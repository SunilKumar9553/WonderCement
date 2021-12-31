package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.WiniumDriver;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static DriverFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	ThreadLocal<AppiumDriver<WebElement>> appiumDriver = new ThreadLocal<AppiumDriver<WebElement>>();
	ThreadLocal<WiniumDriver> windowDriver = new ThreadLocal<WiniumDriver>();

	private DriverFactory() {

	}

	public static DriverFactory getInstance() {
		if (instance == null) {
			instance = new DriverFactory();
		}
		return instance;
	}

	public final void setWebDriver(String browser) throws Exception {

		DesiredCapabilities caps = null;

		switch (browser) {

		case "Chrome":
			caps = DesiredCapabilities.chrome();
			ChromeOptions chOptions = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("credentials_enable_service", false);
			chOptions.setExperimentalOption("prefs", chromePrefs);
			chOptions.addArguments("--disable-plugins", "--disable-extensions", "--disable-popup-blocking");
			caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
			caps.setCapability("applicationCacheEnabled", false);
			WebDriverManager.chromedriver().setup();
			webDriver.set(new ChromeDriver());
			getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getWebDriver().manage().window().maximize();

			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver.set(new FirefoxDriver());
			getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getWebDriver().manage().window().maximize();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			webDriver.set(new EdgeDriver());
			getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getWebDriver().manage().window().maximize();
			break;

		case "IE":
			WebDriverManager.iedriver().setup();
			webDriver.set(new InternetExplorerDriver());
			getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getWebDriver().manage().window().maximize();
			break;

		}

	}

	public WebDriver getWebDriver() {
		return webDriver.get();
	}

	public AppiumDriver<WebElement> getMobileDriver() {
		return appiumDriver.get();
	}

	public WiniumDriver getWindowDriver() {
		return windowDriver.get();
	}
}