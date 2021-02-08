package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MyStoreHomePage;
import pages.SignInPage;

public class TestBase {
	
	WebDriver driver;
	MyStoreHomePage homePage;
	SignInPage signInPage;
	ExcelReader excelReader;
	String username;
	String password;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.homePage = new MyStoreHomePage(driver);
		this.signInPage = new SignInPage(driver);
		this.excelReader = new ExcelReader("data/TestPlan.xlsx");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
		System.out.println("The end");
	}
}
