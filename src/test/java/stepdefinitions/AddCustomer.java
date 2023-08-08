package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.CustomersPage;
import pages.HomePage;
import utils.CommonUtils;

public class AddCustomer {
	
	WebDriver driver;
	private HomePage homePage;
	private CustomersPage customersPage;
	private CommonUtils commonUtils;
	

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
	  
		driver = DriverFactory.getDriver();
		
		homePage = new HomePage(driver);		
		
		homePage.clickOnCustomersMenu();
		//driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Customers')]")).click();
		
	}
	
	@And("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	    
		customersPage = homePage.clickOnCustomersMenuItem();
		//driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
	}
	
	@And("click on Add new button")
	public void click_on_add_new_button() {
	    
		customersPage = new CustomersPage(driver);
		customersPage.clickOnAddNewBtn();
		//driver.findElement(By.xpath("//a[normalize-space()='Add new']")).click();
	}
	
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    
		Assert.assertTrue(customersPage.verifyAddNewCustomerPage().contains("Add a new customer"));
		//Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='float-left']")).getText().contains("Add a new customer"));
	}
	
	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	    
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		
		commonUtils = new CommonUtils();
		customersPage.enterEmailText(commonUtils.getEmailWithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(getEmailWithTimeStamp());
		customersPage.enterPasswordText(datamap.get("password"));
		//driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(datamap.get("password"));
		customersPage.enterFirstNameText(datamap.get("firstName"));
		//driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(datamap.get("firstName"));
		customersPage.enterLastNameText(datamap.get("lastName"));
		//driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(datamap.get("lastName"));
		customersPage.enterCompanyName(datamap.get("companyName"));
		//driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(datamap.get("companyName"));
		customersPage.enterAdminComment(datamap.get("adminComment"));
		//driver.findElement(By.xpath("//textarea[@id='AdminComment']")).sendKeys(datamap.get("adminComment"));
		
	}
	
	@When("User enters existing customer details into below fields")
	public void user_enters_existing_customer_details_into_below_fields(DataTable dataTable) {
	    
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		
		customersPage.enterEmailText(datamap.get("email"));
		customersPage.enterPasswordText(datamap.get("password"));
		customersPage.enterFirstNameText(datamap.get("firstName"));
		customersPage.enterLastNameText(datamap.get("lastName"));
		customersPage.enterCompanyName(datamap.get("companyName"));
		customersPage.enterAdminComment(datamap.get("adminComment"));
		/*driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(datamap.get("email"));
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(datamap.get("password"));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(datamap.get("firstName"));
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(datamap.get("lastName"));
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(datamap.get("companyName"));
		driver.findElement(By.xpath("//textarea[@id='AdminComment']")).sendKeys(datamap.get("adminComment"));
		*/
	}
	
	@And("click on Save button")
	public void click_on_save_button() throws InterruptedException {
	   
		customersPage.clickOnSaveBtn();
		//driver.findElement(By.xpath("//button[@name='save']")).click();
		Thread.sleep(3000);
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
	    
		Assert.assertTrue(customersPage.verifyAddCustomerSuccessMessage().contains("The new customer has been added successfully."));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText()
		//		.contains("The new customer has been added successfully."));
	}
	
	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	   
		Assert.assertTrue(customersPage.verifyEmailWarningMessage().contains("Email is already registered"));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).getText()
		//		.contains("Email is already registered"));
	}
	
	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	   
	}
	
	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	    
		Assert.assertTrue(customersPage.verifyEmailWarningMessage().contains("'Email' must not be empty."));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).getText()
		//		.contains("'Email' must not be empty."));
	}

/*
public String getEmailWithTimeStamp() {
		
		Date date = new Date();
		return "demo"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
	}*/
	
	
}
