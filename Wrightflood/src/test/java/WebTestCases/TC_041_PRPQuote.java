package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;


@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_041_PRPQuote {

	
	
	@Test(description = "creating PRP quote", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_041_prpQuote() throws Exception {

		FloodQuote floodQuote = new FloodQuote();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		floodQuote.TCPRPQuote();

	}

}
