package WcWebPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import WebUtil.WebActions;

public class ReturnableGatePass {
	
	
	Robot robot;
	JavascriptExecutor js;
	String filePath;
	WebDriverWait wait;
	String gate_entry_number;
	// ==========================Objects==================================
	WebActions webActions = new WebActions();

	// ==========================Locators==================================
	public static By storeTab = By.xpath("(//*[text()='Store'])[1]");
	public static By gateEntryTab = By.xpath("(//*[text()='Store'])[1]//following::span[text()='Gate Entry'][1]");
	public static By addGateEntry = By.xpath("//*[@id=\"kt_content\"]/div/div/div/div/div[1]/div[2]/div/div/a");
	public static By gateEntryType = By.xpath("//select[@id='ddlGateEntryType']");
	public static By documentTypeContainer = By.xpath("//*[@id=\"select2-ddlDocumentType-container\"]");
	public static By factoryGateDropdown = By.xpath("//*[@id=\"select2-ddlFactoryGate-container\"]");
	public static By inputField = By.xpath("/html/body/span/span/span[1]/input");
	public static By skipMeasurement = By
			.xpath("//*[@id=\"kt_content\"]/div/div/div[1]/form/div/div[2]/div[1]/div/div[7]/div/label/span");
	public static By poNumberInput = By.xpath("//input[@id='txtPONo']");
	public static By searchButtonPo = By.xpath("//*[@id=\"btnSearchPO\"]/span");
	public static By vendorContainer = By
			.xpath("//*[@id=\"kt_content\"]/div/div/div[1]/form/div/div[2]/div[2]/div/div[3]/div/span/span[1]/span");

	public static By vehicleNumber = By.xpath("//input[@id='txtVehicleNumber']");
	public static By equipmentDropDown = By.xpath("//select[@id='ddlEquipment']");
	public static By transporterDropdown = By.xpath("//span[@id='select2-hdnTransporterID-container']");
	public static By LRRRAWBNumber = By.xpath("//input[@id='txtLR_RR_AWB']");
	public static By LRRRAWBDate = By.xpath("//input[@id='dpLR_RR_AWB_Date']");
	public static By challanNumber = By.xpath("//input[@id='txtChallanNumber']");
	public static By challanDate = By.xpath("//input[@id='dpChallanDate']");
	public static By originContainer = By.xpath("//span[@id='select2-txtOriginID-container']");
	public static By gateIn = By.xpath("//button[@id='btnGateIn']");
	public static By okButton = By.xpath("//button[text()='OK']");
	public static By selectPoItem = By.xpath("//*[@id=\"btnOpenPOItemModal\"]");
	public static By selectPoItem2 = By.xpath("//*[@id=\"btnOpenAfterInPOItemModal\"]");
	public static By itemNumberInput = By.xpath("//input[@id='gridPOItemFilter']");
	public static By addButton = By.xpath("//button[text()='Add' and @onclick='AddRGPItems()']");
	public static By confirmButton = By.xpath("//*[@id=\"btnGateEntryLineSubmit\"]");
	public static By yesButton = By.xpath("//button[text()='Yes']");
	public static By updateButton = By.xpath("//*[@id=\"btnUpdateGateEntry\"]");
	public static By vehicleExitButton = By.xpath("//*[@id=\"btnVehicleExit\"]");
	public static By gateOutButton = By.xpath("//*[@id=\"btnGateOut\"]");
	public static By vendorChallanQty = By.xpath("//*[@id=\"grdtxtGEVendorChallanQty\"]"); // *[@id="grdtxtGEVendorChallanQty"]
	public static By GRNQty = By.xpath("//*[@id=\"grdtxtGEGRNQty\"]");
	public static By unloadingArea = By.xpath("//*[@id=\"grdDDLUnloadingArea\"]");
	public static By unloadedBy = By.xpath("//*[@id=\"grdDDLUnloadedBy\"]");
	public static By serialNumber = By.xpath("//*[@id=\"grdtxtWBSerialNumber\"]");
	public static By cardNo = By.xpath("//*[@id=\"grdtxtWBCardNo\"]");
	public static By firstMachineNo = By.xpath("//*[@id=\"grdtxtWBFirstWeighingMachineNo\"]");
	public static By secondMachineNo = By.xpath("//*[@id=\"grdtxtWBSecondWeighingMachineNo\"]");
	public static By firstWeight = By.xpath("//*[@id=\"grdtxtWBFirstWeight\"]");
	public static By secondWeight = By.xpath("//*[@id=\"grdtxtWBSecondWeight\"]");
	public static By inDate = By.xpath("//*[@id=\"grddpWBInDateTime\"]");
	public static By outDate = By.xpath("//*[@id=\"grddpWBOutDateTime\"]");
	public static By account = By.xpath("//*[@id=\"kt_header\"]/div[4]/div[3]/div[2]/div/span[3]");
	public static By signOut = By.xpath("//*[@id=\"kt_header\"]/div[4]/div[3]/div[3]/div[2]/div/a[1]");
	public static By newGateEntry = By.xpath("//*[@id=\"newbtn\"]");
	public static By gateEntryNumber = By.xpath("//*[@id=\"spanVersionNo\"]");
	
