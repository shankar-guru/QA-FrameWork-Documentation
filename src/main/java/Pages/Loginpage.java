package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Elementutils;

public class Loginpage {


	private Elementutils utils;

	private By LoginLogo = By.xpath("//*[@class='login_logo']");
	private By Username = By.id("user-name");
	private By Password = By.id("password");
	private By LoginBtn= By.id("login-button");
	private By Dashboard=By.xpath("//*[@class='header_secondary_containerr']");

	public Loginpage( WebDriver driver) {
			this.utils= new Elementutils(driver);
	}
	public boolean isLoginpageDisplayed() {
		return utils.isDisplayed(LoginLogo);
	}

	public void EnterUsername(String username) {
		utils.sendKeys(Username, username);
	}
		public void EnterPassword(String password) {
			utils.sendKeys(Password, password);
		}
		public void ClickLogin() {
			utils.click(LoginBtn);
		}

		public boolean IsDashboardDisplayed() {
			return utils.isDisplayed(Dashboard);
		}
	}

