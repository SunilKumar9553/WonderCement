package WebPages;

import org.openqa.selenium.By;

import Utilities.ReportManager;
import WebUtil.WebActions;

public class NegativeFlowReports {
	// ==========================Objects==================================
				WebActions webActions = new WebActions();

	   // ==========================Locators==================================

				public static By reports = By.xpath("//a[@id='MainRpts']");		
				public static By claims = By.xpath("//a[contains(.,'Claims')]");
				public static By expiration = By.xpath("//a[contains(.,'Expiration')]");
				public static By reportStartDate = By.xpath("(//img[@class='ui-datepicker-trigger'])[1]");
				public static By firstMonthDay = By.xpath("(//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td/a)[1]");
				public static By reportEndDate = By.xpath("//input[@id='endDate']/following-sibling::img[@class='ui-datepicker-trigger']");
				public static By tenthMonthDay = By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td/a[contains(.,'10')]");
				public static By claimStatus = By.xpath("//select[@id='claimStatus']");
				public static By generateSpreadsheetYes = By.xpath("//input[@id='genSpreadsheetYes']");
				public static By generateReport = By.xpath("//input[@id='submitButton']");
				public static By reportErrorMessage= By.xpath("(//div[contains(.,'Report End Date End date cannot be before the start date')])[2]");
				public static By ErrorMessageOkButton = By.xpath("//button//span[contains(.,'Ok')]");
				
				/**
				 * =============================================================================
				 * Method: ExtractReports | Author: Samadrita Guha | Date:24 Sept 2020 | Description:
				 * Extracting reports from the application | Parameters: none | Return: None
				 * =============================================================================
				 * 
				 * @throws Exception
				 */		
				
				
				public void NegativeFlowForReports() throws Exception {

					webActions.Click(reports, "Reports");
					Thread.sleep(2000);
					webActions.Click(expiration, "Expiration");
					Thread.sleep(2000);
					webActions.Click(reportStartDate, "Datepicker to choose start date");
					webActions.Click(tenthMonthDay, "First day of the current month");
					//selectDate();
					webActions.Click(reportEndDate, "Datepicker to choose end date");
					webActions.Click(firstMonthDay, "Tenth day of the current month");
					//selectDate();
					webActions.Click(generateSpreadsheetYes, "Radio button yes for generate spreadsheet");
					webActions.Click(generateReport, "Generate report");
					Thread.sleep(4000);
					System.out.println("===========================ERRoR_MeSSagE================");
				    String ActualErrorMsg=webActions.getElmText(reportErrorMessage);
				    Thread.sleep(2000);
				    String expectedErrorMessage = "Report End Date End date cannot be before the start date"; 
				    Thread.sleep(2000);
				    webActions.verifyText(ActualErrorMsg, expectedErrorMessage);
				    Thread.sleep(2000);
				    ReportManager.logScreenshotInfo();
				    Thread.sleep(2000);
				    webActions.Click(ErrorMessageOkButton, "Ok button");
				    Thread.sleep(2000);
					//System.out.println(ClaimErrorMsgs);		
				}

}
