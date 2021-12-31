package Utilities;

import java.net.MalformedURLException;

public class InitDriver {

	DriverFactory driverFactory = DriverFactory.getInstance();
	int port = 4723;
	
	private String str_Execution_Web = ConfigReader.getValue("Execution_Web");
	private String str_BrowserType = ConfigReader.getValue("Browser");
	//private String str_BrowserType = System.getProperty("Browser");
	private String str_MobileOSType = ConfigReader.getValue("MobileOSType");
	private String str_Execution_Mobile = ConfigReader.getValue("Execution_Mobile");
	private String str_Execution_Desktop = ConfigReader.getValue("Execution_Desktop");

	public void startWebDriver() throws Exception {
		System.out.println(str_Execution_Web);
		if (str_Execution_Web.equalsIgnoreCase("Web_Application")) {
			System.out.println("Execution started @ " + str_BrowserType + " browser & for type : " + str_Execution_Web);

			driverFactory.setWebDriver(str_BrowserType.trim());
			driverFactory.getWebDriver().get(ConfigReader.getValue("URL"));

		}

	}

		public void tearDownDesktopDriver() throws InterruptedException, MalformedURLException {

		System.out.println("Execution ended - " + str_Execution_Desktop);
		if (driverFactory.getWindowDriver() != null) {
			driverFactory.getWindowDriver().close();
		}

	}

	public void tearDownWebDriver() throws InterruptedException, MalformedURLException {
		System.out.println("Execution ended - " + str_BrowserType + " browser & for type : " + str_Execution_Web);
		if (driverFactory.getWebDriver() != null) {
			driverFactory.getWebDriver().quit();
		}

	}

	public void tearDownMobileDriver() {

		System.out.println("Execution ended - " + str_MobileOSType);
		if (driverFactory.getMobileDriver() != null) {
			driverFactory.getMobileDriver().quit();
		}

	}

}
