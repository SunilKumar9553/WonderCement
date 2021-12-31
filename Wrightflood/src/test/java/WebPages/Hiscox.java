package WebPages;

import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.mongodb.assertions.Assertions;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class Hiscox {
	

	// ==========================Objects==================================
		WebActions webActions = new WebActions();

	// ==========================Locators==================================
	public static By newQuote = By.xpath("//a[@id='MainNewQte']");	
	public static By hiscox = By.xpath("(//*[@id=\"HFLDProduct\"]/a/img)[1]");
	public static By waitingPeriod = By.xpath("//select[@id='waitingPeriod']");
	public static By firstName = By.xpath("//input[@id='insuredFirstName']");
	public static By lastName = By.xpath("//input[@id='insuredLastName']");
	public static By streetAddress = By.xpath("//input[@id='propertyStreetAddress']");
	public static By city = By.xpath("//input[@id='propertyCity']");
	public static By state = By.xpath("//select[@id='propertyState']");
	public static By zipCode = By.xpath("//input[@id='propertyZipCode']");
	public static By sameAddress = By.xpath("//input[@id='sameMailingAddress']");
	public static By replacementCost = By.xpath("//input[@id='dwellingTiv']");
	public static By confirmCheckBox = By.xpath("//input[@id='confirmRcv']");
	public static By propertyLimit = By.xpath("//input[@id='personalPropertyTiv']");
	public static By valueType = By.xpath("//select[@id='personalPropertyCostValueType']");
	public static By buildingType = By.xpath("//select[@id='buildingPurpose']");
	public static By floodZone = By.xpath("//input[@id='floodZone']");
	public static By underConstruction = By.xpath("//input[@id='underConstructionNo']");
	public static By condoUnit = By.xpath("//input[@id='condoNo']");
	public static By mobileHome = By.xpath("//input[@id='mobileHomeNo']");
	public static By occupancy = By.xpath("//select[@id='occupancy']");
	public static By constructionYear = By.xpath("//input[@id='yearBuilt']");
	public static By constructionType = By.xpath("//select[@id='construction']");
	public static By noofFloors = By.xpath("//input[@id='noOfStories']");
	public static By squareFootage = By.xpath("//input[@id='floorArea']");
	public static By isElevated = By.xpath("//input[@id='elevNo']");
	public static By isElevatedYes = By.xpath("//input[@id='elevYes']");
	public static By foundationType = By.xpath("//select[@id='foundationType']");
	public static By crawlSpace = By.xpath("//input[@id='baseCrawlNo']");
	public static By overWater = By.xpath("//select[@id='buildingOverWater']");
	public static By anyFloodLosses = By.xpath("//input[@id='priorLossNo']");
	public static By submit = By.xpath("//button[contains(text(),'Submit')]");
	public static By selectOption = By.xpath("//input[@value='Select Option 1']");
	public static By quotePdf = By.xpath("//div[@id='headerButtons']/a");
	
	public static By addLender = By.xpath("//button[@id='addLender']");
	public static By nameOne = By.xpath("//input[@id='nameOne']");
	public static By lenderName = By.xpath("//table/tbody/tr[1]/td[1]");
	public static By lenderType = By.xpath("//select[@id='lenderTypeCode']");
	public static By billToLender = By.xpath("//input[@id='billToLender-Y']");
	public static By financialInterest = By.xpath("//select[@id='lenderInterestCode']");
    public static By loanNumber = By.xpath("//input[@id='loanNbr']");
    public static By nextButton = By.xpath("//button[@id='nextButton']");
    public static By nextInPayment = By.xpath("//button[@id='back']");
    public static By licensedAgent = By.xpath("//select[@id='licensee']");  // ADD NEW AGENT LICENSE - 854444588
    public static By achUpload = By.xpath("//input[@id='ach']");
    public static By sweepWaitingPeriod = By.xpath("//select[@id='sweepWaitingPeriod']"); //0 Days
    public static By bankAccount = By.xpath("//select[@id='achInformation']"); //*********2222|63000021
    public static By submitPayment = By.xpath("//button[@id='submitPayment']");
    public static By applicationPdf = By.xpath("//a[@class='btn btn-success']");
    
    public static By datePicker = By.xpath("//*[@id=\"divEffectiveDate\"]/img");
    public static By elevationHeight = By.xpath("//input[@id='elevationHeight']");
    public static By isGarageAttached = By.xpath("//select[@id='attachedGarage']");
    public static By eftOption = By.xpath("//input[@id='ceft']");
    public static By abaRouting = By.xpath("//input[@id='abaRoutingNumber']");
    public static By bankAccountNumber = By.xpath("//input[@id='bankAccount']");
    public static By confirmAccountNumber = By.xpath("//input[@id='confirmBankAccount']");
	
		
	
	
	/**
	 * =============================================================================
	 * Method: hiscoxQuote | Author: Sunil | Date:27 jan 2021 |
	 * Description: Creating Hiscox Quote | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	public void hiscoxQuote() throws Exception {
		
		webActions.Click(newQuote, "New Quote");
		Thread.sleep(2000);
		webActions.Click(hiscox, "Hiscox");
		webActions.selectByVisibleText(waitingPeriod, "Standard 7 Day Wait");
		webActions.sendKeys(firstName, "test");
		webActions.sendKeys(lastName, "test");
		webActions.sendKeys(streetAddress, "10953 96TH STREET NORTH");
		webActions.sendKeys(city, "LARGO");
		webActions.selectByVisibleText(state, "FL");
		webActions.sendKeys(zipCode, "33773");
		webActions.Click(sameAddress, "Same address");
		webActions.sendKeys(replacementCost, "100000");
		webActions.Click(confirmCheckBox, "Confirm");
		webActions.sendKeys(propertyLimit, "50000");
		webActions.selectByVisibleText(valueType, "Actual Cost Value (ACV)");
		webActions.selectByVisibleText(buildingType, "Single Family");
		webActions.sendKeys(floodZone, "AE");
		webActions.Click(underConstruction, "is Under Construction");
		webActions.Click(condoUnit, "condo unit");
		webActions.Click(mobileHome, "a mobile home");
		webActions.selectByVisibleText(occupancy, "Primary");
		webActions.sendKeys(constructionYear, "2016");
		webActions.selectByVisibleText(constructionType, "Brick Veneer");
		webActions.sendKeys(noofFloors, "1");
		webActions.sendKeys(squareFootage, "200");
		webActions.Click(isElevated, "is Elevated");
		webActions.selectByVisibleText(foundationType, "Foundation wall");
		webActions.Click(crawlSpace, "subgrade crawl space");
		webActions.selectByVisibleText(overWater, "No");
		webActions.Click(anyFloodLosses, "Flood losses before - NO");
		webActions.Click(submit, "Submit");
		webActions.waitForVisible(selectOption);
		webActions.Click(selectOption, "Select option 1");
		webActions.waitForVisible(quotePdf);
		
		Thread.sleep(2000);
	    webActions.Click(addLender, "Add Lender"); //payment page
	    webActions.waitForVisible(lenderName);
	    webActions.Click(lenderName, "name");
	    webActions.waitForVisible(lenderType);
	    webActions.selectByVisibleText(lenderType, "First Mortgagee");
	    webActions.Click(billToLender, "Yes for Bill To Lender");
	    webActions.clearAndSendKeys(loanNumber, "45242");
	    webActions.selectByVisibleText(financialInterest, "Building Only");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextButton, "Next");
	    webActions.Click(nextInPayment, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "ADD NEW AGENT LICENSE - 854444588");
	    webActions.Click(achUpload, "ACH(Upload)");
	    webActions.selectByVisibleText(sweepWaitingPeriod, "0 Days");
	    webActions.selectByVisibleText(bankAccount, "*********2222|63000021");
	    webActions.Click(submitPayment, "Submit payment");
		webActions.waitForVisible(applicationPdf);
		webActions.Click(applicationPdf, "QuotePDF");
		Thread.sleep(2000);
		webActions.switchTab();
		Thread.sleep(4000);
		String pageTitle = DriverFactory.getInstance().getWebDriver().getTitle();
		System.out.println("page title is : " + pageTitle);
		ReportManager.logScreenshotInfo();
		Thread.sleep(2000);	
	}
	
	/**
	 * =============================================================================
	 * Method: hiscoxQuote | Author: Sunil | Date:25th Feb 2021 |
	 * Description: Creating Hiscox Quote with different options (building type, occupancy, construction type,no of floors, elevation yes) | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	
	public void hiscoxQuote2() throws Exception{
		
		webActions.Click(newQuote, "New Quote");
		Thread.sleep(2000);
		webActions.Click(hiscox, "Hiscox");
		webActions.selectByVisibleText(waitingPeriod, "Loan Closing - No Wait");
		webActions.sendKeys(firstName, "test");
		webActions.sendKeys(lastName, "test");
		webActions.sendKeys(streetAddress, "10953 96TH STREET NORTH");
		webActions.sendKeys(city, "LARGO");
		webActions.selectByVisibleText(state, "FL");
		webActions.sendKeys(zipCode, "33773");
		webActions.sendKeys(replacementCost, "100000");
		webActions.Click(confirmCheckBox, "Confirm");
		webActions.sendKeys(propertyLimit, "50000");
		webActions.selectByVisibleText(valueType, "Replacement Cost Value (RCV)");
		webActions.selectByVisibleText(buildingType, "2 to 4 Family");
		webActions.sendKeys(floodZone, "AE");
		webActions.Click(underConstruction, "is Under Construction");
		webActions.Click(condoUnit, "condo unit");
		webActions.Click(mobileHome, "a mobile home");
		webActions.selectByVisibleText(occupancy, "Secondary");
		webActions.sendKeys(constructionYear, "2016");
		webActions.selectByVisibleText(constructionType, "Masonry");
		webActions.sendKeys(noofFloors, "2");
		webActions.sendKeys(squareFootage, "200");
		webActions.Click(isElevatedYes, "yes for is elevated");
		webActions.selectByVisibleText(foundationType, "Solid foundation walls");
		webActions.clearAndSendKeys(elevationHeight, "20");
		webActions.selectByVisibleText(isGarageAttached, "Finished");
		webActions.Click(submit, "Submit");
		webActions.waitForVisible(selectOption);
		webActions.Click(selectOption, "Select option 1");
		webActions.waitForVisible(quotePdf);
		
		Thread.sleep(2000);
	    webActions.Click(addLender, "Add Lender"); //payment page
	    webActions.waitForVisible(lenderName);
	    webActions.Click(lenderName, "name");
	    webActions.waitForVisible(lenderType);
	    webActions.selectByVisibleText(lenderType, "First Mortgagee");
	    webActions.Click(billToLender, "Yes for Bill To Lender");
	    webActions.clearAndSendKeys(loanNumber, "45242");
	    webActions.selectByVisibleText(financialInterest, "Personal Property--Household/Commercial only");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextButton, "Next");
	    webActions.Click(nextInPayment, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "ADD NEW AGENT LICENSE - 854444588");
	    webActions.Click(achUpload, "ACH(Upload)");
	    webActions.selectByVisibleText(sweepWaitingPeriod, "0 Days");
	    webActions.selectByVisibleText(bankAccount, "*********2222|63000021");
	    
	    webActions.Click(submitPayment, "Submit payment");
		webActions.waitForVisible(applicationPdf);
		webActions.Click(applicationPdf, "QuotePDF");
		Thread.sleep(2000);
		webActions.switchTab();
		Thread.sleep(4000);
		String pageTitle = DriverFactory.getInstance().getWebDriver().getTitle();
		System.out.println("page title is : " + pageTitle);
		ReportManager.logScreenshotInfo();
		Thread.sleep(2000);	
		
		
		SoftAssert ha = new SoftAssert();
	
	}
		

}
