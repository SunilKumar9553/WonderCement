package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.ZurichFloodQuote;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_006_ZurichFloodQuote {
	
	/**
	 * =============================================================================
	 * Method: TC_006_ZurichFloodQuote | Author: Samadrita Guha | Date:23 Sept 2020 |
	 * Description: Process Zurich Flood Quote Product | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Zurich Flood Quote", groups = { "smoke", "regression",
	"Web Application" })
    public void TC_006_zurichFloodQuote() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	ZurichFloodQuote zurichFlood = new ZurichFloodQuote();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	zurichFlood.ProcessZurichFloodQuote();
	
//	zurichFlood.openQuoteandAppPDFs();
	
}

}
