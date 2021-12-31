package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.NegativeFlowClaimSearch;
import WebPages.QuoteSearch;

@Listeners({ SuiteEvent.class, WebEvent.class })


public class TC_020_NegativeFlowClaimSearch {
	
	/**
	 * =============================================================================
	 * Method: TC_020_NegativeFlowClaimSearch | Author: Samadrita Guha | Date:7 Dec 2020 |
	 * Description: Negative flow for claim search | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Negative flow for claim search", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_020_NegativeFlowClaimSearch() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	NegativeFlowClaimSearch negativeFlowClaimSearch = new NegativeFlowClaimSearch();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	negativeFlowClaimSearch.NegativeFlowClaimSearchProcess();
	
	}

}
