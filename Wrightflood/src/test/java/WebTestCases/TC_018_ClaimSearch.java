package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ClaimSearch;
import WebPages.FloodQuote;




@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_018_ClaimSearch {
	
	/**
	 * =============================================================================
	 * Method: TC_013_policySearch | Author: Samadrita Guha | Date:6 Oct 2020 |
	 * Description: Searching policies with policy number | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "ClaimSearch", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_018_ClaimSearch() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	ClaimSearch claimsearch = new ClaimSearch();
	

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	claimsearch.ClaimSearchProcess();
	

}
}

