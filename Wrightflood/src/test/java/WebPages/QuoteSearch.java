package WebPages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.DriverFactory;
import WebUtil.WebActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import Utilities.ReportManager;

public class QuoteSearch  {
	
	// ==========================Objects==================================
	WebActions webActions = new WebActions();

// ==========================Locators==================================
	
	public static By quoteSearch = By.xpath("//a[contains(.,'Quote Search')]");
	public static By quoteNumber = By.xpath("//input[@id='quoteNumber']");
	public static By quoteNumberValue = By.xpath("(//dt[contains(.,'Quote Number')]//following-sibling::dd)[1]");
	public static By search = By.xpath("//a[@id='MainSrch']");
	public static By searchBy = By.xpath("//select[@id='searchBy']");//policy number
	public static By searchButton = By.xpath("//button[@id='searchButton']");
	public static By nextButton = By.xpath("//button[@id='nextButton1']");
	public static By closeIcon = By.xpath("//button[@class='close']/i");
	public static By ACHUpload = By.xpath("//label[contains(.,'Please select a payment method.')]/following-sibling::div//label//input[@id='EFT']");
	public static By clickHereToUploadDocuments = By.xpath("//a[contains(.,'To upload documents now, click here')]");
	public static By uploafile = By.xpath("//*[@id=\"uploadFilesButton\"]");
	

	/**
	 * =============================================================================
	 * Method: QuoteSearchProcess | Author: Samadrita Guha | Date:7 Oct 2020 | Description:
	 * Searching policies with policy number | Parameters: none | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */		
	
	
	public void QuoteSearchProcess() throws Exception {

		Thread.sleep(4000);
		webActions.Click(search, "Search");
		Thread.sleep(2000);
		webActions.Click(quoteSearch, "Quote search");
		Thread.sleep(2000);
		webActions.selectByVisibleText(By.xpath("//select[@id='searchBy']"), "Quote Number");
		webActions.clearAndSendKeys(quoteNumber, "09QT0009588399");
		webActions.Click(searchButton, "Search button");
		String actualValue = webActions.getElmText(quoteNumberValue);
		String expectedValue = "09QT0009588399";
		webActions.verifyText(actualValue, expectedValue);
		Thread.sleep(5000);
		/*webActions.Click(nextButton, "Next");
		webActions.Click(nextButton, "Next");
		webActions.Click(closeIcon, "Close Icon");
		webActions.Click(nextButton, "Next");
		webActions.selectByVisibleText(By.xpath("//select[@id='selectedNpnAgt']"), "Alana Ash - 123ALA4567");
		webActions.Click(ACHUpload, "ACH upload payment option");
		webActions.selectByVisibleText(By.xpath("//select[@id='PWTDYS']"), "3 Days");
		webActions.Click(nextButton, "Next");
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		webActions.Click(closeIcon, "Close Icon");
		webActions.Click(clickHereToUploadDocuments, "To upload documents now, click here.");
		StringSelection strSelection = new StringSelection(
				"D:\\POCs\\wrightflood\\src\\test\\resources\\Files\\slack dc.png");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(strSelection, null);
		
		robot1.delay(5000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.delay(1000);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.delay(1000);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.delay(1000);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.delay(2000);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.delay(2000);
		webActions.selectByVisibleText(By.xpath("//*[@id='documentType_0']"),
				"Proof of Residency: Automobile Registration");
		webActions.Click(uploafile, "Upload File");
	}	*/

}
}


//09QT4764514199