package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class RegisterSteps{
	
	WebDriver driver;
	RegisterPage registerpage;
	
	
	@Given("User opens Demo Web Shop Register page")
	public void user_opens_demo_web_shop_register_page() {
	    
		driver = hooks.driver;
		
		registerpage = new RegisterPage(driver);
		
		registerpage.launchPage();
	}

	@When("User selects Male gender")
	public void user_selects_male_gender() {
		registerpage.selectMaleRadioButton();
	}

	@When("User enter validuserdetails")
	public void user_enters_first_name() {
	    registerpage.enterUserDetails();
	}

	@When("User clicks on Register button")
	public void user_clicks_on_register_button() {
	    registerpage.clickRegisterButton();
	}

	@Then("User should register successfully")
	public void user_should_register_successfully() {
	    String msg=registerpage.getsuccessmsg();
	    
	    String expectedscssmsg="Your registration completed";
	    System.out.println("After register sucessfull message is: "+ msg);
	    
	    Assert.assertEquals(expectedscssmsg, msg);
	}

	
}