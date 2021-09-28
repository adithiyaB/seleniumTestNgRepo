package org.ab.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public final class DataProviderUtil {
	private static List<Map<String, String>> executionData = new ArrayList<Map<String, String>>();

	@DataProvider(name = "executor", parallel=true)
	public static Object[] getTestcaseExecutionData(Method m) {
		List<Map<String, String>> testcaseDataProvider = new ArrayList<Map<String, String>>();
		if (executionData.isEmpty()) {
			executionData = getTestExecutorData();
		}
		for (int i = 0; i < executionData.size(); i++) {
			if (executionData.get(i).get("TC_ID").equalsIgnoreCase(m.getName())) {
				testcaseDataProvider.add(executionData.get(i));
//				executionData.remove(i);
			}
		}
		return testcaseDataProvider.toArray();
	}

	public static List<Map<String, String>> getTestExecutorData() {
		List<Map<String, String>> testDataAllCases = new ArrayList<Map<String, String>>();
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/testData/executor_smoke.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet tcSheet = workbook.getSheet("Testcases");
			List<String> testDataRowHeaders = new ArrayList<String>();
			List<String> executorCaseList = new ArrayList<String>();
			XSSFSheet testDataSheet = workbook.getSheet("Testdata");

			for (int i = 1; i <= tcSheet.getLastRowNum(); i++) {
				if (tcSheet.getRow(i).getCell(3).getStringCellValue().equalsIgnoreCase("yes")) {
					executorCaseList.add(tcSheet.getRow(i).getCell(1).getStringCellValue());
				}
			}
			for (int j = 0; j < testDataSheet.getRow(0).getLastCellNum(); j++) {
				testDataRowHeaders.add(testDataSheet.getRow(0).getCell(j).getStringCellValue());
			}

			testDataSheet = workbook.getSheet("Testdata");
			for (int i = 1; i <= testDataSheet.getLastRowNum(); i++) {
				Map<String, String> testData = new TreeMap<String, String>();
				for (int j = 0; j < testDataSheet.getRow(0).getLastCellNum(); j++) {
					if (j == 0
							&& !(executorCaseList.contains(testDataSheet.getRow(i).getCell(0).getStringCellValue()))) {
						break;
					}
					if (testDataSheet.getRow(i).getCell(j) != null) {
						testData.put(testDataRowHeaders.get(j),
								testDataSheet.getRow(i).getCell(j).getStringCellValue());
					} else {
						testData.put(testDataRowHeaders.get(j), "");
					}
				}
				if (!testData.isEmpty()) {
					testDataAllCases.add(testData);
				}
			}

			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDataAllCases;
	}
}
