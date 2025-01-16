package com.Xsalts.Listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Xsalts.Utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener
{
	ExtentReports extReport;
	ExtentTest extentTest;
	
    public void onTestStart(ITestResult result)
	{
		String testName=result.getName();
		System.out.println(testName + " started executing");
		extentTest = extReport.createTest(testName);
		extentTest.log(Status.INFO,testName + " started executing");
	}

	public void onTestSuccess(ITestResult result) 
	{
		String testName=result.getName();
		System.out.println(testName + " got passed");
		extentTest = extReport.createTest(testName);
		extentTest.log(Status.PASS,testName + "  got passed");
	}

	public void onTestFailure(ITestResult result)
	{
		String testName=result.getName();
		WebDriver driver = null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String distPath=System.getProperty("user.dir")+"\\Screenshots\\" + testName +".png";
		try {
			FileHandler.copy(file, new File(distPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(distPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL,testName + "  got failed");
		
//		System.out.println(testName + " got failure");
//		System.out.println(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) 
	{
		String testName=result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP,testName + "  got skipped");
		
		System.out.println(testName + " got skipped");
		System.out.println(result.getThrowable());
	}

	public void onStart(ITestContext context) 
	{
		System.out.println("Execution of the project started");
		extReport = ExtentReportManager.generateExtentReport();
	}

	public void onFinish(ITestContext context)
	{
		System.out.println("Project execution got finished");
		extReport.flush();

	}
	

}
