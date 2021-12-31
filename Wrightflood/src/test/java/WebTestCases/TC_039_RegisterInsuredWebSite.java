package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.InsuredWebSite;


@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_039_RegisterInsuredWebSite {
	
	@Test(description = "Registration through insured website", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_039_registerInsuredWebSite() throws Exception {
	  
		InsuredWebSite insuredWebSite = new InsuredWebSite();
		insuredWebSite.registerInsuredWebSite();
	  
  }

}
