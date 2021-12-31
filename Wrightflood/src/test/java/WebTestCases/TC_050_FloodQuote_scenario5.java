package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;



@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_050_FloodQuote_scenario5 {
	
	
	@Test(description = "creating a flood quote ", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_050_floodQuote_scenario5() throws Exception {
		

		FloodQuote floodQuote = new FloodQuote();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		floodQuote.floodQuoteScenario5();
	}

}
