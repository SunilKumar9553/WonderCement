package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.ExcessFloodProduct;
import WebPages.FloodQuote;


@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_033_ExcessFloodQuote {
		
		
		@Test(description = "creating excess flood quote", groups = { "smoke", "regression",
		"Web Application" })
		public void TC_033_excessFloodQuote() throws Exception {
			
			FloodQuote floodQuote = new FloodQuote();
			ExcessFloodProduct excessQuote = new ExcessFloodProduct();

			floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
			excessQuote.excessFloodQuote();
		}

	}


