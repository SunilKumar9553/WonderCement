package WebTestCases;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.PendingInsurance;


@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_015_PendingInsurance {
	
	/**
	 * =============================================================================
	 * Method: TC_015_pendingInsurance | Author: Samadrita Guha | Date:12 Oct 2020 |
	 * Description: Pending insurance process and making payment | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Pending Insurance", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_015_pendingInsurance() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	PendingInsurance pendingInsurance = new PendingInsurance();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	pendingInsurance.PendingInsuranceProcess();
	
}

}
