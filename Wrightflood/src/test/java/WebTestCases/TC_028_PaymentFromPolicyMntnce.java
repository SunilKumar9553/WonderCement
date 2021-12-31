package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.PolicyMaintenance;
import WebPages.PolicySearchBox;


@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_028_PaymentFromPolicyMntnce {
	

	@Test(description = "payment from policy Maintanance page", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_028_paymentFromPolicyMntnce() throws Exception {
		
		FloodQuote floodQuote = new FloodQuote();
		PolicySearchBox policySearch = new PolicySearchBox();
		PolicyMaintenance policyMantnce = new PolicyMaintenance();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		policySearch.searchPolicyFromSearchBox();
		policyMantnce.paymentFromPolicyMntnce();
		
	}

}
