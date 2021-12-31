package WcWebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import WebUtil.WebActions;

public class GatePassPage {
	Robot robot;
	String path;
	JavascriptExecutor javascriptExecutor;
	WebDriverWait wait;
	String gatePassNumber;
	JavascriptExecutor js1;

	// ==========================Objects==================================
	WebActions webActions = new WebActions();

	// ==========================Locators==================================
	public static By username = By.xpath("//*[@id=\"USER_ID\"]");
	public static By password = By.xpath("//*[@id=\"PASSWORD\"]");
	public static By loginButton = By.xpath("//*[@id=\"kt_login_signin_submit\"]");

	public static By gatePassTab = By.xpath("(//span[text()='Gate Pass'])[1]");
	public static By gatePassSubtab = By
			.xpath("((//span[text()='Gate Pass'])[1]//following::span[text()='Gate Pass'])[1]");
	public static By gatePassStoreTab = By.xpath("(//span[text()='Gate Pass-Store'])[1]");
	public static By gatePassChallanTab = By.xpath("(//span[text()='Gate Pass-Challan'])[1]");
	public static By plusGatePassButton = By.xpath("//*[@class='btn btn-brand btn-elevate btn-icon-sm btn-sm']");
	public static By departmentContainer = By.xpath("//*[@id=\"select2-crDdlDepartmentId-container\"]");
	public static By inputField = By.xpath("/html/body/span/span/span[1]/input");
	public static By siteContainer = By.xpath("//*[@id=\"select2-crDdlSiteId-container\"]");
	public static By typeContainer = By.xpath("//*[@id=\"select2-crDdlGatePassTypeId-container\"]");
	public static By dateInput = By.xpath("//*[@id=\"crTxtRequestDate\"]");
	public static By saveButton = By.xpath("//*[@id=\"btnSave\"]");
	public static By closeButton = By.xpath("//*[@id=\"createGatePassModal\"]/div/div/div[1]/button");
	public static By vendorContainer = By.xpath("//span[@id='select2-hdnVendorID-container']");
	public static By siteInput = By.xpath("//input[@placeholder='Site']");
	public static By departmentInput = By.xpath("//input[@placeholder='Department']");
	public static By gatePassTypeInput = By.xpath("//input[@placeholder='Gate Pass Type']");
	public static By workFlowStatus = By.xpath("//input[@placeholder='Work Flow Status']");
	public static By draftedGatePass = By.xpath("//a[@title='Edit Gate Pass']");
	public static By expectedDateOfReturn = By.xpath("//*[@id=\"TxtEdor\"]");
	public static By gatePassReasonContainer = By.xpath("//span[@id='select2-ddlgatepassreason-container']");
	public static By updateButton = By.xpath("//button[@id='btnUpdate']");
	public static By gatePassLineButton = By.xpath("//*[@id=\"headingTwo4\"]/div");
	public static By deleteLineButton = By.xpath("(//*[@id=\"btnLineDelete\"]/i)[1]");
	public static By yesButton = By.xpath("//button[text()='Yes']");
	public static By itemCodeSearch = By.xpath("//*[@id=\"btnOpenSearchModal\"]");
	public static By itemCodeInput = By.xpath("//*[@id=\"grdTxt_1\"]");
	public static By unitPrice = By.xpath("//*[@id=\"txtapproxprice\"]");
	public static By configurationDropDown = By.xpath("//*[@id=\"ddlConfiguration\"]");
	public static By quantity = By.xpath("//*[@id=\"txtQty\"]");
	public static By addLine = By.xpath("//*[@id=\"btnSubmitmat_REQLINE\"]");
	public static By submittButton = By.xpath("//*[@id=\"btnSubmitOpen\"]");
	public static By submitRemarks = By.xpath("//*[@id=\"txtSubmitRemark\"]");
	public static By finalSubmit = By.xpath("//*[@id=\"btnFinalSubmit\"]");
	public static By gatePassNumberText = By.xpath("//*[@id=\"spanVersionNo\"]");
	public static By account = By.xpath("//*[@id=\"kt_header\"]/div[4]/div[3]/div[2]/div/span[3]");
	public static By signOut = By.xpath("//*[@id=\"kt_header\"]/div[4]/div[3]/div[3]/div[2]/div/a[1]");

