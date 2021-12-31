package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.PolicySearchBox;
import WebPages.ZurichFloodQuote;


@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_030_OpenQuoteandAppPDFs {
	
	
	@Test(description = "Validating the quote pdf and app pdfs are printable after creating a quote", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_030_openQuoteandAppPDFs() throws Exception {
		
		FloodQuote floodQuote = new FloodQuote();
		ZurichFloodQuote zurichFlood = new ZurichFloodQuote();
		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		zurichFlood.openQuoteandAppPDFs();
		
	}

}
