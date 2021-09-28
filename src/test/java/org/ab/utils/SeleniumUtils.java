package org.ab.utils;

import org.ab.driverManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
//	private static WebElement element;
	
	public static void click(By obj) {
		By locator=By
		wait.until(ExpectedConditions.elementToBeClickable(obj));
		DriverManager.getDriver().findElement(obj).click();
	}
	
	public static void sendKeys(By obj,String value) {
		By locator = By.
		element = DriverManager.getDriver().findElement(obj);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void getLocator(String obj) {
		obj.split("By.");
	}
}
