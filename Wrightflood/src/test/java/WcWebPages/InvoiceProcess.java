package WcWebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.DriverFactory;
import WebUtil.WebActions;

public class InvoiceProcess {

	Robot robot;
	String ReferenceNumber;

	// ==========================Objects==================================
	WebActions webActions = new WebActions();

	// ==========================Locators==================================

	public static By usernameField = By.xpath("//input[@id='oaloginform:userid']");
	public static By passwordField = By.xpath("//input[@id='oaloginform:password']");
	public static By loginButton = By.xpath("//input[@id='oaloginform:loginbtn']");
	public static By continueLogin = By.xpath("//*[@id=\"oaloginform:contloginbtn\"]");
	public static By searchBoxProcess = By.xpath("//*[@id=\"QueueListForm:Prefix\"]");
	public static By supplyIntroduction = By.xpath("//label[@title='Supply Po(Introduction)']");
	public static By newButton = By.xpath("//*[@id=\"wlf:NewShow\"]");
	public static By referenceNumber = By.xpath("//*[@id=\"wdesk:title\"]");
	public static By introduceButton = By.xpath("//*[@id=\"Introduce\"]/label[2]");
	public static By processDropdown = By.xpath("//*[@id=\"wlf:processlistcm\"]/span[1]");
	public static By referenceInput = By.xpath("//*[@id=\"wlf:Prefix\"]");
	public static By referenceSearch = By.xpath("//input[@id=\"wlf:cmdBtn\"]");
	public static By initiatorStatus = By.xpath("//*[@id=\"wlf:pnlResult_0_pn\"]");// *[@id="wlf:pnlResult_0_pn"]
	public static By invoiceCategory = By.xpath("//*[@id=\"proctype\"]");
	public static By poNumberInput = By.xpath("//*[@id=\"purchaseorderno\"]");
	public static By invoiceNumberInput = By.xpath("//*[@id=\"invoiceno\"]");
	public static By fetchButton = By.xpath("//*[@id=\"btn_fetchpogedetails\"]");
	public static By invoiceAmount = By.xpath("//*[@id=\"invoiceamount\"]");
	public static By invoiceDate = By.xpath("//*[@id=\"invoicedate\"]");
	public static By postingDate = By.xpath("//*[@id=\"postingdate\"]");
	public static By narrationRemarks = By.xpath("//*[@id=\"narrationremarks\"]");
	public static By poLines = By.xpath("//*[@id=\"q_polines_0_ContLbl\"]");
	public static By chargesLines = By.xpath("//*[@id=\"q_othercharges_0_ContLbl\"]");
	public static By status = By.xpath("//*[@id=\"initiatorstatus\"]");
	public static By initiatorRemarks = By.xpath("//*[@id=\"initiatorremarks\"]");
	public static By saveButton = By.xpath("//*[@id=\"Save\"]");
	public static By invoiceStatus = By.xpath("//*[@id=\"wlf:pnlResult_0_pn\"]//following::td[1]"); 
	public static By doneButton = By.xpath("//*[@id=\"Done\"]");
	public static By refreshButton = By.xpath("//*[@id=\"wlf\"]/table[1]/tbody/tr/td[1]/table/tbody/tr/td[2]/label");
	public static By storeStatus = By.xpath("//*[@id=\"storestatus\"]");
	public static By storeRemarks = By.xpath("//*[@id=\"storeremarks\"]");
	public static By holdForSingleInvoiceDropdown = By.xpath("//*[@id=\"multiplegrnholdflag\"]");
	public static By statusText = By.xpath("(//*[@id=\"wlf:pnlResult_0_pn\"]//following::td//label)[1]"); 
	public static By approveButton = By.xpath("//*[@id=\"Btn_Approve\"]");
	public static By holdAmount = By.xpath("//*[@id=\"holdamount\"]");
	public static By holdNarrationRemarks = By.xpath("//*[@id=\"hold_narration\"]");
	public static By maintainChargesTab = By.xpath("//*[text()='Maintain Charges']");
	public static By chargesAt = By.xpath("//*[@id=\"qoc_chargesat\"]");
	public static By lineNumber = By.xpath("//*[@id=\"qoc_linenumber\"]");
	public static By chargesCodePick = By.xpath("//*[@id=\"Pick_chargesCode\"]");
	public static By chargesCodeInputField = By.xpath("//*[@id=\"oforms_uni_picklist_txtFilter\"]"); //*[@id="oforms_uni_picklist_txtFilter"]
	public static By chargesCodeSearch = By.xpath("//*[@id=\"oforms_uni_picklist_SearchButton\"]"); //*[@id="oforms_uni_picklist_SearchButton"]
	public static By OKButton = By.xpath("//*[@id=\"oforms_uni_picklist_OKButton\"]");
	public static By chargesCodeCategory = By.xpath("//*[@id=\"qoc_category\"]");
	public static By chargesValue = By.xpath("//*[@id=\"qoc_chargesvalue\"]");
	public static By vendorCodePick = By.xpath("//*[@id=\"Pick_qocVendor\"]");
	public static By accessableValue = By.xpath("//*[@id=\"qoc_assessablevalue\"]");
	public static By chargesCodeAdd = By.xpath("//*[@id=\"Btn_Add_Maintaincharges\"]");
	public static By retentionTab = By.xpath("//*[text()=\"Retention\"]");
	public static By retentionAmountField = By.xpath("//*[@id=\"retentionamount\"]");
	public static By leftArrowButton = By.xpath("//*[@id=\"Tab1_img_L\"]");
	public static By taxdocumentTab = By.xpath("//*[text()='Tax Document']");
	public static By taxDocumentLines = By.xpath("//*[@id=\"q_taxdocument_bodytable\"]/tbody/tr");
	public static By taxAmountAdjustmentField = By.xpath("//*[@id=\"qtd_taxamountadjustment\"]");
	public static By modifyButton = By.xpath("//*[@id=\"Btn_Modify_Taxdocument\"]");
    public static By TDStab = By.xpath("//*[text()='TDS/TCS']");
    public static By TDSLines = By.xpath("//label[@id='q_withholdingtax_0_HeadLbl']//following::tr");
    public static By TCSAdjustmentAmountField = By.xpath("//*[@id=\"qwht_adjustedtdsamount\"]");
    public static By TCSModifyButton = By.xpath("//*[@id=\"Btn_Modify_Withholdingtax\"]");
    public static By accountMakerStatus = By.xpath("//*[@id=\"accountsstatus\"]"); 
    public static By accountMakerRemarks = By.xpath("//*[@id=\"accountsremarks\"]");
    
