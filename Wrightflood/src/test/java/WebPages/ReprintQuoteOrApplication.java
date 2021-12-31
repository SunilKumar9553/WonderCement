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


public class ReprintQuoteOrApplication {
	
	// ==========================Objects==================================
	WebActions webActions = new WebActions();

// ==========================Locators==================================
	public static By reprintQuoteOrApp = By.xpath("//a[contains(.,'Reprint Quote/App')]");
	public static By quoteRadioButton = By.xpath("//input[@id='SearchForQuote']");
	public static By searchBy = By.xpath("//select[@id='quoteSearchOptions']");
	public static By firstName = By.xpath("//input[@id='JFNAME']");
	public static By lastName = By.xpath("//input[@id='JLNAME']");
	public static By searchButton = By.xpath("//button[contains(.,'Search')]");
	//public static By firstQuoteResult = By.xpath("((//tbody[@class='page1']/tr)[1]/td)[1]");
	public static By firstQuoteResult = By.xpath("(//input[@name=\"Selector\"])[1]");
	public static By selectButton = By.xpath("//button[@title='Select']");
	
	
	public static By applicationRadioButton = By.xpath("//input[@id='SearchForApplication']");
	public static By searhByAppNumber = By.xpath("//select[@id='appSearchOptions']");
	public static By applicationNumber = By.xpath("//input[@id='JAPPNO']");
	
	
	/**
	 * =============================================================================
	 * Method: ReprintQuoteOrApplicationPDF | Author: Samadrita Guha | Date:8 Oct 2020 | Description:
	 * Reprinting quote details by providing quote number | Parameters: none | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */		
	
	
	public void ReprintQuoteOrApplicationPDF() throws Exception {

		webActions.Click(reprintQuoteOrApp, "Reprint quote or app");
		Thread.sleep(2000);
		webActions.Click(quoteRadioButton, "Quote radio button");
		Thread.sleep(2000);
		webActions.selectByVisibleText(By.xpath("//select[@id='quoteSearchOptions']"), "Individual Name");
		webActions.clearAndSendKeys(firstName, "test");
		webActions.clearAndSendKeys(lastName, "test");
		webActions.Click(searchButton, "Search button");
		webActions.Click(firstQuoteResult, "First quote result");
		Thread.sleep(5000);
		webActions.Click(selectButton, "Select button");
		webActions.scrollDownUsingJS();
		Thread.sleep(5000);
	}
	
	
	/**
	 * =============================================================================
	 * Method: RepringQuoteOrWithAppNumber | Author: Sunil | Date:27 jan 2021 |
	 * Description: Reprint the quote by providing the application number | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	public void ReprintQuoteOrAppWithAppNumber() throws Exception {
		
		webActions.Click(reprintQuoteOrApp, "Reprint quote or app");
		Thread.sleep(2000);
		webActions.Click(applicationRadioButton, "select Application radio button");
		//webActions.Click(searhByAppNumber, "select Application number option");
		webActions.selectByVisibleText(searhByAppNumber, "Application Number");
		webActions.clearAndSendKeys(applicationNumber, "727-867-5309");
		webActions.Click(searchButton, "Search button");
		Thread.sleep(3000);
		webActions.Click(firstQuoteResult, "First quote result");
		Thread.sleep(5000);
		webActions.Click(selectButton, "Select button");
		webActions.scrollDownUsingJS();
		Thread.sleep(5000);
		
		
	}

}
