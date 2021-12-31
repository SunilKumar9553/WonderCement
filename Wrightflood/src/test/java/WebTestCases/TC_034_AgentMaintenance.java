package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import Utilities.ConfigReader;
import WebPages.Agent;
import WebPages.FloodQuote;

@Listeners({ SuiteEvent.class , WebEvent.class})
public class TC_034_AgentMaintenance {
	
	
	@Test(description = "going to the agent maintenance page", groups = { "smoke", "regression",
	"Web Application" })
	public void TC_034_agentMaintenance() throws Exception {
		
		FloodQuote floodQuote = new FloodQuote();
		Agent agent = new Agent();

		floodQuote.wrightlogin(ConfigReader.getValue("adminUserName"), ConfigReader.getValue("adminPassWord"));
		agent.openAgenMaintenance();
		
	}

}
