package WcWebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import WebPages.WCPrToPo;
import WebUtil.WebActions;

public class PoWorkflow {

	Robot robot;
	String delivery_date;
	String poNumber;

	// ==========================Objects==================================
	WebActions webActions = new WebActions();

	// ==========================Locators==================================
	public static By purchseTab = By.xpath("(//span[text()='Purchase'])[1]");
	public static By ReleasedPurchasedRequisitionTab = By
			.xpath("((//span[text()='Purchase'])[1]//following::span[text()='Released Purchase Requisition'])[1]");
	public static By prNumberInput = By.xpath("//input[@placeholder='PR No']");
	public static By prNumberInput2 = By.xpath("(//input[@placeholder='PR No'])[2]");
	public static By prOptions = By.xpath("//*[text()='PR22004639']/ancestor::tr/td/span");
	public static By poButton = By.xpath("//a[contains(text(),' PO')]");
	public static By newRadioButton = By.xpath("((//input[@name='GeneratePO'])[1]//following::span)[1]");
	public static By process_po = By.xpath("//*[@id='btnProcessPO']");
	public static By poHeaderDetails = By.xpath("//*[contains(text(),'PO Header Detail')]");
	public static By financialDetails = By.xpath("//*[contains(text(),'Financial Detail')]");
	public static By extraDetail = By.xpath("//*[contains(text(),'Extra Detail')]");
	public static By paymentMilestone = By.xpath("(//*[contains(text(),'Payment Milestone')])[1]");
	public static By vendorSearch = By.xpath("//*[@id='btnVendorPopUp']");
	public static By vendorInput = By.xpath("//*[@id='tblVendorList']/thead/tr/th[2]/input[@placeholder='Code']");
	public static By vendorRadio = By.xpath("//*[text()='104231']/ancestor::tr/td/label/span");
	public static By poCategory = By.xpath("//*[@id='POCategory']");
	public static By tdsGroupContainer = By.xpath("//*[@id='select2-TDSGroup-container']");
	public static By deliveryDate = By.xpath("//*[@id=\"DeliveryDate\"]");
	public static By lineDeliveryDate = By.xpath("//*[@id=\"SubDeliveryDate\"]");
	public static By deliveryName = By.xpath("//*[@id='select2-DeliveryName-container']");
	public static By TEFRContainer = By.xpath("//*[@id='select2-TEFR-container']");
	public static By lineTEFRContainer = By.xpath("//*[@id=\"select2-SubTEFR-container\"]");
	public static By TCSGroupContainer = By.xpath("//*[@id='select2-TCSGroup-container']");
	public static By paymentTerm = By.xpath("//*[@id='select2-PaymentTerm-container']");
	public static By purpose = By.xpath("//*[@id=\"Purpose\"]");
	public static By poQuantity = By.xpath("//*[@id='SubQty']");
	public static By poUnitPrice = By.xpath("//*[@id='SubUnitPrice']");
	public static By otherDetailTab = By.xpath("//a[text()='Other Detail']");
	public static By lineTcsGroupContainer = By.xpath("//*[@id=\"select2-SubTCSGroup-container\"]");
	public static By lineEdit = By.xpath("//*[@id=\"btnShow\"]");
	public static By projectCategoryContainer = By.xpath("//*[@id='select2-SubProjectCategory-container']");
	public static By fixedAssetGroupContainer = By.xpath("//*[@id='select2-SubFixedAssetGroup-container']");
	public static By lineTdsGroupContainer = By.xpath("//*[@id=\"select2-SubTDSGroup-container\"]");
	public static By taxInfoTaab = By.xpath("//a[text()='Tax Info']");
	public static By hsnsearchButton = By.xpath("//*[@id='divHSN']");
	public static By hsnInput = By.xpath("//*[@id=\"tblHSNList\"]/thead/tr/th[2]/input");
	public static By hsnRadio = By.xpath("//td[text()='06029090']/ancestor::tr/td/label/span");
	public static By sacSearch = By.xpath("//*[@id='divSAC']");
	public static By sacInput = By.xpath("//input[@placeholder='SAC Code']");
	public static By sacRadio = By.xpath("//*[text()='440013']/ancestor::tr/td/label/span");
	public static By linesLevelTab = By.xpath("//a[text()='Lines Level']");
	public static By lineSaveButton = By.xpath("//*[@id='btnUpdatePOSubDetails']");
	public static By updateButton = By.xpath("//*[@id='btnUpdateHeader']");
	public static By inputField = By.xpath("/html/body/span/span/span[1]/input");
	public static By allPRtab = By.xpath("//*[contains(text(),'All PR')]");
	public static By myPRtab = By.xpath("//a[contains(text(),'My PR')]");
	public static By allPrPagePrOptionsButton = By.xpath("//*[@id=\"tblAllPR\"]/tbody/tr[1]/td[1]/span/a");
	public static By delegateOption = By.xpath("/html/body/div[4]/a[4]");
	public static By delegateContainer = By.xpath("//*[@dir='ltr']");
	public static By delegatInput = By.xpath("/html/body/span/span/span[1]/input");
	public static By delegateSubmit = By.xpath("//*[@id=\"btnDelegate\"]");
	public static By discountField = By.xpath("//*[@id=\"SubDiscount\"]");
	public static By deliveryMode = By.xpath("//*[@id=\"select2-DeliveryMode-container\"]");
	public static By deliveryTerm = By.xpath("//*[@id=\"select2-DeliveryTerm-container\"]");
	public static By addDescriptionButton = By.xpath("//*[@id=\"tblPaymentMilestone_new\"]");
	public static By descriptionField = By.xpath("//*[@id=\"txtDescription\"]");
	public static By percentageField = By.xpath("//*[@id=\"txtPercentage\"]");
	public static By poUpdate = By.xpath("//*[@id=\"btnUpdateHeader\"]");
	public static By account = By.xpath("//*[@id=\"kt_header\"]/div[4]/div[3]/div[2]/div/span[3]");
	public static By signOut = By.xpath("//*[@id=\"kt_header\"]/div[4]/div[3]/div[3]/div[2]/div/a[1]");
	public static By po_number = By.xpath("(//h3[text()='Purchase Order']//following::div)[1]");
	public static By poSubmit = By.xpath("/html/body/div[4]/a[5]");
	public static By workflowApproval = By.xpath("(//span[text()='Workflow Approval'])[1]");
	public static By purchaseOrder = By.xpath("((//span[text()='Workflow Approval'])[1]//following::span[text()='Purchase Order'])[1]");
	public static By poInputField = By.xpath("//input[@placeholder='PO No']");
	public static By poApprove = By.xpath("/html/body/div[4]/a[6]");
    public static By poRemarks = By.xpath("//*[@id=\"txtRemark\"]");
    public static By poRemarksSubmit = By.xpath("//*[@id=\"btnSubmitRemark\"]");
    public static By poApprovalRemarks = By.xpath("//*[@id=\"txtRemark\"]");
    public static By poRemarksApprove = By.xpath("//*[@id=\"btnWBSubmit\"]");
    public static By prDescription = By.xpath("(//input[@placeholder='PR Description'])[2]");
	
	
	
	
	
	
	
	
	
