package AndroidTestCases;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidNativeParallelTests {
	
	By userId = By.id("mobileNo");
    By password = By.id("et_password");
    By login_Button = By.id("btn_mlogin");
    By existingUser_login = By.id("btn_mlogin");

    ThreadLocal<AndroidDriver<MobileElement>> appiumDriver = new ThreadLocal<AndroidDriver<MobileElement>>();
	@BeforeTest(alwaysRun = true)
	@Parameters({"platform", "udid", "systemPort"})
	public void setup(String platform, String udid, String systemPort) throws Exception {
	    URL url = new URL("http://0.0.0.0:4723/wd/hub");
	    String[] platformInfo = platform.split(" ");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo);
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	    capabilities.setCapability(MobileCapabilityType.UDID, udid);
	    capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
	    capabilities.setCapability(MobileCapabilityType.APP, "D:\\ProjectsNew\\IntegratedFramework\\MobileApps\\Flipkart Online Shopping App_v6.10_apkpure.com.apk");
	    capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
	    appiumDriver.set(new AndroidDriver<MobileElement>(url, capabilities));
	    getMobileDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest(alwaysRun = true)
	public void teardown() throws Exception {
	    if (getMobileDriver() != null) {
	    	getMobileDriver().quit();
	    }
	}
	
	@Test
	public void testLoginAndLogout() throws InterruptedException {
		Thread.sleep(10000);
		getMobileDriver().findElement(existingUser_login).click();
		Thread.sleep(10000);
		getMobileDriver().findElement(userId).clear();
		Thread.sleep(10000);
		getMobileDriver().findElement(userId).sendKeys("rajesh@test.com");
		Thread.sleep(10000);
		getMobileDriver().findElement(password).sendKeys("rajesh123");
		Thread.sleep(10000);
		getMobileDriver().findElement(login_Button).click();
		Thread.sleep(20000);
        Assert.assertTrue(getMobileDriver().findElement(By.id("pageLevelError")).getText().equalsIgnoreCase("Account does not exist"));
	}
	public AppiumDriver<MobileElement> getMobileDriver() {
		return appiumDriver.get();
	}
}

