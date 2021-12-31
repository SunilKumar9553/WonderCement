package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.InsuredWebSite;


@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_040_PolicyOverViewOpenClaim {
	
	
	@Test(description = "Clicking on Open Claim tab in policy overView page from guest Sign in", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_040_policyOverViewOpenClaim() throws Exception {
		
		InsuredWebSite insuredWebSite = new InsuredWebSite();
		insuredWebSite.policyOverViewOpenClaim();
		
	}

}
