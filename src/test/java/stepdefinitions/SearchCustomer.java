package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.CustomersPage;

public class SearchCustomer {
	
	WebDriver driver;
	
	private CustomersPage customersPage;
	
	@When("Enter valid customer firstname {string} into the field")
	public void enter_valid_customer_firstname_into_the_field(String validFirstname) {
	   
		driver = DriverFactory.getDriver();
		
		customersPage = new CustomersPage(driver);
		
		customersPage.enterFirstNameSearchField(validFirstname);
		//driver.findElement(By.xpath("//input[@name='SearchFirstName']")).sendKeys(validFirstname);
	}

	@And("Click on search button")
	public void click_on_search_button() throws InterruptedException {
	    
		customersPage.clickOnSearchBtn();
		//driver.findElement(By.xpath("//button[@class='btn btn-primary btn-search']")).click();
		Thread.sleep(3000);
	}
	
	@When("Enter invalid customer firstname {string} into the field")
	public void enter_invalid_customer_firstname_into_the_field(String invalidFirstname) throws InterruptedException {
	    
		driver = DriverFactory.getDriver();
		customersPage = new CustomersPage(driver);
		
		customersPage.enterFirstNameSearchField(invalidFirstname);
		//driver.findElement(By.xpath("//input[@name='SearchFirstName']")).sendKeys(invalidFirstname);
		Thread.sleep(3000);
	}

	@Then("User should get matching customers in the Search result")
	public void user_should_get_matching_customers_in_the_search_result() {
	  
		Assert.assertTrue(customersPage.verifySearchResultName().contains("Victoria"));
		//Assert.assertTrue(driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText().contains("Victoria"));
	}

	@Then("User should get a message about no data available")
	public void user_should_get_a_message_about_no_data_available() {
	    
		Assert.assertEquals("No data available in table", customersPage.verifyNoSearchRecordMessage());
		//Assert.assertEquals("No data available in table", driver.findElement(By.xpath("//tbody/tr/td[@class='dataTables_empty']")).getText());
	  
	}


	
	
}
