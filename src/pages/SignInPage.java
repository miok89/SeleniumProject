package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	WebDriver driver;
	WebElement emailAddressLabel;
	WebElement passwordLabel;
	WebElement signInButton;
	WebElement errorMessageBox;

	public SignInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getEmailAddressLabel() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordLabel() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getErrorMessageBox() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
	}
	
	public void navigateToSignInButton() {
		getSignInButton().click();
	}
	
	public void logIn(String username, String password) throws InterruptedException {
		this.getEmailAddressLabel().clear();
		this.getEmailAddressLabel().sendKeys(username);
		Thread.sleep(1000);
		this.getPasswordLabel().clear();
		this.getPasswordLabel().sendKeys(password);
		Thread.sleep(1000);
		this.navigateToSignInButton();
	}
}
