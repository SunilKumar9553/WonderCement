package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ClaimSearch;
import WebPages.FloodQuote;
import WebPages.NegativeFlowReports;
import WebPages.PolicySearch;



@Listeners({ SuiteEvent.class, WebEvent.class })


public class TC_019_NegativeFlowReports {
	
	/**
	 * =============================================================================
	 * Method: TC_019_NegativeFlowReports | Author: Samadrita Guha | Date:6 Dec 2020 |
	 * Description: Checking negative flow for reports | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Negative flow for reports", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_019_NegativeFlowReports() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	NegativeFlowReports negativeflowReports = new NegativeFlowReports();
	

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	negativeflowReports.NegativeFlowForReports();
	

}

}
