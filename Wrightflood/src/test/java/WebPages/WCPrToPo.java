package WebPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import WcWebPages.PoWorkflow;
import WebUtil.WebActions;

public class WCPrToPo {
	
	Robot robot;
	String pr_number;
	WebDriverWait wait;
	
	
	
	// ==========================Objects==================================
			WebActions webActions = new WebActions();

		// ==========================Locators==================================
			
			public static By username = By.xpath("//*[@id=\"USER_ID\"]");
			public static By password = By.xpath("//*[@id=\"PASSWORD\"]");
			public static By loginButton = By.xpath("//*[@id=\"kt_login_signin_submit\"]");
			public static By purchaseRequistionTab = By.xpath("(//span[text()='Purchase Requisition'])[1]");
			public static By purchaseRequisitionSubTab = By.xpath("((//span[text()='Purchase Requisition'])[1]//following::span[text()='Purchase Requisition'])[1]");
			public static By addPrButton = By.xpath("//*[@id=\"btnExport\"]//following::a[1]");
			public static By siteContainer = By.xpath("//*[@id=\"select2-SiteId-container\"]");
			public static By siteTextBoox = By.xpath("//input[@class='select2-search__field']");
			public static By prTypeDropdown = By.xpath("//*[@id=\"PRType\"]");
			public static By prSubTypeDropdown = By.xpath("//*[@id=\"PRSubType\"]");
			public static By projectSearchButton = By.xpath("//*[@id=\"ProjectModelPopUp\"]");
			public static By prNameInput = By.xpath("//*[@id=\"PRName\"]");
			public static By TEFRsearch = By.xpath("//*[@id=\"TEFRIDPopUp\"]");
			public static By consumptionDate = By.xpath("//*[@id=\"ConsumptionDate\"]");
			public static By departmentDropDown = By.xpath("//*[@id=\"DepartmentId\"]");
			public static By businessJustfication = By.xpath("//*[@id=\"BusinessJustification\"]");
			public static By saveButton = By.xpath("//*[@id=\"btnSavePR\"]");
			public static By searchItemCode = By.xpath("//*[@id=\"btnItemDialog\"]");
			public static By itemCodeInput = By.xpath("(//input[@placeholder='ItemCode'])[1]");
			public static By selectItem = By.xpath("//table[@id='gridAllItemsList']/tbody/tr/td/div/label/span");
			public static By unitPriceFeild = By.xpath("//*[@id=\"PRLines_UnitPrice\"]");
			public static By quantityField = By.xpath("//*[@id=\"PRLines_Quantity\"]");
			public static By remarksField = By.xpath("//*[@id=\"PRLines_LastPurchaseRemark\"]");
			public static By attentionInformation = By.xpath("//*[@id=\"PRLines_AttentionInformation\"]");
			public static By configuration = By.xpath("//*[@id=\"PRLines_ItemConfigurationId\"]");
			public static By ware_House = By.xpath("//*[@id=\"select2-PRLines_InventoryWareHouseId-container\"]");
			public static By inventoryDimension = By.xpath("//*[@id=\"inventoryWareHouse\"]");
			public static By warehouseDropdown = By.xpath("//*[@id=\"select2-PRLines_InventoryWareHouseId-container\"]");
			public static By warehouseDimensionTab = By.xpath("//*[@id=\"WareHouseDimission\"]");
			public static By inventoryWarehouseTab = By.xpath("//*[@id=\"inventoryWareHouse\"]");
			public static By locationDropdown = By.xpath("//*[@id=\"Inventory\"]/div/div[4]/span/span[1]/span");
			public static By financialDimensionTab = By.xpath("//*[@id=\"FinancialWareHouse\"]");
			public static By costCenterContainer = By.xpath("//*[@id=\"select2-hdnCostCenterId-container\"]");
			public static By input = By.xpath("//input[@class='select2-search__field']");
			public static By ledgerAccountContainer = By.xpath("//*[@id=\"select2-PRLines_LedgerAccountId-container\"]");
			public static By addButton = By.xpath("//*[@id=\"btnAddLine\"]");
			public static By submittButton = By.xpath("//*[@id=\"SubmitForApprove\"]");
			public static By PRnumber = By.xpath("//*[@id=\"lblPrNo\"]");
			public static By workFlowApprovalTab = By.xpath("(//span[text()='Workflow Approval'])[1]");
			public static By purchaseRequisitionApproval = By.xpath("((//span[text()='Workflow Approval'])[1]//following::span[text()='Purchase Requisition'])[1]");
			public static By PrInputField = By.xpath("//input[@placeholder='PR No']");
			public static By PrOptions = By.xpath("//table[@id='tblPendingPR']/tbody/tr/td/span/a");
			public static By approveOption = By.xpath("/html/body/div[4]/a[4]");
			public static By approveRemarks = By.xpath("//*[@id=\"txtRemark\"]");
			public static By approveSubmitt = By.xpath("//*[@id=\"btnWBSubmit\"]");
			public static By account = By.xpath("//*[@id=\"kt_header\"]/div[4]/div[3]/div[2]/div/span[3]");
			public static By signOut = By.xpath("//*[@id=\"kt_header\"]/div[4]/div[3]/div[3]/div[2]/div/a[1]");
			public static By projectInput = By.xpath("//*[@id=\"tblProjects\"]/thead/tr/th[2]/form/input");
			public static By selectProjectRadio = By.xpath("//*[@id=\"tblTEFR\"]/tbody/tr/td/input[1]");
			public static By TEFRsiteInput = By.xpath("//*[@id=\"tblTEFR\"]/thead/tr/th[5]/form/input");
			public static By TEFRinput = By.xpath("//*[@id=\"tblTEFR\"]/thead/tr/th[3]/form/input");
			
		
			
			
			
			
			
