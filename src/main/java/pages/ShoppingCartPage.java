package pages;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;
import core.DataLakeClient;

public class ShoppingCartPage extends BasePage {
	@FindBy(how = How.CSS, using = "a[class='BasketItemProduct-info-title']")
	private WebElement cartDetailText;
	
	public ShoppingCartPage() {
		super();
	}
	
	public void checkCart() {
		assertThat(getText(cartDetailText),
		    allOf(containsString(DataLakeClient.productMap.get("valid").name), 
		    			(containsString(DataLakeClient.productMap.get("valid").id))));
	}
}
