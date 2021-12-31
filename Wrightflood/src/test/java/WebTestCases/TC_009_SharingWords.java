package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.FloodQuote;
import WebPages.SharingWords;


@Listeners({ SuiteEvent.class, WebEvent.class })

public class TC_009_SharingWords {

	
	/**
	 * =============================================================================
	 * Method: TC_009_sharingWords | Author: Samadrita Guha | Date:12 Oct 2020 |
	 * Sharing words process | Parameters: None | 
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */

	@Test(description = "Sharing words", groups = { "smoke", "regression",
	"Web Application" })
	
    public void TC_009_sharingWords() throws Exception {
	
	FloodQuote floodQuote = new FloodQuote();
	SharingWords sharingWords = new SharingWords();

	floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
	sharingWords.processSharingWords();
}
	
}
