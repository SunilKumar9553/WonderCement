package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;

@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_038_SFRQuote {
	
	
	@Test(description = "creating SFR quote", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_038_sfrQuote() throws Exception {
		FloodQuote floodQuote = new FloodQuote();
	
		
		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		floodQuote.TCSFRQuote();
	}

}
