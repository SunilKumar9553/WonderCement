package WebTestCases;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.PolicySearch;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_013_PolicySearch {
	
	/**
	 * =============================================================================
	 * Method: TC_013_policySearch | Author: Samadrita Guha | Date:6 Oct 2020 |
	 * Description: Searching policies with policy number | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Policy search", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_013_policySearch() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	PolicySearch policySearch = new PolicySearch();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	policySearch.PolicySearchProcess();

}
}