    public static By qualityMakerLines = By.xpath("//*[@id=\"q_polines_bodytable\"]/tbody/tr");
    public static By qualityLineNumberDropdown = By.xpath("//*[@id=\"Quality_linenumber\"]");
    public static By acceptedQuantity = By.xpath("//*[@id=\"Q_acceptedquantity\"]");
    public static By acceptedRemarks = By.xpath("//*[@id=\"Q_acceptedremarks\"]");
    public static By rejectedQuantity = By.xpath("//*[@id=\"Q_rejectedquantity\"]");
    public static By rejectedRemarks = By.xpath("//*[@id=\"Q_rejectedremarks\"]");
    public static By updateDetailsButton = By.xpath("//*[@id=\"Btn_updateQuaratinedetails\"]");
    public static By qualityRemarks = By.xpath("//*[@id=\"qualityremarks\"]");
    
    

	public void switchWindow() throws Exception {

		WebDriver driver = DriverFactory.getInstance().getWebDriver();
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("size of handles " + s1.size());
		Iterator i1 = s1.iterator();

		while (i1.hasNext()) {
			String child_window = (String) i1.next();
			if (!parentWindow.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println("title is " + driver.switchTo().window(child_window).getTitle());
			} else {
				System.out.println("there is no next window");
			}

		}

	}

	public void loginToPaperless() throws Exception {
		
		DriverFactory.getInstance().getWebDriver()
				.get("https://paperlessuat.wondercement.com/omniapp/pages/login/loginapp.jsf");
		webActions.clearAndSendKeys(usernameField, "demo");
		webActions.clearAndSendKeys(passwordField, "Test@123");
		webActions.Click(loginButton, "login");
		Thread.sleep(3000);

		boolean isTrue = webActions.isDisplayedList(continueLogin, "Continue Loin");
		if (isTrue) {

			webActions.Click(continueLogin, "Continue login");

		}

	}

