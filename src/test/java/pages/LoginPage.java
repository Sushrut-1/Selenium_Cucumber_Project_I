package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
    WebDriver driver;
    
    // 2. Constructor 
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 1. Locators 
    By usernameInput = By.id("Email"); 
    By passwordInput = By.id("Password");
    By loginButton = By.xpath("//input[@value=\"Log in\"]");
    By errorMessage = By.xpath("//div[@class=\"validation-summary-errors\"]//span");
    By errorMessage2=By.xpath("//div[@class=\"validation-summary-errors\"]//ul//li");
    By loggedInEmail = By.className("account");


    // 3. Actions / Methods
    public void enterUsername(String username) {
    	driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
    	driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    public String getErrorMessage() {
        String firstError = driver.findElement(errorMessage).getText();
        String secondError = driver.findElement(errorMessage2).getText();
        
      
        return firstError + " " + secondError; 
    }
    
    public String getLoggedInEmailText() {
        return driver.findElement(loggedInEmail).getText();
    }
}