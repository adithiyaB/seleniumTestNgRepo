//package org.ab.constants;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.Properties;
//
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.WebDriver;
//
//import com.concord.nextstep.helper.ExcelHelper;
//import com.concord.nextstep.logger.Logger;
//
//public class GlobalVariable 
//{	
//	public static WebDriver driver;
//	public static Class<?> currentClass;
//	private static String SNo;
//	private static String TC_ID;
//	private static String TestCaseDescription;
//	private static String Execution;
//	private static String Browser;
//	public static String current_className;
//	public static int current_SheetNumber;
//	public static XSSFWorkbook TCWorkbook;
//	public static XSSFWorkbook JiraWorkbook;	
//	public static InputStream input = null;
//	public static Properties prop = new Properties();
//	public static String baseURL;
//	public static String env;
//	public static String defaultSharedQueue = null;	
//	public static String userName;
//	public static String password;
//	public static String invalidpassword;
//	public static String adminUserName;
//	public static String adminPassword;
//	public static String faxnumber;
//	public static int beforesourcefoldercount;
//	public static int beforedestinationfoldercount;
//	public static int aftersourcefoldercount;
//	public static int afterdestinationfoldercount;
//	public static int sourceFaxPageCount;
//	public static int destinationFaxPageCount;
//	public static int totalPageCount;
//	public static String testType = "NA";
//	public static int afterdestinationfolder2count;
//	public static int beforedestinationfolder2count;
//	public static String timeTaken;
//	public static int iterationCount;
//	public static String [] executionTime;
//	public static String folderName;
//	public static String folderName2;
//	public static String queueName;
//	public static String markDocumentAs;
//	public static boolean userapplogout = false;
//	public static int thumbnailcount;
//	public static String activityTimeout;
//	public static Boolean updateGlobalValue(int rowNumber, int sheetNumber) throws Exception
//	{
//		Boolean status = false;
//		updateURL();
//		String[] value = ExcelHelper.readALine(TCWorkbook, sheetNumber,rowNumber);
//		if(value[0]!= null)
//		{
//			SNo = value[0];
//			TC_ID =value[1];
//			TestCaseDescription = value[2];
//			Execution = value[3];     
//			Browser = value[4];
//			status = true;
//		}
//		else
//		{
//			status = false;
//		}
//		return status;
//	}
//	
//	public static void updateURL() throws Exception
//	{
//		env = GlobalVariable.prop.getProperty("testEnvironment");		
//		if(env.equals("Test"))
//		{
//			baseURL = GlobalVariable.prop.getProperty("TestURL");
//			Logger.writeDayLog(Logger.messageType.Pass, "URL is set as per config");
//		}
//		else if(env.equals(("Dev")))
//		{
//			baseURL = GlobalVariable.prop.getProperty("DevURL");
//			Logger.writeDayLog(Logger.messageType.Pass, "URL is set as per config");
//		}
//		else if(env.equals(("Stage")))
//		{
//			baseURL = GlobalVariable.prop.getProperty("StageURL");
//			Logger.writeDayLog(Logger.messageType.Pass, "URL is set as per config");
//		}
//		else if(env.equals(("Preview")))
//		{
//			baseURL = GlobalVariable.prop.getProperty("PreviewURL");
//			Logger.writeDayLog(Logger.messageType.Pass, "URL is set as per config");
//		}
//		else if(env.equals(("Production")))
//		{
//			baseURL = GlobalVariable.prop.getProperty("ProductionURL");
//			Logger.writeDayLog(Logger.messageType.Pass, "URL is set as per config");
//		}
//		else
//		{
//			baseURL = GlobalVariable.prop.getProperty("TestURL");
//			Logger.writeDayLog(Logger.messageType.Pass, "URL is set to test");
//		}
//		userName = GlobalVariable.prop.getProperty("UserName");
//		password = GlobalVariable.prop.getProperty("Password");
//		adminUserName = GlobalVariable.prop.getProperty("adminUserName");
//		adminPassword = GlobalVariable.prop.getProperty("adminPassword");
//	}
//	
//	public static void excelInit(String filename) throws Exception
//	{
//		TCWorkbook = ExcelHelper.copyWorkbook("./Data/" +filename);
//		JiraWorkbook = ExcelHelper.copyWorkbook("./Data/JIRA.xlsx");
//	}
//	
//	public static void init() throws Exception
//	{		
//		String inputTestFile;
//		input = new FileInputStream("config.properties");        
//        prop.load(input);        
//        if(GlobalVariable.prop.getProperty("executionType").equals("All"))
//		{    		    		
//        	inputTestFile = "Regression.xlsx";
//    		GlobalVariable.testType = "Regression";
//		}
//    	else if(GlobalVariable.prop.getProperty("executionType").equals("Using Jira ID")) 
//    	{    		    		
//    		inputTestFile = "Regression.xlsx";
//    		GlobalVariable.testType = "Custom";
//    	}    		    	
//    	else if(GlobalVariable.prop.getProperty("executionType").equals("Smoke"))
//    	{    	
//    		inputTestFile ="SmokeTest.xlsx";
//    		GlobalVariable.testType = "Smoke";
//    	}
//    	else if(GlobalVariable.prop.getProperty("executionType").equals("Metrics"))
//    	{
//    		inputTestFile="MetricsCalculation.xlsx";
//    		GlobalVariable.testType = "Metrics Calculation";
//    	}
//    	else
//    	{    		
//    		GlobalVariable.testType = "Invalid";
//    		inputTestFile = "Regression.xlsx";    		
//    		
//    	}    	    	
//		excelInit(inputTestFile);
//		Logger.logInit();    	
//	}
//	
//	public static String getSNo() 
//	{
//		return SNo;
//    }
//	
//	public static String getTC_ID() 
//	{
//		return TC_ID;
//    }
//	
//	public static String getTestCaseDescription() 
//	{
//		return TestCaseDescription;
//    }
//	
//	public static String getExecution() 
//	{
//		return Execution;
//    }
//	
//	public static String getBrowser() 
//	{
//		return Browser;
//    }
//}