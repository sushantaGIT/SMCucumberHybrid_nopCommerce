package stepdefinitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private CommonUtils commonUtils;
	

	@Given ("User navigates to login page")
	public void User_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		
		
	}
	
	@When ("^User enters valid email text (.+) into email field$")
	public void User_enters_valid_email_text_address_into_email_field(String emailText) {
		
		loginPage = new LoginPage(driver);
		loginPage.clearLoginEmailField();
		loginPage.enterLoginEmail(emailText);
		//driver.findElement(By.xpath("//input[@id='Email']")).clear();
		//driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailText);
	}
	
	@And("^User enters valid password text (.+) into password field$")
	public void user_enters_valid_password_text_into_password_field(String passwordText) {
		loginPage.clearLoginPasswordField();
	   loginPage.enterLoginPassword(passwordText);
		//driver.findElement(By.xpath("//input[@id='Password']")).clear();
		//driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passwordText);
	}
	
	
	@When ("User enters valid email address {string} into email field")
	public void User_enters_valid_email_address_into_email_field(String emailText) {
		
		loginPage = new LoginPage(driver);
		loginPage.clearLoginEmailField();
		loginPage.enterLoginEmail(emailText);
		//driver.findElement(By.xpath("//input[@id='Email']")).clear();
		//driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailText);
	}
	
	@And("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		loginPage.clearLoginPasswordField();
	   loginPage.enterLoginPassword(passwordText);
		//driver.findElement(By.xpath("//input[@id='Password']")).clear();
		//driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passwordText);
	}
	
	
	
	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
	   
		loginPage.clickOnLoginButton();
		//driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	   
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyDashboardTextDisplays());
		//Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Dashboard']")).isDisplayed());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		commonUtils = new CommonUtils();
		
		loginPage = new LoginPage(driver);
		loginPage.clearLoginEmailField();
		loginPage.enterLoginEmail(commonUtils.getEmailWithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='Email']")).clear();
		//driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(getEmailWithTimeStamp());
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String InvalidPasswordText) {
	    
		loginPage.clearLoginPasswordField();
		loginPage.enterLoginPassword(InvalidPasswordText);
		//driver.findElement(By.xpath("//input[@id='Password']")).clear();
		//driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(InvalidPasswordText);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	  
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Login was unsuccessful. Please correct the errors and try again."));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText()
		//		.contains("Login was unsuccessful. Please correct the errors and try again."));
		
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
	   
		loginPage = new LoginPage(driver);
		loginPage.clearLoginEmailField();
		loginPage.enterLoginEmail("");
		//driver.findElement(By.xpath("//input[@id='Email']")).clear();
	}

	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	   
		loginPage.clearLoginPasswordField();
		loginPage.enterLoginPassword("");
		//driver.findElement(By.xpath("//input[@id='Password']")).clear();
	}
	
	@Then("User should get a proper warning message about blank input")
	public void user_should_get_a_proper_warning_message_about_blank_input() {
	    
		Assert.assertEquals("Please enter your email", loginPage.getWarningMessageTextForBlankInput());
		//Assert.assertEquals("Please enter your email", driver.findElement(By.xpath("//span[@id='Email-error']")).getText());
	}
	
	

	
}
