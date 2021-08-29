package com.teachopia.pagerepository;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyDashboardScreen
{
	public MyDashboardScreen(AppiumDriver<?> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
//	
//	@FindBy(xpath="//android.widget.EditText[@text='Enter Mobile Number']")
//	public WebElement NumberTextfield;
//	
//	@FindBy(xpath="//android.widget.EditText[@text='Enter Password']")
//	public WebElement EnterPassword;
	
	@FindBy(xpath="//android.widget.TextView[@text='  My Dashboard  ']")
	public WebElement MyDashboard;
	
	@FindBy(xpath="//android.widget.FrameLayout//android.view.ViewGroup")
	public List<WebElement> HamburgerMenu1;
	
//	/******
//	 * this is a 2nd element
//	 */
//	@FindBy(xpath="//android.widget.ScrollView//android.view.ViewGroup//android.view.ViewGroup")
//	public List<WebElement> PasswordViewIcon2;
//	
//	@FindBy(xpath="//android.widget.TextView[@text=' SIGN UP ']")
//	public WebElement SignUpButton;
//	
	
}