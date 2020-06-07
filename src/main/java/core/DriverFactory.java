package core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;

public class DriverFactory {
	private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();
	private static final String CHROME_WIN = System.getProperty("user.dir") + File.separator + "drivers" + File.separator
	    + "chromedriver.exe";
	private static final String CHROME_UNIX = System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver";
	private static final String FIREFOX_WIN = System.getProperty("user.dir") + File.separator + "drivers" + File.separator
	    + "geckodriver.exe";
	private static final String FIREFOX_UNIX = System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver";

	private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
		if (SystemUtils.IS_OS_WINDOWS)
			System.setProperty("webdriver.chrome.driver", CHROME_WIN);
		else
			System.setProperty("webdriver.chrome.driver", CHROME_UNIX);
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("enable-automation");
		options.addArguments("start-maximized");
		options.addArguments("--disable-extensions");
		return new ChromeDriver(options);
	};
	private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
		if (SystemUtils.IS_OS_WINDOWS)
			System.setProperty("webdriver.gecko.driver", FIREFOX_WIN);
		else
			System.setProperty("webdriver.gecko.driver", FIREFOX_UNIX);
	return new FirefoxDriver();
	};
	static {
		driverMap.put(DriverType.CHROME, chromeDriverSupplier);
		driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
	}
	
	public static final WebDriver createDriver(DriverType type) {
		return driverMap.get(type).get();
	}
}
