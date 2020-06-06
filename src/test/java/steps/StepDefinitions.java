package steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.ProductListPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

public class StepDefinitions {
	WebDriver driver;
	HomePage homePage;
	ProductListPage productListPage;
	ProductPage productPage;
	ShoppingCartPage shoppingCartPage;
	
	@Given("I enter into an ecommerce")
	public void i_enter_into_an_ecommerce() {
		homePage = new HomePage();
		homePage.openEcommerce();
	}
	
	@When("search for a valid product")
	public void search_for_a_valid_product() {
		homePage.searchValidProduct();
		productListPage = new ProductListPage();
		productListPage.clickProduct();
		productPage = new ProductPage();
		productPage.addCart();
	}
	
	@When("search for an unavailable product")
	public void search_for_an_unavailable_product() {
		homePage.searchUnavailableProduct();
	}
	
	@When("search for an invalid product")
	public void search_for_an_invalid_product() {
		homePage.searchInvalidProduct();
	}
	
	@Then("it should be added to cart")
	public void it_will_be_added_to_cart() {
		shoppingCartPage = new ShoppingCartPage();
		shoppingCartPage.checkCart();
	}
	
	@Then("its quantity should be zero")
	public void its_quantity_should_be_zero() {
		productListPage = new ProductListPage();
		productListPage.checkQuantity();
		;
	}
	
	@Then("an error message should be shown")
	public void an_error_message_should_be_shown() {
		productListPage = new ProductListPage();
		productListPage.checkErrorMessage();
	}
}