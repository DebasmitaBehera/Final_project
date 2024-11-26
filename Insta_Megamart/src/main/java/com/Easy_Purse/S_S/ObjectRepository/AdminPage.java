package com.Easy_Purse.S_S.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	WebDriver driver;
	public AdminPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Create Category")
	private WebElement  CreatCategoryEdt;
	
	@FindBy(linkText = "Insert Product")
	private   WebElement InsertProductLink;
	
	



	}
	
	
	
	


