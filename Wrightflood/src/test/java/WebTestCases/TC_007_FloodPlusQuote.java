package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodPlusQuote;
import WebPages.FloodQuote;


@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_007_FloodPlusQuote{
	
	/**
	 * =============================================================================
	 * Method: TC_002_Openaclaim | Author: Samadrita Guha | Date:22 Aug 2020 |
	 * Description: Flood plus quote process | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Flood plus quote", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_007_floodPlusQuote() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	FloodPlusQuote floodPlus = new FloodPlusQuote();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	floodPlus.FloodPlus();
	
}

}


