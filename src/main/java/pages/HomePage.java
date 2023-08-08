package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	//Page Objects
	
	@FindBy(xpath="//p[normalize-space()='Dashboard']")
	private WebElement dashboardTextDisplays;
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement customersMenu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	private WebElement customersMenuItem;
	
	
	
	
	
	
	
	
	//Methods for the Page Objects
	
	public boolean verifyDashboardTextDisplays() {
		//return dashboardTextDisplays.isDisplayed();
		return elementUtils.displayStatusOfElement(dashboardTextDisplays, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnCustomersMenu() {
		//customersMenu.click();
		elementUtils.clickOnElement(customersMenu, 30);
	}
	
	public CustomersPage clickOnCustomersMenuItem() {
		customersMenuItem.click();
		return new CustomersPage(driver);
	}
	
	
	
	
	
	
}
