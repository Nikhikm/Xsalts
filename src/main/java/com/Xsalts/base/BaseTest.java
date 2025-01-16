package com.Xsalts.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest 
{
	public static Properties prop;
	public static WebDriver driver;
	
    @BeforeTest
	public static void loadConfiguration() 
	{
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\Xsalts\\config\\config.properties");
			prop.load(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("driver"+ driver);
		
		
	}
    @BeforeMethod
	public static void launchApplication() 
	{
    	
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.contains("chrome")) 
		{
			//WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browserName.contains("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://xaltsocnportal.web.app/");
		driver.manage().window().maximize();
	}

}
