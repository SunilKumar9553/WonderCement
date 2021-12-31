package WebPages;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class ExcessFloodProduct {
	

	// ==========================Objects==================================
	WebActions webActions = new WebActions();

	// ==========================Locators==================================
	public static By clickonnewquote = By.xpath("//*[@id=\"MainNewQte\"]");
	public static By excessFlood = By.xpath("//*[@id=\"XFLDButton\"]/img");
	public static By policyNumber = By.xpath("//*[@id='underlyingPolicyNumber']");
	public static By squateFootage = By.xpath("//*[@id='squareFootage']");
	public static By proceed = By.xpath("//*[@id='fldPolSearch']");
	public static By constructionType = By.xpath("//*[@id='constructionType']");
	public static By firstQuestion = By.xpath("//tr[@id='trG1']/td[2]/label[2]");
	public static By secondQuestion = By.xpath("//tr[@id='trG3']/td[2]/label[2]");
	public static By thirdQuestion = By.xpath("//tr[@id='trG4']/td[2]/label[2]");
	public static By fourthQuestion = By.xpath("//tr[@id='trG5']/td[2]/label[2]");
	public static By fifthQuestion = By.xpath("//tr[@id='trG6']/td[2]/label[2]");
	public static By sixthQuestion = By.xpath("//tr[@id='trG7']/td[2]/label[2]");
	public static By seventhQuestion = By.xpath("//tr[@id='trG10']/td[2]/label[2]");
	public static By eigthQuestion = By.xpath("//tr[@id='trG11']/td[2]/label[2]");
	public static By nextPage = By.xpath("//*[text()='Next Page']");
	public static By excessQuote = By.xpath("//a[@id='excessQuote']");
	public static By next = By.xpath("//*[@id=\"buttonContainer\"]/button");
	public static By licensedAgent = By.xpath("//select[@id='licensee']");
	public static By checkOption = By.xpath("//input[@id='CHECK']");
	public static By checkNumber = By.xpath("//input[@id='PCHKNO']");
	public static By payerAgent = By.xpath("//input[@id='PPYRCD-A']");
	public static By next2 = By.xpath("//*[@id=\"content\"]/button[2]");
	public static By documents = By.xpath("//a[@class='btn btn-success']");
	public static By excessPolicyNumber = By.xpath("//a[@class='btn btn-success']//following::strong[1]");
	public static By excessApplicationPdf = By.xpath("//a[@id='excessApplication']");	
	
	
	
	
	
	
	/**
	 * =============================================================================
	 * Method: excessFloodQuote | Author: Sunil | Date:4th Feb 2021 |
	 * Description: Creating excess flood quote | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * 
	 * 
	 * @throws Exception
	 */
	
	public void excessFloodQuote() throws Exception {
		
		
		
		
		Properties prop = new Properties();
		FileReader rd = new FileReader("C:\\Users\\Sunil\\git\\WrightFlood\\Wrightflood\\Inputs.properties");
		prop.load(rd);
		System.out.println("value taken " + prop.getProperty("policy"));	
		
		
		
		
		webActions.Click(clickonnewquote, "New Quote");
		webActions.Click(excessFlood, "Excess Flood");
		webActions.clearAndSendKeys(policyNumber, prop.getProperty("policy"));
		webActions.clearAndSendKeys(squateFootage, "2000");
		webActions.Click(proceed, "Proceed for Quote");
		Thread.sleep(3000);
		webActions.selectByVisibleText(constructionType, "Brick, Stone or Masonry");
		webActions.Click(firstQuestion, "No for first question");
		webActions.Click(secondQuestion, "No for second question");
		webActions.Click(thirdQuestion, "No for third question");
		webActions.Click(fourthQuestion, "No for fourth question");
		webActions.Click(fifthQuestion, "No for fifth question");
		webActions.Click(sixthQuestion, "No for sixth question");
		webActions.Click(seventhQuestion, "No for seventh question");
		webActions.Click(eigthQuestion, "No for eigth question");
		webActions.Click(next, "Next");
		webActions.waitForVisible(nextPage);
		webActions.Click(nextPage, "Next page");
		webActions.waitForVisible(licensedAgent);
		WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(licensedAgent);
		Select select = new Select(ele);
		select.selectByIndex(1);
		webActions.Click(checkOption, "Check");
	    webActions.clearAndSendKeys(checkNumber, "12345");
	    webActions.Click(payerAgent, "Agent");
	    webActions.scrollDownUsingJS();
	    webActions.Click(next2, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(excessPolicyNumber);
	    webActions.getElmText(excessPolicyNumber);
	    webActions.Click(excessApplicationPdf, "Excess Appliction");
		Thread.sleep(5000);
        webActions.switchTab();
		ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
		
		
		
	}

}
