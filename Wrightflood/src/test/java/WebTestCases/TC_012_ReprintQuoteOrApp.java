package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.ReprintQuoteOrApplication;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_012_ReprintQuoteOrApp {

	/**
	 * =============================================================================
	 * Method: TC_012_reprintQuoteOrApp | Author: Samadrita Guha | Date:8 Oct 2020 |
	 * Description: Reprinting quote details by providing quote number | Parameters:
	 * None | Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	//@Test(description = "Reprint Quote or App", groups = { "smoke", "regression", "Web Application" })

	public void TC_012_reprintQuoteOrApp() throws Exception {

		FloodQuote floodQuote = new FloodQuote();
		ReprintQuoteOrApplication rePrintQuoteOrApp = new ReprintQuoteOrApplication();
		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		rePrintQuoteOrApp.ReprintQuoteOrApplicationPDF();

	}

	
	
}
