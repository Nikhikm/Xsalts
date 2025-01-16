package com.Xsalts.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Xsalts.base.BaseTest;

public class NavigationPage extends BaseTest
{
	@FindBy(xpath="//div/h1[text()=\"Open Capital Network\"]")
	WebElement homeText;
	
	@FindBy(xpath ="//button[text()='Sign In']")
	WebElement signin;
	
	@FindBy(xpath="//div/img[@class='logo']")
	WebElement logo;
	public NavigationPage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void verifyLaunch() 
	{
		Assert.assertEquals(homeText.getText(), "Open Capital Network");
	}
	
	public boolean verifySignInButton() 
	{
		return signin.isDisplayed();
	}
	
	public CreateAccount clickSignin() 
	{
		signin.click();
		//return new LoginPage();
		return new CreateAccount();
	}
	
	public boolean isLogoDisplayed() 
	{
		return logo.isDisplayed();
	}

}
