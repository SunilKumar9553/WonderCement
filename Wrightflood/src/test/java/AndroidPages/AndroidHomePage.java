package AndroidPages;

import org.openqa.selenium.By;

import AppiumUtils.MobileActions;
import AppiumUtils.Swipe;
import Utilities.DriverFactory;
import Utilities.ReportManager;
import io.appium.java_client.MobileBy;

public class AndroidHomePage {

	// ================Login========================
	By Allow = By.id("android:id/button1");
	By locationAllow = By.id("com.android.packageinstaller:id/permission_allow_button");
	By next = By.id("com.evamall.evacustomer:id/next");
	By phone_Email = By.id("com.evamall.evacustomer:id/edtPhoneEmail");
	By getOtp = By.id("com.evamall.evacustomer:id/txvGetOtp");
	By otpView1 = By.id("com.evamall.evacustomer:id/otpView1");
	By otpView2 = By.id("com.evamall.evacustomer:id/otpView2");
	By otpView3 = By.id("com.evamall.evacustomer:id/otpView3");
	By otpView4 = By.id("com.evamall.evacustomer:id/otpView4");
	By submit = By.id("com.evamall.evacustomer:id/txvSubmit");

	// ================Login========================
	By userId = By.id("mobileNo");
	By password = By.id("et_password");
	By login_Button = By.id("btn_mlogin");
	By existingUser_login = By.id("btn_mlogin");

	MobileActions mobileActions = new MobileActions();

	public void Login() throws InterruptedException {
		ReportManager.logInfo("Test started login");
		mobileActions.Click(Allow, "Location and Camera Permission");
		//mobileActions.Click(locationAllow, "Location Permission");
		mobileActions.Click(next, "Next");
		mobileActions.Click(next, "Next");
		mobileActions.Click(next, "Next");
		mobileActions.Click(next, "Next");
		mobileActions.Click(next, "Next");
		mobileActions.sendKeys(phone_Email, "9948101074");
		mobileActions.Click(getOtp, "Get OTP");
		mobileActions.sendKeys(otpView1, "8");
		mobileActions.sendKeys(otpView2, "0");
		mobileActions.sendKeys(otpView3, "5");
		mobileActions.sendKeys(otpView4, "5");
		mobileActions.Click(submit, "Submit");
		Thread.sleep(2000);

	}

	public void invalidLogin() throws InterruptedException {
		//allowAppPermission();
		mobileActions.Click(existingUser_login, "Existing User");
		mobileActions.clearAndSendKeys(userId, "rajeshbuddha@gmail.com");
		mobileActions.sendKeys(password, "Anasurya1@");
		mobileActions.Click(login_Button, "Login Button");
		mobileActions.Click(By.xpath("//android.widget.ImageButton[@index='0']"),"Open Drawer");
		
		
		/*mobileActions.swipeUp(5);
		
		mobileActions.swipeLefttoRight(5);
		
		mobileActions.swipeRighttoLeft(5);
		
		mobileActions.swipeDown(5);*/
		/*
		
		Thread.sleep(5000);
		mobileActions.swipeDown(10);
		mobileActions.swipeUp(10);*/
		/*mobileActions.Click(By.xpath("//android.widget.ImageButton[@index='0']"),"Open Drawer");
		mobileActions.swipeRighttoLeft(5);*/
		/*String elmText =
		 mobileActions.getText(By.id("com.flipkart.android:id/pageLevelError"));
		 Assert.assertTrue(elmText.equalsIgnoreCase("Account does not exist"));*/
		 //return new LoginPage(driver);
	}

	/*public void allowAppPermission() {

		try {
			Thread.sleep(5000);
			if (DriverFactory.getInstance().getMobileDriver()
					.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][1]")).isDisplayed()) {
				DriverFactory.getInstance().getMobileDriver()
						.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][1]")).click();
			} else {
				System.out.println("pop-up not displyed");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}*/

}
