package WcTestCases;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WcWebPages.PoWorkflow;
import WcWebPages.multiplePRs;
import WebPages.WCPrToPo;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class PrToPoFlow {
	@Test(description = "Upload file", groups = { "smoke", "regression",
	"Web Application" })
	public void loginToWonderCement() throws Exception {
		
//		WCPrToPo pr = new WCPrToPo();
		multiplePRs mpr = new multiplePRs();
		
		mpr.wonderCementLogin();
		mpr.createPRheader();
		

	}

}
