package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.PolicySearchBox;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_027_ClaimInfrmtnPagefromSearchBox {
	
	
	@Test(description = "going to claim information page from searching a policy from searhBox on home page", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_027_claimInfrmtnPageFromSearchBox() throws Exception {
		
		FloodQuote floodQuote = new FloodQuote();
		PolicySearchBox policySearch = new PolicySearchBox();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		policySearch.claimInfrmtnPageFromSearchBox();
		
	}

}
