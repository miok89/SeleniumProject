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
		Thread.sleep(4000);
		
		excelReader.assertMethod("addWishList", 6, 6, myWishListPage.getAssertWishList1().getText());
	}
	
	@Test (priority = 10)
	public void deleteWishList() throws InterruptedException {
		
		myAccountPage.navigateToMyWishList();
		
		myWishListPage.navigateToDeleteWishListBtn();

		Thread.sleep(4000);
		
		int actual = myWishListPage.getTableOfWishLists().size();
		Assert.assertEquals(actual, 0);
	}
	
	@Test (priority = 15)
	public void addMultipleWishList() throws InterruptedException {
	
		myAccountPage.navigateToMyWishList();
		
		addWishListMethod(3);
		Thread.sleep(4000);
		
		int actual1 = myWishListPage.getTableOfWishLists().size();
		System.out.println(actual1);
		
		Assert.assertEquals(actual1, 3);
		
		myWishListPage.navigateToDeleteWishListBtn();

		Thread.sleep(4000);
		
		int actual2 = myWishListPage.getTableOfWishLists().size();
		System.out.println(actual2);
		
		Assert.assertEquals(actual2, 0);	
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}

