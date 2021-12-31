package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.ZurichFloodQuote;



@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_044_ZurichQuote_scenario_2 {
	
	@Test(description = "Zurich Flood Quote", groups = { "smoke", "regression",
	"Web Application" })
    public void TC_044_zurichQuote_scenario_2() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	ZurichFloodQuote zurichFlood = new ZurichFloodQuote();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	zurichFlood.zurichQuoteScenario2();
	
//	zurichFlood.openQuoteandAppPDFs();
	
}

}