	public void createSupplyInvoice(String po_number, String challan_number) throws Exception {
		
		loginToPaperless();
		
		webActions.switchToFrame(By.id("iframe_Int11"));
		webActions.Click(searchBoxProcess, "Search box");
		webActions.clearAndSendKeys(searchBoxProcess, "Supply");
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		webActions.Click(supplyIntroduction, "Supply po introduction");
		DriverFactory.getInstance().getWebDriver().switchTo().defaultContent();
		Thread.sleep(2000);
		webActions.switchToFrame(By.id("iframe_Int38"));
		Thread.sleep(2000);
		webActions.Click(newButton, "New");
		Thread.sleep(2000);
		WebDriver driver = DriverFactory.getInstance().getWebDriver();

		switchWindow();

		Thread.sleep(3000);
		ReferenceNumber = webActions.getElmText(referenceNumber);
		String numberOnly = ReferenceNumber.replaceAll("[^0-9]", "");
		webActions.waitForVisible(introduceButton);
		webActions.Click(introduceButton, "Introduce");
		Thread.sleep(2000);
		DriverFactory.getInstance().getWebDriver().close();
		webActions.switchToWindowIndex(0);
		webActions.switchToFrame(By.xpath("//*[@id=\"iframe_Int41\"]"));
		webActions.Click(processDropdown, "Process dropdown");
		driver.switchTo().defaultContent();
		webActions.Click(By.xpath("//*[@id=\"wlf:processlistopt\"]/span[7][contains(text(),'Supply')]"),
				"Supply po invoice");
		webActions.switchToFrame(By.xpath("//*[@id=\"iframe_Int41\"]"));
		webActions.Click(referenceInput, "Reference");
		webActions.clearAndSendKeys(referenceInput, numberOnly);
		webActions.Click(referenceSearch, "Search");
		driver.switchTo().defaultContent();
		webActions.switchToFrame(By.id("iframe_Int38"));
		Thread.sleep(2000);
		webActions.Click(refreshButton, "Refresh");
		String invoice_status = webActions.getElmText(invoiceStatus);
		Thread.sleep(5000);
		if (invoice_status.contains("Initiator")) {
			Thread.sleep(3000);
			webActions.Click(initiatorStatus, "Initiator");
		}else {
			System.out.println("status is not initiator ");
		}

		initiatorPage(po_number, challan_number);

	}

	public void initiatorPage(String po_number, String challan_number) throws Exception {

		switchWindow();
		webActions.switchToFrame(By.xpath("//*[@id=\"ngformIframe\"]"));
		webActions.selectByVisibleText(invoiceCategory, "Store Spare items");
		webActions.clearAndSendKeys(poNumberInput, po_number);
		webActions.clearAndSendKeys(invoiceNumberInput, challan_number);
		Thread.sleep(2000);
		webActions.Click(fetchButton, "Fetch");
		Thread.sleep(3000);
		webActions.clearAndSendKeys(invoiceAmount, "24242");
		WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(invoiceDate);
		JavascriptExecutor js = (JavascriptExecutor) (DriverFactory.getInstance().getWebDriver());
		js.executeScript("arguments[0].value='02/06/2021';", ele);
		WebElement elem = DriverFactory.getInstance().getWebDriver().findElement(postingDate);
		js.executeScript("arguments[0].scrollIntoView();", elem);
		js.executeScript("arguments[0].value='02/06/2021';", elem);

//			webActions.clearAndSendKeys(narrationRemarks, "Remarks");
		List<WebElement> list = webActions.getListofElements(poLines, "po lines");
		System.out.println("lines count in intiator page: " + list.size());
		for (int i = 0; i < list.size(); i++) {

			if (i > 0) {
				webActions.switchToFrame(By.xpath("//*[@id=\"ngformIframe\"]"));
			}
			js.executeScript("arguments[0].click();", list.get(i));
			webActions.selectByVisibleText(status, "Initiate");
			webActions.clearAndSendKeys(initiatorRemarks, "Remarks");
			DriverFactory.getInstance().getWebDriver().switchTo().defaultContent();
			webActions.Click(saveButton, "Save");
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		webActions.Click(doneButton, "Done");
		Thread.sleep(3000);
		webActions.switchToWindowIndex(0);
		webActions.switchToFrame(By.id("iframe_Int38"));
		webActions.Click(refreshButton, "Refresh");
		Thread.sleep(5000);
		webActions.Click(initiatorStatus, "Work item");
		storeMakerPage();
	}

	public void storeMakerPage() throws Exception {

		switchWindow();
		webActions.switchToFrame(By.xpath("//*[@id=\"ngformIframe\"]"));
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_END);

		List<WebElement> list = webActions.getListofElements(poLines, "po lines");
		System.out.println("the lines count in store maker page: "+ list.size());
		for (int i = 0; i < list.size(); i++) {

			if (i > 0) {
				webActions.switchToFrame(By.xpath("//*[@id=\"ngformIframe\"]"));
			}
			JavascriptExecutor js = (JavascriptExecutor) (DriverFactory.getInstance().getWebDriver());
			js.executeScript("arguments[0].click();", list.get(i));
			webActions.selectByVisibleText(storeStatus, "Submit For GRN");
			Thread.sleep(2000);
			webActions.selectByVisibleText(holdForSingleInvoiceDropdown, "No");
			webActions.clearAndSendKeys(storeRemarks, "Remarks");
			DriverFactory.getInstance().getWebDriver().switchTo().defaultContent();
			webActions.Click(saveButton, "Save");
			Thread.sleep(3000);
		}
			webActions.Click(doneButton, "Done");
			Thread.sleep(3000);
			webActions.switchToWindowIndex(0);
			webActions.switchToFrame(By.id("iframe_Int38"));
			webActions.Click(refreshButton, "Refresh");
			Thread.sleep(3000);
			String status = webActions.getElmText(statusText);
			System.out.println("work item status is " + status);
			while(status.contains("SchedulerStore")) {
				Thread.sleep(10000);
				webActions.Click(refreshButton, "Refresh");
				Thread.sleep(2000);
				status = webActions.getElmText(statusText);
			}
			String status2 = webActions.getElmText(statusText);
			if(status2.contains("QualityMaker")) {
				System.out.println("status changed to Quality maker");
				webActions.Click(initiatorStatus, "Work item");
			}
			
		qualityMakerPage();

	}
	
