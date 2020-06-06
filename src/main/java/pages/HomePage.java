package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

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
		search("220258600");
	}
	
	public void searchUnavailableProduct() {
		search("452722000");
	}
	
	public void searchInvalidProduct() {
		search("220258601");
	}
	
	public void search(String product) {
		searchField.sendKeys(product);
		searchButton.click();
	}
}
