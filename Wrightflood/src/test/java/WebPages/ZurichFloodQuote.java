package WebPages;

import java.awt.AWTException;
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



public class ZurichFloodQuote extends Reports{
	
	// ==========================Objects==================================
		WebActions webActions = new WebActions();

   // ==========================Locators==================================

		public static By zurichFloodQuote = By.xpath("//p//a[@href='/praesidium/app/marketplace/?command=initialize']");
		//effective date from flood plus product
		public static By applicantType = By.xpath("//select[@id='applicantType']");
		public static By datePicker = By.xpath("//img[@class='ui-datepicker-trigger']");
		public static By dwellingLimit = By.xpath("//input[@id='amountOfInsurance']");
		public static By mapLocation = By.xpath("//input[@id='pac-input']");//7305 124th Ave N, Largo, FL 33773, USA
		public static By map = By.xpath("//div[@id=\"map\"]");
		//public static By LocationInMap = By.xpath("(//img[@src=\"https://maps.gstatic.com/mapfiles/api-3/images/spotlight-poi2.png\"])[1]");
		public static By LocationInMap = By.cssSelector("#map > div > div > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > img");
		public static By firstNextButton = By.xpath("//button[@id='nextButton1']");
		public static By yearBuilt = By.xpath("//input[@id='yearBuilt']");
		public static By squareFeet = By.xpath("//input[@id='squareFeet']");
		public static By noOfStories = By.xpath("//select[@id='numberOfStories']");
		public static By constructionType = By.xpath("//select[@id='constructionType']");
		public static By basementOrEnclosure= By.xpath("//select[@id='basement']");
		public static By basementContentsNo= By.xpath("//input[@id='basementContentsNo']");
		public static By foundationVentsNo= By.xpath("//input[@id='foundationVentsNo']");
		public static By belowGroundElevation= By.xpath("//input[@id='diag1']");
		public static By priorLossNo= By.xpath("//input[@id='priorLossNo']");
		public static By selectDeductible= By.xpath("//select[@id='coverageList0Deductible']");
		public static By riskIneligibleClose= By.xpath("//button[@id='btnClose']");
		public static By dwellingCoverageRange= By.xpath("//span[starts-with(.,'Dwelling Coverage Range: ')]");
		public static By amountOfInsurance= By.xpath("//input[@id='coverageList0.perOccurAmt']");
		public static By calculateButton= By.xpath("//input[@id='calculateButton']");
		public static By firstQuestion= By.xpath("//input[@id='question0No']");
		public static By secondQuestion= By.xpath("//input[@id='question1No']");
		
		public static By thirdQuestion= By.xpath("//input[@id='question2No' and @name='questionList[2].answer']");
		public static By fourthQuestion= By.xpath("//input[@id='question3No']");
		public static By fifthQuestion= By.xpath("//input[@id='question4No']");
		public static By sixthQuestion= By.xpath("//input[@id='question5No']");
		public static By seventhQuestion= By.xpath("//input[@id='question6No']");
		public static By eighthQuestion= By.xpath("//input[@id='question7Yes']");
		public static By documentsButton= By.xpath("//button[@id='availableDocuments']");
		public static By sameMailingAddress= By.xpath("//button[@id='sameMailingAddressYes']");
		public static By additionalInsuredNo= By.xpath("//input[@id='additionalInsuredNo']");
		public static By floodZone= By.xpath("//select[@id='floodZone']");
		public static By numberOfFamilies= By.xpath("//select[@id='numberOfFamilies']");
		public static By foundationType= By.xpath("//select[@id='foundationType']");
		public static By licensedAgent= By.xpath("//select[@id='foundationType']");
		public static By paymentPlansQuarterly= By.xpath("//input[@id='payCodeC1']");
		public static By payorIndicator= By.xpath("//input[@id='payCodeC1']");
		public static By paymentMethodEFT= By.xpath("//input[@id='ceft']");
		public static By ABARouting= By.xpath("//input[@id='abaRoutingNumber']");
		public static By bankAccountNumber= By.xpath("//input[@id='bankAccount']");
		public static By confirmBankAccountNumber= By.xpath("//input[@id='confirmBankAccount']");
		public static By submitPayment= By.xpath("//button[@id='submitPayment']");
		public static By nextButton= By.xpath("//button[@id='nextButton1']");
		public static By sameMailingAndPropertyAddressRadioButtonYes= By.xpath("//input[@id='sameMailingAddressYes']");
		public static By floodZoneField= By.xpath("//select[@id='floodZone']");
		public static By numberOfFamiliesField= By.xpath("//select[@id='numberOfFamilies']");
		public static By foundationTypeField= By.xpath("//select[@id='foundationType']");
		public static By paidInFull= By.xpath("//input[@id='payCodeA1']");
		public static By ACH_Upload= By.xpath("//input[@id='ach']");
		public static By partyResponsibleForPayingTheRenewalBill= By.xpath("//select[@id='payorIndicator']");
		//public static By submitPayment= By.xpath("//input[@id='ach']");
		
		
		
