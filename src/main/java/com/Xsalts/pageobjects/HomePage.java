package com.Xsalts.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Xsalts.base.BaseTest;

public class HomePage extends BaseTest
{
	//public WebDriver driver;
	@FindBy(xpath="//div/h1[text()=\"Open Capital Network\"]")
	WebElement homeText;
	
	@FindBy(xpath="//button[text()='Sign Out']")
	WebElement signOut;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;
	
	public HomePage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void isHomedisplayed() 
	{
		homeText.isDisplayed();
	}
	
	public boolean signOut() 
	{
		signOut.click();
		return signIn.isDisplayed();
	}

}

