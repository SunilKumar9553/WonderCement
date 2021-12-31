package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.InclineFlood;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_049_Inclined_scenario_3 {

	@Test(description = "creating incline flood quote", groups = { "smoke", "regression", "Web Application" })
	public void TC_049_inclined_scenario_3() throws Exception {

		FloodQuote floodQuote = new FloodQuote();
		InclineFlood inclineFlood = new InclineFlood();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		inclineFlood.inclinedQuoteScenario3();

	}

}
