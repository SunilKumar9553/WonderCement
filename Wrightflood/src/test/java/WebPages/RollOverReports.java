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


public class RollOverReports extends FloodPlusQuote{
	
	// ==========================Objects==================================
			WebActions webActions = new WebActions();

   // ==========================Locators==================================
			public static By rollOverReports = By.xpath("//a[@id='MainRollover']");
			public static By reportMonthField = By.xpath("//select[@id='reportMonth']");	
			public static By reportYearField = By.xpath("//select[@id='reportYear']");
			public static By submitButton = By.xpath("//input[@id='submitButton']");
			public static By viewRollOverReport = By.xpath("//a[contains(.,'View Rollover Report')]");
			public static By viewListOfPaidRollOvers = By.xpath("//a[contains(.,'View List of Paid Rollovers')]");
			public static By viewListOfUnPaidRollOvers = By.xpath("//a[contains(.,'View List of Unpaid Rollovers')]");
			
			
			/**
			 * =============================================================================
			 * Method: RollOverReportsProcess | Author: Samadrita Guha | Date:23 Sept 2020 | Description:
			 * Extracting roll over reports from the application | Parameters: none | Return: None
			 * =============================================================================
			 * 
			 * @throws Exception
			 */		
			
			
			public void RollOverReportsProcess() throws Exception {

				webActions.Click(rollOverReports, "Rollover Reports");
				Thread.sleep(2000);
				webActions.selectByVisibleText(By.xpath("//select[@id='reportMonth']"), "October");
				Thread.sleep(2000);
				webActions.selectByVisibleText(By.xpath("//select[@id='reportYear']"), "2020");
				webActions.Click(submitButton, "Submit button");
				webActions.Click(viewRollOverReport, "View rollover report");
				Thread.sleep(15000);
			}
			
			
}
