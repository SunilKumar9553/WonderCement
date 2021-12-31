package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;


@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_047_FloodQuote_scenario_3 {
	
	
	@Test(description = "creating a flood quote ", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_047_floodQuote_scenario_3() throws Exception {
		

		FloodQuote floodQuote = new FloodQuote();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		floodQuote.floodQuoteScenario3();
	}
	
	

}
