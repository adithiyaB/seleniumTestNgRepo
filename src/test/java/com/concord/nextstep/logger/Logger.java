//package com.concord.nextstep.logger;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import com.concord.nextstep.framework.App;
//import com.concord.nextstep.framework.BusinessLogic;
//import com.concord.nextstep.framework.GlobalVariable;
//import com.concord.nextstep.framework.MetricsCalculation;
//import com.concord.nextstep.framework.SmokeSuite;
//import com.concord.nextstep.helper.DateTimeHelper;
//
//public class Logger 
//{
//	public static String fileName;
//	public static String folderPath;
//	public static PrintWriter writer;
//	public static PrintWriter HTMLwriter;
//	public static PrintWriter dataWriter;
//	public static StringBuilder buf;
//	public static String html;
//	public static String filePathHTML;
//	public static String metricsHTMLPath;
//	public static String filePath;	
//	public static String metricshtml;
//	public static int count = 0;
//	public static StringBuilder metricsbuf;
//	public static int metricsCount = 0;
//	
//	public static void logInit() throws Exception
//	{
//		String date =DateTimeHelper.GetCurrentTimeAsString();
//		date = date.replace(":","" );
//		date = date.replace("/", "");
//	  	fileName = "DayLog_" +date +".log";	  	
//	  	Date now = new Date();
//	  	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
//	  	String time = dateFormat.format(now);
//	  	//folderPath = "./AutomationLog/" + time ;
//	    folderPath = "./AutomationLog/" + time ;
//	  	Path path = Paths.get(folderPath);
//        //if directory exists?
//        if (!Files.exists(path)) 
//        {
//            try
//            {
//                Files.createDirectories(path);
//            } 
//            catch (IOException e) 
//            {
//                //fail to create directory
//                e.printStackTrace();
//            }
//        }	  	  
//        filePath = folderPath + "\\" + fileName;
//		File file = new File(filePath);
//		writer = new PrintWriter(file,"UTF-8");
//		//Logger.takeScreenShot();
//		//OutputStream os = new FileOutputStream(file);
//		//Writer writer1 = new OutputStreamWriter(os,"UTF-8");
//		//writer1.write("Test");
//	}
//	
//	public static enum messageType 
//	{
//		  Pass, Fail, Warning, Exception
//	}
//	
//	public static void writeDayLog(messageType type, String message) 
//	{		
//		//messageType type = messageType.valueOf(messagetype);
//		switch(type)
//		{
//			case Pass:
//			{
//				writer.println("<INFO>       " + DateTimeHelper.GetCurrentTimeAsString() +"  "+ message );
//				break;
//			}
//			case Fail:
//			{
//				String failedPage = takeScreenShot();
//				writer.println("<FAIL>       " + DateTimeHelper.GetCurrentTimeAsString() +"  "+ message );
//				writer.println("<FAIL>       " + DateTimeHelper.GetCurrentTimeAsString() +"  "+ "screenshot name  "+failedPage );
//				break;
//			}
//			case Warning:
//			{
//				writer.println("<WARNING>    " + DateTimeHelper.GetCurrentTimeAsString() +"  "+ message );
//				break;
//			}
//			case Exception:
//			{
//				String failedPage = takeScreenShot();
//				writer.println("<EXCEPTION>  " + DateTimeHelper.GetCurrentTimeAsString() +"  "+ message );
//				writer.println("<EXCEPTION>       " + DateTimeHelper.GetCurrentTimeAsString() +"  "+ "screenshot name  "+failedPage );
//				break;
//			}
//			default:
//			{
//				
//			}						
//		}			
//		Logger.writer.flush();
//	}
//	
//	public static void writeAllLog(messageType type, String message) throws Exception
//	{
//		writeDayLog(type,message);
//		count ++;
//		buf.append("<tr><td>")
//	       .append(count)
//	       .append("</td><td>")
//	       .append(GlobalVariable.getTC_ID())
//	       .append("</td><td>")
//	       .append(GlobalVariable.getTestCaseDescription())
//	       .append("</td><td>")
//	       .append(App.startTime)
//	       .append("</td><td>")
//	       .append(App.endTime);	       
//
//		 if(GlobalVariable.prop.getProperty("executionType").equals("Metrics"))
//		{
//			if(BusinessLogic.validateTestRun(MetricsCalculation.status))
//			{
//	    	   buf.append("</td><td>")
//		       .append("PASS");
//			}
//			else
//			{
//				buf.append("</td><td>")
//			       .append("FAIL");
//			}	       	       	       
//	       buf.append("</td></tr>");	
//		}
//		else
//		{
//		    if(BusinessLogic.validateTestRun(BusinessLogic.status))
//			{
//	    	   buf.append("</td><td>")
//		       .append("PASS");
//			}
//			else
//			{
//				buf.append("</td><td>")
//			       .append("FAIL");
//			}	       	       	       
//	       buf.append("</td></tr>");
//		}
//	}
//	
//	public static String takeScreenShot() 
//	{
//		try {
//		String date =DateTimeHelper.GetCurrentTimeAsString();
//		date = date.replace(":","" );
//		date = date.replace("/", "");
//	  	//fileName = "DayLog_" +date +".png";
//		String TcId = GlobalVariable.getTC_ID();
//	  	fileName = "screenshot_" +TcId+"_" +date +".png";	
//		TakesScreenshot scrShot =((TakesScreenshot)GlobalVariable.driver);
////		File scrFile = ((TakesScreenshot)GlobalVariable.driver).getScreenshotAs(OutputType.FILE);
//		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//		File DestFile=new File(folderPath+"\\"+fileName);
//		FileUtils.copyFile(SrcFile, DestFile);
//		}
//		catch(Exception e)
//		{
//			
//		}
//		return fileName;
//	}
//	
//	public static void HTMLReportHeader()
//	{
//		buf = new StringBuilder();
//		buf.append("<html>" +
//				   "<header> <h1 align=\"Center\">NEXTSTEP - Automation Report</h1> </header>"+
//		           "<body>" +
//		           "<table border=\"1\" align=\"Center\">  " +
//		           "<tr>" +
//		           "<th>S.No</th>" +
//		           "<th>TestCase ID</th>" +
//		           "<th>TestCase Name</th>" +
//		           "<th>Start Time</th>" +
//		           "<th>End Time</th>" +
//		           "<th>Status</th>" +
//		           "</tr>");
//	}
//	
//	public static void HTMLend() throws FileNotFoundException, UnsupportedEncodingException
//	{
//		buf.append("</table>" +
//		           "</body>" +
//		           "</html>");
//		html = buf.toString();
//		String date =DateTimeHelper.GetCurrentTimeAsString();
//		date = date.replace(":","" );
//		date = date.replace("/", "");
//	  	String HTMLfileName = "DayLog_" +date +".html";	  	
//	  	filePathHTML = folderPath + "\\" + HTMLfileName;
//		File file = new File(filePathHTML);
//		HTMLwriter = new PrintWriter(file,"UTF-8");
//		HTMLwriter.write(html);
//		HTMLwriter.flush();	  	
//	}
//	
//	public static void dataLogInit() throws Exception
//	{
//		String date =DateTimeHelper.GetTimeCustomFormat("dd/MM/yyyy");
//		date = date.replace("/", "");
//	  	fileName = "Datalog_" +date +".log";	
//	  	Date now = new Date();
//	  	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
//	  	String time = dateFormat.format(now);
//	  	folderPath = "./AutomationLog/" + time ;
//	  	Path path = Paths.get(folderPath);
//        //if directory exists?
//        if (!Files.exists(path)) 
//        {
//            try
//            {
//                Files.createDirectories(path);
//            } 
//            catch (IOException e) 
//            {
//                //fail to create directory
//                e.printStackTrace();
//            }
//        }
//        filePath = folderPath + "\\" + fileName;        
//        dataWriter = new PrintWriter(new FileOutputStream(new File(filePath), true));       
//	}
//	
//	public static void writeDataLog(String message) throws Exception
//	{
//		dataLogInit();
//		writer.println("<DATA>" + DateTimeHelper.GetCurrentTimeAsString() +"  "+ message );
//		dataWriter.flush();
//	}
//	
//	public static void dataLogHead()
//	{
//		writer.println("Test case ID: " +GlobalVariable.getTC_ID());
//		writer.println("Test case Description: " +GlobalVariable.getTestCaseDescription());
//	}	
//	public static void MetricsReportHeader()
//	{		
//		String iteration = GlobalVariable.prop.getProperty("MetricsIterationCount");
//		double temp = Double.parseDouble(iteration);
//		GlobalVariable.iterationCount = (int) temp;
//		metricsbuf = new StringBuilder();
//		metricsbuf.append("<html>" +
//				   "<header> <h1 align=\"Center\">NEXTSTEP - Automation Metrics Report</h1> </header>"+
//		           "<body>" +
//		           "<table border=\"1\" align=\"Center\">  " +
//		           "<tr>" +
//		           "<th>S.No</th>" +
//		           "<th>TestCase ID</th>" +
//		           "<th>TestCase Name</th>");
//		         for(int i = 0; i<GlobalVariable.iterationCount ; i++)
//		         {
//		        	 int tempVal = i+1;
//		        	 metricsbuf.append("<th>Iteration "+ tempVal +" </th>" );
//		         }	
//		         metricsbuf.append("<th>Average time Taken</th>");
//		         metricsbuf.append("</tr>");
//	}
//	public static void addTimetaken()
//	{	Float total=(float) 0;
//		metricsCount ++;
//		metricsbuf.append("<tr><td>")
//	       .append(metricsCount)
//	       .append("</td><td>")
//	       .append(GlobalVariable.getTC_ID())
//	       .append("</td><td>")
//	       .append(GlobalVariable.getTestCaseDescription());	       	       
//	       for(int i = 0; i<GlobalVariable.iterationCount ; i++)
//	       {
//	    	   metricsbuf.append("</td><td>")
//	    	   .append(GlobalVariable.executionTime[i] + " (sec)");	        	
//	    	   total = total + Float.parseFloat(GlobalVariable.executionTime[i]);
//	       }			  	      
//	       Float avg = total/GlobalVariable.iterationCount;
//	       metricsbuf.append("</td><td>")
//	       .append(avg + " (sec)");
//	       metricsbuf.append("</td></tr>");
//	}
//	
//	public static void metricsHTMLend() throws FileNotFoundException, UnsupportedEncodingException
//	{
//		metricsbuf.append("</table>" +
//		           "</body>" +
//		           "</html>");
//		metricshtml = metricsbuf.toString();
//		String date =DateTimeHelper.GetCurrentTimeAsString();
//		date = date.replace(":","" );
//		date = date.replace("/", "");
//	  	String HTMLfileName = "MetricsReport_" +date +".html";	  	
//	  	metricsHTMLPath = folderPath + "\\" + HTMLfileName;
//		File file = new File(metricsHTMLPath);
//		HTMLwriter = new PrintWriter(file,"UTF-8");
//		HTMLwriter.write(metricshtml);
//		HTMLwriter.flush();	  	
//	}
//}
