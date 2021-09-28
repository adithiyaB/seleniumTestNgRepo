package org.ab.tests;


import java.util.Map;

import org.ab.driverManager.DriverManager;
import org.ab.utils.DataProviderUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTest2 extends Hooks{

//	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
//	public void TCF_1(Map<String, String> data) {
//		System.out.println("within test1");
////		DriverManager.getDriver().findElement(By.name("q")).sendKeys(data.get("Subject"),Keys.ENTER);
//	}
//	
	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
	public void TCF_8(Map<String, String> data) {
		System.out.println("within test8");
		DriverManager.getDriver().findElement(By.name("q")).sendKeys(data.get("Subject"),Keys.ENTER);
	}
}
