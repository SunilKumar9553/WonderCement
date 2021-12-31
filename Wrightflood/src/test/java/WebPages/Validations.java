package WebPages;

import org.openqa.selenium.By;

import WebUtil.WebActions;



public class Validations {
	
	// ==========================Objects==================================
		WebActions webActions = new WebActions();

	// ==========================Locators==================================
		
		public static By home = By.xpath("//a[contains(.,'Home')]");
		public static By feedback = By.xpath("//a[contains(.,'Feedback')]");
		public static By contactUs = By.xpath("//a[contains(.,'Contact Us')]");
		public static By privacy = By.xpath("//a[contains(.,'Privacy')]");
		public static By product = By.xpath("//a[@id='productSelection']");
		public  static By pendingInsurance=By.xpath("//a[contains(.,'Pending')]");
		public static By privateFlood = By.xpath("//a[@id='privateFlood']");
		public static By expiringPolicies = By.xpath("//a[@id='expiringPolicies']");
		public static By nonRenewals = By.xpath("//a[@id='nonRenewalPolicies']");
		public static By rollOverSuspense = By.xpath("//a[contains(.,'Rollover Suspense')]");
		public static By flood = By.xpath("//h4[contains(.,'Flood')]");
		public static By excessFlood = By.xpath("//h4[contains(.,'Excess Flood')]");
		public  static By floodPlus=By.xpath("//h4[contains(.,'FloodPlus')]");
		public static By zurichFlood = By.xpath("//h4[contains(.,'Zurich Flood™')]");
		public static By inclineFlood = By.xpath("//h4[contains(.,'Incline Flood™')]");
		public static By searchBox = By.xpath("//form[@name='quickSearchBoxForm']");
		public static By welcomePage = By.xpath("//a[contains(.,'Welcome Page')]");
		public static By newQuote = By.xpath("//a[contains(.,'New Quote')]");
		public static By openAClaim = By.xpath("//a[contains(.,'Open a Claim')]");
		public static By reports = By.xpath("//a[contains(.,'Reports')]");
		public static By signOff = By.xpath("//a[contains(.,'Signoff')]");
		public static By policyMaintenance = By.xpath("//a[contains(.,'Policy Maintenance')]");
		
		/**
		 * =============================================================================
		 * Method: Validating required fields | Author: Samadrita Guha | Date:12 Dec 2020 | Description:
		 * Checking the presence of required fields | Parameters: none | Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */		
		

