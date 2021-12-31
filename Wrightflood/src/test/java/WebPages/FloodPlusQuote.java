package WebPages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import WebUtil.WebActions;


public class FloodPlusQuote {
	
	// ==========================Objects==================================
			WebActions webActions = new WebActions();
			
	// ==========================Locators==================================
			public static By floodPlusQuote= By.xpath("//p//a[@href=\"/praesidium/app/flood_plus/initialize\"]");
			public static By waitingPeriod= By.xpath("//select[@id='waitingPeriod']");
			public static By waitingPeriodOptions= By.xpath("//select[@id='waitingPeriod']/option");
			public static By datePicker= By.xpath("//img[@class='ui-datepicker-trigger']");
			public static By effectiveDate= By.xpath("//input[@id='effectiveDate']");
			public static By insuredFirstName= By.xpath("//input[@id='insuredFirstName']");
			public static By insuredLastName= By.xpath("//input[@id='insuredLastName']");
			public static By propertyStreetAddress= By.xpath("//input[@id='propertyStreetAddress']");
			public static By propertyCity= By.xpath("//input[@id='propertyCity']");
			public static By propertyState= By.xpath("//select[@id='propertyState']");
			public static By propertyStateOptions= By.xpath("//select[@id='propertyState']/option");
			public static By propertyZipCode= By.xpath("//input[@id='propertyZipCode']");
			public static By sameMailingAddress= By.xpath("//input[@id='sameMailingAddress']");
			public static By dwellingReplacementCost= By.xpath("//input[@id='dwellingTiv']");
			public static By dwellingReplacementCostCheckbox= By.xpath("//input[@id='confirmRcv']");
			public static By personalPropertyLimit= By.xpath("//input[@id='personalPropertyTiv']");
			public static By personalPropertyCostValueType= By.xpath("//select[@id='personalPropertyCostValueType']");
			public static By buildingPurpose= By.xpath("//select[@id='buildingPurpose']");
			public static By buildingPurposeOptions= By.xpath("//select[@id='buildingPurpose']/option");
			public static By floodZone= By.xpath("//input[@id='floodZone']");
			public static By underConstructionNo= By.xpath("//input[@id='underConstructionNo']");
			public static By underConstructionYes= By.xpath("//input[@id='underConstructionYes']");
			public static By condoUnitYes= By.xpath("//input[@id='condoYes']");
			public static By condoUnitNo= By.xpath("//input[@id='condoNo']");
			public static By mobileHomeYes= By.xpath("//input[@id='mobileHomeYes']");
			public static By mobileHomeNo= By.xpath("//input[@id='mobileHomeNo']");
			public static By occupancy= By.xpath("//select[@id='occupancy']");
			public static By occupancyOptions= By.xpath("//select[@id='occupancy']/option");
			public static By constructionYear= By.xpath("//input[@id='yearBuilt']");
			public static By constructionType= By.xpath("//select[@id='construction']");
			public static By constructionTypeOptions= By.xpath("//select[@id='construction']/option");
			public static By numberOfFloors= By.xpath("//input[@id='noOfStories']");
			public static By floorArea= By.xpath("//input[@id='floorArea']");
			public static By elevatedBuildingYes= By.xpath("//input[@id='elevYes']");
			public static By elevatedBuildingNo= By.xpath("//input[@id='elevNo']");
			public static By foundationType= By.xpath("//select[@id='foundationType']");
			public static By foundationTypeOptions= By.xpath("//select[@id='foundationType']/option");
			public static By buildingOverWater= By.xpath("//select[@id='buildingOverWater']");
			public static By buildingOverWaterOptions= By.xpath("//select[@id='buildingOverWater']/option");
			public static By priorLossYes= By.xpath("//input[@id='priorLossYes']");
			public static By priorLossNo= By.xpath("//input[@id='priorLossNo']");
			public static By SubmitInFloodPlusQuote= By.xpath("//button[contains(.,'Submit')]");
			public static By basementSubgradeCrawlspaceNo= By.xpath("//input[@id='baseCrawlNo']");
			public static By generatedQuoteNumber= By.xpath("//table[@id='quoteSummaryTbl']//tbody//tr[1]//td[contains(.,'Quote Number: ')]//following-sibling::td");
			public static By dateOfQuoteGeneration= By.xpath("//table[@id='quoteSummaryTbl']//tbody//tr//td[contains(.,'Date of Quote')]//following-sibling::td");
			public static By quoteExpiryDate= By.xpath("//div[@id='floodLossMessage']//span");
			public static By selectOptionOne= By.xpath("//input[@value='Select Option 1']");
			
			
			
