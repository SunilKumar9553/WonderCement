package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;

import WebPages.FileuploadforPolicy;
import WebPages.FloodQuote;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_004_Test {

	/**
	 * =============================================================================
	 * Method: TC_001_Fileupload | Author: Rajesh Buddha | Date:16 Aug 2020 |
	 * Description: File upload | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	@Test(description = "Upload file", groups = { "smoke", "regression",
			"Web Application" })
	public void TC_001_Fileupload() throws Exception {

		//CreatePolicy createPolicy = new CreatePolicy();
		//createPolicy.wright();
		
		
	}

}