	public static By gatePassSearch = By.xpath("//*[@id=\"btnOpentxtGatePassModal\"]");
    public static By selectRGPitem = By.xpath("//*[@id=\"btnOpenRGPItemModal\"]");
	public static By RGPitemInput = By.xpath("//*[@id=\"gridRGPItemFilter\"]");
	public static By gatePassTab = By.xpath("(//span[text()='Gate Pass'])[1]");
	public static By gatePassReturnTab = By.xpath("(//span[text()='Gate Pass-Return'])[1]");
    public static By gatePassInput = By.xpath("//input[@placeholder='Gate Pass ID']");
	public static By returnGateEntryDropdown = By.xpath("//*[@id=\"ddlGateEntry\"]");
	public static By returnDescription = By.xpath("//*[@id=\"txtItemDescription\"]");
	public static By addReturnLine = By.xpath("//*[@id=\"AddLineBtn\"]");
	public static By gatePassReturnWindowClose = By.xpath("//*[@id=\"ReturnDetialsPopup\"]/div/div/div[1]/button");
	
	
	
	
	
	
	public void createGateEntry(String vendor, String gatePassNumber, int i) throws Exception {

		wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 100);

	   filePath =  "C:\\Users\\Sunil\\Downloads\\GatePassInputs-NonReturnable.xlsx";
	
		int headerRowCount = webActions.getAvailableRowCount(filePath, "GateEntry_returnable_header");
		System.out.println("Returnable gate pass headers count: " + headerRowCount);
		
		String user_name = webActions.getExcelData(filePath, "Credentials", 1, 0);
		String passcode = webActions.getExcelData(filePath, "Credentials", 1, 1);
		
		Thread.sleep(3000);
		GatePassPage page = new GatePassPage();
		page.wonderCementLogin(user_name, passcode);

		JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		js1.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
		webActions.Click(storeTab, "Store");
		webActions.Click(gateEntryTab, "GateEntry");
		webActions.Click(addGateEntry, "add gate entry");

		
			
			String vehicle_number = webActions.getExcelData(filePath, "GateEntry_returnable_header", i, 0);
			String equipment = webActions.getExcelData(filePath, "GateEntry_returnable_header", i, 1);
			String transporter = webActions.getExcelData(filePath, "GateEntry_returnable_header", i, 2);
			String LRNumber = webActions.getExcelData(filePath, "GateEntry_returnable_header", i, 3);
			String LRDate = webActions.getExcelData(filePath, "GateEntry_returnable_header", i, 4);
			String challDate = webActions.getExcelData(filePath, "GateEntry_returnable_header", i, 5);
			String origin = webActions.getExcelData(filePath, "GateEntry_returnable_header",i , 6);
			String skip_measurement = webActions.getExcelData(filePath, "GateEntry_returnable_header", i, 7);

			
			if (skip_measurement.equals("yes")) {
				webActions.Click(skipMeasurement, "Skip measurement");
			}

