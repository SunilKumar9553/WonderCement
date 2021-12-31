package DesktopTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.DesktopEvent;
import TestNGListeners.SuiteEvent;
import DesktopPages.*;

@Listeners({SuiteEvent.class,DesktopEvent.class})
public class TC_001{

	DesktopHomePage desktopHomePage =  new DesktopHomePage();
	
	@Test(description="This is simple test",groups = { "smoke", "regression","DesktopApplication" })
	public void test(){
		desktopHomePage.Login();
		
	}

	
}