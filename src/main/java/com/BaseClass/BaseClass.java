package com.BaseClass;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class BaseClass {
	
    public static WebDriver driver;
    public static WebDriverWait wait;
    
    public static WebDriver browserLaunch() {
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		initializeWait();
		return driver;
	}
 
    // 1. Initialize WebDriver and Wait
    public static void initializeWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
 
    // 2. Click Element
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
 
    // 3. Enter Text
    public void sendKeys(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(value);
    }
 
    // 4. Clear Text
    public void clearText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
    }
 
    // 5. Clear and Enter Text
    public void clearAndEnterText(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(value);
    }
 
    // 6. Get Text
    public String getText(WebElement element) {
   	 
        wait.until(ExpectedConditions.visibilityOf(element));
     
        return element.getText();
    }
 
    // 7. Get Attribute
    public String getAttribute(WebElement element, String attribute) {
        return wait.until(ExpectedConditions.visibilityOf(element))
                   .getAttribute(attribute);
    }
 
    // 8. Check Element is Displayed
    public boolean isDisplayed(WebElement element) {
   	 
        try {
     
            wait.until(ExpectedConditions.visibilityOf(element));
     
            return element.isDisplayed();
     
        } catch (Exception e) {
     
            return false;
        }
    }
 
    // 9. Check Element is Enabled
    public boolean isEnabled(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }
 
    // 10. Check Element is Selected
    public boolean isSelected(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isSelected();
    }
 
    // 11. Wait for Element Visibility
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
 
    // 12. Wait for Element Clickable
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
 
    // 13. Wait for Element to Disappear
    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
 
    // 14. Wait for URL Contains
    public void waitForURL(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }
 
    // 15. Wait for Page Title
    public void waitForTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }
 
    // 16. Dropdown Select by Visible Text
    public void selectByText(WebElement element, String text) {
        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOf(element)));
        select.selectByVisibleText(text);
    }
 
    // 17. Dropdown Select by Value
    public void selectByValue(WebElement element, String value) {
        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOf(element)));
        select.selectByValue(value);
    }
 
    // 18. Dropdown Select by Index
    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOf(element)));
        select.selectByIndex(index);
    }
 
    // 19. Mouse Hover
    public void mouseHover(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
 
    // 20. Double Click
    public void doubleClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }
 
    // 21. Right Click
    public void rightClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
 
    // 22. Drag and Drop
    public void dragAndDrop(WebElement source, WebElement target) {
        wait.until(ExpectedConditions.visibilityOf(source));
        wait.until(ExpectedConditions.visibilityOf(target));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }
 
    // 23. Scroll to Element
    public void scrollToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
 
    // 24. Scroll to Bottom
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
 
    // 25. Scroll to Top
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
 
    // 26. Accept Alert
    public void acceptAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
 
    // 27. Dismiss Alert
    public void dismissAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }
 
    // 28. Get Alert Text
    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
 
    // 29. Enter Text in Alert
    public void enterAlertText(String value) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(value);
    }
 
    // 30. Switch to Frame by Element
    public void switchToFrame(WebElement element) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }
 
    // 31. Switch to Default Content
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
 
    // 32. Switch to New Window
    public void switchToNewWindow(String parentWindow) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
 
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
 
    // 33. Navigate Back
    public void navigateBack() {
        driver.navigate().back();
    }
 
    // 34. Navigate Forward
    public void navigateForward() {
        driver.navigate().forward();
    }
 
    // 35. Refresh Page
    public void refreshPage() {
        driver.navigate().refresh();
    }
 
    // 36. Get Current URL
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
 
    // 37. Get Page Title
    public String getPageTitle() {
        return driver.getTitle();
    }
 
    // 38. Press Enter
    public void pressEnter(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element))
            .sendKeys(Keys.ENTER);
    }
 
    // 39. Get List of Elements
    public List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
 
    // 40. Wait for Text to Be Present
    public void waitForText(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
 
    // 41. Wait for URL to Match
    public void waitForURLToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }
 
    // 42. Wait for Element to Be Present
    public void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
 
    // 43. Click Using JavaScript
    public void jsClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    // 44. Upload a File
    public void uploadFile(WebElement upload, String filePath) {
    	wait.until(ExpectedConditions.visibilityOf(upload));
    	upload.sendKeys(filePath);
    }
    
    // 45. Upload using Robot (when input is hidden)
    public void uploadUsingRobot(WebElement upload, String filePath) throws Exception {
    	wait.until(ExpectedConditions.visibilityOf(upload));
        upload.click();
     
        StringSelection selection = new StringSelection(filePath);
     
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
     
        Robot robot = new Robot();
        robot.delay(2000);
     
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
     
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(500);
     
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    // 46. Download and Verify
    public boolean verifyFileDownloaded(String downloadPath, String expectedFileName) {
    	 
        File folder = new File(downloadPath);
     
        File[] files = folder.listFiles();
     
        if (files == null) {
            return false;
        }
     
        for (File file : files) {
     
            if (file.getName().equals(expectedFileName)) {
                return true;
            }
        }
     
        return false;
    }
    
    public void downloadAndVerify(WebElement element, String path, String fileName) {
    	wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    	boolean status = verifyFileDownloaded(path, fileName);
    	if(status) {
    		System.out.println("File downlaoded successfully");
    	}
    	else {
    		System.out.println("File not downloaded");
    	}
    }
    
    // 47. Auto-complete suggestion
    public void autoCompleteSuggestion(List<WebElement> suggestions, String option) {
    	 
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
     
        List<WebElement> list = suggestions;
     
        for (WebElement item : list) {
     
            if (item.getText().equals(option)) {
     
                item.click();
                break;
            }
        }
    }
    
    // 48. Take Screenshot
    public String takeScreenshot(WebDriver driver, String screenshotName) {
    	 
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
     
        String filePath = System.getProperty("user.dir") + "/Screenshots/"
                + screenshotName + "_" + timestamp + ".png";
     
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
    
    // 49. Window handling
    // Parent window
    public String parentWindow() {
    	return driver.getWindowHandle();
    }
    
    // Switch to Child window
    public void switchToChildWindow(String parentWindow) {
    	for(String window : driver.getWindowHandles()) {
    		if(!window.equals(parentWindow)) {
    			driver.switchTo().window(window);
    		break;
    		}
    	}
    }
    
    // Switch to Child window using URL name
    public void switchToChildWindowByUrlName(String value) {
    	for(String window : driver.getWindowHandles()) {
    		if(driver.getCurrentUrl().contains(value)) {
    		break;
    		}
    	}
    }
    
    // Switch back to parent window
    public void switchToParentWindow(String parentWindow) {
    	driver.switchTo().window(parentWindow);
    }
    
    // Close current window and switch back to parent window
    public void closeCurrentWindowAndReturn(String parentWindow) {
    	driver.close();
    	driver.switchTo().window(parentWindow);
    }
    
    // Close all child windows (keep Parent)
    public void closeAllChildWindows(String parentWindow) {
    	for(String window : driver.getWindowHandles()) {
    		if(!window.equals(parentWindow)) {
    			driver.switchTo().window(window);
    			driver.close();
    		}
    	}
    	driver.switchTo().window(parentWindow);
    }
    
    // 50. Clear
    public void clear(WebElement element) {
    	 
        wait.until(ExpectedConditions.visibilityOf(element));
     
        element.sendKeys(Keys.CONTROL, "a");
     
        element.sendKeys(Keys.DELETE);
    }
    
    // 51. Get texts
    public List<String> getTexts(List<WebElement> elements) {
    	 
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        List<String> texts = new ArrayList<>();
        for(WebElement element : elements) {
        	texts.add(element.getText());
        }
        return texts;
    }
    
    // 52. Get size
    public int getSize(List<WebElement> elements) {
    	 
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
     
        return elements.size();
    }
    
    // 53. Close the browser
    public static void closeBrowser() {
    	if(driver!=null) {
			driver.quit();
		}
    }

}

