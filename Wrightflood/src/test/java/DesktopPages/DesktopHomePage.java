package DesktopPages;

import org.openqa.selenium.By;

import DesktopUtil.DesktopActions;
import Utilities.ReportManager;

public class DesktopHomePage {

	DesktopActions desktopActions=new DesktopActions();
	
	public void Login() {
		ReportManager.logInfo("Test started login");
		DesktopActions.click(By.name("Text Editor"), "Login button ");
		DesktopActions.sendKeys(By.name("Text Editor"), "Hello world");
	}

	

}
