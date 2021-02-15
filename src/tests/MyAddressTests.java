package tests;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		logedIn();
	}

	@Test(priority = 5)
	public void addNewAddress() throws InterruptedException {

		address1 = excelReader.getData("addNewAddress", 5, 6);
		address2 = excelReader.getData("addNewAddress", 6, 6);
		city = excelReader.getData("addNewAddress", 7, 6);
		state = excelReader.getData("addNewAddress", 8, 6);
		postalCode = excelReader.getData("addNewAddress", 9, 6);
		mobilePhone = excelReader.getData("addNewAddress", 10, 6);
		aliasAddress = excelReader.getData("addNewAddress", 11, 6);

		myAccountPage.navigateToMyAddressButton();
		
		myAddressPage.navigateToAddNewAddressBtn();
		
		myAddressPage.addingInfoAdrresses(address1, address2, city, state, postalCode, mobilePhone, aliasAddress);
		
		myAddressPage.navigateToSaveButton();
		
		excelReader.assertMethod("addNewAddress", 13, 6, myAddressPage.getAliasNameText().get(0).getText());

	}

	@Test(priority = 10)
	public void updateAddress() throws InterruptedException {
		
		address1 = excelReader.getData("updateAddress", 5, 6);
		address2 = excelReader.getData("updateAddress", 6, 6);
		city = excelReader.getData("updateAddress", 7, 6);
		state = excelReader.getData("updateAddress", 8, 6);
		postalCode = excelReader.getData("updateAddress", 9, 6);
		mobilePhone = excelReader.getData("updateAddress", 10, 6);
		aliasAddress = excelReader.getData("updateAddress", 11, 6);
		
		myAccountPage.navigateToMyAddressButton();
		
		myAddressPage.navigateToUpdateButton();
	
		myAddressPage.addingInfoAdrresses(address1, address2, city, state, postalCode, mobilePhone, aliasAddress);
		
		myAddressPage.navigateToSaveButton();
	
		excelReader.assertMethod("updateAddress", 13, 6, myAddressPage.getAliasNameText().get(0).getText());
	}

	@Test(priority = 15)
	public void removeAddress() throws InterruptedException {

		myAccountPage.navigateToMyAddressButton();
		
		int beforeDel = myAddressPage.getAddressesList().size();
		System.out.println("Broj adresa pre brisanja: " + beforeDel);
		
		myAddressPage.navigateToDeleteAddressBtn();
		
		driver.switchTo().alert().accept();
		
		int afterDel = myAddressPage.getAddressesList().size();
		System.out.println("Broj adresa posle brisanja: " + afterDel);
		
		Assert.assertNotEquals(afterDel, beforeDel);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
