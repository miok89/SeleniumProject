package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
	}
	
	@Test (priority = 0)
	public void logInWithValidCredentials() throws InterruptedException {
		homePage.navigateToSignInTab();
		Thread.sleep(1000);
		username = excelReader.getData("LogIn", 6, 6);
		password = excelReader.getData("LogIn", 8, 6);
		Thread.sleep(1000);
		signInPage.logIn(username, password);
		Thread.sleep(2000);
		excelReader.assertMethod("LogIn", 10, 6, homePage.getSignOutButton().getText());
		Thread.sleep(2000);
		}
	
	@Test (priority = 5)
	public void logInWithInvalidUsernameAndPassword() throws InterruptedException {
		homePage.navigateToSignInTab();
		Thread.sleep(1000);
		username = excelReader.getData("LogIn", 6, 7);
		password = excelReader.getData("LogIn", 8, 7);
		Thread.sleep(1000);
		signInPage.logIn(username, password);
		Thread.sleep(2000);
		excelReader.assertMethod("LogIn", 10, 7, signInPage.getErrorMessageBox().getText());
		Thread.sleep(2000);
	}
	
	@Test (priority = 10)
	public void logInWithValidUsernameAndInvalidPassword() throws InterruptedException {
		homePage.navigateToSignInTab();
		Thread.sleep(1000);
		username = excelReader.getData("LogIn", 6, 6);
		password = excelReader.getData("LogIn", 8, 7);
		Thread.sleep(1000);
		signInPage.logIn(username, password);
		Thread.sleep(2000);
		excelReader.assertMethod("LogIn", 10, 7, signInPage.getErrorMessageBox().getText());
		Thread.sleep(2000);
	}
	
	@Test (priority = 15)
	public void logInWithInvalidUsernameAndValidPassword() throws InterruptedException {
		homePage.navigateToSignInTab();
		Thread.sleep(1000);
		username = excelReader.getData("LogIn", 6, 7);
		password = excelReader.getData("LogIn", 8, 6);
		Thread.sleep(1000);
		signInPage.logIn(username, password);
		Thread.sleep(2000);
		excelReader.assertMethod("LogIn", 10, 7, signInPage.getErrorMessageBox().getText());
		Thread.sleep(2000);
	}
	
	@Test (priority = 20)
	public void logInWithoutCredential() throws InterruptedException {
		homePage.navigateToSignInTab();
		Thread.sleep(1000);
		username = "";
		password = "";
		Thread.sleep(1000);
		signInPage.logIn(username, password);
		Thread.sleep(2000);
		excelReader.assertMethod("LogIn", 10, 8, signInPage.getErrorMessageBox().getText());
		Thread.sleep(2000);
	}
	
	@Test (priority = 25)
	public void logOut() throws InterruptedException {
		logInWithValidCredentials();
		Thread.sleep(2000);
		homePage.navigateToSignOutButton();
		Thread.sleep(2000);

	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
