package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.Hiscox;


@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_036_HiscoxQuote {
	
	
	@Test(description = "Creating hiscox quote", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_036_hiscoxQuote() throws Exception {
		
		FloodQuote floodQuote = new FloodQuote();
	    Hiscox hiscox = new Hiscox();
		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		hiscox.hiscoxQuote();
	}

}
