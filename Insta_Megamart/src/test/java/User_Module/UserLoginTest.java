package User_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Easy_Purse.S_S.GenericUtility.BaseClass;
import com.Easy_Purse.S_S.GenericUtility.ExcelUtility;
import com.Easy_Purse.S_S.GenericUtility.FileUtility;
import com.Easy_Purse.S_S.GenericUtility.JavaUtility;
import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;
import com.Easy_Purse.S_S.ObjectRepository.CheckOutProcessPage;
import com.Easy_Purse.S_S.ObjectRepository.UserLoginPage;
import com.Easy_Purse.S_S.ObjectRepository.VerifyWishlistPage;
@Listeners(com.Easy_Purse.S_S.GenericUtility.Listner_implementation.class)
public class UserLoginTest extends BaseClass {
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	@Test(groups = "regressionTest")
	
	public void UserLogin() throws Throwable {
		
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		UserLoginPage userlogin = new UserLoginPage(driver);
		userlogin.UserLogin(URL, USERNAME, PASSWORD);
		String ActualText = driver.findElement(By.xpath("//ul[@class='list-unstyled']/descendant::a")).getText();
		System.out.println(ActualText);
		String ExpectedText = "Welcome -Shravan";
		Assert.assertTrue(ActualText.contains(ExpectedText));
		userlogin.getLogoutLink().click();
	}

	@Test(groups =  "smokeTest")

	public void VerifyPayment() throws Throwable {
		
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		UserLoginPage userlogin = new UserLoginPage(driver);
		userlogin.UserLogin(URL, USERNAME, PASSWORD);
		String ActualText = driver.findElement(By.xpath("//ul[@class='list-unstyled']/descendant::a")).getText();
		System.out.println(ActualText);
		String ExpectedText = "Welcome -Shravan";
		Assert.assertTrue(ActualText.contains(ExpectedText));
		CheckOutProcessPage check = new CheckOutProcessPage(driver);
		String ProductName = eLib.getDataFromExcel("Verifywishlist", 2, 1);
		check.SelectProduct(ProductName);
		WebElement addBtn = driver.findElement(By.xpath("//a[text()='" + ProductName
				+ "']/parent::h3/parent::div/following-sibling::div//button[text()='Add to cart']"));
		wLib.javascriptexecutor(driver, addBtn);
		driver.switchTo().alert().accept();
		check.checkout(ProductName, ProductName, ProductName, ProductName, URL, USERNAME, PASSWORD, ProductName);
		check.searchproduct(ProductName);
		String actresult = driver.findElement(By.xpath("//a[text()='Samsung Galaxy S24 5G AI Smartphone']")).getText();
		System.out.println(actresult);
		String ExptResult = "Samsung Galaxy S24 5G AI Smartphone";
		Assert.assertTrue(actresult.contains(ExptResult));
		userlogin.getLogoutLink().click();
	}

	@Test(groups = "regressionTest")

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
		check.searchproduct(ProductName);
		String actresult = driver.findElement(By.xpath("//a[text()='Samsung Galaxy S24 5G AI Smartphone']")).getText();
		System.out.println(actresult);
		String ExptResult = "Samsung Galaxy S24 5G AI Smartphone";
		Assert.assertTrue(actresult.contains(ExptResult));
		userlogin.getLogoutLink().click();
	}

	@Test(groups =  "smokeTest")

	public void VerfifyWishlist() throws Throwable {
		
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		UserLoginPage userlogin = new UserLoginPage(driver);
		userlogin.UserLogin(URL, USERNAME, PASSWORD);
		VerifyWishlistPage wishlist = new VerifyWishlistPage(driver);
		String ProductName = eLib.getDataFromExcel("Verifywishlist", 2, 1);
		wishlist.wishlistproduct(ProductName);
		WebElement addBtn = driver.findElement(By.xpath("//a[text()='" + ProductName
				+ "']/parent::h3/parent::div/following-sibling::div//a[@title=\"Wishlist\"]"));
		wLib.javascriptexecutor(driver, addBtn);
		wishlist.SelectProduct(ProductName);
		String actresult = driver.findElement(By.xpath("//a[text()='Samsung Galaxy S24 5G AI Smartphone']")).getText();
		System.out.println(actresult);
		String ExptResult = "Samsung Galaxy S24 5G AI Smartphone";
		Assert.assertTrue(actresult.contains(ExptResult));
		userlogin.getLogoutLink().click();
	}


}
