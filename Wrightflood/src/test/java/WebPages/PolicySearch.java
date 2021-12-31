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

public class PolicySearch {
	
	// ==========================Objects==================================
				WebActions webActions = new WebActions();

		   // ==========================Locators==================================
				
				public static By search = By.xpath("//a[contains(.,'Search')]");
				public static By policySearch = By.xpath("//a[contains(.,'Policy Search')]");
				public static By searchBy = By.xpath("//select[@id='searchBy']");//policy number
				public static By policyNumber = By.xpath("//input[@id='policyNumber']");//04115149733802
				public static By searchButton = By.xpath("//button[@id='searchButton']");
				public static By policyNumberValue = By.xpath("//td[@id='dspPolNbr']");
				
				/**
				 * =============================================================================
				 * Method: PolicySearchProcess | Author: Samadrita Guha | Date:6 Oct 2020 | Description:
				 * Searching policies with policy number | Parameters: none | Return: None
				 * =============================================================================
				 * 
				 * @throws Exception
				 */		
				
				
				public void PolicySearchProcess() throws Exception {

					webActions.Click(search, "Search");
					Thread.sleep(2000);
					webActions.Click(policySearch, "Policy search");
					webActions.selectByVisibleText(By.xpath("//select[@id='searchBy']"), "Policy Number");
					webActions.clearAndSendKeys(policyNumber, "04115149733802");
					webActions.Click(searchButton, "Search button");
					String actualValue = webActions.getElmText(policyNumberValue);
					String expectedValue = "04115149733802";
					webActions.verifyText(actualValue, expectedValue);
					Thread.sleep(5000);
				}	

}