	public void POcreation(String pr_number, String index) throws Exception {

		multiplePRs pr = new multiplePRs();
		
	    

		int poHeaderLength = pr.getAvailableRowCount("PoHeader");
		    int i = Integer.parseInt(index);

			String po_vendor = pr.getExcelData("PoHeader", i, 0);
			String purchase_type = pr.getExcelData("PoHeader", i, 1);
			String POCategory = pr.getExcelData("PoHeader", i, 2);
			String headerTDS = pr.getExcelData("PoHeader", i, 3);
			String headerTCS = pr.getExcelData("PoHeader", i, 4);
			delivery_date = pr.getExcelData("PoHeader", i, 5);
			String delivery_mode = pr.getExcelData("PoHeader", i, 6);
			String delivery_term = pr.getExcelData("PoHeader", i, 7);
			String payment_term = pr.getExcelData("PoHeader", i, 8);
			String description = pr.getExcelData("PoHeader", i, 9);
			String percentage = pr.getExcelData("PoHeader", i, 10);
			String header_tefr = pr.getExcelData("PoHeader", i, 11);
			String delivery_name = "";
			
			String prType1 = pr.getExcelData("Header", i, 1);

			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(),200);
			wait.until(ExpectedConditions.elementToBeClickable(purchseTab));
			webActions.Click(purchseTab, "click on purchse requision tab");
			webActions.Click(ReleasedPurchasedRequisitionTab, "click on released purchase requision");
			webActions.clearAndSendKeys(prNumberInput, pr_number);

