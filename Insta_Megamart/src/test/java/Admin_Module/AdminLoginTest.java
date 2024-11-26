package Admin_Module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Easy_Purse.S_S.GenericUtility.BaseClass;
import com.Easy_Purse.S_S.GenericUtility.ExcelUtility;
import com.Easy_Purse.S_S.GenericUtility.FileUtility;
import com.Easy_Purse.S_S.GenericUtility.JavaUtility;
import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;
import com.Easy_Purse.S_S.ObjectRepository.AdminloginPage;
import com.Easy_Purse.S_S.ObjectRepository.CreateCategoryPage;
import com.Easy_Purse.S_S.ObjectRepository.CreateSubCtegoryPage;
@Listeners(com.Easy_Purse.S_S.GenericUtility.Listner_implementation.class)
public class AdminLoginTest extends BaseClass {
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	@Test(groups = "smokeTest")
	public void adminlogin() throws Throwable {
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("adminusername");
		String PASSWORD = fLib.getDataFromPropertiesFile("adminpassword");
		AdminloginPage alogin = new AdminloginPage(driver);
		alogin.AdminLogin(URL, USERNAME, PASSWORD);
		String actulresult = driver.findElement(By.xpath("//span[@style='margin-left: 30px;']")).getText();
		System.out.println(actulresult);
		String expectedresult = "Shopping | Admin";
		Assert.assertTrue(actulresult.contains(expectedresult));
	}

	@Test(groups = "regression")

	public void createcategory() throws Throwable {
		String URL = fLib.getDataFromPropertiesFile("url") ;
		String USERNAME = fLib.getDataFromPropertiesFile("adminusername");
		String PASSWORD = fLib.getDataFromPropertiesFile("adminpassword");
		AdminloginPage alogin = new AdminloginPage(driver);
		alogin.AdminLogin(URL, USERNAME, PASSWORD);
		CreateCategoryPage CreateCategory = new CreateCategoryPage(driver);
		String ProductName = eLib.getDataFromExcel("CreateCategory", 1, 1);
		String Description = eLib.getDataFromExcel("CreateCategory", 2, 2);
		CreateCategory.createCategory(ProductName, Description);
		String Actualtext = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(Actualtext);
		String ExpectedText = "Well done! Category Created !!";
		Assert.assertTrue(Actualtext.contains(ExpectedText));
	}

	@Test(groups =  "smokeTest")
	public void createSubCategory() throws Throwable {

		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("adminusername");
		String PASSWORD = fLib.getDataFromPropertiesFile("adminpassword");
		AdminloginPage alogin = new AdminloginPage(driver);
		alogin.AdminLogin(URL, USERNAME, PASSWORD);
		CreateSubCtegoryPage createSubCategory = new CreateSubCtegoryPage(driver);
		String ProductName = eLib.getDataFromExcel("CreateCategory", 1, 3);
		createSubCategory.createSubCategory(ProductName);
		createSubCategory.getSearchTextField().sendKeys(ProductName);
		String Actualtext = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(Actualtext);
		String ExpectedText = "Well done! SubCategory Created !!";
		Assert.assertTrue(Actualtext.contains(ExpectedText));

	}

}
