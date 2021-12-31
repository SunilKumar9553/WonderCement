package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.RollOverReports;


@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_010_RollOverReports {
	
	/**
	 * =============================================================================
	 * Method: TC_010_rollOverReports | Author: Samadrita Guha | Date:23 Sept 2020 |
	 * Description: Extracting roll over reports from the application | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Roll over reports", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_010_rollOverReports() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	RollOverReports rollOverReports = new RollOverReports();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	rollOverReports.RollOverReportsProcess();

}
}
