package driverFactory;

import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utilities.ConfigReader;

public class DriverFactory {

	 public static AppiumDriver createDriver() {

	        String platform = ConfigReader.getProperty("platformName");
	        String serverURL = ConfigReader.getProperty("appiumServerUrl");

	        try {
	            URL url = new URL(serverURL);
	            AppiumDriver driver;

	            // Android
	            if (platform.equalsIgnoreCase("Android")) {

	                UiAutomator2Options options = new UiAutomator2Options();

	                options.setDeviceName(ConfigReader.getProperty("deviceName"));
	                options.setUdid(ConfigReader.getProperty("udid"));
	                options.setAutomationName(
	                    ConfigReader.getProperty("automationName", "UiAutomator2")
	                );

	                String appPath = ConfigReader.getProperty("appPath", "");

	                if (!appPath.isBlank()) {
	                    options.setApp(appPath);
	                }

	                options.setAppPackage(ConfigReader.getProperty("appPackage"));
	                options.setAppActivity(ConfigReader.getProperty("appActivity"));
	                options.setNoReset(ConfigReader.getBooleanProperty("noReset"));

	                driver = new AndroidDriver(url, options);
	            }

	            // iOS
	            else if (platform.equalsIgnoreCase("iOS")) {

	                XCUITestOptions options = new XCUITestOptions();

	                options.setDeviceName(ConfigReader.getProperty("deviceName"));
	                options.setAutomationName("XCUITest");
	                options.setNoReset(ConfigReader.getBooleanProperty("noReset"));

	                String udid = ConfigReader.getProperty("udid", "");
	                if (!udid.isBlank()) {
	                    options.setUdid(udid);
	                }

	                String appPath = ConfigReader.getProperty("appPath", "");
	                if (!appPath.isBlank()) {
	                    options.setApp(appPath);
	                }

	                String bundleId = ConfigReader.getProperty("bundleId", "");
	                if (!bundleId.isBlank()) {
	                    options.setBundleId(bundleId);
	                }

	                driver = new IOSDriver(url, options);
	            }

	            else {
	                throw new IllegalArgumentException("Invalid platform: " + platform);
	            }

	            driver.manage().timeouts().implicitlyWait(Duration.ZERO);

	            return driver;

	        } catch (Exception e) {
	            throw new RuntimeException(
	                "Appium driver initialization failed", e
	            );
	        }
	    }
}
