package com.Easy_Purse.S_S.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;

public class AdminloginPage extends WebDriverUtility {
	WebDriver driver;
    public AdminloginPage(WebDriver driver)
    {
	this.driver=driver;
	PageFactory.initElements(driver, this);

	}
	@FindBy(linkText = "Admin Login")
	private WebElement adminloginEdt;

	@FindBy(name = "username")
	private WebElement usernameTextFld;

	@FindBy(name = "password")
	private WebElement passwordTextFld;

	@FindBy(name = "submit")
	private WebElement LoginBtn;
	
	
	
	public WebElement getAdminloginEdt() {
		return adminloginEdt;
	}


	public WebElement getUsernameTextFld() {
		return usernameTextFld;
	}

	public WebElement getPasswordTextFld() {
		return passwordTextFld;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	public void AdminLogin(String Url,String un,String pswd) throws InterruptedException {
		driver.get(Url);
		maximizewindow(driver);
		implicitlitywait(driver);
		getAdminloginEdt().click();
		getUsernameTextFld().sendKeys(un);
		getPasswordTextFld().sendKeys(pswd);
		Thread.sleep(10);
		getLoginBtn().click();
		

}}