	public void qualityMakerPage() throws Exception {
		String path = "E:\\downloads-29dec\\SupplyPOInvoiceInputs.xlsx";
		String filePath = "E:\\downloads-29dec\\gateEntry.xlsx";
		int linesCount = webActions.getAvailableRowCount(path, "supplyInvoiceLine1");
	
		String accepted_remarks = "aremarks";
		String rejected_remarks = "rremarks";
		String quality_remarks = "remarks";
		switchWindow();
		webActions.switchToFrame(By.xpath("//*[@id=\"ngformIframe\"]"));
		Thread.sleep(2000);
		
		ArrayList<WebElement> qualityList = (ArrayList<WebElement>) webActions.getListofElements(qualityMakerLines, "Quality lines");
		System.out.println("the lines count in quality makers page: "+ linesCount);
		for(int i=1;i<qualityList.size();i++) {
			
			String quality_line_number = webActions.getExcelData(path, "supplyInvoiceLine1", i, 0);
			String index = "1";
			int count = linesCount + 1;
			String accepted_qty = webActions.getExcelData(filePath, "GateEntryLine"+index, count-i, 3);
			JavascriptExecutor js = (JavascriptExecutor) (DriverFactory.getInstance().getWebDriver());
			js.executeScript("arguments[0].click();", qualityList.get(i));
			webActions.selectByVisibleText(qualityLineNumberDropdown, quality_line_number);
			webActions.clearAndSendKeys(acceptedQuantity, accepted_qty);
			webActions.clearAndSendKeys(acceptedRemarks, accepted_remarks);
			webActions.clearAndSendKeys(rejectedRemarks, rejected_remarks);
			webActions.Click(updateDetailsButton, "Update details");
			Thread.sleep(3000);
			
		}
		    webActions.clearAndSendKeys(qualityRemarks, quality_remarks);
		    DriverFactory.getInstance().getWebDriver().switchTo().defaultContent();
		    webActions.Click(saveButton, "Save");
		    Thread.sleep(2000);
		    webActions.Click(doneButton, "Done");
		    Thread.sleep(3000);
		    webActions.switchToWindowIndex(0);
			webActions.switchToFrame(By.id("iframe_Int38"));
			Thread.sleep(1000);
			webActions.Click(refreshButton, "Refresh");
			Thread.sleep(2000);
		    webActions.Click(initiatorStatus, "Invoice for Accounts checker");
		    Thread.sleep(2000);
		    qualityCheckerPage();
	}
	
