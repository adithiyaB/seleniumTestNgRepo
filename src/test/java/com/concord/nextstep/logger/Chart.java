//package com.concord.nextstep.logger;
//import java.awt.Color;
//import java.io.File;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PiePlot;
//import org.jfree.data.general.DefaultPieDataset;
//
//import com.concord.nextstep.framework.BusinessLogic;
//
//public class Chart 
//{
//	public static int pass, fail, totalTC ;
//	public static double passPer, failPer;
//	public static String path = null;
//   
//   public static void createPieChart() throws Exception 
//   {	 
//	  pass = BusinessLogic.passCount;
//	  fail = BusinessLogic.failCount;
//	  totalTC = pass + fail;
//	  passPer = Math.round(((double)pass/totalTC)*100);
//	  failPer = Math.round(((double)fail/totalTC)*100);
//      DefaultPieDataset dataset = new DefaultPieDataset( );
//     
//      JFreeChart chart = ChartFactory.createPieChart(
//         "Automation Test Run",   // chart title
//         dataset,          // data
//         true,             // include legend
//         true,
//         false);
//               
//      PiePlot renderer = (PiePlot) chart.getPlot();
//      
//      if(pass>0)
//      {
//    	  String passValue = "PASS " + passPer+ "%";
//    	  dataset.setValue(passValue, pass );
//    	  renderer.setSectionPaint(passValue,new Color(46, 204, 113));
//      }
//      if(fail>0)
//      {
//    	  String failValue = "FAIL " + failPer+"%";
//    	  dataset.setValue(failValue, fail);
//    	  renderer.setSectionPaint(failValue, new Color(236, 112, 99));
//      }
//      
//      int width = 640;   /* Width of the image */
//      int height = 480;  /* Height of the image */
//      path = "./AutomationLog/Chart/";
//      File pieChart = new File(path + "PieChart.jpeg" ); 
//      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
//   }
//}