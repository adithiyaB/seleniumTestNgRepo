package org.ab.driverManager;

import org.ab.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverRef) {
		driver.set(driverRef);
	}

	public static void unload() {
		driver.remove();
	}

	public static void initDriver(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
			setDriver(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
			setDriver(new FirefoxDriver());
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", FrameworkConstants.getIedriverpath());
			setDriver(new InternetExplorerDriver());
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", FrameworkConstants.getEdgedriverpath());
			setDriver(new EdgeDriver());
			break;
		}

	}

	public static void quitDriver() {
		getDriver().quit();
		unload();
	}
}
