package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.driverFactory;
import Pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver= driverFactory.getDriver();
Loginpage page=new Loginpage(driver);

	@Given("User is on login page")
	public void user_is_on_login_page() {

	    Assert.assertTrue(page.isLoginpageDisplayed(), "Loginpage is not displayed ");
	}
	@Given("User enters the {string} of user")
	public void user_enters_the_of_user(String string) {
	   page.EnterUsername(string);
	}
	@Given("User enters the {string} of password")
	public void user_enters_the_of_password(String string) {
	   page.EnterPassword(string);
	}
	@When("User clicks the sign-in button")
	public void user_clicks_the_sign_in_button() {
	  page.ClickLogin();
	}
	@Then("User will navigate to the dashboard with {string}")
	public void user_will_navigate_to_the_dashboard_with(String string) {
	   Assert.assertTrue(page.IsDashboardDisplayed(), "User is not navigated to dashboard");
	}
}
