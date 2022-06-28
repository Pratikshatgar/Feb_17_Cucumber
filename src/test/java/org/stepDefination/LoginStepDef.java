package org.stepDefination;

import org.AmazonPages.LoginPage;
import org.applicationHooks.AppHooks;
import org.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.utilities.BaseUtility;
import org.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDef {

	private WebDriver driver;
	private LoginPage lp;
	
	
	@Given("User is on login Page and it is already resistered")
	public void user_is_on_login_page_and_it_is_already_resistered() {
		/*	String url = "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(url);*/ 

		driver =DriverFactory.getDriver();
		driver.get(AppHooks.prop.getProperty("url"));
		lp = new LoginPage(driver);



	}

	@Then("Username field is displayed")
	public void username_field_is_displayed() {
		Assert.assertTrue(lp.verifyuserNameFieldIsPresent());
	}

	@Then("Continue button is displayed")
	public void continue_button_is_displayed() {
		Assert.assertTrue(lp.verifycontinueBtnIsPresent());
	}
	@When("user enters Username")
	public void user_enters_username() {
		lp.enterUserName(AppHooks.prop.getProperty("userName"));
	}

	@When("Click on Continue button")
	public void click_on_continue_button() {
		lp.clickOnContinueBtn();
	}


	@Then("Password field is displayed")
	public void password_field_is_displayed() {
		Assert.assertTrue(lp.verifypasswordFieldIsPresent());
	}

	@Then("Sign In button is displayed")
	public void sign_in_button_is_displayed() {
		Assert.assertTrue(lp.verifysignInBtnIsPresent());
	}

	@Then("Keep me signed in checkbox is displayed")
	public void keep_me_signed_in_checkbox_is_displayed() {
		Assert.assertTrue(lp.verifykeepMeSignInBtnIsPresent());
	}

	@Then("ForgotPassword link is displayed")
	public void forgot_password_link_is_displayed() {
		Assert.assertTrue(lp.verifyforgotPasswordBtnIsPresent());
	}

	@Then("Amazon Logo is displayed")
	public void amazon_logo_is_displayed() {
		Assert.assertTrue(lp.verifylogoIsPresent());
	}


	@When("user enters Password")
	public void user_enters_password() {
		lp.enterPassword(AppHooks.prop.getProperty("password"));
	}

	@When("Click on SignIn button")
	public void click_on_sign_in_button() {
		lp.clickOnSignIn();
	}

	@Then("All button is displayed")
	public void all_button_is_displayed() {
		Assert.assertTrue(lp.verifyAllBtnIsPresent());
	}



}
