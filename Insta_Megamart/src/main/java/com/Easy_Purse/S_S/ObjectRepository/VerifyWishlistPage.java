package com.Easy_Purse.S_S.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;

public class VerifyWishlistPage extends WebDriverUtility {
	WebDriver driver;

	public VerifyWishlistPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Wishlist")
	private WebElement WishlistLink;

	@FindBy(linkText = "Wishlist")
	private WebElement WishlistEdt;

	@FindBy(xpath = "//a[@href='product-details.php?pid=6']")
	private WebElement ProductName;

	@FindBy(className = "search-field")
	private WebElement searchfieldTextField;

	@FindBy(className = "search-button")
	private WebElement searchbutton;

	@FindBy(xpath = "//a[@title='Wishlist']/child::i")
	private WebElement WishlistIcon;
	
	@FindBy(xpath = "//input[@value='Internet Banking']")
	private WebElement internetBnkingbtn;
	
	@FindBy(className  = "search-field")
	private WebElement searchTextField;
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(className  = "search-field")
	private WebElement searchBtn;

	public WebElement getWishlistLink() {
		return WishlistLink;
	}

	public WebElement getWishlistEdt() {
		return WishlistEdt;
	}

	public WebElement getInternetBnkingbtn() {
		return internetBnkingbtn;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getSearchfieldTextField() {
		return searchfieldTextField;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getWishlistIcon() {
		return WishlistIcon;
	}
	
	public void SelectProduct(String productname) {
		getSearchfieldTextField().sendKeys(productname);
		getSearchbutton().click();
	}
	

	public void wishlistproduct(String ProductName) {
		getSearchfieldTextField().sendKeys(ProductName);
		getSearchbutton().click();
	}
		
		

	}


