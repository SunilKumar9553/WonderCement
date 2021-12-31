package WebPages;

import org.openqa.selenium.By;

import Utilities.ReportManager;
import WebUtil.WebActions;

public class NegativeFlowQuoteSearch {
	
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
		public static By quoteErrorMessage = By.xpath("(//div[contains(.,'Quote Number is not valid.')])[2]");
		public static By okButton = By.xpath("//button/span[contains(.,'Ok')]");
		public static By firstName = By.xpath("//input[@id='firstName' and @name='JFNAME']");
		public static By lastName = By.xpath("//input[@id='lastName' and @name='JLNAME']");
		public static By radioButton = By.xpath("//input[@id='startsWithSearch']");
		public static By QuoteErrorMessage2 = By.xpath("//td[contains(.,'No Records Found')]");
		
		

		/**
		 * =============================================================================
		 * Method: QuoteSearchProcess | Author: Samadrita Guha | Date:7 Oct 2020 | Description:
		 * Searching policies with policy number | Parameters: none | Return: None
		 * =============================================================================
		 * 
		 * @throws Exception
		 */		
		
		
		public void NegativeFlowQuoteSearchProcess() throws Exception {

			Thread.sleep(4000);
			webActions.Click(search, "Search");
			Thread.sleep(2000);
			webActions.Click(quoteSearch, "Quote search");
			Thread.sleep(2000);
			webActions.selectByVisibleText(By.xpath("//select[@id='searchBy']"), "Quote Number");
			webActions.clearAndSendKeys(quoteNumber, "1234234534");
			webActions.Click(searchButton, "Search button");
			Thread.sleep(2000);
			String actualValue = webActions.getElmText(quoteErrorMessage);
			String expectedValue = "Quote Number is not valid.";
			webActions.verifyText(actualValue, expectedValue);
			Thread.sleep(2000);
			ReportManager.logScreenshotInfo();
			webActions.Click(okButton, "Ok button");
			Thread.sleep(2000);
			webActions.selectByVisibleText(By.xpath("//select[@id='searchBy']"), "Individual Name");
			Thread.sleep(2000);
			webActions.clearAndSendKeys(firstName, "test123");
			webActions.clearAndSendKeys(lastName, "test1234");
			Thread.sleep(2000);
			webActions.Click(radioButton, "Begin with search criteria radio button");
			webActions.Click(searchButton, "Search button");
			Thread.sleep(2000);
			String actualValue1 = webActions.getElmText(QuoteErrorMessage2);
			String expectedValue2 = "No Records Found";
			webActions.verifyText(actualValue1, expectedValue2);
			Thread.sleep(2000);
			 ReportManager.logScreenshotInfo();
			
			Thread.sleep(5000);
		}
	
	

}
