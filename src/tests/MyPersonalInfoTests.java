package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInfoTests extends TestBase{
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
	}
	
	@Test (priority = 5)
	public void updateMyPersonalInfo() throws InterruptedException {
		
		name = excelReader.getData("personalInfo", 4, 6);
		lastName = excelReader.getData("personalInfo", 5, 6);
		emailAddress = excelReader.getData("personalInfo", 6, 6);
		currentPassword = excelReader.getData("personalInfo", 7, 6);
		
		logedIn();
		
		myAccountPage.navigateToMyPersonalInfoBtn();
		
		myPersonalInfoPage.addingPersonalInfo(name, lastName, emailAddress, currentPassword);
		
		myPersonalInfoPage.navigateToSaveBtn();
		
		excelReader.assertMethod("personalInfo", 9, 6, myPersonalInfoPage.getAssertTextMessage().getText());
		
		myPersonalInfoPage.navigateToBackToYourAccountBtn();
		
		restoreCurrentPersonalInfo();
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
	}
}
