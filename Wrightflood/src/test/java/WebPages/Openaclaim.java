package WebPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class Openaclaim {

	//==========================Objects==================================
	WebActions webActions = new WebActions();

	
	//==========================Locators==================================
	public static By clickonOpenacliambutton = By.xpath("//*[@id=\"MainOpnClm\"]");
	public static By selectpolicy = By.xpath("//*[@id=\"searchBy\"]");
	public static By enterPolicynumber = By.xpath("//*[@id=\"policyNumber\"]"); // 09 SFA0003476 01 policy munber
	public static By clickonsearch = By.xpath("//*[@id=\"searchButton\"]");
	public static By dateofloss = By.xpath("//*[@id=\"JLSSDT\"]");
	public static By prmiaryphone = By.xpath("//*[@id=\"JRCELLX\"]");
	public static By waterheight = By.xpath("//*[@id=\"JWTRHT\"]"); // 09 SFA0003476 01 policy munber
	public static By floodevent = By.xpath("//*[@id=\"divCatLoss\"]/select");
	public static By legderinformation = By.xpath("//*[@id=\"lender-change-no\"]");
	public static By submit = By.xpath("//*[@id=\"cmdSave\"]");
	public static By comments = By.xpath("//*[@id=\"comments\"]");

	
	/**
	 * =============================================================================
	 * Method: claim | Author: Rajesh Buddha | Date:15 Aug 2020 |
	 * Description: open a claim for policy | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	public void claim(String policynumber, String date) throws Exception {

		webActions.Click(clickonOpenacliambutton, "Open a cliam button");
		webActions.Click(selectpolicy, "select policy");
		webActions.selectByVisibleText(By.xpath("//*[@id='searchBy']"), "Policy Number");
		webActions.sendKeys(enterPolicynumber, policynumber);
		webActions.Click(clickonsearch, "click on search");
		webActions.sendKeys(dateofloss, date);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		js.executeScript("scroll(0, 600);");
		webActions.sendKeys(prmiaryphone, "4084667285");
		webActions.Click(waterheight, "water height");
		webActions.selectByVisibleText(By.xpath("//*[@id='JWTRHT']"), "1-2 Feet");
		webActions.Click(floodevent, "flood event");
		Thread.sleep(5000);
		webActions.selectByVisibleText(By.xpath("//*[@id='divCatLoss']/select"), "4TH QTR 10/1-12/31");
		webActions.Click(legderinformation, "legder information");
		webActions.sendKeys(comments, "please open a claim");
		webActions.Click(submit, "submit");

	}
	
	
	/**
	 * =============================================================================
	 * Method: claimInformationPage | Author: Sunil | Date:27 jan 2021 |
	 * Description: open claim information page for policy | Parameters: String |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	public void claimInformationPage(String policynumber) throws Exception {
		
		webActions.Click(clickonOpenacliambutton, "Open a cliam button");
		webActions.Click(selectpolicy, "select policy");
		webActions.selectByVisibleText(By.xpath("//*[@id='searchBy']"), "Policy Number");
		webActions.sendKeys(enterPolicynumber, policynumber);
		webActions.Click(clickonsearch, "click on search");
		ReportManager.logScreenshotInfo();
		Thread.sleep(3000);
		
	}
	
}
