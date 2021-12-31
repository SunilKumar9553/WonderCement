package WebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class FloodQuote extends Reports {

	// ==========================Objects==================================
	WebActions webActions = new WebActions();

	// ==========================Locators==================================

	public static By userName = By.xpath("//*[@id=\"username\"]");
	public static By passWord = By.xpath("//*[@id=\"password\"]");
	public static By loginbutton = By.xpath("//*[@id=\"Login\"]");
	public static By selectusername = By.xpath("//*[@id=\"emailMainform\"]/div[2]/select");
	public static By clickonOKbutton = By.xpath("//*[@id=\"docBody\"]/div[11]/div[2]/div/button/span");
	public static By clickonnewquote = By.xpath("//*[@id=\"MainNewQte\"]");
	public static By clickonfloodproduct = By.xpath("//*[@id=\"FLDButton\"]/img");
	public static By insuredbusinessno = By.xpath("//*[@id=\"tbusnmNo\"]");
	public static By firstname = By.xpath("//*[@id=\"tfnam1\"]");
	public static By lastname = By.xpath("//*[@id=\"tlnam1\"]");
	public static By email = By.xpath("//*[@id=\"temail\"]");
	public static By address = By.xpath("//*[@id=\"tpadr1\"]");
	public static By city = By.xpath("//*[@id=\"tpcity\"]");
	public static By state = By.xpath("//*[@id=\"tpstat\"]");
	public static By zip = By.xpath("//*[@id=\"tpzip\"]");
	public static By commericaladdresscheckboxyes = By.xpath("//*[@id=\"tcmrclCheckbox\"]");
	public static By samePrpoertyAdress = By.xpath("//*[@id=\"tprpsmYes\"]");
	public static By floodZone = By.xpath("//*[@id=\"tzonrqYes\"]");
	public static By multiplestructures = By.xpath("//*[@id=\"multipleStructuresYes\"]");
	public static By desc = By.xpath("//*[@id=\"multipleStructureDescription\"]");
	public static By nextbutton = By.xpath("//*[@id=\"nextButton1\"]");
	public static By quotenumber = By.xpath("//*[@id=\"quoteInformation\"]/div[1]/dl/dd[1]");
	
	
	public static By cancelButton = By.xpath("//button[@id=\"btnClose\"]");
	public static By insuredBusinessYes = By.xpath("//input[@id='tbusnmYes']");
	public static By businessName = By.xpath("//input[@id='tbsnam']");
	public static By businessName2 = By.xpath("//input[@id='tbsnm2']");
	public static By telephone = By.xpath("//input[@id='thphon']");
	public static By street = By.xpath("//input[@id='tpadr1']");
	public static By zip2 = By.xpath("//input[@id='tpzip']");
	public static By multipleStructuresNo = By.xpath("//input[@id='multipleStructuresNo']");
	public static By floodZoneInformation = By.xpath("//*[@id=\"mainform\"]/h3");
	public static By waitingPeriod = By.xpath("//select[@id='twait']");
	public static By floodZoneList = By.xpath("//a[@id='manualZoneToggle']");
	public static By communityNumber = By.xpath("//select[@id='tcomno']");
	public static By floodZoneNo = By.xpath("//*[@id='tzonrqNo']");
	public static By currentFloodZone = By.xpath("//select[@id='tcurzon']");
	public static By suffix = By.xpath("//select[@id='mapPanelSuffix']");
	public static By documentType = By.xpath("//select[@id='tcurmi']");
	public static By mandatoryPurchase = By.xpath("//input[@id='tmpuriYes']");
	public static By mandatoryPurchaseNo = By.xpath("//input[@id='tmpuriNo']");
	public static By MpppYes = By.xpath("//input[@id='tmpppYes']");
	public static By condominium = By.xpath("//select[@id='tcondo']"); //Condo Association-Commercial
	public static By datePicker = By.xpath("//input[@id='tcstdx']//following::img[1]");
	public static By substantiallyImprvd = By.xpath("//input[@id='substantiallyImprovedNo']");
	public static By constructionDate = By.xpath("//select[@id='tcnstyp']");
	public static By aTenant = By.xpath("//input[@id='ttntinNo']");
	public static By rentalProperty = By.xpath("//input[@id='trntliNo']");
	public static By nonProfitEntity = By.xpath("//input[@id='tnpeniNo']");
	public static By purchaseDatePicker = By.xpath("//input[@id='tpurdx']//following::img");
	public static By disasterAssistance = By.xpath("//input[@id='tdstynNo']");
	public static By buildingOccupancy = By.xpath("//select[@id='toccpc']");  //text = Non-Residential - Business
	public static By smallBusiness = By.xpath("//input[@id='tsmlbsNo']");
	public static By buildingDescription = By.xpath("//select[@id='tblduse']"); // Main House
	public static By underConstruction = By.xpath("//input[@id='tblgcsNo']");
	public static By isRoofed = By.xpath("//input[@id='tblgurNo']");
	public static By overWater = By.xpath("//select[@id='tovwtr']"); // Not Over Water
	public static By extensions = By.xpath("//select[@id='tadext']"); //None
	public static By elevationCertificate = By.xpath("//input[@id='teleynYes']");
	public static By estimationType = By.xpath("//input[@id='texpndYes']");
	public static By elevationCertificateDate = By.xpath("//input[@id='tcrtdx']//following::img[1]");
	public static By diagramNumber = By.xpath("//select[@id='tdgrm']"); //6
	public static By baseFloodElevation = By.xpath("//input[@id='tbfe']");
	public static By elevationDatum = By.xpath("//select[@id='tbfedm']"); //NAVD
	public static By figuresDatum = By.xpath("//select[@id='telvdm']"); //NAVD
	public static By bottomFloor = By.xpath("//input[@id='tbtmfl']");
	public static By lowestFloorElv = By.xpath("//input[@id='tlfe']") ;
	public static By lowestAdjacentGrade = By.xpath("//input[@id='tlag']");
	public static By photographsTakenDate = By.xpath("//input[@id='trphdx']//following::img");
	public static By isGarageAttached = By.xpath("//input[@id='tgatchNo']"); 
	public static By isBasement = By.xpath("//select[@id='tbsenc']"); 
	public static By oilPit = By.xpath("//input[@id='tolpitNo']");
	public static By isElevated = By.xpath("//input[@id='televtNo']");
	public static By slabDesign = By.xpath("//select[@id='tongrd']"); //Slab on Natural Grade
	public static By noofFloors = By.xpath("//select[@id='tbtype']"); //One Floor
	public static By floodProofedCertificate = By.xpath("//input[@id='tflprfNo']");
	public static By repleacementCost = By.xpath("//input[@id='trpcst']");
	public static By buildingCoverage = By.xpath("//input[@id='ttlbld']");
	public static By contentCoverage = By.xpath("//input[@id='ttlcnt']");
	public static By contentsLoation = By.xpath("//select[@id='tcntlc']");
	public static By deductible = By.xpath("//input[@id='ratingOption0']");
	public static By xButton = By.xpath("//*[@id=\"modalDialog\"]/div[1]/button/i");
	public static By availableDocuments = By.xpath("//button[@id='availableDocuments']");
	public static By quotePdf = By.xpath("//a[@id='floodQuote']");
	public static By isFullyEnclosed = By.xpath("//select[@id='tpfenc']");
	public static By squareFootage = By.xpath("//input[@id='tsqftg']");
	public static By crawlSpace = By.xpath("//select[@id='tencus']");
	public static By foundationType = By.xpath("//select[@id='toffgr']");
	public static By crawlSpaceWalls = By.xpath("//select[@id='tencwl']");
	public static By basementOrEnclosure = By.xpath("//input[@id='tbttypNo']");
	public static By noofPermanentOpenings = By.xpath("//input[@id='teprop']");
	public static By noofPermanentOpenings2 = By.xpath("//input[@id='tgprop']"); //pol type preferred - no tenenat - building description Detached Guest house
	public static By totalNetArea = By.xpath("//input[@id='tsqins']");
	public static By totalNetArea2 = By.xpath("//input[@id='tgpsqi']");//pol type preferred - no tenenat - building description Detached Guest house
	public static By machineryEquipment = By.xpath("//input[@id='tmeqynNo']");
	public static By foodFreezer = By.xpath("//input[@id='twdindNo']");
	public static By elevators = By.xpath("//input[@id='telvriNo']");
	public static By contentsLocation = By.xpath("//select[@id='tcntlc']");
	public static By topOfNextHigherFloor = By.xpath("//input[@id='tnxhfl']");
	public static By reviseQuote = By.xpath("//input[@id='cancel']");
	public static By policyType = By.xpath("//select[@id='ptype']");
	
	
	public static By addLender = By.xpath("//button[@id='addLenderButton']");
	public static By nameOne = By.xpath("//input[@id='nameOne']");
	public static By lenderName = By.xpath("//table/tbody/tr[1]/td[1]");
	public static By lenderType = By.xpath("//select[@id='lenderTypeCode']");
	public static By billToLender = By.xpath("//input[@id='billToLender-Y']");
	public static By financialInterest = By.xpath("//select[@id='lenderInterestCode']");
    public static By loanNumber = By.xpath("//input[@id='loanNbr']");
    public static By licensedAgent = By.xpath("//select[@id='selectedNpnAgt']");
    public static By achUpload = By.xpath("//input[@id='EFT']");
    public static By noofDays = By.xpath("//select[@id='PWTDYS']");
    public static By documents = By.xpath("//a[@class='btn btn-success']");
	public static By policyNumber = By.xpath("//a[@class='btn btn-success']//following::strong[1]");
	
	public static By zoneDetermindationYes = By.xpath("//input[@id='tzonrqYes']");
	public static By buildingPurpose = By.xpath("//select[@id='tblprp']");
	public static By percentageOfTheYear = By.xpath("//input[@id='tprncpC']");
	public static By contentsOnly = By.xpath("//input[@id='tcvtypNo']");
	public static By maximumPremium = By.xpath("//input[@id='ratingOption8']");
	public static By checkOption = By.xpath("//input[@id='CHECK']");
	public static By checkNumber = By.xpath("//input[@id='PCHKNO']");
	public static By payerAgent = By.xpath("//input[@id='PPYRCD-A']");
	
	public static By substantiallyImprovedYes = By.xpath("//input[@id='substantiallyImprovedYes']");
	public static By substantiallyImprovedYesDate = By.xpath("//input[@id='substantiallyImprovedYes']//following::img[1]");
	public static By tenantYes = By.xpath("//input[@id='ttntinYes']");
	public static By tenantInsurable = By.xpath("//input[@id='tinintYes']");
	
	public static By multipleStructuresDescription = By.xpath("//textarea[@id='multipleStructureDescription']");
	public static By governmentAgency = By.xpath("//select[@id='tdstas']");
	public static By caseFileNumber = By.xpath("//input[@id='tcfnbr']");
	public static By percentageResArea = By.xpath("//input[@id='trupct']");
	public static By disasterAssistanceYes = By.xpath("//input[@id='tdstynYes']");
	
    public static By buildingOwnerFirstName = By.xpath("//input[@id=\"firstName\"]");
    public static By buildingOwnerLastName = By.xpath("//*[@id=\"secondaryName\"]");
    public static By buildingOwnerAddressOne = By.xpath("//*[@id=\"addressOne\"]");
    public static By buildingOwnerState = By.xpath("//*[@id=\"state\"]");
    public static By buildingOwnerZip = By.xpath("//*[@id=\"postalCode\"]");
    public static By garageAttachedYes = By.xpath("//*[@id=\"tgatchYes\"]");
    public static By garageFinished = By.xpath("//*[@id=\"tgrtyp\"]");
    public static By garageUsedFor = By.xpath("//*[@id=\"tgrgus\"]");
    public static By garageContains = By.xpath("//*[@id=\"tgeqynNo\"]");
    public static By garageSquareFeet = By.xpath("//*[@id=\"tgsqft\"]");
    public static By rentalPropertyYes = By.xpath("//input[@id='trntliYes']");
    
    
	
	
	
	
	
	
	/**
	 * =============================================================================
	 * Method: wrightlogin | Author: Rajesh Buddha | Date:15 Aug 2020 | Description:
	 * Login into the application | Parameters: username, password | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	public void wrightlogin(String username, String password) throws Exception {

		webActions.sendKeys(userName, username);
		webActions.sendKeys(passWord, password);
		webActions.Click(loginbutton, "login button");
		Thread.sleep(4000);
		WebElement es1 = DriverFactory.getInstance().getWebDriver()
				.findElement(By.xpath("//*[@id=\"emailMainform\"]/div[2]/select"));
		Actions s = new Actions(DriverFactory.getInstance().getWebDriver());
		s.moveToElement(es1).click().perform();
		webActions.selectByVisibleText(By.xpath("//*[@id=\"emailMainform\"]/div[2]/select"), "example@gmail.com");
		webActions.Click(clickonOKbutton, "clickon OK button");
		
		//close button
		Thread.sleep(4000);
		webActions.Click(cancelButton, "click on cancel button");
		
	}

	/**
	 * =============================================================================
	 * Method: TCfloodquote | Author: Rajesh Buddha | Date:15 Aug 2020 |
	 * Description: New quote for flood | Parameters: None | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	public void TCfloodquote() throws Exception {

		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredbusinessno, "insured business no");
		webActions.sendKeys(firstname, "surya");
		webActions.sendKeys(lastname, "surya");
		webActions.sendKeys(email, "gurram.suryateja@gmail.com");
		webActions.sendKeys(address, "Legacy fountain plaza");
		webActions.sendKeys(city, "Legacy fountain plaza");
		WebElement state1 = DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//*[@id=\"tpstat\"]"));
		Actions s5 = new Actions(DriverFactory.getInstance().getWebDriver());
		s5.moveToElement(state1).click().perform();
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "CA");
		webActions.sendKeys(zip, "95110");
		webActions.Click(commericaladdresscheckboxyes, "commerical address check box yes");
		webActions.Click(samePrpoertyAdress, "same Prpoerty Adress");
		webActions.Click(floodZone, "flood Zone");
		webActions.Click(multiplestructures, "multiple structures");
		webActions.sendKeys(desc, "wrightflood");
		webActions.Click(nextbutton, "next button");
		String quotenumber = webActions.getElmText(By.xpath("//*[@id='quoteInformation']/div[1]/dl/dd[1]"));
		System.out.println("quotenumberis " + quotenumber);
		
	}
	
	
	
	/**
	 * =============================================================================
	 * Method: TCMPPPFloodQuote | Author: Sunil | Date:5th Feb 2021 |
	 * Description: Creating a flood quote by selecting MPPP yes | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	public void TCMPPPFloodQuote() throws Exception {
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
	    webActions.Click(floodZoneNo, "Flood zone");
	    webActions.Click(floodZoneList, "Flood Zone List");
	    Thread.sleep(4000);
	    webActions.selectByVisibleText(communityNumber, "MADEIRA BEACH, CITY OF");
	    webActions.selectByVisibleText(currentFloodZone, "AE");
	    webActions.selectByVisibleText(suffix, "0192|G");
	    webActions.selectByVisibleText(documentType, "LOMA");
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
        webActions.Click(mandatoryPurchase, "Mandatory Purchase");
        Thread.sleep(2000);
        webActions.Click(MpppYes, "Mppp");
	    ReportManager.logScreenshotInfo();
	    webActions.selectByVisibleText(condominium, "Condo Association-Commercial");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
 
	    
	    webActions.Click(substantiallyImprvd, "no for substantially improved");
	    webActions.selectByVisibleText(constructionDate, "Building Permit Date");
	    webActions.Click(aTenant, "Insured a Tenant");
	    Thread.sleep(2000);
	    webActions.Click(rentalProperty, "Rental Property");
	    webActions.Click(nonProfitEntity, "Is non-profitable entity");
	    webActions.Click(purchaseDatePicker, "Purchase Date");
	    Thread.sleep(2000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(2000);
	    webActions.Click(nextbutton, "Next");
	    webActions.selectByVisibleText(buildingOccupancy, "Non-Residential - Business");
	    Thread.sleep(2000);
	    webActions.Click(smallBusiness, "is Insured a small business");
	    webActions.selectByVisibleText(buildingDescription, "Main House");
	    webActions.Click(underConstruction, "Under construction - NO");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(overWater, "Not Over Water");
	    webActions.selectByVisibleText(extensions, "None");
	    
	    webActions.Click(elevationCertificate, "Elevation Certificate");
	    webActions.Click(estimationType, "Premium estimation Type - quote");
	    webActions.Click(elevationCertificateDate, "Elevation Certificate Date");
	    Thread.sleep(3000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    webActions.selectByVisibleText(diagramNumber, "1");
	    Thread.sleep(2000);
	    webActions.sendKeys(baseFloodElevation, "3");
	    webActions.selectByVisibleText(elevationDatum, "NAVD");
	    webActions.selectByVisibleText(figuresDatum, "NAVD");
	    webActions.sendKeys(bottomFloor, "3");
	    webActions.sendKeys(lowestAdjacentGrade, "3");
	    webActions.Click(photographsTakenDate, "photgraphs taken date");
	    Thread.sleep(2000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(2000);
	    webActions.Click(isGarageAttached, "Garage attached");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(isBasement, "None");
	    webActions.Click(oilPit, "No for Oil Pit");
	    webActions.Click(isElevated, "Building Elevated");
	    webActions.selectByVisibleText(slabDesign, "Slab on Natural Grade");
	    webActions.selectByVisibleText(noofFloors, "One Floor");
	    webActions.scrollDownUsingJS();
	    webActions.sendKeys(repleacementCost, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(buildingCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(contentCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.scrollDownUsingJS();
	    Thread.sleep(2000);
	    WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(nextbutton);
	    JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getInstance().getWebDriver();
	    executor.executeScript("arguments[0].click();", ele);
	    webActions.waitForVisible(deductible);
	    webActions.Click(deductible, "Premium by deductible combination");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "Close button");
	    Thread.sleep(2000);
	    webActions.Click(addLender, "Add Lender"); //payment page
	    webActions.Click(lenderName, "name");
	    webActions.waitForVisible(lenderType);
	    webActions.selectByVisibleText(lenderType, "First Mortgagee");
	    webActions.Click(billToLender, "Yes for Bill To Lender");
	    webActions.clearAndSendKeys(loanNumber, "45242");
	    webActions.selectByVisibleText(financialInterest, "Building Only");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    Thread.sleep(3000);
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "Alana Ash - 123ALA4567");
	    webActions.Click(achUpload, "ACH(Upload)");
	    webActions.selectByVisibleText(noofDays, "3 Days");
	    webActions.Click(nextbutton, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(documents);
	    String policy_number = webActions.getElmText(policyNumber);
	    System.out.println("policy Number is : " + policy_number);
	    webActions.Click(documents, "Documents");
	    webActions.Click(quotePdf, "Flood quote PDF");
	    Thread.sleep(2000);
	    webActions.switchTab();
	    ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
		
		
		
		
		
	}
	

	/**
	 * =============================================================================
	 * Method: TCSFRQuote | Author: Sunil | Date:5th Feb 2021 |
	 * Description: Creating a SFR quote | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	
	public void TCSFRQuote() throws Exception{
		
		
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
	    webActions.Click(floodZoneNo, "Flood zone");
	    webActions.Click(floodZoneList, "Flood Zone List");
	    Thread.sleep(4000);
	    webActions.selectByVisibleText(communityNumber, "MADEIRA BEACH, CITY OF");
	    webActions.selectByVisibleText(currentFloodZone, "AE");
	    webActions.selectByVisibleText(suffix, "0192|G");
	    webActions.selectByVisibleText(documentType, "LOMA");
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
        webActions.Click(mandatoryPurchase, "Mandatory Purchase");
        Thread.sleep(2000);
        webActions.Click(MpppYes, "Mppp");
	    ReportManager.logScreenshotInfo();
	    webActions.selectByVisibleText(condominium, "Condo Association-Commercial");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
 
	    
	    webActions.Click(substantiallyImprvd, "substantially improved");
	    webActions.selectByVisibleText(constructionDate, "Building Permit Date");
	    webActions.Click(aTenant, "Insured a Tenant");
	    Thread.sleep(2000);
	    webActions.Click(rentalProperty, "Rental Property");
	    webActions.Click(nonProfitEntity, "Is non-profitable entity");
	    webActions.Click(purchaseDatePicker, "Purchase Date");
	    Thread.sleep(2000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(2000);
	    webActions.Click(nextbutton, "Next");
	    webActions.selectByVisibleText(buildingOccupancy, "Non-Residential - Business");
	    Thread.sleep(2000);
	    webActions.Click(smallBusiness, "is Insured a small business");
	    webActions.selectByVisibleText(buildingDescription, "Main House");
	    webActions.Click(underConstruction, "Under construction - NO");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(overWater, "Not Over Water");
	    webActions.selectByVisibleText(extensions, "None");
	    webActions.Click(elevationCertificate, "Elevation Certificate");
	    webActions.Click(estimationType, "Premium estimation Type - quote");
	    webActions.Click(elevationCertificateDate, "Elevation Certificate Date");
	    Thread.sleep(3000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    webActions.selectByVisibleText(diagramNumber, "6");
	    Thread.sleep(2000);
	    webActions.sendKeys(baseFloodElevation, "7");
	    webActions.selectByVisibleText(elevationDatum, "NAVD");
	    webActions.selectByVisibleText(figuresDatum, "NAVD");
	    webActions.sendKeys(bottomFloor, "3");
	    webActions.sendKeys(topOfNextHigherFloor, "9");
	    webActions.sendKeys(lowestAdjacentGrade, "3");
	    
	    webActions.Click(photographsTakenDate, "photgraphs taken date");
	    Thread.sleep(2000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(2000);
	    webActions.Click(isGarageAttached, "Garage attached");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(isBasement, "Enclosure");
	    webActions.Click(oilPit, "no for Oil Pit");
	    webActions.selectByVisibleText(isFullyEnclosed, "Fully");
	    webActions.sendKeys(squareFootage, "600");
	    webActions.selectByVisibleText(crawlSpace, "Storage");
	    webActions.selectByVisibleText(foundationType, "Piles");
	    webActions.selectByVisibleText(crawlSpaceWalls, "Masonry Walls (Non-Breakaway)");
	    webActions.Click(basementOrEnclosure, "Basement or Enclosure");
	    webActions.clearAndSendKeys(noofPermanentOpenings, "0");
	    webActions.clearAndSendKeys(totalNetArea, "0");
	    webActions.Click(machineryEquipment, "no for Machinery Equipment");
	    webActions.Click(foodFreezer, "no for food freezer");
	    webActions.Click(elevators, "No for Elevators");
	    webActions.selectByVisibleText(noofFloors, "Two Floors");
	    webActions.sendKeys(repleacementCost, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(buildingCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(contentCoverage, "100000");
	    Thread.sleep(3000);
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_TAB);
	    webActions.scrollDownUsingJS();
	    webActions.selectByVisibleText(contentsLocation, "Basmnt/Encl/Crawlspc and Above");
	   
	    Thread.sleep(2000);
	    WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(nextbutton);
	    JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getInstance().getWebDriver();
	    executor.executeScript("arguments[0].click();", ele);
	    webActions.waitForVisible(reviseQuote);
	    ReportManager.logScreenshotInfo();
	    Thread.sleep(4000);
	   
	}
	
	/**
	 * =============================================================================
	 * Method: TCPRPQuote | Author: Sunil | Date:8th Feb 2021 |
	 * Description: Creating a PRP quote | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	public void TCPRPQuote() throws Exception{
		
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
	    webActions.Click(floodZoneNo, "Flood zone");
	    webActions.Click(floodZoneList, "Flood Zone List");
	    Thread.sleep(4000);
	    webActions.selectByVisibleText(communityNumber, "MADEIRA BEACH, CITY OF");
	    webActions.selectByVisibleText(currentFloodZone, "X");
	    webActions.selectByVisibleText(suffix, "0192|G");
	    webActions.selectByVisibleText(documentType, "LOMA");
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
        webActions.Click(mandatoryPurchase, "Mandatory Purchase");
        Thread.sleep(3000);
        webActions.selectByVisibleText(condominium, "Condo Association-Commercial");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(1000);
	    webActions.Click(substantiallyImprvd, "no for substantially improved");
	    webActions.selectByVisibleText(constructionDate, "Building Permit Date");
	    webActions.selectByVisibleText(policyType, "Regular");
	    webActions.Click(aTenant, "Insured a Tenant");
	    Thread.sleep(2000);
	    webActions.Click(rentalProperty, "Rental Property");
	    webActions.Click(nonProfitEntity, "Is non-profitable entity");
	    webActions.Click(purchaseDatePicker, "Purchase Date");
	    Thread.sleep(2000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(2000);
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(buildingOccupancy);
	    
	    webActions.selectByVisibleText(buildingOccupancy, "Non-Residential - Business");
	    Thread.sleep(2000);
	    webActions.Click(smallBusiness, "is Insured a small business");
	    webActions.selectByVisibleText(buildingDescription, "Main House");
	    webActions.Click(underConstruction, "Under construction - NO");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(overWater, "Not Over Water");
	    webActions.selectByVisibleText(extensions, "None");
	    Thread.sleep(2000);
	    webActions.Click(isGarageAttached, "Garage attached");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(isBasement, "None");
	    webActions.Click(oilPit, "no for Oil Pit");
	    webActions.Click(isElevated, "Building Elevated");
	    webActions.selectByVisibleText(slabDesign, "Slab on Natural Grade");
	    webActions.selectByVisibleText(noofFloors, "One Floor");
	    webActions.scrollDownUsingJS();
	    webActions.sendKeys(repleacementCost, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(buildingCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(contentCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.scrollDownUsingJS();
	    Thread.sleep(2000);
	    WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(nextbutton);
	    JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getInstance().getWebDriver();
	    executor.executeScript("arguments[0].click();", ele);
	    webActions.waitForVisible(deductible);
	    webActions.Click(deductible, "Premium by deductible combination");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "Close button");
	    
	    
	    Thread.sleep(2000);
	    webActions.Click(addLender, "Add Lender"); //payment page
	    webActions.Click(lenderName, "name");
	    webActions.waitForVisible(lenderType);
	    webActions.selectByVisibleText(lenderType, "First Mortgagee");
	    webActions.Click(billToLender, "Yes for Bill To Lender");
	    webActions.clearAndSendKeys(loanNumber, "45242");
	    webActions.selectByVisibleText(financialInterest, "Building Only");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    Thread.sleep(3000);
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "Alana Ash - 123ALA4567");
	    webActions.Click(achUpload, "ACH(Upload)");
	    webActions.selectByVisibleText(noofDays, "3 Days");
	    webActions.Click(nextbutton, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(documents);
	    String policy_number = webActions.getElmText(policyNumber);
	    System.out.println("policy Number is : " + policy_number);
	    webActions.Click(documents, "Documents");
	    webActions.Click(quotePdf, "Flood quote PDF");
	    Thread.sleep(2000);
	    webActions.switchTab();
	    ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
	}
	
	/**
	 * =============================================================================
	 * Method: zoneDetermination | Author: Sunil | Date:8th Feb 2021 |
	 * Description: Creating a quote by doing zone determination yes | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	public void zoneDetermination() throws Exception{
		
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
		webActions.Click(zoneDetermindationYes, "yes for zone determination");
		webActions.Click(multipleStructuresNo, "No for multiple structures");
		Thread.sleep(3000);
		webActions.Click(nextbutton, "Next");
		Thread.sleep(4000);
		webActions.scrollDownUsingJS();
		webActions.Click(nextbutton, "Next");
		webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
	    webActions.Click(mandatoryPurchaseNo, "No for Mandatory purchase");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(condominium, "Other (Not a condo)");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(1000);
	    
	    webActions.Click(substantiallyImprvd, "no for substantially improved");
	    webActions.selectByVisibleText(constructionDate, "Building Permit Date");
	    webActions.selectByVisibleText(policyType, "Preferred");
	    webActions.Click(aTenant, "Insured a Tenant");
	    Thread.sleep(2000);
	    webActions.Click(rentalProperty, "Rental Property");
	    webActions.Click(nonProfitEntity, "Is non-profitable entity");
	    webActions.Click(purchaseDatePicker, "Purchase Date");
	    Thread.sleep(2000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(3000);
	    
	    
	    
	    webActions.selectByVisibleText(buildingPurpose, "Residential");
	    webActions.selectByVisibleText(buildingOccupancy, "Single Family");
	    Thread.sleep(2000);
	    webActions.Click(smallBusiness, "is Insured a small business");
	    webActions.selectByVisibleText(buildingDescription, "Main House");
	    webActions.Click(underConstruction, "Under construction - NO");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(overWater, "Not Over Water");
	    webActions.selectByVisibleText(extensions, "None");
	    Thread.sleep(2000);
	    webActions.Click(percentageOfTheYear, "80%");
	    webActions.Click(isGarageAttached, "Garage attached");
	    webActions.selectByVisibleText(isBasement, "None");
	    webActions.selectByVisibleText(noofFloors, "One Floor");
	    Thread.sleep(2000);
	    webActions.clearAndSendKeys(repleacementCost, "350000");
	    Thread.sleep(2000);
	    webActions.Click(contentsOnly, "No for contents only");
	    webActions.Click(nextbutton, "Next");
	    webActions.scrollDownUsingJS();
	    webActions.Click(maximumPremium, "Maximum premium value");
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "Close button");
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "Alana Ash - 123ALA4567");
	    webActions.Click(checkOption, "Check");
	    webActions.clearAndSendKeys(checkNumber, "12345");
	    webActions.Click(payerAgent, "Agent");
	    webActions.Click(nextbutton, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "close");
	    String Policy_Number = webActions.getElmText(policyNumber);
//	    System.out.println("policy Number is : " + policy_number);
	    
	    
	    
	    Properties prop = new Properties();
		FileOutputStream stream = new FileOutputStream("C:\\Users\\Sunil\\git\\WrightFlood\\Wrightflood\\Inputs.properties"); 
		prop.setProperty("policy", Policy_Number);
		prop.save(stream, "Writing PolicyNumber");
		System.out.println("Policy Number is :  " + prop.get("policy"));
	    
	    
	    
	    webActions.Click(documents, "Documents");
	    webActions.Click(quotePdf, "Flood quote PDF");
	    Thread.sleep(2000);
	    webActions.switchTab();
	    ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
	    
	    
	    
	    
	    
	}
	
	
	/**
	 * =============================================================================
	 * Method: policyForExcessFloodQuote | Author: Sunil | Date:8th Feb 2021 |
	 * Description: Creating a policy which can be used for creating the excess flood quote (duplicate of zoneDetermination method - ) | Parameters: None |
	 * Return: String value of policy number
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */

	
	
	public String policyForExcessFloodQuote() throws Exception{
		
		
		
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
		webActions.Click(zoneDetermindationYes, "yes for zone determination");
		webActions.Click(multipleStructuresNo, "No for multiple structures");
		Thread.sleep(3000);
		webActions.Click(nextbutton, "Next");
		Thread.sleep(4000);
		webActions.scrollDownUsingJS();
		webActions.Click(nextbutton, "Next");
		webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
	    webActions.Click(mandatoryPurchaseNo, "No for Mandatory purchase");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(condominium, "Other (Not a condo)");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(1000);
	    
	    webActions.Click(substantiallyImprvd, "no for substantially improved");
	    webActions.selectByVisibleText(constructionDate, "Building Permit Date");
	    webActions.selectByVisibleText(policyType, "Preferred");
	    webActions.Click(aTenant, "Insured a Tenant");
	    Thread.sleep(2000);
	    webActions.Click(rentalProperty, "Rental Property");
	    webActions.Click(nonProfitEntity, "Is non-profitable entity");
	    webActions.Click(purchaseDatePicker, "Purchase Date");
	    Thread.sleep(2000);
	    webActions.Click(xpathofTodaysDate, "Date");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(buildingPurpose, "Residential");
	    
	    webActions.selectByVisibleText(buildingOccupancy, "Single Family");
	    Thread.sleep(2000);
	    webActions.Click(smallBusiness, "is Insured a small business");
	    webActions.selectByVisibleText(buildingDescription, "Main House");
	    webActions.Click(underConstruction, "Under construction - NO");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(overWater, "Not Over Water");
	    webActions.selectByVisibleText(extensions, "None");
	    Thread.sleep(2000);
	    webActions.Click(percentageOfTheYear, "80%");
	    webActions.Click(isGarageAttached, "Garage attached");
	    webActions.selectByVisibleText(isBasement, "None");
	    webActions.selectByVisibleText(noofFloors, "One Floor");
	    Thread.sleep(2000);
	    webActions.clearAndSendKeys(repleacementCost, "350000");
	    Thread.sleep(2000);
	    webActions.Click(contentsOnly, "No for contents only");
	    webActions.Click(nextbutton, "Next");
	    webActions.scrollDownUsingJS();
	    webActions.Click(maximumPremium, "Maximum premium value");
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "Close button");
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "Alana Ash - 123ALA4567");
	    webActions.Click(checkOption, "Check");
	    webActions.clearAndSendKeys(checkNumber, "12345");
	    webActions.Click(payerAgent, "Agent");
	    webActions.Click(nextbutton, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "close");
	    
	    
	    Thread.sleep(10000000);
	    
	   String policy_number =  webActions.getElmText(policyNumber);