			webActions.Click(factoryGateDropdown, "FactoryGate");
			webActions.clearAndSendKeys(inputField, "102");
			robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(documentTypeContainer, "Document type");
			webActions.clearAndSendKeys(inputField, "Returnable Gate Pass Return");
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
			webActions.Click(vendorContainer, "vendor");
			webActions.clearAndSendKeys(inputField, vendor);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            webActions.Click(gatePassSearch, "Gate pass search");
            Thread.sleep(4000);
           
            webActions.Click(By.xpath("//*[contains(text(),'"+gatePassNumber+"')]/ancestor::tr//input[1]"), "Gate pass number radio");
            Thread.sleep(1000);
			webActions.clearAndSendKeys(vehicleNumber, vehicle_number);
			webActions.selectByVisibleText(equipmentDropDown, "Truck");
			webActions.Click(transporterDropdown, "Transporter container");
			Thread.sleep(1000);
			webActions.clearAndSendKeys(inputField, transporter);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.clearAndSendKeys(LRRRAWBNumber, "3435");
			WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(LRRRAWBDate);
			js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
			js.executeScript("arguments[0].value=' " + LRDate + "' ", ele);
			int min = 200;
			int max = 1000;
			int b = (int) (Math.random() * (max - min + 1) + min);
			webActions.clearAndSendKeys(challanNumber, "0000" + b);
			WebElement elem = DriverFactory.getInstance().getWebDriver().findElement(challanDate);
			js.executeScript("arguments[0].value=' " + LRDate + "' ", elem);
			webActions.Click(originContainer, "Origin");
			Thread.sleep(1000);
			webActions.clearAndSendKeys(inputField, origin);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			webActions.Click(gateIn, "Gate In");
			Thread.sleep(2000);
			webActions.Click(okButton, "OK");
			Thread.sleep(3000);
			gate_entry_number = webActions.getElmText(gateEntryNumber);
			
			
			webActions.writeData(filePath, "GateEntry_returnable_header", i, 9, gate_entry_number);
			
