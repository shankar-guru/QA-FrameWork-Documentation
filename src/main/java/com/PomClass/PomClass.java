package com.PomClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class PomClass extends BaseClass {
	public PomClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'login_logo')]")
	public WebElement loginPageTitle;
	
	@FindBy(id="user-name")
	public WebElement usernameField;
	
	@FindBy(xpath="//input[@placeholder=\"Password\"]")
	public WebElement passwordField;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	public WebElement loginSubmitBtn;
	
	@FindBy(xpath="//div[@class='app_logo']")
	public WebElement homePageTitle;
	
	@FindBy(xpath="//div[@class='inventory_item']")
	public List<WebElement> products;
	
	@FindBy(xpath="//h3[@role=\"alert\"]")
	public WebElement errorMsg;

}
