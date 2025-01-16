package com.Xsalts.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Xsalts.base.BaseTest;

public class CreateAccount extends BaseTest
{
	@FindBy(xpath="(//div/input[@type='password'])[1]")
	public WebElement password;
	
	@FindBy(xpath="//div/input[@type='text']")
	public WebElement email;

	@FindBy(xpath="(//div/input[@type='password'])[2]")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	public WebElement signUp;
	
	@FindBy(xpath="//div/button[text()='Already have an account? Click here to sign in.']")
	public WebElement signInNavigation;
	
	public CreateAccount() {
		PageFactory.initElements(driver, this);
	}
	
    public boolean isSignUpPagedisplayed() throws InterruptedException 
    {
    	Thread.sleep(4000);
    	return signInNavigation.isDisplayed();
    }
    
    public void signinNavigate()
    {
    	signInNavigation.click();
    }
	
	
	public void SignUp(String email1,String password1,String confirmpassword) throws InterruptedException
	{
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(10));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		Thread.sleep(10000);
		email.sendKeys(email1);
		//driver.findElement(By.xpath("//div/input[@type='text']")).sendKeys("nikhilkm128@gmail.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(password));
		Thread.sleep(10000);
		password.sendKeys(password1);
	//	driver.findElement(By.xpath("(//div/input[@type='password'])[1]")).sendKeys("nikhilkm128@gmail.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(confirmPassword));
		Thread.sleep(10000);
		confirmPassword.sendKeys(confirmpassword);
		signUp.click();
	//	driver.findElement(By.xpath("(//div/input[@type='password'])[2]")).sendKeys("nikhilkm128@gmail.com");
		
//		wait.until(ExpectedConditions.visibilityOf(password));
//		password.sendKeys("pass");
//		wait.until(ExpectedConditions.visibilityOf(confirmPassword));
//		confirmPassword.sendKeys("no");
		//(//div/input[@type='password'])[1]
	}
	
	

}
