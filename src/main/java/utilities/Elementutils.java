package utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elementutils {

	private WebDriver driver;
	private WebDriverWait wait;

	public Elementutils(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
	}

////////////////////////////Wait////////////////////////
// Wait until element is invisible
	public boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

// Wait until element is clickable
	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

// Wait until element is present
	public WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

// Wait until element contains text
	public boolean waitForText(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

/////////////////////Actions///////////////////////////
//	Element CLick
	public void click(By locator) {

		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

//    SendKeys
	public void sendKeys(By locator, String value) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.clear();
		element.sendKeys(value);
	}

//    Getting the text from element
	public String getText(By locator) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	// Clear input field
	public void clear(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
	}

	// Get attribute value
	public String getAttribute(By locator, String attribute) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attribute);
	}

	// Get CSS property
	public String getCssValue(By locator, String propertyName) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getCssValue(propertyName);
	}

/////////////////Validation/////////////////////////////
//    check if the element is displayed 
	public boolean isDisplayed(By locator) {

		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();

		} catch (TimeoutException e) {
			return false;
		}

	}

	// Check whether element is enabled
	public boolean isEnabled(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
	}

	// Check whether element is selected (checkbox/radio)
	public boolean isSelected(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isSelected();
	}

////////////////Dropdown////////////////////////////////
	
	// Select dropdown by visible text
	public void selectByVisibleText(By locator, String text) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
		select.selectByVisibleText(text);
	}

	// Select dropdown by value
	public void selectByValue(By locator, String value) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
		select.selectByValue(value);
	}

	// Select dropdown by index
	public void selectByIndex(By locator, int index) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
		select.selectByIndex(index);
	}
	
////////////////Windows Handling ////////////////////////////////
	// Get current window handle
	public String getCurrentWindowHandle() {
	    return driver.getWindowHandle();
	}

	// Get all window handles
	public Set<String> getAllWindowHandles() {
	    return driver.getWindowHandles();
	}

	// Switch to a specific window using window handle
	public void switchToWindow(String windowHandle) {
	    driver.switchTo().window(windowHandle);
	}

	// Switch to the newly opened window
	public void switchToNewWindow() {
	    String parentWindow = driver.getWindowHandle();

	    for (String window : driver.getWindowHandles()) {
	        if (!window.equals(parentWindow)) {
	            driver.switchTo().window(window);
	            break;
	        }
	    }
	}

	// Switch back to parent window
	public void switchToParentWindow(String parentWindow) {
	    driver.switchTo().window(parentWindow);
	}

	// Close the current window
	public void closeCurrentWindow() {
	    driver.close();
	}

	// Close all windows and quit browser
	public void closeAllWindows() {
	    driver.quit();
	}

	// Get window count
	public int getWindowCount() {
	    return driver.getWindowHandles().size();
	}

	// Switch to window using title
	public void switchToWindowByTitle(String title) {
	    for (String window : driver.getWindowHandles()) {
	        driver.switchTo().window(window);

	        if (driver.getTitle().equals(title)) {
	            return;
	        }
	    }

	    throw new NoSuchWindowException("Window with title not found: " + title);
	}

	// Maximize current window
	public void maximizeWindow() {
	    driver.manage().window().maximize();
	}

	// Minimize current window
	public void minimizeWindow() {
	    driver.manage().window().minimize();
	}

	// Set window size
	public void setWindowSize(int width, int height) {
	    driver.manage().window().setSize(new Dimension(width, height));
	}

	
////////////////Alert/////////////////////////
	
	// Accept alert
	public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	// Dismiss alert
	public void dismissAlert() {
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	// Get alert text
	public String getAlertText() {
		return wait.until(ExpectedConditions.alertIsPresent()).getText();
	}

	// Enter text into prompt alert
	public void sendKeysToAlert(String value) {
		wait.until(ExpectedConditions.alertIsPresent()).sendKeys(value);
	}

	// Check whether alert is present
	public boolean isAlertPresent() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	
///////////////////Js////////////////////////////
	// Scroll to element
	public void scrollToElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	}

	// Click using JavaScript
	public void jsClick(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	
/////////////////Mouse Actions///////////////////////// 
	
	// Move mouse to element
	public void hover(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		new Actions(driver).moveToElement(element).perform();
	}

	// Double click
	public void doubleClick(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		new Actions(driver).doubleClick(element).perform();
	}

	// Right click
	public void rightClick(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		new Actions(driver).contextClick(element).perform();
	}

	
//////////////checkBox/////////////////////
	
	// Select checkbox only if not already selected
	public void selectCheckbox(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		if (!element.isSelected()) {
			element.click();
		}
	}

	// Deselect checkbox only if selected
	public void deselectCheckbox(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		if (element.isSelected()) {
			element.click();
		}
	}
////////////////////screenshot/////////////////////////////
	// Capture screenshot and save it
	public static String takeScreenshot(WebDriver driver, String screenshotName) {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
		String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timeStamp + ".png";

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
	
////////////////////Upload & Download/////////////////////////////
	// Upload file with visibility wait
	public void uploadFileWithWait(By locator, String filePath) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(filePath);
	}

	// Get downloaded file path
	public String getDownloadedFilePath(String fileName) {
		return System.getProperty("user.home") + "\\Downloads\\" + fileName;
	}

	// Check whether downloaded file exists
	public boolean isFileDownloaded(String fileName) {
		File file = new File(getDownloadedFilePath(fileName));
		return file.exists();
	}

	// Wait until downloaded file exists
	public boolean waitForFileDownload(String fileName, int timeout) {
		WebDriverWait downloadWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		return downloadWait.until(d -> {
			File file = new File(getDownloadedFilePath(fileName));
			File tempFile = new File(getDownloadedFilePath(fileName) + ".crdownload");

			return file.exists() && !tempFile.exists();
		});
	}

	// Get downloaded file size in bytes
	public long getDownloadedFileSize(String fileName) {
		File file = new File(getDownloadedFilePath(fileName));

		if (!file.exists()) {
			throw new RuntimeException("Downloaded file not found: " + fileName);
		}

		return file.length();
	}

	// Delete downloaded file
	public boolean deleteDownloadedFile(String fileName) {
		File file = new File(getDownloadedFilePath(fileName));
		return file.exists() && file.delete();
	}
}