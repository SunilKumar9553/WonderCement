package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FileuploadforPolicy;
import WebPages.FloodQuote;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_001_fileupload {

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

		FloodQuote floodQuote = new FloodQuote();
		FileuploadforPolicy fileuploadforPolicy = new FileuploadforPolicy();
		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		fileuploadforPolicy.fileupload(ConfigReader.getValue("policyNumber"));

	}

}