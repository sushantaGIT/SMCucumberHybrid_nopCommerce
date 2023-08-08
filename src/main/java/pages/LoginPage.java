package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	//Create a Constructer (constructer name should be same as class name "LoginPage")
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
				
	}
	//Object Repository
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement loginEmailField;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement loginPasswordField;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
	private WebElement warningMessage;
	
	@FindBy(xpath="//span[@id='Email-error']")
	private WebElement warningMessageForBlankInput;
	
	
	
	
	//Methods for the Object Repositories
	public void clearLoginEmailField() {
		loginEmailField.clear();
		}
	
	public void enterLoginEmail(String emailText) {
		loginEmailField.sendKeys(emailText);
	}
	
	public void clearLoginPasswordField() {
		loginPasswordField.clear();
		}
	
	public void enterLoginPassword(String passwordText) {
		loginPasswordField.sendKeys(passwordText);
	}
	
	public void clickOnLoginButton() {
		//loginButton.click();
		elementUtils.clickOnElement(loginButton, 30);
	}
	
	public String getWarningMessageText() {
		//return warningMessage.getText();
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getWarningMessageTextForBlankInput() {
		return warningMessageForBlankInput.getText();
	}
	
	
	
}
