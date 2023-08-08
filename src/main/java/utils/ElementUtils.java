package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//WAIT FOR AN ELEMENT TO BE VISIBLE AND THEN CLICK ON IT
	public void clickOnElement(WebElement element,long durationInSeconds) {
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		//WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		
	}
	
	//WAIT FOR THE TEXTFIELD TO BE VISIBLE AND CLEAR FIELD, THEN TYPE TEXT INTO IT
	public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		//WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		
	}
	
	//WAIT FOR THE ELEMENT TO BE CLICKABLE
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement =  wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
	}
	
	public void acceptAlert(long durationInSeconds) {
		
		Alert alert = waitforAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds) {
		
		Alert alert = waitforAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitforAlert(long durationInSeconds) {
		
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
		return alert;
		
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds){
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		//WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		WebElement WebElement = waitForVisibilityOfElement(element,durationInSeconds);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(WebElement).click().build().perform();
	}
	
	//WAIT FOR THE ELEMENT TO BE VISIBLE
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
		
		WebElement WebElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return WebElement;
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguements[0].click()", webElement);
		
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String textToBeTyped) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguements[0].value='"+textToBeTyped+"'", webElement);
		
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {
		
		try {
			WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
			return webElement.isDisplayed();
		}catch(Throwable e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
}