			public void wonderCementLogin() throws Exception {
				
				String user_name = webActions.getExcelData("","Header", 1, 11);
				String passcode = webActions.getExcelData("", "Header", 1, 12);
				String approverUserName = webActions.getExcelData("", "Header", 1, 13);
				String approverPassword = webActions.getExcelData("", "Header", 1, 14);
				webActions.sendKeys(username, user_name);
				webActions.sendKeys(password, passcode);
				webActions.Click(loginButton, "Login to WC");
			}
			
			
			
			
			public String createPRheader() throws Exception {
				
				Thread.sleep(3000);
				webActions.Click(purchaseRequistionTab, "purchse requisition tab");
				webActions.Click(purchaseRequisitionSubTab, "purchase requistion sub tab");
				webActions.Click(addPrButton, "click on add PR");
				
			
				
				int rowCountOfHeaders = webActions.getAvailableRowCount("", "Header");
				
				for(int i=1;i<rowCountOfHeaders;i++) {
					
					
					String site = webActions.getExcelData("", "Header", i, 0);
					String prType = webActions.getExcelData("", "Header", i, 1);
					String prSubType = webActions.getExcelData("", "Header", i, 2);
					String prName = webActions.getExcelData("","Header", i, 3);
					String TEFR = webActions.getExcelData("","Header", i, 4);
					String projectID = webActions.getExcelData("","Header", i, 5);
					String consumption_date = webActions.getExcelData("","Header", i, 6);
					String department = webActions.getExcelData("","Header", i, 7);
					String justification = webActions.getExcelData("","Header", i, 8);
					String workOrderNumber = webActions.getExcelData("","Header", i, 10);
					
					
					if(i>1) {
						wonderCementLogin();
						
						webActions.Click(purchaseRequistionTab, "purchse requisition tab");
						webActions.Click(purchaseRequisitionSubTab, "purchase requistion sub tab");
						webActions.Click(addPrButton, "click on add PR");
						
					}
					
					webActions.Click(siteContainer, "click on site container");
					webActions.sendKeys(siteTextBoox, site);
					Thread.sleep(1000);
		    		robot = new Robot();
		    		robot.delay(1000);
		    		robot.keyPress(KeyEvent.VK_ENTER);
		    		robot.keyRelease(KeyEvent.VK_ENTER);
					webActions.selectByVisibleText(prTypeDropdown, prType);
					webActions.selectByVisibleText(prSubTypeDropdown, prSubType);
					
					if(prSubType.equals("Project")) {
						
						webActions.Click(projectSearchButton, "click on project ID search");
						webActions.clearAndSendKeys(projectInput, projectID);
						robot = new Robot();
			    		robot.delay(1000);
			    		Thread.sleep(3000);
			    		robot.keyPress(KeyEvent.VK_ENTER);
			    		robot.keyRelease(KeyEvent.VK_ENTER);
			    		Thread.sleep(4000);
			    		webActions.Click(By.xpath("(//*[text()='"+projectID+"']/ancestor::tr/td/input)[1]"), "select the project ID");
			    		Thread.sleep(2000);
			    		if(prType.equals("Project Supply")) {
			    			Thread.sleep(2000);
			    			webActions.Click(TEFRsearch, "click on TEFR search");
			    			Thread.sleep(2000);
				    		webActions.clearAndSendKeys(TEFRinput, TEFR);
				    		Thread.sleep(2000);
				    		webActions.clearAndSendKeys(TEFRsiteInput, site);
				    		Thread.sleep(3000);
				    		robot.keyPress(KeyEvent.VK_ENTER);
				    		robot.keyRelease(KeyEvent.VK_ENTER);
				    		Thread.sleep(3000);
				    		webActions.Click(By.xpath("(//*[text()='"+TEFR+"']/ancestor::tr/td/input)[1]"),"select TEFR");
			    		}
			    	
			    		
					}
					Thread.sleep(3000);
					webActions.sendKeys(prNameInput, prName);
					WebElement ele = DriverFactory.getInstance().getWebDriver().findElement(consumptionDate);
					JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
					javascriptExecutor.executeScript("arguments[0].value=' " + consumption_date + "' ", ele);
					WebElement es1 = DriverFactory.getInstance().getWebDriver()
							.findElement(departmentDropDown);
					Actions s = new Actions(DriverFactory.getInstance().getWebDriver());
					s.moveToElement(es1).click().perform();
					DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//*[contains(text(),'" + department + "')]")).click();
					
					webActions.sendKeys(businessJustfication, justification);
					webActions.Click(saveButton, "click on save");
					Thread.sleep(4000);
					pr_number = webActions.getElmText(PRnumber);
					
					
                    String prtype = webActions.getExcelData("", "Header",i, 1);
                    String prsubtype = webActions.getExcelData("","Header", i, 2);
					
					System.out.println("name is "+ prtype);
					
					if(prtype.equals("Revenue Service") || prtype.equals("Capital Service") || (prtype.equals("Project Service") && !prsubtype.equals("Project"))) {
			
						addServiceLines();
						wonderCementLogin();
						approvePR();
						wonderCementLogin();
						PoWorkflow po = new PoWorkflow();
//						po.POcreation(pr_number);
//						po.addPoServiceLines();
						wonderCementLogin();
						po.approvePO();
						
					}
					else if(prtype.equals("Revenue Supply") || (prtype.equals("Capital Supply") && !prsubtype.equals("Project")) || (prtype.equals("Project Supply") && !prsubtype.equals("Project"))) {
						addSupplyLines();
						wonderCementLogin();
						approvePR();
						wonderCementLogin();
						PoWorkflow po = new PoWorkflow();
//						po.POcreation(pr_number);
//						po.addPoSupplyLines();
						wonderCementLogin();
						po.approvePO();
						
					}
					else if((prtype.equals("Project Service")) && (prsubtype.equals("Project")) ){
					    
						addProjectLines();
						wonderCementLogin();
						approvePR();
						wonderCementLogin();
						PoWorkflow po = new PoWorkflow();
//						po.POcreation(pr_number);
//						po.addPoProjectLines();
						wonderCementLogin();
						po.approvePO();
						
					}else if((prtype.equals("Project Supply") && (prsubtype.equals("Project"))) || (prtype.equals("Capital Supply") && prsubtype.equals("Project"))) {
						
						addCapitalSupplyLines();
						wonderCementLogin();
						approvePR();
						wonderCementLogin();
						PoWorkflow po = new PoWorkflow();
//						po.POcreation(pr_number);
//						po.addPoProjectLines();
						wonderCementLogin();
						po.approvePO();
						
					}else {
						
						System.out.println("PR type or sub type is incorrect......");
					}
					
					
				}
				return pr_number;
				
			
			}
			
