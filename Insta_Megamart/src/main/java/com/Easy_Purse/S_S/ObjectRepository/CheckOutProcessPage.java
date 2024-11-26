package com.Easy_Purse.S_S.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Easy_Purse.S_S.GenericUtility.WebDriverUtility;

public class CheckOutProcessPage extends WebDriverUtility {
	WebDriver driver;

	public CheckOutProcessPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "search-field")
	private WebElement searchfieldTextField;

	@FindBy(className = "search-button")
	private WebElement searchbutton;

	public WebElement getMyCartLink() {
		return MyCartLink;
	}

	@FindBy(xpath = "")
	private WebElement MyCartLinkicon;

	@FindBy(linkText = "My Cart")
	private WebElement MyCartLink;

	@FindBy(name = "billingaddress")
	private WebElement billingaddressTextField;

	@FindBy(name = "bilingstate")
	private WebElement bilingstateTextField;

	@FindBy(name = "billingcity")
	private WebElement billingcityTextField;

	@FindBy(name = "billingpincode")
	private WebElement billingpincodeTextField;

	@FindBy(name = "Update")
	private WebElement UpdateBtn1;

	@FindBy(name = "shippingaddress")
	private WebElement shippingaddressTextField;

	@FindBy(name = "shippingstate")
	private WebElement shippingstateTextField;

	@FindBy(name = "shippingcity")
	private WebElement shippingcityTextField;

	@FindBy(name = "shippingpincode")
	private WebElement shippingpincodeTextField;

	@FindBy(name = "shipupdate")
	private WebElement shipupdateBtn;

	@FindBy(name = "ordersubmit")
	private WebElement ProceedtocheckoutrBtn;

	@FindBy(xpath = "//input[@value='COD']")
	private WebElement PaymentRadioBtn;

	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	@FindBy(className  = "search-field")
	private WebElement searchTextField;
	
	@FindBy(className  = "search-field")
	private WebElement searchBtn;
	

	public WebElement getBillingaddressTextField() {
		return billingaddressTextField;
	}

	public WebElement getBilingstateTextField() {
		return bilingstateTextField;
	}

	public WebElement getBillingcityTextField() {
		return billingcityTextField;
	}

	public WebElement getBillingpincodeTextField() {
		return billingpincodeTextField;
	}

	public WebElement getUpdateBtn1() {
		return UpdateBtn1;
	}

	public WebElement getShippingaddressTextField() {
		return shippingaddressTextField;
	}

	public WebElement getShippingstateTextField() {
		return shippingstateTextField;
	}

	public WebElement getShippingcityTextField() {
		return shippingcityTextField;
	}

	public WebElement getShippingpincodeTextField() {
		return shippingpincodeTextField;
	}

	public WebElement getShipupdateBtn() {
		return shipupdateBtn;
	}

	public WebElement getProceedtocheckoutrBtn() {
		return ProceedtocheckoutrBtn;
	}

	public WebElement getPaymentRadioBtn() {
		return PaymentRadioBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getSearchfieldTextField() {
		return searchfieldTextField;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getMyCartLinkicon() {
		return MyCartLinkicon;
	}
	
	public WebElement getSearchfieldTextFieldACO() {
		return searchfieldTextField;
	}

	public WebElement getSearchbuttonACO() {
		return searchbutton;
	}

	public void SelectProduct(String productname) {
		getSearchfieldTextField().sendKeys(productname);
		getSearchbutton().click();

	}
	
	public void searchproduct(String productname) {
		getSearchfieldTextFieldACO().sendKeys(productname);
		getSearchbuttonACO().click();
	}

	public void checkout(String BillingAdd, String BillingState, String BillingCity, String BillingPincode,
			String ShippingAdd, String ShippingState, String ShippingCity, String Shippingpincode) {

		getBillingaddressTextField().sendKeys(BillingAdd);
		getBilingstateTextField().sendKeys(BillingState);
		getBillingcityTextField().sendKeys(BillingCity);
		getBillingpincodeTextField().sendKeys(BillingPincode);
		getShippingaddressTextField().sendKeys(ShippingAdd);
		getShippingstateTextField().sendKeys(ShippingState);
		getShippingcityTextField().sendKeys(ShippingCity);
		getShippingpincodeTextField().sendKeys(Shippingpincode);
		getProceedtocheckoutrBtn().click();
		getPaymentRadioBtn().click();
		getSubmitBtn().click();
	}

}
