package com.teachopia.genericlib;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Utility 
{
	public static void takeScreenshot(AndroidDriver<?> driver,ITestResult result)
	{
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname);
		Date d = new Date();
		String[] dary = d.toString().split(" ");
		String date= dary[2];
		String Mon = dary[1];
		String year = dary[5];
		String time = dary[3];
		String t = time.replace(":", "-");
		
		TakesScreenshot img = (TakesScreenshot)Base.staticdriver;
		File src = img.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+methodname+"_"+date+"_"+Mon+"_"+year+"_"+t+".PNG");
		System.out.println("Screenshot taken");
		try 
		{
			FileHandler.copy(src, dest);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void mouseAction(AndroidDriver<?> driver, WebElement ele) throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(5000);
	}

	public static void dropDown(AndroidElement ele, String value)
	{
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}
	
	public static void dropDownByText(AndroidElement ele, String text)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	public void verify(String actual, String expected)
	{
		SoftAssert s = new SoftAssert();
		s.assertEquals(actual, expected);
		s.assertAll();
	}
	
}
