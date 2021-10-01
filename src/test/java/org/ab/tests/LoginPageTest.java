package org.ab.tests;

import java.util.HashMap;
import java.util.Map;

import org.ab.ReportConfig.ExtentLogger;
import org.ab.utils.DataProviderUtil;
import org.ab.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public final class LoginPageTest extends Hooks {
	public WebDriver driver;
	public String LoginPageObjects;
	WebDriverWait wait;
	Map<String, String> pageObjects = new HashMap<String, String>();

	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
	public void TCF_6(Map<String, String> data) {
		ExtentLogger.info("Infor of tc6");
	}

	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
	public void TCF_7(Map<String, String> data) {
		ExtentLogger.info("Infor of tc7");
	}

	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
	public void TCF_1(Map<String, String> data) {
		ExtentLogger.info("Infor of tc1");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeleniumUtils.waitUntilPageLoad();
		SeleniumUtils.contextClick("FaxInbox.MyPersonalFolderMenu");
		SeleniumUtils.click("FaxInbox.createSubFolder");
		SeleniumUtils.sendKeys("FaxInbox.subFolderNameTxt","automationTest");
		SeleniumUtils.click("FaxInbox.createBtn");
	}
}
