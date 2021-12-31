package WcTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WcWebPages.ReturnableGatePass;



@Listeners({ SuiteEvent.class, WebEvent.class })
public class ReturnableGatePassTest {
	

	@Test(description = "Returable gate pass creation", groups = { "smoke", "regression",
	"Web Application" })
	public void returnableGatePass() throws Exception {
		
		ReturnableGatePass pass = new ReturnableGatePass();
		pass.rgpReturn("2");
	}
	

}
