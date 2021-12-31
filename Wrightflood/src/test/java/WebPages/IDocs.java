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

public class IDocs {
	
	// ==========================Objects==================================
				WebActions webActions = new WebActions();

	   // ==========================Locators==================================
				public static By iDocs = By.xpath("//a[contains(.,'iDocs')]");
				public static By firstDocOfList = By.xpath("//ul[@class='unstyled']/li[1]/a");
				public static By firstDocument = By.xpath("//ul[@class='unstyled']/li[1]/a");
				
				
				/**
				 * =============================================================================
				 * Method: IDocsInfo | Author: Samadrita Guha | Date:2 Oct 2020 | Description:
				 * iDocs of policies from the application | Parameters: none | Return: None
				 * =============================================================================
				 * 
				 * @throws Exception
				 */		
				
				
				public void IDocsInfo() throws Exception {

					webActions.Click(iDocs, "iDocs");
					Thread.sleep(2000);
					webActions.Click(firstDocOfList, "First iDoc in iDocs list");
					Thread.sleep(2000);
					webActions.Click(firstDocument, "First pdf i-document");
					webActions.scrollDownUsingJS();
					Thread.sleep(15000);
				}
				
				
				

}
