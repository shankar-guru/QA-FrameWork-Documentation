package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.ElementUtils;

public class LoginPage {
	
	private By LoginDisp=AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
	private By Username = AppiumBy.accessibilityId("test-Username");
	private By Password = AppiumBy.accessibilityId("test-Password");
	private By LoginBtn	=	AppiumBy.accessibilityId("test-LOGIN");
	private By DashDisp =AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)");

	private ElementUtils utils;
	
	public LoginPage(AppiumDriver driver) {
		this.utils =new ElementUtils(driver);
	}
	
	public boolean isLoginPageDisplayed() {
		return utils.isDisplayed(LoginDisp);
	}
	
	public void enterUsername(String string) {
		utils.sendKeys(Username, string);
	}
	
	public void enterPassword(String string) {
		utils.sendKeys(Password, string);
	}
	
	public void clickLogin() {
		utils.click(LoginBtn);
	}
	
	public boolean IsDashboardDisplayed() {
		return utils.isDisplayed(DashDisp);
	}
}
