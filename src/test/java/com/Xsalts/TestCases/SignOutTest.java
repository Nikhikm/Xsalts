package com.Xsalts.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import com.Xsalts.base.BaseTest;
import com.Xsalts.pageobjects.CreateAccount;
import com.Xsalts.pageobjects.HomePage;
import com.Xsalts.pageobjects.LoginPage;
import com.Xsalts.pageobjects.NavigationPage;

//@Listeners(com.Xsalts.Utilities.MyListener.class)
public class SignOutTest extends BaseTest
{

	NavigationPage navigationPage;
	 LoginPage loginPage;
	 public CreateAccount account;
	 HomePage home;
	@Test
	public void verifySignOut() throws InterruptedException
	{
		navigationPage = new NavigationPage();
		navigationPage.clickSignin();
		account = new CreateAccount();
		account.signinNavigate();
		loginPage= new LoginPage();
		loginPage.Login();
		home = new HomePage();
		home.signOut();
	}

}
