package WebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import WcWebPages.InvoiceProcess;
import WebUtil.WebActions;

public class GateEntry {

	Robot robot;
	JavascriptExecutor js;
	String filePath;
	WebDriverWait wait;
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
	public static By addButton = By.xpath("//button[text()='Add' and @onclick='AddPOItems()']");
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

	
	
	
	
	
	
	public void createGateEntry() throws Exception {

		wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 100);

		filePath = "E:\\downloads-29dec\\gateEntry.xlsx";
		int headerRowCount = webActions.getAvailableRowCount(filePath, "Header");

		JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		js1.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
		webActions.Click(storeTab, "Store");
		webActions.Click(gateEntryTab, "GateEntry");
		webActions.Click(addGateEntry, "add gate entry");

		for (int i = 1; i < headerRowCount; i++) {

			String po_number = webActions.getExcelData(filePath, "Header", i, 0);
			String factoryGate = webActions.getExcelData(filePath, "Header", i, 1);
			String documentType = webActions.getExcelData(filePath, "Header", i, 2);
			String vendor = webActions.getExcelData(filePath, "Header", i, 3);
			String vehicle_number = webActions.getExcelData(filePath, "Header", i, 4);
			String equipment = webActions.getExcelData(filePath, "Header", i, 5);
			String transporter = webActions.getExcelData(filePath, "Header", i, 6);
			String LRNumber = webActions.getExcelData(filePath, "Header", i, 7);
			String LRDate = webActions.getExcelData(filePath, "Header", i, 8);
			String challan_number = webActions.getExcelData(filePath, "Header", i, 9);
			String challDate = webActions.getExcelData(filePath, "Header", i, 10);
			String origin = webActions.getExcelData(filePath, "Header",i , 11);
			String skip_measurement = webActions.getExcelData(filePath, "Header", i, 12);

			if(i>1) {
				
				webActions.Click(newGateEntry, "New Gate Entry");
				Thread.sleep(3000);
			}
			
			if (skip_measurement.equals("yes")) {
				webActions.Click(skipMeasurement, "Skip measurement");
			}

			webActions.Click(factoryGateDropdown, "FactoryGate");
			webActions.clearAndSendKeys(inputField, factoryGate);
			robot = new Robot();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(documentTypeContainer, "Document type");
			webActions.clearAndSendKeys(inputField, documentType);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			webActions.clearAndSendKeys(poNumberInput, po_number);
			webActions.Click(searchButtonPo, "search PO");
			Thread.sleep(5000);
//			webActions.Click(vendorContainer, "vendor");
//			webActions.clearAndSendKeys(inputField, vendor);
//			Thread.sleep(1000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);

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
			webActions.clearAndSendKeys(challanNumber, po_number + b);
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
			String gate_entry_number = webActions.getElmText(gateEntryNumber);
			
			
			webActions.writeData(filePath, "Header", i, 14, gate_entry_number);
			
			Thread.sleep(3000);
			js1.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
			String index = String.valueOf(i);
			addPoItems(index);
			
			InvoiceProcess invoice = new InvoiceProcess();
			invoice.createSupplyInvoice(po_number, po_number + b);

		}

	}

	public void addPoItems(String index) throws Exception {

		int linesCount = webActions.getAvailableRowCount(filePath, "GateEntryLine"+index);
		System.out.println("lines count is: " + linesCount);

		for (int j = 1; j < linesCount; j++) {

			String item_number = webActions.getExcelData(filePath, "GateEntryLine1", j, 1);
			webActions.Click(selectPoItem, "Selct PO item");
			Thread.sleep(2000);
			webActions.clearAndSendKeys(itemNumberInput, item_number);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(By.xpath("//*[text()='" + item_number + "']/ancestor::tr/td/input"), "item code checkbox");
			webActions.Click(addButton, "Add");
			Thread.sleep(3000);

		}

		for (int i = 1; i < linesCount; i++) {

			String vendor_qty = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 2);
			String grn_qty = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 3);
			String unloading_area = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 4);
			String unloaded_by = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 5);
			String serial_no = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 6);
			String card_no = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 7);
			String first_machine_no = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 8);
			String second_machine_no = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 9);
			String first_weight = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 10);
			String second_weight = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 11);
			String in_date = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 12);
			String out_date = webActions.getExcelData(filePath, "GateEntryLine"+index, i, 13);

			webActions.clearAndSendKeys(By.xpath("(//*[@id=\"grdtxtGEVendorChallanQty\"])[" + i + "]"), vendor_qty);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtGEGRNQty'])[" + i + "]"), grn_qty);
			webActions.selectByVisibleText(By.xpath("(//*[@id='grdDDLUnloadingArea'])[" + i + "]"), unloading_area);
			js.executeScript("window.scrollBy(2000,0)");
			Thread.sleep(2000);
			webActions.selectByVisibleText(By.xpath("(//*[@id='grdDDLUnloadedBy'])[" + i + "]"), unloaded_by);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBSerialNumber'])[" + i + "]"), serial_no);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBCardNo'])[" + i + "]"), card_no);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBFirstWeighingMachineNo'])[" + i + "]"),
					first_machine_no);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBSecondWeighingMachineNo'])[" + i + "]"),
					second_machine_no);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBFirstWeight'])[" + i + "]"), first_weight);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grdtxtWBSecondWeight'])[" + i + "]"), second_weight);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grddpWBInDateTime'])[" + i + "]"), in_date);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			webActions.clearAndSendKeys(By.xpath("(//*[@id='grddpWBOutDateTime'])[" + i + "]"), out_date);
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
		Thread.sleep(3000);
		

	}
}
