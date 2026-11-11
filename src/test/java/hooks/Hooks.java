package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.driverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

 
public class Hooks {
	 private WebDriver driver;
	 @Before
	    public void setUp() {

	        String browser = ConfigReader.getValue("browser");

	        driverFactory.initializeBrowser(browser);

	        driverFactory.getDriver().get(ConfigReader.getValue("qaurl"));
	    }

   
	    @After
		public void tearDown(Scenario scenario) {

			 driver = driverFactory.getDriver();

			try {
				if (scenario.isFailed() && driver != null) {

					// Capture screenshot
					byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

//	    				Attach the screenshot to html reprt
					scenario.attach(screenshot, "image/png", "Failure Screenshot");

		
				}

			} catch (Exception e) {
				System.err.println("Failed to capture or attach screenshot: " + e.getMessage());
			} finally {
				// Always quit driver after attaching screenshot
				driverFactory.quitDriver();
			}
		}
}
