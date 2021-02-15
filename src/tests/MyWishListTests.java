package tests;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		logedIn();
	}
	
	@Test (priority = 5)
	public void addWishList() throws InterruptedException {
		
		wishListName = excelReader.getData("addWishList", 4, 6);
		
		myAccountPage.navigateToMyWishList();
		
		myWishListPage.getInputName().sendKeys(wishListName);
		
		myWishListPage.navigateToSaveWishListBtn();
		Thread.sleep(2000);
		
		excelReader.assertMethod("addWishList", 6, 6, myWishListPage.getAssertWishList1().getText());
	}
	
	@Test (priority = 10)
	public void deleteWishList() throws InterruptedException {
		
		myAccountPage.navigateToMyWishList();
		
		myWishListPage.navigateToDeleteWishListBtn();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		//int actual = myWishListPage.getTableOfWishLists().size();
		//Assert.assertEquals(actual, 0);
		
		boolean actual = myWishListPage.getDeleteWishListBtn().isDisplayed();
		boolean expected = false;

		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 15)
	public void addMultipleWishList() throws InterruptedException {
	
		myAccountPage.navigateToMyWishList();
		Thread.sleep(2000);
		
		addWishListMethod(3);
		Thread.sleep(2000);
		
		int actual1 = myWishListPage.getTableOfWishLists().size();
		System.out.println(actual1);
		
		Assert.assertEquals(actual1, 3);
		for (int i = 0; i < 3; i++) {
			myWishListPage.navigateToDeleteWishListBtn();
			driver.switchTo().alert().accept();
		}
		Thread.sleep(5000);
		
		boolean actual3 = myWishListPage.getDeleteWishListBtn().isDisplayed();
		boolean expected3 = false;
		
		//int actual2 = myWishListPage.getTableOfWishLists().size();
		//System.out.println(actual2);
		
		//Assert.assertEquals(actual2, expected2);
		Assert.assertEquals(actual3, expected3);
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}

