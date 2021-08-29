package com.teachopia.pagerepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeScreen
{
	public WelcomeScreen(AppiumDriver<?> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text=' English  ']")
	public WebElement EnglishButton;
	
	@FindBy(xpath="//android.widget.TextView[@text=' ಕನ್ನಡ ']")
	public WebElement KannadaButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='   LOGIN   ']")
	public WebElement ELoginButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='  SIGN UP  ']")
	public WebElement ESignupButton;
	
	@FindBy(xpath="//android.widget.TextView[@text=' ಲಾಗಿನ್ ']")
	public WebElement KLoginButton;
	
	@FindBy(xpath="//android.widget.TextView[@text=' ಸೈನ್ ಅಪ್ ']")
	public WebElement KSignupButton;

	
}