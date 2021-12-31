package WcTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WcWebPages.NonReturnableGatePass;


@Listeners({ SuiteEvent.class, WebEvent.class })
public class NonReturnableGatePassTest {
	
	
	@Test(description = "Non Returable gate pass creation", groups = { "smoke", "regression",
	"Web Application" })
	public void createNonReturnable() throws Exception {
		
		NonReturnableGatePass pass = new NonReturnableGatePass();
		pass.createNonReturnableGatePass();
		
	}

}
