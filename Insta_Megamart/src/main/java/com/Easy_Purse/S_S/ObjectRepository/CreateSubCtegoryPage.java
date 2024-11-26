package com.Easy_Purse.S_S.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;

public class CreateSubCtegoryPage extends WebDriverUtility {
	WebDriver driver;

public CreateSubCtegoryPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Sub Category")
private WebElement  SubCategoryLink;

@FindBy(name = "category")
private WebElement categoryDropDown;

@FindBy(xpath  = "//input[@placeholder='Enter SubCategory Name']")
private WebElement subcategoryTextField;





public WebElement getSubcategoryTextField() {
	return subcategoryTextField;
}
@FindBy(name  = "submit")
private WebElement createBtn;

@FindBy(xpath =  "//input[@aria-controls='DataTables_Table_0']")
private WebElement SearchTextField;

public WebElement getSubCategoryLink() {
	return SubCategoryLink;
}

public WebElement getCategoryDropDown() {
	return categoryDropDown;
}

public WebElement getCreateBtn() {
	return createBtn;
}

public WebElement getSearchTextField() {
	return SearchTextField;
}

public void selectCategory()
{
	getCategoryDropDown().click();
	selectbyVisibletext(getCategoryDropDown(),"MOBILES");
}


public void createSubCategory(String Subcat) {
	getSubCategoryLink().click();
	selectCategory();
	getSubcategoryTextField().sendKeys(Subcat);
	getCreateBtn().click();
}




	

}
