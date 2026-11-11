package DriverFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Constants;

public class driverFactory {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initializeBrowser(String browserName) {

	        WebDriver webDriver;
	        String downloadPath = System.getProperty("user.home") + "\\Downloads";
	        
			switch (browserName.toLowerCase()) {

			case "chrome":

				WebDriverManager.chromedriver().setup();

				ChromeOptions options = new ChromeOptions();

				Map<String, Object> preferences = new HashMap<>();
				preferences.put("download.default_directory", downloadPath);
				preferences.put("download.prompt_for_download", false);
				preferences.put("download.directory_upgrade", true);
				preferences.put("safebrowsing.enabled", true);

				options.setExperimentalOption("prefs", preferences);

				webDriver = new ChromeDriver(options);
				break;

			case "firefox":

				WebDriverManager.firefoxdriver().setup();

				FirefoxOptions firefoxOptions = new FirefoxOptions();

				firefoxOptions.addPreference("browser.download.folderList", 2);
				firefoxOptions.addPreference("browser.download.dir", downloadPath);
				firefoxOptions.addPreference("browser.download.useDownloadDir", true);
				firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
						"application/pdf,application/octet-stream,text/csv,application/zip");

				webDriver = new FirefoxDriver(firefoxOptions);
				break;

			case "edge":

				WebDriverManager.edgedriver().setup();

				EdgeOptions edgeOptions = new EdgeOptions();

				Map<String, Object> edgePreferences = new HashMap<>();
				edgePreferences.put("download.default_directory", downloadPath);
				edgePreferences.put("download.prompt_for_download", false);
				edgePreferences.put("download.directory_upgrade", true);
				edgePreferences.put("safebrowsing.enabled", true);

				edgeOptions.setExperimentalOption("prefs", edgePreferences);

				webDriver = new EdgeDriver(edgeOptions);
				break;

			default:
				throw new IllegalArgumentException("Unsupported browser: " + browserName);
			}
	        driver.set(webDriver);

	        webDriver.manage().timeouts().pageLoadTimeout(
	            Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));

	        webDriver.manage().timeouts().scriptTimeout(
	            Duration.ofSeconds( Constants.SCRIPT_TIMEOUT));

	        webDriver.manage().window().maximize();
	        return webDriver;
	}



	public static WebDriver getDriver() {

		WebDriver webDriver = driver.get();

		if (webDriver == null) {
			throw new IllegalStateException("WebDriver is not initialized for this thread");
		}
		return webDriver;

	}

	public static void quitDriver() {

		WebDriver webDriver = driver.get();

		try {
			if (webDriver != null) {
				webDriver.quit();
			}
		} finally {
			driver.remove();
		}
	}
}
