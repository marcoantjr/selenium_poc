package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(){
		driver = DriverFactory.getDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
}
