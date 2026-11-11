package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.SupportsRotation;

public class ElementUtils {

	private AppiumDriver driver;
	private WebDriverWait wait;

	// Constructor
	public ElementUtils(AppiumDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantUtils.EXPLICIT_WAIT));
	}

	// Wait until element is clickable
	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait until element is present in DOM
	public WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait until element becomes invisible
	public boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// Wait until element contains expected text
	public boolean waitForText(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	// Wait for element visibility
	public WebElement waitForElement(By locator) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Click element
	public void click(By locator) {

		waitForClickable(locator).click();
	}

	// Enter text
	public void sendKeys(By locator, String text) {

		WebElement element = waitForElement(locator);

		element.clear();
		element.sendKeys(text);
	}

	// Get element text
	public String getText(By locator) {

		return waitForElement(locator).getText();
	}

	// Check element displayed
	public boolean isDisplayed(By locator) {

		try {

			return waitForElement(locator).isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	// Check element enabled
	public boolean isEnabled(By locator) {

		return waitForElement(locator).isEnabled();
	}

	// Clear text field
	public void clear(By locator) {

		waitForElement(locator).clear();
	}

	// Get attribute
	public String getAttribute(By locator, String attribute) {

		return waitForElement(locator).getAttribute(attribute);
	}
	// Get matching element count
	public int getElementCount(By locator) {
	    return driver.findElements(locator).size();
	}

	// Get text from multiple elements
	public List<String> getElementsText(By locator) {
	    return driver.findElements(locator)
	            .stream()
	            .map(WebElement::getText)
	            .collect(Collectors.toList());
	}
	
	// Wait for element to disappear
	public boolean waitForElementToDisappear(By locator) {
	    return waitForInvisibility(locator);
	}

	// Hide keyboard
	public void hideKeyboard() {

		if (driver instanceof AndroidDriver) {
			((AndroidDriver) driver).hideKeyboard();

		} else if (driver instanceof IOSDriver) {
			((IOSDriver) driver).hideKeyboard();
		}
	}

	// Get current page source
	public String getPageSource() {

		return driver.getPageSource();
	}

	// Scroll down
	public void scrollDown() {
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "down");
		params.put("percent", 0.75);

		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
	}

	// Scroll up
	public void scrollUp() {
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "up");
		params.put("percent", 0.75);

		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
	}

	// Scroll to element with visible text using Android UiScrollable
	public void scrollToElement(String visibleText) {

		if (driver instanceof AndroidDriver) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
					+ ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"));
		} else {
			throw new UnsupportedOperationException("This scrolling method is Android-specific");
		}
	}

	// Long press an element
	public void longPress(By locator) {

		WebElement element = waitForElement(locator);

		Map<String, Object> params = new HashMap<>();
		params.put("elementId", ((RemoteWebElement) element).getId());
		params.put("duration", 2000);

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", params);
	}

	// Swipe on screen
	public void swipe(String direction) {

		Map<String, Object> params = new HashMap<>();

		params.put("direction", direction);
		params.put("percent", 0.75);

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", params);
	}

	// Tap element
	public void tap(By locator) {

		WebElement element = waitForElement(locator);

		Map<String, Object> params = new HashMap<>();
		params.put("elementId", ((RemoteWebElement) element).getId());

		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", params);
	}

	// Select checkbox if not selected
	public void selectCheckbox(By locator) {

		WebElement element = waitForClickable(locator);

		if (!element.isSelected()) {
			element.click();
		}
	}

	// Deselect checkbox if selected
	public void deselectCheckbox(By locator) {

		WebElement element = waitForClickable(locator);

		if (element.isSelected()) {
			element.click();
		}
	}

	// Android device back button
	public void pressBack() {

		if (driver instanceof AndroidDriver) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		} else {
			throw new UnsupportedOperationException("This back-button method is Android-specific");
		}
	}

	// Open Android notification panel
	public void openNotifications() {

		if (driver instanceof AndroidDriver) {

			((AndroidDriver) driver).openNotifications();

		} else {
			throw new UnsupportedOperationException("Open notifications is supported only on Android");
		}
	}

	// Press Android Home button
	public void pressHome() {

		if (driver instanceof AndroidDriver) {

			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));

		} else {
			throw new UnsupportedOperationException("Press Home is supported only on Android");
		}
	}

	// Push file to Android device
	public void pushFileToAndroid(String devicePath, String localFilePath) throws IOException {

		if (driver instanceof AndroidDriver) {

			File file = new File(localFilePath);

			((AndroidDriver) driver).pushFile(devicePath, file);

		} else {
			throw new UnsupportedOperationException("This method is supported only on Android");
		}
	}

	// Download file from Android device to local system
	public void pullFileFromAndroid(String devicePath, String localPath) {

		if (driver instanceof AndroidDriver) {

			byte[] fileData = ((AndroidDriver) driver).pullFile(devicePath);

			try {
				Files.write(Paths.get(localPath), fileData);
			} catch (IOException e) {
				throw new RuntimeException("Failed to download file from Android", e);
			}

		} else {
			throw new UnsupportedOperationException("This method is supported only on Android");
		}
	}

//	Verify the file downloaded on Android 
	public boolean verifyAndroidFileDownloaded(String devicePath) {

		if (!(driver instanceof AndroidDriver)) {
			throw new UnsupportedOperationException("Android only");
		}

		try {
			((AndroidDriver) driver).pullFile(devicePath);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Push file to iOS device
	public void pushFileToIOS(String devicePath, String localFilePath) throws IOException {

		if (driver instanceof IOSDriver) {

			File file = new File(localFilePath);

			((IOSDriver) driver).pushFile(devicePath, file);

		} else {
			throw new UnsupportedOperationException("This method is supported only on iOS");
		}
	}
//    Capture and save the screenhot

	public String takeScreenshot(String screenshotName) {

		String timeStamp = new SimpleDateFormat(ConstantUtils.SCREENSHOT_FORMAT).format(new Date());

		String directory = System.getProperty("user.dir") + ConstantUtils.SCREENSHOT_PATH;

		File folder = new File(directory);

		if (!folder.exists()) {
			folder.mkdirs();
		}

		String filePath = directory + screenshotName + "_" + timeStamp + ConstantUtils.SCREENSHOT_EXTENSION;

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File(filePath);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			throw new RuntimeException("Failed to save screenshot", e);
		}

		return filePath;
	}
	public void rotateToLandscape() {
	    ((SupportsRotation) driver).rotate(ScreenOrientation.LANDSCAPE);
	}

	public void rotateToPortrait() {
	    ((SupportsRotation) driver).rotate(ScreenOrientation.PORTRAIT);
	}

	public ScreenOrientation getDeviceOrientation() {
	    return ((SupportsRotation) driver).getOrientation();
	}
}
