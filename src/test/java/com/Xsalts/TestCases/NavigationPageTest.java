 package com.Xsalts.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Xsalts.base.BaseTest;
import com.Xsalts.pageobjects.NavigationPage;

import net.bytebuddy.implementation.bind.annotation.Super;

public class NavigationPageTest extends BaseTest
{
	public static NavigationPage navigationPage;
	@Test
	public void verifyLaunch() 
	{
		navigationPage = new NavigationPage();
		navigationPage.verifyLaunch();
	}
	
	@Test
	public void getTitle() throws InterruptedException 
	{
		String title =driver.getTitle();
		Assert.assertEquals(title,"OCN Portal");
		Thread.sleep(3000);
	}
	
	@Test
	public void logo() throws InterruptedException 
	{
		navigationPage = new NavigationPage();
		Boolean flag =navigationPage.isLogoDisplayed();
		Assert.assertEquals(flag, true);
		Thread.sleep(3000);
	}
	
	@Test
	public void reLaunch() throws InterruptedException 
	{
		navigationPage.verifyLaunch();
		Thread.sleep(3000);
	}

}
