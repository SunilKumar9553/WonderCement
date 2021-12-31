package WebPages;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class InsuredWebSite {
	
	// ==========================Objects==================================
		 WebActions webActions = new WebActions();

	// ==========================Locators==================================
		 public static By insuredWebSite = By.xpath("//a[@id='tydeLink']");
		 public static By signIn = By.xpath("//a[text()='Sign In']");
		 public static By guest = By.xpath("//a[text()='Guest']");
		 public static By register = By.xpath("//a[text()='Register']");
		 public static By guestPolicyNumber = By.xpath("//input[@id='guestPolicyNumber']");
		 public static By guestZipCode = By.xpath("//input[@id='guestZipCode']");
		 public static By guestSignInButton = By.xpath("//button[text()='Guest Sign In']");
		 public static By policyPayment = By.xpath("//*[text()='Policy Payment']");
		 public static By signOut = By.xpath("//span[@id='logoutLinkContent']");
		 public static By clientID = By.xpath("//input[@id='clientId']");
		 public static By policyNumber = By.xpath("//input[@id='policyNumber']");
		 public static By zip = By.xpath("//input[@id='zipCode']");
		 public static By next = By.xpath("//button[text()='Next']");
		 public static By openClaim = By.xpath("//a[contains(text(),'Open a claim')]");
		 
		 public static By lookUp = By.xpath("//button[contains(text(),'Lookup')]");
		 
		 public static By firstName = By.xpath("//input[@id='firstName']");
		 public static By lastName = By.xpath("//input[@id='lastName']");
		 public static By userName = By.xpath("//input[@id='username']");
		 public static By password = By.xpath("//input[@id='password']");
		 public static By confirmPasword = By.xpath("//input[@id='passwordConfirmation']");
		 public static By registerButton = By.xpath("//button[contains(text(),'Register')]"); //user rigistration page
		 
		 public static By userPolicy = By.xpath("//a[contains(text(),'View Policy')]");
		 public static By documents = By.xpath("//a[contains(text(),'Documents')]");
		 public static By makePayment = By.xpath("//a[contains(text(),'Make a payment')]");
		 public static By claimHistory = By.xpath("//a[contains(text(),'Claim History')]");
		 
		 
		 
	


	/**
	 * =============================================================================
	 * Method: guestSignInAndSignOut | Author: Sunil | Date:27 jan 2021 | Description:
	 * signing In as guest and signing out | Parameters: none | Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 * @throws Exception
	 */		

   
	public void guestSignInAndSignOut() throws InterruptedException, IOException {
		
		webActions.Click(insuredWebSite, "click on insured Web Site");
		Thread.sleep(3000);
		webActions.Click(guest, "click on guests");
		webActions.sendKeys(guestPolicyNumber, "09900003599600");
		webActions.sendKeys(guestZipCode, "33704");
		Thread.sleep(2000);
		webActions.Click(guestSignInButton, "click on guest Sign in");
		webActions.waitForVisible(policyPayment);
		Thread.sleep(10000);
		ReportManager.logScreenshotInfo();
		webActions.Click(signOut, "sign Out");
		
	}
	

	/**
	 * =============================================================================
	 * Method: policyOverViewOpenClaim | Author: Sunil | Date:5th Feb 2021 | Description:
	 * signing In as guest and clicking on open Claim tab | Parameters: none | Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 * @throws Exception
	 */		
	
	public void policyOverViewOpenClaim() throws Exception{
		
		webActions.Click(insuredWebSite, "click on insured Web Site");
		Thread.sleep(3000);
		webActions.Click(guest, "click on guests");
		webActions.sendKeys(guestPolicyNumber, "4211516006480");
		webActions.sendKeys(guestZipCode, "78654");
		Thread.sleep(2000);
		webActions.Click(guestSignInButton, "click on guest Sign in");
		ReportManager.logScreenshotInfo();
		webActions.waitForVisible(openClaim);
		webActions.Click(openClaim, "Open a Claim");
		Thread.sleep(2000);
		ReportManager.logScreenshotInfo();
		
		
		
		
	}
	

	/**
	 * =============================================================================
	 * Method: registerInsuredWebSite | Author: Sunil | Date:5th Feb 2021 | Description:
	 * signing In as guest and signing out | Parameters: none | Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 * @throws Exception
	 */		

	public void registerInsuredWebSite() throws Exception {
		
		

		Properties prop = new Properties();
		FileReader rd = new FileReader("C:\\Users\\Sunil\\git\\WrightFlood\\Wrightflood\\Inputs.properties");
		prop.load(rd);
		System.out.println("value taken " + prop.getProperty("Inclined_policy"));	
		
		
		webActions.Click(insuredWebSite, "click on insured Web Site");
		Thread.sleep(3000);
		webActions.Click(register, "Register");
		webActions.sendKeys(policyNumber, prop.getProperty("Inclined_policy"));
		webActions.sendKeys(clientID, "5385449");
		webActions.sendKeys(zip, "33773");
		Thread.sleep(2000);
		webActions.Click(lookUp, "look Up");
		webActions.waitForVisible(firstName);
		webActions.clearAndSendKeys(firstName, "test");
		webActions.clearAndSendKeys(lastName, "test");
		webActions.clearAndSendKeys(userName, "morningtespmmddyyyy@weareflood.com");
		webActions.clearAndSendKeys(password, "sunil@123");
		webActions.clearAndSendKeys(confirmPasword, "sunil@123");
		webActions.waitForVisible(userPolicy);
		webActions.Click(documents, "Documents");
		Thread.sleep(2000);
		webActions.Click(makePayment, "Make Payment");
		Thread.sleep(2000);
		webActions.Click(claimHistory, "Claim history");
		Thread.sleep(2000);
		webActions.Click(signOut, "Sign Out");
		Thread.sleep(2000);
		webActions.Click(signIn, "Sign In");
		Thread.sleep(3000);
		ReportManager.logScreenshotInfo();
		Thread.sleep(1000);
		
		
		
	}
	
		
}