	public void qualityCheckerPage() throws Exception {
		String quality_checker_remarks = "";
		switchWindow();
		webActions.switchToFrame(By.xpath("//*[@id=\"ngformIframe\"]"));
//		Thread.sleep(2000);
//		webActions.Click(approveButton, "Approve");
		
		webActions.clearAndSendKeys(qualityRemarks, quality_checker_remarks);
	    DriverFactory.getInstance().getWebDriver().switchTo().defaultContent();
	    webActions.Click(saveButton, "Save");
	    Thread.sleep(2000);
	    webActions.Click(doneButton, "Done");
		Thread.sleep(3000);
		webActions.switchToWindowIndex(0);
		webActions.switchToFrame(By.id("iframe_Int11"));
		webActions.Click(refreshButton, "Refresh");
		String status = webActions.getElmText(statusText);
		while(!status.contains("AccountsMaker")) {
			Thread.sleep(10000);
			webActions.Click(refreshButton, "Refresh");
		}
		
		System.out.println("status changed to Accounts Maker");
		webActions.Click(initiatorStatus, "Work item");
		
		accountsMakerPage();
		
	}
	
	public void accountsMakerPage() throws Exception {
		String path = "E:\\downloads-29dec\\SupplyPOInvoiceInputs.xlsx";
		int linesCount = webActions.getAvailableRowCount(path, "supplyInvoiceLine1");
		
		
		String retention_amount = "23424";
		
		
		String account_maker_status = "Submit For Invoicing";
		String account_remarks = "remarks";
		switchWindow();
		webActions.switchToFrame(By.xpath("//*[@id=\"ngformIframe\"]"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		js.executeScript("window.scrollBy(0,550)", "");
		webActions.clearAndSendKeys(holdAmount, "97575");
		webActions.Click(holdNarrationRemarks, "Hold narration remarks");
		webActions.clearAndSendKeys(holdNarrationRemarks, "Remarks");
		webActions.scrollDownUsingJS();
		webActions.Click(maintainChargesTab, "Maintain charges");
		Thread.sleep(2000);
		List<WebElement> list = webActions.getListofElements(chargesLines, "Maintain charges lines");
		System.out.println("accounts maker lines count: "+ linesCount);
		for (int i = 1; i < linesCount; i++) {
         
			String line_number = webActions.getExcelData(path, "supplyInvoiceLine1", i, 0);
			String charges_code = webActions.getExcelData(path, "supplyInvoiceLine1", i, 6);
			String charges_code_category = webActions.getExcelData(path, "supplyInvoiceLine1", i, 7);
			String charges_value = webActions.getExcelData(path, "supplyInvoiceLine1", i, 8);
			String vendor = webActions.getExcelData(path, "supplyInvoiceLine1", i, 9);
			String accessable_value = webActions.getExcelData(path, "supplyInvoiceLine1", i, 10);
			
			
			
			webActions.selectByVisibleText(chargesAt, "Line");
			webActions.selectByVisibleText(lineNumber, line_number);
			
			
			if(!charges_code.equals("")) {
				webActions.Click(chargesCodePick, "pick charges code");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(chargesCodePick, charges_code);
				webActions.Click(chargesCodeSearch, "Search Charges code");
				Thread.sleep(2000);
				webActions.Click(OKButton, "OK");
			}
			webActions.selectByVisibleText(chargesCodeCategory, charges_code_category);
			webActions.clearAndSendKeys(chargesValue, charges_value);
			
			if(!vendor.equals("")) {
				
				webActions.Click(vendorCodePick, "Vendor pick");
				Thread.sleep(1000);
				webActions.clearAndSendKeys(chargesCodeInputField, vendor);
				webActions.Click(chargesCodeSearch, "Search");
				Thread.sleep(2000);
				webActions.Click(OKButton, "OK");
			}
			
			webActions.selectByVisibleText(accessableValue, accessable_value);
			Thread.sleep(1000);
			webActions.Click(chargesCodeAdd, "Add");
			Thread.sleep(3000);
			
			
		}
		  //loop ends
		    webActions.Click(retentionTab, "Retention tab");
		    Thread.sleep(2000);
		    webActions.clearAndSendKeys(retentionAmountField, retention_amount);
		    webActions.Click(leftArrowButton, "Left arrow");
		    Thread.sleep(1000);
		    webActions.Click(leftArrowButton, "Left arrow");
		    webActions.Click(taxdocumentTab, "Tax document tab");
		    Thread.sleep(2000);
		    
		    ArrayList taxLines = (ArrayList) webActions.getListofElements(taxDocumentLines, "No of Lines");
		    for(int i=1;i<linesCount;i++) {
		    	String line_number = webActions.getExcelData(path, "supplyInvoiceLine1", i, 0);
		    	String tax_amount_adjustment = webActions.getExcelData(path, "supplyInvoiceLine1", i, 13);
		    	webActions.Click(By.xpath("(//label[@id='q_taxdocument_0_HeadLbl']//following::td[@title='"+line_number+"'])[1]"), "Line on tax ");
		    	Thread.sleep(2000);
		    	if(!tax_amount_adjustment.equals("")) {
		 
		    		webActions.clearAndSendKeys(taxAmountAdjustmentField, tax_amount_adjustment);
		    	}
		    	webActions.Click(modifyButton, "Modify");
		    	Thread.sleep(3000);
		    	
		    }
		    //loop ends
		    webActions.Click(TDStab, "TDS/TCS Tab");
		    Thread.sleep(2000);
		    ArrayList tdsLines = (ArrayList) webActions.getListofElements(taxDocumentLines, "No of Lines");
		    for(int i=0;i<linesCount;i++) {
		    	String line_number = webActions.getExcelData(path, "supplyInvoiceLine1", i, 0);
		    	String tcs_adjustment_amount = webActions.getExcelData(path, "supplyInvoiceLine1", i, 12);
		    	webActions.Click(By.xpath("(//label[@id='q_withholdingtax_0_HeadLbl']//following::tr/td[@title='"+line_number+"'])[1]"), "Line on TCS");
		    	Thread.sleep(2000);
		    	if(!tcs_adjustment_amount.equals("")) {
		    		webActions.clearAndSendKeys(TCSAdjustmentAmountField, tcs_adjustment_amount);
		    	}
		    	
		        webActions.Click(TCSModifyButton, "tcs Modify");
		    	
		    }
		    
		    robot = new Robot();
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_END);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyRelease(KeyEvent.VK_END);
		    Thread.sleep(2000);
		    webActions.selectByVisibleText(accountMakerStatus, account_maker_status);
		    webActions.clearAndSendKeys(accountMakerRemarks, account_remarks);
		    DriverFactory.getInstance().getWebDriver().switchTo().defaultContent();
		    webActions.Click(saveButton, "Save");
		    Thread.sleep(2000);
		    webActions.Click(doneButton, "Done");
		    Thread.sleep(3000);
		    webActions.switchToWindowIndex(0);
			webActions.switchToFrame(By.id("iframe_Int38"));
			Thread.sleep(2000);
			webActions.Click(refreshButton, "Refresh");
			Thread.sleep(2000);
		    webActions.Click(initiatorStatus, "Invoice for Accounts checker");
		    
		    Thread.sleep(2000);
		    accountsCheckerPage();
	}
	
	
	public void accountsCheckerPage() throws Exception {
		switchWindow();
		webActions.switchToFrame(By.xpath("//*[@id=\"ngformIframe\"]"));
		Thread.sleep(2000);
		robot = new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_END);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_END);
	    Thread.sleep(2000);
	    webActions.selectByVisibleText(accountMakerStatus, "Create Invoicing");
	    webActions.clearAndSendKeys(accountMakerRemarks, "Remarks");
	    DriverFactory.getInstance().getWebDriver().switchTo().defaultContent();
	    webActions.Click(saveButton, "Save");
	    Thread.sleep(2000);
	    webActions.Click(doneButton, "Done");
	    Thread.sleep(3000);
	    webActions.switchToWindowIndex(0);
		webActions.switchToFrame(By.id("iframe_Int38"));
		Thread.sleep(1000);
		webActions.Click(refreshButton, "Refresh");
		Thread.sleep(2000);
		String status = webActions.getElmText(statusText);
		while(!status.contains("SchedulerAccounts")) {
			Thread.sleep(1000);
			webActions.Click(refreshButton, "Refresh");
			status = webActions.getElmText(statusText);
			
		}
		
	}
	

}
