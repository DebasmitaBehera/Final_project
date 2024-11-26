package com.Easy_Purse.S_S.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {
	WebDriver driver;

	public CreateCategoryPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Create Category")
	private WebElement  CreatCategoryLink;
	
	public WebElement getCreatCategoryLink() {
		return CreatCategoryLink;
	}
	@FindBy(name="category")
	private WebElement categoryNameTextField;
	
	@FindBy(name="description")
	private WebElement descriptionTextField;
	
	@FindBy(name="submit")
	private WebElement CreateBtn;
	
	@FindBy(xpath = "//input[@aria-controls='DataTables_Table_0']")
	private WebElement SearchTextField;

	public WebElement getCategoryNameTextField() {
		return categoryNameTextField;
	}

	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public WebElement getCreateBtn() {
		return CreateBtn;
	}

	public WebElement getSearchTextField() {
		return SearchTextField;
	}
	
	public void createCategory(String Categoryname,String Description) {
		CreatCategoryLink.click();
		getCategoryNameTextField().sendKeys(Categoryname);
		getDescriptionTextField().sendKeys(Description);
	    getCreateBtn().click();
		
	
	}

	

}
