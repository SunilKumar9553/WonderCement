package AndroidTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AndroidPages.AndroidHomePage;
import TestNGListeners.MobileEvent;
import TestNGListeners.SuiteEvent;

@Listeners({SuiteEvent.class,MobileEvent.class})
public class TC_001{

	@Parameters({"platform", "udid", "systemPort","deviceName"})
	@Test(description="This is simple test",groups = { "smoke", "regression","MobileApplication" })
	public void FlipKartLogin() throws InterruptedException{
		AndroidHomePage homePage = new AndroidHomePage();
		homePage.Login();
		
	}

	
}