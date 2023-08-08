package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class CustomersPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public CustomersPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Add new']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//h1[@class='float-left']")
	private WebElement addNewCustomerPage;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@id='Company']")
	private WebElement companyNameField;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	private WebElement adminCommentField;
	
	@FindBy(xpath="//button[@name='save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	private WebElement addCustomerSuccessMessage;
	
	@FindBy(xpath="//div[@class='validation-summary-errors']")
	private WebElement emailWarningMessage;
	
	
	
	//Search Customer ORs
	@FindBy(xpath="//input[@name='SearchFirstName']")
	private WebElement firstNameSearchField;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//tbody/tr[1]/td[3]")
	private WebElement searchResultName;
	
	@FindBy(xpath="//tbody/tr/td[@class='dataTables_empty']")
	private WebElement noSearchRecordMessage;
		
	
	
	
	
	
	
	
	
	public void clickOnAddNewBtn() {
		addNewBtn.click();
	}
	
	public String verifyAddNewCustomerPage() {
		return addNewCustomerPage.getText();
	}
	
	public void enterEmailText(String emailText) {
		//emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField, emailText, 30);
	}
	
	public void enterPasswordText(String passwordText) {
		//passwordField.sendKeys(passwordText);
		elementUtils.typeTextIntoElement(passwordField, passwordText, 30);
	}
	
	public void enterFirstNameText(String firstNameText) {		
		firstNameField.sendKeys(firstNameText);
	}	
	
	public void enterLastNameText(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterCompanyName(String companyNameText) {
		companyNameField.sendKeys(companyNameText);
	}
	
	public void enterAdminComment(String adminCommentText) {
		adminCommentField.sendKeys(adminCommentText);
	}
	
	public void clickOnSaveBtn() {
		saveButton.click();
	}
	
	public String verifyAddCustomerSuccessMessage() {
		return addCustomerSuccessMessage.getText();
	}
	
	public String verifyEmailWarningMessage() {
		//return emailWarningMessage.getText();
		//return elementUtils.getTextFromElement(emailWarningMessage, 30);
		return elementUtils.getTextFromElement(emailWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	
	
	//Search Customer Methods
	public void enterFirstNameSearchField(String firstNameSearch) {
		//firstNameSearchField.sendKeys(firstNameSearch);
		elementUtils.typeTextIntoElement(firstNameSearchField, firstNameSearch, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();		
	}
	
	public String verifySearchResultName() {
		//return searchResultName.getText();
		return elementUtils.getTextFromElement(searchResultName, 30);
	}
	
	public String verifyNoSearchRecordMessage() {
		return noSearchRecordMessage.getText();
	}
	
	
	
	
}
