package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAddressButton;
	WebElement MyPersonalInfoBtn;
	WebElement myWishList;

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	//custom x.path
	//a[@title="Addresses"]
	public WebElement getMyAddressButton() {
		return driver.findElement(By.xpath("//a[@title=\"Addresses\"]"));
	}
	
	public void navigateToMyAddressButton() {
		getMyAddressButton().click();
	}
	//custom x.path
	//a[@title="Information"]
	public WebElement getMyPersonalInfoBtn() {
		return driver.findElement(By.xpath("//a[@title=\"Information\"]"));
	}
	
	public void navigateToMyPersonalInfoBtn() {
		getMyPersonalInfoBtn().click();
	}
	//custom x.path
	//a[@title="My wishlists"]
	public WebElement getMyWishList() {
		return driver.findElement(By.xpath("//a[@title=\"My wishlists\"]"));
	}
	
	public void navigateToMyWishList()  {
		getMyWishList().click();
	}
	
	
}
