package org.ab.ReportConfig;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class Listeners implements ISuiteListener,ITestListener{
	
//	private Listeners() {
//	};

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportConfig.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.getExtentTest().log(Status.PASS,result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.getExtentTest().log(Status.FAIL,result.getMethod().getMethodName() + " is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReportManager.getExtentTest().log(Status.SKIP,result.getMethod().getMethodName() + " is skipped");
	}

	@Override
	public void onStart(ISuite suite) {
		ExtentReportConfig.initExtentReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReportConfig.flushReport();
	}
	
	
}
