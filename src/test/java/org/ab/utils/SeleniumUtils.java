package org.ab.utils;

import java.util.Map;

import org.ab.driverManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumUtils {
	private static Map<String, By> allPageObjects = YamlReader.getPageObjects();
	private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);

	public static void click(String obj) {
		WebElement element = DriverManager.getDriver().findElement(getByLocator(obj));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void sendKeys(String obj, String value) {
		WebElement element = DriverManager.getDriver().findElement(getByLocator(obj));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	private static By getByLocator(String obj) {
		By locator = allPageObjects.get(obj);
		Assert.assertNotNull(locator, "\"" + obj + "\"" + "not found in yml");
		return locator;
	}

}
