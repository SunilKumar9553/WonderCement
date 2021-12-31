package WebPages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import WebUtil.WebActions;

public class FileuploadforPolicy {

	// ==========================Objects==================================
	WebActions webActions = new WebActions();

	// ==========================Locators==================================
	public static By clickonpolicymaintaince = By.xpath("//*[@id=\"MainSearch\"]");
	public static By searchBy = By.xpath("//*[@id=\"searchBy\"]");
	public static By policyNumber = By.xpath("//*[@id=\"policyNumber\"]"); // 09 SFA0003476 0
	public static By search = By.xpath("//*[@id=\"searchButton\"]");
	public static By fileupload = By.xpath("//*[@id=\"InquiryFileUpld\"]");
	public static By clickfiletoselect = By.xpath("//*[@id=\"fileUploadForm\"]");
	public static By uploafile = By.xpath("//*[@id=\"uploadFilesButton\"]");
	public static By documenttype = By.xpath("//*[@id=\"documentType_0\"]");
	public static By editemail = By.xpath("//*[@id=\"editableUploadEmailAddress\"]");
	public static By emailuploads = By.xpath("//*[@id=\"uploadEmailContainer\"]/div/button");
	public static By closefileupload = By.xpath("//*[@id=\"uploadCloseButton\"]");

	/**
	 * =============================================================================
	 * Method: fileupload | Author: Rajesh Buddha | Date:15 Aug 2020 | Description:
	 * Upload file into the application | Parameters: None | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	public void fileupload(String policynumber) throws Exception {
		Thread.sleep(4000);
		webActions.Click(clickonpolicymaintaince, "click on policy maintaince");
		Thread.sleep(1000);
		webActions.Click(searchBy, "search By");
		Thread.sleep(1000);
		webActions.selectByVisibleText(By.xpath("//*[@id='searchBy']"), "Policy Number");
		webActions.sendKeys(policyNumber, policynumber);
		Thread.sleep(1000);
		webActions.Click(search, "Search");
		webActions.Click(fileupload, "File Upload");
		Thread.sleep(4000);
		webActions.ClickJSE(By.xpath("//*[@id='fileUploadForm']"), "file Upload Form");
		Thread.sleep(4000);
		StringSelection strSelection = new StringSelection(
				"C:\\Users\\Sunil\\Desktop\\bfsi_testing_services_4x.jpg");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(strSelection, null);
		Robot robot1 = new Robot();
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
		Thread.sleep(3000);
		webActions.Click(emailuploads, "Email Uploads");
		webActions.getElmText(By.xpath("//*[@id='uploadConfirmationEmailMessage']"));
		webActions.ClickJSE(closefileupload, "Close upload file");
	}

}
