package com.Easy_Purse.S_S.GenericUtility;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner_implementation implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	public void onStart(ISuite suite) {

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test suite Reults");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	public void onFinish(ISuite suite) {

		System.out.println("Report Backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {

		System.out.println("========>" + result.getMethod().getMethodName() + ">====START=====");
		test = report.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "====>started<=====");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("========>" + result.getMethod().getMethodName() + ">=====END====");
		extenttest.get().log(Status.PASS, result.getMethod().getMethodName() + "==>completed<===");
	}

	public void onTestFailure(ITestResult result) {

		String testname = result.getMethod().getMethodName();
		TakesScreenshot edriver = (TakesScreenshot) BaseClass.sdriver;
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		File dest = new File("./Screenshot/" + testname + "+" + time + ".png");
		test.addScreenCaptureFromBase64String(filepath, testname + " " + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "====>fail<====");
		test.log(Status.FAIL, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Report Backup");
		report.flush();

	}

}
