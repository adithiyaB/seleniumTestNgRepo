package org.ab.ReportConfig;

public class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String msg) {
		ExtentReportManager.getExtentTest().pass(msg);
	}

	public static void fail(String msg) {
		ExtentReportManager.getExtentTest().fail(msg);
	}

	public static void info(String msg) {
		ExtentReportManager.getExtentTest().info(msg);
	}

	public static void skip(String msg) {
		ExtentReportManager.getExtentTest().skip(msg);
	}
}