		public static By documentsGreenButton1 = By.xpath("//button[@id='availableDocuments']");
		public static By documentsGreenButton2 = By.xpath("//a[@class='btn btn-success']");
		public static By quotePDF = By.xpath("//a[@id=\"marketplaceQuote\"]");
		public static By applicationPDF = By.xpath("//a[@id=\"marketplaceApplication\"]");
		public static By diagram2 = By.xpath("//input[@id='diag2']");
		public static By priorLossYes = By.xpath("//input[@id='priorLossYes']");
		public static By damageRepairedYes = By.xpath("//input[@id='repairedAfterLossYes']");
		public static By dateOfLoss = By.xpath("//input[@id='dateOfLoss']");
		public static By amountOfLoss = By.xpath("//input[@id='lossValue']");
		public static By addClaim = By.xpath("//input[@id='addClaim']");
		public static By policy_number = By.xpath("//*[@id=\"appDocumentNotifierContainer\"]//following::strong[1]");
		
	
	
		
		/**
		 * =============================================================================
		 * Method: ProcessZurichFloodQuote | Author: Samadrita Guha | Date:23 Sept 2020 | Description:
		 * ProcessingZurich Flood Quote | Parameters: none | Return: None
		 * =============================================================================
		 * 
		 * @throws Exception
		 */		
		
		
		public void ProcessZurichFloodQuote() throws Exception {

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
			webActions.selectByVisibleText(By.xpath("//select[@id='coverageList0Deductible']"), "1000");
			webActions.Click(calculateButton, "calculate button");
			Thread.sleep(3000);
			webActions.Click(riskIneligibleClose, "risk ineligible close button");
			Thread.sleep(3000);
			String coverageRange = webActions.getElmText(dwellingCoverageRange);
			String number = coverageRange.substring(33);
			int i=Integer.parseInt(number); 
			int amountOfInsuranceInInteger  = i-100;
			String finalAmountOfInsurance=String.valueOf(amountOfInsuranceInInteger);  
			Thread.sleep(3000);
			webActions.clearAndSendKeys(amountOfInsurance, finalAmountOfInsurance);
			Thread.sleep(3000);
			webActions.Click(firstNextButton, "Next button");
			Thread.sleep(3000);
			webActions.Click(firstQuestion, "radio button no for first question");
			webActions.Click(secondQuestion, "radio button no for second question");
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
			js.executeScript("scroll(0, 600);");
			webActions.Click(thirdQuestion, "radio button no for third question");
			webActions.Click(fourthQuestion, "radio button no for fourth question");
			Thread.sleep(3000);
			webActions.Click(fifthQuestion, "radio button no for fifth question");
			webActions.Click(sixthQuestion, "radio button no for sixth question");
			Thread.sleep(3000);
			webActions.Click(seventhQuestion, "radio button no for seventh question");
			webActions.Click(eighthQuestion, "radio button yes for eighth question");	
			Thread.sleep(3000);
			webActions.Click(nextButton, "next button");
			Thread.sleep(7000);
			
			
			
			
			
			webActions.Click(nextButton, "next button");
			webActions.Click(sameMailingAndPropertyAddressRadioButtonYes, "radio buton yes for mailing address same as property address");
			webActions.selectByVisibleText(By.xpath("//select[@id='floodZone']"), "AE Zone");
			webActions.selectByVisibleText(By.xpath("//select[@id='numberOfFamilies']"), "Single Family Dwelling");
			webActions.selectByVisibleText(By.xpath("//select[@id='foundationType']"), "Basement");
			webActions.Click(nextButton, "next button");
			Thread.sleep(5000);
			webActions.selectByVisibleText(By.xpath("//select[@id='licensee']"), "ADD NEW AGENT LICENSE - 854444588");
			webActions.Click(paidInFull, "Pain in fill radio button");
			webActions.selectByVisibleText(By.xpath("//select[@id='payorIndicator']"), "Insured");
			webActions.Click(ACH_Upload, "ACH Upload in payment method options");
			webActions.selectByVisibleText(By.xpath("//select[@id='sweepWaitingPeriod']"), "0 Days");
			webActions.selectByVisibleText(By.xpath("//select[@id='achInformation']"), "*********2222|63000021");	
			webActions.Click(submitPayment, "Submit payment");
			Thread.sleep(4000);
			
			
		}
		
		
		
