package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.InclineFlood;


@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_037_InclineFloodQuote {
	
	
	@Test(description = "creating incline flood quote", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_038_inclineFloodQuote() throws Exception {
		
		

		FloodQuote floodQuote = new FloodQuote();
	    InclineFlood inclineFlood = new InclineFlood();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		inclineFlood.inclineFloodQuote();
		
	}

}
