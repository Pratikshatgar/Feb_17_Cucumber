package org.AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver ;
	
	//Webelements
	
	@FindBy(css="input[type='email']")
	private WebElement userNameField;
	
	@FindBy(css="i[role='img']")
	private WebElement logoImage;
	
	@FindBy(css="input[class='a-button-input']")
	private WebElement continueBtn ;
	
	@FindBy(css="input[type='password']")
	private WebElement passwordField;
	
	@FindBy(css="input[type='checkbox']")
	private WebElement keepMeSignInBtn;
	
	@FindBy(id="auth-fpp-link-bottom")
	private WebElement forgotPasswordBtn;
	
	@FindBy(id="signInSubmit")
	private WebElement signInBtn;
	
//	@FindBy(css="input[type='submit']")
//	private WebElement signInBtn;
	
	@FindBy(css="a[role='button']")
	private WebElement AllBtn;
	
	 //Constructor
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	//	PageFactory.initElements(driver,LoginPage.class);
	}
	
	// Action Methods
	
	public Boolean verifyuserNameFieldIsPresent() {
		return userNameField.isDisplayed();
	}
	
	public Boolean verifycontinueBtnIsPresent() {
		return continueBtn.isEnabled();
	}
	
	public Boolean verifypasswordFieldIsPresent() {
		return passwordField.isDisplayed();
	}
	
	public Boolean verifyforgotPasswordBtnIsPresent() {
		return forgotPasswordBtn.isDisplayed();
	}
	public Boolean verifykeepMeSignInBtnIsPresent() {
		return keepMeSignInBtn.isDisplayed();
	}
	
	public Boolean verifylogoIsPresent() {
		return logoImage.isDisplayed();
	}
	public Boolean verifysignInBtnIsPresent() {
		return signInBtn.isDisplayed();
	}
	
	
	public void enterUserName(String uName1) {
		userNameField.sendKeys(uName1);
	}
	public void clickOnContinueBtn() {
		continueBtn.click();
	}
	public void enterPassword(String pwd1) {
		passwordField.sendKeys(pwd1);
	}
	public void clickOnSignIn() {
		signInBtn.click();
	}
	
	public boolean verifyAllBtnIsPresent() {
		return AllBtn.isDisplayed();
	}
	
/*	public void doLogin() {
		enterUserName();
		 clickOnContinueBtn();
		 enterPassword();
		 clickOnSignIn();
		 
	}*/
}
