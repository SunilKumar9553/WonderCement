package WebPages;
import java.awt.Robot;
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

public class PendingInsurance {
	
	// ==========================Objects==================================
				WebActions webActions = new WebActions();

		   // ==========================Locators==================================
				
				public static By pendingInsuranced = By.xpath("//a[@id='suspensePolicies']");
				public static By firstPolicyNumber = By.xpath("//tbody/tr[1]/td/following-sibling::td/a");
				public static By premiumDetail = By.xpath("//a[@id='premiumDetail']");
				public static By makeChanges = By.xpath("//button[contains(.,'Make Changes')]");
				public static By policyPayment = By.xpath("//li[@id='selectablePY']");
				public static By beginTransaction = By.xpath("//button[@id='selectTransactionButton']");
				public static By transactionAmount = By.xpath("//input[@id='transactionAmountOtherTxt']");
				public static By ACHUpload = By.xpath("//a[contains(.,'ACH (Upload)')]");
				public static By submitButton = By.xpath("//button[@id='submitPaymentButton']");
				public static By RequestSubmittedConfirmation = By.xpath("//h1[contains(.,'Payment Request Submitted')]");
				
				/**
				 * =============================================================================
				 * Method: PendingInsuranceProcess | Author: Samadrita Guha | Date:12 Oct 2020 | Description:
				 * Pending insurance process and making payment | Parameters: none | Return: None
				 * =============================================================================
				 * 
				 * @throws Exception
				 */		
				
				
				public void PendingInsuranceProcess() throws Exception {
					
					webActions.Click(pendingInsuranced, "Pending Insurance");
					webActions.Click(firstPolicyNumber, "First policy number in the list of pending Insurance policies");
					Thread.sleep(3000);
					webActions.Click(premiumDetail, "Premium details");
					webActions.Click(makeChanges, "Make changes button");
					webActions.Click(policyPayment, "Policy payment");
					webActions.Click(beginTransaction, "Begin transaction button");
					webActions.clearAndSendKeys(transactionAmount, "345");
					Thread.sleep(3000);
					webActions.Click(ACHUpload, "ACH (Upload)");
					webActions.selectByVisibleText(By.xpath("//select[@id='eftSweepWait']"), "0 Days");
					webActions.selectByVisibleText(By.xpath("//select[@id='achAccountDetails']"), "63000021|****2222");
					webActions.Click(submitButton, "Submit button");
					String actualValue = webActions.getElmText(RequestSubmittedConfirmation);
					String expectedValue = "Payment Request Submitted";
					webActions.verifyText(actualValue, expectedValue);
					Thread.sleep(3000);
				}

//63000021|****2222
}
