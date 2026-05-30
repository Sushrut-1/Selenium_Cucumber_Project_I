package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class RegisterPage {

    WebDriver driver;

    // Constructor
    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By pageTitle = By.xpath("//div[@class='page-title']//h1[text()='Register']");

    By registerLabels = By.xpath("//div[@class='form-fields']//label");

    By radioButtons = By.xpath("//div[@class='gender']//label");

    By firstName = By.id("FirstName");

    By lastName = By.id("LastName");

    By email = By.id("Email");

    By password = By.id("Password");

    By confirmPassword = By.id("ConfirmPassword");

    By registerButton = By.id("register-button");
    
    By sucessregistermsg= By.xpath("//div[@class=\"result\"]");


    // Faker Object
    Faker faker = new Faker();

    // Generate Test Data
    String generatedFirstName = faker.name().firstName();

    String generatedLastName = faker.name().lastName();

    String generatedEmail = faker.internet().emailAddress();

    String generatedPassword = "Ssp@231";


    // Launch Page
    public void launchPage() {

        driver.get("https://demowebshop.tricentis.com/register");
    }


    // Verify Page Title
    public void verifyPageTitle() {

        boolean status = driver.findElement(pageTitle).isDisplayed();

        Assert.assertTrue(status);

        System.out.println("Register Page Title Verified");
    }


    // Verify Labels
    public void verifyLabels() {

        List<WebElement> labels = driver.findElements(registerLabels);

        for(WebElement ele : labels) {

            System.out.println(ele.getText());
        }
    }


    // Select Male Radio Button
    public void selectMaleRadioButton() {

        List<WebElement> radios = driver.findElements(radioButtons);

        for(WebElement radio : radios) {

            String text = radio.getText();

            if(text.equals("Male")) {

                radio.click();

                break;
            }
        }
    }


    // Enter User Details
    public void enterUserDetails() {

        driver.findElement(firstName).sendKeys(generatedFirstName);

        driver.findElement(lastName).sendKeys(generatedLastName);

        driver.findElement(email).sendKeys(generatedEmail);

        driver.findElement(password).sendKeys(generatedPassword);

        driver.findElement(confirmPassword).sendKeys(generatedPassword);

        System.out.println("Generated Test Data");

        System.out.println("First Name : " + generatedFirstName);

        System.out.println("Last Name : " + generatedLastName);

        System.out.println("Email : " + generatedEmail);

        System.out.println("Password : " + generatedPassword);
    }


    // Click Register Button
    public void clickRegisterButton() {

        driver.findElement(registerButton).click();
    }
    
   
    public String getsuccessmsg()
    {
    	String sccmsg= driver.findElement(sucessregistermsg).getText().trim();
    	return sccmsg;
    }
}

