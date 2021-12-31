package WebPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import Utilities.ReportManager;
import WebUtil.WebActions;

public class NegativeFlowZurichFlood extends ZurichFloodQuote{
	
	// ==========================Objects==================================
			WebActions webActions = new WebActions();

	   // ==========================Locators==================================

		
			public static By RiskIneligibleMessage= By.xpath("//h3[contains(.,'Risk Ineligible')]");
			public static By RiskIneligibleCloseButton= By.xpath("//button[contains(.,'Close')]");
			
			/**
			 * =============================================================================
			 * Method: ProcessZurichFloodQuote | Author: Samadrita Guha | Date:23 Sept 2020 | Description:
			 * ProcessingZurich Flood Quote | Parameters: none | Return: None
			 * =============================================================================
			 * 
			 * @throws Exception
			 */		
			
			
			public void NegativeFlowZurichFloodQuote() throws Exception {

				webActions.Click(zurichFloodQuote, "Zurich flood quote");
				Thread.sleep(2000);
				webActions.Click(datePicker, "Datepicker to choose date");
				Thread.sleep(2000);
				selectDate();
				webActions.selectByVisibleText(By.xpath("//select[@id='applicantType']"), "Individual");
				webActions.clearAndSendKeys(insuredFirstName, "Text");
				webActions.clearAndSendKeys(insuredLastName, "Text");
				webActions.clearAndSendKeys(mapLocation, "7305 124th Ave N");
				Robot robot1 = new Robot();
				robot1.delay(5000);
				robot1.keyPress(KeyEvent.VK_DOWN);
				robot1.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				//webActions.Click(riskIneligibleClose, "risk ineligible close button");
				webActions.Click(firstNextButton, "Next button");
				Thread.sleep(7000);
				webActions.clearAndSendKeys(yearBuilt, "2003");
				webActions.clearAndSendKeys(squareFeet, "700");
				webActions.selectByVisibleText(By.xpath("//select[@id='numberOfStories']"), "One Story");
				webActions.selectByVisibleText(By.xpath("//select[@id='constructionType']"), "Frame-Including Masonry/Veneer");
				webActions.selectByVisibleText(By.xpath("//select[@id='basement']"), "Basement");
				webActions.Click(basementContentsNo, "radio button no for property in basement coverage endorsement");
				webActions.Click(foundationVentsNo, "radio button no for presence of smart vents");
				webActions.Click(belowGroundElevation, "radio button for below ground elevation diagram");
				webActions.Click(priorLossNo, "radio button for no prior loss");
				Thread.sleep(3000);
				webActions.selectByVisibleText(By.xpath("//select[@id='coverageList0Deductible']"), "1000");
				Thread.sleep(3000);
				webActions.Click(firstNextButton, "Next button");
				Thread.sleep(3000);
				System.out.println("===========================ERRoR_MeSSagE================");
			    String ActualErrorMsg=webActions.getElmText(RiskIneligibleMessage);
			    String expectedErrorMessage = "Risk Ineligible"; 
			    webActions.verifyText(ActualErrorMsg, expectedErrorMessage);
			    Thread.sleep(3000);
			    ReportManager.logScreenshotInfo();
			    Thread.sleep(3000);
			    webActions.Click(RiskIneligibleCloseButton, "Risk Ineligible close button");
				

}
}
