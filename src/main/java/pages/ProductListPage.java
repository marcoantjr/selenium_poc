package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

public class ProductListPage extends BasePage {
	@FindBy(how = How.CSS, using = "li[id^='nm-product']")
	private WebElement validProductButton;
	@FindBy(how = How.CSS, using = "h1[id='main-title'] span[id='nm-total-results-number']")
	private WebElement productQuantityText;
	@FindBy(how = How.CSS, using = "div[class='nm-not-found-message1']")
	private WebElement productNotFoundText;
	
	public ProductListPage() {
		super();
	}
	
	public void clickProduct() {
		validProductButton.click();
	}
	
	public void checkQuantity() {
		System.out.println(productQuantityText.getText());
	}
	
	public void checkErrorMessage() {
		System.out.println(productNotFoundText.getText());
	}
	
}
