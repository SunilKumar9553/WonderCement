package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.Reports;
import WebPages.Validations;

@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_023_Validations {
	
	/**
	 * =============================================================================
	 * Method: TC_023_Validations | Author: Samadrita Guha | Date:11 Dec 2020 |
	 * Description: Checking the presence of required fields | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Validations", groups = { "smoke", "regression",
	"Web Application" })
	
     public void TC_023_Validations() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	Validations validations = new Validations();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	validations.ValidatingRequiredElements();
	
}

}
