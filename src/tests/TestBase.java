package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MyAccountPage;
import pages.MyAddressPage;
import pages.MyPersonalInfoPage;
import pages.MyStoreHomePage;
import pages.MyWishListPage;
import pages.SignInPage;

public class TestBase {

	WebDriver driver;
	// pages:
	MyStoreHomePage homePage;
	SignInPage signInPage;
	ExcelReader excelReader;
	MyAccountPage myAccountPage;
	MyAddressPage myAddressPage;
	MyPersonalInfoPage myPersonalInfoPage;
	MyWishListPage myWishListPage;
	// variables:
	String username;
	String password;
	// My Address page:
	String address1;
	String address2;
	String city;
	String state;
	String postalCode;
	String mobilePhone;
	String aliasAddress;
	// Personal info page:
	String name;
	String lastName;
	String emailAddress;
	String currentPassword;
	// Wish list page:
	String wishListName;

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.homePage = new MyStoreHomePage(driver);
		this.signInPage = new SignInPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.myAddressPage = new MyAddressPage(driver);
		this.myPersonalInfoPage = new MyPersonalInfoPage(driver);
		this.myWishListPage = new MyWishListPage(driver);
		this.excelReader = new ExcelReader("data/TestPlan.xlsx");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		System.out.println("The end");
	}

	public void logedIn() throws InterruptedException {
		
		username = excelReader.getData("LogIn", 6, 6);
		password = excelReader.getData("LogIn", 8, 6);
		
		homePage.navigateToSignInTab();
		
		signInPage.logIn(username, password);
		
		excelReader.assertMethod("LogIn", 10, 6, homePage.getSignOutButton().getText());
	}

	public void restoreAddressInfoPage() throws InterruptedException {
		
		address1 = excelReader.getData("updateAddress", 5, 7);
		address2 = excelReader.getData("updateAddress", 6, 7);
		city = excelReader.getData("updateAddress", 7, 7);
		state = excelReader.getData("updateAddress", 8, 7);
		postalCode = excelReader.getData("updateAddress", 9, 7);
		mobilePhone = excelReader.getData("updateAddress", 10, 7);
		aliasAddress = excelReader.getData("updateAddress", 11, 7);
		
		myAddressPage.navigateToUpdateButton();

		myAddressPage.addingInfoAdrresses(address1, address2, city, state, postalCode, mobilePhone, aliasAddress);
		
		myAddressPage.navigateToSaveButton();
	}

	public void restoreCurrentPersonalInfo() throws InterruptedException {
		
		name = excelReader.getData("personalInfo", 4, 7);
		lastName = excelReader.getData("personalInfo", 5, 7);
		emailAddress = excelReader.getData("personalInfo", 6, 7);
		currentPassword = excelReader.getData("personalInfo", 7, 7);
		
		myAccountPage.navigateToMyPersonalInfoBtn();

		myPersonalInfoPage.addingPersonalInfo(name, lastName, emailAddress, currentPassword);
		
		myPersonalInfoPage.navigateToSaveBtn();
		
		excelReader.assertMethod("personalInfo", 9, 7, myPersonalInfoPage.getAssertTextMessage().getText());
	}

	public void addWishListMethod(int howMany) {
		
		howMany += 7;
		
		for (int i = 7; i < howMany; i++) {
			wishListName = excelReader.getData("addWishList", 4, i);
			myWishListPage.getInputName().sendKeys(wishListName);
			myWishListPage.navigateToSaveWishListBtn();
		}
	}
}
