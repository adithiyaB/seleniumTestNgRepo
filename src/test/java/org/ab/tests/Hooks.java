package org.ab.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.ab.constants.FrameworkConstants;
import org.ab.driverManager.DriverManager;
import org.ab.utils.ReadPropertyFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks {

	public static String enviroment;

	@BeforeSuite
	public void getEnvironment() {
		try {
			System.out.println("within if");
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
		System.out.println(map.get("Browser"));
		System.out.println("within setuphook");
		DriverManager.initDriver(map.get("Browser"));
		try {
			System.out.println("env is:" + enviroment);
			String URL = ReadPropertyFile.getPropertyValue(FrameworkConstants.getConfigfilepath(), enviroment);
//			Assert.assertEquals(URL, "https://www.google.com1", "Both are not equal");
//			Assertions.assertThat(URL).isEqualTo("https://www.google.com1")
//			.isNotBlank();
			DriverManager.getDriver().get(URL);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterMethod
	protected void tearDown() {
		System.out.println("within tearDown hook");
		DriverManager.quitDriver();
	}
}
