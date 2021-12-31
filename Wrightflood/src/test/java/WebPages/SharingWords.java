package WebPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
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

public class SharingWords {
	
	// ==========================Objects==================================
			WebActions webActions = new WebActions();

	   // ==========================Locators==================================

			public static By bulletinBoard = By.xpath("//a[contains(.,'Bulletin Board')]");
			public static By sharingWords = By.xpath("//a[contains(.,'Sharing Words')]");
			public static By nameField = By.xpath("//input[@id='nameField']");
			public static By commentField = By.xpath("//textarea[@id='sharedWords']");
			public static By sendToWrightFlood = By.xpath("//button[@title='send email to Wright Flood']");
			public static By continueTransaction = By.xpath("//span[contains(.,'Continue Transaction')]");
			public static By exitTransaction = By.xpath("//span[contains(.,'Exit Transaction')]");
			
			/**
			 * =============================================================================
			 * Method: processSharingWords | Author: Samadrita Guha | Date:12 Oct 2020 | Description:
			 * Sharing words process | Parameters: none | Return: None
			 * =============================================================================
			 * 
			 * @throws Exception
			 */		
			
			public void processSharingWords() throws Exception {
				
				webActions.Click(bulletinBoard, "Bulletin board");
				Thread.sleep(5000);
				webActions.Click(sharingWords, "Sharing words");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(nameField, "test");
				webActions.clearAndSendKeys(commentField, "test");
				webActions.Click(sendToWrightFlood, "Send to Wright Flood Button");
				Thread.sleep(2000);
				Robot robot1 = new Robot();
				robot1.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(5000);
				String actualMessage = DriverFactory.getInstance().getWebDriver().switchTo().alert().getText();
				String expectedMessage = "Your message has been sent.";
				webActions.verifyText(actualMessage, expectedMessage);
				Thread.sleep(4000);
				robot1.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(5000);
				
						
				
			}
}