		/**
		 * =============================================================================
		 * Method: openQuoteandAppPDFs | Author: Sunil | Date:27 jan 2021 |
		 * Description: opening the quote and application pdfs after creating the quote in Zurich Flood  | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */
		
		
		public void openQuoteandAppPDFs() throws Exception {
			
			
			//creating zurich quote initially 
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
			webActions.selectByVisibleText(By.xpath("//select[@id='coverageList0Deductible']"), "1000");
			webActions.Click(calculateButton, "calculate button");
			Thread.sleep(3000);
			webActions.Click(riskIneligibleClose, "risk ineligible close button");
			Thread.sleep(3000);
			String coverageRange = webActions.getElmText(dwellingCoverageRange);
			String number = coverageRange.substring(33);
			int i=Integer.parseInt(number); 
			int amountOfInsuranceInInteger  = i-100;
			String finalAmountOfInsurance=String.valueOf(amountOfInsuranceInInteger);  
			Thread.sleep(3000);
			webActions.clearAndSendKeys(amountOfInsurance, finalAmountOfInsurance);
			Thread.sleep(3000);
			webActions.Click(firstNextButton, "Next button");
			Thread.sleep(3000);
			webActions.Click(firstQuestion, "radio button no for first question");
			webActions.Click(secondQuestion, "radio button no for second question");
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
			js.executeScript("scroll(0, 600);");
			webActions.Click(thirdQuestion, "radio button no for third question");
			webActions.Click(fourthQuestion, "radio button no for fourth question");
			Thread.sleep(3000);
			webActions.Click(fifthQuestion, "radio button no for fifth question");
			webActions.Click(sixthQuestion, "radio button no for sixth question");
			Thread.sleep(3000);
			webActions.Click(seventhQuestion, "radio button no for seventh question");
			webActions.Click(eighthQuestion, "radio button yes for eighth question");	
			Thread.sleep(3000);
			webActions.Click(nextButton, "next button");
			Thread.sleep(7000);
			webActions.Click(documentsGreenButton1,  "click on green button");
			webActions.Click(quotePDF, "click on quotePDF");
			
			//DriverFactory.getInstance().getWebDriver().switchTo().window("");
//			Robot robot1 = new Robot();
			robot1.delay(5000);
			robot1.keyPress(KeyEvent.VK_CONTROL);
			robot1.keyPress(KeyEvent.VK_P);
			robot1.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(4000);
			
			robot1.keyPress(KeyEvent.VK_CONTROL);
			robot1.keyPress(KeyEvent.VK_SHIFT);
			robot1.keyPress(KeyEvent.VK_TAB);
			robot1.keyRelease(KeyEvent.VK_CONTROL);
			robot1.keyRelease(KeyEvent.VK_SHIFT);
			robot1.keyRelease(KeyEvent.VK_TAB);
			webActions.Click(nextButton, "next button");
			Thread.sleep(4000);
			
			webActions.Click(sameMailingAndPropertyAddressRadioButtonYes, "radio buton yes for mailing address same as property address");
			webActions.selectByVisibleText(By.xpath("//select[@id='floodZone']"), "AE Zone");
			webActions.selectByVisibleText(By.xpath("//select[@id='numberOfFamilies']"), "Single Family Dwelling");
			webActions.selectByVisibleText(By.xpath("//select[@id='foundationType']"), "Basement");
			webActions.Click(nextButton, "next button");
			Thread.sleep(2000);
			WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//select[@id='licensee']"));
			Select licencedAgent = new Select(ele);
			licencedAgent.selectByIndex(1);
			//webActions.selectByVisibleText(By.xpath("//select[@id='licensee']"), "AARON A AARONSON - 3454634634");
			webActions.Click(paidInFull, "Pain in fill radio button");
			webActions.selectByVisibleText(By.xpath("//select[@id='payorIndicator']"), "Insured");
			webActions.Click(ACH_Upload, "ACH Upload in payment method options");
			webActions.selectByVisibleText(By.xpath("//select[@id='sweepWaitingPeriod']"), "0 Days");
			webActions.selectByVisibleText(By.xpath("//select[@id='achInformation']"), "*********2222|63000021");	
			webActions.Click(submitPayment, "Submit payment");
			Thread.sleep(7000);
			String policyNumber = webActions.getElmText(policy_number);
			System.out.println("policy number is: " + policyNumber);
			webActions.Click(documentsGreenButton2, "Document button");
			webActions.Click(applicationPDF, "Application PDF");
			robot1.keyPress(KeyEvent.VK_CONTROL);
			robot1.keyPress(KeyEvent.VK_P);
			robot1.keyRelease(KeyEvent.VK_CONTROL);
			ReportManager.logScreenshotInfo();
			Thread.sleep(4000);
			
			
		}
		
		
		
