package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_003_wrightfloodquote {

	/**
	 * =============================================================================
	 * Method: TC_003_Wrightfloodquote | Author: Rajesh Buddha | Date:16 Aug 2020 |
	 * Description: Wright flood quote | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Wright flood quote", groups = { "smoke", "regression", "MobileApplication" })
	public void TC_003_Wrightfloodquote() throws Exception {

		FloodQuote floodQuote = new FloodQuote();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		floodQuote.TCfloodquote();

	}

}