	public static By workFlowApprovalTab = By.xpath("(//span[text()='Workflow Approval'])[1]");
	public static By approvalGatePassTab = By
			.xpath("(//span[text()='Workflow Approval'])[1]//following::span[text()='Gate Pass'][1]");
	public static By actionOption = By.xpath("/html/body/div[4]/a[1]");
	public static By actionName = By.xpath("//*[@id=\"drpAction\"]");
	public static By approveRemarks = By.xpath("//*[@id=\"txtRemark\"]");
	public static By approveSubmit = By.xpath("//*[@id=\"btnWBSubmit\"]");
	public static By gatePassIdInput = By.xpath("//input[@placeholder='GatePass ID']");
	public static By vehicleNumber = By.xpath("//*[@id=\"txtvehileno\"]");
	public static By modeOfDeliveryDropdown = By.xpath("//*[@id=\"ddlModeOfDelivery\"]");
	public static By modeOfTransport = By.xpath("//span[@id='select2-ddlModeOfTransport-container']");
	public static By postButton = By.xpath("//*[@id=\"btnpostStore\"]");
	public static By challanNumber = By.xpath("//*[@id=\"txtChallanNo\"]");
	public static By createChallan = By.xpath("//*[@id=\"btnCreateChallan\"]");
	public static By gateOut = By.xpath("//*[@id=\"btngateoutStore\"]");

	// gateEntry locators

	public void wonderCementLogin(String userName, String passWord) throws Exception {
		wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 100);

