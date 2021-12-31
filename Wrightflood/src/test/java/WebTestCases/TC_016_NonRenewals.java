package WebTestCases;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.NonRenewals;
import WebPages.PendingInsurance;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_016_NonRenewals {
	
	/**
	 * =============================================================================
	 * Method: TC_016_NonRenewals | Author: Samadrita Guha | Date:20 Oct 2020 |
	 * Description: Non renewals Processing  | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Non renewals", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_016_nonRenewals() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	NonRenewals nonRenewals = new NonRenewals();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	nonRenewals.NonRenewalsProcess();
	
}

}
