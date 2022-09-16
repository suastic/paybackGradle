package pageObjectClasses;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseClass;
import junit.framework.Assert;

public class LoginClass extends BaseClass{

	String profilePassword = "Payback@1";
	String passwordScreenMessage = "Zur Sicherheit erneut das Passwort für die Kundennummer 4044739874 eingeben";
	
	public LoginClass() throws MalformedURLException{
		driver = getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(@resource-id, 'welcome_loginbutton')]" )
	private WebElement login;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@resource-id, 'txtInputLoginCheckCardNumber')]" )
	private WebElement cardNum;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@resource-id, 'progressbutton_btn')]" )
	private WebElement next;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@resource-id, 'login_customernumber')]" )
	private WebElement passwordScreenText;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@resource-id, 'login_password_field')]" )
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@resource-id, 'progressbutton_btn')]" )
	private WebElement submit;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@resource-id, 'snackbar_text')]" )
	private WebElement validationText;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@resource-id, 'coupon')]" )
	private WebElement coupon;
	
	public Boolean isLoginDisplayed() {
		if(login.isEnabled()) {
		return true;	
		}
		else {
		return false;
		}
	}
	public void clickLogin() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(login));  
		login.click();
		//Thread.sleep(3000);
	}
	
	@SuppressWarnings("deprecation")
	public void enterCardnum() throws InterruptedException {
		
		Thread.sleep(3000);
		cardNum.click();
		//using driver keyboard functions to insert text
		driver.getKeyboard().pressKey("4");
		driver.getKeyboard().pressKey("0");
		driver.getKeyboard().pressKey("4");
		driver.getKeyboard().pressKey("4");
		driver.getKeyboard().pressKey("7");
		driver.getKeyboard().pressKey("3");
		driver.getKeyboard().pressKey("9");
		driver.getKeyboard().pressKey("8");
		driver.getKeyboard().pressKey("7");
		driver.getKeyboard().pressKey("4");
		driver.hideKeyboard();
		
	}
	
	public void clickNext() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(next)); 
		next.click();
		
	}
	@SuppressWarnings("deprecation")
	public void validateText() throws InterruptedException {
		
		Thread.sleep(2000);
		String actualText = passwordScreenText.getText();
		
		Assert.assertEquals(passwordScreenMessage, actualText);
		
	}
	
	public void inputPassword() throws InterruptedException {
		
		password.click();
		password.sendKeys(profilePassword);
	}
	
	public void loginBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		Thread.sleep(500);
	}
	
	
	public void selectCoupon(){
		coupon.click();
	}
	@SuppressWarnings("deprecation")
	public void errorMessage() {
		String message = validationText.getText();
		Assert.assertEquals("Wir können den PAYBACK Server gerade nicht erreichen. \r\n"
				+ "Mach dir gerne einen Tee, während wir das Problem beheben", message);
	}
}
