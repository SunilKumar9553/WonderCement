package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.ReprintQuoteOrApplication;


@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_035_ReprintQuoteOrAppWithAppNumber {

	
	@Test(description = "Reprint Quote or App with application number", groups = { "smoke", "regression",
	"Web Application" })

	public void TC_012_reprintQuoteOrAppWithAppNumber() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	ReprintQuoteOrApplication rePrintQuoteOrApp = new ReprintQuoteOrApplication();
	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	rePrintQuoteOrApp.ReprintQuoteOrAppWithAppNumber();
	
	}
	
}
