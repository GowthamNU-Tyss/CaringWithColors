package com.teachopia.genericlib;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.teachopia.pagerepository.HamburgerMenuWindow;
import com.teachopia.pagerepository.LoginScreen;
import com.teachopia.pagerepository.MyDashboardScreen;
import com.teachopia.pagerepository.WelcomeScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


@Listeners(com.teachopia.genericlib.ListenerImp.class)

public class Base 
{
	DesiredCapabilities dc = new DesiredCapabilities();
	public AndroidDriver<WebElement> dr;
	public static AndroidDriver<WebElement> staticdriver;
	
	
	@BeforeClass()
	public void installTeachopia() throws MalformedURLException
	{		
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");//SendKeys are not working in UiAutomator2
		
		File app = new File("D:\\d\\gowtham 1\\Appium\\CaringWithColors\\apk file\\base.apk");
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
				
		dr = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		staticdriver = dr;
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	
	@BeforeMethod()
	public void loginIntoTeachopia() throws InterruptedException
	{
		FileLib lib = new FileLib();
		Utility u = new Utility();
		WelcomeScreen ws = new WelcomeScreen(dr);
		LoginScreen ls = new LoginScreen(dr);
		MyDashboardScreen mds = new MyDashboardScreen(dr);
		ws.EnglishButton.click();
//		dr.navigate().back();
		ws.ELoginButton.click();
		ls.NumberTextfield.click();
		dr.hideKeyboard();
		ls.NumberTextfield.sendKeys(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("LoginSheetName"), 1, 1));
		ls.EnterPassword.sendKeys(lib.getSpecifiedDataFromExcelFile(lib.getDataFromPrpoertyFile("LoginSheetName"), 2, 1));
		ls.PasswordViewIcon2.get(2).click();
		ls.LoginButton.click();
		Thread.sleep(4000);
		
		String dashboard = mds.MyDashboard.getText();
		System.out.println(dashboard);
		u.verify("  My Dashboard  ", dashboard);
		Reporter.log("Loggedin Successfully", true);
	}
	
	@AfterMethod()
	public void logoutFromTeachopia() throws InterruptedException
	{
		Utility u = new Utility();
		MyDashboardScreen mds = new MyDashboardScreen(dr);
		LoginScreen ls = new LoginScreen(dr);
		HamburgerMenuWindow hm = new HamburgerMenuWindow(dr);
		mds.HamburgerMenu1.get(24).click();
		System.out.println("Clicked on hamburger");
		Thread.sleep(2000);
		hm.LogoutButton.click();
		Thread.sleep(4000);
		
		String login = ls.UserLogin.getText();
		u.verify("User Login", login);
		Reporter.log("Loggedout Successfully", true);
	}
	
	@AfterClass
	public void quitTeachopia()
	{
		dr.quit();
		Reporter.log("App closes successfully", true);
	}
}
