package core;

import org.openqa.selenium.WebDriver;

import enums.DriverType;

public class DriverManager {
private static WebDriver driver;
	
	private DriverManager() {
	}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			driver = DriverFactory.createDriver(DriverType.CHROME);
		}
		return driver;
	}
	
	public static void destroy() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
