package AndroidTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AndroidPages.AndroidHomePage;
import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_002 {

	@Test(groups = { "regression", "MobileApplication" })
	public void test() throws InterruptedException {
		AndroidHomePage homePage = new AndroidHomePage();
		homePage.invalidLogin();
		
	}

}