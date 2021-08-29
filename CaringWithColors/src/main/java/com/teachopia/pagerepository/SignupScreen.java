package com.teachopia.pagerepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignupScreen
{
	public SignupScreen(AppiumDriver<?> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter Full Name']")
	public WebElement NameTextfield;
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter Mobile Number']")
	public WebElement NumberTextfield;
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter Password']")
	public WebElement EnterPassword;
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter Confirm Password']")
	public WebElement ConfirmPassword;
	
	@FindBy(className="//[android.view.ViewGroup]")
	public List<WebElement> TandCcheckbox;
	
	
}