			Thread.sleep(3000);
			js1.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
			String index = String.valueOf(i);
			addPoItems(index);

		

	}

	public void addPoItems(String index) throws Exception {

		int linesCount = webActions.getAvailableRowCount(filePath, "RGP_Line"+index);
		System.out.println("rgp lines count is: " + linesCount);

		for (int j = 1; j < linesCount; j++) {

			String item_number = webActions.getExcelData(filePath, "RGP_Line"+index, j, 0);
			webActions.Click(selectRGPitem, "Selct PO item");
			Thread.sleep(2000);
			webActions.clearAndSendKeys(RGPitemInput, item_number);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(By.xpath("//*[text()='" + item_number + "']/ancestor::tr/td/input"), "item code checkbox");
			webActions.Click(addButton, "Add");
			Thread.sleep(3000);

		}

		for (int i = 1; i < linesCount; i++) {

			String vendor_qty = webActions.getExcelData(filePath, "RGP_Line"+index, i, 1);
			String grn_qty = webActions.getExcelData(filePath, "RGP_Line"+index, i, 2);
			String unloading_area = webActions.getExcelData(filePath, "RGP_Line"+index, i, 3);
			String unloaded_by = webActions.getExcelData(filePath, "RGP_Line"+index, i, 4);
			String serial_no = webActions.getExcelData(filePath, "RGP_Line"+index, i, 5);
			String card_no = webActions.getExcelData(filePath, "RGP_Line"+index, i, 6);
			String first_machine_no = webActions.getExcelData(filePath, "RGP_Line"+index, i, 7);
			String second_machine_no = webActions.getExcelData(filePath, "RGP_Line"+index, i, 8);
			String first_weight = webActions.getExcelData(filePath, "RGP_Line"+index, i, 9);
			String second_weight = webActions.getExcelData(filePath, "RGP_Line"+index, i, 10);
			String in_date = webActions.getExcelData(filePath, "RGP_Line"+index, i, 11);
			String out_date = webActions.getExcelData(filePath, "RGP_Line"+index, i, 12);

			webActions.clearAndSendKeys(By.xpath("(//*[@id=\"grdtxtGEVendorChallanQty\"])["+ i +"]"), vendor_qty);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtGEGRNQty'])["+ i +"]"), grn_qty);
			webActions.selectByVisibleText(By.xpath("(//*[@id='grdDDLUnloadingArea'])["+ i +"]"), unloading_area);
			js.executeScript("window.scrollBy(2000,0)");
			Thread.sleep(2000);
			webActions.selectByVisibleText(By.xpath("(//*[@id='grdDDLUnloadedBy'])["+ i +"]"), unloaded_by);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBSerialNumber'])["+ i +"]"), serial_no);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBCardNo'])["+ i +"]"), card_no);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBFirstWeighingMachineNo'])["+ i +"]"),
					first_machine_no);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBSecondWeighingMachineNo'])["+ i +"]"),
					second_machine_no);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBFirstWeight'])["+ i +"]"), first_weight);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBSecondWeight'])["+ i +"]"), second_weight);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grddpWBInDateTime'])["+ i +"]"), in_date);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grddpWBOutDateTime'])["+ i +"]"), out_date);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);

		}

		webActions.Click(confirmButton, "Confirm Item");
		Thread.sleep(2000);
		webActions.Click(yesButton, "Yes");
		Thread.sleep(3000);
		webActions.Click(updateButton, "Update");
		webActions.Click(yesButton, "Yes");
		Thread.sleep(2000);
		webActions.Click(vehicleExitButton, "Vehicle exit");
		Thread.sleep(2000);
		webActions.Click(yesButton, "Yes");
		Thread.sleep(2000);
		webActions.Click(gateOutButton, "Gate out");
		Thread.sleep(2000);
		webActions.Click(yesButton, "Yes");
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(account));
		webActions.ClickJSE(account, "Click on user account");
		Thread.sleep(3000);
		webActions.ClickJSE(signOut, "sign out of the account");
		rgpReturn(index);

	}
	
	public void rgpReturn(String index) throws Exception {
		
		
		
		filePath =  "C:\\Users\\Sunil\\Downloads\\GatePassInputs-NonReturnable.xlsx";
		
		String user_name = webActions.getExcelData(filePath, "Credentials", 1, 0);
		String passcode = webActions.getExcelData(filePath, "Credentials", 1, 1);
		int j = Integer.parseInt(index);
		String gatePassNumber = webActions.getExcelData(filePath, "GatePassHeader", j, 11);
		
		Thread.sleep(3000);
		GatePassPage page = new GatePassPage();
		page.wonderCementLogin(user_name, passcode);
		
		Thread.sleep(4000);
		webActions.Click(gatePassTab, "Gate pass");
		Thread.sleep(2000);
		webActions.Click(gatePassReturnTab, "Gate pass return");
		Thread.sleep(3000);
		System.out.println("gate pass number is "+ gatePassNumber);
		webActions.clearAndSendKeys(gatePassInput, gatePassNumber);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		webActions.Click(By.xpath("//*[contains(text(),'"+gatePassNumber+"')]"), "Gate pass number");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_END);
		Thread.sleep(3000);
		int ReturnlinesCount = webActions.getAvailableRowCount(filePath, "RGP_Line"+index);
		
		String gateEntryNumber = webActions.getExcelData(filePath, "GateEntry_returnable_header", j, 9);
		for(int i=1; i<ReturnlinesCount;i++) {
			
			String item_number = webActions.getExcelData(filePath, "RGP_Line"+index, i, 0);
			webActions.Click(By.xpath("//*[contains(text(),'"+ item_number +"')]/ancestor::tr/td/a"), "Retrun Detail");
			Thread.sleep(2000);
			
			System.out.println("gate entry number " + gateEntryNumber);
			Thread.sleep(2000);
			webActions.selectByVisibleText(returnGateEntryDropdown, gateEntryNumber);
			webActions.clearAndSendKeys(returnDescription, "Descriptionn");
			webActions.Click(addReturnLine, "Add line");
			Thread.sleep(3000);
			webActions.Click(gatePassReturnWindowClose, "Close");
			Thread.sleep(3000);
			
		}
		
	
		
		
	}

}
