package WebUtil;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import Utilities.ReportManager;

public class WebActions {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;

	JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	Actions action = new Actions(DriverFactory.getInstance().getWebDriver());

	/**
	 * =============================================================================
	 * Method: waitForVisible | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 60 sec | Parameters: locator | Return: element
	 * =============================================================================
	 */
	@SuppressWarnings("deprecation")
	public WebElement waitForVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 100);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * =============================================================================
	 * Method: waitForVisible_MilliSeconds | Author: Rajesh Buddha | Date:16 Jan
	 * 2020 | Description: This method wait for element it will check every 5 sec
	 * its present or not until 60 sec | Parameters: locator | Return: element
	 * =============================================================================
	 */
	@SuppressWarnings("deprecation")
	public WebElement waitForVisible_MilliSeconds(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
		wait.pollingEvery(50, TimeUnit.MILLISECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * =============================================================================
	 * Method: openURL | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method open url | Parameters: URL | Return: none
	 * =============================================================================
	 */
	public void openURL(String URL) {
		DriverFactory.getInstance().getWebDriver().get(URL);
		String strActualText = DriverFactory.getInstance().getWebDriver().getCurrentUrl();
		verifyText(strActualText, URL);
		ReportManager.logInfo("Successfully Entered URL - " + URL);
		System.out.println("Successfully Entered URL - " + URL);
	}

	/**
	 * =============================================================================
	 * Method: Click | Author: Rajesh Buddha | Date:16 Jan 2020 | Description: This
	 * method click on element | Parameters: locator, info | Return: none
	 * =============================================================================
	 */
	public void Click(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		ReportManager.logInfo("Successfully clicked on - " + info);
		System.out.println("Successfully clicked on - " + info);
	}

	/**
	 * =============================================================================
	 * Method: Click | Author: Rajesh Buddha | Date:16 Jan 2020 | Description: This
	 * method click on element | Parameters: locator, info | Return: none
	 * =============================================================================
	 */
	public void ClickJSE(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		javascriptExecutor.executeScript("arguments[0].click();", elm);
		ReportManager.logInfo("Successfully clicked on - " + info);
		System.out.println("Successfully clicked on - " + info);
	}

	/**
	 * =============================================================================
	 * Method: sendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method enter text input text using element | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 */
	public void sendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text - " + text);
		System.out.println("Successfully Entered text - " + text);
	}

	/**
	 * =============================================================================
	 * Method: fileUploadsendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method upload file | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 * @throws IOException 
	 */
	public void fileUploadsendKeys(By locator, String path) throws AWTException, InterruptedException, IOException {
		WebElement elm = waitForVisible(locator);
		Thread.sleep(2000);
		File f = new File(path); //file name will be entered by user at runtime
      //  System.out.println(f.exists()); //will print "true" if the file name given by user exists, false otherwise

        if(f.exists())
        {
        	elm.click();
        	System.out.println("File exists at give path");
        	StringSelection ss = new StringSelection(path);
    		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); // copy the above string to clip board
    		Robot robot;
    		robot = new Robot();
    		robot.delay(1000);
    		robot.keyPress(KeyEvent.VK_ENTER);
    		robot.keyRelease(KeyEvent.VK_ENTER);
    		robot.delay(2000);
    		robot.keyPress(KeyEvent.VK_CONTROL);
    		robot.keyPress(KeyEvent.VK_V);
    		robot.keyRelease(KeyEvent.VK_V);
    		robot.delay(2000);
    		robot.keyRelease(KeyEvent.VK_CONTROL); // paste the copied string into the dialog box
    		robot.keyPress(KeyEvent.VK_ENTER);
    		robot.keyRelease(KeyEvent.VK_ENTER); // enter
        }else {
        	BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        	ImageIO.write(image, "png", new File("D:\\POCs\\Maxval\\Reports\\Screenshots\\screenshot.png"));
        	System.out.println("File Not exists at give pat");
        	ReportManager.logScreenshotInfo();
        	ReportManager.logFail("File Not exists at give path");;
    		assertEquals(f.exists(), true);
        }
		
		
	}

	/**
	 * =============================================================================
	 * Method: sendKeysfromKeyboard | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method will keyboard actions | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 */
	public void sendKeysfromKeyboard(By locator, Keys keyboardAction) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(keyboardAction);
		ReportManager.logInfo("Successfully Entered text - " + keyboardAction);
		System.out.println("Successfully Entered text - " + keyboardAction);
	}

	public String getElmText(By locator) {
		WebElement elm = waitForVisible(locator);
		String elamText = elm.getText();
		ReportManager.logInfo("Successfully get element text - " + elamText);
		System.out.println("Successfully get element text - " + elamText);
		return elamText;
	}

	public boolean isDisplayed(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean isPresent = elm.isDisplayed();
		if (isPresent) {
			ReportManager.logInfo("Successfully element displayed: " + info);
			System.out.println("Successfully element displayed: " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);
		}
		return isPresent;
	}

	public boolean isDisplayedList(By locator, String info) throws InterruptedException {
		Thread.sleep(2000);
		boolean isPresent = DriverFactory.getInstance().getWebDriver().findElements(locator).size()>0;
		if (isPresent) {
			ReportManager.logInfo("Successfully element displayed: " + info);
			System.out.println("Successfully element displayed: " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);
		}
		return isPresent;
	}

	
	
	public boolean isEnabled(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean isPresent = elm.isEnabled();
		if (isPresent) {
			ReportManager.logInfo("Successfully element displayed: " + info);
			System.out.println("Successfully element displayed: " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);
		}
		return isPresent;
	}

	public void clearAndSendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.clear();
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text - " + text);
		System.out.println("Successfully Entered text - " + text);
	}

	public void verifyText(String actualText, String expectedText) {
		ReportManager.logInfo("Actual Text - " + "<b style=\"color:green;\">" + actualText + "</b>");
		ReportManager.logInfo("Expected Text - " + "<b style=\"color:green;\">" + expectedText + "</b>");
		System.out.println("Actual Text - " + actualText);
		System.out.println("Expected Text - " + expectedText);
		assertEquals(expectedText, actualText);
	}

	public void verifyIntValues(int actualValue, int expectedValue) {
		ReportManager.logInfo("Actual Value - " + actualValue);
		ReportManager.logInfo("Expected Value - " + expectedValue);
		System.out.println("Actual Value - " + actualValue);
		System.out.println("Expected Value - " + expectedValue);
		assertEquals(actualValue, expectedValue);
	}

	public String getAttributeValue(By locator, String name) {
		WebElement elm = waitForVisible(locator);
		String attributeText = elm.getAttribute(name);
		ReportManager.logInfo("Successfully get attribute text - " + attributeText);
		System.out.println("Successfully get attribute text - " + attributeText);
		return attributeText;
	}

	public boolean isScrollPresent() throws Exception {
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		Boolean isScroll_Present = (Boolean) (javascriptExecutor.executeScript(execScript));
		return isScroll_Present;

	}

	public void scrollDownUsingJS() {

		javascriptExecutor.executeScript(
				"window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
	}

	public void mouseHover(By locator) throws Exception {
		WebElement elm = waitForVisible_MilliSeconds(locator);
		action.moveToElement(elm).build().perform();
		String elmText = elm.getText();
		ReportManager.logInfo("Successfully mouse hover and get text - " + elmText);
		System.out.println("Successfully mouse hover and get text - " + elmText);
	}

	public void switchToFrame(By locator) throws Exception {
		WebElement elm = waitForVisible(locator);
		DriverFactory.getInstance().getWebDriver().switchTo().frame(elm);
		ReportManager.logInfo("Successfully switched to frame ");
		System.out.println("Successfully switched to frame ");
	}

	public List<WebElement> getListofElements(By locator, String name) {
		waitForVisible(locator);
		List<WebElement> lst_Elements = DriverFactory.getInstance().getWebDriver().findElements(locator);
		ReportManager.logInfo("Successfully get element size - " + lst_Elements.size());
		System.out.println("Successfully get element size - " + lst_Elements.size());
		return lst_Elements;
	}

	public void selectByVisibleText(By locator, String value) {
		WebElement elm = waitForVisible(locator);
		Select sel = new Select(DriverFactory.getInstance().getWebDriver().findElement(locator));
		sel.selectByVisibleText(value);
	}

	public void switchTab() {
		String MainWindow = DriverFactory.getInstance().getWebDriver().getWindowHandle();
		String currentHandle = "";
		Set<String> win = DriverFactory.getInstance().getWebDriver().getWindowHandles();

		Iterator<String> it = win.iterator();
		if (win.size() > 1) {
			while (it.hasNext()) {
				String handle = it.next();
				if (!handle.equalsIgnoreCase(MainWindow)) {
					DriverFactory.getInstance().getWebDriver().switchTo().window(handle);
					currentHandle = handle;
				}
			}
		} else {
			System.out.println("Unable to switch");
		}
	}

	public void switchDefaultWindow() {

		DriverFactory.getInstance().getWebDriver().switchTo().defaultContent();

	}
	
	public String getExcelData(String path, String sheetName, int rowCount, int cellCount) throws Exception {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		wb = new XSSFWorkbook(stream);
		sheet = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		String name = formatter.formatCellValue(sheet.getRow(rowCount).getCell(cellCount));
		
		return name;

	}
	

	public int getAvailableRowCount(String path, String sheetName) throws Exception {
		
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		wb = new XSSFWorkbook(stream);
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;

		// TODO Auto-generated method stub
		
	}
	
	
	public void writeData(String path, String sheetName, int rowCount, int cellCount, String value) throws Exception {
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		wb = new XSSFWorkbook(stream);
		sheet = wb.getSheet(sheetName);
		cell = sheet.getRow(rowCount).getCell(cellCount);
		if(cell == null) {
			cell = sheet.getRow(rowCount).createCell(cellCount);
		}
		cell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
	}
	
	public boolean isElementPresent(By xpath){
        try{
            DriverFactory.getInstance().getWebDriver().findElement(xpath);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

	
	public void switchToWindowIndex(int index) {
		WebDriver driver = DriverFactory.getInstance().getWebDriver();
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> windowStrings = new ArrayList<>(windowHandles);
	    System.out.println("window handles size " + windowStrings.size());
	    String reqWindow = windowStrings.get(index);
	    driver.switchTo().window(reqWindow);
	    System.out.println("Switched to " + driver.getTitle());
	}
	
	
}
