package WebPages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import WebUtil.WebActions;


public class ExpiringPilicies extends PendingInsurance{
	
	// ==========================Objects==================================
		WebActions webActions = new WebActions();
		
	// ==========================Locators==================================
		public static By expiringPolicies = By.xpath("//a[@id='expiringPolicies']");
		public static By firstPolicyNumber = By.xpath("//table[@id='expData']//tbody[1]//tr[1]//td[1]");
		public static By makePayment = By.xpath("//button[contains(.,'Make Payment')]");
		public static By makeChanges = By.xpath("//button[contains(.,'Make Changes')]");
		public static By copyToNewQuote = By.xpath("//button[contains(.,'Copy to New Quote')]");
		public static By abaRoundingNumber = By.xpath("//input[@id='routingNumber']");
		public static By renewal = By.xpath("//button[@id='btnRenewal']");
		public static By bankAccountNumber = By.xpath("//input[@id='accountNumber']");
		public static By confirmAccountNumber = By.xpath("//input[@id='accountNumber2']");
		public static By submitPayment = By.xpath("//span[contains(.,'Submit Payment')]");
		public static By backInPolicyMaintenance = By.xpath("//button[contains(.,'Back')]");
		public static By cancelInPolicyMaintenance = By.xpath("//button[contains(.,'Cancel')]");
		public static By beginTransaction = By.xpath("//button[contains(.,'Begin Transaction')]");
		public static By transactionTypePayment = By.xpath("//li[@id='selectablePY']");
		public static By expiringPoliciesTable = By.xpath("//table[@id='expData']//tbody[+i+]");
		public static By rowsWithinEachRowInExpiringPoliciesTable = By.xpath("//table[@id='expData']//tbody//tr");
		public static By submitPaymentButton = By.xpath("//button[@id='submitPaymentButton']");
		/**
		 * =============================================================================
		 * Method: IDocsInfo | Author: Samadrita Guha | Date:2 Oct 2020 | Description:
		 * iDocs of policies from the application | Parameters: none | Return: None
		 * =============================================================================
		 * 
		 * @throws Exception
		 */		
		
		
		public void ExpiringPiliciesProcess() throws Exception {

			webActions.Click(expiringPolicies, "Expiring policy");
			webActions.Click(firstPolicyNumber, "First policy number in expiring policies");
			Robot robot1=new Robot();
			robot1.delay(3000);
			robot1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			webActions.Click(makeChanges, "Make changes button");
			webActions.Click(policyPayment, "Policy payment");
			webActions.Click(beginTransaction, "Begin transaction button");
			webActions.Click(renewal, "Renewal button");
			webActions.clearAndSendKeys(transactionAmount, "345");
			webActions.Click(ACHUpload, "ACH (Upload)");
			webActions.selectByVisibleText(By.xpath("//select[@id='eftSweepWait']"), "0 Days");
			webActions.selectByVisibleText(By.xpath("//select[@id='achAccountDetails']"), "63000021|****2222");
			webActions.Click(submitPaymentButton, "Submit payment button");
			String actualValue = webActions.getElmText(RequestSubmittedConfirmation);
			String expectedValue = "Payment Request Submitted";
			webActions.verifyText(actualValue, expectedValue);
			Thread.sleep(3000);
			
			
		}
		
}









	

	
	
	