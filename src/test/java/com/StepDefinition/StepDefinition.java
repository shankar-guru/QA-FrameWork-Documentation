package com.StepDefinition;

import com.BaseClass.BaseClass;
import com.PomClass.PomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinition extends BaseClass{
	PomClass p=new PomClass(driver);
	
	@Given("User is on the Saucedemo login page")
	public void user_is_on_the_saucedemo_login_page() {
	    Assert.assertTrue(isDisplayed(p.loginPageTitle));
	    Assert.assertTrue(getCurrentURL().contains("saucedemo.com"));
	}

	@When("User enters the username {string}")
	public void user_enters_the_username(String name) {
		clearText(p.usernameField);
	    Assert.assertTrue(isDisplayed(p.usernameField));
	    sendKeys(p.usernameField, name);
	}

	@When("User enters the password {string}")
	public void user_enters_the_password(String pwd) {
		clearText(p.passwordField);
		Assert.assertTrue(isDisplayed(p.passwordField));
	    sendKeys(p.passwordField, pwd);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		Assert.assertTrue(isDisplayed(p.loginSubmitBtn));
	    click(p.loginSubmitBtn);
	}

	@Then("User should be navigated to the home page {string}")
	public void user_should_be_navigated_to_the_home_page(String result) {
		switch (result) {
		case "invalid":
			Assert.assertTrue(isDisplayed(p.errorMsg));
			System.out.println("Validation msg for incorrect credentials: "+getText(p.errorMsg));
			break;

		case "valid":
			 Assert.assertTrue(getCurrentURL().contains("inventory"));
			 Assert.assertTrue(isDisplayed(p.homePageTitle));
			 Assert.assertFalse(p.products.isEmpty());
			 System.out.println("User is navigated to home page successfully");
			break;
		}
	}

}