			public void addProjectLines() throws Exception {
//				
//				String prQuantity =  webActions.getExcelData("ProjectLine", 1, 1);
//				String prUnitPrice = webActions.getExcelData("ProjectLine", 1, 2);
//				String item_code = webActions.getExcelData("ProjectLine",1, 3);
//				String configurationValue = webActions.getExcelData("ProjectLine", 1, 4);
//				String wareHouse = webActions.getExcelData("ProjectLine", 1, 5);
//				String location = webActions.getExcelData("ProjectLine", 1, 6);
//				String ledger_account = webActions.getExcelData("ProjectLine", 1, 7);
//				String cost_center = webActions.getExcelData("ProjectLine", 1, 8);
//				String net_amount = webActions.getExcelData("ProjectLine", 1, 9);
//				String delivery_name = webActions.getExcelData("ProjectLine", 1, 11);
//				String attention_information = webActions.getExcelData("ProjectLine", 1, 12);
//				String remarks_line = webActions.getExcelData("ProjectLine", 1, 13);
//				String no_of_manpower = webActions.getExcelData("ProjectLine", 1, 14);
//				String GLA = webActions.getExcelData("ProjectLine", 1, 15);
				
//				WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
//				webActions.Click(searchItemCode, "click on item code search");
//				webActions.sendKeys(itemCodeInput, item_code);
//				robot = new Robot();
//	    		robot.delay(1000);
//	    		robot.keyPress(KeyEvent.VK_ENTER);
//	    		robot.keyRelease(KeyEvent.VK_ENTER);
//	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]")));
//	    		webActions.Click(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]"), "select item code");
//			
//				webActions.clearAndSendKeys(unitPriceFeild, prUnitPrice);
//				webActions.sendKeys(quantityField, prQuantity);
//				webActions.sendKeys(remarksField, remarks_line);
//				webActions.sendKeys(attentionInformation, attention_information);
//				webActions.selectByVisibleText(configuration, configurationValue);
//				
//				webActions.Click(financialDimensionTab, "click on warehouse dimension tab");
//				webActions.Click(costCenterContainer, "click on cost center container");
//				webActions.sendKeys(input, cost_center);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
//				webActions.Click(ledgerAccountContainer, "click on ledger account container");
//				webActions.sendKeys(input, "1010101020");
//				robot.keyPress(KeyEvent.VK_ENTER);
//	    		robot.keyRelease(KeyEvent.VK_ENTER);
	    		webActions.Click(addButton, "click on add button");
	    		Thread.sleep(6000);
	    		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	    	      js.executeScript("window.scrollBy(0,-3500)");
	    		WebElement elem = DriverFactory.getInstance().getWebDriver().findElement(submittButton);
	    		wait.until(ExpectedConditions.elementToBeClickable(elem));
	    		webActions.Click(submittButton, "click on submit");
	    		Thread.sleep(5000);
	    		webActions.ClickJSE(account, "click on account");
	    		Thread.sleep(3000);
	    		webActions.ClickJSE(signOut, "sign out of the account");
	    		
				
			}
			
			
			public void addServiceLines() throws Exception {
				
				System.out.println("service lines are adding..........");
				
//				int row_count = webActions.getAvailableRowCount("ServiceLine");
//				System.out.println("row count is........." + row_count);
//				for(int i=1;i<row_count;i++) {
//					
//				
//				String prQuantity =  webActions.getExcelData("ServiceLine", i, 1);
//				String prUnitPrice = webActions.getExcelData("ServiceLine", i, 2);
//				String item_code = webActions.getExcelData("ServiceLine",i, 3);
//				String configurationValue = webActions.getExcelData("ServiceLine", i, 4);
//				String wareHouse = webActions.getExcelData("ServiceLine", i, 5);
//				String location = webActions.getExcelData("ServiceLine", i, 6);
//				String ledger_account = webActions.getExcelData("ServiceLine", i, 7);
//				String cost_center = webActions.getExcelData("ServiceLine", i, 8);
//				String net_amount = webActions.getExcelData("ServiceLine", i, 9);
//				String delivery_name = webActions.getExcelData("ServiceLine", i, 11);
//				String attention_information = webActions.getExcelData("ServiceLine", i, 12);
//				String remarks_line = webActions.getExcelData("ServiceLine", i, 13);
//				String no_of_manpower = webActions.getExcelData("ServiceLine", i, 14);
//				String GLA = webActions.getExcelData("ServiceLine", i, 15);
				
				JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	    	      js1.executeScript("window.scrollBy(0,-1500)");
				
				wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
				wait.until(ExpectedConditions.elementToBeClickable(searchItemCode));
//				webActions.Click(searchItemCode, "click on item code search");
//				webActions.clearAndSendKeys(itemCodeInput, item_code);
//				robot = new Robot();
//	    		robot.delay(1000);
//	    		Thread.sleep(2000);
//	    		robot.keyPress(KeyEvent.VK_ENTER);
//	    		robot.keyRelease(KeyEvent.VK_ENTER);
//	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]")));
//	    		webActions.Click(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]"), "select item code");
//				Thread.sleep(2000);
//				webActions.clearAndSendKeys(unitPriceFeild, prUnitPrice);
//				webActions.sendKeys(quantityField, prQuantity);
//				
//				webActions.sendKeys(remarksField, remarks_line);
//				webActions.sendKeys(attentionInformation, attention_information);
//				
//				if(i>1) {
//					webActions.Click(inventoryDimension, "click on inventory dimension");
//				}
//				
//				webActions.selectByVisibleText(configuration, configurationValue);
//				webActions.Click(ware_House, "click on warehouse");
//				webActions.sendKeys(input, wareHouse);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_ENTER);
				webActions.Click(financialDimensionTab, "click on warehouse dimension tab");
				webActions.Click(costCenterContainer, "click on cost center container");
//				webActions.sendKeys(input, cost_center);
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(2000);
				
				wait.until(ExpectedConditions.elementToBeClickable(ledgerAccountContainer));
				webActions.Click(ledgerAccountContainer, "click on ledger account container");
//				webActions.sendKeys(input, ledger_account);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
	    		robot.keyRelease(KeyEvent.VK_ENTER);
	    		Thread.sleep(2000);
	    		webActions.Click(addButton, "click on add button");
	    		Thread.sleep(6000);
	    		
				}
	    		
//	    		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
//	    	      js.executeScript("window.scrollBy(0,-3500)");
//	    		WebElement elem = DriverFactory.getInstance().getWebDriver().findElement(submittButton);
//	    		wait.until(ExpectedConditions.elementToBeClickable(elem));
//	    		webActions.Click(submittButton, "click on submit");
//	    		Thread.sleep(5000);
//	    		webActions.ClickJSE(account, "click on account");
////	    	
//	    		Thread.sleep(3000);
//	    		webActions.ClickJSE(signOut, "sign out of the account");
//	    		
				
				
//			}
			
