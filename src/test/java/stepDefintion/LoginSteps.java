package stepDefintion;

import org.testng.Assert;


import driverFactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

	LoginPage page=new LoginPage(DriverManager.getDriver());
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    Assert.assertTrue( page.isLoginPageDisplayed() ,"Login page is not displayed "  );
	}
	@Given("User enters the {string} of user")
	public void user_enters_the_of_user(String string) {
	   page.enterUsername(string);
	}
	@Given("User enters the {string} of password")
	public void user_enters_the_of_password(String string) {
	    page.enterPassword(string);
	}
	@When("User clicks the sign-in button")
	public void user_clicks_the_sign_in_button() {
	   page.clickLogin();
	}
	@Then("User will navigate to the dashboard with {string}")
	public void user_will_navigate_to_the_dashboard_with(String string) {
	   Assert.assertTrue(page.IsDashboardDisplayed(), "Login failed");
	}
}
