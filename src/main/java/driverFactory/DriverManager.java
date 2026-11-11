package driverFactory;

import io.appium.java_client.AppiumDriver;

public class DriverManager {

	  private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

	    // Store driver
	    public static void setDriver(AppiumDriver appiumDriver) {
	        driver.set(appiumDriver);
	    }

	    // Get driver
	    public static AppiumDriver getDriver() {
	        return driver.get();
	    }

	    // Quit driver
	    public static void quitDriver() {

	        if (driver.get() != null) {

	            driver.get().quit();

	            driver.remove();
	        }
	    }
}
