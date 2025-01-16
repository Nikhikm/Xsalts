package com.Xsalts.Utilities;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import lombok.ToString;

public class ExtentReportManager 
{
	public static ExtentReports generateExtentReport() 
	{
		  Calendar calendar = Calendar.getInstance(); 
	    String time = Integer.toString(calendar.get(Calendar.DATE));		
		String minute = Integer.toString(calendar.get(Calendar.MINUTE));
		String second = Integer.toString(calendar.get(Calendar.SECOND));
		String hour =Integer.toString(calendar.get(Calendar.SECOND));
		
		ExtentReports report= new ExtentReports();
		File reportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentreport_"+ time+hour+minute+second +".html");
		ExtentSparkReporter spark= new ExtentSparkReporter(reportFile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Xsalts Test Report");
		spark.config().setDocumentTitle("Xsalts");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		report.attachReporter(spark);
//		Properties prop = new Properties();
//		report.setSystemInfo("Application URL", );
		//report
		return report;
	}

}

//<class name="com.Xsalts.TestCases.SignOutTest"/>
//<class name="com.Xsalts.TestCases.LoginPageTest"/>
//<class name="com.Xsalts.TestCases.LoginPageTest"/>
