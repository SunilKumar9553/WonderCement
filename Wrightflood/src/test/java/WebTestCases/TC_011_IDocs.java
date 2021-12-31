package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.IDocs;


@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_011_IDocs {
	
	/**
	 * =============================================================================
	 * Method: TC_011_iDocs | Author: Samadrita Guha | Date:2 Oct 2020 |
	 * Description: iDocs of policies from the application | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "iDocs", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_011_iDocs() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	IDocs iDocs = new IDocs();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	iDocs.IDocsInfo();
	
	}
}
