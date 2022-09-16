package stepDefs;

import java.net.MalformedURLException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectClasses.LoginClass;

public class ActivateCoupon {
	
	@Given("user has freshly installed the Payback android application")
	public void user_has_freshly_installed_the_payback_android_application() throws MalformedURLException, InterruptedException {
	   	 //implemented in base class
		
	}
	@When("user open the Payback application")
	public void user_open_the_payback_application() throws Exception {
		try {
		LoginClass login = new LoginClass();
			login.clickLogin();
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	@When("user log in to the application")
	public void user_log_in_to_the_application() throws Exception {
		try {
		LoginClass login = new LoginClass();
		   login.enterCardnum();
		   login.clickNext();
		   login.validateText();
		   login.inputPassword();
		   login.loginBtn();
		}
		catch(Exception ex){
			throw ex;
		}
	}
	@When("user navigates to the coupon center")
	public void user_navigates_to_the_coupon_center() throws Exception {
		try {
		LoginClass login = new LoginClass();
		   login.selectCoupon();
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	@When("user filter the coupon by PartnerName")
	public void user_filter_the_coupon_by_partner_name() {
	    
	}
	@When("user activate the first enabled coupon")
	public void user_activate_the_first_enabled_coupon() {
	    
	}
	@Then("user should be able to activate the coupon")
	public void user_should_be_able_to_activate_the_coupon() {
	    
	}
	
	@Then("an error message should be displayed to the user")
	public void an_error_message_should_be_displayed_to_the_user() throws Exception {
		try {
		LoginClass login = new LoginClass();
		login.errorMessage();
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}