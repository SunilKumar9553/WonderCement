package WebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utilities.DriverFactory;
import Utilities.ReportManager;
import WebUtil.WebActions;


public class TokenNumber {
	
	// ==========================Objects==================================
		WebActions webActions = new WebActions();
		WebDriver driver;  

	// ==========================Locators==================================
		
		public static By username = By.xpath("(//input)[1]");
		public static By password = By.xpath("(//input)[2]");
		public static By loginButton = By.xpath("(//input)[3]");
		public static By usernameTestPage = By.xpath("//input[@id='username']");
		public static By passwordTestPage = By.xpath("//input[@id='password']");
		public static By clientId = By.xpath("//input[@id='clientId']");
		public static By singleSignIn = By.xpath("//input[@value='Single Sign-On']");
		public static By tokenElement = By.xpath("//textarea[@class='xmlText']");
		public static By tokenInput = By.xpath("//input[@id='token']");
		public static By ssoButton = By.xpath("//input[@class='buttonStyle']");
		public static By floodPortalWithoutXml = By.xpath("//input[@value='Launch FloodPortal without XML']");
		public static By propertyAddress = By.xpath("//input[@id='places-search']");
		public static By editAddress = By.xpath("//div[@id='address-form-toggle']");
		public static By street = By.xpath("//input[@id='addressLine1']");
		public static By city = By.xpath("//input[@id='city']");
		public static By state = By.xpath("//input[@id='state']");
		public static By zip = By.xpath("//input[@id='zipCode']");
		public static By typeOfHome = By.xpath("(//a[@class='dd-selected'])[1]");
		public static By singleFamily = By.xpath("//label[text()='Single Family Home']");
		public static By noClaim = By.xpath("//label[@class='tloss-no']");
		public static By next = By.xpath("//button[@id='section-property-next-button']");
		public static By keepChange = By.xpath("//span[text()='Keep Change']");
		public static By coverage = By.xpath("(//input[@class='rate-radio'])[1]");
		public static By isPrimaryResidence = By.xpath("//input[@id='tprncp-c']");
		public static By next2 = By.xpath("//button[@id='section-coverage-next-button']");
		public static By hasBasement = By.xpath("(//a[@class='dd-selected'])[2]");
		public static By None = By.xpath("//*[text()='None']");
		public static By isGarage = By.xpath("//label[@class='tgatch-no']");
		public static By underConstruction = By.xpath("//label[@class='tblgcs-no']");
		public static By completionYear = By.xpath("//input[@id='tcstdxYear']");
		public static By permitDate = By.xpath("//input[@id='tcnstyp-original']");
		public static By oneFloor = By.xpath("//label[text()='One Floor']");
		public static By next3 = By.xpath("//button[@id='section-construction-next-button']");
		public static By quoteNumber = By.xpath("(//*[text()='Reference:']//following::td)[1]");
		public static By premium = By.xpath("(//*[text()='The premium for your property has been adjusted']//following::td)[1]");
		public static By paymentInformation = By.xpath("//a[text()='Policy and Payment']");
		
		
		
		
		/**
		 * =============================================================================
		 * Method: loginTotestPage | Author: Sunil | Date:27 jan 2021 |
		 * Description: Copying the Token number into the Token To test the skinned SSO test | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */
		
		
		public void loginTotestPage() throws InterruptedException {
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sunil\\Desktop\\chromedriver_win32\\chromedriver.exe");
				driver =  DriverFactory.getInstance().getWebDriver();
			    driver.get(" https://www.wrightflood.net/FloodPortal/admin/testPage");
			    
			    webActions.clearAndSendKeys(username, "admin");
			    webActions.clearAndSendKeys(password, "nimda");
			    webActions.Click(loginButton, "login");
			    Thread.sleep(3000);
			
		}
	
		
		/**
		 * =============================================================================
		 * Method: tokenNumber | Author: Sunil | Date:27 jan 2021 |
		 * Description: Copying the Token number into the Token To test the skinned SSO test | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */
		
