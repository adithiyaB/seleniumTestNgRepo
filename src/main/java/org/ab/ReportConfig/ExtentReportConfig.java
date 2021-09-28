package org.ab.ReportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfig {

	private ExtentReportConfig() {
	};

	private static ExtentReports extent;

	public static void initExtentReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/Spark.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("My TestNG Report");
		spark.config().setReportName("My Report Name");
	}

	public static void flushReport() {
		extent.flush();
	}

	public static void createTest(String methodName) {
		ExtentReportManager.setExtentTest(extent.createTest(methodName));
	}
}
