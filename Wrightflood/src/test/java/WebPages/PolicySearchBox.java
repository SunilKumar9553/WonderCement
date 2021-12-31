package WebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;

import Utilities.ReportManager;
import WebUtil.WebActions;

public class PolicySearchBox {

	// ==========================Objects==================================
	WebActions webActions = new WebActions();
	

	// ==========================Locators==================================
	public static By searchBox = By.xpath("//input[@id='quickSearchText']");
	public static By openaClaim = By.xpath("//a[@id='InquiryOpnClm']");
	public static By clientId = By.xpath("//*[@id=\"content\"]/div[1]/div[1]/table/tbody/tr[10]/td");

	/**
	 * =============================================================================
	 * Method: searchPolicyFromSearchBox | Author: Sunil | Date:27 jan 2021 |
	 * Description: opening policy from search Box | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */

	public void searchPolicyFromSearchBox() throws Exception {

		
		Properties prop = new Properties();
		FileReader rd = new FileReader("C:\\Users\\Sunil\\git\\WrightFlood\\Wrightflood\\Inputs.properties");
		prop.load(rd);
		System.out.println("value taken " + prop.getProperty("Inclined_policy"));	
		
		
		webActions.sendKeys(searchBox, prop.getProperty("Inclined_policy"));
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		ReportManager.logScreenshotInfo();
		Thread.sleep(4000);
		String client_id = webActions.getElmText(clientId);
		System.out.println("Client id is :  " + client_id);
		
		Properties prop1 = new Properties();
		FileOutputStream stream = new FileOutputStream("C:\\Users\\Sunil\\git\\WrightFlood\\Wrightflood\\Inputs.properties"); 
		prop1.setProperty("ClientId", client_id);
		prop1.save(stream, "Writing Client Id");
		
	}
	
	/**
	 * =============================================================================
	 * Method: searchPolicyFromSearchBoxwithName | Author: Sunil | Date:27 jan 2021 |
	 * Description: open policy from search Box with policy name | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */

	public void searchPolicyFromSearchBoxwithName() throws Exception {

		webActions.sendKeys(searchBox, "test");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		ReportManager.logScreenshotInfo();
		Thread.sleep(4000);
	}
	
	
	/**
	 * =============================================================================
	 * Method: claimInfrmtnPageFromSearchBox | Author: Sunil | Date:27 jan 2021 |
	 * Description: opening Claim information page after opening the policy from search box | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */

	public void claimInfrmtnPageFromSearchBox() throws Exception {
		webActions.sendKeys(searchBox, "099000033469 00");
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		webActions.Click(openaClaim, "click on open a claim");
		ReportManager.logScreenshotInfo();
		Thread.sleep(4000);
	}

}
