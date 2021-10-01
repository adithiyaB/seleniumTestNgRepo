package org.ab.tests;

import java.util.Map;

import org.ab.ReportConfig.ExtentLogger;
import org.ab.utils.DataProviderUtil;
import org.testng.annotations.Test;

public final class LoginPageTest2 extends Hooks {

	@Test(dataProvider = "executor", dataProviderClass = DataProviderUtil.class)
	public void TCF_8(Map<String, String> data) {
		ExtentLogger.info("Infor of tc8");
	}
}
