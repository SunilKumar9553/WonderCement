package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ExpiringPilicies;
import WebPages.FloodQuote;
import WebPages.NonRenewals;
import WebPages.PendingInsurance;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_017_ExpiringPolicies {
	
	/**
	 * =============================================================================
	 * Method: TC_017_expiringPolicies | Author: Samadrita Guha | Date:23 Oct 2020 |
	 * Description: Expiring policies process  | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Expiring policies", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_017_expiringPolicies() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	ExpiringPilicies expiringPolicies = new ExpiringPilicies();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	expiringPolicies.ExpiringPiliciesProcess();
	
}


}
