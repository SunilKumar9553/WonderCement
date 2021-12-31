package WcWebPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
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
import WebUtil.WebActions;

public class multiplePRs {
	
	Robot robot;

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;
	String index;
	
	String prType;
	String site; 
	
	WebDriverWait wait;
	// ==========================Objects==================================
			 WebActions webActions = new WebActions();

		// ==========================Locators==================================
			 public static By insuredWebSite = By.xpath("//a[@id='tydeLink']");
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
				public static By warehouseDimensionDropdown = By.xpath("//*[@id=\"select2-PRLines_WHCode-container\"]");
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
				
				
				
				public String getExcelData(String sheetName, int rowCount, int cellCount) throws Exception {
					File file = new File("C:\\Users\\Sunil\\Desktop\\serviceprs.xlsx");
					FileInputStream stream = new FileInputStream(file);
					wb = new XSSFWorkbook(stream);
					sheet = wb.getSheet(sheetName);
					DataFormatter formatter = new DataFormatter();
					String name = formatter.formatCellValue(sheet.getRow(rowCount).getCell(cellCount));
					
					return name;

				}
				
				public int getAvailableRowCount(String sheetName) throws Exception {
					
					File file = new File("C:\\Users\\Sunil\\Desktop\\serviceprs.xlsx");
					FileInputStream stream = new FileInputStream(file);
					wb = new XSSFWorkbook(stream);
					sheet = wb.getSheet(sheetName);
					int rowCount = sheet.getPhysicalNumberOfRows();
					return rowCount;

					// TODO Auto-generated method stub
					
				}
				
				public void writeData(String sheetName, int rowCount, int cellCount, String value) throws Exception {
					File file = new File("C:\\Users\\Sunil\\Desktop\\serviceprs.xlsx");
					FileInputStream stream = new FileInputStream(file);
					wb = new XSSFWorkbook(stream);
					sheet = wb.getSheet(sheetName);
					cell = sheet.getRow(rowCount).getCell(cellCount);
					if(cell == null) {
						cell = sheet.getRow(rowCount).createCell(cellCount);
					}
					cell.setCellValue(value);
					FileOutputStream fos = new FileOutputStream(file);
					wb.write(fos);
				}
				
				public void wonderCementLogin() throws Exception {
					
					String user_name = getExcelData("Header", 1, 11);
					String passcode = getExcelData("Header", 1, 12);
					String approverUserName = getExcelData("Header", 1, 13);
					String approverPassword = getExcelData("Header", 1, 14);
					webActions.sendKeys(username, user_name);
					webActions.sendKeys(password, passcode);
					webActions.Click(loginButton, "Login to WC");
				}
				

				public void createPRheader() throws Exception {
					
					Thread.sleep(3000);
					WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(),100);
					wait.until(ExpectedConditions.elementToBeClickable(purchaseRequistionTab));
					webActions.Click(purchaseRequistionTab, "purchse requisition tab");
					webActions.Click(purchaseRequisitionSubTab, "purchase requistion sub tab");
					webActions.Click(addPrButton, "click on add PR");
					
				
					
					int rowCountOfHeaders = getAvailableRowCount("Header");
					System.out.println("Header sheet row count: " + rowCountOfHeaders);
					
