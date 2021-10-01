package org.ab.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.ab.constants.FrameworkConstants;
import org.ab.driverManager.DriverManager;
import org.ab.pageAction.Login;
import org.ab.utils.ReadPropertyFile;
import org.ab.utils.SeleniumUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks {

	private static String enviroment;

	@BeforeSuite
	public void getEnvironment() {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/testData/executor_smoke.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet tcSheet = workbook.getSheet("GlobalParams");
			enviroment = tcSheet.getRow(1).getCell(0).getStringCellValue();
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] executorData) {
		Map<String, String> map = (Map<String, String>) executorData[0];
		DriverManager.initDriver(map.get("Browser"));
		try {
			String URL = ReadPropertyFile.getPropertyValue(FrameworkConstants.getConfigfilepath(), enviroment);
//			Assert.assertEquals(URL, "https://www.google.com1", "Both are not equal");
//			Assertions.assertThat(URL).isEqualTo("https://www.google.com1")
//			.isNotBlank();
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			DriverManager.getDriver().get(URL);
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			SeleniumUtils.waitUntilPageLoad();
			Login.SsoLogin(map.get("UserName"),map.get("Password"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	protected void tearDown() {
		DriverManager.quitDriver();
	}
}
