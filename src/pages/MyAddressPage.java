package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAddressPage {
	WebDriver driver;
	WebElement UpdateButton;
	WebElement address1Label;
	WebElement address2Label;
	WebElement cityLabel;
	Select dropState;
	WebElement addNewAddressBtn;
	WebElement postalCodeLabel;
	WebElement mobilePhoneBtn;
	WebElement aliasAddressNameLabel;
	WebElement saveButton;
	WebElement deleteAddressBtn;
	WebElement noAddressBtn;

	public MyAddressPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	//a[@title="Add an address"]
	public WebElement getAddNewAddressBtn() {
		return driver.findElement(By.xpath("//a[@title=\"Add an address\"]"));
	}
	
	//a[@title="Update"]
	//x.path for particular element
	//(//a[@title="Update"])[1]
	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//a[@title=\"Update\"]"));
	}
	
	public WebElement getAddress1Label() {
		return driver.findElement(By.id("address1"));
	}
	
	public WebElement getAddress2Label() {
		return driver.findElement(By.id("address2"));
	}
	
	public WebElement getCityLabel() {
		return driver.findElement(By.id("city"));
	}
	
	public Select getDropState() {
		Select dropState = new Select(driver.findElement(By.id("id_state")));
		return dropState;
	}
	
	public WebElement getPostalCodeLabel() {
		return driver.findElement(By.id("postcode"));
	}
	
	public WebElement getMobilePhoneBtn() {
		return driver.findElement(By.id("phone_mobile"));
	}
	
	public WebElement getAliasAddressNameLabel() {
		return driver.findElement(By.id("alias"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	
	//custom x.path
	//a[@title="Delete"]
	public WebElement getDeleteAddressBtn() {	
		return driver.findElement(By.xpath("//a[@title=\"Delete\"]"));
	}
	
	//i[@class="icon-chevron-left"]
	public WebElement getBackToYourAccountBtn() {	
		return driver.findElement(By.xpath("//i[@class=\"icon-chevron-left\"]"));
	}
	
	//p[@class="alert alert-warning"]
	public WebElement getNoAddressBtn() {
		return driver.findElement(By.xpath("//p[@class=\"alert alert-warning\"]"));
	}
	
	//div[@class="col-xs-12 col-sm-6 address"]/ul/li/h3
	public List<WebElement> getAliasNameText() {
		return driver.findElements(By.xpath("//div[@class=\"col-xs-12 col-sm-6 address\"]/ul/li/h3"));
	}
	
	//div[@class=\"bloc_adresses row\"]/div[@class=\"col-xs-12 col-sm-6 address\"]
	public List<WebElement> getAddressesList() {
		return driver.findElements(By.xpath("//div[@class=\"bloc_adresses row\"]/div[@class=\"col-xs-12 col-sm-6 address\"]"));
	}
	
	public void navigateToUpdateButton() {
		getUpdateButton().click();
	}
	
	public void navigateToSaveButton() {
		getSaveButton().click();
	}
	
	public void navigateToAddNewAddressBtn() {
		getAddNewAddressBtn().click();
	}
	
	public void navigateToDeleteAddressBtn() {
		getDeleteAddressBtn().click();
	}
	
	public void navigateToBackToYourAccountBtn() {
		getBackToYourAccountBtn().click();
	}
	
	public void addingInfoAdrresses(String address1, String address2, String city, String state, 
			String postalCode, String mobilePhone, String aliasAddress) throws InterruptedException {
		this.getAddress1Label().clear();
		this.getAddress1Label().sendKeys(address1);
		Thread.sleep(1000);
		this.getAddress2Label().clear();
		this.getAddress2Label().sendKeys(address2);
		Thread.sleep(1000);
		this.getCityLabel().clear();
		this.getCityLabel().sendKeys(city);
		Thread.sleep(1000);
		this.getDropState().selectByVisibleText(state);
		Thread.sleep(2000);
		this.getPostalCodeLabel().clear();
		this.getPostalCodeLabel().sendKeys(postalCode);
		Thread.sleep(1000);
		this.getMobilePhoneBtn().clear();
		this.getMobilePhoneBtn().sendKeys(mobilePhone);
		Thread.sleep(1000);
		this.getAliasAddressNameLabel().clear();
		this.getAliasAddressNameLabel().sendKeys(aliasAddress);
		Thread.sleep(1000);
	}

}
