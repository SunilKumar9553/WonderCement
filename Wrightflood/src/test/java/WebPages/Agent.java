package WebPages;

import java.io.IOException;

import org.openqa.selenium.By;

import Utilities.ReportManager;
import WebUtil.WebActions;

public class Agent {
	
	// ==========================Objects==================================
		WebActions webActions = new WebActions();

	// ==========================Locators==================================
		public static By mainAgent = By.xpath("//a[text()='Agent']");
		public static By agtMaintenance = By.xpath("//a[text()='Agt Maintenance']");

		
		
		
		/**
		 * =============================================================================
		 * Method: openAgentMaintenance | Author: Sunil | Date:4th Feb 2021 |
		 * Description: opening agent maintenance page | Parameters: None |
		 * Return: None
		 * =============================================================================
		 * @throws InterruptedException 
		 * 
		 * @throws Exception
		 */
		public void openAgenMaintenance() throws InterruptedException, IOException {
			
			webActions.Click(mainAgent, "Agent");
			Thread.sleep(2000);
			webActions.Click(agtMaintenance, "Agt Maintenance");
			Thread.sleep(5000);
			ReportManager.logScreenshotInfo();
		}
}
