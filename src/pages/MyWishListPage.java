package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishListPage {
	WebDriver driver;
	WebElement inputName;
	WebElement saveWishListBtn;
	WebElement deleteWishListBtn;

	public MyWishListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getInputName() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveWishListBtn() {
		return driver.findElement(By.id("submitWishlist"));
	}

	// i[@class="icon-remove"]
	//*[@id="wishlist_29923"]/td[6]/a/i
	public List<WebElement> getDeleteWishListBtn() {
		return driver.findElements(By.xpath("//table[@class=\"table table-bordered\"]/tbody/tr[contains(@id ,'wishlist')]/td[6]/a/i"));
	}

	// (//a[@href=\"javascript:;\"])[redniBr]
	public WebElement getAssertWishList1() {
		return driver.findElement(By.xpath("(//a[@href=\"javascript:;\"])[1]"));
	}

	// div[@id=\"block-history\"]/table/tbody/tr[starts-with(@id ,'wishlist')]
	//table[@class="table table-bordered"]/tbody/tr[contains(@id ,'wishlist')]
	public List<WebElement> getTableOfWishLists() {
		return driver.findElements(By.xpath("//table[@class=\"table table-bordered\"]/tbody/tr[contains(@id ,'wishlist')]"));
	}

	public void navigateToDeleteWishListBtn() throws InterruptedException {
		
		for (int i = 0; i < getDeleteWishListBtn().size(); i++) {
			getDeleteWishListBtn().get(i).click();
			driver.switchTo().alert().accept();
		}
	}

	public void navigateToSaveWishListBtn() {
		getSaveWishListBtn().click();
	}
}
