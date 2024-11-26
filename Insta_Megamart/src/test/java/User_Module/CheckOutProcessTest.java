package User_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Easy_Purse.S_S.GenericUtility.BaseClass;
import com.Easy_Purse.S_S.GenericUtility.ExcelUtility;
import com.Easy_Purse.S_S.GenericUtility.FileUtility;
import com.Easy_Purse.S_S.GenericUtility.JavaUtility;
import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;
import com.Easy_Purse.S_S.ObjectRepository.CheckOutProcessPage;
import com.Easy_Purse.S_S.ObjectRepository.UserLoginPage;

public class CheckOutProcessTest extends BaseClass {

	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	@Test

	public void CheckOutProcess() throws Throwable {
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		UserLoginPage userlogin = new UserLoginPage(driver);
		userlogin.UserLogin(URL, USERNAME, PASSWORD);
		CheckOutProcessPage check = new CheckOutProcessPage(driver);
		String ProductName = eLib.getDataFromExcel("Verifywishlist", 2, 1);
		check.SelectProduct(ProductName);
		System.out.println(ProductName);
		WebElement addBtn = driver.findElement(By.xpath("//a[text()='" + ProductName
				+ "']/parent::h3/parent::div/following-sibling::div//button[text()='Add to cart']"));
		wLib.javascriptexecutor(driver, addBtn);
		driver.switchTo().alert().accept();
		check.checkout(ProductName, ProductName, ProductName, ProductName, URL, USERNAME, PASSWORD, ProductName);
		check.SelectProduct(ProductName);
		String actresult = driver.findElement(By.xpath("//a[text()='Samsung Galaxy S24 5G AI Smartphone']")).getText();
		System.out.println(actresult);
		String ExptResult = "Samsung Galaxy S24 5G AI Smartphone";
		Assert.assertTrue(actresult.contains(ExptResult));
	}
}
