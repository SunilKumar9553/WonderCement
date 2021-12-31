package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_032_MPPP {
	
	
	@Test(description = "creating a new quote •	Mortgage Portfolio Protection Program (MPPP) force placed policy", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_032_mppp() throws Exception {
		
		FloodQuote floodQuote = new FloodQuote();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		floodQuote.TCMPPPFloodQuote();
	}

}