			public void addSupplyLines() throws Exception {
				
				System.out.println("adding supply lines..........");
					
					int row_count = webActions.getAvailableRowCount("","SupplyLine");
					
					System.out.println("row count is........." + row_count);
					for(int i=1;i<row_count;i++) {
						
//					
//					String prQuantity =  webActions.getExcelData("", "SupplyLine", i, 1);
//					String prUnitPrice = webActions.getExcelData("", "SupplyLine", i, 2);
//					String item_code = webActions.getExcelData("", "SupplyLine",i, 3);
//					String configurationValue = webActions.getExcelData("", "SupplyLine", i, 4);
//					String wareHouse = webActions.getExcelData("", "SupplyLine", i, 5);
//					String location = webActions.getExcelData("", "SupplyLine", i, 6);
//					String ledger_account = webActions.getExcelData("SupplyLine", i, 7);
//					String cost_center = webActions.getExcelData("SupplyLine", i, 8);
//					String net_amount = webActions.getExcelData("SupplyLine", i, 9);
//					String delivery_name = webActions.getExcelData("SupplyLine", i, 11);
//					String attention_information = webActions.getExcelData("SupplyLine", i, 12);
//					String remarks_line = webActions.getExcelData("SupplyLine", i, 13);
//					String no_of_manpower = webActions.getExcelData("SupplyLine", i, 14);
//					String GLA = webActions.getExcelData("SupplyLine", i, 15);
//					
					JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		    	      js1.executeScript("window.scrollBy(0,-1500)");
					
					wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
					wait.until(ExpectedConditions.elementToBeClickable(searchItemCode));
					webActions.Click(searchItemCode, "click on item code search");
//					webActions.clearAndSendKeys(itemCodeInput, item_code);
//					robot = new Robot();
//		    		robot.delay(1000);
//		    		robot.keyPress(KeyEvent.VK_ENTER);
//		    		robot.keyRelease(KeyEvent.VK_ENTER);
//		    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]")));
//		    		webActions.Click(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]"), "select item code");
//					Thread.sleep(2000);
//					webActions.clearAndSendKeys(unitPriceFeild, prUnitPrice);
//					webActions.sendKeys(quantityField, prQuantity);
//					
//					webActions.sendKeys(remarksField, remarks_line);
//					webActions.sendKeys(attentionInformation, attention_information);
//					
//					if(i>1) {
//						webActions.Click(inventoryDimension, "click on inventory dimension");
//					}
//					
//					webActions.selectByVisibleText(configuration, configurationValue);
//					webActions.Click(ware_House, "click on warehouse");
//					webActions.sendKeys(input, wareHouse);
//					Thread.sleep(2000);
//					robot.keyPress(KeyEvent.VK_DOWN);
//					robot.keyPress(KeyEvent.VK_ENTER);
//					robot.keyRelease(KeyEvent.VK_DOWN);
//					robot.keyRelease(KeyEvent.VK_ENTER);
//					webActions.Click(financialDimensionTab, "click on warehouse dimension tab");
//					webActions.Click(costCenterContainer, "click on cost center container");
//					webActions.sendKeys(input, cost_center);
//					Thread.sleep(2000);
					robot.keyPress(KeyEvent.VK_DOWN);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_DOWN);
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(2000);
		    		webActions.Click(addButton, "click on add button");
		    		Thread.sleep(3000);
		    		
					}
		    		
		    		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		    	      js.executeScript("window.scrollBy(0,-3500)");
		    		WebElement elem = DriverFactory.getInstance().getWebDriver().findElement(submittButton);
		    		wait.until(ExpectedConditions.elementToBeClickable(elem));
		    		webActions.Click(submittButton, "click on submit");
		    		Thread.sleep(5000);
		    		webActions.ClickJSE(account, "Click on user account");
		    		Thread.sleep(3000);
		    		webActions.ClickJSE(signOut, "sign out of the account");
		    		
				
			}
			
			
			public void addCapitalSupplyLines() throws Exception {
				
				System.out.println("adding Capitalsupply lines..........");
				
//				int row_count = webActions.getAvailableRowCount("CapitalSupplyProjectLine");
//				
//				System.out.println("row count is........." + row_count);
//				
//				for(int i=1;i<row_count;i++) {
//					
//				String prQuantity =  webActions.getExcelData("CapitalSupplyProjectLine", i, 1);
//				String prUnitPrice = webActions.getExcelData("CapitalSupplyProjectLine", i, 2);
//				String item_code = webActions.getExcelData("CapitalSupplyProjectLine",i, 3);
//				String configurationValue = webActions.getExcelData("CapitalSupplyProjectLine", i, 4);
//				String wareHouse = webActions.getExcelData("CapitalSupplyProjectLine", i, 5);
//				String location = webActions.getExcelData("CapitalSupplyProjectLine", i, 6);
//				String ledger_account = webActions.getExcelData("CapitalSupplyProjectLine", i, 7);
//				String cost_center = webActions.getExcelData("CapitalSupplyProjectLine", i, 8);
//				String net_amount = webActions.getExcelData("CapitalSupplyProjectLine", i, 9);
//				String delivery_name = webActions.getExcelData("CapitalSupplyProjectLine", i, 11);
//				String attention_information = webActions.getExcelData("CapitalSupplyProjectLine", i, 12);
//				String remarks_line = webActions.getExcelData("CapitalSupplyProjectLine", i, 13);
//				String no_of_manpower = webActions.getExcelData("CapitalSupplyProjectLine", i, 14);
//				String GLA = webActions.getExcelData("CapitalSupplyProjectLine", i, 15);
				
				WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
				webActions.Click(searchItemCode, "click on item code search");
//				webActions.clearAndSendKeys(itemCodeInput, item_code);
//				robot = new Robot();
//	    		robot.delay(1000);
//	    		robot.keyPress(KeyEvent.VK_ENTER);
//	    		robot.keyRelease(KeyEvent.VK_ENTER);
//	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]")));
//	    		webActions.Click(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]"), "select item code");
//			
//				webActions.clearAndSendKeys(unitPriceFeild, prUnitPrice);
//				webActions.sendKeys(quantityField, prQuantity);
//				webActions.sendKeys(remarksField, remarks_line);
//				webActions.sendKeys(attentionInformation, attention_information);
////				
//				if(i>1) {
//					webActions.Click(inventoryDimension, "click on inventory dimension");
//				}
//				
//				if(item_code.equals("80400139")) {
//					webActions.selectByVisibleText(configuration, "FLENDER");
//				}
//				webActions.selectByVisibleText(configuration, configurationValue);
//				
//				webActions.Click(warehouseDropdown, "warehouse");
//				webActions.clearAndSendKeys(input, wareHouse);
//				Thread.sleep(2000);
//				robot.keyPress(KeyEvent.VK_ENTER);
//				robot.keyRelease(KeyEvent.VK_ENTER);
//				webActions.Click(locationDropdown, location);
//				Thread.sleep(2000);
//				robot.keyPress(KeyEvent.VK_DOWN);
//				robot.keyPress(KeyEvent.VK_ENTER);
//				robot.keyRelease(KeyEvent.VK_DOWN);
//				robot.keyRelease(KeyEvent.VK_ENTER);
//				webActions.Click(financialDimensionTab, "click on financial dimension tab");
//				webActions.Click(costCenterContainer, "click on cost center container");
//				webActions.sendKeys(input, cost_center);
//				robot.keyPress(KeyEvent.VK_DOWN);
//				robot.keyPress(KeyEvent.VK_ENTER);
//				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
	    		webActions.Click(addButton, "click on add button");
	    		Thread.sleep(4000);
	    		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	    	      js.executeScript("window.scrollBy(0,-1000)");
				}
