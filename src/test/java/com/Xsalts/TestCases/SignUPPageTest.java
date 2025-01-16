package com.Xsalts.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Xsalts.Utilities.Utilities;
import com.Xsalts.base.BaseTest;
import com.Xsalts.pageobjects.CreateAccount;
import com.Xsalts.pageobjects.LoginPage;
import com.Xsalts.pageobjects.NavigationPage;

public class SignUPPageTest extends BaseTest
{
	public WebDriver driver;
	public NavigationPage navigationPage;
	public LoginPage loginPage;
	public CreateAccount account;
	public static String sheetName = "Sheet1";
	
	@DataProvider
	public Object[][] providedata() throws IOException
	{
       return Utilities.getFormData(sheetName);
    
	}
	
	@Test(description = "Verify signUp page displayed")
	public void isSignUpdisplayed() throws InterruptedException
	{
		navigationPage = new NavigationPage();
		navigationPage.clickSignin();
		Thread.sleep(3000);
		account = new CreateAccount();
		Thread.sleep(3000);
		boolean flag = account.isSignUpPagedisplayed();
		Assert.assertEquals(flag, true);
	}
	
		@Test(dataProvider = "providedata")
		public void NewSignUp(String email,String password,String confirmpassword) throws InterruptedException
		{
			navigationPage = new NavigationPage();
			navigationPage.clickSignin();
				try {
					Utilities.providedata("Sheet1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			account = new CreateAccount();
		    account.SignUp(email, password, confirmpassword);
		   
		}
		
		@Test(dataProvider = "providedata",dependsOnMethods = "NewSignUp")
		public void ExistingSignUp(String email,String password,String confirmpassword) throws InterruptedException
		{
			navigationPage = new NavigationPage();
			navigationPage.clickSignin();
				try {
					Utilities.providedata("Sheet1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			account = new CreateAccount();
		    account.SignUp(email, password, confirmpassword);
		    Thread.sleep(5000);
		    String text=driver.switchTo().alert().getText();
		    System.out.println(text);
		//    Assert.assertEquals(text, "Provided E-Mail is already in use");
		   
		}
	}


