package com.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.BaseClass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {
	
	@After
	public void takeScreenshot(Scenario scenario) {
		if(scenario.isFailed()&&driver!=null) {
			byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed screenshot");
			System.out.println("Screenshot captured for: "+ scenario.getName());
		}
	}

}