//				
//	    		JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
//	    	      js1.executeScript("window.scrollBy(0,-3500)");
//	    	      Thread.sleep(6000);
//	    		WebElement elem = DriverFactory.getInstance().getWebDriver().findElement(submittButton);
//	    
////	    		wait.until(ExpectedConditions.elementToBeClickable(elem));
//	    		webActions.Click(submittButton, "click on submit");
//	    		Thread.sleep(5000);
//	    		webActions.ClickJSE(account, "Click on user account");
//	    		Thread.sleep(3000);
//	    		webActions.ClickJSE(signOut, "sign out of the account");
//	    		
//			}
			
			
			public void approvePR() throws Exception {
				
				JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	    	      js1.executeScript("window.scrollBy(0,-1000)");
				Thread.sleep(2000);
				webActions.Click(workFlowApprovalTab, "click on workflow approval tab");
				webActions.Click(purchaseRequisitionApproval, "Click on purchase requisition");
				Thread.sleep(4000);
				webActions.sendKeys(PrInputField, pr_number);
				robot = new Robot();
	    		robot.delay(1000);
	    		Thread.sleep(3000);
	    		robot.keyPress(KeyEvent.VK_ENTER);
	    		robot.keyRelease(KeyEvent.VK_ENTER);
	    		Thread.sleep(3000);
	    		webActions.Click(PrOptions, "click on PR options");
	    		Thread.sleep(2000);
	    		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
	    		wait.until(ExpectedConditions.elementToBeClickable(approveOption));
	    		webActions.Click(approveOption, "Click on approve");
	    		webActions.sendKeys(approveRemarks, "remarks");
	    		webActions.Click(approveSubmitt, "click on submitt");
	    		Thread.sleep(5000);
	    		webActions.ClickJSE(account, "Click on user account");
	    		Thread.sleep(3000);
	    		webActions.ClickJSE(signOut, "sign out of the account");
	    		
			}
			
			
			

}
