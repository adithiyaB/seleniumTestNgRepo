//package org.ab.pageAction;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.logging.Logs;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import com.concord.nextstep.POM.NextstepFaxInbox;
//import com.concord.nextstep.POM.NextstepNewAdmin;
//import com.concord.nextstep.POM.UserInput;
//import com.concord.nextstep.framework.GlobalVariable;
//import com.concord.nextstep.helper.SeleniumHelper;
//import com.concord.nextstep.logger.Logger;
//
//
//public class NewAdmin 
//{	
//	public static int SNo;
//	public static String TC_ID;
//	public static String TestCaseDescription;
//	public static String BrowserName;
//	public static String baseURL;	
//	public static Boolean launch(String baseURL, String BrowserName) throws Exception
//	{				
//		Boolean status = false;
//		BrowserNameEnum browserOption = BrowserNameEnum.valueOf(BrowserName);		
//		switch(browserOption)
//		{
//		case Firefox:
//		{ 			
// 			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
// 			GlobalVariable.driver = new FirefoxDriver();
//			Logger.writeDayLog(Logger.messageType.Pass, "Successfully Launched Firefox Browser");			
//			status = true;
//			break;
//		}
//		case Chrome:
//		{
//			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
//			GlobalVariable.driver = new ChromeDriver();
//			GlobalVariable.driver.manage().window().maximize();
//			Logger.writeDayLog(Logger.messageType.Pass, "Successfully Launched Chrome Browser");
//			status = true;
//			break;
//		}
//		case Edge:
//		{
//			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
//			GlobalVariable.driver = new EdgeDriver();
//			Logger.writeDayLog(Logger.messageType.Pass, "Successfully Launched Edge Browser");
//			status = true;
//			break;
//		}
//		case IE:
//		{
//			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
//			GlobalVariable.driver = new InternetExplorerDriver();
//			Logger.writeDayLog(Logger.messageType.Pass, "Successfully Launched IE Browser");
//			status = true;
//			break;
//		}
//		case Safari:
//		{
//			System.setProperty("webdriver.safari.noinstall", "true");
//			GlobalVariable.driver = new SafariDriver();		
//			Logger.writeDayLog(Logger.messageType.Pass, "Successfully Launched Safari Browser");
//			status = true;
//			break;
//		}
//		default:
//		{
//			Logger.writeDayLog(Logger.messageType.Fail, "Launching Browser failed, following Test case will fail");			
//			status = false;
//		}
//		}		
//		if(invoke())
//		{
//			status = true;
//		}
//		else
//		{
//			status = false;
//		}
//		return status;		
//	}
//	
//	public static Boolean invoke() throws Exception
//	{
//		Boolean status = false;
//		try
//		{
//			GlobalVariable.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
//			GlobalVariable.driver.navigate().to(GlobalVariable.baseURL);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Navigated browser to " +GlobalVariable.baseURL);
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, "Failed to navigate to " +GlobalVariable.baseURL);		
//		}		
//		return status;
//	}
//	
//	private enum BrowserNameEnum
//	{
//		  Firefox, Chrome, Edge, IE, Safari
//	}
//	
//	
//	public static Boolean clickNewAdminLink() throws Exception
//	{
//		Boolean status=false;
//		WebElement newAdmin = NextstepNewAdmin.newAdminLink();
//		try
//		{
//			if(SeleniumHelper.isExist( newAdmin))
//			{
//				SeleniumHelper.click( newAdmin);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "New Admin link is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click New Admin link");
//		}
//		return status;
//	}
//	public static Boolean clickOldAdminLink() throws Exception
//	{
//		Boolean status=false;
//		WebElement newAdmin = NextstepNewAdmin.oldAdmin();
//		try
//		{
//			if(SeleniumHelper.isExist( newAdmin))
//			{
//				SeleniumHelper.click( newAdmin);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Old Admin link is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Old to click New Admin link");
//		}
//		return status;
//	}
//	
//	public static Boolean clickCompanySettings() throws Exception
//	{
//		Boolean status=false;
//		WebElement company = NextstepNewAdmin.companySettings();
//		try
//		{
//			if(SeleniumHelper.isExist( company))
//			{
//				SeleniumHelper.click( company);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Company Settings is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Company Settings");
//		}
//		return status;
//	}
//	public static Boolean clickWorkflowSettings() throws Exception
//	{
//		Boolean status=false;
//		WebElement workflow = NextstepNewAdmin.workflowSettings();
//		try
//		{
//			if(SeleniumHelper.isExist( workflow))
//			{
//				SeleniumHelper.click( workflow);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Worlflow Settings is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click worlflow Settings");
//		}
//		return status;
//	}
//	public static Boolean clickAddNewWorkflow() throws Exception
//	{
//		Boolean status=false;
//		WebElement newworkflow = NextstepNewAdmin.addNewWorkflow();
//		try
//		{
//			if(SeleniumHelper.isExist( newworkflow))
//			{
//				SeleniumHelper.click( newworkflow);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Add Workflow  is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add Workflow");
//		}
//		return status;
//	}
//	public static Boolean enterWorkflowName(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement name = NextstepNewAdmin.workflowName();
//		try
//		{
//			if(SeleniumHelper.setText( name, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as  WF name");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in WF name");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter WF name");
//		}			
//		return status;
//	}
//	public static Boolean clickFaxNumberDropDown() throws Exception
//	{
//		Boolean status=false;
//		WebElement faxNumberfield = NextstepNewAdmin.faxNumberField();
//		try
//		{
//			if(SeleniumHelper.isExist( faxNumberfield))
//			{
//				SeleniumHelper.click( faxNumberfield);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax Number field is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax Number Field");
//		}
//		return status;
//	}
//	public static Boolean clickFaxNumberValue() throws Exception
//	{
//		Boolean status=false;
//		WebElement faxNumberValue = NextstepNewAdmin.faxNumberValue();
//		try
//		{
//			if(SeleniumHelper.isExist( faxNumberValue))
//			{
//				SeleniumHelper.click( faxNumberValue);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax Number value is selected Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Fax Number value");
//		}
//		return status;
//	}
//	public static Boolean clickSaveWorkflowWithFaxnumber() throws Exception
//	{
//		Boolean status=false;
//		WebElement wfsave = NextstepNewAdmin.saveWorkflow();
//		try
//		{
//			if(SeleniumHelper.isExist( wfsave))
//			{
//				SeleniumHelper.doubleClick( wfsave);
//				Thread.sleep(2000);
//				SeleniumHelper.click( wfsave);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "WF is saved Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to save WF");
//		}
//		return status;
//	}
//	public static Boolean clickSaveWorkflow() throws Exception
//	{
//		Boolean status=false;
//		WebElement wfsave = NextstepNewAdmin.saveWorkflow();
//		try
//		{
//			if(SeleniumHelper.isExist( wfsave))
//			{
//				SeleniumHelper.click( wfsave);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "WF is saved Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to save WF");
//		}
//		return status;
//	}
//	public static Boolean clickWorkflowBackArrow() throws Exception
//	{
//		Boolean status=false;
//		WebElement back = NextstepNewAdmin.workflowbackButton();
//		try
//		{
//			if(SeleniumHelper.isExist( back))
//			{
//				SeleniumHelper.click( back);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "WF back button is clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click WF back button");
//		}
//		return status;
//	}
//	public static Boolean clickCreateCompanyLookupConnection() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(1000);
//		WebElement company = NextstepNewAdmin.createCompanyLookUpConnection();
//		try
//		{
//			if(SeleniumHelper.isExist( company))
//			{
//				SeleniumHelper.click( company);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Create is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Create");
//		}
//		return status;
//	}
//	public static Boolean clickCompanyRetention() throws Exception
//	{
//		Boolean status=false;
//		WebElement company = NextstepNewAdmin.retentiontab();
//		try
//		{
//			if(SeleniumHelper.isExist( company))
//			{
//				SeleniumHelper.click( company);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Retention tab is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Retention tab");
//		}
//		return status;
//	}
//	public static Boolean clickCompanyRetentionSave() throws Exception
//	{
//		Boolean status=false;
//		WebElement company = NextstepNewAdmin.retentionSave();
//		try
//		{
//			if(SeleniumHelper.isExist( company))
//			{
//				SeleniumHelper.click( company);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Retention save is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Retention save");
//		}
//		return status;
//	}
//	public static Boolean clickCompanyPermissionSave() throws Exception
//	{
//		Boolean status=false;
//		WebElement permission = NextstepNewAdmin.permissionSave();
//		try
//		{
//			if(SeleniumHelper.isExist( permission))
//			{
//				SeleniumHelper.click( permission);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Permission save is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Permission save");
//		}
//		return status;
//	}
//	public static Boolean enterRetainAllDocuments(String value) throws Exception
//	{
//		Boolean status = false;
//		//Thread.sleep(3000);
//		WebElement daysBox = NextstepNewAdmin.retainAllDocumentsTextbox();
//		try
//		{
//			if(SeleniumHelper.setText( daysBox, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as days");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in days");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter days");
//		}			
//		return status;
//	}
//	public static Boolean enterConnectioName(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement name = NextstepNewAdmin.connectionName();
//		try
//		{
//			if(SeleniumHelper.setText( name, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as name");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in name");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter name");
//		}			
//		return status;
//	}
//	public static Boolean enterConnectionDataSource(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement data = NextstepNewAdmin.dataSource();
//		try
//		{
//			if(SeleniumHelper.setText( data, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as data source");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in data source");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter data source");
//		}			
//		return status;
//	}
//	public static Boolean enterConnectionInitialCatalog(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement catalog = NextstepNewAdmin.initialCatalog();
//		try
//		{
//			if(SeleniumHelper.setText( catalog, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as initialCatalog");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in initialCatalog");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter initialCatalog");
//		}			
//		return status;
//	}
//	public static Boolean enterConnectionUserId(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement userid = NextstepNewAdmin.userId();
//		try
//		{
//			if(SeleniumHelper.setText( userid, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as userid");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in userid");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter userid");
//		}			
//		return status;
//	}
//	public static Boolean enterConnectionPassword(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement password = NextstepNewAdmin.lookupPassWord();
//		try
//		{
//			if(SeleniumHelper.setText( password, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as password");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in password");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter password");
//		}			
//		return status;
//	}
//	public static Boolean selectProvider() throws Exception
//	{
//		Boolean status=false;
//		WebElement provider = NextstepNewAdmin.selectProvider();
//		try
//		{
//			if(SeleniumHelper.isExist( provider))
//			{
//				SeleniumHelper.click( provider);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Select Provider drop down is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Select Provider drop down");
//		}
//		return status;
//	}
//	public static Boolean selectProviderValue() throws Exception
//	{
//		Boolean status=false;
//		WebElement providerValue = NextstepNewAdmin.selectProviderValue();
//		try
//		{
//			if(SeleniumHelper.isExist( providerValue))
//			{
//				SeleniumHelper.click( providerValue);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Provider value is selected Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Select Provider Value");
//		}
//		return status;
//	}
//	public static Boolean clickConnectionCreateButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement create = NextstepNewAdmin.createCompanyConnection();
//		try
//		{
//			if(SeleniumHelper.isExist( create))
//			{
//				SeleniumHelper.click( create);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Company Connection is created Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to create Company Connection");
//		}
//		return status;
//	}
//	public static Boolean clickConnectionUpdateButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement providerValue = NextstepNewAdmin.updateCompanyConnection();
//		try
//		{
//			if(SeleniumHelper.isExist( providerValue))
//			{
//				SeleniumHelper.click( providerValue);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Company Connection is updated Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to update Company Connection");
//		}
//		return status;
//	}
//	public static Boolean clickConnectionCreatedOkButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement ok = NextstepNewAdmin.createCompanyConnectionCreatedOkButton();
//		try
//		{
//			if(SeleniumHelper.isExist( ok))
//			{
//				SeleniumHelper.click( ok);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "ok button is clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click ok button");
//		}
//		return status;
//	}
//	public static Boolean clickConnectionDeleteOkButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement ok = NextstepNewAdmin.companyConnectionDeleteOkButton();
//		try
//		{
//			if(SeleniumHelper.isExist(ok))
//			{
//				SeleniumHelper.click(ok);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "ok button is clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click ok button");
//		}
//		return status;
//	}
//	public static Boolean clickConnectionBackToListButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement list = NextstepNewAdmin.companyConnectionBacktoListButton();
//		try
//		{
//			if(SeleniumHelper.isExist( list))
//			{
//				SeleniumHelper.click( list);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Back to List button is clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Back to List button");
//		}
//		return status;
//	}
//	
//	public static Boolean clickConnectionEditButton() throws Exception
//	{
//		Boolean status=false;
//		List<WebElement> edit = NextstepNewAdmin.getCompanyLookUpEditButtons();
//		try
//		{
//			for(int i=0;i<=edit.size();i++)
//			{
//				WebElement test = edit.get(i);
//				if (SeleniumHelper.isExist( test)) 
//				{
//					SeleniumHelper.click( test);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "edit button is clicked Sucessfully");
//					break;
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//				
//			}
//			
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click edit button");
//		}
//		return status;
//	}
//	public static Boolean clickConnectionDeleteButton() throws Exception
//	{
//		Boolean status=false;
//		List<WebElement> delete = NextstepNewAdmin.getCompanyLookUpDeleteButtons();
//		try
//		{
//			for(int i=0;i<=delete.size();i++)
//			{
//				WebElement test = delete.get(i);
//				if (SeleniumHelper.isExist( test)) 
//				{
//					SeleniumHelper.click( test);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "delete button is clicked Sucessfully");
//					break;
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//				
//			}
//			
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click delete button");
//		}
//		return status;
//	}
//	public static Boolean clickCompanyPermission() throws Exception
//	{
//		Boolean status=false;
//		WebElement company = NextstepNewAdmin.Permission();
//		try
//		{
//			if(SeleniumHelper.isExist(company))
//			{
//				SeleniumHelper.click(company);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Permission tab is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Permission tab");
//		}
//		return status;
//	}
//	
//	public static Boolean enterUserName(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement userNameBox = NextstepNewAdmin.getUserNameInputBox();		
//		try
//		{
//			while(!(userNameBox.isDisplayed()))
//			{
//				Thread.sleep(1000);
//			}
//			if(SeleniumHelper.setText( userNameBox, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as UserName");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in UserName");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter UserName");
//		}			
//		return status;
//	}
//	
//	public static Boolean enterPassword(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement passwordBox = NextstepFaxInbox.getPasswordInputBox();
//		try
//		{
//			if(SeleniumHelper.setText( passwordBox, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as Password");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in Password");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter Password");
//		}			
//		return status;
//	}
//	public static Boolean clickLogin() throws Exception
//	{
//		Boolean status = false;
//		WebElement temp = NextstepNewAdmin.getLoginButton();
//		try
//		{			
//			if(SeleniumHelper.isExist(temp))
//			{
//				SeleniumHelper.click(temp);
//				waitForPageLoad();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Login is Clicked Sucessfully");
//			}
//			else
//			{
//				throw new Exception();
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Login" + e.getStackTrace());
//		}
//		return status;				
//	}
//	public static Boolean clickLogout() throws Exception
//	{
//		Boolean status = false;
//		WebElement logout = NextstepNewAdmin.getLogoutButton();
//		try
//		{
//			if(SeleniumHelper.isExist( logout))
//			{
//				SeleniumHelper.click( logout);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Logout is Clicked Sucessfully");
//			}
//			else
//			{
//				throw new Exception();
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Logout" + e.getStackTrace());
//		}
//		return status;				
//	}
//	public static Boolean clickLogoutConfirmButton() throws Exception
//	{
//		Boolean status = false;
//		WebElement confirm = NextstepNewAdmin.getLogoutConfirmButton();
//		try
//		{			
//			SeleniumHelper.click(confirm);
//			waitForPageLoad();
//			if(ValidateLogout())
//			{
//				//SeleniumHelper.click( confirm);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Logout is Clicked Sucessfully");
//			}
//			else
//			{
//				throw new Exception();
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Logout" + e.getStackTrace());
//		}
//		return status;				
//	}
//	public static Boolean waitForPageLoad() throws Exception
//	{
//		Boolean status = false;
//		WebElement allPageLoader = null;
//		try
//		{
//			allPageLoader = NextstepNewAdmin.getLoadingSpinner();	
//			WebElement temp = NextstepNewAdmin.getLogoutButton();
//			SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, allPageLoader);		
//			SeleniumHelper.waitUntilControlNotExist( GlobalVariable.driver,temp);		
//			WebElement austria = new WebDriverWait(GlobalVariable.driver, 10).until(ExpectedConditions.elementToBeClickable(temp));
//			Logger.writeDayLog(Logger.messageType.Pass, "Page loaded successfully");
//			Thread.sleep(2000);
//			status = true;
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//		}
//		return status;
//	}
//	public static Boolean verifyUserName() throws Exception
//	{
//		Boolean status = false;
//		try
//		{
//			WebElement userName = NextstepFaxInbox.getLoggedUserName();
//			String name = userName.getText();
//			if(name != null)
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, name +" is Logged user");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, "Logged user name is empty");
//			}
//		}
//		catch(Exception e)
//		{
//			Logger.writeDayLog(Logger.messageType.Exception,e.getMessage());
//		}
//		return status;
//	}
//	public static Boolean ValidateLogout() throws Exception 
//	{
//		Boolean status = false;
//		try
//		{
//			if (SeleniumHelper.isExist( NextstepNewAdmin.getUserNameInputBox())) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Appliation logged out Sucessfully");
//			} 
//			else
//			{
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Appliation not logged out" + e.getStackTrace());
//		}
//		return status;
//	}
//	public static Boolean verifyHomePage() throws Exception
//	{
//		Boolean status = false;
//		try
//		{
//			WebElement deptHeader  = NextstepNewAdmin.getDepartmentHead();
//			Logger.writeDayLog(Logger.messageType.Pass, "Waiting for Department header element");
//			SeleniumHelper.waitForControl( deptHeader);
//			Logger.writeDayLog(Logger.messageType.Pass, "Department header element found");
//			status = true;
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Department header element not found");
//		}		
//		return status;
//	}
//	public static Boolean killDriver() throws Exception
//	{
//		Boolean status = false;
//		try
//		{						
//			GlobalVariable.driver.close();			
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Browser is killed successfully");
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to kill Browser driver" + e.getStackTrace());
//		}
//		return status;
//	}
//	public static Boolean selectCompanyPermission(String name) throws Exception 
//	{
//		Boolean status = false;
//		WebElement permission = NextstepNewAdmin.getCompanyPermission(name);
//		try 
//		{
//			if (SeleniumHelper.isExist( permission)) 
//			{
//				SeleniumHelper.click( permission);
//				Logger.writeDayLog(Logger.messageType.Pass, "Permission is selected successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Permission is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean selectGridPagination(String name) throws Exception 
//	{
//		Boolean status = false;
//		WebElement pagination = NextstepNewAdmin.getGridPagination( name);
//		try 
//		{
//			if (SeleniumHelper.isExist( pagination)) 
//			{
//				SeleniumHelper.click( pagination);
//				Logger.writeDayLog(Logger.messageType.Pass, "pagination is selected successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "pagination is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean selectWorkflow(String name) throws Exception 
//	{
//		Boolean status = false;
//		WebElement wfName = NextstepNewAdmin.getWorkflowName(name);
//		WebElement wfRow = NextstepNewAdmin.getWorkflowRow(name);
//		SeleniumHelper.click( wfRow);
//		try 
//		{
//			if (SeleniumHelper.isExist(wfName)) 
//			{
//				SeleniumHelper.doubleClick(wfName);
//				Logger.writeDayLog(Logger.messageType.Pass, "Workflow is selected successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Workflow is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean clickWorkflowDeleteButton(String name) throws Exception 
//	{
//		Boolean status = false;
//		WebElement wfDelete = NextstepNewAdmin.getWorkflowDeleteButton( name);
//		WebElement wfRow = NextstepNewAdmin.getWorkflowRow( name);
//		SeleniumHelper.click( wfRow);
//		try 
//		{
//			if (SeleniumHelper.isExist( wfDelete)) 
//			{
//				SeleniumHelper.click( wfDelete);
//				Logger.writeDayLog(Logger.messageType.Pass, "Workflow delete button is clicked successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Workflow delete is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean clickWorkflowDeleteOkButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement ok = NextstepNewAdmin.getLogoutConfirmButton();
//		try 
//		{
//			if (SeleniumHelper.isExist( ok)) 
//			{
//				SeleniumHelper.click( ok);
//				Logger.writeDayLog(Logger.messageType.Pass, "ok button is clicked successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "ok button is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean clickWorkflowStreamingButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement stream = NextstepNewAdmin.getWorkflowStreamingButton();
//		try 
//		{
//			if (SeleniumHelper.isExist( stream)) 
//			{
//				SeleniumHelper.click( stream);
//				Logger.writeDayLog(Logger.messageType.Pass, "Streaming Button button is clicked successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Streaming Button button is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean clickWorkflowOverrideButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement override = NextstepNewAdmin.getWorkflowOverrideButton();
//		try 
//		{
//			if (SeleniumHelper.isExist( override)) 
//			{
//				SeleniumHelper.click( override);
//				Logger.writeDayLog(Logger.messageType.Pass, "Override Button button is clicked successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Override Button button is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean clickWorkflowOverrideOkButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement ok = NextstepNewAdmin.getLogoutConfirmButton();
//		try 
//		{
//			if (SeleniumHelper.isExist( ok)) 
//			{
//				SeleniumHelper.click( ok);
//				Logger.writeDayLog(Logger.messageType.Pass, "ok button is clicked successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "ok button is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean clickUserSettings() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.userSettings();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "User Settings is Clicked Sucessfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click User Settings");
//           }
//           return status;
//    }
//    public static Boolean clickUserSearchDropDown() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserSearchDropDown();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "User Search drop down is Clicked Sucessfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click User search drop down");
//           }
//           return status;
//    }      
//    public static Boolean clickUserSearchDropDownSetNoFilter() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserSearchDropDownSetNoFilter();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "User Search drop down is set to no filter");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to set User search drop down as no filter");
//           }
//           return status;
//    }      
//    public static Boolean clickUserSearchDropDownSetName() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserSearchDropDownSetName();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "User Search drop down is set to name");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to set User search drop down as name");
//           }
//           return status;
//    }      
//    public static Boolean clickUserSearchDropDownSetEmail() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserSearchDropDownSetEmail();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "User Search drop down is set to Email");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to set User search drop down as Email");
//           }
//           return status;
//    }      
//    public static Boolean clickUserSearchDropDownSetFaxNumber() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserSearchDropDownSetFaxNumber();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "User Search drop down is set to Fax Number");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to set User search drop down as Fax Number");
//           }
//           return status;
//    }
//    public static Boolean enterUserSearchText(String value) throws Exception
//    {
//           Boolean status = false;
//           WebElement name = NextstepNewAdmin.getUserSearchTextBox();
//           try
//           {
//                  if(SeleniumHelper.setText( name, value))
//                  {                          
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as search text in user");
//                  }
//                  else
//                  {
//                        status = false;
//                        Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as search text in user");
//                  }
//           }
//           catch(Exception e)
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter search text in user");
//           }                    
//           return status;
//    }
//    public static Boolean clickUserSearchButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserSearchButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "User Search is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click user search button");
//           }
//           return status;
//    }
//    public static Boolean validateUserSearchResult(List<WebElement> t, String input)
//    {
//           Boolean status = false;
//           try
//           {
//                  if(t.size()<=0)
//                  {
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "No data found");
//                  }
//                  else if(t.size()>0)
//                  {
//                        for(int i=0;i<t.size();i++)
//                        {                          
//                               if(!(t.get(i).getText().contains(input)))
//                               {
//                                      status = false;
//                                      Logger.writeDayLog(Logger.messageType.Exception, "Failed in user search validation");
//                                      return status;
//                               }
//                        }
//                        Logger.writeDayLog(Logger.messageType.Pass, "Validation succesful");
//                        status = true;
//                  }
//                  else
//                  {
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e)
//           {
//                  Logger.writeDayLog(Logger.messageType.Exception, "Failed in user search validation");
//                  status = false;
//           }                          
//           return status;
//    }
//    public static Boolean clickWFSearchDropDownSetName() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getWFSearchDropDownSetName();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Workflow drop down is set to Name");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to set workflow drop down as Name");
//           }
//           return status;
//    }
//    public static Boolean clickCreateTag() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getCreateTag();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Create tag is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create tag");
//           }
//           return status;
//    }
//    public static Boolean clickEditTag() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getEditTag();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Edit tag is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click edit tag");
//           }
//           return status;
//    }
//    public static Boolean clickDeleteTag() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getDeleteTag();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Delete tag is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Delete tag");
//           }
//           return status;
//    }
//    public static Boolean clickSaveTag() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUpdateTag();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Save/update tag is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save/update tag");
//           }
//           return status;
//    }
//    public static Boolean clickCancelTag() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getCancelTag();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Cancel tag is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Cancel tag");
//           }
//           return status;
//    }
//    public static Boolean enterTagsName(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement name = NextstepNewAdmin.getCreateTagTextBox();
//		try
//		{
//			if(SeleniumHelper.setText( name, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as  tag name");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in tag name");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter tag name");
//		}			
//		return status;
//	}
//    public static Boolean gotoWFPropertiesTab() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getWFProperitesTab();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "WF properties is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click WF properties");
//           }
//           return status;
//    }
//    public static Boolean mouseHoverTagList(String input) throws Exception
//    {
//           Boolean status = false;
//           List<WebElement> tagsList = NextstepNewAdmin.getTagsList();
//           try
//           {
//                  if(tagsList.size()<=0)
//                  {
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "No tags found");
//                  }
//                  else if(tagsList.size()>0)
//                  {
//                	   	for(int i=0;i<tagsList.size();i++)
//                        {                          
//                               if((tagsList.get(i).getText().contains(input)))
//                               {
//                            	   	Actions builder = new Actions(GlobalVariable.driver);
//                       				Action hover = builder.moveToElement(tagsList.get(i)).build();
//                       				hover.perform();
//                                    status = true;
//                                    Logger.writeDayLog(Logger.messageType.Exception, tagsList.get(i).getText()+ " tag is highlighted");                                    
//                               }
//                        }                       
//                  }
//                  else
//                  {
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e)
//           {
//                  Logger.writeDayLog(Logger.messageType.Exception, "Failed to hover tag");
//                  status = false;
//           }                          
//           return status;
//    }
//    
//    public static Boolean clickCreateStatus() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getCreateStatus();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Create status is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create status");
//           }
//           return status;
//    }
//    public static Boolean clickEditStatus() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getEditStatus();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Edit status is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click edit status");
//           }
//           return status;
//    }
//    public static Boolean clickDeleteStatus() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getDeleteStatus();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Delete status is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Delete status");
//           }
//           return status;
//    }
//    public static Boolean clickSaveStatus() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUpdateStatus();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Save/update status is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save/update status");
//           }
//           return status;
//    }
//    public static Boolean clickCancelStatus() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getCancelStatus();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Cancel status is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Cancel status");
//           }
//           return status;
//    }
//    public static Boolean enterStatusName(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement name = NextstepNewAdmin.getCreateStatusTextBox();
//		try
//		{
//			if(SeleniumHelper.setText( name, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as  status name");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in status name");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter status name");
//		}			
//		return status;
//	}
//    public static Boolean mouseHoverDocumentStatusList(String input) throws Exception
//    {
//           Boolean status = false;
//           List<WebElement> statusList = NextstepNewAdmin.getStatusList();
//           try
//           {
//                  if(statusList.size()<=0)
//                  {
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "No document status found");
//                  }
//                  else if(statusList.size()>0)
//                  {
//                	   	for(int i=0;i<statusList.size();i++)
//                        {                          
//                               if((statusList.get(i).getText().contains(input)))
//                               {
//                            	   	Actions builder = new Actions(GlobalVariable.driver);
//                       				Action hover = builder.moveToElement(statusList.get(i)).build();
//                       				hover.perform();
//                                    status = true;
//                                    Logger.writeDayLog(Logger.messageType.Exception, statusList.get(i).getText()+ " document status is highlighted");                                    
//                               }
//                        }                       
//                  }
//                  else
//                  {
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e)
//           {
//                  Logger.writeDayLog(Logger.messageType.Exception, "Failed to hover document status");
//                  status = false;
//           }                          
//           return status;
//    }
//    public static Boolean clickdeleteConfirmation() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getLogoutConfirmButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Delete confirmation is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Delete confirmation");
//           }
//           return status;
//    }    
//    public static Boolean clickCreateFolder() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getCreateFolder();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Create Folder is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create Folder");
//           }
//           return status;
//    }
//    public static Boolean clickEditFolder() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getEditFolder();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Edit Folder is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click edit Folder");
//           }
//           return status;
//    }
//    public static Boolean clickDeleteFolder() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getDeleteFolder();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Delete Folder is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Delete Folder");
//           }
//           return status;
//    }
//    public static Boolean clickSaveFolder() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUpdateFolder();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Save/update Folder is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save/update Folder");
//           }
//           return status;
//    }
//    public static Boolean clickCancelFolder() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getCancelFolder();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Cancel Folder is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Cancel Folder");
//           }
//           return status;
//    }
//    public static Boolean enterFolderName(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement name = NextstepNewAdmin.getCreateFolderTextBox();
//		try
//		{
//			if(SeleniumHelper.setText( name, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as  Folder name");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in Folder name");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter Folder name");
//		}			
//		return status;
//	}
//    
//    public static Boolean mouseHoverFolderList(String input) throws Exception
//    {
//           Boolean status = false;
//           List<WebElement> folderList = NextstepNewAdmin.getFolderList();
//           try
//           {
//                  if(folderList.size()<=0)
//                  {
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "No Folder found");
//                  }
//                  else if(folderList.size()>0)
//                  {
//                	   	for(int i=0;i<folderList.size();i++)
//                        {                          
//                               if((folderList.get(i).getText().contains(input)))
//                               {
//                            	   	Actions builder = new Actions(GlobalVariable.driver);
//                       				Action hover = builder.moveToElement(folderList.get(i)).build();
//                       				hover.perform();
//                                    status = true;
//                                    Logger.writeDayLog(Logger.messageType.Exception, folderList.get(i).getText()+ " Folder is highlighted");                                    
//                               }
//                        }                       
//                  }
//                  else
//                  {
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e)
//           {
//                  Logger.writeDayLog(Logger.messageType.Exception, "Failed to hover Folder");
//                  status = false;
//           }                          
//           return status;
//    }
//    public static Boolean clickWfFieldsTab() throws Exception
//    {
//           Boolean status=false;
//           WebElement field = NextstepNewAdmin.getWFFieldsTab();
//           try
//           {
//                  if(SeleniumHelper.isExist( field))
//                  {
//                        SeleniumHelper.click( field);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Workflow Field tab is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to set workflow Field tab");
//           }
//           return status;
//    }
//    public static Boolean clickAddFields() throws Exception
//    {
//           Boolean status=false;
//           WebElement addField = NextstepNewAdmin.getAddField();
//           try
//           {
//                  if(SeleniumHelper.isExist( addField))
//                  {
//                        SeleniumHelper.click( addField);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Add Field is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add Field");
//           }
//           return status;
//    }
//    public static Boolean enterFieldName(String value) throws Exception
//    {
//           Boolean status = false;
//           WebElement name = NextstepNewAdmin.getFieldTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist( name))
//                  {      
//                           SeleniumHelper.setText( name, value);                
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as field name");
//                  }
//                  else
//                  {
//                        status = false;
//                        Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as field name");
//                  }
//           }
//           catch(Exception e)
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter search text in field name");
//           }                    
//           return status;
//    }
//    public static Boolean clickSaveField() throws Exception
//    {
//           Boolean status=false;
//           WebElement saveField = NextstepNewAdmin.getFieldSaveButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( saveField))
//                  {
//                        SeleniumHelper.click( saveField);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Save Field is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save Field");
//           }
//           return status;
//    }
//    public static Boolean hoverFieldEditIcon() throws Exception 
//    {
//    	Boolean status = false;
//        WebElement fieldHover = NextstepNewAdmin.getFieldHoverArea();
//        try
//        {
//        	Actions builder = new Actions(GlobalVariable.driver);
//            Action hover = builder.moveToElement(fieldHover).build();
//            hover.perform();
//            status = true;
//            Logger.writeDayLog(Logger.messageType.Pass, "Mouse hover field is passed");
//        } 
//        catch (Exception e) 
//        {
//        	status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Mouse hover field failed");
//        }
//        return status;
//    }
//    public static Boolean clickEditField() throws Exception
//    {
//           Boolean status=false;
//           WebElement editField = NextstepNewAdmin.getFieldEditButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( editField))
//                  {
//                        SeleniumHelper.click( editField);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Edit Field is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click edit Field");
//           }
//           return status;
//    }
//    public static Boolean clickDeleteField() throws Exception
//    {
//           Boolean status=false;
//           WebElement deleteField = NextstepNewAdmin.getFieldDeleteButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( deleteField))
//                  {
//                        SeleniumHelper.click( deleteField);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Delete Field is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click delete Field");
//           }
//           return status;
//    }
//    public static Boolean selectUserFromGrid() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> userRow = NextstepNewAdmin.getUserListFromGrid();		
//		try 
//		{
//			if (SeleniumHelper.isExist(userRow.get(1))) 
//			{
//				SeleniumHelper.doubleClick(userRow.get(1));
//				Logger.writeDayLog(Logger.messageType.Pass, "User is selected successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "User is not selected");
//			status = false;
//		}
//		return status;
//	}
//    public static Boolean clickUserSaveFolder() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserUpdateFolder();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Save/update Folder is clicked successfully in User setting");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save/update Folder in User setting");
//           }
//           return status;
//    }    
//    public static Boolean clickBackToUserGrid() throws Exception
//	{
//		Boolean status=false;
//		WebElement back = NextstepNewAdmin.getUserBackButton();
//		try
//		{
//			if(SeleniumHelper.isExist( back))
//			{
//				SeleniumHelper.click( back);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "User Settings back button is clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click User Settings back button");
//		}
//		return status;
//	}
//    public static Boolean mouseHoverUserFolderList(String input) throws Exception
//    {
//           Boolean status = false;
//           List<WebElement> folderList = NextstepNewAdmin.getUserFolderList();
//           try
//           {
//                  if(folderList.size()<=0)
//                  {
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "No Folder found");
//                  }
//                  else if(folderList.size()>0)
//                  {
//                	   	for(int i=0;i<folderList.size();i++)
//                        {                          
//                               if((folderList.get(i).getText().contains(input)))
//                               {
//                            	   	Actions builder = new Actions(GlobalVariable.driver);
//                       				Action hover = builder.moveToElement(folderList.get(i)).build();
//                       				hover.perform();
//                                    status = true;
//                                    Logger.writeDayLog(Logger.messageType.Exception, folderList.get(i).getText()+ " Folder is highlighted");                                    
//                               }
//                        }                       
//                  }
//                  else
//                  {
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e)
//           {
//                  Logger.writeDayLog(Logger.messageType.Exception, "Failed to hover Folder");
//                  status = false;
//           }                          
//           return status;
//    }
//    public static Boolean clickUserEditFolder() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserEditFolder();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Edit Folder is clicked successfully in User settings");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click edit Folder in User settings");
//           }
//           return status;
//    }   
//    public static Boolean clickUserDeleteFolder() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getUserDeleteFolder();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Delete Folder is clicked successfully in User settings");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Delete Folder in User settings");
//           }
//           return status;
//    }
//    public static Boolean clickAddWorkflowToUser() throws Exception
//	{
//		Boolean status=false;
//		WebElement back = NextstepNewAdmin.getAddWorkflowToUser();
//		try
//		{
//			if(SeleniumHelper.isExist( back))
//			{
//				SeleniumHelper.click( back);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Add Workflow to user button is clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add Workflow to user button");
//		}
//		return status;
//	}
//    public static Boolean enterWorkflowNameInUserSettingAdd(String value) throws Exception   
//   	{
//   		Boolean status = false;
//   		WebElement name = NextstepNewAdmin.getAddWorkflowToUserEditBox();
//   		try
//   		{
//   			if(SeleniumHelper.setText( name, value))
//   			{	
//   				List<WebElement> WFList = NextstepNewAdmin.getAddWFSuggestionList();
//   				for(int i=0;i<WFList.size();i++)
//   				{
//   					if(WFList.get(i).getText().contains(value))
//   					{
//   						SeleniumHelper.click( WFList.get(i));
//   						break;
//   					}
//   				}   				
//   				status = true;
//   				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as Workflow name in user setting");
//   			}
//   			else
//   			{
//   				status = false;
//   				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered inuser setting");
//   			}
//   		}
//   		catch(Exception e)
//   		{
//   			status = false;
//   			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter Workflow name in user setting");
//   		}			
//   		return status;
//   	}
//    public static Boolean clickAddWFToUserSave() throws Exception
//   	{
//   		Boolean status=false;
//   		WebElement back = NextstepNewAdmin.getAddWFToUserSave();
//   		try
//   		{
//   			if(SeleniumHelper.isExist( back))
//   			{
//   				SeleniumHelper.click( back);
//   				status = true;
//   				Logger.writeDayLog(Logger.messageType.Pass, "Add Workflow to user button is clicked Sucessfully");
//   			}
//   			else
//   			{
//   				status = false;
//   				throw new Exception();
//   			}
//   		}
//   		catch(Exception e) 
//   		{
//   			status = false;
//   			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add Workflow to user button");
//   		}
//   		return status;
//   	}
//    
//    public static Boolean mouseHoverUserWFList(String input) throws Exception
//    {
//           Boolean status = false;
//           List<WebElement> wfList = NextstepNewAdmin.getUserWFList();
//           try
//           {
//                  if(wfList.size()<=0)
//                  {
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "No WF found");
//                  }
//                  else if(wfList.size()>0)
//                  {
//                	   	for(int i=0;i<wfList.size();i++)
//                        {                          
//                               if((wfList.get(i).getText().contains(input)))
//                               {
//                            	   	Actions builder = new Actions(GlobalVariable.driver);
//                       				Action hover = builder.moveToElement(wfList.get(i)).build();
//                       				hover.perform();
//                                    status = true;
//                                    Logger.writeDayLog(Logger.messageType.Exception, wfList.get(i).getText()+ " Workflow is highlighted");                                    
//                               }
//                        }                       
//                  }
//                  else
//                  {
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e)
//           {
//                  Logger.writeDayLog(Logger.messageType.Exception, "Failed to hover Workflow");
//                  status = false;
//           }                          
//           return status;
//    }
//    public static Boolean clickSaveUserSetting() throws Exception
//	{
//		Boolean status=false;
//		WebElement wfsave = NextstepNewAdmin.getSaveUserSetting();
//		try
//		{
//			if(SeleniumHelper.isExist( wfsave))
//			{
//				SeleniumHelper.click( wfsave);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "User settings is saved Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to save User settings");
//		}
//		return status;
//	}
//    public static Boolean clickUserSettingsOverrideButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement override = NextstepNewAdmin.getUserSettingsOverrideButton();
//		try 
//		{
//			if (SeleniumHelper.isExist( override)) 
//			{
//				SeleniumHelper.click( override);
//				Logger.writeDayLog(Logger.messageType.Pass, "Override Button button is clicked successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Override Button button is not selected");
//			status = false;
//		}
//		return status;
//	}
//    public static Boolean clickUserSettingsRemoveWorkflow() throws Exception
//	{
//		Boolean status=false;
//		WebElement wfsave = NextstepNewAdmin.getUserSettingsRemoveWorkflow();
//		try
//		{
//			if(SeleniumHelper.isExist( wfsave))
//			{
//				SeleniumHelper.click( wfsave);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "User settings is saved Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to save User settings");
//		}
//		return status;
//	}
//    public static Boolean gotoWFUsersTab() throws Exception
//    {
//           Boolean status=false;
//           WebElement workflow = NextstepNewAdmin.getWFUsersTab();
//           try
//           {
//                  if(SeleniumHelper.isExist( workflow))
//                  {
//                        SeleniumHelper.click( workflow);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Users tab is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click add user tab");
//           }
//           return status;
//    }
//    
//    //
//    public static Boolean clickAddUserToWF() throws Exception
//	{
//		Boolean status=false;
//		WebElement back = NextstepNewAdmin.getAddUserToWF();
//		try
//		{
//			if(SeleniumHelper.isExist( back))
//			{
//				SeleniumHelper.click( back);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Add user to Workflow button is clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add user to Workflow  button");
//		}
//		return status;
//	}
//    public static Boolean enterUserNameInWFSettingAdd(String value) throws Exception   
//   	{
//   		Boolean status = false;
//   		WebElement name = NextstepNewAdmin.getAddUserToWFEditBox();
//   		try
//   		{
//   			if(SeleniumHelper.setText( name, value))
//   			{	
//   				List<WebElement> WFList = NextstepNewAdmin.getAddUserSuggestionList();
//   				for(int i=0;i<WFList.size();i++)
//   				{
//   					if(WFList.get(i).getText().contains(value))
//   					{
//   						SeleniumHelper.click( WFList.get(i));
//   						break;
//   					}
//   				}   				
//   				status = true;
//   				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as User name in Workflow setting");
//   			}
//   			else
//   			{
//   				status = false;
//   				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in Workflow setting");
//   			}
//   		}
//   		catch(Exception e)
//   		{
//   			status = false;
//   			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter User name in WF setting");
//   		}			
//   		return status;
//   	}
//    public static Boolean clickAddUserToWFSave() throws Exception
//   	{
//   		Boolean status=false;
//   		WebElement back = NextstepNewAdmin.getAddUserToWFSave();
//   		try
//   		{
//   			if(SeleniumHelper.isExist( back))
//   			{
//   				SeleniumHelper.click( back);
//   				status = true;
//   				Logger.writeDayLog(Logger.messageType.Pass, "Add User to wf button is clicked Sucessfully");
//   			}
//   			else
//   			{
//   				status = false;
//   				throw new Exception();
//   			}
//   		}
//   		catch(Exception e) 
//   		{
//   			status = false;
//   			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add user to wf button");
//   		}
//   		return status;
//   	}
//    
//    public static Boolean mouseHoverWFUserList(String input) throws Exception
//    {
//           Boolean status = false;
//           List<WebElement> wfList = NextstepNewAdmin.getUserWFList();
//           try
//           {
//                  if(wfList.size()<=0)
//                  {
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "No User found");
//                  }
//                  else if(wfList.size()>0)
//                  {
//                	   	for(int i=0;i<wfList.size();i++)
//                        {                          
//                               if((wfList.get(i).getText().contains(input)))
//                               {
//                            	   	Actions builder = new Actions(GlobalVariable.driver);
//                       				Action hover = builder.moveToElement(wfList.get(i)).build();
//                       				hover.perform();
//                                    status = true;
//                                    Logger.writeDayLog(Logger.messageType.Exception, wfList.get(i).getText()+ " User is highlighted");                                    
//                               }
//                        }                       
//                  }
//                  else
//                  {
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e)
//           {
//                  Logger.writeDayLog(Logger.messageType.Exception, "Failed to hover user");
//                  status = false;
//           }                          
//           return status;
//    }
//    public static Boolean clickSaveWFSetting() throws Exception
//	{
//		Boolean status=false;
//		WebElement wfsave = NextstepNewAdmin.getSaveWFUserSetting();
//		try
//		{
//			if(SeleniumHelper.isExist( wfsave))
//			{
//				SeleniumHelper.click( wfsave);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "User settings is saved Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to save User settings");
//		}
//		return status;
//	}
//    public static Boolean clickWFSettingsRemoveUser() throws Exception
//   	{
//   		Boolean status=false;
//   		WebElement wfsave = NextstepNewAdmin.getWFSettingsRemoveUser();
//   		try
//   		{
//   			if(SeleniumHelper.isExist( wfsave))
//   			{
//   				SeleniumHelper.click( wfsave);
//   				status = true;
//   				Logger.writeDayLog(Logger.messageType.Pass, "WF settings user remove is clicked Sucessfully");
//   			}
//   			else
//   			{
//   				status = false;
//   				throw new Exception();
//   			}
//   		}
//   		catch(Exception e) 
//   		{
//   			status = false;
//   			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click remove user in WF settings");
//   		}
//   		return status;
//   	}    
//    public static Boolean clickWfLookupTab() throws Exception
//    {
//           Boolean status=false;
//           WebElement lookup = NextstepNewAdmin.getWFLookupTab();
//           try
//           {
//                  if(SeleniumHelper.isExist( lookup))
//                  {
//                        SeleniumHelper.click( lookup);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Workflow lookup tab is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click workflow lookup tab");
//           }
//           return status;
//    }
//    public static Boolean clickWfLookupCreateButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement create = NextstepNewAdmin.getWFCreateLookupButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( create))
//                  {
//                        SeleniumHelper.click( create);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "create is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create button");
//           }
//           return status;
//    }
//    public static Boolean enterLookupName(String value) throws Exception
//    {
//           Boolean status = false;
//           WebElement name = NextstepNewAdmin.getWFEnterLookupName();
//           try
//           {
//                  if(SeleniumHelper.isExist( name))
//                  {      
//                           SeleniumHelper.setText( name, value);                
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as lookup name");
//                  }
//                  else
//                  {
//                        status = false;
//                        Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as lookup name");
//                  }
//           }
//           catch(Exception e)
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter search text in lookup name");
//           }                    
//           return status;
//    }
//    public static Boolean clickConnection() throws Exception
//       {
//              Boolean status=false;
//              WebElement connection = NextstepNewAdmin.getWFSelectConnection();
//              try
//              {
//                     if(SeleniumHelper.isExist( connection))
//                     {
//                           SeleniumHelper.click( connection);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "Select connection drop down is Clicked Sucessfully");
//                     }
//                     else
//                     {
//                           status = false;
//                           throw new Exception();
//                     }
//              }
//              catch(Exception e) 
//              {
//                     status = false;
//                     Logger.writeDayLog(Logger.messageType.Exception, "Unable to select connection drop down");
//              }
//              return status;
//       }
//    public static Boolean selectConnectionValue() throws Exception
//       {
//              Boolean status=false;
//              WebElement connectionValue = NextstepNewAdmin.getWFConnectionValue();
//              try
//              {
//                    if(SeleniumHelper.isExist( connectionValue))
//                    {
//                           SeleniumHelper.click( connectionValue);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "connectionValue is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select connectionValue");
//              }
//              return status;
//       }
//    public static Boolean clickResource() throws Exception
//       {
//              Boolean status=false;
//              Thread.sleep(2000);
//              WebElement resource = NextstepNewAdmin.getWFSelectResource();
//              try
//              {
//                     if(SeleniumHelper.isExist( resource))
//                     {
//                           SeleniumHelper.click( resource);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "Select resource drop down is Clicked Sucessfully");
//                     }
//                     else
//                     {
//                           status = false;
//                           throw new Exception();
//                     }
//              }
//              catch(Exception e) 
//              {
//                     status = false;
//                     Logger.writeDayLog(Logger.messageType.Exception, "Unable to select resource drop down");
//              }
//              return status;
//       }
//    public static Boolean selectResourceValue() throws Exception
//       {
//              Boolean status=false;
//              WebElement resourceValue = NextstepNewAdmin.getWFSelectResourceValue();
//              try
//              {
//                    if(SeleniumHelper.isExist( resourceValue))
//                    {
//                           SeleniumHelper.click( resourceValue);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "resourceValue is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select resourceValue");
//              }
//              return status;
//       }
//    public static Boolean enterLookupButtonName(String value) throws Exception
//    {
//           Boolean status = false;
//           WebElement buttonName = NextstepNewAdmin.getWFLookupButtonName();
//           try
//           {
//                  if(SeleniumHelper.isExist( buttonName))
//                  {      
//                           SeleniumHelper.setText( buttonName, value);                
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as buttonName");
//                  }
//                  else
//                  {
//                        status = false;
//                        Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as buttonName");
//                  }
//           }
//           catch(Exception e)
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter buttonName");
//           }                    
//           return status;
//    }
//    public static Boolean clickQueryFieldList() throws Exception
//       {
//              Boolean status=false;
//              WebElement fieldList = NextstepNewAdmin.getWFLookupSelectFieldList1();
//              try
//              {
//                     if(SeleniumHelper.isExist( fieldList))
//                     {
//                           SeleniumHelper.click( fieldList);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "fieldList drop down is Clicked Sucessfully");
//                     }
//                     else
//                     {
//                           status = false;
//                           throw new Exception();
//                     }
//              }
//              catch(Exception e) 
//              {
//                     status = false;
//                     Logger.writeDayLog(Logger.messageType.Exception, "Unable to select fieldList drop down");
//              }
//              return status;
//       }
//    public static Boolean clickQueryFieldListValue() throws Exception
//       {
//              Boolean status=false;
//              WebElement fieldListValue = NextstepNewAdmin.getWFLookupSelectFieldList1Value();
//              try
//              {
//                     if(SeleniumHelper.isExist( fieldListValue))
//                     {
//                           SeleniumHelper.click( fieldListValue);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "fieldListValue is Clicked Sucessfully");
//                     }
//                     else
//                     {
//                           status = false;
//                           throw new Exception();
//                     }
//              }
//              catch(Exception e) 
//              {
//                     status = false;
//                     Logger.writeDayLog(Logger.messageType.Exception, "Unable to select fieldListValue");
//              }
//              return status;
//       }
//    public static Boolean clickOperator() throws Exception
//       {
//              Boolean status=false;
//              WebElement operator = NextstepNewAdmin.getWFLookupOperator();
//              try
//              {
//                     if(SeleniumHelper.isExist( operator))
//                     {
//                           SeleniumHelper.click( operator);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "operator drop down is Clicked Sucessfully");
//                     }
//                     else
//                     {
//                           status = false;
//                           throw new Exception();
//                     }
//              }
//              catch(Exception e) 
//              {
//                     status = false;
//                     Logger.writeDayLog(Logger.messageType.Exception, "Unable to select operator drop down");
//              }
//              return status;
//       }
//    public static Boolean clickOperatorValue() throws Exception
//       {
//              Boolean status=false;
//              WebElement operatorValue = NextstepNewAdmin.getWFLookupOperatorValue();
//              try
//              {
//                     if(SeleniumHelper.isExist( operatorValue))
//                     {
//                           SeleniumHelper.click( operatorValue);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "operatorValue is Clicked Sucessfully");
//                     }
//                     else
//                     {
//                           status = false;
//                           throw new Exception();
//                     }
//              }
//              catch(Exception e) 
//              {
//                     status = false;
//                     Logger.writeDayLog(Logger.messageType.Exception, "Unable to select operatorValue");
//              }
//              return status;
//       }
//    public static Boolean clickWFFields() throws Exception
//       {
//              Boolean status=false;
//              WebElement wfFields = NextstepNewAdmin.getWFLookupSelectWFFieldsQuery();
//              try
//              {
//                    if(SeleniumHelper.isExist( wfFields))
//                    {
//                           SeleniumHelper.click( wfFields);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "wfFields drop down is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select wfFields drop down");
//              }
//              return status;
//       }
//    public static Boolean clickWFFieldsValue() throws Exception
//       {
//              Boolean status=false;
//              WebElement wfFieldsValue = NextstepNewAdmin.getWFLookupSelectWFFieldsQueryValue();
//              try
//              {
//                    if(SeleniumHelper.isExist( wfFieldsValue))
//                    {
//                           SeleniumHelper.click( wfFieldsValue);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "wfFields value Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select wfFields value");
//              }
//              return status;
//       }
//    public static Boolean clickWFFieldsResult() throws Exception
//       {
//              Boolean status=false;
//              WebElement wfFields = NextstepNewAdmin.getWFLookupSelectWFFieldsResult();
//              try
//              {
//                    if(SeleniumHelper.isExist( wfFields))
//                    {
//                           SeleniumHelper.click( wfFields);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "wfFields result drop down is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select wfFields result drop down");
//              }
//              return status;
//       }
//    public static Boolean clickWFFieldsResultValue() throws Exception
//       {
//              Boolean status=false;
//              WebElement wfFields = NextstepNewAdmin.getWFLookupSelectWFFieldsResultValue();
//              try
//              {
//                    if(SeleniumHelper.isDisplayed( wfFields))
//                    {
//                           SeleniumHelper.click( wfFields);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "wfFields result value is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select wfFields result value");
//              }
//              return status;
//       }
//    public static Boolean clickWFFieldsListResult() throws Exception
//       {
//              Boolean status=false;
//              WebElement fieldList = NextstepNewAdmin.getWFLookupSelectFieldListResult();
//              try
//              {
//                    if(SeleniumHelper.isExist( fieldList))
//                    {
//                           SeleniumHelper.click( fieldList);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "fieldList drop down is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select fieldList drop down");
//              }
//              return status;
//       }
//    public static Boolean clickWFFieldsListResultValue() throws Exception
//       {
//              Boolean status=false;
//              WebElement fieldList = NextstepNewAdmin.getWFLookupSelectFieldListResultValue();
//              try
//              {
//                    if(SeleniumHelper.isExist( fieldList))
//                    {
//                           SeleniumHelper.click( fieldList);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "fieldList drop down value is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select fieldList drop down value");
//              }
//              return status;
//       }
//    public static Boolean clickWFLookupCreate() throws Exception
//    {
//           Boolean status=false;
//           WebElement create = NextstepNewAdmin.getWFLookupCreate();
//           try
//           {
//                  if(SeleniumHelper.isExist( create))
//                  {
//                        SeleniumHelper.click( create);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "create is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create button");
//           }
//           return status;
//    }
//    public static Boolean clickWFLookupButtonPosition() throws Exception
//       {
//              Boolean status=false;
//              WebElement buttonPosition = NextstepNewAdmin.getWFLookupButtonPosition();
//              try
//              {
//                    if(SeleniumHelper.isExist( buttonPosition))
//                    {
//                           SeleniumHelper.click( buttonPosition);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "buttonPosition drop down is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select buttonPosition drop down");
//              }
//              return status;
//       }
//    public static Boolean clickWFLookupButtonPositionValue() throws Exception
//       {
//              Boolean status=false;
//              WebElement value = NextstepNewAdmin.getWFLookupButtonPositionValue();
//              try
//              {
//                    if(SeleniumHelper.isExist( value))
//                    {
//                           SeleniumHelper.click( value);
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, "buttonPosition value is Clicked Sucessfully");
//                    }
//                    else
//                    {
//                           status = false;
//                           throw new Exception();
//                    }
//              }
//              catch(Exception e) 
//              {
//                    status = false;
//                    Logger.writeDayLog(Logger.messageType.Exception, "Unable to select buttonPosition value");
//              }
//              return status;
//       }
//    public static Boolean clickSnackBarCloseButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement close = NextstepNewAdmin.getSnackbarClose();
//           try
//           {
//                  if(SeleniumHelper.isExist(close))
//                  {
//                        SeleniumHelper.click(close);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "close is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click close button");
//           }
//           return status;
//    }
//    public static Boolean validateWFLookupConnnection(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement wfname = NextstepNewAdmin.getWFLookupname( name);
//           try
//           {
//                String a= wfname.getText();
//                  if(a.equals(UserInput.LookupName))
//                  {
//                          status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Lookup connection validation is success");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Lookup connection validation is failed");
//           }
//           return status;
//    }
//    public static Boolean OpenWFLookupConnnection(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement wfName = NextstepNewAdmin.getWFLookupname( name);
//           try
//           {
//                
//              if(SeleniumHelper.isDisplayed( wfName))
//                  {
//                      SeleniumHelper.doubleClick( wfName);
//                      status = true;
//                      Logger.writeDayLog(Logger.messageType.Pass, "Lookup connection is opened");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "unable to open connection");
//           }
//           return status;
//    }
//    public static Boolean ClickUpdateLookupConnnection() throws Exception
//    {
//           Boolean status=false;
//           WebElement update = NextstepNewAdmin.getWFLookupUpdateButton();
//           try
//           {
//                
//              if(SeleniumHelper.isDisplayed( update))
//                  {
//                      SeleniumHelper.click( update);
//                      status = true;
//                      Logger.writeDayLog(Logger.messageType.Pass, "Lookup connection is updated");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "unable to update connection");
//           }
//           return status;
//    }
//    public static Boolean ClickWFLookupConnnection(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement wfName = NextstepNewAdmin.getWFLookupname( name);
//           try
//           {
//                
//              if(SeleniumHelper.isDisplayed( wfName))
//                  {
//                      SeleniumHelper.click( wfName);
//                      status = true;
//                      Logger.writeDayLog(Logger.messageType.Pass, "Lookup connection is opened");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "unable to open connection");
//           }
//           return status;
//    }
//    public static Boolean ClickWFLookupDeleteConnection() throws Exception
//    {
//           Boolean status=false;
//           WebElement delete = NextstepNewAdmin.getWFLookupDeleteButton();
//           try
//           {
//                
//              if(SeleniumHelper.isDisplayed( delete))
//                  {
//                      SeleniumHelper.click( delete);
//                      status = true;
//                      Logger.writeDayLog(Logger.messageType.Pass, "Lookup connection is deleted");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "unable to delete connection");
//           }
//           return status;
//    }
//    public static Boolean clickAdvanceMappingCheckbox() throws Exception
//    {
//           Boolean status=false;
//           WebElement checkbox = NextstepNewAdmin.getAdvanceMappingCheckbox();
//           try
//           {
//                  if(SeleniumHelper.isExist( checkbox))
//                  {
//                        SeleniumHelper.click( checkbox);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Advance mapping checkbox is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Advance mapping checkbox");
//           }
//           return status;
//    }
//    public static Boolean clickAddAdvanceMapping() throws Exception
//    {
//           Boolean status=false;
//           WebElement add = NextstepNewAdmin.getAddAdvanceMapping();
//           try
//           {
//                  if(SeleniumHelper.isExist( add))
//                  {
//                        SeleniumHelper.click( add);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Add Advance mapping is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add Advance mapping");
//           }
//           return status;
//    }
//    public static Boolean clickMappingSelectWorkflow() throws Exception
//    {
//           Boolean status=false;
//           WebElement add = NextstepNewAdmin.getMappingSelectWorkflow();
//           try
//           {
//                  if(SeleniumHelper.isExist( add))
//                  {
//                        SeleniumHelper.click( add);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "MappingSelectWorkflow is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add Advance mapping");
//           }
//           return status;
//    }
//    public static Boolean clickMappingSelectWorkflowValue(String wf) throws Exception
//    {
//           Boolean status=false;
//           Thread.sleep(1000);
//           WebElement add = NextstepNewAdmin.getMappingSelectWorkflowValue(wf);
//           try
//           {
//                  if(SeleniumHelper.isExist( add))
//                  {
//                        SeleniumHelper.click( add);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "MappingSelectWorkflow value is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add Advance mapping value");
//           }
//           return status;
//    }
//    public static Boolean clickMappingSelectField() throws Exception
//    {
//           Boolean status=false;
//           Thread.sleep(2000);
//           WebElement value = NextstepNewAdmin.getMappingSelectField();
//           try
//           {
//                  if(SeleniumHelper.isExist( value))
//                  {
//                        SeleniumHelper.click( value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "clickMappingSelectField is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add clickMappingSelectField");
//           }
//           return status;
//    }
//    public static Boolean clickMappingSelectFieldValue(String name) throws Exception
//    {
//           Boolean status=false;
//           Thread.sleep(1000);
//           WebElement value = NextstepNewAdmin.getMappingSelectFieldValue( name);
//           try
//           {
//                  if(SeleniumHelper.isExist( value))
//                  {
//                        SeleniumHelper.click( value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "clickMappingSelectField value is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add clickMappingSelectField value");
//           }
//           return status;
//    }
//    public static Boolean clickDeleteFieldMaping() throws Exception
//    {
//           Boolean status=false;
//           Thread.sleep(1000);
//           WebElement delete = NextstepNewAdmin.getDeleteFieldMapping();
//           try
//           {
//                  if(SeleniumHelper.isExist( delete))
//                  {
//                        SeleniumHelper.click( delete);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "DeleteFieldMaping value is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click DeleteFieldMaping");
//           }
//           return status;
//    }
//    public static Boolean clickMappingSave() throws Exception
//    {
//           Boolean status=false;
//           WebElement save = NextstepNewAdmin.getMappingSaveButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( save))
//                  {
//                        SeleniumHelper.click( save);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Mapping save is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Mapping save");
//           }
//           return status;
//    }
//    public static Boolean SelectField2(String fieldName) throws Exception
//    {
//           Boolean status=false;
//           WebElement field2 = NextstepNewAdmin.getWFField2( fieldName);
//           try
//           {
//                  if(SeleniumHelper.isExist( field2))
//                  {
//                        SeleniumHelper.click( field2);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Workflow Field 2 is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to set workflow Field 2");
//           }
//           return status;
//    }
//    public static Boolean clickProcessesTab() throws Exception
//    {
//           Boolean status=false;
//           WebElement processes = NextstepNewAdmin.getProcessesTab();
//           try
//           {
//                  if(SeleniumHelper.isExist( processes))
//                  {
//                        SeleniumHelper.click( processes);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Processes tab is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Processes Field tab");
//           }
//           return status;
//    }
//    public static Boolean clickCreateProcess() throws Exception
//    {
//           Boolean status=false;
//           WebElement create = NextstepNewAdmin.getCreateProcesses();
//           try
//           {
//                  if(SeleniumHelper.isExist( create))
//                  {
//                        SeleniumHelper.click( create);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "create is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create");
//           }
//           return status;
//    }
//    public static Boolean enterProcessName(String value) throws Exception
//    {
//           Boolean status = false;
//           WebElement name = NextstepNewAdmin.getProcessNameTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist( name))
//                  {      
//                        SeleniumHelper.setText( name, value);                
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as process name");
//                  }
//                  else
//                  {
//                        status = false;
//                        Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as process name");
//                  }
//           }
//           catch(Exception e)
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter process name");
//           }                    
//           return status;
//    }
//    public static Boolean enterProcessDescription(String value) throws Exception
//    {
//           Boolean status = false;
//           WebElement description = NextstepNewAdmin.getProcessDescriptionTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist( description))
//                  {      
//                        SeleniumHelper.setText( description, value);                
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as process description");
//                  }
//                  else
//                  {
//                        status = false;
//                        Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as process description");
//                  }
//           }
//           catch(Exception e)
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter process description");
//           }                    
//           return status;
//    }
//    public static Boolean clickSaveProcess() throws Exception
//    {
//           Boolean status=false;
//           WebElement save = NextstepNewAdmin.getSaveProcess();
//           try
//           {
//                  if(SeleniumHelper.isExist(save))
//                  {
//                        SeleniumHelper.click(save);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "save is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click save");
//           }
//           return status;
//    }
//    public static Boolean clickBackToAdmin() throws Exception
//    {
//           Boolean status=false;
//           WebElement backToAdmin = NextstepNewAdmin.getbackToAdmin();
//           try
//           {
//        	   	  SeleniumHelper.click(backToAdmin);
//        	   	  waitForPageLoad();
//                  if(verifyHomePage())
//                  {                
//                	  status = true;
//                	  Logger.writeDayLog(Logger.messageType.Pass, "backToAdmin is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click backToAdmin");
//           }
//           return status;
//    }
//    public static Boolean clickCreateActivity() throws Exception
//    {
//           Boolean status=false;
//           WebElement createActivity = NextstepNewAdmin.getCreateActivity();
//           try
//           {
//                  if(SeleniumHelper.isExist(createActivity))
//                  {
//                        SeleniumHelper.click(createActivity);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "createActivity is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click createActivity");
//           }
//           return status;
//    }
//    public static Boolean clickEnterActivity(String value) throws Exception
//    {
//           Boolean status=false;
//           Thread.sleep(1000);
//           WebElement enterActivity = NextstepNewAdmin.getEnterActivity();
//           try
//           {
//                  if(SeleniumHelper.isExist(enterActivity))
//                  {
//                        SeleniumHelper.setText(enterActivity, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "enterActivity is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click enterActivity");
//           }
//           return status;
//    }
//    public static Boolean selectActivity(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement selectActivity = NextstepNewAdmin.getActivitiesList(name);
//           try
//           {
//                  if(SeleniumHelper.isExist(selectActivity))
//                  {
//                        SeleniumHelper.click(selectActivity);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Activity is selected successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Activity");
//           }
//           return status;
//    }
//    public static Boolean selectOcrandExtractionActivity(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement selectActivity = NextstepNewAdmin.getOcrAndExtractionActivity( name);
//           try
//           {
//                  if(SeleniumHelper.isExist( selectActivity))
//                  {
//                        SeleniumHelper.click( selectActivity);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "OCR Activity is selected successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to select OCR Activity");
//           }
//           return status;
//    }
//    public static Boolean clickSelectIndividuals() throws Exception
//    {
//           Boolean status=false;
//           WebElement selectIndividuals = NextstepNewAdmin.getBarcodeSelectIndividuals();
//           try
//           {
//                  if(SeleniumHelper.isExist( selectIndividuals))
//                  {
//                        SeleniumHelper.click( selectIndividuals);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "selectIndividuals is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click selectIndividuals");
//           }
//           return status;
//    }
//    public static Boolean clickBarcodeSelectIndividualsValue(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement selectIndividualsValue = NextstepNewAdmin.getBarcodeSelectIndividualValue(name);
//           try
//           {
//                  if(SeleniumHelper.isExist( selectIndividualsValue))
//                  {
//                        SeleniumHelper.click( selectIndividualsValue);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "selectIndividualsValue is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click selectIndividualsValue");
//           }
//           return status;
//    }
//    public static Boolean clickSaveActivity(String activity) throws Exception
//    {
//           Boolean status=false;
//           WebElement clickSaveBarcode = NextstepNewAdmin.getActivitySave(activity);
//           try
//           {
//                  if(SeleniumHelper.isExist( clickSaveBarcode))
//                  {
//                        SeleniumHelper.click( clickSaveBarcode);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "clickSaveBarcode is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click SaveBarcode");
//           }
//           return status;
//    }
//    public static Boolean clickSaveProcess(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement backToList = NextstepNewAdmin.getSaveProcessesUpdated();
//           try
//           {
//                  if(SeleniumHelper.isExist( backToList))
//                  {
//                        SeleniumHelper.click( backToList);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "backToList is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click backToList");
//           }
//           return status;
//    }
//    public static Boolean clickSaveProcesses(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement save = NextstepNewAdmin.getSaveProcesses(name);
//           try
//           {
//                  if(SeleniumHelper.isExist( save))
//                  {
//                        SeleniumHelper.click( save);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Save process is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save process");
//           }
//           return status;
//    }
//    public static Boolean clickOCRPublishRetrievalToggle() throws Exception
//    {
//           Boolean status=false;
//           WebElement toggle = NextstepNewAdmin.getOCRPublishRetrievalToggle();
//           try
//           {
//                  if(SeleniumHelper.isExist( toggle))
//                  {
//                        SeleniumHelper.click( toggle);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "toggle is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click toggle");
//           }
//           return status;
//    }
//    public static Boolean enterOCRName(String value) throws Exception
//    {
//              Boolean status = false;
//              WebElement name = NextstepNewAdmin.getOCRNameTextbox();
//              try
//              {
//                     if(SeleniumHelper.setText( name, value))
//                     {                          
//                           status = true;
//                           Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as name");
//                     }
//                     else
//                     {
//                           status = false;
//                           Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in name");
//                     }
//              }
//              catch(Exception e)
//              {
//                     status = false;
//                     Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter name");
//              }                    
//              return status;
//    }
//    public static Boolean clickDocumentSeperationType() throws Exception
//    {
//           Boolean status=false;
//           WebElement type = NextstepNewAdmin.getDocumentSeparationType();
//           try
//           {
//                  if(SeleniumHelper.isExist(type))
//                  {
//                        SeleniumHelper.click(type);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Seperation type is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Seperation type");
//           }
//           return status;
//    }
//    public static Boolean selectDocumentSeperationTypeValue() throws Exception
//    {
//           Boolean status=false;
//           WebElement value = NextstepNewAdmin.getDocumentSeparationTypeValue();
//           try
//           {
//                  if(SeleniumHelper.isExist(value))
//                  {
//                        SeleniumHelper.click(value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Seperation type value is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Seperation type value");
//           }
//           return status;
//    }
//    public static Boolean deleteActivity(String name) throws Exception
//       {
//              Boolean status = false;
//              WebElement list = NextstepNewAdmin.getSavedActivityList(name);
//              WebElement delete= null;
//              try
//         {
//                if(SeleniumHelper.isExist(list))
//                {
//                      SeleniumHelper.click(list);
//                      delete = NextstepNewAdmin.getDeleteActivity();
//                      SeleniumHelper.click(delete);
//                      status = true;
//                      Logger.writeDayLog(Logger.messageType.Pass, "Activity is Deleted successfully");
//                }
//                else
//                {
//                      status = false;
//                      throw new Exception();
//                }
//         }
//         catch(Exception e) 
//         {
//                status = false;
//                Logger.writeDayLog(Logger.messageType.Exception, "Unable to delete Activity");
//         }
//         return status;
//    }
//    public static Boolean openSavedProcess() throws Exception
//    {
//           Boolean status=false;
//           WebElement process = NextstepNewAdmin.getProcessListRow();
//           try
//           {
//                  if(SeleniumHelper.isExist( process))
//                  {
//                        SeleniumHelper.doubleClick( process);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "process is opened successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to open process");
//           }
//           return status;
//    }
//    public static Boolean ClickDocumentTypeCleanupSelectType() throws Exception
//    {
//           Boolean status=false;
//           WebElement type = NextstepNewAdmin.getDocumentCleanUpSelectType();
//           try
//           {
//                  if(SeleniumHelper.isExist( type))
//                  {
//                        SeleniumHelper.doubleClick( type);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "type select is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click type select");
//           }
//           return status;
//    }
//    public static Boolean ClickDocumentConversionSelectFileFormat() throws Exception
//    {
//           Boolean status=false;
//           WebElement type = NextstepNewAdmin.getDocumentConversionSelectFileFormat();
//           try
//           {
//                  if(SeleniumHelper.isExist( type))
//                  {
//                        SeleniumHelper.doubleClick( type);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "type select is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click type select");
//           }
//           return status;
//    }
//    public static Boolean ClickDocumentConversionFileFormatValue() throws Exception
//    {
//           Boolean status=false;
//           WebElement value = NextstepNewAdmin.getDocumentConversionFileFormatValue();
//           try
//           {
//                  if(SeleniumHelper.isExist( value))
//                  {
//                        SeleniumHelper.doubleClick( value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "File Format value is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to select File Format value");
//           }
//           return status;
//    }
//    public static Boolean ValidateDocumentSeperation() throws Exception
//    {
//           Boolean status=false;
//           WebElement create = NextstepNewAdmin.getCreateActivity();
//           try
//           {
//                  if(SeleniumHelper.isEnabled( create))
//                  {
//                        status = false;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Doc Sepeartion Validation is failed");
//                        throw new Exception();
//                  }
//                  else
//                  {
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Exception, "Doc Seperation Validation is successfull");
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Doc Seperation Validation is failed");
//           }
//           return status;
//    }
//    public static Boolean ClickDocumentClassificationSelectModel() throws Exception
//    {
//           Boolean status=false;
//           WebElement model = NextstepNewAdmin.getDocumentClassificationSelectModel();
//           try
//           {
//                  if(SeleniumHelper.isExist(model))
//                  {
//                        SeleniumHelper.click(model);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Select Model is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Model");
//           }
//           return status;
//    }
//    public static Boolean SelectDocumentRetrievalCheckbox1() throws Exception
//    {
//           Boolean status=false;
//           WebElement checkbox = NextstepNewAdmin.getDocumentRetrievalCheckbox1();
//           try
//           {
//                  if(SeleniumHelper.isExist( checkbox))
//                  {
//                        SeleniumHelper.click( checkbox);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "checkbox clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                       throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to select checkbox");
//           }
//           return status;
//    }
//    public static Boolean clickSelectDataSource() throws Exception
//    {
//           Boolean status=false;
//           WebElement selectIndividuals = NextstepNewAdmin.getSelectDataSource();
//           try
//           {
//                  if(SeleniumHelper.isExist( selectIndividuals))
//                  {
//                        SeleniumHelper.click( selectIndividuals);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "select Data Source is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Data Source");
//           }
//           return status;
//    }
//    public static Boolean selectDataSourceValue(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement dataSourceValue = NextstepNewAdmin.getDataSourceValue(name);
//           try
//           {
//                  if(SeleniumHelper.isExist(dataSourceValue))
//                  {
//                        SeleniumHelper.click(dataSourceValue);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "data Source Value is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click data Source Value");
//           }
//           return status;
//    }
//    public static Boolean clickAddDataSourceButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement add = NextstepNewAdmin.getAddDataSourceButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( add))
//                  {
//                        SeleniumHelper.click( add);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Add Data SourceButton is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add Data Source Button");
//           }
//    return status;
//}
//    public static Boolean enterDataSourceValue(String value, String name) throws Exception
//    {
//           Boolean status=false;
//           Thread.sleep(1000);
//           WebElement textbox = NextstepNewAdmin.getDataSourceTextbox(name);
//           try
//           {
//                  if(SeleniumHelper.isExist( textbox))
//                  {
//                        SeleniumHelper.setText( textbox, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Data source is entered successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter data source");
//           }
//           return status;
//    }
//    public static Boolean enterNotificationSubject(String value) throws Exception
//    {
//           Boolean status=false;
//           Thread.sleep(1000);
//           WebElement enterSubject = NextstepNewAdmin.getNotifySubjectTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist( enterSubject))
//                  {
//                        SeleniumHelper.setText( enterSubject, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Subject is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter subject");
//           }
//           return status;
//    }
//    public static Boolean enterNotificationToAddress(String value) throws Exception
//    {
//           Boolean status=false;
//           Thread.sleep(1000);
//           WebElement enterTo = NextstepNewAdmin.getNotifyToAddressTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist( enterTo))
//                  {
//                        SeleniumHelper.setText( enterTo, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "To is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter To");
//           }
//           return status;
//    }
//    public static Boolean clickNotifyEmailBodyContentName() throws Exception
//    {
//           Boolean status=false;
//           WebElement add = NextstepNewAdmin.getNotifyEmailBodyContent();
//           try
//           {
//                  if(SeleniumHelper.isEnabled( add))
//                  {
//                        SeleniumHelper.click( add);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "NotifyEmailBodyContent is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to clickNotifyEmailBodyContent");
//           }
//    return status;
//}
//    public static Boolean clickNotifyEmailBodyContentNameValue() throws Exception
//    {
//           Boolean status=false;
//           WebElement value = NextstepNewAdmin.getNotifyEmailBodyContentValue();
//           try
//           {
//                  if(SeleniumHelper.isEnabled( value))
//                  {
//                        SeleniumHelper.click( value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "NotifyEmailBodyContent value is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to clickNotifyEmailBodyContent value");
//           }
//    return status;
//}
//    public static Boolean clickProcessingSelectDataSource() throws Exception
//    {
//           Boolean status=false;
//           WebElement selectIndividuals = NextstepNewAdmin.getProcessingSelectDataSource();
//           try
//           {
//                  if(SeleniumHelper.isExist(selectIndividuals))
//                  {
//                        SeleniumHelper.click(selectIndividuals);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "select Data Source is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Data Source");
//           }
//           return status;
//    }
//    public static Boolean clickProcessingAddDataSource() throws Exception
//    {
//           Boolean status=false;
//           WebElement add = NextstepNewAdmin.getProcessingAddDataSourceButton();
//           try
//           {
//                  if(SeleniumHelper.isExist( add))
//                  {
//                        SeleniumHelper.click( add);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "select Data Source add is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click add Data Source");
//           }
//           return status;
//    }
//    public static Boolean selectWfFieldsCheckbox(String name) throws Exception
//    {
//           Boolean status=false;
//           WebElement checkbox = NextstepNewAdmin.getWfFieldsCheckbox(name);
//           try
//           {
//                  if(SeleniumHelper.isExist( checkbox))
//                  {
//                        SeleniumHelper.click( checkbox);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, " WF checkbox Value is selected successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click WF fields checkbox");
//           }
//           return status;
//    }
//    public static Boolean enterWfFieldsTextbox(String name,String value) throws Exception
//    {
//           Boolean status=false;
//           WebElement textbox = NextstepNewAdmin.getWfFieldsTextbox(name);
//           try
//           {
//        	   if(SeleniumHelper.isExist( textbox))
//               {
//                     SeleniumHelper.setText( textbox, value);
//                     status = true;
//                     Logger.writeDayLog(Logger.messageType.Pass, "wf xpath successfuly");
//               }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to wf xpath");
//           }
//           return status;
//    }
//    public static Boolean clickAddressBookButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement AddressBook = NextstepNewAdmin.getAddressBookButton();
//           try
//           {
//                  if(SeleniumHelper.isExist(AddressBook))
//                  {
//                        SeleniumHelper.click( AddressBook);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "AddressBook button is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click AddressBook button");
//           }
//           return status;
//    }
//    public static Boolean clickCreateAddressBookButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement create = NextstepNewAdmin.getCreateAddressBookButton();
//           try
//           {
//                  if(SeleniumHelper.isExist(create))
//                  {
//                        SeleniumHelper.click(create);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "create AddressBook button is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create AddressBook button");
//           }
//           return status;
//    }
//    public static Boolean enterALiasName(String value) throws Exception
//    {
//           Boolean status=false;
//           WebElement alias = NextstepNewAdmin.getAliasTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist(alias))
//                  {
//                        SeleniumHelper.setText(alias, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "Alias is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Alias");
//           }
//           return status;
//    }
//    public static Boolean enterAddresBookFaxnumber(String value) throws Exception
//    {
//           Boolean status=false;
//           WebElement faxNumber = NextstepNewAdmin.getFaxNumberTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist(faxNumber))
//                  {
//                        SeleniumHelper.setText(faxNumber, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "faxNumber is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter faxNumber");
//           }
//           return status;
//    }
//    public static Boolean enterAddresBookEmail(String value) throws Exception
//    {
//           Boolean status=false;
//           WebElement email = NextstepNewAdmin.getEmailTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist(email))
//                  {
//                        SeleniumHelper.setText(email, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "email is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter email");
//           }
//           return status;
//    }
//    public static Boolean enterAddresBookDepartment(String value) throws Exception
//    {
//           Boolean status=false;
//           WebElement department = NextstepNewAdmin.getDepartmentTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist(department))
//                  {
//                        SeleniumHelper.setText(department, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "department is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter department");
//           }
//           return status;
//    }
//    public static Boolean enterAddresBookFirstName(String value) throws Exception
//    {
//           Boolean status=false;
//           WebElement name = NextstepNewAdmin.getFirstNameTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist(name))
//                  {
//                        SeleniumHelper.setText(name, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "name is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter name");
//           }
//           return status;
//    }
//    public static Boolean enterAliasSearch(String value) throws Exception
//    {
//           Boolean status=false;
//           WebElement alias = NextstepNewAdmin.getAliasSearchTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist(alias))
//                  {
//                        SeleniumHelper.setText(alias, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "alias is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter alias");
//           }
//           return status;
//    }
//    public static Boolean enterFaxNumberSearch(String value) throws Exception
//    {
//           Boolean status=false;
//           WebElement faxNumber = NextstepNewAdmin.getFaxNumberSearchTextbox();
//           try
//           {
//                  if(SeleniumHelper.isExist(faxNumber))
//                  {
//                        SeleniumHelper.setText(faxNumber, value);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "faxNumber is entered successfuly");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter faxNumber");
//           }
//           return status;
//    }
//    public static Boolean clickContactEditButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement edit = NextstepNewAdmin.getEditContact();
//           try
//           {
//                  if(SeleniumHelper.isExist(edit))
//                  {
//                        SeleniumHelper.click(edit);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "AddressBook edit button is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create AddressBook edit sbutton");
//           }
//           return status;
//    }
//    public static Boolean clickContactDeleteButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement delete = NextstepNewAdmin.getDeleteContact();
//           try
//           {
//                  if(SeleniumHelper.isExist(delete))
//                  {
//                        SeleniumHelper.click(delete);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "AddressBook delete button is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create AddressBook delete sbutton");
//           }
//           return status;
//    }
//    public static Boolean clickAddressBookSaveButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement save = NextstepNewAdmin.getSaveContact();
//           try
//           {
//                  if(SeleniumHelper.isExist(save))
//                  {
//                        SeleniumHelper.click(save);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "AddressBook save button is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create AddressBook save sbutton");
//           }
//           return status;
//    }
//    public static Boolean clickWarningOkButton() throws Exception
//    {
//           Boolean status=false;
//           WebElement ok = NextstepNewAdmin.getWarningOkButton();
//           try
//           {
//                  if(SeleniumHelper.isExist(ok))
//                  {
//                        SeleniumHelper.click(ok);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "ok button is clicked successfully");
//                  }
//                  else
//                  {
//                        status = true;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click ok button");
//           }
//           return status;
//    }
//    public static Boolean clickAddressBookOkButtton() throws Exception
//    {
//           Boolean status=false;
//           WebElement ok = NextstepNewAdmin.getAddressBookOkButton();
//           try
//           {
//                  if(SeleniumHelper.isExist(ok))
//                  {
//                        SeleniumHelper.click(ok);
//                        status = true;
//                        Logger.writeDayLog(Logger.messageType.Pass, "OK button is clicked successfully");
//                  }
//                  else
//                  {
//                        status = false;
//                        throw new Exception();
//                  }
//           }
//           catch(Exception e) 
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Unable to click ok sbutton");
//           }
//           return status;
//    }
//    
//    public static Boolean clickAddressBookSearchButtton() throws Exception
//    {
//       Boolean status=false;
//       WebElement search = NextstepNewAdmin.getAddresBookSearchButton();
//       try
//       {
//              if(SeleniumHelper.isExist(search))
//              {
//                    SeleniumHelper.click(search);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "search button is clicked successfully");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//       }
//       catch(Exception e) 
//       {
//              status = false;
//              Logger.writeDayLog(Logger.messageType.Exception, "Unable to click search sbutton");
//       }
//       return status;
//    }
//    public static Boolean validateAddressBookSearchResult() throws Exception
//    {
//       Boolean status=false;
//       WebElement alias = NextstepNewAdmin.getAliasField();
//       WebElement faxNumber = NextstepNewAdmin.getFaxNumberField();
//       WebElement name  = NextstepNewAdmin.getNameField();
//       try
//       {
//                  String org =alias.getText();
//                  String number =faxNumber.getText();
//                  String contactname =name.getText();
//              if(org.equals("Concord") && number.equals(UserInput.userSearchText))
//              {
//                      status = true;
//                      Logger.writeDayLog(Logger.messageType.Pass, "Address Book Search is validated successfully"); 
//              }
//               else if(contactname.equals(UserInput.workflowName)) 
//               {
//                       status = true;
//                       Logger.writeDayLog(Logger.messageType.Pass, "Address Book Search is validated successfully");
//              }
//              else 
//              {
//                      status = false;
//                      throw new Exception();
//              }                   
//       }
//       catch(Exception e) 
//       {
//              status = false;
//              Logger.writeDayLog(Logger.messageType.Exception, "Address Book validation is failed");
//       }
//       return status;
//}
//	public static Boolean clickAddressBookSearchDropDown() throws Exception
//	{
//       Boolean status=false;
//       WebElement search = NextstepNewAdmin.getAddresBookSearchDropdown();
//       try
//       {
//              if(SeleniumHelper.isExist(search))
//              {
//                    SeleniumHelper.click( search);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "AddressBook search dropdown is clicked successfully");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//       }
//       catch(Exception e) 
//       {
//              status = false;
//              Logger.writeDayLog(Logger.messageType.Exception, "Unable to click AddressBook search drop down");
//       }
//       return status;
//	}
//	public static Boolean SelectAddressBookDropDownSearchValue(String value) throws Exception
//	{		
//       Boolean status=false;
//       WebElement Searchvalue = NextstepNewAdmin.getAddressookSearchDropdownValue(value);
//       try
//       {
//              if(SeleniumHelper.isExist(Searchvalue))
//              {
//                    SeleniumHelper.click(Searchvalue);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "Address Book Search value is clicked successfully");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//       }
//       catch(Exception e) 
//       {
//              status = false;
//              Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Address Book Search Value");
//       }
//       return status;
//	}
//	public static Boolean enterAddressBookSearchValue(String value) throws Exception
//	{
//       Boolean status=false;
//       WebElement box = NextstepNewAdmin.getAddresBookSearchValueTextBox();
//       try
//       {
//              if(SeleniumHelper.isExist(box))
//              {
//                    SeleniumHelper.setText(box, value);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "Adress Book Search Value entered successfuly");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//       }
//       catch(Exception e) 
//       {
//              status = false;
//              Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Address Book Search");
//       }
//       return status;
//	}
//	public static Boolean clickAddressBookResetButtton() throws Exception
//	{
//       Boolean status=false;
//       WebElement reset = NextstepNewAdmin.getAddresBookResetButton();
//       try
//       {
//              if(SeleniumHelper.isExist(reset))
//              {
//                    SeleniumHelper.click(reset);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "Reset button is clicked successfully");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//       }
//       catch(Exception e) 
//       {
//              status = false;
//              Logger.writeDayLog(Logger.messageType.Exception, "Unable to click reset button");
//       }
//       return status;
//	}
//	public static Boolean validateWFandUserReset(List<WebElement> t)
//	{
//       Boolean status = false;
//       try
//       {
//              if(t.size()<=0)
//              {
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "No data found");
//              }
//              else if(t.size()>0)
//              {          
//               status = true;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Reset validation passed");
//                  return status;
//              }
//              else
//              {
//                   status = false;
//                    throw new Exception();
//              }
//       }
//       catch(Exception e)
//       {
//              Logger.writeDayLog(Logger.messageType.Exception, "Failed in user search validation");
//              status = false;
//       }                          
//       return status;
//	}
//	public static Boolean clickConfirmButton() throws Exception
//    {
//        Boolean status = false;
//        WebElement confirm = NextstepNewAdmin.getLogoutConfirmButton();
//        try
//        {           
//            SeleniumHelper.click(confirm);
//            waitForPageLoad();
//            if(ValidateLogout())
//            {
//                //SeleniumHelper.click(driver, confirm);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Logout is Clicked Sucessfully");
//            }
//            else
//            {
//                throw new Exception();
//            }
//        }
//        catch(Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Logout" + e.getStackTrace());
//        }
//        return status;               
//    }
//	public static Boolean selectFirstWorkflow() throws Exception 
//	{
//		Boolean status = false;
//		WebElement wfRow = NextstepNewAdmin.getWorkflowRow1();
//		try 
//		{
//			if (SeleniumHelper.isExist(wfRow)) 
//			{
//				SeleniumHelper.doubleClick( wfRow);
//				Logger.writeDayLog(Logger.messageType.Pass, "Workflow is selected successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Workflow is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean clickWorkflowDelete1() throws Exception 
//	{
//		Boolean status = false;
//		WebElement delete = NextstepNewAdmin.getWorkflowDelete1();
//		try 
//		{
//			if (SeleniumHelper.isExist(delete)) 
//			{
//				SeleniumHelper.doubleClick( delete);
//				Logger.writeDayLog(Logger.messageType.Pass, "Workflow delete clicked is selected successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Unan=ble to delete workflow");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean clickProcessDeleteButton(String name) throws Exception 
//	{
//		Boolean status = false;
//		WebElement processDelete = NextstepNewAdmin.getProcessDeleteButton(name);
//		WebElement processRow = NextstepNewAdmin.getProcesswRow(name);
//		SeleniumHelper.click( processRow);
//		try 
//		{
//			if (SeleniumHelper.isExist(processDelete)) 
//			{
//				SeleniumHelper.click(processDelete);
//				Logger.writeDayLog(Logger.messageType.Pass, "Process delete button is clicked successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Process delete is not selected");
//			status = false;
//		}
//		return status;
//	}
//	public static Boolean adminLogin() throws Exception
//	{
//		Boolean status = false;
//		try
//		{			
//			NewAdmin.enterUserName(GlobalVariable.adminUserName);
//			NewAdmin.enterPassword(GlobalVariable.adminPassword);
//			NewAdmin.clickLogin();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Admin Logged in successfully");
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to Login" + e.getStackTrace());
//		}
//		return status;				
//	}
//	public static Boolean SSOAdminLogin() throws Exception
//	{
//		Boolean status = false;
//		try
//		{			
//			NewAdmin.enterSSOUserNameAndClickNext(GlobalVariable.adminUserName);
//			NewAdmin.enterSSOPassword(GlobalVariable.adminPassword);
//			NewAdmin.clickSSOLogin();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "SSO Logged in successfully");
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Logout" + e.getStackTrace());
//		}
//		return status;				
//	}
//public static Boolean enterSSOUserNameAndClickNext(String value) throws Exception
//{
//	Boolean status = false;
//	Thread.sleep(2000);
//	WebElement userNameBox = NextstepNewAdmin.getSSOUserNameInputBox();
//	WebElement next = NextstepNewAdmin.getSSOLoginNextButton();
//	try
//	{
//		while(!(userNameBox.isDisplayed()))
//		{
//			Thread.sleep(2000);
//		}
//		if(SeleniumHelper.setText(userNameBox, value))
//		{				
//			status = true;
//			next.click();
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as UserName");
//			Logger.writeDayLog(Logger.messageType.Pass, "Next button is clicked successfully");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in UserName");
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter UserName");
//	}			
//	return status;
//}
//public static Boolean enterSSOPassword(String value) throws Exception
//{
//	Boolean status = false;
//	WebElement passwordBox = NextstepNewAdmin.getSSOPasswordInputBox();
//	try
//	{
//		if(SeleniumHelper.setText(passwordBox, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as Password");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in Password");
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter Password");
//	}			
//	return status;
//}
//public static Boolean clickSSOLogin() throws Exception
//{
//	Boolean status = false;
//	WebElement temp = NextstepNewAdmin.getSSOLoginButton();
//	try
//	{			
//		if(SeleniumHelper.click(temp))
//		{
//			waitForPageLoad();
//			//verifyUserName();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Login is Clicked Sucessfully");
//		}
//		else
//		{
//			throw new Exception();
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Login" + e.getStackTrace());
//	}
//	return status;				
//}
//public static Boolean ValidateSSOLogout() throws Exception 
//{
//	Boolean status = false;
//	try
//	{
//		if (SeleniumHelper.isExist( NextstepNewAdmin.getSSOUserNameInputBox())) 
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Appliation logged out Sucessfully");
//		} 
//		else
//		{
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Appliation not logged out" + e.getStackTrace());
//	}
//	return status;
//}
//public static Boolean clickSSOLogoutConfirmButton() throws Exception
//{
//	Boolean status = false;
//	WebElement confirm = NextstepNewAdmin.getLogoutConfirmButton();
//	try
//	{			
//		SeleniumHelper.click(confirm);
//		waitForPageLoad();
//		if(ValidateSSOLogout())
//		{
//			//SeleniumHelper.click( confirm);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Logout is Clicked Sucessfully");
//		}
//		else
//		{
//			throw new Exception();
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Logout" + e.getStackTrace());
//	}
//	return status;				
//}
//public static Boolean cancelActivity(String name) throws Exception
//{
//       Boolean status = false;
//       WebElement cancel = NextstepNewAdmin.getAddedActivityList(name);
//       try
//       {
//         if(SeleniumHelper.isExist(cancel))
//         {
//               SeleniumHelper.click(cancel);
//               status = true;
//               Logger.writeDayLog(Logger.messageType.Pass, "Activity is cancelled successfully");
//         }
//         else
//         {
//               status = false;
//               throw new Exception();
//         }
//  }
//  catch(Exception e) 
//  {
//         status = false;
//         Logger.writeDayLog(Logger.messageType.Exception, "Unable to cancel Activity");
//  }
//  return status;
//}
//public static Boolean SelectExtractionFields() throws Exception
//{
//       Boolean status=false;
//       WebElement value = NextstepNewAdmin.getSelectExtractedValue();
//       WebElement config = NextstepNewAdmin.getSelectMappingConfiguration();
//       WebElement field = NextstepNewAdmin.getSelectWorkflowField();
//       try
//       {
//              if(SeleniumHelper.isExist(value))
//              {
//                    SeleniumHelper.doubleClick(value);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "Extracted value is selected successfully");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//              if(SeleniumHelper.isExist(config))
//              {
//                    SeleniumHelper.doubleClick(config);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "Mapping configutation is selected successfully");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//              if(SeleniumHelper.isExist(field))
//              {
//                    SeleniumHelper.doubleClick(field);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "Workflow field is selected successfully");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//       }
//       catch(Exception e) 
//       {
//              status = false;
//              Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Extraction values");
//       }
//       return status;
//}
//public static Boolean clickSaveProcessUpdated() throws Exception
//{
//       Boolean status=false;
//       WebElement backToList = NextstepNewAdmin.getSaveProcessesUpdated();
//       try
//       {
//              if(SeleniumHelper.isExist( backToList))
//              {
//                    SeleniumHelper.click( backToList);
//                    status = true;
//                    Logger.writeDayLog(Logger.messageType.Pass, "backToList is clicked successfully");
//              }
//              else
//              {
//                    status = false;
//                    throw new Exception();
//              }
//       }
//       catch(Exception e) 
//       {
//              status = false;
//              Logger.writeDayLog(Logger.messageType.Exception, "Unable to click backToList");
//       }
//       return status;
//}
//public static Boolean selectWorkflowFromGrid() throws Exception 
//{
//	Boolean status = false;
//	List<WebElement> workflow = NextstepNewAdmin.getUserWorkflowListFromGrid();		
//	try 
//	{
//		if (SeleniumHelper.isExist(workflow.get(1))) 
//		{
//			SeleniumHelper.doubleClick(workflow.get(1));
//			Logger.writeDayLog(Logger.messageType.Pass, "User is selected successfully");
//			status = true;
//		}
//	} 
//	catch (Exception e) 
//	{
//		Logger.writeDayLog(Logger.messageType.Exception, "User is not selected");
//		status = false;
//	}
//	return status;
//}
//public static Boolean clickReports() throws Exception
//{
//	Boolean status = false;
//	WebElement report = NextstepNewAdmin.getreports();
//	try
//	{			
//		if(SeleniumHelper.isExist(report))
//		{
//			SeleniumHelper.click(report);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Report is Clicked Sucessfully");
//		}
//		else
//		{
//			throw new Exception();
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Report" + e.getStackTrace());
//	}
//	return status;				
//}
//public static Boolean waitForReportsLoad() throws Exception
//{
//	Boolean status = false;
//	try
//	{	
//		WebDriverWait grid = new WebDriverWait(GlobalVariable.driver, 60);
// 	    grid.until(ExpectedConditions.visibilityOf((NextstepNewAdmin.getPiechart())));
//		Logger.writeDayLog(Logger.messageType.Pass, "Page loaded successfully");
//		Thread.sleep(2000);
//		status = true;
//	}
//	catch(Exception e)
//	{
//		status=false;
//		Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//	}
//	return status;
//}
//public static Boolean ValidateReports() throws Exception
//{
//	Boolean status = false;
//	WebElement wfDocuments = NextstepNewAdmin.getDocumentsInWorkflow();
//	try
//	{			
//		if(SeleniumHelper.isExist(wfDocuments))
//		{
//			String documentsCount = wfDocuments.getText();
//			int i=Integer.parseInt(documentsCount);  
//			if(i > 1)
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Report is Clicked Sucessfully");
//			}
//			else
//			{
//				throw new Exception();
//			}
//		}
//		else
//		{
//			throw new Exception();
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Report" + e.getStackTrace());
//	}
//	return status;				
//}
//}
