package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;

import WebPages.FloodQuote;
import WebPages.NegativeFlowQuoteSearch;




@Listeners({ SuiteEvent.class, WebEvent.class })


public class TC_022_NegativeFlowQuoteSearch {
	
	/**
	 * =============================================================================
	 * Method: TC_022_NegativeFlowQuoteSearch | Author: Samadrita Guha | Date:10 Dec 2020 |
	 * Description: Negative flow for quote search | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Negative flow for quote search", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_022_NegativeFlowQuoteSearch() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	NegativeFlowQuoteSearch negativeFlowQuoteSearch = new NegativeFlowQuoteSearch();
	

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	negativeFlowQuoteSearch.NegativeFlowQuoteSearchProcess();
	

}

}
