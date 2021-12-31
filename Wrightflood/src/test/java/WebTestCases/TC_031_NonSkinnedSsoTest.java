package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.TokenNumber;


@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_031_NonSkinnedSsoTest {
	
	
	
	@Test(description = "test the non-skinned SSO test", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_031_nonSkinnedSsoTest() throws Exception {
		
		TokenNumber tokenNumber = new TokenNumber();
		tokenNumber.loginTotestPage();
		tokenNumber.nonSkinnedTest();
		
	}
}