		webActions.sendKeys(username, userName);
		webActions.sendKeys(password, passWord);
		webActions.Click(loginButton, "Login to WC");
	}

	public void filePathValue() {

		path = "C:\\Users\\Sunil\\Downloads\\GatePassInputs-NonReturnable.xlsx";

	}

	public void createGatePass() throws Exception {

		path = "C:\\Users\\Sunil\\Downloads\\GatePassInputs-NonReturnable.xlsx";

		String user_name = webActions.getExcelData(path, "Credentials", 1, 0);
		String passcode = webActions.getExcelData(path, "Credentials", 1, 1);

		int headersSize = webActions.getAvailableRowCount(path, "GatePassHeader");
		System.out.println("Headers size is: " + headersSize);

		for (int i = 1; i < headersSize; i++) {

			wonderCementLogin(user_name, passcode);

			String department = webActions.getExcelData(path, "GatePassHeader", i, 0);
			String site = webActions.getExcelData(path, "GatePassHeader", i, 1);
			String expected_dateOfReturn = webActions.getExcelData(path, "GatePassHeader", i, 2);
			String vendor = webActions.getExcelData(path, "GatePassHeader", i, 3);
			String gate_pass_reason = webActions.getExcelData(path, "GatePassHeader", i, 4);
			String remarks = webActions.getExcelData(path, "GatePassHeader", i, 5);
			String mode_of_delivery = webActions.getExcelData(path, "GatePassHeader", i, 6);
			String mode_of_trasport = webActions.getExcelData(path, "GatePassHeader", i, 7);
			String transporterCode = webActions.getExcelData(path, "GatePassHeader", i, 8);
			String vehicle_number = webActions.getExcelData(path, "GatePassHeader", i, 9);

			webActions.Click(gatePassTab, "Gate pass");
			webActions.Click(gatePassSubtab, "gate pass sub tab");
			webActions.Click(plusGatePassButton, "+ gate pass");
			webActions.Click(departmentContainer, "Department");
			webActions.clearAndSendKeys(inputField, department);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(siteContainer, "Site");
			webActions.clearAndSendKeys(inputField, site);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(typeContainer, "Type");
			webActions.clearAndSendKeys(inputField, "Returnable");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(saveButton, "save");
			Thread.sleep(2000);

			boolean isTrue = webActions.isDisplayedList(vendorContainer, "check for vendor container");
			if (isTrue) {

				System.out.println("There is no gate pass with above details...............");
				Thread.sleep(2000);
				webActions.Click(vendorContainer, "vendor container");
			} else {
				webActions.Click(closeButton, "close");
				webActions.clearAndSendKeys(siteInput, site);
				webActions.clearAndSendKeys(departmentInput, "2071" + "*");
				webActions.clearAndSendKeys(gatePassTypeInput, "Returnable gate pass");
				webActions.clearAndSendKeys(workFlowStatus, "Draft");
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				webActions.Click(draftedGatePass, "Gate pass");
				webActions.switchTab();
				Thread.sleep(2000);
				webActions.Click(vendorContainer, "Vendor container");
			}

			Thread.sleep(2000);
			webActions.clearAndSendKeys(inputField, vendor);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(expectedDateOfReturn, "expected date of return");
			WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(expectedDateOfReturn);
			javascriptExecutor = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
			javascriptExecutor.executeScript("arguments[0].value=' " + expected_dateOfReturn + "' ", ele);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			webActions.Click(gatePassReasonContainer, "Gate pass Reason");
			Thread.sleep(5000);
			webActions.clearAndSendKeys(inputField, gate_pass_reason);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			webActions.Click(updateButton, "Update");
			Thread.sleep(2000);
			javascriptExecutor.executeScript("window.scrollBy(0,500)", "");

			// end of loop

			webActions.ClickJSE(gatePassLineButton, "gate pass lines");

			boolean isTrue1 = webActions.isDisplayedList(deleteLineButton, "delete line button");
			if (isTrue1) {
				System.out.println("lines are displayed....");
				ArrayList lines = (ArrayList) webActions.getListofElements(By.xpath("//*[@id='btnLineDelete']"),
						"lines");
				for (int j = 1; j < lines.size() + 1; j++) {
					Thread.sleep(2000);
					webActions.waitForVisible(By.xpath("(//*[@id=\"btnLineDelete\"])[" + 1 + "]"));
					webActions.Click(By.xpath("(//*[@id=\"btnLineDelete\"])[" + 1 + "]"), "delete");
					webActions.Click(yesButton, "Yes");

				}

			} else {
				System.out.println("no lines are displayed...");
			}
			Thread.sleep(2000);
			javascriptExecutor.executeScript("window.scrollBy(0,-500)", "");

			int linesSize = webActions.getAvailableRowCount(path, "GatePassLine" + i);
			for (int k = 1; k < linesSize; k++) {

				String item_code = webActions.getExcelData(path, "GatePassLine" + i, k, 1);
				String unit_price = webActions.getExcelData(path, "GatePassLine" + i, k, 2);
				String configuration = webActions.getExcelData(path, "GatePassLine" + i, k, 3);
				String Quantity = webActions.getExcelData(path, "GatePassLine" + i, k, 4);

				if (i > 1) {
					Thread.sleep(3000);
				}
				Thread.sleep(3000);
				webActions.Click(itemCodeSearch, "Search item code");
				Thread.sleep(3000);
				webActions.clearAndSendKeys(itemCodeInput, item_code);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(5000);
				webActions.waitForVisible((By.xpath(
						"(//input[@id='grdhdnProductNumber' and @value='" + item_code + "']//ancestor::tr//span)[1]")));
				Thread.sleep(3000);
				webActions.Click(By.xpath(
						"(//input[@id='grdhdnProductNumber' and @value='" + item_code + "']//ancestor::tr//span)[1]"),
						"item code radio");
				webActions.clearAndSendKeys(unitPrice, unit_price);
				webActions.selectByVisibleText(configurationDropDown, configuration);
				webActions.clearAndSendKeys(quantity, Quantity);
				webActions.Click(addLine, "Add");

			}

			Thread.sleep(2000);
			javascriptExecutor.executeScript("window.scrollBy(0,-500)", "");
			webActions.Click(submittButton, "Submit");
			Thread.sleep(1000);
			webActions.clearAndSendKeys(submitRemarks, "Remarks");
			webActions.Click(finalSubmit, "Final Submit");
			Thread.sleep(2000);
			gatePassNumber = webActions.getElmText(gatePassNumberText);
			webActions.writeData(path, "GatePassHeader", i, 11, gatePassNumber);
			Thread.sleep(5000);
			webActions.ClickJSE(account, "Click on user account");
			wait.until(ExpectedConditions.elementToBeClickable(account));
			Thread.sleep(3000);
			webActions.ClickJSE(signOut, "sign out of the account");
			Thread.sleep(3000);
			String approverUserName = webActions.getExcelData(path, "Credentials", 1, 2);
			String approverPassword = webActions.getExcelData(path, "Credentials", 1, 3);
			wonderCementLogin(approverUserName, approverPassword);

			js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
			js1.executeScript("window.scrollBy(0,-1000)");
			Thread.sleep(2000);
			webActions.Click(workFlowApprovalTab, "workflow approval tab");
			webActions.Click(approvalGatePassTab, "Gate pass tab");
			Thread.sleep(3000);
			webActions.Click(By.xpath("(//a[text()='" + gatePassNumber + "']/ancestor::tr//a)[1]"),
					"gate pass options");
			webActions.Click(actionOption, "Action");
			Thread.sleep(3000);
			WebElement ele1 = DriverFactory.getInstance().getWebDriver().findElement(actionName);
			Select select = new Select(ele1);
			select.selectByValue("1");
			webActions.clearAndSendKeys(approveRemarks, "Remarks");
			Thread.sleep(2000);
			webActions.Click(approveSubmit, "Submit");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(account));
			webActions.ClickJSE(account, "Click on user account");
			Thread.sleep(3000);
			webActions.ClickJSE(signOut, "sign out of the account");
			storeUserSignIn(i);

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(account));
			webActions.ClickJSE(account, "Click on user account");
			Thread.sleep(3000);
			webActions.ClickJSE(signOut, "sign out of the account");
		}

	}

	public void storeUserSignIn(int i) throws Exception {

		String mode_of_delivery = webActions.getExcelData(path, "GatePassHeader", i, 6);
		String mode_of_transport = webActions.getExcelData(path, "GatePassHeader", i, 7);
		String transporterCode = webActions.getExcelData(path, "GatePassHeader", i, 8);
		String vehicle_number = webActions.getExcelData(path, "GatePassHeader", i, 9);

		String vendor = webActions.getExcelData(path, "GatePassHeader", i, 3);

		String storeUserName = webActions.getExcelData(path, "Credentials", 1, 4);
		String storePassword = webActions.getExcelData(path, "Credentials", 1, 5);
		wonderCementLogin(storeUserName, storePassword);
		Thread.sleep(2000);
		webActions.Click(gatePassTab, "gate pass");
		Thread.sleep(2000);
		webActions.Click(gatePassStoreTab, "Gate pass store");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(gatePassIdInput, gatePassNumber);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		webActions.waitForVisible(By.xpath("//*[contains(text(),'" + gatePassNumber + "')]"));
		webActions.Click(By.xpath("//*[contains(text(),'" + gatePassNumber + "')]"), "Approved gate pass number");

		Thread.sleep(2000);
		WebElement elem = DriverFactory.getInstance().getWebDriver().findElement(modeOfDeliveryDropdown);
		js1.executeScript("arguments[0].scrollIntoView(true);", elem);

		System.out.println("....................." + mode_of_delivery);
		System.out.println("....................." + mode_of_transport);

		webActions.selectByVisibleText(modeOfDeliveryDropdown, mode_of_delivery);
		webActions.Click(modeOfTransport, "Mode of transport");
		Thread.sleep(1000);
		webActions.clearAndSendKeys(inputField, mode_of_transport);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		webActions.clearAndSendKeys(vehicleNumber, vehicle_number);
		js1.executeScript("window.scrollBy(0,-1000)");
		webActions.Click(postButton, "Post");
		Thread.sleep(5000);
		webActions.ClickJSE(account, "Click on user account");
		wait.until(ExpectedConditions.elementToBeClickable(account));
		Thread.sleep(3000);
		webActions.ClickJSE(signOut, "sign out of the account");
		String challanUserName = webActions.getExcelData(path, "Credentials", 1, 4);
		String challanPassword = webActions.getExcelData(path, "Credentials", 1, 5);
		wonderCementLogin(challanUserName, challanPassword);
		Thread.sleep(2000);
		webActions.Click(gatePassTab, "Gate pass");
		Thread.sleep(1000);
		webActions.Click(gatePassChallanTab, "Gate pass store");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(gatePassIdInput, gatePassNumber);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		webActions.waitForVisible(By.xpath("//*[contains(text(),'" + gatePassNumber + "')]"));
		webActions.Click(By.xpath("//*[contains(text(),'" + gatePassNumber + "')]"), "posted gate pass number");
		Thread.sleep(2000);
		int min = 200;
		int max = 400;
		int b = (int) (Math.random() * (max - min + 1) + min);
		webActions.clearAndSendKeys(challanNumber, "000" + b + "00" + b);
		webActions.Click(createChallan, "create challan");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(account));
		webActions.ClickJSE(account, "Click on user account");
		Thread.sleep(3000);
		webActions.ClickJSE(signOut, "sign out of the account");
		String gateUserName = webActions.getExcelData(path, "Credentials", 1, 6);
		String gatePassword = webActions.getExcelData(path, "Credentials", 1, 7);
		wonderCementLogin(gateUserName, gatePassword);
		Thread.sleep(2000);
		webActions.Click(gatePassTab, "Gate pass");
		Thread.sleep(1000);
		webActions.Click(gatePassStoreTab, "gate pass store");
		Thread.sleep(1000);
		webActions.clearAndSendKeys(gatePassIdInput, gatePassNumber);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		webActions.waitForVisible(By.xpath("//*[contains(text(),'" + gatePassNumber + "')]"));
		webActions.Click(By.xpath("//*[contains(text(),'" + gatePassNumber + "')]"), "posted gate pass number");
		Thread.sleep(2000);
		webActions.Click(gateOut, "Gate out");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(account));
		webActions.ClickJSE(account, "Click on user account");
		Thread.sleep(3000);
		webActions.ClickJSE(signOut, "sign out of the account");
		Thread.sleep(5000);

		ReturnableGatePass pass = new ReturnableGatePass();
		pass.createGateEntry(vendor, gatePassNumber, i);

	}

	// RGB - Gate Entry

}
