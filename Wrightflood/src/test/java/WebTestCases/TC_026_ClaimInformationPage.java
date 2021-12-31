package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.Openaclaim;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_026_ClaimInformationPage {
	String policyNumber = "099000033469 00";
	
	@Test(description = "going to claim information page from open claim tab", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_026_claimInformationPage() throws Exception {
		FloodQuote floodQuote = new FloodQuote();
		Openaclaim openClaim = new Openaclaim();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		openClaim.claimInformationPage(policyNumber);
		
	}

}