			robot = new Robot();
			robot.delay(1000);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);

			boolean isTrue = webActions.isDisplayedList(
					By.xpath("(//*[text()='" + pr_number + "']/ancestor::tr//a)[1]"), "check for the PR");
			if (isTrue) {

				System.out.println("element is present not displayed in My PRs tab...............");
				webActions.Click(By.xpath("//*[text()='" + pr_number + "']/ancestor::tr/td/span"),
						"clik on pr options");

			} else {

				System.out.println("element is present in all PRs...............");
				webActions.Click(allPRtab, "click on all PR tab");
				Thread.sleep(6000);
				webActions.clearAndSendKeys(prNumberInput2, pr_number);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(6000);
				webActions.Click(prDescription, "PR description");
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[text()='" + pr_number + "']/ancestor::tr/td/span")));
				webActions.Click(By.xpath("//*[text()='" + pr_number + "']/ancestor::tr/td/span"),
						"clik on pr options");
				Thread.sleep(2000);
				webActions.Click(delegateOption, "click on delegate option");
				webActions.Click(delegateContainer, "click on delegate container");
				webActions.clearAndSendKeys(delegatInput, "20574");
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_ENTER);
				webActions.Click(delegateSubmit, "click on submit");
				webActions.Click(myPRtab, "click on my pr tab");
				webActions.clearAndSendKeys(prNumberInput, pr_number);
				Thread.sleep(6000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(6000);
				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[text()='" + pr_number + "']/ancestor::tr/td/span")));
				webActions.Click(By.xpath("//*[text()='" + pr_number + "']/ancestor::tr/td/span"),
						"clik on pr options");

			}

			Thread.sleep(3000);
			webActions.Click(poButton, "click on po");
			webActions.Click(newRadioButton, "click on new radion button");
			webActions.Click(process_po, "click on process po");
			Thread.sleep(3000);
			
			poNumber = webActions.getElmText(po_number);
			pr.writeData("PoHeader", i, 12, poNumber);
			webActions.Click(vendorSearch, "search for vendor");
			Thread.sleep(3000);
			webActions.clearAndSendKeys(vendorInput, po_vendor);
			robot.delay(1000);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			
			Thread.sleep(5000);
			webActions.waitForVisible(By.xpath("//*[text()='" + po_vendor + "']/ancestor::tr/td/label/span"));
			webActions.Click(By.xpath("//*[text()='" + po_vendor + "']/ancestor::tr/td/label/span"),
					"select the vendor radio");
			webActions.Click(financialDetails, "click on financialdetails tab");
			webActions.Click(tdsGroupContainer, "click on tds group container");
			Thread.sleep(2000);
			webActions.sendKeys(inputField, headerTDS);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(deliveryName, "click on delivery name");
			Thread.sleep(2000);
			webActions.Click(inputField, delivery_name);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			WebElement element = DriverFactory.getInstance().getWebDriver().findElement(deliveryDate);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
			System.out.println("date is....... " + delivery_date);
			javascriptExecutor.executeScript("arguments[0].value='" + delivery_date + "'", element);
			webActions.Click(deliveryMode, "click on delivery mode");
			webActions.clearAndSendKeys(inputField, delivery_mode);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			if(prType1.equals("Capital Supply")) {
				webActions.Click(TEFRContainer, "TEFR");
			    webActions.clearAndSendKeys(inputField, header_tefr);
			    robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);	
			}
		    
			Thread.sleep(2000);
			webActions.Click(deliveryTerm, "click on delivery term");
			webActions.clearAndSendKeys(inputField, delivery_term);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			webActions.Click(tdsGroupContainer, "click on tds group container");
			webActions.clearAndSendKeys(inputField, headerTDS);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(paymentTerm, "click on payment term");
			Thread.sleep(2000);
			webActions.clearAndSendKeys(inputField, payment_term);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(extraDetail, "clik on extra details");
			webActions.clearAndSendKeys(purpose, "testing");
			webActions.Click(paymentMilestone, "click on payment mile stone");
			webActions.Click(addDescriptionButton, "click on add description button");
			Thread.sleep(2000);
			webActions.clearAndSendKeys(descriptionField, description);
			webActions.clearAndSendKeys(percentageField, percentage);
			
			String index1 = String.valueOf(i);
			
			String prType = pr.getExcelData("Header", i, 1);
			String prSubType = pr.getExcelData("Header", i, 2);
			
			if(prType.equals("Revenue Service") || prType.equals("Capital Service") || (prType.equals("Project Service")) && !prSubType.equals("Project")) {
				
				addPoServiceLines(index1);
			}else if(prType.equals("Revenue Supply") || prType.equals("Project Supply")) {
				
				addPoSupplyLines(index1);
			}else if((prType.equals("Project Supply") && prSubType.equals("Project")) || prType.equals("Capital Supply") && prSubType.equals("Project") 
					|| (prType.equals("Project Service")) && prSubType.equals("Project")) {
				
				addPoProjectLines(index1);
			}else {
				System.out.println("PR type is not matched....");
			}
			
			

	}

	public void addPoServiceLines(String index) throws Exception {

		System.out.println("adding po service lines");
		multiplePRs pr = new multiplePRs();
		ArrayList<WebElement> lineEditButtons = new ArrayList();
		lineEditButtons = (ArrayList<WebElement>) DriverFactory.getInstance().getWebDriver().findElements(lineEdit);

		for (int i = 0; i < lineEditButtons.size(); i++) {

			System.out.println("po lines number...." + lineEditButtons.size());

			String po_quantity = pr.getExcelData("PoLine"+index, i + 1, 0);
			String po_unitprice = pr.getExcelData("PoLine"+index, i + 1, 1);
			String discount = pr.getExcelData("PoLine"+index, i + 1, 2);
			String lineTEFR = pr.getExcelData("PoLine"+index, i + 1, 3);
			String lineTDS = pr.getExcelData("PoLine"+index, i + 1, 4);
			String lineTCS = pr.getExcelData("PoLine"+index, i + 1, 5);
			String costCenter = pr.getExcelData("PoLine"+index, i + 1, 6);
			String location = pr.getExcelData("PoLine"+index, i + 1, 7);
			String configuration = pr.getExcelData("PoLine"+index, i + 1, 8);
			String project_category = pr.getExcelData("PoLine"+index, i + 1, 9);
			String HSN = pr.getExcelData("PoLine"+index, i + 1, 10);
			String SAC = pr.getExcelData("PoLine"+index, i + 1, 11);
			String fixed_assetGroup = pr.getExcelData("PoLine"+index, i + 1, 12);
			String GST_amount = pr.getExcelData("PoLine"+index, i + 1, 13);
			String Gross_amount = pr.getExcelData("PoLine"+index, i + 1, 14);
			String total_amount = pr.getExcelData("PoLine"+index, i + 1, 15);

			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

			if (i > 0) {
				int index1 = i + 1;
				DriverFactory.getInstance().getWebDriver()
						.findElement(By.xpath("(//*[@id=\"btnShow\"])[" + index1 + "]")).click();

			} else {
				Thread.sleep(5000);
				System.out.println("line element is " + lineEditButtons.get(i));
				javascriptExecutor.executeScript("arguments[0].click();", lineEditButtons.get(i));
				Thread.sleep(3000);
			}
			webActions.clearAndSendKeys(poQuantity, po_quantity);
			webActions.clearAndSendKeys(poUnitPrice, po_unitprice);
			webActions.clearAndSendKeys(discountField, discount);
			Thread.sleep(2000);
			WebElement lineDate = DriverFactory.getInstance().getWebDriver().findElement(lineDeliveryDate);
			javascriptExecutor.executeScript("arguments[0].value='" + delivery_date + "'", lineDate);
			webActions.Click(otherDetailTab, "click on other details");
			webActions.Click(lineTEFRContainer, "click on TEFR");
			webActions.clearAndSendKeys(inputField, lineTEFR);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
//					webActions.Click(lineTcsGroupContainer, "clic on line tcs container");
//					webActions.clearAndSendKeys(inputField, lineTCS);
//					Thread.sleep(1000);
//					robot.keyPress(KeyEvent.VK_ENTER);
//		    		robot.keyRelease(KeyEvent.VK_ENTER);
//		    		webActions.Click(projectCategoryContainer, "click on project container");
//		    		webActions.clearAndSendKeys(inputField, project_category);
//		    		Thread.sleep(1000);
//					robot.keyPress(KeyEvent.VK_ENTER);
//		    		robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
//			webActions.Click(lineTdsGroupContainer, "click on line tds container");
//			webActions.clearAndSendKeys(inputField, lineTDS);
//			Thread.sleep(1000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(taxInfoTaab, "clik on tax info tab");
			Thread.sleep(2000);

			if (HSN != "") {
				webActions.Click(hsnsearchButton, "click on HSN search");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(hsnInput, HSN);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				webActions.Click(By.xpath("//td[text()='" + HSN + "']/ancestor::tr/td/label/span"), "select HSN");
			}

			Thread.sleep(4000);
			if (SAC != "") {
				webActions.Click(sacSearch, "click on SAC search");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(sacInput, SAC);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				webActions.Click(By.xpath("//*[text()='" + SAC + "']/ancestor::tr/td/label/span"), "select sac");
			}

			webActions.Click(linesLevelTab, "click on lines level tab");
			webActions.Click(lineSaveButton, "clik on save");
			Thread.sleep(3000);

		}

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		js.executeScript("window.scrollBy(0,-3500)");
		webActions.Click(poUpdate, "update po");
		Thread.sleep(4000);
		webActions.Click(By.xpath("(//*[text()='" + poNumber + "']/ancestor::tr//a)[1]"), "click on po options");
		Thread.sleep(4000);
		webActions.ClickJSE(poSubmit, "click on po submit");
		Thread.sleep(1000);
		webActions.clearAndSendKeys(poRemarks, "remarks");
		Thread.sleep(2000);
		webActions.Click(poRemarksSubmit, "submit");
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(),100);
		wait.until(ExpectedConditions.elementToBeClickable(account));
		webActions.ClickJSE(account, "click on account");
		Thread.sleep(2000);
		webActions.ClickJSE(signOut, "sign out of the account");

		Thread.sleep(2000);
		approvePO();

	}

	public void addPoSupplyLines(String index) throws Exception {

		System.out.println("adding po supply lines");
		multiplePRs pr = new multiplePRs();
		ArrayList<WebElement> lineEditButtons = new ArrayList();
		lineEditButtons = (ArrayList<WebElement>) DriverFactory.getInstance().getWebDriver().findElements(lineEdit);

		for (int i = 0; i < lineEditButtons.size(); i++) {

			System.out.println("po lines number...." + lineEditButtons.size());

			String po_quantity = pr.getExcelData("PoLine"+index, i + 1, 0);
			String po_unitprice = pr.getExcelData("PoLine"+index, i + 1, 1);
			String discount = pr.getExcelData("PoLine"+index, i + 1, 2);
			String lineTEFR = pr.getExcelData("PoLine"+index, i + 1, 3);
			String lineTDS = pr.getExcelData("PoLine"+index, i + 1, 4);
			String lineTCS = pr.getExcelData("PoLine"+index, i + 1, 5);
			String costCenter = pr.getExcelData("PoLine"+index, i + 1, 6);
			String location = pr.getExcelData("PoLine"+index, i + 1, 7);
			String configuration = pr.getExcelData("PoLine"+index, i + 1, 8);
			String project_category = pr.getExcelData("PoLine"+index, i + 1, 9);
			String HSN = pr.getExcelData("PoLine"+index, i + 1, 10);
			String SAC = pr.getExcelData("PoLine"+index, i + 1, 11);
			String fixed_assetGroup = pr.getExcelData("PoLine"+index, i + 1, 12);
			String GST_amount = pr.getExcelData("PoLine"+index, i + 1, 13);
			String Gross_amount = pr.getExcelData("PoLine"+index, i + 1, 14);
			String total_amount = pr.getExcelData("PoLine"+index, i + 1, 15);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

			int index2 = i + 1;
			String extractedItemCode = webActions
					.getElmText(By.xpath(" ((//*[@id=\"btnShow\"])[" + index2 + "]//following::td)[2]"));

			if (i > 0) {
				int index1 = i + 1;
				DriverFactory.getInstance().getWebDriver()
						.findElement(By.xpath("(//*[@id=\"btnShow\"])[" + index1 + "]")).click();

			} else {
				Thread.sleep(5000);
				System.out.println("line element is " + lineEditButtons.get(i));
				javascriptExecutor.executeScript("arguments[0].click();", lineEditButtons.get(i));
				Thread.sleep(3000);
			}
			webActions.clearAndSendKeys(poQuantity, po_quantity);
			webActions.clearAndSendKeys(poUnitPrice, po_unitprice);
			webActions.clearAndSendKeys(discountField, discount);
			Thread.sleep(2000);
			WebElement lineDate = DriverFactory.getInstance().getWebDriver().findElement(lineDeliveryDate);
			javascriptExecutor.executeScript("arguments[0].value='" + delivery_date + "'", lineDate);
			webActions.Click(otherDetailTab, "click on other details");
			webActions.Click(lineTEFRContainer, "click on TEFR");
			webActions.clearAndSendKeys(inputField, lineTEFR);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);

			System.out.println("item code is: " + extractedItemCode);
			if (extractedItemCode.equals("100000004") || extractedItemCode.equals("100000005")
					|| extractedItemCode.equals("100000007") || extractedItemCode.equals("100000003")) {

				webActions.Click(fixedAssetGroupContainer, "Fixed asset group");
				webActions.clearAndSendKeys(inputField, fixed_assetGroup);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
			}
//					webActions.Click(lineTcsGroupContainer, "clic on line tcs container");
//					webActions.clearAndSendKeys(inputField, lineTCS);
//					Thread.sleep(1000);
//					robot.keyPress(KeyEvent.VK_ENTER);
//		    		robot.keyRelease(KeyEvent.VK_ENTER);

//			Thread.sleep(3000);
//			webActions.Click(lineTdsGroupContainer, "click on line tds container");
//			webActions.clearAndSendKeys(inputField, lineTDS);
//			Thread.sleep(1000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(taxInfoTaab, "clik on tax info tab");
			Thread.sleep(2000);

			if (HSN != "") {
				webActions.Click(hsnsearchButton, "click on HSN search");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(hsnInput, HSN);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				webActions.Click(By.xpath("//td[text()='" + HSN + "']/ancestor::tr/td/label/span"), "select HSN");
			}

			Thread.sleep(4000);
			if (SAC != "") {
				webActions.Click(sacSearch, "click on SAC search");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(sacInput, SAC);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				webActions.Click(By.xpath("//*[text()='" + SAC + "']/ancestor::tr/td/label/span"), "select sac");
			}
            Thread.sleep(2000);
			webActions.Click(linesLevelTab, "click on lines level tab");
			webActions.Click(lineSaveButton, "clik on save");
			Thread.sleep(3000);

		}

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		js.executeScript("window.scrollBy(0,-3500)");
		webActions.Click(poUpdate, "update po");
		Thread.sleep(4000);
		webActions.Click(By.xpath("(//*[text()='" + poNumber + "']/ancestor::tr//a)[1]"), "click on po options");
		Thread.sleep(4000);

		webActions.Click(poSubmit, "click on po submit");
		Thread.sleep(1000);
		webActions.clearAndSendKeys(poRemarks, "remarks");
		Thread.sleep(2000);
		webActions.Click(poRemarksSubmit, "submit");
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(),100);
		wait.until(ExpectedConditions.elementToBeClickable(account));
		webActions.ClickJSE(account, "click on account");
		Thread.sleep(2000);
		webActions.ClickJSE(signOut, "sign out of the account");

		Thread.sleep(2000);
		approvePO();
	}

	public void addPoProjectLines(String index) throws Exception {
		multiplePRs pr = new multiplePRs();
		ArrayList<WebElement> lineEditButtons = new ArrayList();
		lineEditButtons = (ArrayList<WebElement>) DriverFactory.getInstance().getWebDriver().findElements(lineEdit);

		for (int i = 0; i < lineEditButtons.size(); i++) {

			System.out.println("po lines number...." + lineEditButtons.size());

			String po_quantity = pr.getExcelData("PoLine"+index, i + 1, 0);
			String po_unitprice = pr.getExcelData("PoLine"+index, i + 1, 1);
			String discount = pr.getExcelData("PoLine"+index, i + 1, 2);
			String lineTEFR = pr.getExcelData("PoLine"+index, i + 1, 3);
			String lineTDS = pr.getExcelData("PoLine"+index, i + 1, 4);
			String lineTCS = pr.getExcelData("PoLine"+index, i + 1, 5);
			String costCenter = pr.getExcelData("PoLine"+index, i + 1, 6);
			String location = pr.getExcelData("PoLine"+index, i + 1, 7);
			String configuration = pr.getExcelData("PoLine"+index, i + 1, 8);
			String project_category = pr.getExcelData("PoLine"+index, i + 1, 9);
			String HSN = pr.getExcelData("PoLine"+index, i + 1, 10);
			String SAC = pr.getExcelData("PoLine"+index, i + 1, 11);
			String fixed_assetGroup = pr.getExcelData("PoLine"+index, i + 1, 12);
			String GST_amount = pr.getExcelData("PoLine"+index, i + 1, 13);
			String Gross_amount = pr.getExcelData("PoLine"+index, i + 1, 14);
			String total_amount = pr.getExcelData("PoLine"+index, i + 1, 15);

			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();

			if (i > 0) {
				int index1 = i + 1;
				DriverFactory.getInstance().getWebDriver()
						.findElement(By.xpath("(//*[@id=\"btnShow\"])[" + index1 + "]")).click();

			} else {
				Thread.sleep(5000);
				System.out.println("line element is " + lineEditButtons.get(i));
				javascriptExecutor.executeScript("arguments[0].click();", lineEditButtons.get(i));
				Thread.sleep(3000);
			}
			webActions.clearAndSendKeys(poQuantity, po_quantity);
			webActions.clearAndSendKeys(poUnitPrice, po_unitprice);
			webActions.clearAndSendKeys(discountField, discount);
			Thread.sleep(2000);
			WebElement lineDate = DriverFactory.getInstance().getWebDriver().findElement(lineDeliveryDate);
			javascriptExecutor.executeScript("arguments[0].value='" + delivery_date + "'", lineDate);
			webActions.Click(otherDetailTab, "click on other details");
			webActions.Click(lineTEFRContainer, "click on TEFR");
			webActions.clearAndSendKeys(inputField, lineTEFR);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
//					webActions.Click(lineTcsGroupContainer, "clic on line tcs container");
//					webActions.clearAndSendKeys(inputField, lineTCS);
//					Thread.sleep(1000);
//					robot.keyPress(KeyEvent.VK_ENTER);
//		    		robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			webActions.Click(projectCategoryContainer, "click on project container");
			webActions.clearAndSendKeys(inputField, project_category);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
//			webActions.Click(lineTdsGroupContainer, "click on line tds container");
//			webActions.clearAndSendKeys(inputField, lineTDS);
//			Thread.sleep(1000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
			webActions.Click(taxInfoTaab, "clik on tax info tab");
			Thread.sleep(2000);

			if (HSN != "") {
				webActions.Click(hsnsearchButton, "click on HSN search");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(hsnInput, HSN);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				webActions.Click(By.xpath("//td[text()='" + HSN + "']/ancestor::tr/td/label/span"), "select HSN");
			}

			Thread.sleep(4000);
			if (SAC != "") {
				webActions.Click(sacSearch, "click on SAC search");
				Thread.sleep(2000);
				webActions.clearAndSendKeys(sacInput, SAC);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				webActions.Click(By.xpath("//*[text()='" + SAC + "']/ancestor::tr/td/label/span"), "select sac");
			}

			webActions.Click(linesLevelTab, "click on lines level tab");
			webActions.Click(lineSaveButton, "clik on save");
			Thread.sleep(3000);

		}

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		js.executeScript("window.scrollBy(0,-3500)");
		webActions.Click(poUpdate, "update po");
		Thread.sleep(4000);
		webActions.Click(By.xpath("(//*[text()='" + poNumber + "']/ancestor::tr//a)[1]"), "click on po options");
		Thread.sleep(4000);

		webActions.Click(poSubmit, "click on po submit");
		Thread.sleep(1000);
		webActions.clearAndSendKeys(poRemarks, "remarks");
		Thread.sleep(2000);
		webActions.Click(poRemarksSubmit, "submit");
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(),100);
		wait.until(ExpectedConditions.elementToBeClickable(account));
		webActions.ClickJSE(account, "click on account");
		Thread.sleep(2000);
		webActions.ClickJSE(signOut, "sign out of the account");

		Thread.sleep(2000);
		approvePO();

	}

	public void approvePO() throws Exception {

		JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	      js1.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
		multiplePRs pr =new multiplePRs();
		pr.wonderCementLogin();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(),100);
		wait.until(ExpectedConditions.elementToBeClickable(workflowApproval));
		webActions.Click(workflowApproval, "workflow approval");
		webActions.Click(purchaseOrder, "purchse order");
		webActions.clearAndSendKeys(poInputField, poNumber);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		webActions.Click(By.xpath("(//*[text()='" + poNumber + "']/ancestor::tr//a)[1]"), "po options");
		Thread.sleep(1000);
		webActions.Click(poApprove, "Approve");
		Thread.sleep(2000);
		webActions.clearAndSendKeys(poApprovalRemarks, "remarks");
		Thread.sleep(2000);
		webActions.Click(poRemarksApprove, "final approve");
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.elementToBeClickable(account));
		webActions.ClickJSE(account, "click on account");
		Thread.sleep(2000);
		webActions.ClickJSE(signOut, "sign out of the account");
		Thread.sleep(2000);

	}

	

}
