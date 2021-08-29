package com.teachopia.pagerepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HamburgerMenuWindow
{
	public HamburgerMenuWindow(AppiumDriver<?> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='My Dashboard']")
	public WebElement MyDashboard;
	
	@FindBy(xpath="//android.widget.TextView[@text='My Profile']")
	public WebElement MyProfile;
	
	@FindBy(xpath="//android.widget.TextView[@text='Settings']")
	public WebElement Settings;
	
	@FindBy(xpath="//android.widget.TextView[@text='Refer a Friend']")
	public WebElement ReferaFriend;
	
	@FindBy(xpath="//android.widget.TextView[@text='Contact Us']")
	public WebElement ContactUsSignUpButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='About Us']")
	public WebElement AboutUs;
	
	@FindBy(xpath="//android.widget.TextView[@text='Logout']")
	public WebElement LogoutButton;
	
	
}