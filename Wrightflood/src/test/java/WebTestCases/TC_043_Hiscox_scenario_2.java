package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.Hiscox;


@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_043_Hiscox_scenario_2 {
	
	@Test(description = "Creating hiscox quote", groups = { "smoke", "regression",
	"Web Application" })
	
	
	public void TC_043_hiscox_scenario_2() throws Exception {
		
	
	FloodQuote floodQuote = new FloodQuote();
    Hiscox hiscox = new Hiscox();
	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	hiscox.hiscoxQuote2();	
	
	}
}
