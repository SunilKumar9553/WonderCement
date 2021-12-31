package WebPages;

import java.io.IOException;

import org.openqa.selenium.By;

import Utilities.ReportManager;
import WebUtil.WebActions;

public class NegativeFlowClaimSearch {
	
	// ==========================Objects==================================
			WebActions webActions = new WebActions();

		// ==========================Locators==================================
			
			public static By search = By.xpath("//a[contains(.,'Search')]");
			public static By ClaimSearch = By.xpath("//a[contains(.,'Claim Search')]");
			public static By ClaimNumber = By.xpath("//input[@id='searchByClaimNumber']");
			public static By searchButton = By.xpath("//button[@id='searchButton']");
			public static By claimNumberValue = By.xpath("//input[@id='claimNumber']");
			public  static By ClaimErrorMsg=By.xpath(".//h2[contains(.,'No records found.')]");
			/**
			 * =============================================================================
			 * Method: ClaimSearchProcess | Author: Anilkumar Ch | Date:24 Nov 2020 | Description:
			 * Searching Claims with invalid Claims number | Parameters: none | Return: None
			 * =============================================================================
			 * @throws InterruptedException 
			 * @throws IOException 
			 * 
			 * @throws Exception
			 */		
			

			public void NegativeFlowClaimSearchProcess() throws InterruptedException, IOException {
				// TODO Auto-generated method stub
				
				webActions.Click(search, "Search");
				Thread.sleep(2000);
				webActions.Click(ClaimSearch, "Claim Search");
				webActions.Click(ClaimNumber, "ClaimNumber");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(claimNumberValue, "123234312");
				Thread.sleep(1000);
				webActions.Click(searchButton, "Search button");
				Thread.sleep(1000);
				System.out.println("===========================ERRoR_MeSSagE================");
			    String ActualErrorMsg=webActions.getElmText(ClaimErrorMsg);
			    String expectedErrorMessage = "No records found."; 
			    webActions.verifyText(ActualErrorMsg, expectedErrorMessage);
			    Thread.sleep(1000);
			    ReportManager.logScreenshotInfo();
			    Thread.sleep(1000);
				//System.out.println(ClaimErrorMsgs);		
				System.out.println("===========================ERRoR_MeSSagE================");
			}

}
