package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.PolicyMaintenance;


@Listeners({ SuiteEvent.class, WebEvent.class })


public class TC_008_PolicyMaintenance {
	
	/**
	 * =============================================================================
	 * Method: TC_008_policyMaintenance | Author: Samadrita Guha | Date:5 Oct 2020 |
	 * Description: Policy maintenance process | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Policy maintenance", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_008_policyMaintenance() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	PolicyMaintenance policyMaintenance = new PolicyMaintenance();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	policyMaintenance.PolicyMaintenanceProcess();
	

}
}
