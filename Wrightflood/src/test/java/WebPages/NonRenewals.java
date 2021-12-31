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
import org.testng.asserts.SoftAssert;

import com.mongodb.assertions.Assertions;

import Utilities.ReportManager;

public class NonRenewals extends PendingInsurance{
	
	// ==========================Objects==================================
	WebActions webActions = new WebActions();

// ==========================Locators==================================
	
	public static By nonRenewals = By.xpath("//a[@id='nonRenewalPolicies']");
	public static By firstNonRenewalPolicyNumber = By.xpath("//tbody/tr[1]/td[1]/a");
	public static By requestDeclarationPage = By.xpath("//li[@id='selectablePF']");
	public static By emailDeliveryMethod = By.xpath("//li[contains(.,'Email')]");
	public static By agentCheckbox = By.xpath("//input[@id='agentDecCopy']");
	public static By emailInputField = By.xpath("//input[@id='agentEmailAddress']");
	public static By sendButton = By.xpath("//button[@id='processTransactionButton']");
	public static By continueTransaction = By.xpath("//span[contains(.,'Continue Transaction')]");
	public static By exitTransaction = By.xpath("//span[contains(.,'Exit Transaction')]");
	
	/**
	 * =============================================================================
	 * Method: NonRenewalsProcess | Author: Samadrita Guha | Date:12 Oct 2020 | Description:
	 * Non renewals process | Parameters: none | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */		
	
	
	public void NonRenewalsProcess() throws Exception {
		
		webActions.Click(nonRenewals, "Non renewals");
		webActions.Click(firstNonRenewalPolicyNumber, "First policy number under non renewal policy numbers");
		Robot robot1=new Robot();
		robot1.delay(3000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		//webActions.Click(premiumDetail, "Premium details");
		webActions.Click(makeChanges, "Make changes button");
		Thread.sleep(2000);
		webActions.scrollDownUsingJS();
		webActions.Click(requestDeclarationPage, "Request declaration page");
		webActions.Click(beginTransaction, "Begin transaction button");
		webActions.Click(emailDeliveryMethod, "Delivery method - Email");
		webActions.Click(agentCheckbox, "Agent check box");
		webActions.clearAndSendKeys(emailInputField, "example@gmail.com");
		webActions.Click(sendButton, "Send button");
		//String actualMessage = DriverFactory.getInstance().getWebDriver().switchTo().alert().getText();
		//String actualMessage = DriverFactory.getInstance().getWebDriver().switchTo().alert().getText();
		//String expectedMessage = "Agent Declarations Page was sent successfully.";
		//webActions.verifyText(actualMessage, expectedMessage);
		webActions.Click(exitTransaction, "Exit transaction button");
		Thread.sleep(3000);
	}
	

}
