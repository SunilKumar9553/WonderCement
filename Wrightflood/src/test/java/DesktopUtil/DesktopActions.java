package DesktopUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.DriverFactory;
import Utilities.ReportManager;

public class DesktopActions {

	// DriverFactory.getInstance().getWindowDriver()
	/**
	 * =============================================================================
	 * Method: waitForVisible | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 60 sec | Parameters: locator | Return: element
	 * =============================================================================
	 */
	@SuppressWarnings("deprecation")
	public static WebElement waitForVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWindowDriver(), 60);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * =============================================================================
	 * Method: Click | Author: Rajesh Buddha | Date:16 Jan 2020 | Description: This
	 * method click on element | Parameters: locator, info | Return: none
	 * =============================================================================
	 */
	public static void click(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		ReportManager.logInfo("Successfully clicked on - " + info);
		//LogClass.loginfo("Successfully clicked on - " +info);

	}

	public static void click(By locator) {
		WebElement elm = waitForVisible(locator);
		elm.click();
	}

	/**
	 * =============================================================================
	 * Method: sendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method enter text input text using element | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 */
	public static void sendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text -  <b style=\"color:green;\">" +text +"</b>");
		//LogClass.loginfo("Successfully Entered :" +text);
	}

	/**
	 * =============================================================================
	 * Method: sendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method enter text input text using element | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 */
	public static void sendKeys(By locator, String text,String info) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered "+info+" : <b style=\"color:green;\">" +text +"</b>");
		//LogClass.loginfo("Successfully Entered "+info+" :" +text);
	}
	/**
	 * =============================================================================
	 * Method: clearAndSendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method clear text in text box after that enter text using
	 * element | Parameters: locator, text | Return: none
	 * =============================================================================
	 */
	public void clearAndSendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.clear();
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text - " + text);
		//LogClass.loginfo("Successfully Entered text - " +text);

	}

	/**
	 * =============================================================================
	 * Method: getAttributeByInfo | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method returns value of attribute using element |
	 * Parameters: locator, attribute, info | Return: attribute_value string type
	 * =============================================================================
	 */

	public static String getAttributeByInfo(By element, String attribute, String info) throws Exception {

		WebElement ele = waitForVisible(element);
		String attribute_value = ele.getAttribute(attribute);
		ReportManager.logInfo(" " + info + "" + attribute_value);
		//LogClass.loginfo(" " + info + " " + attribute_value);

		return attribute_value;
	}

	/**
	 * =============================================================================
	 * Method: getAttributeBy | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method returns value of attribute using element |
	 * Parameters: locator, attribute | Return: attribute_value string type
	 * =============================================================================
	 */
	public static String getAttributeBy(By element, String attribute) throws Exception {

		WebElement ele = waitForVisible(element);
		return ele.getAttribute(attribute);

	}

	/**
	 * =============================================================================
	 * Method: enter | Author: Rajesh Buddha | Date:16 Jan 2020 | Description: enter
	 * method for enter keyboard action using respective element locator |
	 * Parameters: element | Return: none
	 * =============================================================================
	 */

	public static void enter(By element) throws Exception {

		WebElement ele = waitForVisible(element);
		ele.submit();
	}

	/**
	 * =============================================================================
	 * Method: textClear | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * textClear method used to clear the text using respective element locator |
	 * Parameters: element | Return: none
	 * =============================================================================
	 */
	public static void textClear(By element) throws Exception {
		WebElement ele = waitForVisible(element);
		ele.clear();
		ele.clear();
		ele.clear();
		ele.clear();
		ele.clear();
		ele.clear();
		ele.clear();

	}

	/**
	 * =============================================================================
	 * Method: img_Click | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method used for click on respective matching image | Parameters: image |
	 * Return: none
	 * =============================================================================
	 */

	/*public static void img_Click(String img) throws Exception {
		Thread.sleep(1000);
		Pattern username = new Pattern(img);
		s.click(username);
		Thread.sleep(1000);
	}*/

} // Calss ends
