package WebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class InclineFlood {
	
	// ==========================Objects==================================
		WebActions webActions = new WebActions();

		// ==========================Locators==================================
		
		public static By newQuote = By.xpath("//a[@id='MainNewQte']");	
		public static By inclineFlood = By.xpath("(//div[@id='HFLDProduct']/a)[3]");
		public static By effectiveDatePicker = By.xpath("//input[@id='effectiveDate']//following::img[1]");
		public static By applicationType = By.xpath("//select[@id='applicantType']");
		public static By firstName = By.xpath("//input[@id='insuredFirstName']");
		public static By lastName = By.xpath("//input[@id='insuredLastName']");
		public static By dwellingLimit = By.xpath("//input[@id='amountOfInsurance']");
		public static By mapLocation = By.xpath("//input[@id='pac-input']");
		public static By state = By.xpath("//input[@id='state']"); //TX
		public static By nextButton = By.xpath("//button[@id='nextButton1']");
		public static By yearBuilt = By.xpath("//input[@id='yearBuilt']"); //1962
		public static By squareFeet = By.xpath("//input[@id='squareFeet']"); //1496
		public static By noofStories = By.xpath("//select[@id='numberOfStories']");//One Story
		public static By constructionType = By.xpath("//select[@id='constructionType']"); //Brick, Stone, or Masonry
		public static By enclosure = By.xpath("//select[@id='basement']");
		public static By floodZone = By.xpath("//select[@id='floodZone']"); //AE Zone
		public static By hasSmartVents = By.xpath("//input[@id='foundationVentsNo']");
		public static By diagram1 = By.xpath("//input[@id='diag1']");
		public static By anyFloodLoss = By.xpath("//input[@id='priorLossNo']");
		public static By deductible = By.xpath("//select[@id='coverageList0Deductible']");
		public static By firstQuestion = By.xpath("//input[@id='question0No']");
		public static By secondQuestion = By.xpath("//input[@id='question1No']");
		public static By thirdQuestion = By.xpath("//input[@id='question2No']");
		public static By fourthQuestion = By.xpath("//input[@id='question3No']");
		public static By fifthQuestion = By.xpath("//input[@id='question4No']");
		public static By sixthQuestion = By.xpath("//input[@id='question5No']");
		public static By seventhQuestion = By.xpath("//input[@id='question6No']");
		public static By eigthQuestion = By.xpath("//input[@id='question7Yes']");
		public static By doucments = By.xpath("//div[@id='appDocumentNotifierContainer']");
		public static By quotePDF = By.xpath("//a[@id='marketplaceQuote']");
		
		public static By addLender = By.xpath("//button[@id='addLenderButton']");
		public static By lenderTitle = By.xpath("//table/tbody/tr[2]/td[1]");
		public static By lenderType = By.xpath("//select[@id='lenderTypeCode']");
		public static By billToLender = By.xpath("//input[@id='billToLender-Y']");
		public static By financialInterest = By.xpath("//select[@id='lenderInterestCode']");
	    public static By loanNumber = By.xpath("//input[@id='loanNbr']");
	    public static By nextInPayment = By.xpath("//*[@id=\"nextButton\"]");
		public static By sameMailingAddressYes = By.xpath("//input[@id='sameMailingAddressYes']");
		public static By noofFamilies = By.xpath("//select[@id='numberOfFamilies']");
		public static By foundationType = By.xpath("//select[@id='foundationType']");
		public static By licensedAgent = By.xpath("//select[@id='licensee']");
		public static By paidInFull = By.xpath("//input[@id='payCodeA1']");
		public static By partyResponsibleForPay = By.xpath("//select[@id='payorIndicator']");
		public static By achUpload = By.xpath("//input[@id='ach']");
		public static By sweepWaitingPeriod = By.xpath("//select[@id='sweepWaitingPeriod']");
		public static By bank = By.xpath("//select[@id='achInformation']");
		public static By submitPayment = By.xpath("//button[@id='submitPayment']");
		public static By generatedPolicyNumber = By.xpath("//div[@id='appDocumentNotifierContainer']//following::strong[1]");
		public static By applicationPdf = By.xpath("//a[@id='marketplaceApplication']");
		
		public static By entityName = By.xpath("//input[@id='businessName']");
		public static By diagram2 = By.xpath("//input[@id=\"diag2\"]");
		
		public static By anyFloodLossYes = By.xpath("//input[@id='priorLossYes']");
		public static By damageRepairedYes = By.xpath("//input[@id='repairedAfterLossYes']");
		public static By dateOfLoss = By.xpath("//input[@id='dateOfLoss']");
		public static By amountOfLoss = By.xpath("//input[@id='lossValue']");
		public static By addClaim = By.xpath("//input[@id='addClaim']");
		
		
		/* 
		 * 
		 * 
		 * 7754 BUENA VISTA STREET

             HOUSTON, TX 77087

 

              2105 SHIRLEY LANE

              LA PORTE, TX 77571

 

               62 SOUTH BACHELOR BUTTON STREET

                 LAKE JACKSON, TX 77566*/
		
		
		/**
		 * =============================================================================
		 * Method: inclineFloodQuote | Author: Sunil | Date:5th Feb 2021 |
		 * Description: Creating the Incline Flood Quote | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */
		

		
		
		public void inclineFloodQuote() throws Exception {
			
			webActions.Click(newQuote, "New Quote");
			webActions.Click(inclineFlood, "Incline Flood");
			webActions.Click(effectiveDatePicker, "Date picker");
			Thread.sleep(2000);
		    
		    Date date=java.util.Calendar.getInstance().getTime();
			int today = date.getDate();
			By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
	        webActions.Click(xpathofTodaysDate, "Date");
	        webActions.selectByVisibleText(applicationType, "Individual");
	        webActions.sendKeys(firstName, "test");
	        webActions.sendKeys(lastName, "test");
	        //webActions.sendKeys(dwellingLimit, "250000");
	        webActions.scrollDownUsingJS();
	        
	        webActions.clearAndSendKeys(mapLocation, "7754 BUENA VISTA STREET HOUSTON, TX 77087");
			Robot robot1 = new Robot();
			robot1.delay(5000);
			robot1.keyPress(KeyEvent.VK_DOWN);
			robot1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
	        webActions.clearAndSendKeys(state, "TX");
	        webActions.Click(nextButton, "Next");
	        webActions.waitForVisible(yearBuilt);
	        webActions.clearAndSendKeys(yearBuilt, "1962");
	        webActions.clearAndSendKeys(squareFeet, "1496");
	        webActions.selectByVisibleText(noofStories, "One Story");
	        webActions.selectByVisibleText(constructionType, "Brick, Stone, or Masonry");
	        webActions.selectByVisibleText(enclosure, "None");
	        webActions.selectByVisibleText(floodZone, "AE Zone");
	        webActions.Click(hasSmartVents, "Has smart Vents");
	        webActions.Click(diagram1, "Diagram 1 below ground elevation");
	        webActions.Click(anyFloodLoss, "no for prior flood losses");
	        webActions.selectByVisibleText(deductible, "1000");
	        webActions.Click(nextButton, "Next");
	        webActions.waitForVisible(firstQuestion);
	        webActions.Click(firstQuestion, "No for First question");
	        webActions.Click(secondQuestion, "No for Second question");
	        webActions.Click(thirdQuestion, "No for Third Question");
	        webActions.Click(fourthQuestion, "No for fourthQuestion");
	        webActions.Click(fifthQuestion, "No for FifthQuestion");
	        webActions.Click(sixthQuestion, "No for sixthQuestion");
	        webActions.Click(seventhQuestion, "No for seventhQuestion");
	        webActions.Click(eigthQuestion, "Yes for EighthQuestion");
	        webActions.Click(nextButton, "Next");
	        webActions.waitForVisible(nextButton);
	  
//	        Thread.sleep(2000);
//		    webActions.Click(addLender, "Add Lender"); //payment page
//		    webActions.scrollDownUsingJS();
//		    webActions.Click(lenderTitle, "Lender Name");
//		    webActions.waitForVisible(lenderType);
//		    webActions.selectByVisibleText(lenderType, "First Mortgagee");
//		    webActions.Click(billToLender, "Yes for Bill To Lender");
//		    webActions.clearAndSendKeys(loanNumber, "45242");
//		    webActions.scrollDownUsingJS();
//		    webActions.Click(nextInPayment, "Next");
//		    Thread.sleep(3000);
		    
		    
		    webActions.Click(nextButton, "Next");
	        webActions.Click(sameMailingAddressYes, "yes for same mail address");
	        webActions.selectByVisibleText(noofFamilies, "Two Families");
	        webActions.selectByVisibleText(foundationType, "Fill or Crawlspace");
	        webActions.Click(nextButton, "Next");
	        
	        WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(licensedAgent);
	        Select select = new Select(ele);
	        select.selectByIndex(1);
	        //webActions.selectByVisibleText(licensedAgent, "ADD NEW AGENT LICENSE - 854444588");
	        webActions.Click(paidInFull, "Paid In Full");
	        webActions.selectByVisibleText(partyResponsibleForPay, "Insured");
	        webActions.Click(achUpload, "ACH(Upload)");
	        webActions.selectByVisibleText(sweepWaitingPeriod, "0 Days");
	        webActions.selectByVisibleText(bank, "*********2222|63000021");
	        webActions.Click(submitPayment, "Submit Payment");
	        webActions.waitForVisible(generatedPolicyNumber);
	        String policy_number = webActions.getElmText(generatedPolicyNumber);
	        
	        
	        Properties prop = new Properties();
			FileOutputStream stream = new FileOutputStream("C:\\Users\\Sunil\\git\\WrightFlood\\Wrightflood\\Inputs.properties"); 
			prop.setProperty("Inclined_policy", policy_number);
			prop.save(stream, "Writing PolicyNumber");
			System.out.println("Policy Number is :  " + prop.get("Inclined_policy"));
	        
	        
	        Thread.sleep(2000);
	        ReportManager.logScreenshotInfo();
	        webActions.Click(doucments, "Available Documents");
	        webActions.Click(applicationPdf, "Quote PDF");
	        webActions.switchTab();
	        Thread.sleep(2000);
	        ReportManager.logScreenshotInfo();
	        Thread.sleep(10000);
	        
	        
		}
		
		/**
		 * =============================================================================
		 * Method: inclineFloodQuote | Author: Sunil | Date:25th Feb 2021 |
		 * Description: Creating the Incline Flood Quote with different options than above one | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */
		
		
		
		
		public void inclinedQuote2() throws Exception{
			
			webActions.Click(newQuote, "New Quote");
			webActions.Click(inclineFlood, "Incline Flood");
			webActions.Click(effectiveDatePicker, "Date picker");
			Thread.sleep(2000);
		    
		    Date date=java.util.Calendar.getInstance().getTime();
			int today = date.getDate();
			By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
	        webActions.Click(xpathofTodaysDate, "Date");
	        webActions.selectByVisibleText(applicationType, "Trust");
	        webActions.clearAndSendKeys(entityName, "abc");
	        webActions.scrollDownUsingJS();
	        webActions.clearAndSendKeys(mapLocation, "7754 BUENA VISTA STREET HOUSTON, TX 77087");
	        Robot robot1 = new Robot();
			robot1.delay(5000);
			robot1.keyPress(KeyEvent.VK_DOWN);
			robot1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
	       
	        webActions.Click(nextButton, "Next");
	        webActions.waitForVisible(yearBuilt);
	        webActions.clearAndSendKeys(yearBuilt, "1962");
	        webActions.clearAndSendKeys(squareFeet, "1496");
	        webActions.selectByVisibleText(noofStories, "Two Stories");
	        webActions.selectByVisibleText(constructionType, "Frame-Including Masonry/Veneer");
	        webActions.selectByVisibleText(enclosure, "Enclosure");
	        webActions.selectByVisibleText(floodZone, "AE Zone");
	        webActions.Click(hasSmartVents, "Has smart Vents");
	        webActions.Click(diagram2, "0 to 1ft above the ground diagram");
	        webActions.Click(anyFloodLoss, "No for prior flood losses");
	        webActions.selectByVisibleText(deductible, "2000");
	        webActions.Click(nextButton, "Next");
	        
	        webActions.waitForVisible(firstQuestion);
	        webActions.Click(firstQuestion, "No for First question");
	        webActions.Click(secondQuestion, "No for Second question");
	        webActions.Click(thirdQuestion, "No for Third Question");
	        webActions.Click(fourthQuestion, "No for fourthQuestion");
	        webActions.Click(fifthQuestion, "No for FifthQuestion");
	        webActions.Click(sixthQuestion, "No for sixthQuestion");
	        webActions.Click(seventhQuestion, "No for seventhQuestion");
	        webActions.Click(eigthQuestion, "Yes for EighthQuestion");
	        webActions.Click(nextButton, "Next");
	        webActions.waitForVisible(nextButton);
	        
	        webActions.Click(nextButton, "Next");
	        webActions.Click(sameMailingAddressYes, "yes for same mail address");
	        webActions.selectByVisibleText(noofFamilies, "Two Families");
	        webActions.selectByVisibleText(foundationType, "Fill or Crawlspace");
	        webActions.Click(nextButton, "Next");
	        WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(licensedAgent);
	        Select select = new Select(ele);
	        select.selectByIndex(1);
	        //webActions.selectByVisibleText(licensedAgent, "ADD NEW AGENT LICENSE - 854444588");
	        webActions.Click(paidInFull, "Paid In Full");
	        webActions.selectByVisibleText(partyResponsibleForPay, "Insured");
	        webActions.Click(achUpload, "ACH(Upload)");
	        webActions.selectByVisibleText(sweepWaitingPeriod, "0 Days");
	        webActions.selectByVisibleText(bank, "*********2222|63000021");
	        webActions.Click(submitPayment, "Submit Payment");
	        webActions.waitForVisible(generatedPolicyNumber);
	        webActions.getElmText(generatedPolicyNumber);
	        Thread.sleep(2000);
	        ReportManager.logScreenshotInfo();
	        webActions.Click(doucments, "Available Documents");
	        webActions.Click(applicationPdf, "Quote PDF");
	        webActions.switchTab();
	        Thread.sleep(2000);
	        ReportManager.logScreenshotInfo();
	        Thread.sleep(1000);
	        
			
		}
		
		
		

		/**
		 * =============================================================================
		 * Method: inclineFloodQuoteScenario3 (Prior Flood Loss)| Author: Sunil | Date:6th March 2021 |
		 * Description: Creating the Incline Flood Quote with different options than above one | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */
		
		public void inclinedQuoteScenario3() throws Exception{
			
			
			webActions.Click(newQuote, "New Quote");
			webActions.Click(inclineFlood, "Incline Flood");
			webActions.Click(effectiveDatePicker, "Date picker");
			Thread.sleep(2000);
		    
		    Date date=java.util.Calendar.getInstance().getTime();
			int today = date.getDate();
			By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
	        webActions.Click(xpathofTodaysDate, "Date");
	        webActions.selectByVisibleText(applicationType, "Individual");
	        webActions.sendKeys(firstName, "test");
	        webActions.sendKeys(lastName, "test");
	        //webActions.sendKeys(dwellingLimit, "250000");
	        webActions.scrollDownUsingJS();
	        webActions.clearAndSendKeys(mapLocation, "7305 124th Ave N");
			Robot robot1 = new Robot();
			robot1.delay(5000);
			robot1.keyPress(KeyEvent.VK_DOWN);
			robot1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
	        webActions.clearAndSendKeys(state, "TX");
	        webActions.Click(nextButton, "Next");
	        webActions.waitForVisible(yearBuilt);
	        webActions.clearAndSendKeys(yearBuilt, "1962");
	        webActions.clearAndSendKeys(squareFeet, "1496");
	        webActions.selectByVisibleText(noofStories, "One Story");
	        webActions.selectByVisibleText(constructionType, "Brick, Stone, or Masonry");
	        webActions.selectByVisibleText(enclosure, "None");
	        webActions.selectByVisibleText(floodZone, "AE Zone");
	        webActions.Click(hasSmartVents, "Has smart Vents");
	        webActions.Click(diagram1, "Diagram 1 below ground elevation");
	        webActions.Click(anyFloodLossYes, "yes for prior flood loss");
	        webActions.clearAndSendKeys(dateOfLoss, "01/01/2015");
	        webActions.clearAndSendKeys(amountOfLoss, "1000000");
	        webActions.Click(addClaim, "Add claim"); //adding claim
	        webActions.selectByVisibleText(deductible, "1000");
	        webActions.Click(nextButton, "Next");
	        
	        webActions.waitForVisible(firstQuestion);
	        webActions.Click(firstQuestion, "No for First question");
	        webActions.Click(secondQuestion, "No for Second question");
	        webActions.Click(thirdQuestion, "No for Third Question");
	        webActions.Click(fourthQuestion, "No for fourthQuestion");
	        webActions.Click(fifthQuestion, "No for FifthQuestion");
	        webActions.Click(sixthQuestion, "No for sixthQuestion");
	        webActions.Click(seventhQuestion, "No for seventhQuestion");
	        webActions.Click(eigthQuestion, "Yes for EighthQuestion");
	        webActions.Click(nextButton, "Next");
	        webActions.waitForVisible(nextButton);
	        
	        webActions.Click(nextButton, "Next");
	        webActions.Click(sameMailingAddressYes, "yes for same mail address");
	        webActions.selectByVisibleText(noofFamilies, "Two Families");
	        webActions.selectByVisibleText(foundationType, "Fill or Crawlspace");
	        webActions.Click(nextButton, "Next");
	        
	        WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(licensedAgent);
	        Select select = new Select(ele);
	        select.selectByIndex(1);
	        
	        //webActions.selectByVisibleText(licensedAgent, "ADD NEW AGENT LICENSE - 854444588");
	        webActions.Click(paidInFull, "Paid In Full");
	        webActions.selectByVisibleText(partyResponsibleForPay, "Insured");
	        webActions.Click(achUpload, "ACH(Upload)");
	        webActions.selectByVisibleText(sweepWaitingPeriod, "0 Days");
	        webActions.selectByVisibleText(bank, "*********2222|63000021");
	        webActions.Click(submitPayment, "Submit Payment");
	        webActions.waitForVisible(generatedPolicyNumber);
	        webActions.getElmText(generatedPolicyNumber);
	        Thread.sleep(2000);
	        ReportManager.logScreenshotInfo();
	        webActions.Click(doucments, "Available Documents");
	        webActions.Click(applicationPdf, "Quote PDF");
	        webActions.switchTab();
	        Thread.sleep(2000);
	        ReportManager.logScreenshotInfo();
	        Thread.sleep(1000);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