		/**
		 * =============================================================================
		 * Method: zurichQuoteScenario2(Prior flood Loss - no of stories,enclosure option, construction type) | Author: Sunil | Date:06 March 2021 |
		 * Description: opening the quote and application pdfs after creating the quote in Zurich Flood  | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */
		
		public void zurichQuoteScenario2() throws Exception {
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
			webActions.clearAndSendKeys(yearBuilt, "2003");
			webActions.clearAndSendKeys(squareFeet, "700");
			webActions.selectByVisibleText(By.xpath("//select[@id='numberOfStories']"), "Two Stories");
			webActions.waitForVisible(constructionType);
			webActions.selectByVisibleText(constructionType, "Frame-Including Masonry/Veneer");
			webActions.selectByVisibleText(By.xpath("//select[@id='basement']"), "Enclosure");
			webActions.Click(foundationVentsNo, "radio button no for presence of smart vents");
			webActions.Click(diagram2, "radio button 0 to 1ft above ground");
			Thread.sleep(2000);
			webActions.Click(priorLossYes, "radio button for yes prior loss");
			webActions.Click(damageRepairedYes, "radio button yes for damage repaired");
			webActions.clearAndSendKeys(dateOfLoss, "01/01/2016");
			webActions.clearAndSendKeys(amountOfLoss, "500000");
			webActions.Click(addClaim, "add Claim");
			
			webActions.selectByVisibleText(By.xpath("//select[@id='coverageList0Deductible']"), "1000");
			webActions.Click(calculateButton, "calculate button");
			Thread.sleep(3000);
			webActions.Click(riskIneligibleClose, "risk ineligible close button");
			Thread.sleep(3000);
			String coverageRange = webActions.getElmText(dwellingCoverageRange);
			String number = coverageRange.substring(33);
			int i=Integer.parseInt(number); 
			int amountOfInsuranceInInteger  = i-100;
			String finalAmountOfInsurance=String.valueOf(amountOfInsuranceInInteger);  
			Thread.sleep(3000);
			webActions.clearAndSendKeys(amountOfInsurance, finalAmountOfInsurance);
			Thread.sleep(3000);
			webActions.Click(firstNextButton, "Next button");
			webActions.Click(firstQuestion, "radio button no for first question");
			webActions.Click(secondQuestion, "radio button no for second question");
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
			js.executeScript("scroll(0, 600);");
			webActions.Click(thirdQuestion, "radio button no for third question");
			webActions.Click(fourthQuestion, "radio button no for fourth question");
			Thread.sleep(3000);
			webActions.Click(fifthQuestion, "radio button no for fifth question");
			webActions.Click(sixthQuestion, "radio button no for sixth question");
			Thread.sleep(3000);
			webActions.Click(seventhQuestion, "radio button no for seventh question");
			webActions.Click(eighthQuestion, "radio button yes for eighth question");	
			Thread.sleep(3000);
			webActions.Click(nextButton, "next button");
			Thread.sleep(7000);
			webActions.Click(nextButton, "next button");
			webActions.Click(sameMailingAndPropertyAddressRadioButtonYes, "radio buton yes for mailing address same as property address");
			webActions.selectByVisibleText(By.xpath("//select[@id='floodZone']"), "AE Zone");
			webActions.selectByVisibleText(By.xpath("//select[@id='numberOfFamilies']"), "Single Family Dwelling");
			webActions.selectByVisibleText(By.xpath("//select[@id='foundationType']"), "Fill or Crawlspace");
			webActions.Click(nextButton, "next button");
			Thread.sleep(5000);
			
//			webActions.selectByVisibleText(By.xpath("//select[@id='licensee']"), "ADD NEW AGENT LICENSE - 854444588");
//			webActions.Click(paidInFull, "Pain in fill radio button");
//			webActions.selectByVisibleText(By.xpath("//select[@id='payorIndicator']"), "Insured");
//			webActions.Click(ACH_Upload, "ACH Upload in payment method options");
//			webActions.selectByVisibleText(By.xpath("//select[@id='sweepWaitingPeriod']"), "0 Days");
//			webActions.selectByVisibleText(By.xpath("//select[@id='achInformation']"), "*********2222|63000021");	
//			webActions.Click(submitPayment, "Submit payment");
//			Thread.sleep(4000);
//			String policyNumber = webActions.getElmText(policy_number);
//			System.out.println("policy number is: " + policyNumber);
//			webActions.Click(documentsGreenButton2, "Document button");
//			webActions.Click(applicationPDF, "Application PDF");
//			robot1.keyPress(KeyEvent.VK_CONTROL);
//			robot1.keyPress(KeyEvent.VK_P);
//			robot1.keyRelease(KeyEvent.VK_CONTROL);
			ReportManager.logScreenshotInfo();
			Thread.sleep(4000);
		}
	
		
}
		
		
		
	