//	    System.out.println("policy Number is : " + policy_number);
	    webActions.Click(documents, "Documents");
	    webActions.Click(quotePdf, "Flood quote PDF");
	    Thread.sleep(2000);
	    webActions.switchTab();
	    ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
		return policy_number;
		
	}
	
	
	
	/**
	 * =============================================================================
	 * Method: floodQuote_scenario_2 | Author: Sunil | Date:25th Feb 2021 |
	 * Description: New quote for flood with choosing different options| Parameters: None | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	
	
	public void floodQuote_scenario_2() throws Exception {
		
		
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
		webActions.Click(zoneDetermindationYes, "yes for zone determination");
		webActions.Click(multipleStructuresNo, "No for multiple structures");
		Thread.sleep(4000);
		webActions.Click(nextbutton, "Next");
		Thread.sleep(4000);
		webActions.scrollDownUsingJS();
		webActions.Click(nextbutton, "Next");
		webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
	    webActions.Click(mandatoryPurchaseNo, "No for Mandatory purchase");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(condominium, "Other (Not a condo)");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
        
        webActions.Click(substantiallyImprovedYes, "yes for substantially improved yes");
        webActions.Click(substantiallyImprovedYesDate, "Date picker");
        webActions.Click(xpathofTodaysDate, "today's Date");
        webActions.selectByVisibleText(policyType, "Regular");
        webActions.Click(aTenant, "yes - is the insured a tenant");
        webActions.Click(rentalProperty, "No for rental property");
        webActions.Click(nonProfitEntity, "No - not profit entity");
        webActions.Click(purchaseDatePicker, "Purchase date picker");
        webActions.Click(xpathofTodaysDate, "Date");
        Thread.sleep(3000);
        webActions.Click(nextbutton, "Next");
        webActions.waitForVisible(buildingPurpose);
        webActions.selectByVisibleText(buildingPurpose, "Non-Residential");
        webActions.selectByVisibleText(buildingOccupancy, "Non-Residential - Business");
	    Thread.sleep(2000);
	    webActions.Click(smallBusiness, "is Insured a small business");
	    webActions.selectByVisibleText(buildingDescription, "Main House");
	    webActions.Click(underConstruction, "Under construction - NO");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(overWater, "Not Over Water");
	    webActions.selectByVisibleText(extensions, "None");
	    Thread.sleep(2000);
	    webActions.Click(isGarageAttached, "Garage attached");
	    webActions.selectByVisibleText(isBasement, "None");
	    webActions.Click(oilPit, " no for Oil Pit");
	    webActions.Click(isElevated, "Building Elevated");
	    webActions.selectByVisibleText(slabDesign, "Slab on Natural Grade");
	    webActions.selectByVisibleText(noofFloors, "One Floor");
	    webActions.scrollDownUsingJS();
	    webActions.sendKeys(repleacementCost, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(buildingCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(contentCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.scrollDownUsingJS();
	    Thread.sleep(2000);
	    WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(nextbutton);
	    JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getInstance().getWebDriver();
	    executor.executeScript("arguments[0].click();", ele);
	    webActions.waitForVisible(deductible);
	    webActions.Click(deductible, "Premium by deductible combination");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "Close button");
	    
	    
	    
	    
	    Thread.sleep(2000);
	    webActions.Click(addLender, "Add Lender"); //payment page
	    webActions.Click(lenderName, "name");
	    webActions.waitForVisible(lenderType);
	    webActions.selectByVisibleText(lenderType, "First Mortgagee");
	    webActions.Click(billToLender, "Yes for Bill To Lender");
	    webActions.clearAndSendKeys(loanNumber, "45242");
	    webActions.selectByVisibleText(financialInterest, "Building Only");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    Thread.sleep(3000);
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(licensedAgent);
	    
	    Thread.sleep(100000000);
	    
	    webActions.selectByVisibleText(licensedAgent, "Alana Ash - 123ALA4567");
	    webActions.Click(achUpload, "ACH(Upload)");
	    webActions.selectByVisibleText(noofDays, "3 Days");
	    webActions.Click(nextbutton, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(documents);
	    String policy_number = webActions.getElmText(policyNumber);
	    System.out.println("policy Number is : " + policy_number);
	    webActions.Click(documents, "Documents");
	    webActions.Click(quotePdf, "Flood quote PDF");
	    Thread.sleep(2000);
	    webActions.switchTab();
	    ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
        
      
	    
	}
	
	
	
	/**
	 * =============================================================================
	 * Method: floodQuote_scenario_3 (Building owner information)| Author: Sunil | Date:25th Feb 2021 |
	 * Description: New quote for flood with choosing different options| Parameters: None | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	
	public void floodQuoteScenario3() throws Exception{
		
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
		webActions.Click(zoneDetermindationYes, "yes for zone determination");
		webActions.Click(multiplestructures, "yes - multiple structures");
		Thread.sleep(4000);
		webActions.clearAndSendKeys(multipleStructuresDescription, "abc");
		webActions.Click(nextbutton, "Next");
		webActions.scrollDownUsingJS();
		webActions.Click(nextbutton, "next");
		webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
	    webActions.Click(mandatoryPurchaseNo, "No for Mandatory purchase");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(condominium, "Other (Not a condo)");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
        webActions.Click(substantiallyImprovedYes, "yes for substantially improved yes");
        webActions.Click(substantiallyImprovedYesDate, "Date picker");
        webActions.Click(xpathofTodaysDate, "today's Date");
        webActions.selectByVisibleText(policyType, "Regular");
        webActions.Click(tenantYes, "yes - is the insured a tenant");
        webActions.Click(tenantInsurable, "yes - tenant has insurable interest");
        webActions.Click(nonProfitEntity, "No - not profit entity");
        Thread.sleep(2000);
        webActions.Click(disasterAssistanceYes, "yes - Is insurance required for disaster assistance");
        Thread.sleep(2000);
        webActions.selectByVisibleText(governmentAgency, "SBA");
        webActions.clearAndSendKeys(caseFileNumber, "12345");
        webActions.Click(nextbutton, "Next");
        webActions.waitForVisible(buildingPurpose);
        webActions.waitForVisible(buildingPurpose);
        webActions.selectByVisibleText(buildingPurpose, "Non-Residential");
        webActions.selectByVisibleText(buildingOccupancy, "Non-Residential - Business");
	    Thread.sleep(2000);
	    webActions.Click(smallBusiness, "is Insured a small business");
	    webActions.selectByVisibleText(buildingDescription, "Main House");
	    webActions.Click(underConstruction, "Under construction - NO");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(overWater, "Not Over Water");
	    webActions.selectByVisibleText(extensions, "None");
	    Thread.sleep(2000);
	    webActions.Click(isGarageAttached, "Garage attached");
	    webActions.selectByVisibleText(isBasement, "None");
	    webActions.Click(oilPit, "no for Oil Pit");
	    webActions.Click(isElevated, "Building Elevated");
	    webActions.selectByVisibleText(slabDesign, "Slab on Natural Grade");
	    webActions.selectByVisibleText(noofFloors, "One Floor");
	    webActions.scrollDownUsingJS();
	    webActions.sendKeys(repleacementCost, "100000");
	    webActions.sendKeys(buildingCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(contentCoverage, "100000");
	    Thread.sleep(3000);
	    
	    webActions.clearAndSendKeys(buildingOwnerFirstName, "test");
	    webActions.clearAndSendKeys(buildingOwnerLastName, "test");
	    webActions.clearAndSendKeys(buildingOwnerAddressOne, "1032 35TH AVE N");
	    webActions.selectByVisibleText(buildingOwnerState, "Florida");
	    webActions.clearAndSendKeys(buildingOwnerZip, "33704-1851");
	    
	    webActions.scrollDownUsingJS();
	    Thread.sleep(2000);
	    WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(nextbutton);
	    JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getInstance().getWebDriver();
	    executor.executeScript("arguments[0].click();", ele);
	    webActions.waitForVisible(deductible);
	    webActions.Click(deductible, "Premium by deductible combination");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "Close button");
	    
	    
	    
	    Thread.sleep(2000);
	    webActions.Click(addLender, "Add Lender"); //payment page
	    webActions.Click(lenderName, "name");
	    webActions.waitForVisible(lenderType);
	    webActions.selectByVisibleText(lenderType, "Disaster Agency");
	    webActions.Click(billToLender, "Yes for Bill To Lender");
	    webActions.clearAndSendKeys(loanNumber, "45242");
	    webActions.selectByVisibleText(financialInterest, "Building Only");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    Thread.sleep(3000);
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "Alana Ash - 123ALA4567");
	    webActions.Click(achUpload, "ACH(Upload)");
	    webActions.selectByVisibleText(noofDays, "3 Days");
	    webActions.Click(nextbutton, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(documents);
	    String policy_number = webActions.getElmText(policyNumber);
	    System.out.println("policy Number is : " + policy_number);
	    webActions.Click(documents, "Documents");
	    webActions.Click(quotePdf, "Flood quote PDF");
	    Thread.sleep(2000);
	    webActions.switchTab();
	    ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
		
		
        
  
		
	}
	
	
	/**
	 * =============================================================================
	 * Method: floodQuote_scenario_4 (garage attached) | Author: Sunil | Date:25th Feb 2021 |
	 * Description: New quote for flood with choosing different options| Parameters: None | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	
	public void floodQuoteScenario4() throws Exception{
		
		
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
		webActions.Click(zoneDetermindationYes, "yes for zone determination");
		webActions.Click(multipleStructuresNo, "No for multiple structures");
		Thread.sleep(4000);
		webActions.Click(nextbutton, "Next");
		Thread.sleep(4000);
		webActions.scrollDownUsingJS();
		webActions.Click(nextbutton, "Next");
		webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
	    webActions.Click(mandatoryPurchaseNo, "No for Mandatory purchase");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(condominium, "Other (Not a condo)");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
        
        webActions.Click(substantiallyImprovedYes, "yes for substantially improved yes");
        webActions.Click(substantiallyImprovedYesDate, "Date picker");
        webActions.Click(xpathofTodaysDate, "today's Date");
        webActions.selectByVisibleText(policyType, "Regular");
        webActions.Click(tenantYes, "yes - is the insured a tenant");
        webActions.Click(tenantInsurable, "yes - tenant has insurable interest");
        webActions.Click(nonProfitEntity, "No - not profit entity");
        ReportManager.logScreenshotInfo();
        Thread.sleep(2000);
        webActions.scrollDownUsingJS();
	    Thread.sleep(2000);
	    WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(nextbutton);
	    JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getInstance().getWebDriver();
	    executor.executeScript("arguments[0].click();", ele);
       // webActions.Click(nextbutton, "Next");
       
        webActions.waitForVisible(buildingPurpose);
        webActions.selectByVisibleText(buildingPurpose, "Mixed Use");
        webActions.clearAndSendKeys(percentageResArea, "70");      
        
        webActions.selectByVisibleText(buildingOccupancy, "Non-Residential - Business");
        webActions.selectByVisibleText(buildingDescription, "Detached Guest House");
        webActions.Click(underConstruction, "No for under construction");
        webActions.selectByVisibleText(overWater, "Not Over Water");
        webActions.selectByVisibleText(extensions, "None");
        webActions.Click(garageAttachedYes, "yes for garage attached");
        webActions.clearAndSendKeys(garageSquareFeet, "200");
        webActions.selectByVisibleText(garageFinished, "Finished");
        webActions.selectByVisibleText(garageUsedFor, "Parking");
        webActions.Click(garageContains, "No for Garage contains machinery or equipment on the garage floor");
        
        webActions.selectByVisibleText(isBasement, "None");
	    webActions.Click(oilPit, "no for Oil Pit");
	    webActions.Click(isElevated, "Building Elevated");
	    webActions.selectByVisibleText(slabDesign, "Slab on Natural Grade");
	    webActions.selectByVisibleText(noofFloors, "One Floor");
	    webActions.scrollDownUsingJS();
	    webActions.sendKeys(repleacementCost, "100000");
	    webActions.sendKeys(buildingCoverage, "100000");
	    Thread.sleep(3000);
	    webActions.sendKeys(contentCoverage, "100000");
	    Thread.sleep(3000);
	    
	    webActions.clearAndSendKeys(buildingOwnerFirstName, "test");
	    webActions.clearAndSendKeys(buildingOwnerLastName, "test");
	    webActions.clearAndSendKeys(buildingOwnerAddressOne, "1032 35TH AVE N");
	    webActions.selectByVisibleText(buildingOwnerState, "Florida");
	    webActions.clearAndSendKeys(buildingOwnerZip, "33704-1851");
	    
	    webActions.scrollDownUsingJS();
	    Thread.sleep(2000);
	    WebElement ele1 = DriverFactory.getInstance().getWebDriver().findElement(nextbutton);
	    JavascriptExecutor executor1 = (JavascriptExecutor)DriverFactory.getInstance().getWebDriver();
	    executor.executeScript("arguments[0].click();", ele1);
	    webActions.waitForVisible(deductible);
	    webActions.Click(deductible, "Premium by deductible combination");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "Close button");
	    
	  
	    Thread.sleep(2000);
	    webActions.Click(addLender, "Add Lender"); //payment page
	    webActions.Click(lenderName, "name");
	    webActions.waitForVisible(lenderType);
	    webActions.selectByVisibleText(lenderType, "First Mortgagee");
	    webActions.Click(billToLender, "Yes for Bill To Lender");
	    webActions.clearAndSendKeys(loanNumber, "45242");
	    webActions.selectByVisibleText(financialInterest, "Building Only");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    Thread.sleep(3000);
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "Alana Ash - 123ALA4567");
	    webActions.Click(achUpload, "ACH(Upload)");
	    webActions.selectByVisibleText(noofDays, "3 Days");
	    webActions.Click(nextbutton, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(documents);
	    String policy_number = webActions.getElmText(policyNumber);
	    System.out.println("policy Number is : " + policy_number);
	    webActions.Click(documents, "Documents");
	    webActions.Click(quotePdf, "Flood quote PDF");
	    Thread.sleep(2000);
	    webActions.switchTab();
	    ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
		
		
	}
	
	
	/**
	 * =============================================================================
	 * Method: floodQuoteScenario5 (Building Foundation - Subgrade Crawlspace) | Author: Sunil | Date:06 March 2021 |
	 * Description: New quote for flood with choosing different options | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	
	
	
	public void floodQuoteScenario5() throws Exception {
		
		webActions.Click(clickonnewquote, "click on new quote");
		webActions.Click(clickonfloodproduct, "click on flood product");
		webActions.Click(insuredBusinessYes, "YES radio");
		webActions.clearAndSendKeys(businessName, "test");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(businessName2, "test");
		webActions.clearAndSendKeys(email, "exampleone@gmail.com");
		webActions.clearAndSendKeys(telephone, "1234512345");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(street, "1032 35TH AVE N");
		webActions.clearAndSendKeys(city, "ST PETERSBURG");
		webActions.selectByVisibleText(By.xpath("//*[@id=\"tpstat\"]"), "FL");
		webActions.clearAndSendKeys(zip2, "33704-1851");
		webActions.Click(commericaladdresscheckboxyes, "Commercial address Check Box");
		webActions.Click(nextbutton, "Next Button");
		Thread.sleep(3000);
		webActions.Click(samePrpoertyAdress, "Same property address");
		webActions.Click(zoneDetermindationYes, "yes for zone determination");
		webActions.Click(multiplestructures, "yes - multiple structures");
		Thread.sleep(4000);
		webActions.clearAndSendKeys(multipleStructuresDescription, "abc");
		webActions.Click(nextbutton, "Next");
		webActions.scrollDownUsingJS();
		webActions.Click(nextbutton, "next");
		webActions.waitForVisible(waitingPeriod);
	    webActions.selectByVisibleText(waitingPeriod, "Standard 30 Day Wait");
	    webActions.Click(mandatoryPurchaseNo, "No for Mandatory purchase");
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(condominium, "Condo Association-Commercial");
	    webActions.Click(datePicker, "Datepicker to choose date");
	    Thread.sleep(2000);
	    
	    Date date=java.util.Calendar.getInstance().getTime();
		int today = date.getDate();
		By xpathofTodaysDate = By.xpath("//a[text()='"+today+"']");
        webActions.Click(xpathofTodaysDate, "Date");
        webActions.Click(substantiallyImprovedYes, "yes for substantially improved yes");
        webActions.Click(substantiallyImprovedYesDate, "Date picker");
        webActions.Click(xpathofTodaysDate, "today's Date");
        webActions.selectByVisibleText(policyType, "Preferred");
        webActions.Click(aTenant, "No - tenant has insurable interest");
        webActions.Click(rentalPropertyYes, "yes for rental property");
        webActions.Click(nonProfitEntity, "No - not profit entity");
        webActions.Click(purchaseDatePicker, "click on purchased date picker");
        webActions.Click(xpathofTodaysDate, "Date");
        Thread.sleep(2000);
        webActions.Click(disasterAssistanceYes, "yes - Is insurance required for disaster assistance");
        Thread.sleep(2000);
        webActions.selectByVisibleText(governmentAgency, "SBA");
        webActions.clearAndSendKeys(caseFileNumber, "12345");
        webActions.selectByVisibleText(buildingOccupancy, "Other Non-Residential");
        webActions.selectByVisibleText(buildingDescription, "Detached Guest House");
        webActions.Click(underConstruction, "No for under construction");
        webActions.selectByVisibleText(overWater, "Not Over Water");
        webActions.selectByVisibleText(extensions, "None");
        webActions.Click(garageAttachedYes, "yes for garage attached");
        webActions.clearAndSendKeys(garageSquareFeet, "200");
        webActions.clearAndSendKeys(noofPermanentOpenings2, "22");
        webActions.clearAndSendKeys(totalNetArea2, "200");
        Thread.sleep(3000);
        webActions.selectByVisibleText(isBasement, "Subgrade Crawlspace");
        webActions.Click(oilPit, "No for Oil Pit");
        webActions.selectByVisibleText(foundationType, "Piles");
        webActions.selectByVisibleText(noofFloors, "Two Floors");
        webActions.sendKeys(repleacementCost, "100000");
        webActions.selectByVisibleText(contentsLoation, "Basmnt/Encl/Crawlspc and Above");
        webActions.Click(contentsOnly, "No for contents only");
        
        webActions.Click(nextbutton, "Next");
	    webActions.scrollDownUsingJS();
	    webActions.Click(maximumPremium, "Maximum premium value");
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(xButton);
	    webActions.Click(xButton, "Close button");
	    webActions.Click(nextbutton, "Next");
	    
	    webActions.Click(addLender, "Add Lender"); //payment page
	    webActions.Click(lenderName, "name");
	    webActions.waitForVisible(lenderType);
	    webActions.selectByVisibleText(lenderType, "Disaster Agency");
	    webActions.Click(billToLender, "Yes for Bill To Lender");
	    webActions.clearAndSendKeys(loanNumber, "45242");
	    webActions.selectByVisibleText(financialInterest, "Building Only");
	    webActions.scrollDownUsingJS();
	    webActions.Click(nextbutton, "Next");
	    Thread.sleep(3000);
	    webActions.Click(nextbutton, "Next");
	    webActions.waitForVisible(licensedAgent);
	    webActions.selectByVisibleText(licensedAgent, "Alana Ash - 123ALA4567");
	    webActions.Click(achUpload, "ACH(Upload)");
	    webActions.selectByVisibleText(noofDays, "3 Days");
	    webActions.Click(nextbutton, "Next");
	    Alert alert = DriverFactory.getInstance().getWebDriver().switchTo().alert();
	    alert.accept();
	    webActions.waitForVisible(documents);
	    String policy_number = webActions.getElmText(policyNumber);
	    System.out.println("policy Number is : " + policy_number);
	    webActions.Click(documents, "Documents");
	    webActions.Click(quotePdf, "Flood quote PDF");
	    Thread.sleep(2000);
	    webActions.switchTab();
	    ReportManager.logScreenshotInfo();
		Thread.sleep(2000);
		
	}
	
	
}
