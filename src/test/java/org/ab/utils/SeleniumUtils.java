package org.ab.utils;

import java.util.Map;

import org.ab.driverManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumUtils {
	private static Map<String, By> allPageObjects = YamlReader.getPageObjects();
	private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 15);

	private static By getByLocator(String obj) {
		By locator = allPageObjects.get(obj);
		Assert.assertNotNull(locator, "\"" + obj + "\"" + "not found in yml");
		return locator;
	}

	public static void click(String obj) {
		WebElement element = DriverManager.getDriver().findElement(getByLocator(obj));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		waitUntilPageLoad();
	}

	public static void sendKeys(String obj, String value) {
		WebElement element = DriverManager.getDriver().findElement(getByLocator(obj));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void contextClick(String obj) {
		Actions action = new Actions(DriverManager.getDriver());
		WebElement element = DriverManager.getDriver().findElement(getByLocator(obj));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		action.contextClick(element).perform();
	}

	public static void doubleClick(String obj) {
		Actions action = new Actions(DriverManager.getDriver());
		WebElement element = DriverManager.getDriver().findElement(getByLocator(obj));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		action.doubleClick(element).perform();
		waitUntilPageLoad();
	}

	public static void switchToDefaultContent() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

	public static void waitUntilElementDisappear(String obj) {
		WebElement element = DriverManager.getDriver().findElement(getByLocator(obj));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitUntilPageLoad() {
		wait.until(driver -> ((JavascriptExecutor) DriverManager.getDriver())
				.executeScript("return document.readyState").equals("complete"));
	}

}
