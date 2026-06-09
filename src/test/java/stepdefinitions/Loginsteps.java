package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import hooks.hooks;
import org.testng.Assert;

public class Loginsteps {
	
	WebDriver driver;
    LoginPage loginPage;
    

	@Given("User opens Demo Web Shop application")
	public void user_opens_demo_web_shop_application() {
		driver = hooks.getDriver();

        driver.get("https://demowebshop.tricentis.com/login");

        loginPage = new LoginPage(driver);
	}

	@When("User enters email as {string}")
	public void user_enters_email_as(String string) { 
		loginPage.enterUsername(string);
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String string) {
	    loginPage.enterPassword(string);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	   loginPage.clickLogin();
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		String actualEmail = loginPage.getLoggedInEmailText();
	    System.out.println("Logged in user is: " + actualEmail);
	    
	    String expectedEmail = "ssparab@gmail.com"; 
	    Assert.assertEquals(actualEmail, expectedEmail);
	}

	@Then("User should see login error message")
	public void user_should_see_login_error_message() {
	    String errormsg=loginPage.getErrorMessage();
	    System.out.println("Erro message" + errormsg);
	    
	    String expectederrormsg= "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect";
	    Assert.assertEquals(errormsg, expectederrormsg);
	}

	@Then("User should see validation message")
	public void user_should_see_validation_message() {
		String errormsg=loginPage.getErrorMessage();
	    System.out.println("Erro message: " + errormsg);
	    
	    String expectederrormsg= "Login was unsuccessful. Please correct the errors and try again. No customer account found";
	    Assert.assertEquals(errormsg,expectederrormsg );
	}
	
	


}