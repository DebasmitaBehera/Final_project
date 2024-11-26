package com.Easy_Purse.S_S.GenericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	FileUtility fLib = new FileUtility();
	DataBaseUtility DbLib = new DataBaseUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	public WebDriver driver = null;

	public static WebDriver sdriver = null;

	public ExtentSparkReporter spark;
	public ExtentReports report;

	@BeforeSuite(alwaysRun = true)

	public void configBS() throws SQLException {
		System.out.println(" connect to DB");
		DbLib.getDBConnection();
	}

	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(@Optional("chrome") String browser) throws Throwable {

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		sdriver = driver;

		System.out.println("Launch the browser");
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		wLib.Closewindow(driver);

		System.out.println("Close the browser");

	}

	@AfterSuite(alwaysRun = true)
	public void configAS() {

		try {
			DbLib.closeDBConnection();
			System.out.println(" Close DB,Report Backup....");

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(" Disconnect to DB");
	}

}
