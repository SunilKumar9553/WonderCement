package WebPages;

import org.openqa.selenium.By;

import WebUtil.WebActions;

public class ClaimSearch {

	// ==========================Objects==================================
	WebActions webActions = new WebActions();

// ==========================Locators==================================
	
	public static By search = By.xpath("//a[contains(.,'Search')]");
	public static By ClaimSearch = By.xpath("//a[contains(.,'Claim Search')]");
	public static By ClaimNumber = By.xpath("//input[@id='searchByClaimNumber']");
	public static By searchButton = By.xpath("//button[@id='searchButton']");
	public static By claimNumberValue = By.xpath("//input[@id='claimNumber']");
	public  static By ClaimErrorMsg=By.xpath("//p[text()='The system was unable to locate any records matching your search criteria.']");
	/**
	 * =============================================================================
	 * Method: ClaimSearchProcess | Author: Anilkumar Ch | Date:24 Nov 2020 | Description:
	 * Searching Claims with invalid Claims number | Parameters: none | Return: None
	 * =============================================================================
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */		
	

	public void ClaimSearchProcess() throws InterruptedException {
		// TODO Auto-generated method stub
		
		webActions.Click(search, "Search");
		Thread.sleep(2000);
		webActions.Click(ClaimSearch, "Claim Search");
		webActions.Click(ClaimNumber, "ClaimNumber");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(claimNumberValue, "123234312");
		Thread.sleep(1000);
		webActions.Click(searchButton, "Search button");
		System.out.println("===========================ERRoR_MeSSagE================");
	    String ClaimErrorMsgs=webActions.getElmText(ClaimErrorMsg);
		System.out.println(ClaimErrorMsgs);		
		System.out.println("===========================ERRoR_MeSSagE================");
	}
}