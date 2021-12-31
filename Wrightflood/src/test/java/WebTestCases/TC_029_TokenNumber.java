package WebTestCases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.TokenNumber;


@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_029_TokenNumber {
	
	@Test(description = "Copying the Token number into the Token To test the skinned SSO test", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_029_tokenNumber() throws Exception {
		
		TokenNumber tokenNumber = new TokenNumber();
		tokenNumber.loginTotestPage();
		tokenNumber.tokenNumber();
	}

}
