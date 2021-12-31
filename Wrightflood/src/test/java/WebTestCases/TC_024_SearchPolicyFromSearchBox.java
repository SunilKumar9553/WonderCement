package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.PolicySearchBox;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_024_SearchPolicyFromSearchBox {
	
	@Test(description = "Policy search", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_024_searchPolicyFromSearchBox() throws Exception {
		
		FloodQuote floodQuote = new FloodQuote();
		PolicySearchBox policySearch = new PolicySearchBox();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		policySearch.searchPolicyFromSearchBox();
		Thread.sleep(6000);
		policySearch.searchPolicyFromSearchBoxwithName();
	}
	

}