			/**
			 * =============================================================================
			 * Method: FloodPlus | Author: Samadrita Guha | Date:22 Aug 2020 | Description:
			 * Flood plus quote process | Parameters: username, password | Return: None
			 * =============================================================================
			 * 
			 * @throws Exception
			 */		
			
			  public void FloodPlus() throws Exception {
			    Thread.sleep(4000);
				webActions.Click(floodPlusQuote, "Flood plus quote");
				Thread.sleep(1000);
				webActions.selectByVisibleText(By.xpath("//select[@id='waitingPeriod']"), "Standard 7 Day Wait");
				Thread.sleep(1000);
				webActions.clearAndSendKeys(insuredFirstName, "Samadrita");
				webActions.clearAndSendKeys(insuredLastName, "Guha");
				webActions.clearAndSendKeys(propertyStreetAddress, "4328 10TH AVENUE NORTH");
				webActions.clearAndSendKeys(propertyCity, "ST. PETERSBURG");
				webActions.selectByVisibleText(By.xpath("//select[@id='propertyState']"), "FL");
				webActions.clearAndSendKeys(propertyZipCode, "33713");
				webActions.clearAndSendKeys(dwellingReplacementCost, "94500");
				webActions.Click(dwellingReplacementCostCheckbox, "Dwelling replacement cost checkbox");
				webActions.clearAndSendKeys(personalPropertyLimit, "47250");
				webActions.selectByVisibleText(By.xpath("//select[@id='personalPropertyCostValueType']"), "Replacement Cost Value (RCV)");
				webActions.selectByVisibleText(By.xpath("//select[@id='buildingPurpose']"), "Single Family");
				webActions.clearAndSendKeys(floodZone, "AE");
				webActions.Click(underConstructionNo, "Radio button no for under construction criteria");
				webActions.Click(condoUnitNo, "Radio button no for condo unit criteria");
				webActions.Click(mobileHomeNo, "Radio button no for mobile home criteria");
				webActions.selectByVisibleText(By.xpath("//select[@id='occupancy']"), "Primary");
				webActions.clearAndSendKeys(constructionYear, "2003");
				webActions.selectByVisibleText(By.xpath("//select[@id='construction']"), "Brick Veneer");
				webActions.clearAndSendKeys(numberOfFloors, "1");
				webActions.clearAndSendKeys(floorArea, "700");
				webActions.Click(elevatedBuildingNo, "Radio button no for elevated building criteria");
				webActions.selectByVisibleText(By.xpath("//select[@id='foundationType']"), "Foundation wall");
				webActions.Click(basementSubgradeCrawlspaceNo, "Radio button no for basement/subgrade Crawlspace criteria");
				webActions.selectByVisibleText(By.xpath("//select[@id='buildingOverWater']"), "No");
				webActions.Click(priorLossNo, "Radio button no for prior loss criteria");
				webActions.Click(SubmitInFloodPlusQuote, "Submit button for flood plus quote");
				Thread.sleep(7000);
				String floodPlusQuoteGenerated = webActions.getElmText(generatedQuoteNumber);
				System.out.println("Flood plus quote - " + floodPlusQuoteGenerated);
				String dateOfQuote = webActions.getElmText(dateOfQuoteGeneration);
				System.out.println("Date of flood plus quote generation - " + dateOfQuote);
				String expiryDate = webActions.getElmText(quoteExpiryDate);
				System.out.println("Expiry date of flood plus quote generation - " + quoteExpiryDate);
				webActions.Click(selectOptionOne, "Option One Full Value");
			}
				
			
			
			public void selectDate() throws Exception {
				Thread.sleep(3000);
				Date today = new Date();
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, 3);
				Date future = cal.getTime();
				System.out.println("Actual date is :" + future);
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				String futureDate = sdf.format(future);
				System.out.println("Future date set" + futureDate);
				String demo = "02/18/2020";
				webActions.sendKeys(effectiveDate, futureDate);
			}
			
			
			
}



	
	