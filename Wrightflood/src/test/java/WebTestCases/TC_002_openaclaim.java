package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.Openaclaim;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_002_openaclaim {

	/**
	 * =============================================================================
	 * Method: TC_002_Openaclaim | Author: Rajesh Buddha | Date:16 Aug 2020 |
	 * Description: Create claim for policy number | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	@Test(description = "Create claim for policy number", groups = { "smoke", "regression", "Web Application" })
	public void TC_002_Openaclaim() throws Exception {

		FloodQuote floodQuote = new FloodQuote();
		Openaclaim openaclaim = new Openaclaim();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		openaclaim.claim(ConfigReader.getValue("policyNumber"), ConfigReader.getValue("dateofLoss"));

	}

}