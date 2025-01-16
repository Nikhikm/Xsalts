 package com.Xsalts.ReusableElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Xsalts.base.BaseTest;
import com.google.common.base.Throwables;

public class ResusableElements extends BaseTest
{
	public static void populateFieldbyText(String inputText,int index) throws InterruptedException//String text,String inputText)
	{
//		String text1="E-Mail";
//		String inputText="nikhil";
//		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
//		Thread.sleep(3000);
		String xpath="(//input[@type='text'])[" + index +"]";
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(inputText);
		}
		catch (Exception e)
		{
			System.err.println(Throwables.getStackTraceAsString(e));
			System.out.println("unable to set the " + inputText + " on the field ");
		}
		
	}

}
