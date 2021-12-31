package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.QuoteSearch;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_014_QuoteSearch {
	
	/**
	 * =============================================================================
	 * Method: TC_014_quoteSearch | Author: Samadrita Guha | Date:7 Oct 2020 |
	 * Description: Searching policies with policy number | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Quote search", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_014_quoteSearch() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	QuoteSearch quoteSearch = new QuoteSearch();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	quoteSearch.QuoteSearchProcess();
	
	}

}
