package com.Xsalts.TestCases;

import java.io.IOException;

import javax.management.DescriptorKey;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.Xsalts.ReusableElements.ResusableElements;
import com.Xsalts.Utilities.Utilities;
import com.Xsalts.base.BaseTest;
import com.Xsalts.pageobjects.CreateAccount;
import com.Xsalts.pageobjects.LoginPage;
import com.Xsalts.pageobjects.NavigationPage;


public class LoginPageTest extends BaseTest
{
	NavigationPage navigationPage;
	 LoginPage loginPage;
	 public CreateAccount account;
	public static String sheetName = "Sheet1";
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
       return Utilities.getFormData(sheetName);
    
	}
	//To verify SignIn page got displayed
	@Test()
	public void isSignInDisplayed() 
	{
		navigationPage = new NavigationPage();
		navigationPage.clickSignin();
		LoginPage loginPage = new LoginPage();
		boolean flag=loginPage.verifySignInbtn();
		Assert.assertEquals(flag, true);//check made as false
		
	}
	@Test(enabled = false)
	public void isCreateAccountDisplayed()
	{
		navigationPage = new NavigationPage();
		navigationPage.clickSignin();
	}
	
	@Test(priority = 1)
	public void SignInAccount() throws InterruptedException 
	{
		navigationPage = new NavigationPage();
		navigationPage.clickSignin();
		account = new CreateAccount();
		account.signinNavigate();
		loginPage= new LoginPage();
		loginPage.Login();
	}
	
//	@Test(dataProvider="getdata")
//	public void Login(String email,String password,String confirmpassword) throws InterruptedException
//	{
//		navigationPage = new NavigationPage();
//		navigationPage.clickSignin();
//			try {
//				Utilities.getdata("Sheet1");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//	    loginPage = new LoginPage();
//	    loginPage.Login(email,password,confirmpassword);
//	   
//	}
//	

	

}
