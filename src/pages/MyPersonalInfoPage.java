package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInfoPage {
	WebDriver driver;
	WebElement firstNameLbl;
	WebElement lastNameLbl;
	WebElement emailAddressLbl;
	WebElement currentPasswordLbl;
	WebElement saveBtn;
	WebElement assertTextMessage;
	WebElement backToYourAccountBtn;
	
	public MyPersonalInfoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getFirstNameLbl() {
		return driver.findElement(By.id("firstname"));
	}
	
	public WebElement getLastNameLbl() {
		return driver.findElement(By.id("lastname"));
	}
	
	public WebElement getEmailAddressLbl() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getCurrentPasswordLbl() {
		return driver.findElement(By.id("old_passwd"));
	}
	
	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button/span"));
	}
	
	public WebElement getAssertTextMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
	}
	
	public WebElement getBackToYourAccountBtn() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a/span"));
	}
	
	public void navigateToFirstNameLbl() {
		getFirstNameLbl().click();
	}
	
	public void navigateToLastNameLbl() {
		getLastNameLbl().click();
	}
	
	public void navigateToEmailAddressLbl() {
		getEmailAddressLbl().click();
	}
	
	public void navigateToCurrentPasswordLbl() {
		getCurrentPasswordLbl().click();
	}
	
	public void navigateToSaveBtn() {
		getSaveBtn().click();
	}
	
	public void navigateToBackToYourAccountBtn() {
		getBackToYourAccountBtn().click();
	}
	
	public void addingPersonalInfo(String name, String lastName,
			String emailAddress, String currentPassword) throws InterruptedException {
		getFirstNameLbl().clear();
		getFirstNameLbl().sendKeys(name);
		Thread.sleep(1000);
		getLastNameLbl().clear();
		getLastNameLbl().sendKeys(lastName);
		Thread.sleep(1000);
		getEmailAddressLbl().clear();
		getEmailAddressLbl().sendKeys(emailAddress);
		Thread.sleep(1000);
		getCurrentPasswordLbl().clear();
		getCurrentPasswordLbl().sendKeys(currentPassword);
		Thread.sleep(1000);
	}
}
