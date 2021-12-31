package WebPages;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.DriverFactory;
import WebUtil.WebActions;


public class Reports extends FloodPlusQuote{
	
	// ==========================Objects==================================
			WebActions webActions = new WebActions();

   // ==========================Locators==================================

			public static By reports = By.xpath("//a[@id='MainRpts']");		
			public static By claims = By.xpath("//a[contains(.,'Claims')]");
			public static By reportStartDate = By.xpath("(//img[@class='ui-datepicker-trigger'])[1]");
			public static By firstMonthDay = By.xpath("(//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td/a)[1]");
			public static By reportEndDate = By.xpath("//input[@id='endDate']/following-sibling::img[@class='ui-datepicker-trigger']");
			public static By tenthMonthDay = By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td/a[contains(.,'10')]");
			public static By claimStatus = By.xpath("//select[@id='claimStatus']");
			public static By generateSpreadsheetYes = By.xpath("//input[@id='genSpreadsheetYes']");
			public static By generateReport = By.xpath("//input[@id='submitButton']");
			
			
			/**
			 * =============================================================================
			 * Method: ExtractReports | Author: Samadrita Guha | Date:24 Sept 2020 | Description:
			 * Extracting reports from the application | Parameters: none | Return: None
			 * =============================================================================
			 * 
			 * @throws Exception
			 */		
			
			
			public void ExtractReports() throws Exception {

				webActions.Click(reports, "Reports");
				Thread.sleep(2000);
				webActions.Click(claims, "Claims");
				Thread.sleep(2000);
				webActions.Click(reportStartDate, "Datepicker to choose start date");
				webActions.Click(firstMonthDay, "First day of the current month");
				//selectDate();
				webActions.Click(reportEndDate, "Datepicker to choose end date");
				webActions.Click(tenthMonthDay, "Tenth day of the current month");
				//selectDate();
				webActions.selectByVisibleText(By.xpath("//select[@id='claimStatus']"), "Any Status");
				Thread.sleep(2000);
				webActions.Click(generateSpreadsheetYes, "Radio button yes for generate spreadsheet");
				webActions.Click(generateReport, "Generate report");
				Thread.sleep(5000);
				
			}
			
	
}
