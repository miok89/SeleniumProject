package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStoreHomePage {
	WebDriver driver;
	
	public MyStoreHomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getSignInTab() {
		return driver.findElement(By.className("login"));
	}
	
	
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}
	
	public void navigateToSignInTab() {
		getSignInTab().click();
	}
	
	public void navigateToSignOutButton() {
		getSignOutButton().click();
	}
}
