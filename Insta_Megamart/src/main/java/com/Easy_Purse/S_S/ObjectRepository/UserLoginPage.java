package com.Easy_Purse.S_S.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;

public class UserLoginPage extends WebDriverUtility {
	WebDriver driver;
	public UserLoginPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath  = "//a[text()='Login']")
	 private WebElement LoginLink;
	
	@FindBy(id ="exampleInputEmail1")
	private WebElement usernameTxtFd;
	
	@FindBy(name ="password")
	private WebElement passwordTxtFd;
	
	@FindBy(linkText ="Login")
	private WebElement LoginTxtFd;
	
	@FindBy(linkText = "Login")
	private WebElement LoginBtn;
	
	@FindBy(name ="fullname")
	private WebElement fullnameTxtFd;
	
	@FindBy(name ="emailid")
	private WebElement emailidTxtFd;
	
	@FindBy(name ="contactno")
	private WebElement contactnoTxtFd;
	
	@FindBy(name ="password")
	WebElement password2TxtFd;
	
	@FindBy(name ="confirmpassword")
	private WebElement confirmpasswordTxtFd;
	
	@FindBy(name ="Sign Up")
	private WebElement SignUpTxtFd;
	
	@FindBy(xpath  = "//a[text()='Logout']")
	private WebElement LogoutLink;


	
	public WebElement getLogiLink() {
		return LoginLink;
	}



	public WebElement getLoginLink() {
		return LoginLink;
	}



	public WebElement getUsernameTxtFd() {
		return usernameTxtFd;
	}



	public WebElement getPasswordTxtFd() {
		return passwordTxtFd;
	}



	public WebElement getLoginTxtFd() {
		return LoginTxtFd;
	}



	public WebElement getLoginBtn() {
		return LoginBtn;
	}



	public WebElement getFullnameTxtFd() {
		return fullnameTxtFd;
	}



	public WebElement getEmailidTxtFd() {
		return emailidTxtFd;
	}



	public WebElement getContactnoTxtFd() {
		return contactnoTxtFd;
	}



	public WebElement getPassword2TxtFd() {
		return password2TxtFd;
	}



	public WebElement getConfirmpasswordTxtFd() {
		return confirmpasswordTxtFd;
	}



	public WebElement getSignUpTxtFd() {
		return SignUpTxtFd;
	}



	public WebElement getLogoutLink() {
		return LogoutLink;
	}


	public void UserLogin(String url,String username,String password) {
		driver.get(url);
		maximizewindow(driver);
		implicitlitywait(driver);
		getLoginLink().click();
		getUsernameTxtFd().sendKeys(username);
		getPasswordTxtFd().sendKeys(password,Keys.ENTER);
		
		
		
	}
	
	
}
