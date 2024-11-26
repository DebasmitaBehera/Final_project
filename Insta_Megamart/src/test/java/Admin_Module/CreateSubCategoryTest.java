package Admin_Module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Easy_Purse.S_S.GenericUtility.BaseClass;
import com.Easy_Purse.S_S.GenericUtility.ExcelUtility;
import com.Easy_Purse.S_S.GenericUtility.FileUtility;
import com.Easy_Purse.S_S.GenericUtility.JavaUtility;
import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;
import com.Easy_Purse.S_S.ObjectRepository.AdminloginPage;
import com.Easy_Purse.S_S.ObjectRepository.CreateSubCtegoryPage;

public class CreateSubCategoryTest extends BaseClass {
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	@Test
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
