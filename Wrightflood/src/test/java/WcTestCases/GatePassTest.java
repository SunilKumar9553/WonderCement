package WcTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WcWebPages.GatePassPage;
import WcWebPages.multiplePRs;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class GatePassTest {
	@Test(description = "Gate Pass", groups = { "smoke", "regression",
	"Web Application" })
	public void gatePassCreation() throws Exception {
		
		
		GatePassPage gatePass = new GatePassPage();
		gatePass.createGatePass();
		

	}

}