		public void tokenNumber() throws InterruptedException, IOException {
		
		    webActions.clearAndSendKeys(usernameTestPage, "THIGMAINGP");
		    webActions.clearAndSendKeys(passwordTestPage, "M3L2P9F8ER");
		    webActions.clearAndSendKeys(clientId, "ZKURTEVA@FL0052");
		    webActions.Click(singleSignIn, "single sign in");
		    Thread.sleep(2000);
		    
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    String tokenText = driver.findElement(tokenElement).getText().toString();
		   
		    System.out.println("token text "+ tokenText);
		    
		    String str = tokenText;
			Pattern p = Pattern.compile("(?<=\\<Token\\>)(\\s*.*\\s*)(?=\\<\\/Token\\>)");
			Matcher m = p.matcher(str);
			while(m.find()){
	
			   System.out.printf(m.group());
			   driver.findElement(tokenInput).sendKeys(m.group());
			}
			
			driver.findElement(ssoButton).click();
			webActions.switchTab();
			Thread.sleep(15000);
			ReportManager.logScreenshotInfo();
			Thread.sleep(2000);
			
		    
	}
		
		/**
		 * =============================================================================
		 * Method: nonSkinnedTest | Author: Sunil | Date:27 jan 2021 |
		 * Description:  test the non-skinned SSO test | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * @throws Exception 
		 * 
		 * @throws Exception
		 */
		
		
		public void nonSkinnedTest() throws Exception {
			
			
			webActions.clearAndSendKeys(usernameTestPage, "WSTEST");
			webActions.clearAndSendKeys(passwordTestPage, "RISEUP0911");
			webActions.Click(floodPortalWithoutXml, "Launch flood portal without xml");
			webActions.switchTab();
			webActions.Click(editAddress, "Edit address lines");
			webActions.clearAndSendKeys(street, "1032 35th Ave N");
			webActions.clearAndSendKeys(city, "St. Petersburg");
			webActions.clearAndSendKeys(state, "FL");
			webActions.clearAndSendKeys(zip, "33704");
			webActions.Click(editAddress, "Search address");
			webActions.Click(propertyAddress, "Property Address");
			Thread.sleep(2000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(typeOfHome, "Type of Home");
			webActions.Click(singleFamily, "Single Family Home");
			webActions.Click(noClaim, "No");
			
			webActions.Click(next, "Next");
			webActions.waitForVisible(coverage);
			Thread.sleep(2000);
			webActions.Click(coverage, "Coverage");
			webActions.Click(isPrimaryResidence, "80% or more");
			webActions.Click(next2, "Next");
			Thread.sleep(2000);
			webActions.Click(hasBasement, "Construction of Building");
			webActions.Click(None, "None");
			webActions.Click(isGarage, "attached garage");
			webActions.Click(underConstruction, "Under Construction");
			webActions.clearAndSendKeys(completionYear, "2016");
			webActions.Click(permitDate, "Building permit date");
			webActions.Click(oneFloor, "One Floor");
			webActions.Click(next3, "Next");
			webActions.waitForVisible(paymentInformation);
			WebElement element = driver.findElement(quoteNumber);
			System.out.println("title : "+ driver.getTitle());
			Assert.assertEquals(element.isDisplayed(), true);
			ReportManager.logScreenshotInfo();
			ReportManager.logPass("the quotation number is displayed: " + element.getText().toString());
			Thread.sleep(2000);
			driver.navigate().refresh();
			webActions.waitForVisible(premium);
			WebElement prem = driver.findElement(premium);
			Assert.assertEquals(prem.isDisplayed(), true);
			ReportManager.logScreenshotInfo();
			ReportManager.logPass("the quotation number is displayed: " + prem.getText().toString());
			ReportManager.logPass("the premium amount is displayed");
			Thread.sleep(10000);
			
		}

}









