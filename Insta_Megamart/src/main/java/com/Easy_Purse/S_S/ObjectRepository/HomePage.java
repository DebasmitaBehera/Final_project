package com.Easy_Purse.S_S.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "My Account")
	private WebElement MycartEdt;

	@FindBy(linkText = "Admin Login")
	private WebElement adminloginEdt;

	@FindBy(linkText = "Wishlist")
	private WebElement WishlistLink;

	@FindBy(linkText = "My Cart")
	private WebElement MyCartLink;

	@FindBy(linkText = "Login")
	private WebElement LoginLink;

	@FindBy(linkText = "home")
	private WebElement homeLink;

	@FindBy(linkText = "Electronics")
	private WebElement ElectronicsEdt;

	@FindBy(linkText = "Furniture")
	private WebElement FurnitureEdt;

	@FindBy(linkText = "Fashion")
	private WebElement FashionEdt;
	
	@FindBy(linkText = "Categories")
	private WebElement CategoriesEdt;

	public WebElement getMycartEdt() {
		return MycartEdt;
	}

	public WebElement getAdminloginEdt() {
		return adminloginEdt;
	}



	public WebElement getWishlistLink() {
		return WishlistLink;
	}

	public WebElement getMyCartLink() {
		return MyCartLink;
	}

	public WebElement getLoginLink() {
		return LoginLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getElectronicsEdt() {
		return ElectronicsEdt;
	}

	public WebElement getFurnitureEdt() {
		return FurnitureEdt;
	}

	public WebElement getFashionEdt() {
		return FashionEdt;
	}

	public WebElement getCategoriesEdt() {
		return CategoriesEdt;
	}
	

		
		
	}
	
	

