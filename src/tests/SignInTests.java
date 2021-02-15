package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
	}
	
	@Test (priority = 0)
	public void logInWithValidCredentials() throws InterruptedException {
		
		username = excelReader.getData("LogIn", 6, 6);
		password = excelReader.getData("LogIn", 8, 6);
		
		homePage.navigateToSignInTab();
	
		signInPage.logIn(username, password);
	
		excelReader.assertMethod("LogIn", 10, 6, homePage.getSignOutButton().getText());
	
		}
	
	@Test (priority = 5)
	public void logInWithInvalidUsernameAndPassword() throws InterruptedException {
		
		username = excelReader.getData("LogIn", 6, 7);
		password = excelReader.getData("LogIn", 8, 7);
		
		homePage.navigateToSignInTab();
		
		signInPage.logIn(username, password);
	
		excelReader.assertMethod("LogIn", 10, 7, signInPage.getErrorMessageBox().getText());
	
	}
	
	@Test (priority = 10)
	public void logInWithValidUsernameAndInvalidPassword() throws InterruptedException {
		
		username = excelReader.getData("LogIn", 6, 6);
		password = excelReader.getData("LogIn", 8, 7);
		
		homePage.navigateToSignInTab();
	
		signInPage.logIn(username, password);
		
		excelReader.assertMethod("LogIn", 10, 7, signInPage.getErrorMessageBox().getText());
	
	}
	
	@Test (priority = 15)
	public void logInWithInvalidUsernameAndValidPassword() throws InterruptedException {
		
		username = excelReader.getData("LogIn", 6, 7);
		password = excelReader.getData("LogIn", 8, 6);
		
		homePage.navigateToSignInTab();
	
		signInPage.logIn(username, password);
	
		excelReader.assertMethod("LogIn", 10, 7, signInPage.getErrorMessageBox().getText());
	
	}
	
	@Test (priority = 20)
	public void logInWithoutCredentials() throws InterruptedException {
		
		homePage.navigateToSignInTab();
	
		signInPage.navigateToSignInButton();
	
		excelReader.assertMethod("LogIn", 10, 8, signInPage.getErrorMessageBox().getText());
	
	}
	
	@Test (priority = 25)
	public void logOut() throws InterruptedException {
		
		logInWithValidCredentials();
	
		homePage.navigateToSignOutButton();
	
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();	
	}
}
