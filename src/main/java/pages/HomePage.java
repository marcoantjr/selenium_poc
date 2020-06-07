package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;
import core.DataLakeClient;

public class HomePage extends BasePage {
	@FindBy(how = How.ID, using = "inpHeaderSearch")
	private WebElement searchField;
	@FindBy(how = How.ID, using = "btnHeaderSearch")
	private WebElement searchButton;
	
	public HomePage() {
		super();
	}
	
	public void openEcommerce() {
		driver.get("http://www.magazineluiza.com.br");
	}
	
	public void searchValidProduct() {
		search(DataLakeClient.productMap.get("valid").id);
	}
	
	public void searchUnavailableProduct() {
		search(DataLakeClient.productMap.get("unavailable").id);
	}
	
	public void searchInvalidProduct() {
		search(DataLakeClient.productMap.get("invalid").id);
	}
	
	public void search(String productId) {
		searchField.sendKeys(productId);
		searchButton.click();
	}
}