		public void ValidatingRequiredElements() throws InterruptedException {
			// TODO Auto-generated method stub
			//verifying home
			String actualValueHome = webActions.getElmText(home);
			String expectedValueHome = "Home";
			webActions.verifyText(actualValueHome, expectedValueHome);
			Thread.sleep(2000);
			//verifying feedback
			String actualValueFeedback = webActions.getElmText(feedback);
			String expectedValueFeedback = "Feedback";
			webActions.verifyText(actualValueFeedback, expectedValueFeedback);
			Thread.sleep(2000);
			//verifying contact us
			String actualValueContactUs = webActions.getElmText(contactUs);
			String expectedValueContactUs = "Contact Us";
			webActions.verifyText(actualValueContactUs, expectedValueContactUs);
			Thread.sleep(2000);
			//verifying privacy
			String actualValuePrivacy = webActions.getElmText(privacy);
			String expectedValuePrivacy = "Privacy";
			webActions.verifyText(actualValuePrivacy, expectedValuePrivacy);
			Thread.sleep(2000);
			//verifying product
			String actualValueProduct = webActions.getElmText(product);
			String expectedValueProduct = " \nProducts\n ";
			webActions.verifyText(actualValueProduct, expectedValueProduct);
			Thread.sleep(2000);
			//verifying pending insurance
			//String actualValuePendingInsurance = webActions.getElmText(pendingInsurance);
			//String expectedValuePendingInsurance = "Pending\n Issuance\n";
			//webActions.verifyText(actualValuePendingInsurance, expectedValuePendingInsurance);
			//Thread.sleep(2000);
			//verifying private flood
			//String actualValuePrivateFlood = webActions.getElmText(privateFlood);
			//String expectedValuePrivateFlood = "Private Flood";
			//webActions.verifyText(actualValuePrivateFlood, expectedValuePrivateFlood);
			//Thread.sleep(2000);
			//verifying expiring policies
			//String actualValueExpiringPolicies = webActions.getElmText(expiringPolicies);
			//String expectedValueExpiringPolicies = "Expiring Policies";
			//webActions.verifyText(actualValueExpiringPolicies, expectedValueExpiringPolicies);
			//Thread.sleep(2000);
			//verifying non renewals
			//String actualValueNonRenewals = webActions.getElmText(nonRenewals);
			//String expectedValueNonRenewals = "Non-Renewals";
			//webActions.verifyText(actualValueNonRenewals, expectedValueNonRenewals);
			//Thread.sleep(2000);
			//verifying roll over suspense
			//String actualValueRollOverSuspense = webActions.getElmText(rollOverSuspense);
			//String expectedValueRollOverSuspense = "Rollover Suspense";
			//webActions.verifyText(actualValueRollOverSuspense, expectedValueRollOverSuspense);
			//Thread.sleep(2000);
			//verifying flood
			String actualValueFlood = webActions.getElmText(flood);
			String expectedValueFlood = "Flood";
			webActions.verifyText(actualValueFlood, expectedValueFlood);
			Thread.sleep(2000);
			//verifying excess flood
			String actualValueExcessFlood = webActions.getElmText(excessFlood);
			String expectedValueExcessFlood = "Excess Flood";
			webActions.verifyText(actualValueExcessFlood, expectedValueExcessFlood);
			Thread.sleep(2000);
			//verifying flood plus
			String actualValueFloodPlus = webActions.getElmText(floodPlus);
			String expectedValueFloodPlus = "FloodPlus";
			webActions.verifyText(actualValueFloodPlus, expectedValueFloodPlus);
			Thread.sleep(2000);
			//verifying Zurich flood
			String actualValueZurichFlood = webActions.getElmText(zurichFlood);
			String expectedValueZurichFlood = "Zurich Flood™";
			webActions.verifyText(actualValueZurichFlood, expectedValueZurichFlood);
			Thread.sleep(2000);
			//verifying incline flood
			String actualValueInclineFlood = webActions.getElmText(inclineFlood);
			String expectedValueInclineFlood = "Incline Flood™";
			webActions.verifyText(actualValueInclineFlood, expectedValueInclineFlood);
			Thread.sleep(2000);
			//verifying welcome page
			String actualValueWelcomePage = webActions.getElmText(welcomePage);
			String expectedValuWelcomePage = "Welcome Page";
			webActions.verifyText(actualValueWelcomePage, expectedValuWelcomePage);
			Thread.sleep(2000);
			//verifying new quote
			String actualValueNewQuote = webActions.getElmText(newQuote);
			String expectedValuNewQuote = "New Quote";
			webActions.verifyText(actualValueNewQuote, expectedValuNewQuote);
			Thread.sleep(2000);
			//verifying open a claim
			String actualValueOpenAClaim = webActions.getElmText(openAClaim);
			String expectedValuOpenAClaim = "Open a Claim";
			webActions.verifyText(actualValueOpenAClaim, expectedValuOpenAClaim);
			Thread.sleep(2000);
			//verifying reports
			String actualValueReports = webActions.getElmText(reports);
			String expectedValuReports = "Reports";
			webActions.verifyText(actualValueReports, expectedValuReports);
			Thread.sleep(2000);
			//verifying signoff
			String actualValueSignOff = webActions.getElmText(signOff);
			String expectedValuSignOff = "Signoff";
			webActions.verifyText(actualValueSignOff, expectedValuSignOff);
			Thread.sleep(2000);
			//verifying policyMaintenance
			String actualValuePolicyMaintenance = webActions.getElmText(policyMaintenance);
			String expectedValuPolicyMaintenance = "Policy Maintenance";
			webActions.verifyText(actualValuePolicyMaintenance, expectedValuPolicyMaintenance);
			Thread.sleep(2000);
			
		}

}
