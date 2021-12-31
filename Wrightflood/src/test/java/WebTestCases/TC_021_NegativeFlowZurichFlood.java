package WebTestCases;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ClaimSearch;
import WebPages.FloodQuote;
import WebPages.NegativeFlowZurichFlood;
import WebPages.PolicySearch;


@Listeners({ SuiteEvent.class, WebEvent.class })


public class TC_021_NegativeFlowZurichFlood {
	
	/**
	 * =============================================================================
	 * Method: TC_021_NegativeFlowZurichFlood | Author: Samadrita Guha | Date:8 Oct 2020 |
	 * Description: Negative flow for Zurich Flood | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Negative flow for Zurich flood", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_021_NegativeFlowZurichFlood() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	NegativeFlowZurichFlood negativeFlowZurichFlood = new NegativeFlowZurichFlood();
	

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	negativeFlowZurichFlood.NegativeFlowZurichFloodQuote();
	}	

}
