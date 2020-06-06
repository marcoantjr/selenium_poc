package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

public class ProductPage extends BasePage {
	@FindBy(how = How.CSS, using = "button[class*='js-main-add-cart-button']")
	private WebElement addCartButton;
	
	public ProductPage() {
		super();
	}
	
	public void addCart() {
		addCartButton.click();
	}
}
