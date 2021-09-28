package org.ab.tests;

import java.util.HashMap;
import java.util.Map;

import org.ab.ReportConfig.ExtentLogger;
import org.ab.constants.FrameworkConstants;
import org.ab.driverManager.DriverManager;
import org.ab.utils.DataProviderUtil;
import org.ab.utils.GetAllPropertyValues;
import org.ab.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public final class LoginPageTest extends Hooks {
	public WebDriver driver;
	public String LoginPageObjects;
	WebDriverWait wait;
	Map<String, String> pageObjects = new HashMap<String, String>();

	public LoginPageTest() {
		pageObjects = GetAllPropertyValues
				.allPropertyValues(FrameworkConstants.getPageObjectsPath() + "LoginPage.properties");
	}

//	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
//	public void TCF_6(Map<String, String> data) {
//		System.out.println("within test6");
//		DriverManager.getDriver().findElement(By.name("q")).sendKeys(data.get("Subject"),Keys.ENTER);
//	}
//
//	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
//	public void TCF_7(Map<String, String> data) {
//		System.out.println("within test7");
//		DriverManager.getDriver().findElement(By.name("q1")).sendKeys(data.get("Subject"),Keys.ENTER);
//	}

	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
	public void TCF_1(Map<String, String> data) {

		System.out.println("tc1");
		System.out.println(data.get("Password"));
		System.out.println(data.get("UserName"));
		ExtentLogger.info("Infor of tc1");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeleniumUtils.sendKeys(pageObjects.get("LoginPage.username"), data.get("UserName"));
		SeleniumUtils.click(pageObjects.get("LoginPage.nextBtn"));
}}
