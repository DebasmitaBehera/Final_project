package Admin_Module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Easy_Purse.S_S.GenericUtility.BaseClass;
import com.Easy_Purse.S_S.GenericUtility.ExcelUtility;
import com.Easy_Purse.S_S.GenericUtility.FileUtility;
import com.Easy_Purse.S_S.GenericUtility.JavaUtility;
import com.Easy_Purse.S_S.ObjectRepository.AdminloginPage;
import com.Easy_Purse.S_S.ObjectRepository.CreateCategoryPage;

public class CreateCategortyTest extends BaseClass {
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	
	@Test
	
	public void createcategory() throws Throwable {
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("adminusername");
		String PASSWORD=fLib.getDataFromPropertiesFile("adminpassword");
		AdminloginPage alogin=new AdminloginPage(driver);
		alogin.AdminLogin(URL, USERNAME, PASSWORD);
		CreateCategoryPage CreateCategory=new CreateCategoryPage(driver);
		String ProductName = eLib.getDataFromExcel("CreateCategory", 1, 1) ;
		String Description=eLib.getDataFromExcel("CreateCategory", 2, 2);
		CreateCategory.createCategory(ProductName, Description);
		String Actualtext=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(Actualtext);
		String ExpectedText="Well done! Category Created !!";
		Assert.assertTrue(Actualtext.contains(ExpectedText));
	}
}
		
		
		
		
		