					for(int i=1;i<rowCountOfHeaders;i++) {
						
						
						site = getExcelData("Header", i, 0);
						prType = getExcelData("Header", i, 1);
						String prSubType = getExcelData("Header", i, 2);
						String prName = getExcelData("Header", i, 3);
						String TEFR = getExcelData("Header", i, 4);
						String projectID = getExcelData("Header", i, 5);
						String consumption_date = getExcelData("Header", i, 6);
						String department = getExcelData("Header", i, 7);
						String justification = getExcelData("Header", i, 8);
						String workOrderNumber = getExcelData("Header", i, 10);
						
						
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
				    		if(prType.contains("Project")) {
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
						String pr_number = webActions.getElmText(PRnumber);
						
						writeData("Header",i,18,pr_number);
						
						index = String.valueOf(i);
						
						
						//adding PR and PO lines
						addPRlines(index);
						wonderCementLogin();
					    approvePR(pr_number);
					    wonderCementLogin();
						PoWorkflow poflow = new PoWorkflow();
						poflow.POcreation(pr_number, index);
						
					}
				
				}
				
				
				public void addPRlines(String index) throws Exception {
					
					int prLinesRowCount = getAvailableRowCount("prline"+index);
					
					System.out.print("PR lines count is : " + prLinesRowCount);
					
					for(int i=0;i<prLinesRowCount-1;i++) {
						
						
						String prQuantity =  getExcelData("prline"+index, i+1, 0);
						String prUnitPrice = getExcelData("prline"+index, i+1, 1);
						String item_code = getExcelData("prline"+index,i+1, 2);
						String configurationValue = getExcelData("prline"+index, i+1, 3);
						String wareHouse = getExcelData("prline"+index, i+1, 4);
						String location = getExcelData("prline"+index, i+1, 5);
						String ledger_account = getExcelData("prline"+index, i+1, 6);
						String cost_center = getExcelData("prline"+index, i+1, 7);
						String net_amount = getExcelData("prline"+index, i+1, 8);
						String delivery_name = getExcelData("prline"+index, i+1, 10);
						String attention_information = getExcelData("prline"+index, i+1, 11);
						String remarks_line = getExcelData("prline"+index, i+1, 12);
						String no_of_manpower = getExcelData("prline"+index, i+1, 13);
						String GLA = getExcelData("prline"+index, i+1, 14);
						String marketWareHouse = getExcelData("prline"+index, i+1, 15);
					
						
						JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
			    	      js1.executeScript("window.scrollBy(0,-1500)");
						
						wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
						wait.until(ExpectedConditions.elementToBeClickable(searchItemCode));
						webActions.Click(searchItemCode, "click on item code search");
						webActions.clearAndSendKeys(itemCodeInput, item_code);
						robot = new Robot();
			    		robot.delay(1000);
			    		Thread.sleep(2000);
			    		robot.keyPress(KeyEvent.VK_ENTER);
			    		robot.keyRelease(KeyEvent.VK_ENTER);
			    		robot.keyPress(KeyEvent.VK_TAB);
			    		robot.keyRelease(KeyEvent.VK_TAB);
			    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]")));
			    		webActions.Click(By.xpath("//td[text()='"+item_code+"']/ancestor::tr//span[1]"), "select item code");
						Thread.sleep(2000);
						webActions.clearAndSendKeys(unitPriceFeild, prUnitPrice);
						webActions.sendKeys(quantityField, prQuantity);
						
						webActions.sendKeys(remarksField, remarks_line);
						webActions.sendKeys(attentionInformation, attention_information);
						
						if(i>0) {
							webActions.Click(inventoryDimension, "click on inventory dimension");
						}
						Thread.sleep(2000);
						webActions.selectByVisibleText(configuration, configurationValue);
						
						if(prType.contains("Service") || prType.contains("Capital Supply")) {
							webActions.Click(ware_House, "click on warehouse");
							webActions.sendKeys(input, wareHouse);
							Thread.sleep(2000);
							robot.keyPress(KeyEvent.VK_DOWN);
							robot.keyPress(KeyEvent.VK_ENTER);
							robot.keyRelease(KeyEvent.VK_DOWN);
							robot.keyRelease(KeyEvent.VK_ENTER);
							
							
						}
						
						if(prType.contains("Capital Supply")) {
							webActions.Click(locationDropdown, location);
							Thread.sleep(2000);
							webActions.clearAndSendKeys(input, location);
							Thread.sleep(2000);
							robot.keyPress(KeyEvent.VK_DOWN);
							robot.keyPress(KeyEvent.VK_ENTER);
							robot.keyRelease(KeyEvent.VK_DOWN);
							robot.keyRelease(KeyEvent.VK_ENTER);
						}
						Thread.sleep(2000);
						
						//marketing PR
						if(site.contains("104")) {
							webActions.Click(warehouseDimensionTab, "ware house dimension");
							Thread.sleep(2000);
							webActions.Click(warehouseDimensionDropdown, "warehouse dimesnion dropdown");
							Thread.sleep(2000);
							webActions.clearAndSendKeys(input, marketWareHouse);
							Thread.sleep(1000);
							robot.keyPress(KeyEvent.VK_ENTER);
							robot.keyRelease(KeyEvent.VK_ENTER);
							Thread.sleep(1000);
						}
						
						
						webActions.Click(financialDimensionTab, "click on financial dimension tab");
						Thread.sleep(1000);
						webActions.Click(costCenterContainer, "click on cost center container");
						webActions.sendKeys(input, cost_center);
						Thread.sleep(2000);
						robot.keyPress(KeyEvent.VK_DOWN);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_DOWN);
						robot.keyRelease(KeyEvent.VK_ENTER);
						
						Thread.sleep(2000);
						
						if(prType.contains("Service") && !prType.equals("Project Service")) {
							System.out.println("ledger needed for service PR");
							webActions.Click(ledgerAccountContainer, "click on ledger account container");
							webActions.sendKeys(input, ledger_account);
							Thread.sleep(1000);
							robot.keyPress(KeyEvent.VK_ENTER);
				    		robot.keyRelease(KeyEvent.VK_ENTER);
						}
						
			    		Thread.sleep(2000);
			    		webActions.Click(addButton, "click on add button");
			    		Thread.sleep(6000);
					}
					
		    		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
		    	      js.executeScript("window.scrollBy(0,-3500)");
		    		WebElement elem = DriverFactory.getInstance().getWebDriver().findElement(submittButton);
		    		wait.until(ExpectedConditions.elementToBeClickable(elem));
		    		webActions.Click(submittButton, "click on submit");
		    		Thread.sleep(8000);
		    		wait.until(ExpectedConditions.elementToBeClickable(account));
		    		webActions.ClickJSE(account, "click on account");
		    		Thread.sleep(3000);
		    		webActions.ClickJSE(signOut, "sign out of the account");
		    		
					
				}
				

				public void approvePR(String pr_number) throws Exception {
					
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
		    		Thread.sleep(8000);
		    		webActions.ClickJSE(account, "Click on user account");
		    		wait.until(ExpectedConditions.elementToBeClickable(account));
		    		Thread.sleep(3000);
		    		webActions.ClickJSE(signOut, "sign out of the account");
		    		
				}	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
}
		
				
		