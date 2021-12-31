package WcTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WcWebPages.InvoiceProcess;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class InvoiceTest {
	
	@Test(description = "Invoice creation", groups = { "smoke", "regression",
	"Web Application" })
	public void createInvoices() throws Exception {
		
		InvoiceProcess invoice = new InvoiceProcess();
		invoice.loginToPaperless();
		invoice.createSupplyInvoice("102PO2203873","102PO2203873311");
		
	}

}
