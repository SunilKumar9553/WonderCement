package WcTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WcWebPages.multiplePRs;
import WebPages.GateEntry;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class GateEntryTest {
	
	@Test(description = "Gate Entry", groups = { "smoke", "regression",
	"Web Application" })
	public void createGateEntry() throws Exception {
		
		multiplePRs pr = new multiplePRs();
		GateEntry gate = new GateEntry();
		pr.wonderCementLogin();
		gate.createGateEntry();
		
	}

}
