package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverFactory.DriverFactory;
import driverFactory.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.AttachmentOptions;

import java.io.ByteArrayInputStream;

public class Hooks {

	@Before
	public void setUp() {

		DriverManager.setDriver(DriverFactory.createDriver());

	}

	@After
	public void tearDown(Scenario scenario) {

		AppiumDriver driver = DriverManager.getDriver();

		try {
			if (scenario.isFailed() && driver != null) {

				// Capture screenshot
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				
//				Attach the screenshot to html reprt
				scenario.attach(screenshot, "image/png", "Failure Screenshot");

//				
			}

		} catch (Exception e) {
			System.err.println("Failed to capture or attach screenshot: " + e.getMessage());
		} finally {
			// Always quit driver after attaching screenshot
			DriverManager.quitDriver();
		}
	}
}
