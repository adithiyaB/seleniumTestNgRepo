package org.ab.ReportConfig;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {
	
	
	private ExtentReportManager() {
	};
	
	
	private static ThreadLocal<ExtentTest> extentTestObj = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return extentTestObj.get();
	}

	static void setExtentTest(ExtentTest ref) {
		extentTestObj.set(ref);
	}

	static void unloadExtentTest() {
		extentTestObj.remove();
	}
}
