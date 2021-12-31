package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.Reports;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_005_Reports {

	/**
	 * =============================================================================
	 * Method: TC_005_Reports | Author: Samadrita Guha | Date:24 Sept 2020 |
	 * Description: Extract reports from application | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Reports", groups = { "smoke", "regression",
	"Web Application" })
	
     public void TC_005_reports() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	Reports reports = new Reports();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	reports.ExtractReports();
	
}
}


