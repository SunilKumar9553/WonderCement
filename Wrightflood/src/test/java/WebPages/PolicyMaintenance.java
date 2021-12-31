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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ReportManager;


public class PolicyMaintenance extends Reports{

	
	// ==========================Objects==================================
			WebActions webActions = new WebActions();

	   // ==========================Locators==================================
			
			public static By policyMaintenance = By.xpath("//a[contains(.,'Policy Maintenance')]");
			public static By searchBy = By.xpath("//select[@id='searchBy']");//Individual Name
			public static By policiesEffectiveWithin = By.xpath("//select[@id='termLimit']");//1 Year
			public static By firstName = By.xpath("//input[@id='firstName']");
			public static By lastName = By.xpath("//input[@id='lastName']");
			public static By search = By.xpath("//button[@id='searchButton']");
			public static By firstPolicy = By.xpath("//tbody[@class='page1']/tr[1]/td[1]/input");
			public static By select = By.xpath("//button[@title='Select']");
			
			
			/** new*/
			public static By policyMaintenance2 = By.xpath("//*[@id='InquiryEndCxl']"); //Policy maintenance button in policy summary page
			public static By policyPayment = By.xpath("//li[@id='selectablePY']");
			public static By beginTransaction = By.xpath("//button[@id='selectTransactionButton']");
			public static By paymentAmount = By.xpath("//input[@id='transactionAmountOtherTxt']");
			public static By achUpload = By.xpath("//a[text()='ACH (Upload)']");
			public static By waitingPeriod = By.xpath("//select[@id='eftSweepWait']");
			public static By bankAccountNumbers = By.xpath("//select[@id='achAccountDetails']");
			public static By submitPayment = By.xpath("//span[text()='Submit Payment']");
			public static By documentsGreenButton = By.xpath("//*[@id='policyMaintenanceDocumentNotifierContainer']/a");
			public static By policyPaymentPDF = By.xpath("//*[@id='Policy Payment Transmittal']");
			
			
			
			
			
			

			/**
			 * =============================================================================
			 * Method: PolicyMaintenanceProcess | Author: Samadrita Guha | Date:5 Oct 2020 | Description:
			 * Policy maintenance process | Parameters: none | Return: None
			 * =============================================================================
			 * 
			 * @throws Exception
			 */		
			
			
			public void PolicyMaintenanceProcess() throws Exception {

				webActions.Click(policyMaintenance, "Policy maintenance");
				Thread.sleep(2000);
				webActions.selectByVisibleText(By.xpath("//select[@id='searchBy']"), "Individual Name");
				webActions.selectByVisibleText(By.xpath("//select[@id='termLimit']"), "1 Year");
				webActions.clearAndSendKeys(firstName, "Test");
				webActions.clearAndSendKeys(lastName, "Test");
				webActions.Click(search, "Search");
				webActions.Click(firstPolicy, "First policy matching search criteria from the table");
				webActions.Click(select, "Select");
				Robot robot1 = new Robot();
				robot1.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(6000);
				
				
			}	
			
			
			
			/**
			 * =============================================================================
			 * Method: PaymentFromPolicyMntnce | Author: Sunil | Date:27 Jan 2021 | Description:
			 * Payment from policy maintenance  | Parameters: none | Return: None
			 * =============================================================================
			 * @throws Exception 
			 * 
			 *
			 */		
			
			public void paymentFromPolicyMntnce() throws Exception {
				
				webActions.Click(policyMaintenance2, "click policy Maintenance");
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
				js.executeScript("scroll(0, 600);");
				webActions.Click(policyPayment, "click policy payment");
				webActions.Click(beginTransaction, "Begin transaction");
				webActions.sendKeys(paymentAmount, "1");
				Thread.sleep(2000);
				webActions.Click(achUpload, "ACH Upload");
				Thread.sleep(6000);
				webActions.waitForVisible(waitingPeriod);
				WebElement selectWait = DriverFactory.getInstance().getWebDriver().findElement(waitingPeriod);
				Select select = new Select(selectWait);
				select.selectByIndex(2);
				WebElement selectAccount = DriverFactory.getInstance().getWebDriver().findElement(bankAccountNumbers);
				Select selectBank = new Select(selectAccount);
				selectBank.selectByIndex(1);
				Thread.sleep(6000);
				webActions.Click(submitPayment, "click submit");
				Thread.sleep(7000);
				webActions.waitForVisible(documentsGreenButton);
				webActions.Click(documentsGreenButton, "Documents");
				webActions.Click(policyPaymentPDF, "open payment pdf");
				Thread.sleep(3000);
				ReportManager.logScreenshotInfo();
				Thread.sleep(4000);
				
				
				
				
				
			}
			
			
}
