//package org.ab.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.ab.constants.GlobalVariable;
//import org.ab.pop.NextstepFaxInbox;
//import org.ab.pop.UserInput;
//import org.joda.time.DateTime;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.concord.nextstep.helper.DateTimeHelper;
//import com.concord.nextstep.logger.Logger;
//
//public class FaxInbox 
//{
//	
//	public static int SNo;
//	public static String TC_ID;
//	public static String TestCaseDescription;
//	public static String BrowserName;
//	public static String documentID;
//	public static String secondDocumentID;
//	public static String mergeDocumentID;
//	public static String Description;
//	public static String DocumentType;
//	public static String UploadeddocumentID;
//	
//	public static Boolean launch(String baseURL, String BrowserName) throws Exception
//	{				
//		Boolean status = false;
//		BrowserNameEnum browserOption = BrowserNameEnum.valueOf(BrowserName);		
//		switch(browserOption)
//		{
//		case Firefox:
//		{ 			 
//			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
//			GlobalVariable.driver = new FirefoxDriver();
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
//	
//		//Logs logs = AdminPortal.driver.manage().logs();
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
//	public static Boolean enterUserName(String value) throws Exception
//	{
//		Boolean status = false;
//		Thread.sleep(2000);
//		WebElement userNameBox = NextstepFaxInbox.getUserNameInputBox();		
//		try
//		{
//			while(!(userNameBox.isDisplayed()))
//			{
//				Thread.sleep(1000);
//			}
//			if(SeleniumHelper.setText(userNameBox, value))
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
//			if(SeleniumHelper.setText(passwordBox, value))
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
//	
//	public static Boolean enterInvalidPassword(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement passwordBox = NextstepFaxInbox.getPasswordInputBox();
//		try
//		{
//			if(SeleniumHelper.setText(passwordBox, value))
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
//	
//	public static Boolean ValidateInvalidLogin() throws Exception
//	{
//		Boolean status = false;
//		WebElement alert = NextstepFaxInbox.getInvalidCredentialsAlert();
//		String message=alert.getText();	
//		try
//		{
//			if(message.contains("Invalid"))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Invalid credentials validation successfull");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Pass, "Invalid credentials validation failed");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter Password");
//		}			
//		return status;
//	}
//
//	public static Boolean clickLogin() throws Exception
//	{
//		Boolean status = false;
//		WebElement temp = NextstepFaxInbox.getLoginButton();
//		try
//		{			
//			if(SeleniumHelper.click( temp))
//			{
//				waitForPageLoad();
//				verifyUserName();
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
//	
//	public static Boolean clickLogoutValidation() throws Exception
//	{
//		Boolean status = false;
//		Thread.sleep(1000);
//		WebElement temp = NextstepFaxInbox.getLogoutButton();
//		try
//		{			
//			WebElement austria = new WebDriverWait( GlobalVariable.driver,10).until(ExpectedConditions.elementToBeClickable(temp));
//			SeleniumHelper.click( temp);
//			WebElement username = new WebDriverWait( GlobalVariable.driver,10).until(ExpectedConditions.elementToBeClickable(NextstepFaxInbox.getUserNameInputBox()));
//			if(SeleniumHelper.isExist(NextstepFaxInbox.getUserNameInputBox()))
//			{
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
//	
//	public static Boolean waitForPageLoad() throws Exception
//	{
//		Boolean status = false;
//		Thread.sleep(1000);
//		WebElement allPageLoader = null;
//		try
//		{
//			allPageLoader = NextstepFaxInbox.getLoadingSpinner();	
//			WebElement temp = NextstepFaxInbox.getLogoutButton();
//			SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, allPageLoader);		
//			SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, temp);		
//			WebElement austria = new WebDriverWait(GlobalVariable.driver, 5).until(ExpectedConditions.elementToBeClickable(temp));
//			Logger.writeDayLog(Logger.messageType.Pass, "Page loaded successfully");
//			status = true;
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//		}
//		return status;
//	}
//	
//	public static Boolean AutoRefreshValidation() throws Exception
//	{
//		
//		Boolean status = false;
//		WebElement allPageLoader = null;
//		try
//		{
//			allPageLoader = NextstepFaxInbox.getLoadingSpinner();
//			WebElement loader;
//			WebDriverWait wait = new WebDriverWait( GlobalVariable.driver,60);
//			loader = wait.until(ExpectedConditions.visibilityOf(allPageLoader));
//			Logger.writeDayLog(Logger.messageType.Pass, "Page loaded successfully");
//			status = true;
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//		}
//		return status;
//	}	
//	public static Boolean waitForPreferanceLoad() throws Exception
//	{
//		Boolean status = false;
//		try
//		{
//			WebDriverWait preferenceloader = new WebDriverWait(GlobalVariable.driver, 45);
//			preferenceloader.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getPreferenceLoader())));
//	 	   	SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, NextstepFaxInbox.getPreferenceLoader());
//	 	   	WebDriverWait timeline = new WebDriverWait(GlobalVariable.driver, 45);
//	 	   	timeline.until(ExpectedConditions.elementToBeClickable(NextstepFaxInbox.getActivityTimeoutDropdown()));       	   
//	        status = true;
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//		}
//		return status;
//	}
//	
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
//	
//	public static Boolean clickDatePickerDropDown() throws Exception
//	{
//		Boolean status=false;
//		WebElement datePicker = NextstepFaxInbox.getDateRangePicker();
//		try
//		{
//			if(SeleniumHelper.isExist(datePicker))
//			{
//				SeleniumHelper.click( datePicker);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Date picker Drop Down is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select date picker drop down");
//		}
//		return status;
//	}
//	
//	public static Boolean clickGridFilterOptions() throws Exception
//	{
//		Boolean status=false;
//		WebElement gridFilter = NextstepFaxInbox.getGridFilterOptions();
//		try
//		{
//			if(SeleniumHelper.isExist(gridFilter))
//			{
//				SeleniumHelper.click( gridFilter);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Grid Filter Drop Down is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Grid Filter drop down");
//		}
//		return status;
//	}
//					
//	public static Boolean clickResetFilter() throws Exception
//	{
//		Boolean status=false;
//		WebElement reset = NextstepFaxInbox.getFilterReset();
//		try
//		{
//			if(SeleniumHelper.isExist(reset))
//			{
//				SeleniumHelper.click( reset);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Reset button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Reset button");
//		}
//		return status;
//	}
//	
//	public static Boolean clickSearch() throws Exception
//	{
//		Boolean status=false;
//		WebElement search = NextstepFaxInbox.getFilterSearch();
//		try
//		{
//			if(SeleniumHelper.isExist(search))
//			{
//				SeleniumHelper.click( search);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "search button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select search button");
//		}
//		return status;
//	}
//	
//	public static Boolean selectCreateSubFolder() throws Exception
//	{
//		Boolean status=false;
//		WebElement createSubFolder = NextstepFaxInbox.getCreateSubFolder();
//		try
//		{
//			if(SeleniumHelper.isExist(createSubFolder))
//			{
//				SeleniumHelper.click( createSubFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Create sub folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Create sub folder");
//		}
//		return status;
//	}
//	
//	public static Boolean clickRenameFolder() throws Exception
//	{
//		Boolean status=false;
//		WebElement renameFolder = NextstepFaxInbox.getRenameFolder();
//		try
//		{
//			if(SeleniumHelper.isExist(renameFolder))
//			{
//				SeleniumHelper.click( renameFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Rename Folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Rename Folder");
//		}
//		return status;
//	}
//	
//	public static Boolean clickMoveFolder() throws Exception
//	{
//		Boolean status=false;
//		WebElement moveFolder = NextstepFaxInbox.getMoveFolder();
//		try
//		{
//			if(SeleniumHelper.isExist(moveFolder))
//			{
//				SeleniumHelper.click( moveFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Move Folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Move Folder");
//		}
//		return status;
//	}
//	
//	public static Boolean clickDeleteFolder() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(1000);
//		WebElement deleteFolder = NextstepFaxInbox.getDeleteFolder();	
//		try
//		{
//			if(SeleniumHelper.isExist(deleteFolder))
//			{
//				SeleniumHelper.click( deleteFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Delete Folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Delete Folder");
//		}
//		return status;
//	}
//	
//	public static Boolean clickPersonalFolderArchived() throws Exception
//	{
//		Boolean status=false;
//		WebElement archivedFolder = NextstepFaxInbox.getPersonalFolderArchived();	
//		try
//		{
//			if(SeleniumHelper.isExist(archivedFolder))
//			{
//				SeleniumHelper.click(archivedFolder);
//				Thread.sleep(1000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Archived Folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Archived Folder");
//		}
//		return status;
//	}
//	
//	public static Boolean clickRestoreButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement restore = NextstepFaxInbox.getRestoreButton();
//		try
//		{
//			if(SeleniumHelper.isExist(restore))
//			{
//				SeleniumHelper.click( restore);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Restore is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Restore");
//		}
//		return status;
//	}
//	
//	public static Boolean clickEmptyFolder() throws Exception
//	{
//		Boolean status=false;
//		WebElement emptyFolder = NextstepFaxInbox.getEmptyFolder();
//		try
//		{
//			if(SeleniumHelper.isExist(emptyFolder))
//			{				
//				SeleniumHelper.click( emptyFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Empty Folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Empty Folder");
//		}
//		return status;
//	}
//	
//	public static Boolean rightClickFolder(WebElement control) throws Exception
//	{
//		Boolean status=false;	
//		try
//		{
//			if(SeleniumHelper.isExist(control))
//			{								
//				SeleniumHelper.contextClick( control);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, control.getText() +" is  Right Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to right click Folder");
//		}
//		return status;
//	}
//	
//	public static Boolean enterFolderNameAndCreate(String folderName) throws Exception
//	{
//		Boolean status = false;
//		WebElement textBox = NextstepFaxInbox.getNewFolderName();
//		try
//		{
//			if(SeleniumHelper.isExist(textBox))
//			{
//				if(SeleniumHelper.setText(textBox,folderName))
//				{
//					WebElement create = NextstepFaxInbox.getNewFolderNamePopUpCreate();
//					SeleniumHelper.click( create);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, folderName + " folder is created as sub folder");
//				}
//				else
//				{
//					status = false;
//					Logger.writeDayLog(Logger.messageType.Fail, folderName + " folder is not created as sub folder");
//				}			
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, folderName + " folder is not created as sub folder");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, folderName + " folder is not created as sub folder" + e.getMessage());
//		}
//		return status;
//	}
//	
//	public static Boolean clickSearchDropDown() throws Exception
//	{
//		Boolean status=false;		
//		WebElement filterDropDown = NextstepFaxInbox.getSearchFilterDropDownButton();		
//		try
//		{
//			if(SeleniumHelper.isExist(filterDropDown))
//			{				
//				SeleniumHelper.click( filterDropDown);
//				WebElement filterDropDownMenu = NextstepFaxInbox.getSearchFilterDropDownMenu();
//				status = SeleniumHelper.isExist(filterDropDownMenu);				 
//				Logger.writeDayLog(Logger.messageType.Pass, "Search filter is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Search filter");
//		}
//		return status;
//	}
//	
//	public static Boolean clickSearchDropDownInbound() throws Exception
//	{
//		Boolean status=false;		
//		WebElement inbound = NextstepFaxInbox.getSearchFilterDropDownMenuInbound();
//		try
//		{
//			if(SeleniumHelper.isExist(inbound))
//			{				
//				SeleniumHelper.click( inbound);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Inbound search filter is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Inbound search filter");
//		}
//		return status;
//	}
//	
//	public static Boolean clickSearchDropDownOutbound() throws Exception
//	{
//		Boolean status=false;		
//		WebElement outbound = NextstepFaxInbox.getSearchFilterDropDownMenuOutbound();
//		try
//		{
//			if(SeleniumHelper.isExist(outbound))
//			{				
//				SeleniumHelper.click( outbound);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Outbound search filter is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Outbound search filter");
//		}
//		return status;
//	}
//	
//	
//	public static Boolean clickSearchDropDownFrom() throws Exception
//	{
//		Boolean status=false;		
//		WebElement from = NextstepFaxInbox.getSearchFilterDropDownMenuFrom();
//		try
//		{
//			if(SeleniumHelper.isExist(from))
//			{				
//				SeleniumHelper.click( from);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "From search filter is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select from search filter");
//		}
//		return status;
//	}
//	
//	public static Boolean clickSearchDropDownTo() throws Exception
//	{
//		Boolean status=false;		
//		WebElement to = NextstepFaxInbox.getSearchFilterDropDownMenuTo();
//		try
//		{
//			if(SeleniumHelper.isExist(to))
//			{				
//				SeleniumHelper.click( to);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "To search filter is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select to search filter");
//		}
//		return status;
//	}
//	
//	public static Boolean clickSearchDropDownPages() throws Exception
//	{
//		Boolean status=false;						
//		WebElement filterDropDownMenu = NextstepFaxInbox.getSearchFilterDropDownMenu();
//		status = SeleniumHelper.isExist(filterDropDownMenu);				 
//		try
//		{
//			if(isPagesExistInFaxInbox())
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Pages search filter available in Table, Search drop down should have Pages");
//				WebElement pages = NextstepFaxInbox.getSearchFilterDropDownMenuPages();
//				if(SeleniumHelper.isExist(pages))
//				{				
//					SeleniumHelper.click( pages);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Pages search filter is Clicked Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Pages search filter not available in Table, General menu in Search drop down should have Pages");
//				WebElement general = NextstepFaxInbox.getSearchFilterDropDownMenuGeneral();
//				Actions action = new Actions(GlobalVariable.driver);				 		       
//		        if(SeleniumHelper.isExist(general))
//				{				
//		        	action.moveToElement(general).click(NextstepFaxInbox.getSearchFilterDropDownGeneralMenuPages()).build().perform();
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Pages search filter is Clicked Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Pages search filter");
//		}
//		return status;
//	}
//
//	public static Boolean isPagesExistInFaxInbox() throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> temp = NextstepFaxInbox.getFaxInboxGridHeader();		
//		WebElement filterDropDownMenu = NextstepFaxInbox.getSearchFilterDropDownMenu();
//		try
//		{			
//			if((SeleniumHelper.isExist(filterDropDownMenu)) && (SeleniumHelper.isExist(filterDropDownMenu)))
//			{		
//				for(int i=0; i<=temp.size();i++)
//				{
//					if(temp.get(i).getText().equals("Pages"))
//					{
//						return true;
//					}
//				}				
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Document property is displayed");
//		}
//		return status;
//	}
//	
//	public static Boolean enterSearchText(String searchText) throws Exception
//	{
//		Boolean status = false;
//		WebElement textBox = NextstepFaxInbox.getSearchFilterInputBox();
//		try
//		{
//			if(SeleniumHelper.isExist(textBox))
//			{
//				if(SeleniumHelper.setText(textBox,searchText))
//				{					
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, searchText + " entered in searchbox");
//				}
//				else
//				{
//					status = false;
//					Logger.writeDayLog(Logger.messageType.Fail, searchText + " is failed to enter in search box");
//				}			
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, "Control not exist");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	
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
//	
//	public static Boolean enterFolderNameAndUpdate(String folderName) throws Exception
//	{
//		Boolean status = false;
//		WebElement textBox = NextstepFaxInbox.getRenameFolderName();
//		try
//		{
//			if(SeleniumHelper.isExist(textBox))
//			{
//				if(SeleniumHelper.setText(textBox,folderName))
//				{
//					WebElement update = NextstepFaxInbox.getRenameFolderConfirm();
//					SeleniumHelper.click( update);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, folderName + " as updated");
//				}
//				else
//				{
//					status = false;
//					Logger.writeDayLog(Logger.messageType.Fail, folderName + " folder name updation failed");
//				}			
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail,"Updation of folder name not done");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception,"Updation of folder name not done" + e.getMessage());
//		}
//		return status;
//	}
//	
//	public static Boolean clickNewFaxButtom() throws Exception
//	{
//		Boolean status=false;		
//		WebElement newFax = NextstepFaxInbox.getNewFax();
//		try
//		{
//			if(SeleniumHelper.isExist(newFax))
//			{				
//				SeleniumHelper.click( newFax);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "New Fax button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click new fax button");
//		}
//		return status;
//	}
//	
//	public static Boolean clickMoveFax() throws Exception
//	{
//		Boolean status=false;		
//		WebElement moveFax = NextstepFaxInbox.getMoveFax();
//		try
//		{
//			if(SeleniumHelper.isExist(moveFax))
//			{				
//				SeleniumHelper.click( moveFax);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Move Fax button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Move Fax");
//		}
//		return status;
//	}
//	
//	public static Boolean clickCopyFax() throws Exception
//	{
//		Boolean status=false;		
//		WebElement copyFax = NextstepFaxInbox.getCopyFax();
//		try
//		{
//			if(SeleniumHelper.isExist(copyFax))
//			{				
//				SeleniumHelper.click( copyFax);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Copy Fax button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Copy Fax");
//		}
//		return status;
//	}
//	
//	public static Boolean clickArchiveFax() throws Exception
//	{
//		Boolean status=false;		
//		WebElement archiveFax = NextstepFaxInbox.getArchiveFax();
//		try
//		{
//			if(SeleniumHelper.isExist(archiveFax))
//			{				
//				SeleniumHelper.click( archiveFax);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Archive Fax button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Archive Fax");
//		}
//		return status;
//	}
//	
//	public static Boolean clickDeleteFax() throws Exception
//	{
//		Boolean status=false;		
//		WebElement deleteFax = NextstepFaxInbox.getDeleteFax();
//		try
//		{
//			if(SeleniumHelper.isExist(deleteFax))
//			{				
//				SeleniumHelper.click(deleteFax);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Delete Fax button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Delete Fax");
//		}
//		return status;
//	}
//		
//	public static Boolean clickMoveCopyDropDown() throws Exception
//	{
//		Boolean status=false;		
//		Thread.sleep(3000);
//		WebElement editView = NextstepFaxInbox.getMoveCopyPopUpDropDown();
//		try
//		{
//			if(SeleniumHelper.isExist(editView))
//			{				
//				SeleniumHelper.click( editView);
//				status = true;
//				WebElement austria = new WebDriverWait(GlobalVariable.driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='treeList']")));										
//				Logger.writeDayLog(Logger.messageType.Pass, "Move Copy DropDown is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Move Copy DropDown");
//		}
//		return status;
//	}
//	
//	//FirstFolderToMove
//	public static Boolean selectFirstFolderToMove() throws Exception
//	{
//		Boolean status=false;		
//		WebElement firstFolder = NextstepFaxInbox.getFirstFolderToMove();
//		try
//		{
//			if(SeleniumHelper.isExist(firstFolder))
//			{				
//				SeleniumHelper.click( firstFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "first folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click first folder");
//		}
//		return status;
//	}
//	
//	public static Boolean selectSecondFolderToCopy() throws Exception
//	{
//		Boolean status=false;		
//		WebElement secondFolder = NextstepFaxInbox.getSecondFolderToCopy();
//		try
//		{
//			if(SeleniumHelper.isExist(secondFolder))
//			{				
//				SeleniumHelper.click( secondFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "second folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click second folder");
//		}
//		return status;
//	}
//	
//	public static Boolean selectFirstFolderToCopy() throws Exception
//	{
//		Boolean status=false;		
//		WebElement firstFolder = NextstepFaxInbox.getFirstFolderToCopy();
//		try
//		{
//			if(SeleniumHelper.isExist(firstFolder))
//			{				
//				SeleniumHelper.click(firstFolder);	
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "first folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click first folder");
//		}
//		return status;
//	}
//	
//	//getFaxInboxGriddRows
//	public static Boolean selectFaxInGrid(int i) throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> firstFolder = NextstepFaxInbox.getFaxInboxGriddRows();
//		try
//		{
//			if(firstFolder.size()>=1)
//			{
//				if(SeleniumHelper.isExist(firstFolder.get(i)))
//				{				
//					SeleniumHelper.click( firstFolder.get(i));
//					documentID = getDocumentIDWithIndex(i);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "First fax is selected Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//				FaxInbox.waitForPageLoad();				
//				Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//				List<WebElement>folder = NextstepFaxInbox.getFaxInboxGriddRows();
//				if(SeleniumHelper.isExist(folder.get(i)))
//				{				
//					documentID = getDocumentIDWithIndex(i);
//					SeleniumHelper.click( folder.get(i));
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "click on first fax Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	
//	public static Boolean contextClickFaxInGrid(int i) throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> firstFolder = NextstepFaxInbox.getFaxInboxGriddRows();
//		try
//		{
//			if(firstFolder.size()>1)
//			{
//				if(SeleniumHelper.isExist(firstFolder.get(i)))
//				{				
//					documentID = getDocumentIDWithIndex(i);
//					//mergeDocumentID = getDocumentIDWithIndex(i);
//					Logger.writeDayLog(Logger.messageType.Pass, documentID);
//					SeleniumHelper.contextClick( firstFolder.get(i));
//					Thread.sleep(1000);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Context click on first fax Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//				FaxInbox.waitForPageLoad();				
//				Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//				List<WebElement>folder = NextstepFaxInbox.getFaxInboxGriddRows();
//				if(SeleniumHelper.isExist(folder.get(i)))
//				{				
//					documentID = getDocumentIDWithIndex(0);
//					SeleniumHelper.contextClick( folder.get(i));
//					Thread.sleep(1000);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Context click on first fax Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			int j;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	
//	public static Boolean confirmCopyPaste() throws Exception
//	{
//		Boolean status=false;		
//		WebElement moveCopyConfirm = NextstepFaxInbox.getMoveCopyPopupconfirmButton();
//		try
//		{
//			if(SeleniumHelper.isExist(moveCopyConfirm))
//			{				
//				SeleniumHelper.click( moveCopyConfirm);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Move/Copy confirm is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Move/Copy confirm");
//		}
//		return status;
//	}
//	
//	public static Boolean clickDeleteFaxConfirm() throws Exception
//	{
//		Boolean status=false;		
//		Thread.sleep(2000);
//		WebElement deleteFaxConfirm = NextstepFaxInbox.getDeleteFaxConfirm();
//		try
//		{
//			if(SeleniumHelper.isExist(deleteFaxConfirm))
//			{				
//				SeleniumHelper.click(deleteFaxConfirm);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Delete Fax Confirm is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Delete Fax Confirm");
//		}
//		return status;
//	}
//	
//	public static Boolean selectMarkAsUnreadContextMenu() throws Exception
//	{
//		Boolean status=false;		
//		WebElement markAsUnread = NextstepFaxInbox.getMarkAsUnreadGridContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(markAsUnread))
//			{				
//				SeleniumHelper.click( markAsUnread);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Mark As Unread is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Mark As Unread");
//		}
//		return status;
//	}
//	
//	public static Boolean selectMarkAsReadContextMenu() throws Exception
//	{
//		Boolean status=false;		
//		WebElement markAsRead = NextstepFaxInbox.getMarkAsReadGridContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(markAsRead))
//			{	
//				GlobalVariable.markDocumentAs = markAsRead.getText();
//				SeleniumHelper.click( markAsRead);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, GlobalVariable.markDocumentAs+ "Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click" + GlobalVariable.markDocumentAs);
//		}
//		return status;
//	}
//	
//	public static Boolean selectMoveContextMenu() throws Exception
//	{
//		Boolean status=false;		
//		WebElement move = NextstepFaxInbox.getMoveContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(move))
//			{				
//				SeleniumHelper.click( move);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Move is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Move");
//		}
//		return status;
//	}
//	
//	public static Boolean selectCopyContextMenu() throws Exception
//	{
//		Boolean status=false;		
//		WebElement copy = NextstepFaxInbox.getCopyContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(copy))
//			{				
//				SeleniumHelper.click(copy);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Copy is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Copy");
//		}
//		return status;
//	}
//	
//	public static Boolean selectArchiveContextMenu() throws Exception
//	{
//		Boolean status=false;		
//		WebElement archive = NextstepFaxInbox.getArchiveContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(archive))
//			{				
//				SeleniumHelper.click( archive);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Archive is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Archive");
//		}
//		return status;
//	}
//	
//	public static Boolean selectDeleteContextMenu() throws Exception
//	{
//		Boolean status=false;		
//		WebElement delete = NextstepFaxInbox.getDeleteContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(delete))
//			{				
//				SeleniumHelper.click(delete);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Delete is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Delete");
//		}
//		return status;
//	}
//	
//	public static Boolean selectPropertiesContextMenu() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(1000);
//		WebElement properties = NextstepFaxInbox.getPropertiesContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(properties))
//			{				
//				SeleniumHelper.click(properties);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Properties is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Properties");
//		}
//		return status;
//	}
//	
//	public static Boolean clickDownloadFaxContext() throws Exception
//	{
//		Boolean status=false;		
//		WebElement download = NextstepFaxInbox.getDownloadContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(download))
//			{				
//				SeleniumHelper.click(download);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Download is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Download");
//		}
//		return status;
//	}
//	
//	public static Boolean isPropertyExist() throws Exception
//	{
//		Boolean status=false;		
//		WebElement TL = NextstepFaxInbox.getMyPropertiesTimeLineTab();
//		WebElement DD = NextstepFaxInbox.getMyPropertiesDocumentDetailTab();
//		try
//		{
//			if((SeleniumHelper.isExist(TL)) && (SeleniumHelper.isExist(DD)))
//			{								
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document property is displayed");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Document property is displayed");
//		}
//		return status;
//	}
//	
//	public static String[] getDocumentID() throws Exception
//	{		
//		WebElement temp = null;
//		List<WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();
//		String[] rowValue = new String[rows.size()];
//		try
//		{
//			for(int i = 0; i<rows.size(); i++)
//			{
//				temp = rows.get(i);
//				rowValue[i] = temp.getAttribute("data-automation-id");
//			}
//			Logger.writeDayLog(Logger.messageType.Pass, "Document ID(s) are found");			
//		}
//		catch(Exception e)
//		{			
//			Logger.writeDayLog(Logger.messageType.Exception, "Document ID(s) are  not found");
//		}
//		return rowValue;
//	}
//	
//	public static String getDocumentIDWithIndex(int index) throws Exception
//	{
//		String value = null;;
//		WebElement temp = null;
//		List<WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();		
//		try
//		{					
//			temp = rows.get(index);
//			value = temp.getAttribute("data-automation-id");
//			Logger.writeDayLog(Logger.messageType.Pass, "Document ID for given index is found");
//		}				
//		catch(Exception e)
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Document ID is not found");
//		}
//		return value;
//	}
//	
//	public static Boolean validateRow() throws Exception
//	{
//		Boolean status = false;
//		String[] temp = new String[getDocumentID().length];
//		temp = getDocumentID();
//		try
//		{
//			for(int i=0;i<temp.length; i++)
//			{
//				if(documentID.equals(temp[i]))
//				{
//					Logger.writeDayLog(Logger.messageType.Pass, "Document Found");
//					System.out.println("Document is found");
//					status = true; 
//					break;
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Document not Found");
//			status = false;
//		}		
//		return status;		
//	}
//	
//	public static Boolean clickArchive() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(2000);
//		WebElement archive = NextstepFaxInbox.getPersonalFolderArchive();
//		try
//		{
//			if(SeleniumHelper.isExist(archive))
//			{				
//				SeleniumHelper.click(archive);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Archive folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click archive folder");
//		}
//		return status;
//	}
//	
//	public static Boolean clickPersonalFolderDeletedItems() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(2000);
//		WebElement delete = NextstepFaxInbox.getPersonalFolderDelete();
//		try
//		{
//			if(SeleniumHelper.isExist(delete))
//			{				
//				SeleniumHelper.click( delete);
//				Thread.sleep(2000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Delete folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click delete");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxInboxNextPage() throws Exception
//	{
//		Boolean status=false;		
//		WebElement next = NextstepFaxInbox.getFaxInboxNextPage();
//		try
//		{
//			if(SeleniumHelper.isExist(next))
//			{				
//				SeleniumHelper.click( next);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Next is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Next");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxInboxLastPage() throws Exception
//	{
//		Boolean status=false;		
//		WebElement lastPage = NextstepFaxInbox.getFaxInboxLastPage();
//		try
//		{
//			if(SeleniumHelper.isExist(lastPage))
//			{				
//				SeleniumHelper.click( lastPage);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Last Page is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Last Page");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxInboxPreviousPage() throws Exception
//	{
//		Boolean status=false;		
//		WebElement previous = NextstepFaxInbox.getFaxInboxPreviousPage();
//		try
//		{
//			if(SeleniumHelper.isExist(previous))
//			{				
//				SeleniumHelper.click( previous);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Previous is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Previous");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxInboxFirstPage() throws Exception
//	{
//		Boolean status=false;		
//		WebElement firstPage = NextstepFaxInbox.getFaxInboxFirstPage();
//		try
//		{
//			if(SeleniumHelper.isExist(firstPage))
//			{				
//				SeleniumHelper.click( firstPage);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "First Page is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click First Page");
//		}
//		return status;
//	}
//	
//	public static Boolean openFirstFaxInGrid() throws Exception
//	{
//		Boolean status=false;
//		List<WebElement> firstFolder = NextstepFaxInbox.getFaxInboxGriddRows();
//		try
//		{
//			if(SeleniumHelper.isExist(NextstepFaxInbox.getLoggedUserName()))
//			{
//				if(firstFolder.size()==0)
//				{				
//					SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//					FaxInbox.waitForGridLoad();
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//				}
//				List<WebElement> folder = NextstepFaxInbox.getFaxInboxGriddRows();
//				if(folder.size()==1)
//				{	
//					documentID = getDocumentIDWithIndex(0);		
//					SeleniumHelper.doubleClick(folder.get(0));
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Document is opened");
//				}
//				if(folder.size()>1)
//				{			
//					documentID = getDocumentIDWithIndex(1);
//					SeleniumHelper.doubleClick(folder.get(1));					
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Document is opened");				
//				}
//				}
//				else
//				{
//					status = false;	
//					Logger.writeDayLog(Logger.messageType.Pass, "Unable to open the document");					
//					throw new Exception();
//				}
//		}
//			
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());		
//		}
//		return status;
//	}
//
//	
//	//getFaxViewerSignature
//	public static Boolean clickFaxViewerSignatureOption() throws Exception
//	{
//		Boolean status=false;				
//		WebElement sign = NextstepFaxInbox.getFaxViewerSignature();
//		try
//		{			
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.click( sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Signature option is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click signature option");
//		}
//		return status;
//	}
//	
//	public static void waitForFaxLoad() throws Exception
//	{		
//		Thread.sleep(3000);
//		List<WebElement> faxList = NextstepFaxInbox.getThumbnailsList();
//		try
//		{						
//			while(faxList.size()==0)
//			{
//				Thread.sleep(5000);
//				faxList = NextstepFaxInbox.getThumbnailsList();
//			}
//		}
//		catch(Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Fax not loaded " +e.getMessage());
//		}		
//	}
//	
//	public static Boolean clickFaxViewerPlaceSignature() throws Exception
//	{
//		Boolean status=false;		
//		WebElement sign = NextstepFaxInbox.getFaxViewerPlaceSignature();
//		try
//		{
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.click( sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Place Signature option is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click place signature option");
//		}
//		return status;
//	}
//	
//	//getPlaceSignatureTypeNewUseSignature
//	public static Boolean clickFaxViewerUseSignature() throws Exception
//	{
//		Boolean status=false;		
//		WebElement sign = NextstepFaxInbox.getPlaceSignatureTypeNewUseSignature();
//		try
//		{
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.click( sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Use text Signature option is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click use text signature option");
//		}
//		return status;
//	}
//	
//	public static Boolean placeSignature() throws Exception
//	{
//		Boolean status=false;		
//		WebElement doc = NextstepFaxInbox.getFaxViewerDocumentArea();
//		try
//		{
//			if(SeleniumHelper.isExist(doc))
//			{				
//			    Actions act = new Actions(GlobalVariable.driver);			    
//			    Point point = doc.getLocation();			
//			    int x = point.getX()/2;
//			    int y = point.getY()/2;			    
//			    act.moveToElement(doc, x, y).click().build().perform();			    
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Signature is placeed Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to place signature");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxViewerSignatureAddDateNo() throws Exception
//	{
//		Boolean status=false;		
//		WebElement sign = NextstepFaxInbox.getFaxViewerSignatureAddDateNo();
//		try
//		{
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.click( sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Add date with Signature option No is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Add date with Signature option No");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxViewerSaveAndExit() throws Exception
//	{
//		Boolean status=false;		
//		WebElement sign = NextstepFaxInbox.getFaxViewerSaveAndExit();
//		try
//		{
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.click( sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Save and exit is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save and exit");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxViewerExit() throws Exception
//	{
//		Boolean status=false;		
//		WebElement sign = NextstepFaxInbox.getFaxViewerExit();
//		try
//		{
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.click(sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Exit is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Exit");
//		}
//		return status;
//	}
//	
//	//edit view	
//	public static Boolean clickEditView() throws Exception
//	{
//		Boolean status=false;		
//		WebElement editView = NextstepFaxInbox.getEditView();
//		try
//		{
//			if(SeleniumHelper.isExist(editView))
//			{				
//				SeleniumHelper.click( editView);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit View button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Edit View");
//		}
//		return status;
//	}
//	
//	public static Boolean clickEditViewAddColumn() throws Exception
//	{
//		Boolean status=false;		
//		WebElement editView = NextstepFaxInbox.getEditViewAddCoulmn();
//		try
//		{
//			if(SeleniumHelper.isExist(editView))
//			{				
//				SeleniumHelper.click( editView);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit View Add column button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Edit View Add column");
//		}
//		return status;
//	}
//	
//	public static Boolean clickEditViewRemoveColumn() throws Exception
//	{
//		Boolean status=false;		
//		WebElement editView = NextstepFaxInbox.getEditViewRemoveCoulmn();
//		try
//		{
//			if(SeleniumHelper.isExist(editView))
//			{				
//				SeleniumHelper.click( editView);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit View Remove Column button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Edit View Remove Column");
//		}
//		return status;
//	}
//	
//	public static Boolean clickEditViewAddColumnSave() throws Exception
//	{
//		Boolean status=false;		
//		WebElement editView = NextstepFaxInbox.getEditViewAddSave();
//		try
//		{
//			if(SeleniumHelper.isExist(editView))
//			{				
//				SeleniumHelper.click( editView);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit View Add Save button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Edit View Add Save");
//		}
//		return status;
//	}
//	
//	public static Boolean clickEditViewAddColumnCancel() throws Exception
//	{
//		Boolean status=false;		
//		WebElement editView = NextstepFaxInbox.getEditViewAddCancel();
//		try
//		{
//			if(SeleniumHelper.isExist(editView))
//			{				
//				SeleniumHelper.click( editView);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit View Add Column cancel button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Edit View Add Column Save");
//		}
//		return status;
//	}
//	
//	public static Boolean clickEditViewAddingColumn(String input) throws Exception
//	{
//		Boolean status=false;	
//		List<WebElement> availableCoulmn = NextstepFaxInbox.getEditViewAvailableColumn();				
//		WebElement add = NextstepFaxInbox.getEditViewAddCoulmn();		
//		int finalCount = 0;
//		try
//		{			
//			String split[]=new String[input.split("\\|").length];
//			split = input.split("\\|");
//			for(int i = 0; i<split.length;i++)
//			{
//				for(int j = 0; j<availableCoulmn.size();j++)
//				{
//					String temp = availableCoulmn.get(j).getText();
//					if(temp.equals(split[i]))
//					{
//						SeleniumHelper.click( availableCoulmn.get(j));
//						Thread.sleep(1000);
//						SeleniumHelper.click( add);						
//						availableCoulmn = NextstepFaxInbox.getEditViewAvailableColumn();
//						break;
//					}
//				}
//			}			
//			List<WebElement> selectedColumn = NextstepFaxInbox.getEditViewSelectedColumn();
//			for(int i = 0; i<split.length;i++)
//			{
//				for(int j = 0; j<selectedColumn.size();j++)
//				{
//					if(selectedColumn.get(j).getText().equals(split[i]))
//					{						
//						finalCount++;
//						break;
//					}
//				}
//			}			
//			if(finalCount == split.length)
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Given column are added to Selected column(s)");
//			}
//			
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to Add given column(s)");
//		}
//		return status;
//	}
//	
//	//getEditViewAvailableColumn
//	public static Boolean clickEditViewRemovingColumn(String input) throws Exception
//	{
//		Boolean status=false;	
//		List<WebElement> availableCoulmn = NextstepFaxInbox.getEditViewSelectedColumn();				
//		WebElement remove = NextstepFaxInbox.getEditViewRemoveCoulmn();
//		int finalCount = 0;
//		try
//		{			
//			String split[]=new String[input.split("\\|").length];
//			split = input.split("\\|");
//			for(int i = 0; i<split.length;i++)
//			{
//				for(int j = 0; j<availableCoulmn.size();j++)
//				{
//					String temp = availableCoulmn.get(j).getText();
//					if(temp.equals(split[i]))
//					{
//						SeleniumHelper.click( availableCoulmn.get(j));
//						Thread.sleep(1000);
//						SeleniumHelper.click( remove);						
//						availableCoulmn = NextstepFaxInbox.getEditViewSelectedColumn();
//						break;
//					}
//				}
//			}			
//			List<WebElement> selectedColumn = NextstepFaxInbox.getEditViewAvailableColumn();
//			for(int i = 0; i<split.length;i++)
//			{
//				for(int j = 0; j<selectedColumn.size();j++)
//				{
//					if(selectedColumn.get(j).getText().equals(split[i]))
//					{						
//						finalCount++;
//						break;
//					}
//				}
//			}			
//			if(finalCount == split.length)
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Given column are removed from Selected column(s)");
//			}
//			
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to remove given column(s)");
//		}
//		return status;
//	}
//	
//	public static Boolean doubleClickSharedQueueFolderHeader() throws Exception
//	{
//		Boolean status=false;		
//		WebElement sign = NextstepFaxInbox.getSharedQueueFolderHeader();
//		try
//		{
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.doubleClick(sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Shared Queue header is double Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to double click Shared Queue header");
//		}
//		return status;
//	}
//	
//	public static Boolean selectFirstSharedQueueFolder() throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> firstFolder = NextstepFaxInbox.getSharedQueueSubFolders();
//		try
//		{
//			if(firstFolder.size()>0)
//			{
//				if(SeleniumHelper.isExist(firstFolder.get(0)))
//				{				
//					SeleniumHelper.click( firstFolder.get(0));					
//					status = true;
//					Thread.sleep(1000);
//					Logger.writeDayLog(Logger.messageType.Pass, "Selected first shared queue");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "No data found in grid");
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	
//	//getMyPropertiesDocumentDetailTab
//	public static Boolean clickPropertiesDocumentDetailTab() throws Exception
//	{
//		Boolean status=false;
//		WebElement documentDetail = NextstepFaxInbox.getMyPropertiesDocumentDetailTab();
//		try
//		{
//			if(SeleniumHelper.isExist(documentDetail))
//			{				
//				SeleniumHelper.click( documentDetail);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document detail tab is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Document detail tab");
//		}
//		return status;
//	}
//	
//	public static Boolean clickDocumentStatusDropDown() throws Exception
//	{
//		Boolean status=false;		
//		WebElement documentStatusDropDown = NextstepFaxInbox.getDocumentStatusDropDown();
//		try
//		{
//			if(SeleniumHelper.isExist(documentStatusDropDown))
//			{				
//				SeleniumHelper.click( documentStatusDropDown);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document status dropdown is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Document status dropdown");
//		}
//		return status;
//	}
//	
//	public static Boolean selectDocumentStatusDropDownOption() throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> firstOption = NextstepFaxInbox.getDocumentStatusDropDownList();
//		try
//		{
//			if(firstOption.size()>0)
//			{
//				if(SeleniumHelper.isExist(firstOption.get(1)))
//				{				
//					SeleniumHelper.click( firstOption.get(1));							
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Selected first Document status");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "No data found in dropdown");
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	
//	public static Boolean clickDocumentDetailClose() throws Exception
//	{
//		Boolean status=false;		
//		WebElement documentDetailClose = NextstepFaxInbox.getDocumentDetailCloseButton();
//		try
//		{
//			if(SeleniumHelper.isExist(documentDetailClose))
//			{				
//				SeleniumHelper.click( documentDetailClose);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document detail close is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Document detail close");
//		}
//		return status;
//	}
//	
//	public static Boolean clickPreferance() throws Exception
//	{
//		Boolean status=false;		
//		WebElement preferance = NextstepFaxInbox.getPreferanceButton();
//		try
//		{
//			if(SeleniumHelper.isExist(preferance))
//			{				
//				SeleniumHelper.click( preferance);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Preferance is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Preferance");
//		}
//		return status;
//	}
//	
//	public static Boolean clickDefaultSharedQueueDropDown() throws Exception
//	{
//		Boolean status=false;		
//		WebElement defaultSharedQueueDropDown = NextstepFaxInbox.getDefaultSharedQueueDropDown();
//		try
//		{
//			if(SeleniumHelper.isExist(defaultSharedQueueDropDown))
//			{				
//				SeleniumHelper.click(defaultSharedQueueDropDown);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Default Shared Queue DropDown is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Default Shared Queue DropDown ");
//		}
//		return status;
//	}
//	
//	public static Boolean selectDefaultSharedQueueFromList() throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> defaultSharedQueueDropDown = NextstepFaxInbox.getDefaultSharedQueueDropDownList();	
//		try
//		{	
//			if(defaultSharedQueueDropDown.size()>1)
//			{							
//					SeleniumHelper.click(defaultSharedQueueDropDown.get(1));
////					Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();					
////					keyboard.pressKey(Keys.DOWN);	
////					keyboard.pressKey(Keys.TAB);
//					WebElement temp = NextstepFaxInbox.getPreferanceSaveButton();					
//					SeleniumHelper.click( temp);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Default Shared Queue option is selected Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}			
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Default Shared Queue option ");
//		}
//		return status;
//	}	
//	
//	public static void getSelectedSharedQueueDropDownValue() throws Exception
//	{
//		clickPreferance();
//		waitForPreferanceLoad();
//		WebElement temp = NextstepFaxInbox.getSelectedDefaultSharedQueue();
//		String x = temp.getAttribute("innerText");
//		GlobalVariable.defaultSharedQueue = x;
//		WebElement cancel = NextstepFaxInbox.getPreferanceCancelButton();
//		SeleniumHelper.click( cancel);	
//	}
//	
//	public static Boolean validateDefaultSharedQueue() throws Exception
//	{
//		Boolean status = false;
//		WebElement currentFolder = NextstepFaxInbox.getCurrentFolderName();
//		try
//		{
//			if(SeleniumHelper.isExist(currentFolder))
//			{
//				if(GlobalVariable.defaultSharedQueue.equals(currentFolder.getAttribute("innerText")))
//				{
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Page loaded with default shared queue folder" + GlobalVariable.defaultSharedQueue);
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Page not loaded with " + currentFolder.getAttribute("innerText") + " instead of" +GlobalVariable.defaultSharedQueue);
//		}
//		return status;
//	}
//	
//	public static Boolean dragDropAFax() throws Exception
//	{
//		Boolean status = false;
//		WebElement From = GlobalVariable.driver.findElement(By.xpath("//div[@id ='detailView']//table[@role='treegrid']//tr[2]//img[@id='draggable']"));	
//		documentID = getDocumentIDWithIndex(1);
//		WebElement To = GlobalVariable.driver.findElement(By.xpath("//span[contains(text(),'DND')]"));
//		try
//		{
//			if(SeleniumHelper.dragAndDropE2E( GlobalVariable.driver,From, To))
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass,"Fax is Drag and Dropped to " + To.getText() + " Folder");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to drag and drop fax");
//		}
//		return status;
//	}
//	
//	public static Boolean clickDND() throws Exception
//	{
//		Boolean status=false;		
//		WebElement archive = GlobalVariable.driver.findElement(By.xpath("//span[contains(text(),'DND')]"));
//		try
//		{
//			if(SeleniumHelper.isExist(archive))
//			{				
//				SeleniumHelper.click( archive);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "DND folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click DND folder");
//		}
//		return status;
//	}
//	
//	public static Boolean isInMyPersonalFolder() throws Exception
//	{
//		Boolean status = false;
//		WebElement currentFolder = NextstepFaxInbox.getCurrentFolderName();
//		try
//		{
//			if(SeleniumHelper.isExist(currentFolder))
//			{
//				if((currentFolder.getAttribute("innerText").equals("My Personal Folder")))
//				{
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Page loaded with My Personal Folder as default folder" + GlobalVariable.defaultSharedQueue);
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Page not loaded with My Personal Folder");
//		}
//		return status;
//	}
//	
//	public static Boolean gotoMyPersonalFolder() throws Exception
//	{
//		Boolean status=false;		
//		WebElement myPersonalFolder = NextstepFaxInbox.getMyPersonalFolder();
//		Thread.sleep(1000);
//		try
//		{
//			if(isInMyPersonalFolder())
//			{
//				status=true;
//			}
//			else
//			{
//				if(SeleniumHelper.isExist(myPersonalFolder))
//				{				
//					SeleniumHelper.click(myPersonalFolder);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "My Personal Folder is Clicked Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click My Personal folder");
//		}
//		return status;
//	}
//	
//	public static Boolean verifyEditViewCoulmn() throws Exception
//	{
//		Boolean status = false;
//		String[] val = new String[2];
//		val[0]= "Document Status";
//		val[1]= "Tags";
//		List<WebElement> availableColumn = NextstepFaxInbox.getEditViewAvailableColumn();
//		List<WebElement> selectedColumn = NextstepFaxInbox.getEditViewSelectedColumn();
//		int count = 0;
//		try
//		{
//			for(int i=0; i<availableColumn.size(); i++)
//			{
//				for(int j =0; j<val.length;j++)
//				{
//					if(availableColumn.get(i).getAttribute("innerText").equals(val[j]))
//					{
//						count++;
//					}
//				}
//			}		
//			for(int i=0; i<selectedColumn.size(); i++)
//			{
//				for(int j =0; j<val.length;j++)
//				{
//					if(availableColumn.get(i).getAttribute("innerText").equals(val[j]))
//					{
//						count++;
//					}
//				}
//			}		
//			if(count==0)
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Given column not found in My Personal Folder");
//			}
//			else
//			{
//				status = false;		
//			}
//		}
//		catch(Exception e)
//		{
//			Logger.writeDayLog(Logger.messageType.Warning, "Given column found in My Personal Folder");
//		}
//		return status;
//	}	
//	
//	public static Boolean enterFaxNumber(String value) throws Exception
//	{
//		Boolean status = false;
//		Thread.sleep(3000);
//		WebElement faxNumberBox = NextstepFaxInbox.getFaxNumberInputBox();
//		try
//		{
//			if(SeleniumHelper.setText(faxNumberBox, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as faxNumber");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in faxNumber");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter faxNumber");
//		}			
//		return status;
//	}
//	
//	public static Boolean clickUploadFax() throws Exception
//	{
//		Boolean status=false;		
//		WebElement uploadFax = NextstepFaxInbox.getUploadFax();
//	
//		try
//		{
//			GlobalVariable.driver.findElement(By.xpath("//input[@id='upload-doc']")).sendKeys("C:\\Users\\Auxo User\\Desktop\\Tiff pages\\testsample.tif");
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "UploadFax is Clicked Sucessfully");
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click UploadFax");
//		}
//		return status;
//	}
//		
//	public static Boolean selectSendFaxMenu() throws Exception
//	{
//		Boolean status=false;
//		WebElement sendFaxMenu = NextstepFaxInbox.getFaxViewerSendButton();
//		Thread.sleep(5000);
//		try
//		{
//			if(SeleniumHelper.isExist(sendFaxMenu))
//			{
//				SeleniumHelper.click( sendFaxMenu);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Send Fax Menu is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Send Fax Menu");
//		}
//		return status;
//	}
//	
//	//div[@id='edit-page-menu']
//	public static Boolean clickEditPages() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(5000);
//		WebElement editPage = NextstepFaxInbox.getEditPages();
//		try
//		{
//			if(SeleniumHelper.isExist(editPage))
//			{
//				SeleniumHelper.click( editPage);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit pages is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Edit pages");
//		}
//		return status;
//	}
//	
//	public static Boolean selectFaxViewerDownload() throws Exception
//	{
//		Boolean status=false;
//		WebElement download = NextstepFaxInbox.getFaxViewerDownload();
//		try
//		{
//			if(SeleniumHelper.isExist(download))
//			{
//				SeleniumHelper.click( download);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax viewer download is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax viewer download");
//		}
//		return status;
//	}
//	
//	public static Boolean selectFaxViewerPrint() throws Exception
//	{
//		Boolean status=false;
//		WebElement print = NextstepFaxInbox.getFaxViewerPrint();
//		try
//		{
//			if(SeleniumHelper.isExist(print))
//			{
//				SeleniumHelper.click( print);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax viewer print is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax viewer print");
//		}
//		return status;
//	}
//	
//	public static Boolean selectFaxViewerMove() throws Exception
//	{
//		Boolean status=false;
//		WebElement move = NextstepFaxInbox.getFaxViewerSendMoveDocument();
//		try
//		{
//			if(SeleniumHelper.isExist(move))
//			{
//				SeleniumHelper.click( move);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax viewer move is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax viewer move");
//		}
//		return status;
//	}
//	
//	public static Boolean selectFaxViewerCopy() throws Exception
//	{
//		Boolean status=false;
//		WebElement copy = NextstepFaxInbox.getFaxViewerSendCopyDocument();
//		try
//		{
//			if(SeleniumHelper.isExist(copy))
//			{
//				SeleniumHelper.click( copy);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax viewer copy is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax viewer copy");
//		}
//		return status;
//	}
//	
//	public static Boolean selectFaxViewerEMail() throws Exception
//	{
//		Boolean status=false;
//		WebElement eMail = NextstepFaxInbox.getFaxViewerSendEMailDocument();
//		try
//		{
//			if(SeleniumHelper.isExist(eMail))
//			{
//				SeleniumHelper.click( eMail);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax viewer EMail is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax viewer EMail");
//		}
//		return status;
//	}
//	
//	public static Boolean selectFaxViewerFax() throws Exception
//	{
//		Boolean status=false;
//		WebElement fax = NextstepFaxInbox.getFaxViewerSendFaxDocument();
//		try
//		{
//			if(SeleniumHelper.isExist(fax))
//			{
//				SeleniumHelper.click( fax);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax viewer Fax is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax viewer Fax");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxSend() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(3000);		
//		try
//		{
//			WebElement austria = new WebDriverWait(GlobalVariable.driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='createNewFax-folderSelection-list']//span[contains(text(),'')]")));			
//			WebElement faxSend = NextstepFaxInbox.getFaxSendButton();
//			if(SeleniumHelper.isExist(faxSend))
//			{
//				SeleniumHelper.click( faxSend);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax send is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax send");
//		}
//		return status;
//	}
//	
//	public static Boolean waitForMailSend() throws Exception
//	{
//		Boolean status = false;
//		WebElement allPageLoader = null;
//		try
//		{
//			allPageLoader = NextstepFaxInbox.getSendFaxLoadingSpinner();			
//			SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, allPageLoader);		
//			WebElement austria = new WebDriverWait( GlobalVariable.driver,5).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
//			Logger.writeDayLog(Logger.messageType.Pass, "Fax sent successfully");
//			status = true;
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception,"Fax not sent " + e.getMessage() );
//		}
//		return status;
//	}
//	
//	public static Boolean clickFaxSendSuccessOk() throws Exception
//	{
//		Boolean status=false;					
//		WebElement faxSendOk = NextstepFaxInbox.getSendFaxSuccessOkie();
//		try
//		{
//			if(validateFaxQueuedSuccessfully())
//			{
//				if(SeleniumHelper.isExist(faxSendOk))
//				{
//					SeleniumHelper.click( faxSendOk);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Email queued success ok is Clicked Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				if(SeleniumHelper.isExist(faxSendOk))
//				{
//					SeleniumHelper.click( faxSendOk);
//					SeleniumHelper.click( NextstepFaxInbox.getSendFaxCancelButton());
//					status = false;
//					Logger.writeDayLog(Logger.messageType.Pass, "Failed to queue fax");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax queued success ok");
//		}
//		return status;
//	}
//	
//	public static Boolean enterToEmailAddress(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement eMailTo = NextstepFaxInbox.getSendEMailTo();
//		try
//		{
//			if(SeleniumHelper.setText(eMailTo, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as eMail to");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in eMail to");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter eMail to");
//		}			
//		return status;
//	}
//	
//	public static Boolean enterEmailSubject(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement eMailSubject = NextstepFaxInbox.getSendEMailSubject();
//		try
//		{
//			if(SeleniumHelper.setText(eMailSubject, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as eMail subject");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in eMail subject");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter eMail subject");
//		}			
//		return status;
//	}
//	
//	public static Boolean clickEMailSend() throws Exception
//	{
//		Boolean status=false;
//		WebElement eMailSend = NextstepFaxInbox.getSendEMailSendButton();
//		try
//		{
//			if(SeleniumHelper.isExist(eMailSend))
//			{
//				SeleniumHelper.click( eMailSend);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "EMail send is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click EMail send");
//		}
//		return status;
//	}
//	
//	//getDownloadButton
//	public static Boolean clickDownloadButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement download = NextstepFaxInbox.getDownloadButton();
//		try
//		{
//			if(SeleniumHelper.isExist(download))
//			{
//				SeleniumHelper.click( download);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "download is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click download");
//		}
//		return status;
//	}
//	
//	public static Boolean isDownloadExist() throws Exception
//	{		
//		Boolean status = false;
//		WebElement download = null;
//		try
//		{
//			download = NextstepFaxInbox.getDownloadButton();			
//			SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, download);		
//			WebElement austria = new WebDriverWait( GlobalVariable.driver,5).until(ExpectedConditions.elementToBeClickable(download));
//			if(SeleniumHelper.isDisplayed( download));
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Download button is displayed");
//				status = true;
//			}
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception,"Download button not displayed " + e.getMessage() );
//		}
//		return status;
//	}
//
//	public static Boolean isPrintExist() throws Exception
//	{		
//		Boolean status = false;
//		Thread.sleep(3000);
//		WebElement print = null;
//		try
//		{
//			print = NextstepFaxInbox.getPrintButton();
//			WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 10);
//            wait.until(ExpectedConditions.visibilityOf(print));			
//			if(SeleniumHelper.isDisplayed( print));
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Print button is displayed");
//				status = true;
//			}
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception,"Print button not displayed " + e.getMessage() );
//		}
//		return status;
//	}
//	
//	public static Boolean clickPrintPopUpClose() throws Exception
//	{
//		Boolean status=false;
//		WebElement eMailSend = NextstepFaxInbox.getPrintPopUpClose();
//		try
//		{
//			if(SeleniumHelper.isExist(eMailSend))
//			{
//				SeleniumHelper.click( eMailSend);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Print Popup Close is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Print Popup Close");
//		}
//		return status;
//	}
//	
//	public static Boolean clickDownloadPopUpClose() throws Exception
//	{
//		Boolean status=false;
//		WebElement downloadClose = NextstepFaxInbox.getDownloadPopUpClose();
//		try
//		{
//			if(SeleniumHelper.isExist(downloadClose))
//			{
//				SeleniumHelper.click( downloadClose);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Download Popup Close is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Download Popup Close");
//		}
//		return status;
//	}
//	
//	public static Boolean splitPage() throws Exception
//	{
//		Boolean status = false;
//		List<WebElement> pageList = NextstepFaxInbox.getEditPagesList();
//		WebElement firstPage = NextstepFaxInbox.getFirstPage();
//		int count =pageList.size();
//		try
//		{
//			if(pageList.size()<=1)
//			{
//				status=clickFaxViewerExit();	
//				waitForFaxLoad();
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax having single page so skipped split");
//			}
//			else
//			{
//				Actions action = new Actions(GlobalVariable.driver);				 
//		        action.moveToElement(firstPage).perform();		 
//		        WebElement subElement = NextstepFaxInbox.getFirstPageMoveButton();		 
//		        action.moveToElement(subElement);		 
//		        action.click();		 
//		        action.perform();
//		        status = clickSaveAndExit();	
//		        waitForPageLoad();
//		        FaxInbox.openLastEditedDocument();
//		        waitForPageLoad();
//		        WebElement pageCount = NextstepFaxInbox.getViewetPagesCount();
//		        String number = pageCount.getText();
//		    	String[] parts = number.split(" ");
//		    	String part1 = parts[0];
//		        int afterpagecount=Integer.parseInt(part1);		        
//		        if(afterpagecount == (count-1))
//		        {
//		        	Logger.writeDayLog(Logger.messageType.Pass, "First page is split");
//		        	status =true;
//		        	System.out.println("split page validation is sucessfull");
//		        }		        
//			}
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Failed to split document");
//		}		
//		return status;
//	}
//	
//	public static Boolean clickSaveAndExit() throws Exception
//	{
//		Boolean status=false;
//		WebElement savenExit = NextstepFaxInbox.getSaveAndExit();
//		try
//		{
//			if(SeleniumHelper.isExist(savenExit))
//			{
//				SeleniumHelper.click( savenExit);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Save and Exit is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save and Exit");
//		}
//		return status;
//	}
//	
//	public static Boolean clickSettingDocumentStatusCompleteOk() throws Exception
//	{
//		Boolean status=false;					
//		WebElement faxSendOk = NextstepFaxInbox.getSendFaxSuccessOkie();
//		try
//		{
//			if(SeleniumHelper.isExist(faxSendOk))
//			{
//				SeleniumHelper.click( faxSendOk);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax queued success ok is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax queued success ok");
//		}
//		return status;
//	}
//	
//	public static Boolean clickFolderDeleteConfirmationYes() throws Exception
//	{
//		Boolean status=false;		
//		WebElement sign = NextstepFaxInbox.getFolderDeleteConfirmationYes();
//		try
//		{
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.click( sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Folder Delete Confirmation is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Folder Delete Confirmation");
//		}
//		return status;
//	}
//	
//	public static Boolean setTableFaxDescription(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement description = NextstepFaxInbox.getTableFaxDescriptionTextBox();
//		try
//		{
//			if(SeleniumHelper.setText(description, value))
//			{								
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as FaxDescription");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in FaxDescription");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter FaxDescription");
//		}			
//		return status;
//	}
//	
//	public static Boolean clickTableFaxProperties() throws Exception
//	{
//		Boolean status=false;
//		WebElement tableProperty = NextstepFaxInbox.getTableFaxPropertiesButton();
//		try
//		{
//			if(SeleniumHelper.isExist(tableProperty))
//			{
//				SeleniumHelper.click( tableProperty);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "From table fax Property is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click fax Property from table");
//		}
//		return status;
//	}
//		
//	public static int getFolderCount(String name) throws Exception {
//		
//		int finalValue= -1;
//		WebElement foldercount = NextstepFaxInbox.getFolderWithName( name);
//		try
//		{
//			if(SeleniumHelper.isExist(foldercount)) {
//				String faxcount=foldercount.getText();
//				String count=faxcount.substring(faxcount.indexOf("(")+1, faxcount.indexOf(")"));		
//				double temp = Double.parseDouble(count);
//				System.out.println(temp);
//				finalValue = (int) temp;
//				Logger.writeDayLog(Logger.messageType.Pass, "foldercount is updated successfully");
//			}
//			else
//			{				
//				throw new Exception();
//			}
//			
//		}
//		catch(Exception e) 
//		{			
//			Logger.writeDayLog(Logger.messageType.Exception, " folder count is not updated");
//			return finalValue;
//		}
//		return finalValue;
//	}
//	
//	public static Boolean validateFolderCount() throws Exception
//	{
//		Boolean status = false;		
//		try
//		{
//			if(GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount -1 && GlobalVariable.afterdestinationfoldercount == GlobalVariable.beforedestinationfoldercount +1 ) 
//			{
//				status=true;
//				Logger.writeDayLog(Logger.messageType.Pass, "move folder count validation is success");
//				System.out.println("move validation is sucessfull");
//			}
//			else if(GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount -2 && GlobalVariable.afterdestinationfoldercount == GlobalVariable.beforedestinationfoldercount +2 ) 
//			{
//				status=true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Multiple document move validation is sucessfull");
//				System.out.println("Multiple document move validation is sucessfull");
//			}
//			
//			else if(GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount && GlobalVariable.afterdestinationfoldercount == GlobalVariable.beforedestinationfoldercount +1) 
//			{
//				status=true;
//				System.out.println("copy validation is successfull");	
//				Logger.writeDayLog(Logger.messageType.Pass, "copy folder count validation is success");
//			}
//			else if(GlobalVariable.afterdestinationfoldercount == GlobalVariable.beforedestinationfoldercount +2) 
//			{
//				status=true;
//				System.out.println("Multiple document copy validation is successfull");	
//				Logger.writeDayLog(Logger.messageType.Pass, "Multiple document copy validation is successfull");
//			}
//			else if(GlobalVariable.afterdestinationfolder2count == GlobalVariable.beforedestinationfolder2count +2)
//			{
//				status=true;
//				System.out.println("Multiple document copy validation with multiple folder validation successfull");	
//				Logger.writeDayLog(Logger.messageType.Pass, "Multiple document copy validation with multiple folder validation successfull");
//			}
//			
//			else
//			{
//				status = false;
//				throw new Exception();
//			}							
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Copy/Move validation failed");
//		}
//		return status;
//	}
//				
//	public static Boolean clickDateRangePicker() throws Exception
//	{
//		Boolean status=false;
//		WebElement daterangefilter = NextstepFaxInbox.getDateRangePicker();
//		try
//		{
//			if(SeleniumHelper.isExist(daterangefilter))
//			{
//				SeleniumHelper.click( daterangefilter);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Date Range picker is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "unable to click Date Range picker");
//		}
//		return status;
//	}
//	
//	public static Boolean selectDateRangeValue(String name) throws Exception
//	{
//		Boolean status=false;
//		WebElement selectdaterange = NextstepFaxInbox.getDateRangeValue(name);
//		try
//		{
//			if(SeleniumHelper.isExist(selectdaterange ))
//			{
//				SeleniumHelper.click(selectdaterange );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "range range value is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "unable to click is clicked successfully ");
//		}
//		return status;
//	}
//	
//	public static Boolean selectGridFilterDropdownValue(String name) throws Exception
//	{
//		Boolean status=false;		
//		WebElement dropdownvalue = NextstepFaxInbox.getGridFilterDropdownValue( name);
//		try
//		{
//			if(SeleniumHelper.isExist(dropdownvalue))
//			{				
//				SeleniumHelper.click( dropdownvalue);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "drop down value filter is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select drop down filter");
//		}
//		return status;
//	}
//	
//	public static Boolean clickCustomFilterDropdown() throws Exception
//	{
//		Boolean status=false;
//		WebElement gridFilter = NextstepFaxInbox.getCustomFilterDropdown();
//		try
//		{
//			if(SeleniumHelper.isExist(gridFilter))
//			{
//				SeleniumHelper.click( gridFilter);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Custom Filter Drop Down is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Custom Filter drop down");
//		}
//		return status;
//	}
//	
//	public static Boolean clickCustomFilterDropdownValue(String name) throws Exception
//	{
//		Boolean status=false;
//		WebElement gridFilter = NextstepFaxInbox.getCustomFilerDropdownvalue( name);
//		try
//		{
//			if(SeleniumHelper.isExist(gridFilter))
//			{
//				SeleniumHelper.click( gridFilter);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Custom Filter Drop Down value is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Custom Filter drop down value");
//		}
//		return status;
//		
//	}
//	public static Boolean validateFilterResult() throws Exception
//	{
//		Boolean status=false;
//		List<WebElement> gridFilterresult = NextstepFaxInbox.getCustomFilterResult();
//		try
//		{						
//			for(int count=0; count<gridFilterresult.size(); count++)
//			{
//				String processstatus=gridFilterresult.get(count).getText();
//				if(!(processstatus.equals("Complete")))
//				{
//					Logger.writeDayLog(Logger.messageType.Exception, "Filter validation failed");
//					return false;
//				}
//			}
//			status=true;		
//			Logger.writeDayLog(Logger.messageType.Pass, "Filter validation is Successfull");
//			System.out.println("validation is succesfull");
//		}					
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Filter validation is failed"+e.getMessage());
//		}
//		return status;
//	}
//	
//	public static Boolean deletePage() throws Exception
//	{
//		Boolean status = false;
//		List<WebElement> pageList = NextstepFaxInbox.getEditPagesList();
//		int count =pageList.size();
//		WebElement firstPage = NextstepFaxInbox.getFirstPage();
//		try
//		{
//			if(pageList.size()<=1)
//			{
//				status=clickFaxViewerExit();
//				waitForFaxLoad();
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax having single page so skipped delete");
//			}
//			else
//			{
//				Actions action = new Actions(GlobalVariable.driver);				 
//		        action.moveToElement(firstPage).perform();		 
//		        WebElement subElement = NextstepFaxInbox.getfirstPageDeleteButton();		 
//		        action.moveToElement(subElement);		 
//		        action.click();		 
//		        action.perform();
//		        clickSaveAndExit();	
//		        waitForPageLoad();
//		        FaxInbox.openLastEditedDocument();
//		        waitForPageLoad();
//		        WebElement pageCount = NextstepFaxInbox.getViewetPagesCount();
//		        String number = pageCount.getText();
//		    	String[] parts = number.split(" ");
//		    	String part1 = parts[0];
//		        int afterpagecount=Integer.parseInt(part1); 
//		        if(afterpagecount== (count-1)) 
//		        {
//		        	Logger.writeDayLog(Logger.messageType.Pass, "First page is deleted");
//		        	status =true;
//		        	System.out.println("delete page validation is sucessfull");
//		        }
//		        else
//		        {
//		        	throw new Exception();
//		        }		       
//			}
//		}
//		catch(Exception e)
//		{
//			status=false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Failed to split document");
//		}		
//		return status;
//	}
//	
//	public static Boolean validateMarkasRead() throws Exception
//	{
//		Boolean status=false;
//		WebElement gridFilter = NextstepFaxInbox.getFirstTimelineEvent();
//		String timelineevent=gridFilter.getText();
//		WebElement event1 = NextstepFaxInbox.getSecondTimelineEvent();
//		 String timelineevent1=event1.getText();
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try
//		{
//			if((timelineevent.contains("marked read this document")) || (timelineevent1.contains("marked read this document")))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Mark as Read validation Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Mark as Read validation is failed");
//		}
//		return status;
//	}
//	
//	public static Boolean validateDocumentStatus() throws Exception
//	{
//		Boolean status=false;
//		WebElement event = NextstepFaxInbox.getFirstTimelineEvent();
//		String timelineevent=event.getText();
//		WebElement event1 = NextstepFaxInbox.getSecondTimelineEvent();
//		String timelineevent1=event1.getText();		 
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try
//		{
//			if((timelineevent.contains("assigned document status")) || (timelineevent1.contains("assigned document status")))
//			{
//				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document status validation Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Document status validation is failed");
//		}
//		return status;
//	}
//		
//	public static Boolean validateViewerDocumentStatus() throws Exception
//	{
//		Boolean status=false;
//		WebElement event = NextstepFaxInbox.getViewerFirstTimelineEvent();
//		String timelineevent=event.getText();
//		WebElement event1 = NextstepFaxInbox.getViewerSecondTimelineEvent();
//		String timelineevent1=event1.getText();		 
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try
//		{		
//			if((timelineevent.contains("assigned document status")) || (timelineevent1.contains("assigned document status")))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document status validation Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Document status validation is failed");
//		}
//		return status;
//	}
//		
//	public static Boolean clickDocumentTypebutton() throws Exception
//	{
//		Boolean status=false;
//		WebElement doctype = NextstepFaxInbox.getViewerDocumentType();
//		try
//		{
//			if(SeleniumHelper.isExist(doctype))
//			{
//				SeleniumHelper.click( doctype);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document type  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Document type ");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickTimelinebutton() throws Exception
//	{
//		Boolean status=false;
//		WebElement timeline = NextstepFaxInbox.getMyPropertiesTimeLineTab();
//		try
//		{
//			if(SeleniumHelper.isExist(timeline))
//			{
//				SeleniumHelper.click( timeline);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Timeline  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Timeline ");
//		}
//		return status;		
//	}
//	
//	public static Boolean enterDescription() throws Exception
//	{
//		Boolean status=false;
//		WebElement description = NextstepFaxInbox.getDescriptionTextbox();
//		try
//		{
//			if(SeleniumHelper.isExist(description))
//			{
//				description.clear();
//				description.sendKeys("Test description");
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Description value entered successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter description value ");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickPropertiesButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement properties = NextstepFaxInbox.getPropertiesButton();
//		try
//		{
//			if(SeleniumHelper.isExist(properties))
//			{
//				SeleniumHelper.click( properties);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Properties  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Properties to click Timeline ");
//		}
//		return status;		
//	}
//	
//	public static Boolean validateDescription() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(2000);
//		WebElement descriptionvalue = NextstepFaxInbox.getDescriptionValue();
//		String description = descriptionvalue.getAttribute("value");
//		try
//		{
//			if(description.equals("Test description"))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Description is verified successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Description is not verified");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickViewerDocumentStatus() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(1000);
//		WebElement properties = NextstepFaxInbox.getDocumentStatusViewer();
//		try
//		{
//			if(SeleniumHelper.isExist(properties))
//			{
//				SeleniumHelper.click( properties);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document Status  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Document Status is not clicked");
//		}
//		return status;
//	}
//	
//	public static Boolean selectDocumentStatusDropDownOptionViewer() throws Exception
//	{
//		Boolean status=false;		
//		Thread.sleep(1000);
//		List<WebElement> firstOption = NextstepFaxInbox.getDocumentStatusDropDownListViewer();
//		try
//		{
//			if(firstOption.size()>0)
//			{
//				if(SeleniumHelper.isExist(firstOption.get(1)))
//				{				
//					SeleniumHelper.click( firstOption.get(1));					
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Selected first Document status");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "No data found in dropdown");
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	
//	public static Boolean clickViewerDocumentDetails() throws Exception
//	{
//		Boolean status=false;
//		WebElement properties = NextstepFaxInbox.getViewerDocumentDetails();
//		try
//		{
//			if(SeleniumHelper.isExist(properties))
//			{
//				SeleniumHelper.click( properties);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document Details  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Document Details is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickViewerTags() throws Exception
//	{
//		Boolean status=false;
//		WebElement properties = NextstepFaxInbox.getTagsViewer();
//		try
//		{
//			if(SeleniumHelper.isExist(properties))
//			{
//				SeleniumHelper.click(properties);				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tags  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Tags is not clicked");
//		}
//		return status;	
//	}
//	
//	public static Boolean clickViewerTimeline() throws Exception
//	{
//		Boolean status=false;
//		WebElement properties = NextstepFaxInbox.getViewerTimeLineTab();
//		try
//		{
//			if(SeleniumHelper.isExist(properties))
//			{
//				SeleniumHelper.click( properties);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Timeline  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Timeline is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickViewerDocumentType() throws Exception
//	{
//		Boolean status=false;
//		WebElement properties = NextstepFaxInbox.getViewerDocumentType();
//		try
//		{
//			if(SeleniumHelper.isExist(properties))
//			{
//				SeleniumHelper.click( properties);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document Type  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Document Type is not clicked");
//		}
//		return status;
//	}
//	
//	public static Boolean selectDocumentTypeDropDownOptionViewer() throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> firstOption = NextstepFaxInbox.getDocumentTypeDropDownListViewer();
//		try
//		{
//			if(firstOption.size()>0)
//			{
//				if(SeleniumHelper.isExist(firstOption.get(0)))
//				{				
//					SeleniumHelper.click( firstOption.get(0));					
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Selected first Document Type");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Document Type value");
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	public static Boolean selectDocumentTypeDropDownOption() throws Exception
//	{
//		Boolean status=false;	
//		List<WebElement> firstOption = NextstepFaxInbox.getDocumentTypeDropDownList();
//		try
//		{
//			if(firstOption.size()>0)
//			{
//				if(SeleniumHelper.isExist(firstOption.get(0)))
//				{	
//					SeleniumHelper.click( firstOption.get(0));						
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Selected first Document Type");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "No data found in dropdown");
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//		
//	public static Boolean validateDocumentType() throws Exception
//	{
//		Boolean status=false;
//		WebElement event = NextstepFaxInbox.getFirstTimelineEvent();
//		String timelineevent=event.getText();
//		WebElement event1 = NextstepFaxInbox.getSecondTimelineEvent();
//		String timelineevent1=event1.getText();
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try
//		{
//			if((timelineevent.contains("modified document type")) || (timelineevent1.contains("modified document type")))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Documet Type Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Documet Type validation is failed");
//		}
//		return status;
//	}
//	
//	public static Boolean clickEditPagesEdit() throws Exception
//	{
//		Boolean status=false;		
//		WebElement editPagesEdit = NextstepFaxInbox.getFaxViewerEditPagesEdit();
//		try
//		{
//			if(SeleniumHelper.isExist(editPagesEdit))
//			{				
//				SeleniumHelper.click( editPagesEdit);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit Pages Edit button is Clicked Sucessfully");
//
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
//
//			Logger.writeDayLog(Logger.messageType.Exception, "confirm is not clicked");
//		}
//		return status;		
//	}
//			
//	public static Boolean clickToolsButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement tools = NextstepFaxInbox.getTools();
//		Thread.sleep(5000);
//		try
//		{
//			if(SeleniumHelper.isExist(tools))
//			{
//				SeleniumHelper.click( tools);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tools is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Tools is not clicked");
//		}
//		return status;	
//	}
//	
//	public static Boolean clickRotateSaveOkButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement ok = NextstepFaxInbox.getRotateSaveOkButton();		
//		try
//		{
//			if(SeleniumHelper.isExist(ok))
//			{
//				SeleniumHelper.click( ok);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "ok is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "ok is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickEnableWarningPopupCheckbox() throws Exception
//	{
//		Boolean status=false;
//		WebElement EnableWarningPopupCheckbox = NextstepFaxInbox.getEnableWarningPopupCheckbox();		
//		try
//		{
//			if(SeleniumHelper.isExist(EnableWarningPopupCheckbox ))
//			{
//				SeleniumHelper.click( EnableWarningPopupCheckbox );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Enable Warning Popup Checkbox is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Enable Warning Popup Checkbox is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickPreferenceSaveButton() throws Exception
//	{
//		Boolean status=false;
//		WebElement PreferenceSave = NextstepFaxInbox.getPreferanceSaveButton();		
//		try
//		{
//			if(SeleniumHelper.isExist(PreferenceSave))
//			{
//				SeleniumHelper.click( PreferenceSave );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "PreferenceSave is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "PreferenceSave is not clicked");
//		}
//		return status;
//	}
//	
//	public static Boolean clickEditPagesMerge() throws Exception
//	{
//		Boolean status=false;		
//		WebElement editPagesEdit = NextstepFaxInbox.getFaxViewerEditPagesMerge();
//		try
//		{
//			if(SeleniumHelper.isExist(editPagesEdit))
//			{				
//				SeleniumHelper.click( editPagesEdit);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit Pages Merge button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Edit Pages Merge button is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickPreferenceAutoRefresh() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(2000);
//		WebElement PreferenceAutoRefresh = NextstepFaxInbox.getAutoRefreshPreference();	
//		try
//		{
//			if(SeleniumHelper.isExist(PreferenceAutoRefresh ))
//			{
//				SeleniumHelper.click( PreferenceAutoRefresh );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Auto refresh is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Auto refresh is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickPreferenceAutoRefreshOneMinute() throws Exception
//	{
//		Boolean status=false;
//		WebElement PreferenceAutoRefreshvalue = NextstepFaxInbox.GetAutoRefreshFirstValue();	
//		try
//		{
//			if(SeleniumHelper.isExist(PreferenceAutoRefreshvalue ))
//			{
//				SeleniumHelper.click( PreferenceAutoRefreshvalue );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Auto refresh value is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Auto refresh value is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickPreferenceAutoRefreshNone() throws Exception
//	{
//		Boolean status=false;
//		WebElement PreferenceAutoRefreshvalue = NextstepFaxInbox.GetAutoRefreshNone();		
//		try
//		{
//			if(SeleniumHelper.isExist(PreferenceAutoRefreshvalue ))
//			{
//				SeleniumHelper.click( PreferenceAutoRefreshvalue );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Auto refresh value is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Auto refresh value is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickAddMoreRecipient() throws Exception
//	{
//		Boolean status=false;
//		WebElement AddMoreRecipient = NextstepFaxInbox.getAddMoreRecipient();	
//		try
//		{
//			if(SeleniumHelper.isExist(AddMoreRecipient ))
//			{
//				SeleniumHelper.click( AddMoreRecipient );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Add More Recipient clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Add More Recipient is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickIncludeCoverpageCheckbox() throws Exception
//	{
//		Boolean status=false;
//		WebElement coverpage = NextstepFaxInbox.getIncludeCoverpageCheckbox();
//		WebElement cancelButton = NextstepFaxInbox.getSendFaxCancelButton();
//		try
//		{
//			if(SeleniumHelper.isExist(cancelButton ))
//			{
//				SeleniumHelper.click(coverpage);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Include Coverpage Checkbox clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Include Coverpage Checkbox is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickSendUsing() throws Exception
//	{
//		Boolean status=false;
//		WebElement sendusing = NextstepFaxInbox.getSendUsing();	
//		try
//		{
//			if(SeleniumHelper.isExist(sendusing ))
//			{
//				SeleniumHelper.click( sendusing );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Send using clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Sendusing is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clicksendUsingValue() throws Exception
//	{
//		Boolean status=false;
//		WebElement value = NextstepFaxInbox.getSendUsingValue();		
//		try
//		{
//			if(SeleniumHelper.isExist(value ))
//			{
//				SeleniumHelper.click( value );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "click send Using Value clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "click send Using Value is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickOkButtonValidation() throws Exception
//	{
//		Boolean status=false;
//		WebElement ok = NextstepFaxInbox.getOkButtonValidation();		
//		try
//		{
//			if(SeleniumHelper.isExist(ok ))
//			{
//				SeleniumHelper.click( ok );
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "ok clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "ok is not clicked");
//		}
//		return status;	
//	}
//	
//	public static Boolean clickFirstDocumentCheckbox() throws Exception
//	{
//		Boolean status=false;
//		WebElement checkbox1 = NextstepFaxInbox.getFirstDocumentCheckbox();
//		WebElement checkbox2 = NextstepFaxInbox.getSecondDocumentCheckbox();		
//		try
//		{
//			if(SeleniumHelper.isExist(checkbox1))
//			{
//				SeleniumHelper.click( checkbox1);
//				status = true;
//				documentID = getDocumentIDWithIndex(0);
//				Logger.writeDayLog(Logger.messageType.Pass, "checkbox1 clicked successfully");
//				Logger.writeDayLog(Logger.messageType.Pass, "checkbox1 clicked successfully"+documentID);
//			}
//		    if(SeleniumHelper.isExist(checkbox2))
//			{
//				SeleniumHelper.click( checkbox2);
//				secondDocumentID = getDocumentIDWithIndex(1);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "checkbox2 clicked successfully");
//				Logger.writeDayLog(Logger.messageType.Pass, "checkbox2 clicked successfully"+secondDocumentID);
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		    
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "checkbox is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean enterCopyDescription(String value) throws Exception
//	{
//		Boolean status = false;
//		WebElement descriptionbox = NextstepFaxInbox.getCopyDescriptionTextbox();
//		try
//		{
//			if(SeleniumHelper.setText(descriptionbox, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as description");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in description");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter description");
//		}			
//		return status;
//	}
//	
//	public static int getPageCountofMergeDocument() throws Exception 
//	{		
//		int finalValue= -1;
//		List<WebElement> faxList = NextstepFaxInbox.getMergeWindowFaxList();						
//		try
//		{
//			if(faxList.size()>0)
//			{
//				WebElement mergeDocPageCount = NextstepFaxInbox.getMergeWindowFirstFaxPageCount();
//				String count = mergeDocPageCount.getText();					
//				double temp = Double.parseDouble(count);
//				System.out.println(temp);
//				finalValue = (int) temp;
//				Logger.writeDayLog(Logger.messageType.Pass, "Merge fax page count is updated successfully");
//			}
//			else
//			{				
//				throw new Exception();
//			}			
//		}
//		catch(Exception e) 
//		{			
//			Logger.writeDayLog(Logger.messageType.Exception, " Merge fax page count is not updated");
//			return finalValue;
//		}	
//		return finalValue;
//	}
//	
//	public static Boolean selectFirstFaxInMergeGrid() throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> firstFax = NextstepFaxInbox.getMergeWindowFaxList();
//		try
//		{
//			if(firstFax.size()>1)
//			{
//				if(SeleniumHelper.isExist(firstFax.get(1)))
//				{				
//					SeleniumHelper.click( firstFax.get(1));
//					GlobalVariable.destinationFaxPageCount = getPageCountofMergeDocument();
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "First fax in merge grid is Clicked Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "No data found in grid");
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	
//	public static int getPageCountInFaxViewer() throws Exception 
//	{		
//		int finalValue= -1;		
//		Thread.sleep(2000);
//		List<WebElement> pageList = NextstepFaxInbox.getViewerThumbnailsList();			
//		try
//		{
//			if(pageList.size()>0)
//			{										
//				finalValue = pageList.size();
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax viewer fax page count is updated successfully");
//			}
//			else
//			{				
//				throw new Exception();
//			}			
//		}
//		catch(Exception e) 
//		{			
//			Logger.writeDayLog(Logger.messageType.Exception, " Fax viewer fax page count is not updated");
//			return finalValue;
//		}
//		return finalValue;
//	}
//	
//	public static Boolean clickMergeDocumentsMerge() throws Exception
//	{
//		Boolean status=false;		
//		WebElement mergeButton = NextstepFaxInbox.getMergeWindowMergeButton();
//		try
//		{
//			if(SeleniumHelper.isExist(mergeButton))
//			{				
//				WebElement austria = new WebDriverWait( GlobalVariable.driver,5).until(ExpectedConditions.elementToBeClickable(mergeButton));
//				Thread.sleep(2000);				
//				SeleniumHelper.click( mergeButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit Pages Merge button is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Edit Pages Merge button");
//		}
//		return status;
//	}	
//		
//	public static Boolean validateMergeCount() throws Exception
//	{
//		Boolean status = false;
//		Thread.sleep(3000);
//		List<WebElement> afterpageList = NextstepFaxInbox.getViewerThumbnailsList();
//		try
//		{
//			int afterpagecount = afterpageList.size();
//			if(afterpagecount == (GlobalVariable.sourceFaxPageCount+GlobalVariable.destinationFaxPageCount))
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Merge page validation successful");
//				status =true;
//				System.out.println("Merge page validation successful");
//			}
//			else
//			{
//				throw new Exception();
//			}
//		}
//		catch(Exception e)
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Merge validation failed");
//		}        
//        return status;
//	}
//	
//	public static Boolean clickMergeSaveAndExit() throws Exception
//	{
//		Boolean status=false;		
//		WebElement sign = NextstepFaxInbox.getMergeSaveAndExit();
//		try
//		{
//			if(SeleniumHelper.isExist(sign))
//			{				
//				SeleniumHelper.click( sign);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Save and exit is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Save and exit");
//		}
//		return status;
//	}
//	
//	public static Boolean clickUploadFile() throws Exception
//	{
//		Boolean status=false;
//		WebElement uploadfile = NextstepFaxInbox.getUploadFile();
//		try
//		{
//			if(SeleniumHelper.isExist(uploadfile))
//			{
//				SeleniumHelper.click( uploadfile);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Upload File is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Upload File is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickUploadFileConfirmButton() throws Exception
//	{
//		Boolean status=false;
////		WebElement confirm = NextstepFaxInbox.getUploadfileConfirmButton();
//		WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 90);
//		try
//		{
//			WebElement clickhere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='confirm']")));
//			if(SeleniumHelper.isExist(clickhere))
//			{
//				SeleniumHelper.click( clickhere);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "confirm is clicked successfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "confirm is not clicked");
//		}
//		return status;		
//	}
//	
//	public static Boolean clickTags() throws Exception
//    {
//		Boolean status=false;
//        WebElement tag = NextstepFaxInbox.getTags();
//        try
//        {
//        	if(SeleniumHelper.isExist(tag))
//            {
//        		SeleniumHelper.click(tag);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Tags  is Clicked Sucessfully");
//            }
//            else
//            {
//                status = false;
//                throw new Exception();
//            }
//         }
//         catch(Exception e) 
//         {
//        	 status = false;
//             Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Tags");
//         }
//        return status;        
//    }
//	
//	public static Boolean addTags() throws Exception 
//	{
//		Boolean status = false;
//		WebElement addTag = NextstepFaxInbox.getTagsOption();
//		try 
//		{
//			if (SeleniumHelper.isExist(addTag)) 
//			{
//				SeleniumHelper.click(addTag);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tag is Sucessfully");
//			} 
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to add Tag");
//		}
//		return status;
//	}
//
//	public static Boolean removeTags() throws Exception 
//	{
//		Boolean status = false;
//		WebElement removeTag = NextstepFaxInbox.getTagsOptionDelete();
//		try 
//		{
//			if (SeleniumHelper.isExist(removeTag)) 
//			{
//				SeleniumHelper.click(removeTag);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tag is remove Sucessfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to remove Tag");
//		}
//		return status;
//	}
//
//	public static Boolean validateTags() throws Exception 
//	{
//		Boolean status = false;
//		WebElement gridFilter = NextstepFaxInbox.getFirstTimelineEvent();
//		String timelineevent = gridFilter.getText();
//		System.out.println(timelineevent);
//		WebElement event1 = NextstepFaxInbox.getSecondTimelineEvent();
//		String timelineevent1 = event1.getText();
//		System.out.println(timelineevent1);
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try 
//		{
//			if ((timelineevent.contains("removed tag")) || (timelineevent1.contains("removed tag"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tags Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Tag validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean enterCustomFields(String value) throws Exception 
//	{
//		Boolean status = false;
//		WebElement customfield = NextstepFaxInbox.getCustomField();
//		try 
//		{
//			if (SeleniumHelper.setText(customfield, value)) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered custom fields");
//				customfield.clear();
//			}
//			else 
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered custom fields");
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter custom field");
//		}
//		return status;
//	}
//
//	public static Boolean clickWatermarkButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement watermark = NextstepFaxInbox.getWatermark();
//		try
//		{
//			if (SeleniumHelper.isExist(watermark)) 
//			{
//				SeleniumHelper.click( watermark);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Watermark is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Watermark is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickWatermarkApply() throws Exception 
//	{
//		Boolean status = false;
//		WebElement apply = NextstepFaxInbox.getWatermarkApply();
//		try
//		{
//			if (SeleniumHelper.isExist(apply)) 
//			{
//				SeleniumHelper.click( apply);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Watermark apply is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Watermark apply is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickSaveButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement save = NextstepFaxInbox.getSaveButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(save)) 
//			{
//				SeleniumHelper.click(save);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "save is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "save is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickRotateRightButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement rotateright = NextstepFaxInbox.getRotateRightButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(rotateright)) 
//			{
//				SeleniumHelper.click( rotateright);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Rotate right is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Rotate right is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean validateWatermark() throws Exception 
//	{
//		Boolean status = false;
//		WebElement event = NextstepFaxInbox.getViewerSecondTimelineEvent();
//		WebElement event1 = NextstepFaxInbox.getViewerFirstTimelineEvent();
//		String timelineevent = event.getText();
//		String timelineevent1 = event1.getText();
//		try 
//		{
//			if ((timelineevent.contains("watermarked this document")) || (timelineevent1.contains("watermarked this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Watermark validation Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Watermark validation is failed");
//		}
//		return true;
//	}
//
//	public static Boolean validateRotation() throws Exception 
//	{
//		Boolean status = false;
//		WebElement event = NextstepFaxInbox.getViewerSecondTimelineEvent();
//		String timelineevent = event.getText();
//		WebElement event1 = NextstepFaxInbox.getViewerFirstTimelineEvent();
//		String timelineevent1 = event1.getText();
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try 
//		{
//			if ((timelineevent.contains("rotated 1 page(s) in this document")) || (timelineevent1.contains("rotated 1 page(s) in this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Rotate single page validation Sucess");
//			}
//			else if((timelineevent.contains("rotated 2 page(s) in this document")) || (timelineevent1.contains("rotated 2 page(s) in this document")))
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Rotate multiple pages validation is Sucess");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Rotation validation is failed");
//		}
//		return true;
//	}
//
//	public static Boolean clickFaxViewerTool() throws Exception 
//	{
//		Boolean status = false;
//		WebElement tools = NextstepFaxInbox.getFaxViewerTools();
//		try 
//		{
//			if (SeleniumHelper.isExist(tools)) 
//			{
//				SeleniumHelper.click( tools);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tools is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Tools is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickEMailCancel() throws Exception 
//	{
//		Boolean status = false;
//		WebElement eMailCancel = NextstepFaxInbox.getSendEMailCancelButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(eMailCancel)) 
//			{
//				SeleniumHelper.click( eMailCancel);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "EMail Cancel is Clicked Sucessfully");
//			} 
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click EMail Cancel");
//		}
//		return status;
//	}
//
//	public static Boolean validateFaxQueuedSuccessfully() throws Exception 
//	{
//		Boolean status = false;
//		WebElement popupText = NextstepFaxInbox.getFaxQueuedPopUp();
//		try 
//		{
//			if (popupText.getText().contains("successful")) 
//			{
//				String t = popupText.getText();
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax is queued Sucessfully");
//				status = true;
//			}
//			else 
//			{
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Fax not queued " + popupText.getText());
//			status = false;
//		}
//		return status;
//	}
//
//	public static Boolean validateEmailQueuedSuccessfully() throws Exception 
//	{
//		Boolean status = false;
//		WebElement popupText = NextstepFaxInbox.getEmailQueuedPopUp();
//		try 
//		{
//			if (popupText.getText().contains("successful")) 
//			{
//				String t = popupText.getText();
//				Logger.writeDayLog(Logger.messageType.Pass, "EMail is queued Sucessfully");
//				status = true;
//			}
//			else 
//			{
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "EMail not queued " + popupText.getText());
//			status = false;
//		}
//		return status;
//	}
//
//	public static Boolean clickEmailSendSuccessOk() throws Exception 
//	{
//		Boolean status = false;
//		WebElement faxSendOk = NextstepFaxInbox.getSendFaxSuccessOkie();
//		try 
//		{
//			if (validateEmailQueuedSuccessfully()) 
//			{
//				if (SeleniumHelper.isExist(faxSendOk)) 
//				{
//					SeleniumHelper.click( faxSendOk);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Email queued success ok is Clicked Sucessfully");
//				}
//				else 
//				{
//					status = false;
//					throw new Exception();
//				}
//			} 
//			else 
//			{
//				if (SeleniumHelper.isExist(faxSendOk)) 
//				{
//					SeleniumHelper.click( faxSendOk);
//					SeleniumHelper.click( NextstepFaxInbox.getSendEMailCancelButton());
//					status = false;
//					Logger.writeDayLog(Logger.messageType.Pass, "Failed to queue fax");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Fax queued success ok");
//		}
//		return status;
//	}
//
//	public static Boolean validateFolderAndGridCount() throws Exception 
//	{
//		Boolean status = false;
//		WebElement currentFolder = NextstepFaxInbox.getCurrentFolderName();
//		WebElement gridCount = NextstepFaxInbox.getFaxGridDisplayCount();
//		try 
//		{
//			int folderValue = getFolderCount(currentFolder.getText());
//			String input = gridCount.getText();
//			String split[] = new String[input.split(" ").length];
//			split = input.split(" ");
//			String gridCountValue = split[input.split(" ").length - 1];
//			double temp = Double.parseDouble(gridCountValue);
//			int gridValue = (int) temp;
//			Logger.writeDayLog(Logger.messageType.Pass, "Count in Grid is " + gridValue);
//			Logger.writeDayLog(Logger.messageType.Pass, "Count in folder is " + folderValue);
//
//			if (gridValue == folderValue)
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Folder count is correct while loading");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Folder count mismatch");
//		}
//		return status;
//	}
//
//	public static Boolean clickRedactButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement redact = NextstepFaxInbox.getFaxViewerToolsRedact();
//		try 
//		{
//			if (SeleniumHelper.isExist(redact)) 
//			{
//				SeleniumHelper.click( redact);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Redact is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Redact is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean hoverOverview() throws Exception 
//	{
//		Boolean status = false;
//		WebElement QuickPreview = NextstepFaxInbox.getFaxGridOverviewIcon();
//		try
//		{
//			Actions builder = new Actions(GlobalVariable.driver);
//			Action hover = builder.moveToElement(QuickPreview).build();
//			hover.perform();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Mouse hover preview icon");
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Mouse hover preview icon failed");
//		}
//		return status;
//	}
//
//	public static Boolean clickOverviewIcon() throws Exception 
//	{
//		Boolean status = false;
//		WebElement QuickPreview = NextstepFaxInbox.getFaxGridOverviewIcon();
//		try
//		{
//			Actions builder = new Actions(GlobalVariable.driver);
//			Action hover = builder.moveToElement(QuickPreview).click().build();
//			hover.perform();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "QuickPreview is clicked successfully");
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "QuickPreview is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean validateOverviewPan() throws Exception 
//	{
//		Boolean status = false;
//		WebElement overviewPan = NextstepFaxInbox.getFaxGridPreviewPan();
//		try 
//		{
//			if ((SeleniumHelper.isExist(overviewPan)) && (SeleniumHelper.isDisplayed( overviewPan))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Quick preview pan exist");
//			} 
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Quick preview pan doesn't exist");
//		}
//		return status;
//	}
//
//	public static Boolean OpenDocumentFromQuickPreviewPanel() throws Exception 
//	{
//		Boolean status = false;
//		WebElement edit = NextstepFaxInbox.editDocumentinQuickPreviewPanel();
//		try 
//		{
//			if (SeleniumHelper.isExist(edit)) 
//			{
//				SeleniumHelper.doubleClick(edit);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document is opened");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Document is not opened");
//		}
//		return status;
//	}
//
//	public static Boolean validateViewedEvent() throws Exception 
//	{
//		Boolean status = false;
//		WebElement viewed = NextstepFaxInbox.getViewerFirstTimelineEvent();
//		String timelineevent = viewed.getText();
//		WebElement event1 = NextstepFaxInbox.getViewerSecondTimelineEvent();
//		String timelineevent1 = event1.getText();
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try
//		{
//			if ((timelineevent.contains("viewed this document")) || (timelineevent1.contains("viewed this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "viewed event validation Sucessfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "viewed event validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean clickShapesOption() throws Exception 
//	{
//		Boolean status = false;
//		WebElement shapes = NextstepFaxInbox.getFaxViewerToolsShapes();
//		try 
//		{
//			Thread.sleep(2000);
//			if (SeleniumHelper.isExist(shapes)) 
//			{
//				SeleniumHelper.click( shapes);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tools is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Tools is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickShapesRectangle() throws Exception 
//	{
//		Boolean status = false;
//		WebElement shapes = NextstepFaxInbox.getShapesRectangle();
//		try 
//		{
//			if (SeleniumHelper.isExist(shapes)) 
//			{
//				SeleniumHelper.click( shapes);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Rectangle is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Rectangle is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickShapesOval() throws Exception 
//	{
//		Boolean status = false;
//		WebElement Oval = NextstepFaxInbox.getShapesOval();
//		try 
//		{
//			if (SeleniumHelper.isExist(Oval)) 
//			{
//				SeleniumHelper.click( Oval);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Oval is clicked successfully");
//			} 
//			else
//			{
//				status = false;
//				throw new Exception();
//			}			
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Oval is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickShapesLine() throws Exception 
//	{
//		Boolean status = false;
//		WebElement line = NextstepFaxInbox.getShapesLine();
//		try 
//		{
//			if (SeleniumHelper.isExist(line)) 
//			{
//				SeleniumHelper.click( line);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "lines is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "lines is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickToolsRedact() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(1000);
//		WebElement redact = NextstepFaxInbox.getFaxViewerToolsRedact();
//		try 
//		{
//			if (SeleniumHelper.isExist(redact)) 
//			{
//				SeleniumHelper.click( redact);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Redact is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Redact is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickToolsErase() throws Exception 
//	{
//		Boolean status = false;
//		WebElement erase = NextstepFaxInbox.getFaxViewerToolsErase();
//		try 
//		{
//			if (SeleniumHelper.isExist(erase)) 
//			{
//				SeleniumHelper.click( erase);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Erase is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Erase is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickToolsAnnotate() throws Exception 
//	{
//		Boolean status = false;
//		WebElement erase = NextstepFaxInbox.getFaxViewerToolsAnnotate();
//		try 
//		{
//			if (SeleniumHelper.isExist(erase)) 
//			{
//				SeleniumHelper.click( erase);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Annotate is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Annotate is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean drawShapes() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(1000);
//		WebElement page = NextstepFaxInbox.getFaxViewerDocumentArea();
//		try 
//		{
//			if (SeleniumHelper.isExist(page)) 
//			{
//				Actions a = new Actions(GlobalVariable.driver);
//				Point point = page.getLocation();
//				System.out.println(point);
//				int x = point.getX() / 2;
//				int y = point.getY() / 2;
//				System.out.println(x);
//				System.out.println(y);
//				a.moveToElement(page, x, y).clickAndHold().build().perform();
//				a.moveToElement(page, 300, 150).release().build().perform();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Rectangle is applied successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) {
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to apply rectangle");
//		}
//		return status;
//	}
//
//	public static Boolean validateShapes() throws Exception 
//	{
//		Boolean status = false;
//		WebElement gridFilter = NextstepFaxInbox.getViewerSecondTimelineEvent();
//		String timelineevent = gridFilter.getText();
//		WebElement event1 = NextstepFaxInbox.getViewerFirstTimelineEvent();
//		String timelineevent1 = event1.getText();
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try 
//		{
//			if ((timelineevent.contains("added shapes to 1 page(s) on this document")) || (timelineevent1.contains("added shapes to 1 page(s) on this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Shapes validation is successfull");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch (Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Shapes validation is failed");
//		}
//		Thread.sleep(2000);
//		return status;
//	}
//
//	public static Boolean validateTools() throws Exception 
//	{
//		Boolean status = false;
//		WebElement gridFilter = NextstepFaxInbox.getViewerFirstTimelineEvent();
//		String timelineevent = gridFilter.getText();
//		WebElement event1 = NextstepFaxInbox.getViewerSecondTimelineEvent();
//		String timelineevent1 = event1.getText();
//		//String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try 
//		{
//			if ((timelineevent.contains("redacted 1 page(s) on this document"))	|| (timelineevent1.contains("redacted 1 page(s) on this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Redact validation is successfull");				
//			}
//			else if ((timelineevent.contains("erased 1 page(s) on this document")) || (timelineevent1.contains("erased 1 page(s) on this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Erase validation is successfull");
//			} 
//			else if ((timelineevent.contains("annotated 1 page(s) on this document")) || (timelineevent1.contains("annotated 1 page(s) on this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Annotate validation is successfull");
//			}
//			else if ((timelineevent.contains("annotated 2 page(s) on this document")) || (timelineevent1.contains("annotated 2 page(s) on this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Annotate validation is successfull");
//			}
//			
//			else if ((timelineevent.contains("signed 1 page(s) on this document")) || (timelineevent1.contains("signed 1 page(s) on this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Annotate validation is successfull");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Tools validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean addTagsViewer() throws Exception 
//	{
//		Boolean status = false;
//		WebElement addTag = NextstepFaxInbox.getTagsOptionViewer();
//		try 
//		{
//			if (SeleniumHelper.isExist(addTag)) 
//			{
//				SeleniumHelper.click( addTag);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tag is added Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to add Tag");
//		}
//		return status;
//	}
//
//	public static Boolean removeTagsViewer() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(3000);
//		WebElement removeTag = NextstepFaxInbox.getTagsOptionDeleteViewer();
//		try 
//		{
//			if (SeleniumHelper.isExist(removeTag)) 
//			{
//				SeleniumHelper.click(removeTag);
//				status = true;
//				Thread.sleep(5000);
//				Logger.writeDayLog(Logger.messageType.Pass, "Tag is remove Sucessfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to remove Tag");
//		}
//		return status;
//	}
//
//	public static Boolean validateTagsViewer() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(3000);
//		WebElement event = NextstepFaxInbox.getViewerFirstTimelineEvent();
//		String timelineevent = event.getText();
//		WebElement event1 = NextstepFaxInbox.getViewerSecondTimelineEvent();
//		String timelineevent1 = event1.getText();
//		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try 
//		{
//			if ((timelineevent.contains("removed tag")) || (timelineevent1.contains("removed tag"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tags valiation Sucessfully");
//			} 
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Tag validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean clickRestoreDefaultCheckbox() throws Exception 
//	{
//		Boolean status = false;
//		WebElement RestoreDefaultCheckbox = NextstepFaxInbox.getRestoreDefaultChechbox();
//		try 
//		{
//			if (SeleniumHelper.isExist(RestoreDefaultCheckbox)) 
//			{
//				SeleniumHelper.click( RestoreDefaultCheckbox);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Tag is remove Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to remove Tag");
//		}
//		return status;
//	}
//
//	public static Boolean validateSharedQueueEditView() throws Exception 
//	{
//		Boolean status = false;
//		int finalcount = 0;
//		List<String> list = new ArrayList<String>();		
//		list.add("Date & Time");
//		list.add("From");
//		list.add("To");
//		list.add("Pages");
//		list.add("Document Status");
//		list.add("Process Status");
//		list.add("Tags");
//		try 
//		{
//			List<WebElement> selectedColumn = NextstepFaxInbox.getEditViewSelectedColumn();
//			for (int i = 0; i < list.size(); i++) 
//			{
//				for (int j = 0; j < selectedColumn.size(); j++) 
//				{
//					if (selectedColumn.get(j).getText().equals(list.get(i)))						
//					{
//						finalcount++;
//						break;
//					}
//				}
//			}
//			if (finalcount == list.size())
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, " Shared queue column validation is successfull");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Shared queue Column vaidation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean validatePersonalQueueEditView() throws Exception 
//	{
//		Boolean status = false;
//		int finalcount = 0;
//		List<String> list = new ArrayList<String>();		
//		list.add("Date & Time");
//		list.add("From");
//		list.add("To");
//		list.add("Pages");
//		list.add("Process Status");
//		try 
//		{
//			List<WebElement> selectedColumn = NextstepFaxInbox.getEditViewSelectedColumn();
//			for (int i = 0; i < list.size(); i++) 
//			{
//				for (int j = 0; j < selectedColumn.size(); j++) 
//				{
//					if (selectedColumn.get(j).getText().equals(list.get(i)))						
//					{
//						finalcount++;
//						break;
//					}
//				}
//			}
//			if (finalcount == list.size())
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Personal queue column validation is successfull");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Personal queue Column vaidation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean clickePropertiesCloseButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement close = NextstepFaxInbox.getPropertiesCloseButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(close)) 
//			{
//				SeleniumHelper.click( close);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "close button is clicked");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click close button");
//		}
//		return status;
//	}
//
//	public static Boolean clickeditViewCancelButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement cancelbutton = NextstepFaxInbox.getEditViewCancelButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(cancelbutton)) 
//			{
//				SeleniumHelper.click( cancelbutton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "cancel button is clicked");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click cancel button");
//		}
//		return status;
//	}
//
//	public static Boolean clickPage2Pagination() throws Exception 
//	{
//		Boolean status = false;
//		WebElement gridCount = NextstepFaxInbox.getFaxGridDisplayCount();
//		WebElement page2 = NextstepFaxInbox.getPage2Pagination();
//		try 
//		{
//			String input = gridCount.getText();
//			String split[] = new String[input.split(" ").length];
//			split = input.split(" ");
//			String gridCountValue = split[input.split(" ").length - 1];
//			double temp = Double.parseDouble(gridCountValue);
//			int gridValue = (int) temp;
//			Logger.writeDayLog(Logger.messageType.Pass, "Count in Grid is " + gridValue);
//			if (gridValue > 50) 
//			{
//				SeleniumHelper.click( page2);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Page 2 is clicked successfully");
//			}
//			else
//			{
//				status = true;
//				clickGridRefresh();
//				waitForPageLoad();
//				Logger.writeDayLog(Logger.messageType.Pass, "Document count is not more than 50 so skipping");
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Folder count mismatch");
//		}
//		return status;
//	}
//
//	public static Boolean ValidatePagination() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> getFaxCountGrid = NextstepFaxInbox.getFaxCountGrid();
//		int gridfaxcount = getFaxCountGrid.size();
//		try 
//		{
//			if (gridfaxcount > 0) 
//			{
//				Logger.writeDayLog(Logger.messageType.Exception, "Pagination validation is sucessfull");
//				status = true;
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Pass, "Pagination validation is failed");
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Pagination validation is failed" + e.getMessage());
//		}
//		return status;
//	}
//
//	public static Boolean faxFocusAndPaginationValidation() throws Exception 
//	{
//		Boolean status = false;
//		WebElement page2 = NextstepFaxInbox.getPage2Pagination();
//		try
//		{
//			String page = page2.getText();
//			double temp = Double.parseDouble(page);
//			int pageValue = (int) temp;
//			if (pageValue == 2) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass,"faxFocus and Pagination Validation is successfull" + pageValue);
//			} 
//			else 
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Pass, "faxFocus and Pagination Validation is failed");
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "faxFocus and Pagination Validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean validatePageFilterResult() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> gridFilterresult = NextstepFaxInbox.getPageFilterResult();
//		try 
//		{
//			for (int count = 0; count < gridFilterresult.size(); count++) 
//			{
//				String processstatus = gridFilterresult.get(count).getText();
//				if (!(processstatus.equals("2"))) 
//				{
//					Logger.writeDayLog(Logger.messageType.Exception, "Filter validation failed");
//					return false;
//				}
//			}
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Filter validation is Successfull");
//			System.out.println("validation is succesfull");
//		}
//		catch (Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Filter validation is failed" + e.getMessage());
//		}
//		return status;
//	}
//
//	public static Boolean clickGoToPageTextbox(String pageno) throws Exception 
//	{
//		Boolean status = false;
//		WebElement gotoPage = NextstepFaxInbox.GotoPageTextbox();
//		try 
//		{
//			if (SeleniumHelper.isExist(gotoPage)) 
//			{
//				SeleniumHelper.setText(gotoPage, pageno);
//				gotoPage.sendKeys(Keys.ENTER);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Number 2 is entered successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Number 2 is not entered");
//		}
//		return status;
//	}
//
//	public static Boolean goToPageTextboxValidation() throws Exception 
//	{
//		Boolean status = false;
//		WebElement page2 = NextstepFaxInbox.getPage2Pagination();
//		try 
//		{
//			String page = page2.getText();
//			double temp = Double.parseDouble(page);
//			int pageValue = (int) temp;
//			if (pageValue == 2) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass,"Go to Page Pagination Validation is successfull" + pageValue);
//			} 
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Pass, "Go to Page Pagination Validation is failed");
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Go to Page Pagination Validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean clickGridRefresh() throws Exception 
//	{
//		Boolean status = false;
//		WebElement refresh = NextstepFaxInbox.gridRefresh();
//		try 
//		{
//			if (SeleniumHelper.isExist(refresh)) 
//			{
//				SeleniumHelper.click( refresh);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Refresh is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Refresh is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickAnnotateEdit() throws Exception 
//	{
//		Boolean status = false;
//		WebElement edit = NextstepFaxInbox.getToolsAnnotateEditIcon();
//		try
//		{
//			if (SeleniumHelper.isExist(edit)) 
//			{
//				Actions action = new Actions(GlobalVariable.driver);
//				action.moveToElement(edit).build().perform();
//				SeleniumHelper.click( edit);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Annotate edit is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Annotate text is not entered");
//		}
//		return status;
//	}
//
//	public static Boolean enterAnnotateTextbox(String text) throws Exception 
//	{
//		Boolean status = false;
//		WebElement gotoPage = NextstepFaxInbox.getToolsAnnotateTextbox();
//		try
//		{
//			if (SeleniumHelper.isExist(gotoPage)) 
//			{
//				SeleniumHelper.setText(gotoPage, text);
//				gotoPage.sendKeys(Keys.ENTER);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Annotate text is entered successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Annotate text is not entered");
//		}
//		return status;
//	}
//
//	public static Boolean clickMoveFolderDropDown() throws Exception 
//	{
//		Boolean status = false;
//		WebElement moveFolder = NextstepFaxInbox.getMoveFolderDropDown();
//		try 
//		{
//			if (SeleniumHelper.isExist(moveFolder)) 
//			{
//				SeleniumHelper.click( moveFolder);
//				status = true;
//				WebElement austria = new WebDriverWait(GlobalVariable.driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='treeList']")));
//				Logger.writeDayLog(Logger.messageType.Pass, "Move Folder drop down is Clicked Sucessfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Move Folder drop down");
//		}
//		return status;
//	}
//
//	public static Boolean selectParentFolderToMove() throws Exception 
//	{
//		Boolean status = false;
//		WebElement parentFolder = NextstepFaxInbox.getTargetFolder();
//		try 
//		{
//			if (SeleniumHelper.isExist(parentFolder)) 
//			{
//				SeleniumHelper.click(parentFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Parent folder is Clicked Sucessfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Parent folder");
//		}
//		return status;
//	}
//
//	public static Boolean confirmMoveFolder() throws Exception 
//	{
//		Boolean status = false;
//		WebElement moveFolderConfirm = NextstepFaxInbox.getMoveFolderConfirmButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(moveFolderConfirm)) 
//			{
//				SeleniumHelper.click( moveFolderConfirm);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Move Folder confirm is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Move Folder confirm");
//		}
//		return status;
//	}
//
//	public static Boolean clickParent() throws Exception 
//	{
//		Boolean status = false;
//		WebElement parentFolder = NextstepFaxInbox.getSubFolder("Parent");
//		try 
//		{
//			if (SeleniumHelper.isExist(parentFolder)) 
//			{
//				SeleniumHelper.click( parentFolder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Parent Folder is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Parent Folder");
//		}
//		return status;
//	}
//
//	public static Boolean selectFolderToMove(String foldername) throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(1000);
//		WebElement folder = NextstepFaxInbox.getFolderinDropDown(foldername);
//		try 
//		{
//			if (SeleniumHelper.isExist(folder)) 
//			{
//				SeleniumHelper.click( folder);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Folder is Clicked Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select the folder");
//		}
//		return status;
//	}
//
//	public static Boolean validateCopyMoveFolderName() throws Exception 
//	{
//		Boolean status = false;
//		WebElement gridFolder = NextstepFaxInbox.getCurrentFolderName();
//		WebElement copyMoveFolder = NextstepFaxInbox.getMoveCopyPopUpDropDown();
//		try 
//		{
//			String grid = gridFolder.getText();
//			String copyMove = copyMoveFolder.getText();
//			if (copyMove.contains(grid)) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Folder for copy / move loaded properly");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to load Folder for copy / move");
//		}
//		return status;
//	}
//
//	public static Boolean clickMoveCopyCancel() throws Exception 
//	{
//		Boolean status = false;
//		WebElement moveCopyCancel = NextstepFaxInbox.getCopyMovePopUpClose();
//		try 
//		{
//			if (SeleniumHelper.isExist(moveCopyCancel)) 
//			{
//				SeleniumHelper.click(moveCopyCancel);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Move Copy Cancel is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Move Copy Cancel is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickDocumentDetailsMessageID() throws Exception 
//	{
//		Boolean status = false;
//		WebElement documentDetailMessageID = NextstepFaxInbox.getDocumentDetailsMessageID();
//		try 
//		{
//			if (SeleniumHelper.isExist(documentDetailMessageID)) 
//			{
//				SeleniumHelper.click( documentDetailMessageID);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document Details MessageID is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Document Details MessageID is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean validateFaxDuration() throws Exception 
//	{
//		Boolean status = false;
//		WebElement faxDuration = NextstepFaxInbox.getDocumentDetailsFaxDuration();
//		try 
//		{
//			String input = faxDuration.getText();
//			String split[] = new String[input.split(" ").length];
//			split = input.split(" ");
//			String FaxDuration = split[0];
//			double temp = Double.parseDouble(FaxDuration);
//			int faxDurationValue = (int) temp;
//			Logger.writeDayLog(Logger.messageType.Pass, "Fax duration taken " + faxDurationValue);
//			if (faxDurationValue >= 0) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax duration is calculated");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Fax duration is undefined");
//		}
//		return status;
//	}
//
//	public static Boolean validateDocumentDownloadType() throws Exception 
//	{
//		Boolean status = false;
//		WebElement documentType = NextstepFaxInbox.getDownloadDocumentAsDropDown();
//		try 
//		{
//			if (SeleniumHelper.isExist(documentType)) 
//			{
//				if (documentType.getText().equals("PDF")) 
//				{
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Deafault download type is " + documentType.getText());
//				} 
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Deafault document download is not PDF");
//		}
//		return status;
//	}
//
//	public static Boolean clickFaxGridSelectAll() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(1000);
//		WebElement selectAll = NextstepFaxInbox.getFaxGridSelectAll();
//		try 
//		{
//			if (SeleniumHelper.isExist(selectAll)) 
//			{
//				SeleniumHelper.click( selectAll);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax grid select all is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Fax grid select all is not clicked");
//		}
//		return status;
//	}
//
//	public static int getSelectedFaxCount() throws Exception 
//	{
//		WebElement selectAllCount = NextstepFaxInbox.getFaxGridSelectAllPageCount();
//		int count = 0;
//		String selectValue = selectAllCount.getText();
//		String split[] = new String[selectValue.split(" ").length];
//		split = selectValue.split(" ");
//		String val = split[0];
//		double temp = Double.parseDouble(val);
//		count = (int) temp;
//		return count;
//	}
//
//	public static Boolean isSelectedCountDisplayed() throws Exception 
//	{
//		Boolean status = false;
//		try 
//		{
//			if (getSelectedFaxCount() > 0)
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax grid select all count is " + getSelectedFaxCount());
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax grid select all count displayed");
//			} 
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Fax grid select all count not diplayed");
//		}
//		return status;
//	}
//
//	public static Boolean validateGridToolsExistance() throws Exception 
//	{
//		Boolean status = false;
//		WebElement copy = NextstepFaxInbox.getCopyFax();
//		WebElement move = NextstepFaxInbox.getMoveFax();
//		WebElement archive = NextstepFaxInbox.getArchiveFax();
//		WebElement delete = NextstepFaxInbox.getDeleteFax();
//		try 
//		{
//			if ((copy.isEnabled()) && (move.isEnabled()) && (archive.isEnabled()) && (delete.isEnabled())) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "All the tools are enabled");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "unable to find the tools");
//		}
//		return status;
//	}
//
//	public static Boolean enterViewerCustomFields(String value) throws Exception 
//	{
//		Boolean status = false;
//		WebElement customfield = NextstepFaxInbox.getViewerCustomField();
//		try
//		{
//			if (SeleniumHelper.setText(customfield, value)) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered custom fields");
////				customfield.clear();
//				}
//			else 
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered custom fields");
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter custom field");
//		}
//		return status;
//	}
//
//	public static Boolean MouseHoverVersionButtonandClickOriginalVerion() throws Exception 
//	{
//		Boolean status = false;
//		WebElement VersionButton = NextstepFaxInbox.geVersionButton();		
//		try 
//		{
//			if (SeleniumHelper.isExist(VersionButton)) 
//			{
//				Actions builder = new Actions(GlobalVariable.driver);
//   				Action hover = builder.moveToElement(VersionButton).build();
//   				hover.perform();
//				WebElement originalVersion = NextstepFaxInbox.getOriginalVersion();
//				SeleniumHelper.click( originalVersion);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "version is hovered and clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to hovered version and click button");
//		}
//		return status;
//	}
//	public static Boolean MouseHoverVersionButtonandClickCurrentVersion() throws Exception 
//	{
//		Boolean status = false;
//		WebElement VersionButton = NextstepFaxInbox.geVersionButton();
//		WebElement currentVersion = NextstepFaxInbox.getCurrentVersion();
//		try 
//		{
//			if (SeleniumHelper.isExist(VersionButton)) 
//			{
//				Actions action = new Actions(GlobalVariable.driver);
//				action.moveToElement(VersionButton).build().perform();
//				SeleniumHelper.click( currentVersion);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "version is hovered and clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to hovered version and click button");
//		}
//		return status;
//	}
//	
//	public static Boolean clickOriginalVersion() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(2000);
//		WebElement originalVersion = NextstepFaxInbox.getOriginalVersion();
//		try 
//		{
//			if (SeleniumHelper.isExist(originalVersion)) 
//			{
//				SeleniumHelper.click( originalVersion);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Original version is clicked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Original version edit is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickCurrentVersion() throws Exception 
//	{
//		Boolean status = false;
//		WebElement CurrentVersion = NextstepFaxInbox.getCurrentVersion();
//		try 
//		{
//			if (SeleniumHelper.isExist(CurrentVersion)) 
//			{
//				SeleniumHelper.click( CurrentVersion);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "CurrentVersion is clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "CurrentVersions edit is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean ValidateOriginalVersion() throws Exception 
//	{
//		Boolean status = false;
//		WebElement OriginalVersion = NextstepFaxInbox.getOriginalVersionLabel();
//		String version = OriginalVersion.getText();
//		try 
//		{
//			if (version.equals("Original Document")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Version is validated successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Version validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean clickVersionValidationOkButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement OkButton = NextstepFaxInbox.getVersionValidationOkButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(OkButton)) 
//			{
//				SeleniumHelper.click( OkButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Validate Tools in original version is successfull");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Validate Tools in original version is failed");
//		}
//		return status;
//	}
//
//	public static Boolean clearWatermarkTextbox(String text) throws Exception 
//	{
//		Boolean status = false;
//		WebElement watermarktextbox = NextstepFaxInbox.getWatermarkTextbox();
//		try 
//		{
//			if (SeleniumHelper.isExist(watermarktextbox)) 
//			{
//				SeleniumHelper.setText(watermarktextbox, text);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Watermark text is cleared successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "watermark text is not cleared");
//		}
//		return status;
//	}
//
//	public static Boolean ClickPopupOkButton() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(1000);
//		WebElement okButton = NextstepFaxInbox.getWatermarkPopupOkButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(okButton)) 
//			{
//				SeleniumHelper.click(okButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Watermark pop/Delete fax ok clicked successfull");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Watermark/delete fax ok button");
//		}
//		return status;
//	}
//
//	public static Boolean clickLogoutPopupYesButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement yesbutton = NextstepFaxInbox.getLogoutPopupYesButton();
//		try
//		{
//			if (SeleniumHelper.isExist(yesbutton)) 
//			{
//				SeleniumHelper.click(yesbutton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Log out popup yes button is clicked sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Log out popup yes button is clicked sucessfully");
//		}
//		return status;
//	}
//
//	public static Boolean ValidateLogout() throws Exception 
//	{
//		Boolean status = false;
//		WebElement name = NextstepFaxInbox.getSSOUserNameInputBox();
//		try
//		{
//			if (SeleniumHelper.isExist(name)) 
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
//
//	public static Boolean enterNewFaxSubject(String value) throws Exception 
//	{
//		Boolean status = false;
//		WebElement eMailSubject = NextstepFaxInbox.getNewFaxSubject();
//		try
//		{
//			if (SeleniumHelper.setText(eMailSubject, value)) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as fax subject");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in fax subject");
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter fax subject");
//		}
//		return status;
//	}
//
//	public static Boolean validateIncludeCoverpageCheckbox() throws Exception 
//	{
//		Boolean status = false;
//		WebElement coverpage = NextstepFaxInbox.getIncludeCoverpageCheckbox();
//		try 
//		{
//			if (SeleniumHelper.isExist(coverpage)) 
//			{
//				coverpage.isSelected();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Include Coverpage Checkbox is checked successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Include Coverpage Checkbox is not checked");
//		}
//		return status;
//	}
//
//	public static Boolean enterToCCEmailAddress(String value) throws Exception 
//	{
//		Boolean status = false;
//		WebElement cc = NextstepFaxInbox.getEmailCC();
//		try 
//		{
//			if (SeleniumHelper.setText(cc, value)) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as eMail to");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in eMail to");
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter eMail to");
//		}
//		return status;
//	}
//
//	public static Boolean clickEmailCCPopupOkButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement okButton = NextstepFaxInbox.getEmailCCPopupOkButton();
//		try
//		{
//			if (SeleniumHelper.isExist(okButton)) 
//			{
//				SeleniumHelper.click( okButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Ok is clicked sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Ok button is clicked sucessfully");
//		}
//		return status;
//	}
//
//	public static Boolean clickNewFaxCancelButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement cancelButton = NextstepFaxInbox.getSendFaxCancelButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(cancelButton)) 
//			{
//				SeleniumHelper.click( cancelButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "cancel Button is clicked sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "cancel Button button is not clicked ");
//		}
//		return status;
//	}
//
//	public static Boolean clickbrowserRefresh() throws Exception 
//	{
//		Boolean status = false;
//		try 
//		{
//			GlobalVariable.driver.navigate().refresh();
//			status = true;
//		}
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to refresh browser");
//		}
//		return status;
//	}
//
//	public static Boolean validatetMultipleCopyTimeline() throws Exception 
//	{
//		Boolean status = false;
//		WebElement copyevent1 = NextstepFaxInbox.getFirstTimelineEvent();
//		WebElement copyevent2 = NextstepFaxInbox.getSecondTimelineEvent();
//		String timelineevent1 = copyevent1.getText();
//		String timelineevent2 = copyevent2.getText();
//		try 
//		{
//			if (timelineevent1.contains("copied this document") && timelineevent2.contains("copied this document")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Multiple copy validation is successfull");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Multiple copy validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean selectDocumentWithMorePages() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> pages = NextstepFaxInbox.getPages();
//		try 
//		{
//			for (int i = 0; i <= pages.size(); i++) 
//			{
//				String pagenumber = pages.get(i).getText();
//				int j = Integer.parseInt(pagenumber);
//				if (j > 1) 
//				{
//					WebElement test = pages.get(i);
//					if (SeleniumHelper.isExist(test)) 
//					{
//						documentID = getDocumentIDWithIndex(i);
//						SeleniumHelper.click( test);
//						status = true;
//						break;
//					}
//				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "No record available with more than one page");
//		}
//		return status;
//	}
//
//	public static Boolean clickDocumentOpenButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement open = NextstepFaxInbox.getOpenButton();
//		try
//		{
//			if (SeleniumHelper.isExist(open)) 
//			{
//				SeleniumHelper.click( open);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "open is clicked sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "open button is not clicked ");
//		}
//		return status;
//	}
//
//	public static Boolean selectViewerSecondThumbnail() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> thumbnails = NextstepFaxInbox.getViewerThumbnailsList();
//		try 
//		{
//			if (thumbnails.size() > 1) 
//			{
//				WebElement thumbnail2 = thumbnails.get(1);
//				if (SeleniumHelper.isExist(thumbnail2)) 
//				{
//					SeleniumHelper.click( thumbnail2);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Exception, "Thumbnail 2 is clicked successfully");
//				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Thumbnail 2 is not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean validateToastNotification() throws Exception 
//	{
//		Boolean status = false;	
//		WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 90);
//		try 
//		{
//			WebElement clickhere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-notification']/div/div[1]/div")));
//			if (SeleniumHelper.isExist(clickhere)) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Exception, "Toast Notification is validated successfully");
//				System.out.println("Toast Notification is validated successfully");
//			}
//			else
//			{
//				Logger.writeDayLog(Logger.messageType.Exception, "Toast Notification validation is failed");
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Toast Notification validation is failed");
//		}
//		return status;
//	}
//
//	public static Boolean clickToastNotification() throws Exception 
//	{
//		Boolean status = false;		
//		WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 90);
//		try 
//		{
//			WebElement clickhere = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-notification']/div/div[1]/div")));			
//			clickhere.click();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Exception, "Toast Notification is clicked successfully");
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click tToast Notification");
//		}
//		return status;
//	}
//
//	public static Boolean selectDocumentWithInvalidFaxNumberandValidate() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> faxnumber = NextstepFaxInbox.getFaxNumbers();
//		try 
//		{
//			for (int i = 0; i <= faxnumber.size(); i++) 
//			{
//				String number = faxnumber.get(i).getText();
//				if (number.equals("11111111111")) 
//				{
//					WebElement test = faxnumber.get(i);
//					if (SeleniumHelper.isExist(test)) 
//					{
//						SeleniumHelper.click( test);
//						status = true;
//						clickPropertiesButton();
//						clickPropertiesDocumentDetailTab();
//						clickDocumentDetailsMessageID();
//						validateStatusDescriptionInvalidFaxNumber();
//						clickDocumentDetailsMessageID();
//						clickePropertiesCloseButton();
//						clickLogout();
//						killDriver();
//						break;
//					}
//				}
//				else
//				{
//					status = true;
//					clickLogout();
//					killDriver();
//					break;
//					
//				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "No record available with more than one page");
//		}
//		return status;
//	}
//
//	public static Boolean selectDocumentWithValidFaxNumber() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> faxnumber = NextstepFaxInbox.getFaxNumbers();
//		try 
//		{
//			for (int i = 0; i <= faxnumber.size(); i++) 
//			{
//				String number = faxnumber.get(i).getText();
//				if (number.equals("18662703139")) 
//				{
//					WebElement test = faxnumber.get(i);
//					if (SeleniumHelper.isExist(test)) 
//					{
//						SeleniumHelper.click( test);
//						status = true;
//						break;
//					}
//				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "No record available with more than one page");
//		}
//		return status;
//	}
//
//	public static Boolean validateStatusDescriptionInvalidFaxNumber() throws Exception 
//	{
//		Boolean status = false;
//		WebElement statusDescription = NextstepFaxInbox.getDocumentStatusDescription();
//		try 
//		{
//			String input = statusDescription.getText();
//			String split[] = new String[input.split(" ").length];
//			split = input.split(" ");
//			String StatusDescription = split[0];
//			Logger.writeDayLog(Logger.messageType.Pass, "Fax duration taken " + StatusDescription);
//			if (StatusDescription.contains("Blocked")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Status description validation is passed");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Status description is undefined");
//		}
//		return status;
//	}
//
//	public static Boolean validateStatusDescriptionValidFaxNumber() throws Exception 
//	{
//		Boolean status = false;
//		WebElement statusDescription = NextstepFaxInbox.getDocumentStatusDescription();
//		try 
//		{
//			String input = statusDescription.getText();
//			String split[] = new String[input.split(" ").length];
//			split = input.split(" ");
//			String StatusDescription = split[0];
//			Logger.writeDayLog(Logger.messageType.Pass, "Fax duration taken " + StatusDescription);
//			if (StatusDescription.contains("Success")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Status description validation is passed");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Status description is undefined");
//		}
//		return status;
//	}
//
//	public static Boolean validateNewOutBoundFolderCount() throws Exception 
//	{
//		Boolean status = false;
//		try 
//		{
//			if (GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount + 1) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "New Document count validation is successfull");
//				System.out.println("New Document Folder count validation is sucessfull");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "New Document count validation is successfull");
//		}
//		return status;
//	}
//
//	public static Boolean splitAllPages() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> pageList = NextstepFaxInbox.getEditPagesList();
//		List<WebElement> moveList = NextstepFaxInbox.getAllPageMoveButton();
//		int count = pageList.size();
//		try 
//		{
//			Actions action = new Actions(GlobalVariable.driver);
//			for (int i = 0; i < count; i++) 
//			{
//				WebElement firstPage = pageList.get(i);
//				action.moveToElement(firstPage).perform();
//				WebElement subElement = moveList.get(i);
//				action.moveToElement(subElement);
//				action.click();
//				action.perform();
//			}
//			status = clickSaveAndExit();
//			waitForPageLoad();
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Failed to split document");
//		}
//		return status;
//	}
//
//	public static Boolean validateLoginUserNamewithoutPassword() throws Exception 
//	{
//		Boolean status = false;
//		WebElement passisrequired = NextstepFaxInbox.getPasswordisRequired();
//		try
//		{
//			String password = passisrequired.getText();
//			if (password.equals("Password must be supplied")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Login validation without password is successfull");				
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Login validation without password is successfull");
//		}
//		return status;
//	}
//
//	public static Boolean validateLoginPasswordwithoutUsername() throws Exception 
//	{
//		Boolean status = false;
//		WebElement userisrequired = NextstepFaxInbox.getUserNameisRequired();
//		try 
//		{
//			String username = userisrequired.getText();
//			if (username.contains("The Username field is required")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Login validation without username is successfull");				
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Login validation without username is successfull");
//		}
//		return status;
//	}
//
//	public static Boolean clickDownloadValidationOKButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement okButton = NextstepFaxInbox.getDownloadValidationOkButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(okButton)) 
//			{
//				SeleniumHelper.click( okButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Ok is clicked sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Ok button is clicked sucessfully");
//		}
//		return status;
//	}
//
//	public static Boolean clickEditPagesValidationSaveButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement saveButton = NextstepFaxInbox.getEditPagesValidationSaveButton();
//		try
//		{
//			if (SeleniumHelper.isExist(saveButton)) 
//			{
//				SeleniumHelper.click( saveButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "save is clicked sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "save button is clicked sucessfully");
//		}
//		return status;
//	}
//
//	public static Boolean clickEditPagesValidationDiscardButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement discardButton = NextstepFaxInbox.getEditPagesValidationDiscardButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(discardButton)) 
//			{
//				SeleniumHelper.click( discardButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "discard is clicked sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "discard button is clicked sucessfully");
//		}
//		return status;
//	}
//
//	public static Boolean clickEditPagesValidationCancelButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement cancelButton = NextstepFaxInbox.getEditPagesValidationCancelButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(cancelButton)) 
//			{
//				SeleniumHelper.click( cancelButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "cancel is clicked sucessfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "cancel button is clicked sucessfully");
//		}
//		return status;
//	}
//
//	public static Boolean selectDocumentStatusComplete() throws Exception 
//	{
//		Boolean status = false;
//		WebElement complete = NextstepFaxInbox.getDocumentStatusComplete();
//		try 
//		{
//			if (SeleniumHelper.isExist(complete)) 
//			{
//				SeleniumHelper.click( complete);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document status-complete clicked sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Document status-complete not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean selectViewerDocumentStatusChangeNoButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement noButton = NextstepFaxInbox.getViewerDocumentStatusChangeNoButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(noButton)) 
//			{
//				SeleniumHelper.click( noButton);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "No button clicked sucessfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "No button not clicked");
//		}
//		return status;
//	}
//
//	public static Boolean clickFolderCompleted(String name) throws Exception 
//	{
//		Boolean status = false;
//		WebElement completedFolder = NextstepFaxInbox.getFolderWithName( name);
//		try 
//		{
//			if (SeleniumHelper.isExist(completedFolder)) 
//			{
//				SeleniumHelper.click( completedFolder);
//				Logger.writeDayLog(Logger.messageType.Pass, "Completed folder is successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, " Completed folder is not successfully");
//			status = false;
//		}
//		return status;
//	}
//
//	public static Boolean isInFaxViewer() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(2000);
//		WebElement sendButton = NextstepFaxInbox.getFaxViewerSendButton();
//		WebElement Download = NextstepFaxInbox.getFaxViewerDownload();
//		try 
//		{
//			if ((sendButton.isDisplayed()) && (Download.isDisplayed())) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Fax viewer opened sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to open Fax Viewer");
//		}
//		return status;
//	}
//	public static Boolean selectDocumentWithPagesToMerge() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> pages = NextstepFaxInbox.getMergeWindowFaxListPages();
//		try 
//		{
//			for (int i = 0; i <= pages.size(); i++) 
//			{
//				String pagenumber = pages.get(i).getText();
//				int j = Integer.parseInt(pagenumber);
//				if (j > 0) 
//				{
//					WebElement test = pages.get(i);
//					if (SeleniumHelper.isExist(test)) 
//					{
//						SeleniumHelper.click( test);
//						GlobalVariable.destinationFaxPageCount = j;
//						status = true;
//						Logger.writeDayLog(Logger.messageType.Pass, "Selected a document to merge with count : " +j);
//						break;
//					}
//				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "No record available with more than one page");
//		}
//		return status;
//	}
//	
//	public static Boolean select30kFolderToCopy() throws Exception
//	{
//		Boolean status=false;
//		Thread.sleep(1000);
//		WebElement firstFolder = NextstepFaxInbox.get30kFolderToCopy();
//		try
//		{
//			if(SeleniumHelper.isExist(firstFolder))
//			{				
//				SeleniumHelper.click( firstFolder);	
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "30k folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click 30k folder");
//		}
//		return status;
//	}
//	public static Boolean waitForGridLoad() throws Exception
//    {
//           Boolean status = false;
//           try
//           {   
//        	   SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, NextstepFaxInbox.getLoadingSpinner());
//        	   WebDriverWait grid = new WebDriverWait(GlobalVariable.driver, 60);
//        	   grid.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getFaxInboxGridFirstRow())));
//               status = true;
//           }
//           catch(Exception e)
//           {
//                  status=false;
//                  Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//           }
//           return status;
//    } 
//	public static Boolean waitForLoginLoad() throws Exception
//    {
//           Boolean status = false;
//          try
//           {
//        	  GlobalVariable.driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//        	  WebDriverWait logout = new WebDriverWait(GlobalVariable.driver, 60);
//       	      logout.until(ExpectedConditions.elementToBeClickable(NextstepFaxInbox.getLogoutButton()));
//       	      WebDriverWait grid = new WebDriverWait(GlobalVariable.driver, 45);
//              grid.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getFaxInboxGridFirstRow()))); 
//       	      status = true;
//           }
//           catch(Exception e)
//           {
//                  status=false;
//                  Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//           }
//           return status;
//    }    
//    public static Boolean waitForViewerLoad() throws Exception
//    {
//           Boolean status = false;
//           SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, NextstepFaxInbox.getViewerLoader());
//           List<WebElement> faxList = NextstepFaxInbox.getThumbnailsList();
//           try
//           {      
//                  if(faxList.size()!=0) 
//                  {
//                  WebDriverWait viewer = new WebDriverWait(GlobalVariable.driver, 45);
//                  viewer.until(ExpectedConditions.visibilityOf(NextstepFaxInbox.getFaxViewerDocumentArea()));
//                  WebDriverWait tools = new WebDriverWait(GlobalVariable.driver, 45);
//                  tools.until(ExpectedConditions.elementToBeClickable(NextstepFaxInbox.getTools()));
//                  Logger.writeDayLog(Logger.messageType.Pass, "Page is loaded");
//                  System.out.println("Viewer Page is loaded successfully");
//                  status = true;
//                  }
//           }
//           catch(Exception e) 
//           {
//                  Logger.writeDayLog(Logger.messageType.Exception, "Fax not loaded " +e.getMessage());
//           }
//           return status;             
//    }
//    
//    public static Boolean waitForGridTimelineLoad() throws Exception
//    {
//           Boolean status = false;
//           try
//           {
//        	   //GlobalVariable.driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//        	   WebDriverWait loader = new WebDriverWait(GlobalVariable.driver, 45);
//        	   loader.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getGridTimelineLoader())));
//        	   SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, NextstepFaxInbox.getGridTimelineLoader());
//        	   WebDriverWait timeline = new WebDriverWait(GlobalVariable.driver, 45);
//        	   timeline.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getFirstTimelineEvent())));       	   
//               status = true;
//           }
//           catch(Exception e)
//           {
//                  status=false;
//                  Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//           }
//           return status;
//    }
//    public static Boolean clickLogin2() throws Exception
//	{
//		Boolean status = false;
//		WebElement temp = NextstepFaxInbox.getLoginButton();
//		try
//		{			
//			if(SeleniumHelper.isExist(temp))
//			{
//				SeleniumHelper.click( temp);
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
//    public static Boolean loginTimeCalculation() throws Exception
//    {
//           Boolean status = false;
//           try
//           {      
//                  launch(GlobalVariable.baseURL, UserInput.BrowserName);
//                  enterUserName(GlobalVariable.userName);
//                  enterPassword(GlobalVariable.password);
//                  DateTime startTime = DateTimeHelper.GetCurrentTime();
//                  clickLogin2();                 
//                  verifyUserName();
//                  waitForLoginLoad(); 
//                  DateTime endTime = DateTimeHelper.GetCurrentTime();
//                  String t = DateTimeHelper.getSecondsDifferenceasString(startTime, endTime);
//                  System.out.println(t);
//                  GlobalVariable.timeTaken = t;
//                  Logger.writeDayLog(Logger.messageType.Pass, "Time difference is calculated");
//                  status = true;      
//           }
//           catch(Exception e)
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Not able to calculate timing" + e.getStackTrace());
//           }
//           return status;
//    }
//    public static Boolean loginTimeCalculationWithoutLogout() throws Exception
//    {
//           Boolean status = false;
//           String [] timeVal = new String[5]; 
//           try
//           {      
//                  launch(GlobalVariable.baseURL, UserInput.BrowserName);
//                  for(int i =0;i<5;i++)
//                  {
//	                  enterUserName(GlobalVariable.userName);
//	                  enterPassword(GlobalVariable.password);
//	                  DateTime startTime = DateTimeHelper.GetCurrentTime();
//	                  clickLogin2();                 
//	                  verifyUserName();
//	                  waitForLoginLoad(); 
//	                  DateTime endTime = DateTimeHelper.GetCurrentTime();
//	                  String t = DateTimeHelper.getSecondsDifferenceasString(startTime, endTime);
//	                  System.out.println(t);
//	                  GlobalVariable.timeTaken = t;
//	                  timeVal[i] = t;
//	                  Logger.writeDayLog(Logger.messageType.Pass, "Time difference is calculated");
//	                  clickLogoutValidation();
//	                  status = true;	                  
//                  }
//           }
//           catch(Exception e)
//           {
//                  status = false;
//                  Logger.writeDayLog(Logger.messageType.Exception, "Not able to calculate timing" + e.getStackTrace());
//           }
//           return status;
//    }
//    public static Boolean clickSubFolder(String name) throws Exception 
//    {	
//		Boolean status = false;;
//		WebElement subFolder = NextstepFaxInbox.getFolderWithName(name);
//		try
//		{
//			if(SeleniumHelper.isExist(subFolder)) {
//				SeleniumHelper.click(subFolder);
//				Thread.sleep(2000);
//				Logger.writeDayLog(Logger.messageType.Pass, "sub folder is clicked successfully");
//				status = true;
//			}
//			else
//			{				
//				throw new Exception();
//			}			
//		}
//		catch(Exception e) 
//		{	
//			status = false;		
//			Logger.writeDayLog(Logger.messageType.Exception, "unable to click sub folder");
//			
//		}
//	return status;
//	}
//    public static int getGridCount() throws Exception 
//    {	
//		int finalValue= -1;
//		WebElement gridcount = NextstepFaxInbox.getGridCount();
//		try
//		{
//			if(SeleniumHelper.isExist(gridcount)) 
//			{
//				String faxcount=gridcount.getAttribute("textContent") ;
//				String count=faxcount.substring(10);
//				String[] parts = count.split(" ");
//		    	String part1 = parts[2];
//				//System.out.println(part1);
//				double temp = Double.parseDouble(part1);
//				//System.out.println(temp);
//				finalValue = (int) temp;
//				Logger.writeDayLog(Logger.messageType.Pass, "gridcount is updated successfully");
//			}
//			else
//			{				
//				throw new Exception();
//			}			
//		}
//		catch(Exception e) 
//		{			
//			Logger.writeDayLog(Logger.messageType.Exception, " folder count is not updated");
//			return finalValue;
//		}
//		return finalValue;
//    }
//	public static Boolean newMoveValidation() throws Exception
//	{
//		Boolean status = false;		
//		try
//		{
//			if(GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount -1) 
//			{
//				status=true;
//				Logger.writeDayLog(Logger.messageType.Pass, "move/delete grid count validation is success");
//				System.out.println("move validation is sucessfull");
//			}
//			else if(GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount) 
//			{
//				status=true;
//				Logger.writeDayLog(Logger.messageType.Pass, "copy grid count validation is success");
//				System.out.println("copy validation is sucessfull");
//			}
//			else if(GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount +1) 
//			{
//				status=true;
//				Logger.writeDayLog(Logger.messageType.Pass, "copy/move grid count validation is success");
//				System.out.println("copy validation is sucessfull");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Copy/Move validation failed");
//		}
//		return status;
//	}
//	public static Boolean validateFolderView(String name) throws Exception 
//	{	
//		Boolean status = false;
//		WebElement subFolder = NextstepFaxInbox.getFolderWithName( name);
//		try
//		{
//			if(SeleniumHelper.isDisplayed( subFolder)) 
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Folder structure is available");
//				status = true;
//				System.out.println("Folder structure is diSplayed properly");
//			}
//			else
//			{				
//				throw new Exception();
//			}		
//		}
//		catch(Exception e) 
//		{	
//			status = false;		
//			Logger.writeDayLog(Logger.messageType.Exception, "Folder structure is not available");		
//		}
//		return status;
//	}
//	public static Boolean clickMergeSearchButton() throws Exception 
//	{	
//		Boolean status = false;;
//		WebElement search = NextstepFaxInbox.getmergeSearchButton();
//		try
//		{
//			if(SeleniumHelper.isExist(search)) 
//			{
//				SeleniumHelper.click( search);
//				Logger.writeDayLog(Logger.messageType.Pass, "search is clicked successfully");
//				status = true;
//			}
//			else
//			{				
//				throw new Exception();
//			}			
//		}
//		catch(Exception e) 
//		{	
//			status = false;		
//			Logger.writeDayLog(Logger.messageType.Exception, "unable to click search button");			
//		}
//		return status;
//	}
//	public static Boolean clickMergeCancelButton() throws Exception 
//	{		
//		Boolean status = false;;
//		WebElement cancel = NextstepFaxInbox.getmergeCancelButton();
//		try
//		{
//			if(SeleniumHelper.isExist(cancel)) 
//			{
//				SeleniumHelper.click( cancel);
//				Logger.writeDayLog(Logger.messageType.Pass, "cancel is clicked successfully");
//				status = true;
//			}
//			else
//			{				
//				throw new Exception();
//			}			
//		}
//		catch(Exception e) 
//		{	
//			status = false;		
//			Logger.writeDayLog(Logger.messageType.Exception, "unable to click cancel button");		
//		}
//		return status;
//	}
//	public static Boolean validateMergeButton() throws Exception 
//	{		
//		Boolean status = false;
//		String records=null;
//		WebElement noRecords = NextstepFaxInbox.getNoRecordsReturned();
//		WebElement merge = NextstepFaxInbox.getMergeWindowMergeButton();
//		try
//		{
//			records = noRecords.getText();
//			if(records.contains("No Record(s) Returned")) 
//			{
//				if(SeleniumHelper.isEnabled( merge))
//				{
//					Logger.writeDayLog(Logger.messageType.Pass, "Merge button is enabled");
//					SeleniumHelper.click( merge);
//					status = false;
//				}
//				else
//				{
//					Logger.writeDayLog(Logger.messageType.Pass, "Merge button is disabled");
//					status = true;
//				}
//			}
//			else
//			{	
//				status=true;
//				System.out.println("The grid contains document so skipping the test case");
//			}			
//		}
//		catch(Exception e) 
//		{	
//			status = false;		
//			Logger.writeDayLog(Logger.messageType.Exception, "Able to click the merge button");		
//		}
//		return true;
//	}
//	public static Boolean validateCurrentFolderName() throws Exception 
//	{		
//		Boolean status = false;
//		WebElement name = NextstepFaxInbox.getCurrentFolderName();
//		try
//		{
//			String folderName = name.getText();
//			if(folderName.contains("Inbox")) 
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "current folder is validated successfully");
//				status = true;
//			}
//			else
//			{				
//				throw new Exception();
//			}			
//		}
//		catch(Exception e) 
//		{	
//			status = false;		
//			Logger.writeDayLog(Logger.messageType.Exception, "The current folder is not loaded properly");			
//		}
//		return status;
//	}
//	public static String getCurrentFolderName() throws Exception 
//	{		
//		String folderName=null;
//		WebElement name = NextstepFaxInbox.getCurrentFolderName();
//		try
//		{
//			folderName = name.getText();
//			Logger.writeDayLog(Logger.messageType.Exception, "The current folder is captured");
//		}
//		catch(Exception e) 
//		{	
//		 Logger.writeDayLog(Logger.messageType.Exception, "Unable to capture folder name");			
//		}
//		return folderName;
//	}
//	public static Boolean validateFolderAfterRefresh() throws Exception 
//	{		
//		Boolean status = false;;
//		try
//		{
//			if(GlobalVariable.folderName.contains(GlobalVariable.folderName2))
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Default shared queue is validated successfully");
//				status = true;
//			}
//			else
//			{				
//				throw new Exception();
//			}			
//		}
//		catch(Exception e) 
//		{	
//			status = false;		
//			Logger.writeDayLog(Logger.messageType.Exception, "The default folder is not loaded properly");			
//		}
//		return status;
//	}
//	public static Boolean openLastEditedDocument() throws Exception
//	{
//		WebElement temp = null;
//		Thread.sleep(3000);
//		Boolean status = false;;
//		List <WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();
//		String[] rowValue = new String[rows.size()];
//		try
//		{
//			for(int i = 0; i<rows.size(); i++)
//			{
//				temp =rows.get(i);
//				rowValue[i] = temp.getAttribute("data-automation-id");
//				if(documentID.equals(rowValue[i])) 
//				{
//					WebElement correctRow = rows.get(i);
//					SeleniumHelper.doubleClick(correctRow);
//					status = true;			
//					Logger.writeDayLog(Logger.messageType.Exception, "Last opened document is clicked successfully");
//					break;
//				}
//			}		
//		}
//		catch(Exception e) 
//		{	
//			status = false;		
//			Logger.writeDayLog(Logger.messageType.Exception, "unable to click cancel button");			
//		}
//		return status;
//	}
//	public static Boolean selectDocumentStatusRuleTesting() throws Exception
//	{
//	    Boolean status=false;       
//	    WebElement ruleTesting = NextstepFaxInbox.getDocumentStatusRuleTesting();
//	    try
//	    {
//	        if(SeleniumHelper.isExist(ruleTesting))
//	        {
//	            SeleniumHelper.click( ruleTesting);                           
//	            status = true;
//	            Logger.writeDayLog(Logger.messageType.Pass, "Rule Testing document status is completed");
//	            }
//	            else
//	            {
//	                throw new Exception();
//	            }
//	    }
//	    catch(Exception e)
//	    {
//	        status = false;
//	        Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	    }
//	    return status;
//	}
//	public static Boolean gotoRuleTestingFolder() throws Exception
//	{
//	    Boolean status=false;       
//	    WebElement ruleTestingFolder = NextstepFaxInbox.getRuleTestingFolder();
//	    try
//	    {
//	        if(SeleniumHelper.isExist(ruleTestingFolder))
//	        {
//	            SeleniumHelper.click( ruleTestingFolder);                           
//	            status = true;
//	            Logger.writeDayLog(Logger.messageType.Pass, "Rule Testing Folder is selected successfully");
//	            }
//	            else
//	            {
//	                throw new Exception();
//	            }	       
//	    }
//	    catch(Exception e)
//	    {
//	        status = false;
//	        Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	    }
//	    return status;
//	}
//	public static Boolean clickLastEditedDocument() throws Exception
//	{
//	    WebElement temp = null;
//	    Boolean status = false;;
//	    List <WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();
//	    String[] rowValue = new String[rows.size()];
//	    try
//	    {
//	        for(int i = 0; i<rows.size(); i++)
//	        {
//	            temp =rows.get(i);
//	            rowValue[i] = temp.getAttribute("data-automation-id");
//	            if(documentID.equals(rowValue[i]))
//	            {
//		            WebElement correctRow = rows.get(i);
//		            SeleniumHelper.click( correctRow);
//		            status = true;
//		            Logger.writeDayLog(Logger.messageType.Exception, "Last opened document is clicked successfully");
//		        }
//	        }	       
//	    }
//	    catch(Exception e)
//	    {   
//	        status = false;       
//	        Logger.writeDayLog(Logger.messageType.Exception, "unable to click cancel button");	       
//	    }
//	    return status;
//	}
//	public static Boolean ValidateAllTimelineEvent() throws Exception
//	{
//	    List <WebElement> timeline = NextstepFaxInbox.getAllTimelineEventGrid();
//	    Boolean status=false;
//	    try
//	    {
//	        for(int i = 0; i<timeline.size(); i++)
//	        {
//	            if(timeline.get(i).getText().contains("NEXTSTEP assigned document status Rule Completed"))
//	            {
//	                status = true;
//	                Logger.writeDayLog(Logger.messageType.Exception, "Sequetial Rule Multiple Action is completed");
//	                break;
//	            }	           
//	        }
//	    }
//	    catch(Exception e)
//	    {   
//	        status = false;       
//	        Logger.writeDayLog(Logger.messageType.Exception, "unable to click cancel button");	       
//	    }
//	    return status;
//	}
//	public static Boolean clickAdvanceSearchIcon() throws Exception
//	{
//	    Boolean status = false;
//	    WebElement search = NextstepFaxInbox.getAdvanceSearchIcon();
//	    try
//	    {           
//	        if(SeleniumHelper.isExist(search))
//	        {
//	            SeleniumHelper.click(search);
//	            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch is clicked successfully");
//	            status = true;
//	        }
//	        else
//	        {               
//	            throw new Exception();
//	        }	       
//	    }
//	    catch(Exception e)
//	    {   
//	        status = false;       
//	        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search icon");	     
//	    }
//	    return status;               
//	}
//	public static Boolean enterAdvanceSearchText(String value) throws Exception
//	{
//	    Boolean status = false;
//	    WebElement searhText = NextstepFaxInbox.getAdvanceSearchTextbox();
//	    try
//	    {
//	        if(SeleniumHelper.setText(searhText, value))
//	        {               
//	            status = true;
//	            Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as search text");
//	        }
//	        else
//	        {
//	            status = false;
//	            Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in seach text");
//	        }
//	    }
//	    catch(Exception e)
//	    {
//	        status = false;
//	        Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter search text");
//	    }           
//	    return status;
//	}
//	public static Boolean clickAdvanceSearchButton() throws Exception
//	{
//	    Boolean status = false;
//	    WebElement search = NextstepFaxInbox.getAdvanceSearchButton();
//	    try
//	    {           
//	        if(SeleniumHelper.isExist(search))
//	        {
//	            SeleniumHelper.click( search);
//	            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch button is clicked successfully");
//	            status = true;
//	        }
//	        else
//	        {               
//	            throw new Exception();
//	        }	       
//	    }
//	    catch(Exception e)
//	    {   
//	        status = false;       
//	        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search button");	       
//	    }
//	    return status;               
//	}
//	public static Boolean clickAdvanceSearchAddFilterButton() throws Exception
//	{
//	    Boolean status = false;
//	    WebElement add = NextstepFaxInbox.getAdvanceSearchAddButton();
//	    try
//	    {           
//	        if(SeleniumHelper.isExist(add))
//	        {
//	            SeleniumHelper.click( add);
//	            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch add button is clicked successfully");
//	            status = true;
//	        }
//	        else
//	        {               
//	            throw new Exception();
//	        }	       
//	    }
//	    catch(Exception e)
//	    {   
//	        status = false;       
//	        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search add button");	       
//	    }
//	    return status;               
//	}
//	public static Boolean clickAdvanceSearchQueueFilterButton(boolean dflag) throws Exception
//	{
//	    Boolean status = false;
//	    WebElement SQDropDown = NextstepFaxInbox.getAdanceSearchSharedQueueDropDown();
//	    if(dflag==true)
//	    {
//		    try
//		    {           
//		        if(SeleniumHelper.isExist(SQDropDown))
//		        {
//		            SeleniumHelper.click( SQDropDown);
//		            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch Shared queue dropdown button is clicked successfully");
//		            status = true;
//		        }
//		        else
//		        {               
//		            throw new Exception();
//		        }	       
//		    }
//		    catch(Exception e)
//		    {   
//		        status = false;       
//		        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search Shared queue dropdown button");	       
//		    }
//	    }
//	    else
//		{
//			status = true;
//		}
//	    return status;               
//	}
//	public static Boolean clickAdvanceSearchFolderFilterButton() throws Exception
//	{
//	    Boolean status = false;
//	    Thread.sleep(1000);
//	    if(UserInput.folderFlag==true)
//	    {
//		    WebElement FolderDropDown = NextstepFaxInbox.getAdanceSearchFolderDropDown();
//		    try
//		    {           
//		        if(SeleniumHelper.isExist(FolderDropDown))
//		        {
//		            SeleniumHelper.click( FolderDropDown);
//		            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch folder dropdown button is clicked successfully");
//		            status = true;
//		        }
//		        else
//		        {               
//		            throw new Exception();
//		        }	       
//		    }
//		    catch(Exception e)
//		    {   
//		        status = false;       
//		        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search folder dropdown button");	       
//		    }
//	    }
//	    else
//		{
//			status = true;
//		}
//	    return status;               
//	}
//	public static Boolean clickAdvanceSearchFilterButton() throws Exception
//	{
//	    Boolean status = false;
//	    if(UserInput.filterFlag==true)
//	    {
//		    WebElement filterDropDown = NextstepFaxInbox.getAdanceSearchFilterDropDown();
//		    try
//		    {           
//		        if(SeleniumHelper.isExist(filterDropDown))
//		        {
//		            SeleniumHelper.click( filterDropDown);
//		            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch filter dropdown button is clicked successfully");
//		            status = true;
//		        }
//		        else
//		        {               
//		            throw new Exception();
//		        }	       
//		    }
//		    catch(Exception e)
//		    {   
//		        status = false;       
//		        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search filter dropdown button");	       
//		    }
//	    }
//	    else
//		{
//			status = true;
//		}
//	    return status;               
//	}
//	public static Boolean validateAdvanceSearchResult() throws Exception
//	{
//	    Boolean status=false;
//	    Thread.sleep(1000);
//	    WebElement descriptionvalue = NextstepFaxInbox.getDescriptionTextbox();
//	    String description = descriptionvalue.getAttribute("value");
//	    try
//	    {
//	        if(description.equals(UserInput.SearchText))
//	        {               
//	            status = true;
//	            Logger.writeDayLog(Logger.messageType.Pass, "Advance Serach result is verified successfully");
//	            System.out.println("Azure search is validated successfully");
//	        }
//	        else
//	        {
//	            status = false;
//	            throw new Exception();
//	        }
//	    }
//	    catch(Exception e)
//	    {
//	        status = false;
//	        Logger.writeDayLog(Logger.messageType.Exception, "Advance Serach resul is not verified");
//	    }
//	    return status;       
//	}
//	public static Boolean clickAdvanceSearchResetButton() throws Exception
//	{
//	    Boolean status = false;
//	    WebElement reset = NextstepFaxInbox.getAdvanceSearchResetButton();
//	    try
//	    {           
//	        if(SeleniumHelper.isExist(reset))
//	        {
//	            SeleniumHelper.click( reset);
//	            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch reset button is clicked successfully");
//	            status = true;
//	        }
//	        else
//	        {               
//	            throw new Exception();
//	        }	       
//	    }
//	    catch(Exception e)
//	    {   
//	        status = false;       
//	        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search reset button");	       
//	    }
//	    return status;               
//	}
//	public static Boolean clickAdvancecancelButton() throws Exception
//	{
//	    Boolean status = false;
//	    WebElement cancel = NextstepFaxInbox.getAdanceSearchCancelButton();
//	    try
//	    {           
//	        if(SeleniumHelper.isExist(cancel))
//	        {
//	            SeleniumHelper.click( cancel);
//	            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch cancel button is clicked successfully");
//	            status = true;
//	        }
//	        else
//	        {               
//	            throw new Exception();
//	        }	       
//	    }
//	    catch(Exception e)
//	    {   
//	        status = false;       
//	        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search cancel button");	       
//	    }
//	    return status;               
//	}
//	public static Boolean ValidateOriginalVersionPopUp() throws Exception 
//	{
//		Boolean status = false;
//		WebElement OriginalVersion = NextstepFaxInbox.getOriginalVersionPopUp();
//		String version = OriginalVersion.getText();
//		try 
//		{
//			if (version.equals("Original Document cannot be edited")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Version is validated successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Version validation is failed");
//		}
//		return status;
//	}
//	public static Boolean clickAdvanceSearchFilterSharedQueueWithName(String name) throws Exception 
//	{
//		Boolean status = false;
//		if(UserInput.queueFlag==true)
//		{
//			WebElement searchFilter = NextstepFaxInbox.getAdvanceSearchShareQueueFilterWithName(name);
//			try 
//			{
//				if (SeleniumHelper.isExist(searchFilter)) 
//				{
//					SeleniumHelper.click( searchFilter);
//					Logger.writeDayLog(Logger.messageType.Pass, "Search Filter is successfully");
//					status = true;
//				}
//			} 
//			catch (Exception e) 
//			{
//				Logger.writeDayLog(Logger.messageType.Exception, "Search filter is not selected successfully");
//				status = false;
//			}
//		}
//		else
//		{
//			status = true;
//		}		
//		return status;
//	}
//	
//	public static Boolean clickAdvanceSearchSelectFolder(String input) throws Exception
//	{
//		Boolean status=false;	
//		if(UserInput.folderFlag==true)
//	    {
//			List<WebElement> folderList = NextstepFaxInbox.getAdanceSearchFolderDropDownList();						
//			int finalCount = 0;
//			try
//			{			
//				String split[]=new String[input.split("\\|").length];
//				split = input.split("\\|");
//				for(int i = 0; i<split.length;i++)
//				{
//					for(int j = 0; j<folderList.size();j++)
//					{
//						String temp = folderList.get(j).getText();
//						if(temp.equals(split[i]))
//						{
//							SeleniumHelper.click( folderList.get(j));
//							Thread.sleep(1000);
//							status = true;
//							break;
//						}
//					}
//				}			
//			}
//			catch(Exception e) 
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "Unable to Add given column(s)");
//			}
//	    }
//		else
//		{
//			status = true;
//		}
//		return status;
//	}
//	public static Boolean clickAdvanceSearchFilterWithName(String name) throws Exception 
//	{
//		Boolean status = false;
//		if(UserInput.filterFlag==true)
//	    {
//			WebElement SQFilter = NextstepFaxInbox.getAdvanceSearchFilterWithName( name);
//			try 
//			{
//				if (SeleniumHelper.isExist(SQFilter)) 
//				{
//					SeleniumHelper.click( SQFilter);
//					Logger.writeDayLog(Logger.messageType.Pass, "Shared Queue Filter is successfully");
//					status = true;
//				}
//			} 
//			catch (Exception e) 
//			{
//				Logger.writeDayLog(Logger.messageType.Exception, "Shared Queue is not selected successfully");
//				status = false;
//			}
//	    }
//		else
//		{
//			status = true;
//		}
//		return status;
//	}
//	
//	public static Boolean clickParentFolder(String folder) throws Exception
//    {
//        Boolean status = false;
//        WebElement parentFolder = NextstepFaxInbox.getSubFolder(folder);
//        try
//        {
//            if (SeleniumHelper.isExist(parentFolder))
//            {
//                SeleniumHelper.click(parentFolder);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Parent Folder is Clicked Sucessfully");
//            }
//            else
//            {
//                status = false;
//                throw new Exception();
//            }
//        }
//        catch (Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Parent Folder");
//        }
//        return status;
//    }
//	public static Boolean SelectPreferenceDocumentPreview(String name) throws Exception
//    {
//        Boolean status = false;
//        WebElement option = NextstepFaxInbox.getPreferenceDocumentPreviewOption(name);
//        try
//        {
//            if (SeleniumHelper.isExist(option))
//            {
//                SeleniumHelper.click(option);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Preference Document Preview option is selected successfully");
//            }
//            else
//            {
//                status = false;
//                throw new Exception();
//            }
//        }
//        catch (Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Preference Document Preview option");
//        }
//        return status;
//    }
//	public static Boolean ValidatePreferenceDocumentPreview() throws Exception
//    {
//        Boolean status = false;
//        WebElement small = NextstepFaxInbox.getDocumentPreviewMediumSize();
//        try
//        {
//            if (SeleniumHelper.isExist(small))
//            {
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Preference Document Preview option is validated successfully");
//            }
//            else
//            {
//                status = false;
//                throw new Exception();
//            }
//        }
//        catch (Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Unable to validate Preference Document Preview option");
//        }
//        return status;
//    }
//	public static Boolean MouseHoverVersionButtonandClickResetAnnnotation() throws Exception 
//	{
//		Boolean status = false;
//		Thread.sleep(2000);
//		WebElement VersionButton = NextstepFaxInbox.geVersionButton();		
//		try 
//		{
//			if (SeleniumHelper.isExist(VersionButton)) 
//			{
//				Actions builder = new Actions(GlobalVariable.driver);
//   				Action hover = builder.moveToElement(VersionButton).build();
//   				hover.perform();				
//				WebElement resetAnnotations = NextstepFaxInbox.getResetAnnotation();
//				SeleniumHelper.doubleClick(resetAnnotations);
//				status = true;
//				waitForPageLoad();
//				Logger.writeDayLog(Logger.messageType.Pass, "version is hovered and resetAnnotations clicked successfully");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to hovered version and click resetAnnotations button");
//		}
//		return status;
//	}
//	public static Boolean validateResetAnnotation() throws Exception 
//	{
//		Boolean status = false;
//		WebElement event = NextstepFaxInbox.getViewerFirstTimelineEvent();
//		String timelineevent = event.getText();
//		WebElement event1 = NextstepFaxInbox.getViewerSecondTimelineEvent();
//		String timelineevent1 = event1.getText();
////		String username = NextstepFaxInbox.getLoggedUserName().getText();
//		try 
//		{
//			if ((timelineevent.contains("reset this document")) || (timelineevent1.contains("reset this document"))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Reset Annotation valiation Sucessfully");
//			} 
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Reset Annotation validation is failed");
//		}
//		return status;
//	}
//	public static Boolean selectMergeContextMenu() throws Exception
//	{
//		Boolean status=false;		
//		WebElement merge = NextstepFaxInbox.getMergeContextMenu();
//		try
//		{
//			if(SeleniumHelper.isExist(merge))
//			{				
//				SeleniumHelper.click( merge);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Merge is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Merge");
//		}
//		return status;
//	}
//	public static Boolean clickGridMergeStarted() throws Exception
//    {
//        Boolean status = false;
//        WebElement merge = NextstepFaxInbox.getGridMergeStarted();
//        try
//        {
//            if (SeleniumHelper.isExist(merge))
//            {
//                SeleniumHelper.click(merge);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Grid Merge is cliced successfully");
//            }
//            else
//            {
//                status = false;
//                throw new Exception();
//            }
//        }
//        catch (Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Grid Merge");
//        }
//        return status;
//    }
//	public static Boolean clickMergeButton() throws Exception
//    {
//        Boolean status = false;
//        WebElement merge = NextstepFaxInbox.getMergeButton();
//        try
//        {
//            if (SeleniumHelper.isExist(merge))
//            {
//                SeleniumHelper.click(merge);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Merge button is clicked successfully");
//            }
//            else
//            {
//                status = false;
//                throw new Exception();
//            }
//        }
//        catch (Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Merge button");
//        }
//        return status;
//    }
//	public static Boolean clickGridMergeCompleted() throws Exception
//    {
//        Boolean status = false;        
//        WebElement merge = NextstepFaxInbox.getGridMergeCompleted();
//        try
//        {
//            if (SeleniumHelper.isExist(merge))
//            {
//                SeleniumHelper.click(merge);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Grid Merge completed is cliced successfully");
//            }
//            else if(SeleniumHelper.isExist(NextstepFaxInbox.getGridMergeInProgress()))
//            {
//                status = true;
//                clickLogout();                
//                Logger.writeDayLog(Logger.messageType.Pass, "Grid Merge Inprogress so skipping test case");          
//            }
//            else {
//            	 status = false;
//            	 throw new Exception();
//            }
//         }
//        catch (Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Grid Merge Button");
//        }
//        return status;
//    }
//	public static Boolean clickMergeSave() throws Exception
//    {
//        Boolean status = false;
//        WebElement merge = NextstepFaxInbox.getGridMergeSave();
//        try
//        {
//            if (SeleniumHelper.isExist(merge))
//            {
//                SeleniumHelper.click(merge);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Grid Merge save is cliced successfully");
//            }
//            else
//            {
//                status = false;
//                throw new Exception();
//            }
//        }
//        catch (Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Grid Merge save");
//        }
//        return status;
//    }
//	public static Boolean clickDeletePageinMerge() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> thumbnailList = NextstepFaxInbox.getMergeThumbnails();
//		List<WebElement> deleteList = NextstepFaxInbox.getMergeThumbnailsDelete();
//		int count = thumbnailList.size();
//		try 
//		{
//			Actions action = new Actions(GlobalVariable.driver);
//			if (count>1) 
//			{
//				WebElement firstPage = thumbnailList.get(1);
//				action.moveToElement(firstPage).perform();
//				WebElement subElement = deleteList.get(1);
//				action.moveToElement(subElement);
//				action.click();
//				action.perform();
////				status = clickMergeSave();
//				status = true;
//			}
//			else 
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "only one document available so umable to delete");
//			}			
//			
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Failed to split document");
//		}
//		return status;
//	}
//	public static Boolean clickMergeCartDeleteAll() throws Exception
//    {
//        Boolean status = false;
//        WebElement deleteAll = NextstepFaxInbox.getMergeCartDeleteAllButton();
//        try
//        {
//            if (SeleniumHelper.isExist(deleteAll))
//            {
//                SeleniumHelper.click(deleteAll);
//                status = true;
//                Logger.writeDayLog(Logger.messageType.Pass, "Merge delete is cliced successfully");
//            }
//            else
//            {
//                status = false;
//                throw new Exception();
//            }
//        }
//        catch (Exception e)
//        {
//            status = false;
//            Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Merge delete");
//        }
//        return status;
//    }
//	public static Boolean validateRowandSelectDocument() throws Exception
//	{
//		WebElement doc = null;
//		Boolean status = false;
////		List<WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();
//		String[] temp = getDocumentID();
//		try
//		{
//			for(int i=0;i<=temp.length; i++)
//			{
//				if(documentID.equals(temp[i]))
//				{
//					doc= NextstepFaxInbox.getFaxInboxGriddRows().get(i);
//					SeleniumHelper.contextClick(doc);
//					Logger.writeDayLog(Logger.messageType.Pass, "Document Found");
//					System.out.println("Document is found");
//					status = true; 
//					break;
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Document not Found");
//			status = false;
//		}		
//		return status;
//	}
//	public static Boolean validateMoveDocumentProcessTrigger() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> timeline = NextstepFaxInbox.getGridTimelineEvents();		
//		try 
//		{
//			for (int i=0; i<timeline.size() ;i++) 
//			{
//				String event = timeline.get(i).getText();
//				if (event.contains("Started Process 'automation'")) 
//				{
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Move document process validation is Sucessfully");
//					System.out.println("Document process trigger validation is successful");
//					break;
//				}
//				}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Move document process validation is failed");
//		}
//		return status;
//	}
//	public static Boolean validateCopyDocumentProcessTrigger() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> timeline = NextstepFaxInbox.getGridTimelineEvents();		
//		try 
//		{
//			for (int i=0; i<timeline.size() ;i++) 
//			{
//				String event = timeline.get(i).getText();
//				if (event.contains("Started Process 'automation'")) 
//				{
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Move document process validation is Sucessfully");
//					System.out.println("Document process trigger validation is successful");
//					break;
//				}
//				}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Move document process validation is failed");
//		}
//		return status;
//	}
//	public static Boolean clickRotationWarningOkButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement ok = NextstepFaxInbox.getRotateWarningOkButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(ok)) 
//			{
//				SeleniumHelper.click(ok);
//				SeleniumHelper.click(NextstepFaxInbox.getViewerCancelButton());
//				FaxInbox.waitForPageLoad();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "This is annotated document so cannot save rotation");
//			}
//			else
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document is saved with rotation");
//			}
//		} 
//		catch (Exception e) 
//		{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "save is not clicked");
//		}
//		return status;
//	}
//	public static Boolean rotatioPreconditionCheck() throws Exception 
//	{
//		Boolean status = false;
//		WebElement editedStatus = NextstepFaxInbox.getEditedStatus();
//		String edited = editedStatus.getText();
//		try 
//		{
//			if (edited.contains("False")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Docucment is not edited so can proceed with rotation");
//				clickRotateRightButton();
//				clickSaveButton();
//				waitForPageLoad();
//				clickViewerTimeline();
//				waitForPageLoad();
//				validateRotation();
//				clickLogoutValidation();
//				killDriver();
//			}
//			else if(edited.contains("True"))
//			{
//				status = true;
//				clickLogoutValidation();
//				killDriver();
//				Logger.writeDayLog(Logger.messageType.Pass, "Docucment is edited so cannot save rotation");
//			}
//			else 
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Rotation is failed");
//		}
//		return true;
//	}
//	public static Boolean clickViewerMessageID() throws Exception
//	{
//		Boolean status=false;
//		WebElement id = NextstepFaxInbox.getViewerDocumentID();
//		try
//		{
//			if(SeleniumHelper.isExist(id))
//			{
//				SeleniumHelper.click( id);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Message ID  is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Message ID is not clicked");
//		}
//		return status;		
//	}
//	public static Boolean clickLogoutAfterToolsApplied() throws Exception
//	{
//		Boolean status = false;
//		WebElement temp = NextstepFaxInbox.getLogoutButton();
//		try
//		{			
//			if(SeleniumHelper.isExist(temp))
//			{
//				SeleniumHelper.click(temp);
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click " + e.getStackTrace());
//		}
//		return status;				
//	}
//	public static Boolean clickNextDocument() throws Exception
//	{
//		Boolean status=false;		
//		WebElement next = NextstepFaxInbox.getNextDocumentButton();
//		try
//		{
//			if(SeleniumHelper.isExist(next))
//			{				
//				SeleniumHelper.click( next);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Next document is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Next document");
//		}
//		return status;
//	}
//	public static Boolean clickPreviousDocument() throws Exception
//	{
//		Boolean status=false;		
//		WebElement next = NextstepFaxInbox.getPreviousDocumentButton();
//		try
//		{
//			if(SeleniumHelper.isExist(next))
//			{				
//				SeleniumHelper.click( next);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Previous document is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Previous document");
//		}
//		return status;
//	}
//	public static Boolean selectDocumentWithSinglePage() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> pages = NextstepFaxInbox.getPages();
//		try 
//		{
//			for (int i = 0; i <= pages.size(); i++) 
//			{
//				String pagenumber = pages.get(i).getText();
//				int j = Integer.parseInt(pagenumber);
//				if (j == 1) 
//				{
//					WebElement test = pages.get(i);
//					if (SeleniumHelper.isExist(test)) 
//					{
//						SeleniumHelper.click( test);
//						status = true;
//						break;
//					}
//				}
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "No record available with more than one page");
//		}
//		return status;
//	}
//	public static Boolean validateEditPagesButton() throws Exception
//	{
//		Boolean status=false;		
//		WebElement editPagesEdit = NextstepFaxInbox.getFaxViewerEditPagesEdit();
//		try
//		{
//			if(SeleniumHelper.isExist(editPagesEdit))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit Pages Edit button is available and not clicked");
//				}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Pass, "Edit Pages opened for single page document");
//				throw new Exception();
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Edit Pages Edit button is clickable for single page document");
//		}
//		return status;		
//	}
//	public static Boolean validateGridPage() throws Exception 
//	{
//		Boolean status = false;
//		WebElement sharedQueue = NextstepFaxInbox.getSharedQueueFolderHeader();
//		try 
//		{
//			if (sharedQueue.isDisplayed())
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Inbox grid is loaded successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Inbox grid is not");
//		}
//		return status;
//	}
//	public static Boolean clickLogout() throws Exception
//	{
//		Boolean status = false;
//		Thread.sleep(1000);
//		WebElement temp = NextstepFaxInbox.getLogoutButton();
//		try
//		{			
//			WebElement austria = new WebDriverWait( GlobalVariable.driver,10).until(ExpectedConditions.elementToBeClickable(temp));
//			if(SeleniumHelper.isExist(temp))
//			{
//				SeleniumHelper.click(temp);
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
//	public static Boolean splitAllPageVaidation() throws Exception
//	{
//		Boolean status = false;
//		List<WebElement> pageList = NextstepFaxInbox.getEditPagesList();
//		List<WebElement> moveList = NextstepFaxInbox.getAllPageMoveButton();
//		int count = pageList.size();
//		try 
//		{
//			Actions action = new Actions(GlobalVariable.driver);
//			for (int i = 0; i < count; i++) 
//			{
//				WebElement firstPage = pageList.get(i);
//				action.moveToElement(firstPage).perform();
//				WebElement subElement = moveList.get(i);
//				action.moveToElement(subElement);
//				action.click();
//				action.perform();
//			}
//			List<WebElement> destinationList = NextstepFaxInbox.getDestinationThumbnail();
//			if(count - destinationList.size() == 1)
//			{
//			status = clickSaveAndExit();
//			Logger.writeDayLog(Logger.messageType.Exception, "Split all page validation is successfull");
//			waitForPageLoad();
//			}
//			else 
//			{
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Split all page validation is failed");
//		}
//		return status;
//}
//	public static Boolean deleteAllPageVaidation() throws Exception
//	{
//		Boolean status = false;
//		List<WebElement> pageList = NextstepFaxInbox.getEditPagesList();
//		List<WebElement> deleteList = NextstepFaxInbox.getAllPageDeleteButton();
//		int count = pageList.size();
//		try 
//		{
//			Actions action = new Actions(GlobalVariable.driver);
//			for (int i = 0; i < count; i++) 
//			{
//				WebElement firstPage = pageList.get(i);
//				action.moveToElement(firstPage).perform();
//				WebElement subElement = deleteList.get(i);
//				action.moveToElement(subElement);
//				action.click();
//				action.perform();
//			}
//			List<WebElement> deleteLabelList = NextstepFaxInbox.getEditPagesDeleteLabel();
//			if(count - deleteLabelList.size() == 1)
//			{
//			status = clickSaveAndExit();
//			Logger.writeDayLog(Logger.messageType.Pass, "Delete all pages validation is successfull");
//			waitForGridLoad();
//			}
//			else 
//			{
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Delete all page validation is failed");
//		}
//		return status;
//}
//	public static Boolean clickStatusChangeOkButton() throws Exception 
//	{
//		Boolean status = false; 
//		WebElement temp = NextstepFaxInbox.getStatusChangeOkButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(temp)) 
//			{
//				SeleniumHelper.click(temp);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, " pop ok clicked successfull");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click ok button");
//		}
//		return status;
//	}
//	public static Boolean singleClickFaxInGrid(int i) throws Exception
//	{
//		Boolean status=false;		
//		List<WebElement> firstFolder = NextstepFaxInbox.getFaxInboxGriddRows();
//		try
//		{
//			if(firstFolder.size()>1)
//			{
//				if(SeleniumHelper.isExist(firstFolder.get(i)))
//				{				
//					documentID = getDocumentIDWithIndex(i);
//					SeleniumHelper.click( firstFolder.get(i));
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "click on selected fax Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//			else
//			{
//				SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//				FaxInbox.waitForPageLoad();				
//				Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//				List<WebElement>folder = NextstepFaxInbox.getFaxInboxGriddRows();
//				if(SeleniumHelper.isExist(folder.get(i)))
//				{				
//					documentID = getDocumentIDWithIndex(0);
//					SeleniumHelper.contextClick( folder.get(i));
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Context click on selected fax Sucessfully");
//				}
//				else
//				{
//					status = false;
//					throw new Exception();
//				}
//			}
//		}
//		catch(Exception e) 
//		{
//			status = false;
//			int j;
//			Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//		}
//		return status;
//	}
//	public static Boolean clickSharedQueueDeleteFolder() throws Exception
//	{
//		Boolean status=false;
//		WebElement deletedItems = NextstepFaxInbox.getSharedQueueDeleteFolder();
//		try
//		{
//			if(SeleniumHelper.isExist(deletedItems))
//			{				
//				SeleniumHelper.click(deletedItems);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Delete folder is Clicked Sucessfully");
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
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to click delete");
//		}
//		return status;
//	}
//public static Boolean clickSharedQueueArchiveFolder() throws Exception
//{
//	Boolean status=false;		
//	WebElement archiveItems = NextstepFaxInbox.getSharedQueueArchiveFolder();
//	try
//	{
//		if(SeleniumHelper.isExist(archiveItems))
//		{				
//			SeleniumHelper.click(archiveItems);
//			Thread.sleep(1000);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Archive folder is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click delete");
//	}
//	return status;
//}
//public static Boolean selectParentFirstFolderToMove() throws Exception
//{
//	Boolean status=false;		
//	WebElement firstFolder = NextstepFaxInbox.getParentFirstFolderToMove();
//	try
//	{
//		if(SeleniumHelper.isExist(firstFolder))
//		{				
//			SeleniumHelper.click(firstFolder);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "first folder is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click first folder");
//	}
//	return status;
//}
//public static Boolean validateAdvanceSearchResultPage(int column) throws Exception 
//{
//	Boolean status = false;
//	List<WebElement> folderName = NextstepFaxInbox.getAdvanceSearchFolderNameColumn(column);
//	try 
//	{
//		if(folderName.size() > 0)
//		{	
//		for (int i = 0; i < folderName.size(); i++) 
//		{
//			String name = folderName.get(i).getText();			
//			if (name.equals("My Personal Folder") || name.equals(GlobalVariable.queueName) || name.equals("2")|| name.equals("Complete") || name.equals("Inbox") || name.equals(UserInput.FaxNumber) || name.equals(UserInput.FaxNumber)) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Advance search validation is successful");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//		}
//		else
//		{
//			if(NextstepFaxInbox.getAdvanceSearchNoRecordsReturned().getText().contains("No Record(s) Returned"))
//			{
//			 status = true;
//			 Logger.writeDayLog(Logger.messageType.Pass, "Advance search validation is successful");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//			
//		}
//	}
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Advace search validation failed");
//	}
//	return status;
//}
//public static Boolean clickAdvanceSearchDateToggleButton() throws Exception
//{
//	Boolean status=false;		
//	WebElement toggle = NextstepFaxInbox.getAdvanceSearchDateToggleButton();
//	try
//	{
//		if(SeleniumHelper.isExist(toggle))
//		{				
//			SeleniumHelper.click( toggle);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Toggle is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click toggle button");
//	}
//	return status;
//}
//public static Boolean clickAdvanceSearchClearSearch() throws Exception
//{
//	Boolean status=false;		
//	WebElement clear = NextstepFaxInbox.getAdvanceSearchClearSearch();
//	try
//	{
//		if(SeleniumHelper.isExist(clear))
//		{				
//			SeleniumHelper.click( clear);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "clear search is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click clear search button");
//	}
//	return status;
//}
//public static Boolean enterAdvanceSearchSearchBox(String name) throws Exception
//{
//	Boolean status=false;		
//	WebElement value = NextstepFaxInbox.getAdvanceSearchSearchBox();
//	try
//	{
//		if(SeleniumHelper.isExist(value))
//		{				
//			SeleniumHelper.setText(value, name);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Serach keyword is entered successfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter search textbox");
//	}
//	return status;
//}
//public static Boolean clickAdvanceSearchFilterSharedQueueWithIndex(int index) throws Exception 
//{
//	Boolean status = false;
//	if(UserInput.queueFlag==true)
//	{
//		WebElement queueName = NextstepFaxInbox.getAdvanceSearchShareQueueFilterWithIndex(index);
//		try 
//		{
//			if (SeleniumHelper.isExist(queueName)) 
//			{
//				GlobalVariable.queueName = queueName.getText();
//				SeleniumHelper.click( queueName);
//				Logger.writeDayLog(Logger.messageType.Pass, "Search Filter is successfully");
//				status = true;
//			}
//		} 
//		catch (Exception e) 
//		{
//			Logger.writeDayLog(Logger.messageType.Exception, "Search filter is not selected successfully");
//			status = false;
//		}
//	}
//	else
//	{
//		status = true;
//	}		
//	return status;
//}
//
//public static Boolean selectAdvanceSearchSharedQueueHeader() throws Exception
//{
//	Boolean status=false;	
//	WebElement sq = NextstepFaxInbox.getAdvanceSearchSharedQueueHeader();
//	try
//	{
//		if(SeleniumHelper.isExist(sq))
//		{				
//			SeleniumHelper.click(sq);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Shared Queue header is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to ckick shared queue header");
//	}
//	return status;
//}
//public static Boolean selectAdvanceSearchSharedQueueFolder() throws Exception
//{
//	Boolean status=false;		
//	WebElement sq = NextstepFaxInbox.getAdvanceSearchSharedQueueFolder();
//	try
//	{
//		if(SeleniumHelper.isExist(sq))
//		{				
//			SeleniumHelper.click(sq);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Shared Queue folder is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to ckick shared queue folder");
//	}
//	return status;
//}
//public static Boolean clickAdvanceSearchArchive() throws Exception
//{
//	Boolean status=false;		
//	WebElement archive = NextstepFaxInbox.getAdvanceSearchArchive();
//	try
//	{
//		if(SeleniumHelper.isExist(archive))
//		{				
//			SeleniumHelper.click( archive);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Archive is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click archive");
//	}
//	return status;
//}
//public static Boolean validateAdvanceSearchDocumentPermissionandConfirm() throws Exception
//{
//	Boolean status=false;		
//	WebElement permission = NextstepFaxInbox.getAdvanceSearchDocumentPermission();
//	WebElement archive = NextstepFaxInbox.getMoveCopyPopupconfirmButton();
//	WebElement cancel = NextstepFaxInbox.getCopyMovePopUpClose();
//	try
//	{
//		if(SeleniumHelper.isExist(permission)&&permission.getText().equals("granted"))
//		{				
//			status = true;
//			SeleniumHelper.click(archive);
//			waitForGridLoad();
//			Logger.writeDayLog(Logger.messageType.Pass, "Archived is Clicked Sucessfully");
//		}
//		else if(SeleniumHelper.isExist(cancel))
//		{
//			SeleniumHelper.click(cancel);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Permission is not granted so cancel is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click archive button");
//	}
//	return status;
//}
//public static Boolean clickMergeCartCancelButton() throws Exception
//{
//    Boolean status = false;
//    WebElement cancel = NextstepFaxInbox.getMergeCartCancelButton();
//    try
//    {
//        if (SeleniumHelper.isExist(cancel))
//        {
//            SeleniumHelper.click(cancel);
//            status = true;
//            Logger.writeDayLog(Logger.messageType.Pass, "Merge cancel is cliced successfully");
//        }
//        else
//        {
//            status = false;
//            throw new Exception();
//        }
//    }
//    catch (Exception e)
//    {
//        status = false;
//        Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Merge cancel");
//    }
//    return status;
//}
//public static Boolean clickOrganizationHeader() throws Exception
//{
//	Boolean status=false;
//	Thread.sleep(2000);
//	WebElement organization = NextstepFaxInbox.getOrganizationMoveCopyWindow();
//	try
//	{
//		if(SeleniumHelper.isExist(organization))
//		{				
//			SeleniumHelper.click( organization);	
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "organization header is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click organization header");
//	}
//	return status;
//}
//public static Boolean selectOrganization() throws Exception
//{
//	Boolean status=false;
//	Thread.sleep(3000);
//	WebElement organization = NextstepFaxInbox.getOrganizationValue();
//	try
//	{
//		if(SeleniumHelper.isExist(organization))
//		{				
//			SeleniumHelper.click( organization);	
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "organization is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click organization");
//	}
//	return status;
//}
//public static Boolean selectOrganizationMove() throws Exception
//{
//	Boolean status=false;
//	Thread.sleep(4000);
//	WebElement organization = NextstepFaxInbox.getOrganizationValueMove();
//	try
//	{
//		if(SeleniumHelper.isExist(organization))
//		{				
//			SeleniumHelper.click(organization);	
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "organization is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click organization");
//	}
//	return status;
//}
//public static Boolean validateMarkasReadUnread() throws Exception 
//{
//	Boolean status = false;
//	WebElement event1 = NextstepFaxInbox.getFirstTimelineEvent();
//	String timelineevent1 = event1.getText();
//	try 
//	{
//		if (timelineevent1.contains("marked unread this document")) 
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "marked unread this document validation is successfull");
//		}
//		else if(timelineevent1.contains("marked read this document"))
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "marked read this document validation is successfull");
//			System.out.println("Mark as read is success");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Multiple copy validation is failed");
//	}
//	return status;
//}
//public static Boolean validateMergeCartNumber() throws Exception
//{
//    Boolean status=false;
//    WebElement cartNumber = NextstepFaxInbox.getMergeCartNumber();
//    String description = cartNumber.getText();
//    try
//    {
//        if(description.equals("2"))
//        {               
//            status = true;
//            Logger.writeDayLog(Logger.messageType.Pass, "Merge cart number verified successfully");
//            System.out.println("Merge cart number verified successfully\"");
//        }
//        else if(description.equals("1"))
//        {               
//            status = true;
//            Logger.writeDayLog(Logger.messageType.Pass, "Merge cart number verified successfully");
//            System.out.println("Merge cart number verified successfully\"");
//        }
//        else
//        {
//            status = false;
//            throw new Exception();
//        }
//    }
//    catch(Exception e)
//    {
//        status = false;
//        Logger.writeDayLog(Logger.messageType.Exception, "Merge cart number is not verified");
//    }
//    return status;       
//}
//public static Boolean clickNavigateNextPage() throws Exception
//{
//	Boolean status=false;		
//	WebElement next = NextstepFaxInbox.getNavigateNextPage();
//	try
//	{
//		if(SeleniumHelper.isExist(next))
//		{				
//			SeleniumHelper.click(next);
//			waitForPageLoad();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Next page is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Next page");
//	}
//	return status;
//}
//public static Boolean contextClickMarkAsRead(int i) throws Exception
//{
//	Boolean status=false;		
//	List<WebElement> docList = NextstepFaxInbox.getDocumentListbyMarkAsRead();
//	try
//	{
//		if(docList.size()>1)
//		{
//			if(SeleniumHelper.isExist(docList.get(i)))
//			{				
//				documentID = getDocumentIDWithIndexForMarkAsRead(i);
//				SeleniumHelper.contextClick(docList.get(i));
//				Thread.sleep(1000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Context click on unread fax Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		else
//		{
//			SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//			FaxInbox.waitForPageLoad();				
//			Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//			List<WebElement>list = NextstepFaxInbox.getDocumentListbyMarkAsRead();
//			if(SeleniumHelper.isExist(list.get(i)))
//			{				
//				documentID = getDocumentIDWithIndex(i);
//				SeleniumHelper.contextClick( list.get(i));
//				Thread.sleep(1000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Context click on unread fax Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	}
//	return status;
//}
//public static Boolean contextClickLastDocument() throws Exception
//{
//	Boolean status = false;
//	String[] temp = new String[getDocumentID().length];
//	temp = getDocumentID();
//	try
//	{
//		for(int i=0;i<temp.length; i++)
//		{
//			if(documentID.equals(temp[i]))
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Document Found");
//				System.out.println("Document is found");
//				status = true; 
//				break;
//			}
//		}
//	}
//	catch(Exception e)
//	{
//		Logger.writeDayLog(Logger.messageType.Exception, "Document not Found");
//		status = false;
//	}		
//	return status;		
//}
//public static Boolean ContextClickLastSelectedDocument() throws Exception
//{		
//	Boolean status = false;
//	WebElement temp = null;
//	List<WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();
//	String[] rowValue = new String[rows.size()];
//	try
//	{
//		for(int i = 0; i<rows.size(); i++)
//		{
//			temp = rows.get(i);
//			rowValue[i] = temp.getAttribute("data-automation-id");
//			if(rowValue[i].equals(documentID))
//			{
//				SeleniumHelper.contextClick(temp);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document ID(s) are found");
//				break;
//			}
//		}			
//	}
//	catch(Exception e)
//	{			
//		Logger.writeDayLog(Logger.messageType.Exception, "Document ID(s) are  not found");
//	}
//	return status;
//}
//public static String getDocumentIDWithIndexForMarkAsRead(int index) throws Exception
//{
//	String value = null;;
//	WebElement temp = null;
//	List<WebElement> rows = NextstepFaxInbox.getDocumentListbyMarkAsRead();		
//	try
//	{					
//		temp = rows.get(index);
//		value = temp.getAttribute("data-automation-id");
//		Logger.writeDayLog(Logger.messageType.Pass, "Document ID for given index is found");
//	}				
//	catch(Exception e)
//	{
//		Logger.writeDayLog(Logger.messageType.Exception, "Document ID is not found");
//	}
//	return value;
//}
//public static Boolean validateDocumentViewer() throws Exception
//{
//	Boolean status=false;		
//	WebElement viewer = NextstepFaxInbox.getFaxViewerDocumentArea();
//	try
//	{
//		if(SeleniumHelper.isExist(viewer))
//		{				
//			SeleniumHelper.isDisplayed(viewer);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Viewer page is loaded Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Viewer is not loaded");
//	}
//	return status;
//}
//public static Boolean validateGridRow() throws Exception
//{
//	Boolean status=false;		
//	List<WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();
//	try
//	{
//		if(SeleniumHelper.isExist(rows.get(1)))
//		{
//			if(SeleniumHelper.isDisplayed(rows.get(1)))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Grid is loaded Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Grid  is not loaded");
//	}
//	return status;
//}
//public static Boolean MultiplePagesRotatioPreconditionCheck() throws Exception 
//{
//	Boolean status = false;
//	WebElement editedStatus = NextstepFaxInbox.getEditedStatus();
//	String edited = editedStatus.getText();
//	try 
//	{
//		if (edited.contains("False")) 
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Docucment is not edited so can proceed with rotation");
//			clickRotateRightButton();
//			clickNavigateNextPage();
//			clickRotateRightButton();
//			clickSaveButton();
//			waitForPageLoad();
//			clickViewerTimeline();
//			waitForPageLoad();
//			validateRotation();
//			clickLogout();
//			killDriver();
//		}
//		else if(edited.contains("True"))
//		{
//			status = true;
//			clickLogoutValidation();
//			killDriver();
//			Logger.writeDayLog(Logger.messageType.Pass, "Docucment is edited so cannot save rotation");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Rotation is failed");
//	}
//	return true;
//}
//public static Boolean contextClickOutboundDocument(int i) throws Exception
//{
//	Boolean status=false;		
//	List<WebElement> docList = NextstepFaxInbox.getAllInboundOutboundDocuments();
//	try
//	{
//		if(docList.size()>1)
//		{
//			if(SeleniumHelper.isExist(docList.get(i)))
//			{				
//				documentID = getDocumentIDWithIndexForMarkAsRead(i);
//				SeleniumHelper.contextClick(docList.get(i));
//				Thread.sleep(1000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Context click on Outbound fax Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		else
//		{
//			SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//			FaxInbox.waitForPageLoad();				
//			Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//			List<WebElement>list = NextstepFaxInbox.getAllInboundOutboundDocuments();
//			if(SeleniumHelper.isExist(list.get(i)))
//			{				
//				documentID = getDocumentIDWithIndex(i);
//				SeleniumHelper.contextClick( list.get(i));
//				Thread.sleep(1000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Context click on Outbound fax Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	}
//	return status;
//}
//public static int getDocumentsCount() throws Exception 
//{	
//	int finalValue= -1;
//	WebElement gridcount = NextstepFaxInbox.getGridCount();
//	try
//	{
//		if(SeleniumHelper.isExist(gridcount)) 
//		{
//			String faxcount=gridcount.getText();
//			String count=faxcount.substring(8,10);
//			System.out.println(count);
//			double temp = Double.parseDouble(count);
//			System.out.println(temp);
//			finalValue = (int) temp;
//			Logger.writeDayLog(Logger.messageType.Pass, "Document count is updated successfully");
//		}
//		else
//		{				
//			throw new Exception();
//		}			
//	}
//	catch(Exception e) 
//	{			
//		Logger.writeDayLog(Logger.messageType.Exception, " Document count is not updated");
//		return finalValue;
//	}
//	return finalValue;
//}
//public static Boolean PaginationValidation() throws Exception 
//{
//	Boolean status = false;
//	GlobalVariable.beforesourcefoldercount=FaxInbox.getDocumentsCount();
//	try
//	{
//		if(GlobalVariable.beforesourcefoldercount==51)
//        {
//            Logger.writeDayLog(Logger.messageType.Pass, "Pagination validation successful");
//            status = true;
//        }
//        else
//        {    
//        	status = false;
//            throw new Exception();
//        }           
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Pagination Validation is failed");
//	}
//	return status;
//}
//public static Boolean validateMoveCopyToSameFolder() throws Exception
//{
//	Boolean status=false;
//	WebElement warning = NextstepFaxInbox.getCopyMoveToSameFolderValidationMessage();
//	String message=warning.getText();
//	WebElement ok = NextstepFaxInbox.getWatermarkPopupOkButton();
//	try
//	{
//		if((message.contains("The destination folder is the same as the source folder")))
//		{				
//			status = true;
//			ok.click();
//			Logger.writeDayLog(Logger.messageType.Pass, "Copy/Move to same folder validation Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Copy/Move to same folder validation Sucessfully");
//	}
//	return status;
//}
//public static Boolean validateDocumentPermananentDelete() throws Exception
//{
//	Boolean status = false;
//	String[] temp = new String[getDocumentID().length];
//	temp = getDocumentID();
//	try
//	{
//		for(int i=0;i<temp.length; i++)
//		{
//			if(documentID != temp[i])
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Document delete validated successfully");
//				//System.out.println("Document delete validated successfully");
//				status = true; 
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "Document delete validation failed");
//			}
//		}
//	}
//	catch(Exception e)
//	{
//		Logger.writeDayLog(Logger.messageType.Exception, "Document delete validation failed");
//		status = false;
//	}		
//	return status;		
//}
//public static Boolean clickAdvanceSearchDateRangeDropDown() throws Exception
//{
//    Boolean status = false;
//    WebElement date = NextstepFaxInbox.getAdvanceSearchDateRangeDropDown();
//    try
//    {           
//        if(SeleniumHelper.isExist(date))
//        {
//            SeleniumHelper.click(date);
//            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch date range dropdownm is clicked successfully");
//            status = true;
//        }
//        else
//        {               
//            throw new Exception();
//        }	       
//    }
//    catch(Exception e)
//    {   
//        status = false;       
//        Logger.writeDayLog(Logger.messageType.Exception, "unable to click Advance search date range dropdown");	     
//    }
//    return status;               
//}
//public static Boolean clickAdvanceSearchDateRangeCLear() throws Exception
//{
//    Boolean status = false;
//    WebElement clear = NextstepFaxInbox.getAdvanceSearchDateClear();
//    try
//    {           
//        if(SeleniumHelper.isExist(clear))
//        {
//            SeleniumHelper.click(clear);
//            Logger.writeDayLog(Logger.messageType.Pass, "AdvanceSearch date range clear is clicked successfully");
//            status = true;
//        }
//        else
//        {               
//            throw new Exception();
//        }	       
//    }
//    catch(Exception e)
//    {  
//        status = false;       
//        Logger.writeDayLog(Logger.messageType.Exception, "unable to select Advance search date range clear");	     
//    }
//    return status;               
//}
//public static Boolean validateViewerMergeCartNumber() throws Exception
//{
//    Boolean status=false;
//    WebElement cartNumber = NextstepFaxInbox.getViewerMergeCartNumber();
//    String description = cartNumber.getText();
//    try
//    {
//        if(description.equals("1"))
//        {               
//            status = true;
//            Logger.writeDayLog(Logger.messageType.Pass, "Merge cart number verified successfully for a single document");
//            System.out.println("Merge cart number verified successfully\"");
//        }
//        else if(description.equals("2"))
//        {               
//            status = true;
//            Logger.writeDayLog(Logger.messageType.Pass, "Merge cart number verified successfully for 2 documents");
//            System.out.println("Merge cart number verified successfully\"");
//        }
//        else if(description.equals("3"))
//        {               
//            status = true;
//            Logger.writeDayLog(Logger.messageType.Pass, "Merge cart number verified successfully for 3 documents");
//            System.out.println("Merge cart number verified successfully\"");
//        }
//        else
//        {
//            status = false;
//            throw new Exception();
//        }
//    }
//    catch(Exception e)
//    {
//        status = false;
//        Logger.writeDayLog(Logger.messageType.Exception, "Merge cart number is not verified");
//    }
//    return status;       
//}
//public static Boolean selectContactAddressbook() throws Exception
//{
//	Boolean status=false;		
//	List<WebElement> firstOption = NextstepFaxInbox.getAllContactsAddressBook();
//	try
//	{
//		if(firstOption.size()>0)
//		{
//			if(SeleniumHelper.isExist(firstOption.get(0)))
//			{				
//				SeleniumHelper.click(firstOption.get(0));					
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Selected contact");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Document Type value");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	}
//	return status;
//}
//public static Boolean clickGridPageHeader(int value) throws Exception
//{
//    Boolean status = false;
//    WebElement pages = NextstepFaxInbox.getGridPageHeader(value);
//    try
//    {           
//        if(SeleniumHelper.isExist(pages))
//        {
//            SeleniumHelper.click(pages);
//            Logger.writeDayLog(Logger.messageType.Pass, "clickGridPagesHeader is clicked successfully");
//            status = true;
//        }
//        else
//        {               
//            throw new Exception();
//        }	       
//    }
//    catch(Exception e)
//    {  
//        status = false;       
//        Logger.writeDayLog(Logger.messageType.Exception, "unable to click clickGridPagesHeader");	     
//    }
//    return status;               
//}
//public static Boolean validatePagesSort(int column) throws Exception 
//{
//	Boolean status = false;
//	int oldValue = 0;
//	List<WebElement> pages = NextstepFaxInbox.getAdvanceSearchFolderNameColumn(column);
//	try 
//	{
//		for (int i = 0; i < pages.size(); i++) 
//		{
//			String currentValue = pages.get(i).getText();
//			int curValue=Integer.parseInt(currentValue);  
//			if (curValue >= oldValue) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "sort by page is validated successfully");
//				oldValue = curValue;
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "Pages sort validation is failed");
//			}
//		} 
//	}
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Pages sort validation is failed");
//	}
//	return status;
//}
//public static Boolean validateDirectionSort() throws Exception 
//{
//	Boolean status = false;
//	List<WebElement> pages = NextstepFaxInbox.getGridDirection();
//	try 
//	{
//		for (int i = 0; i < pages.size(); i++) 
//		{
//			String direction = pages.get(i).getAttribute("class");
//			if (direction.contains("inbound")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "sort by direction is validated successfully");
//			}
//			else if (direction.contains("outbound"))
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "sort by direction is validated successfully");
//			}
//			else if (direction.contains("upload"))
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "sort by direction is validated successfully");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, "direction sort validation is failed");
//			}
//		} 
//	}
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "direction sort validation is failed");
//	}
//	return status;
//}
//public static Boolean clickUploadSignatureButton() throws Exception 
//{
//	Boolean status = false;
//	WebElement sign = NextstepFaxInbox.getImageSignatureUploadButton();
//	try 
//	{
//		if (SeleniumHelper.isExist(sign)) 
//		{
//			SeleniumHelper.click( sign);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Image sign upload button is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click image sign upload button");
//	}
//	return status;
//}
//public static Boolean clickImageSignatureButton() throws Exception 
//{
//	Boolean status = false;
//	WebElement sign = NextstepFaxInbox.getImageSignatureButton();
//	try 
//	{
//		if (SeleniumHelper.isExist(sign)) 
//		{
//			SeleniumHelper.click( sign);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Image sign button is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click image sign button");
//	}
//	return status;
//}
//public static Boolean clickImageSignatureSave() throws Exception 
//{
//	Boolean status = false;
//	WebElement save = NextstepFaxInbox.getImageSignatureSave();
//	try 
//	{
//		if (SeleniumHelper.isExist(save)) 
//		{
//			SeleniumHelper.click( save);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Image save button is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click image sign save");
//	}
//	return status;
//}
//public static Boolean clickImageSignatureDeleteConfirmation() throws Exception 
//{
//	Boolean status = false;
//	WebElement delete = NextstepFaxInbox.getImageSignatureDeleteConfirmation();
//	try 
//	{
//		if (SeleniumHelper.isExist(delete)) 
//		{
//			SeleniumHelper.click( delete);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Image delete is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click image sign delete confirmation");
//	}
//	return status;
//}
//public static Boolean enterPrintPageRange(String value) throws Exception
//{
//	Boolean status = false;
//	WebElement faxNumberBox = NextstepFaxInbox.getPrintPageRange();
//	try
//	{
//		if(SeleniumHelper.setText(faxNumberBox, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as faxNumber");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in faxNumber");
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter faxNumber");
//	}			
//	return status;
//}
//public static Boolean selectPrintPaperSize() throws Exception 
//{
//	Boolean status = false;
//	WebElement size = NextstepFaxInbox.getPrintPaparSize();
//	try 
//	{
//		if (SeleniumHelper.isExist(size)) 
//		{
//			Select dropdown = new Select(size);
//			dropdown.selectByVisibleText("A3"); 
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Print paper size is selected");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click image sign button");
//	}
//	return status;
//}
//public static Boolean enterDownloadFileName() throws Exception
//{
//	Boolean status=false;
//	WebElement fileName = NextstepFaxInbox.getDownloadFileNameTextbox();
//	try
//	{
//		if(SeleniumHelper.isExist(fileName))
//		{
//			fileName.clear();
//			fileName.sendKeys("SampleDocument");
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "File Name is entered successfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter file namew");
//	}
//	return status;		
//}
//public static Boolean clickDownloadPageRangeCheckbox() throws Exception 
//{
//	Boolean status = false;
//	WebElement range = NextstepFaxInbox.getDownloadPageRange();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(range)) 
//		{
//			SeleniumHelper.click( range);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Download Pagerange checkbox is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Download Pagerange checkbox ");
//	}
//	return status;
//}
//public static Boolean enterDownloadPageRange() throws Exception
//{
//	Boolean status=false;
//	WebElement pageRange = NextstepFaxInbox.getDownloadPageRangeTextbox();
//	try
//	{
//		if(SeleniumHelper.isExist(pageRange))
//		{
//			pageRange.clear();
//			pageRange.sendKeys("1-2");
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "File Name is entered successfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter file namew");
//	}
//	return status;		
//}
//public static Boolean clickDownloadFormatDropDown() throws Exception 
//{
//	Boolean status = false;
//	WebElement format = NextstepFaxInbox.getDownloadPageFormatDropDown();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(format)) 
//		{
//			SeleniumHelper.click(format);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Download Page format dropdown is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Download Page format ");
//	}
//	return status;
//}
//public static Boolean clickDownloadFormatValue() throws Exception 
//{
//	Boolean status = false;
//	WebElement value = NextstepFaxInbox.getDownloadPageFormatValue();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(value)) 
//		{
//			SeleniumHelper.click(value);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Download Page format value is selected - tiff");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Download Page format value - tiff");
//	}
//	return status;
//}
//public static Boolean clickAddNewContact() throws Exception 
//{
//	Boolean status = false;
//	WebElement contact = NextstepFaxInbox.getAddressBookAddNewContact();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(contact)) 
//		{
//			SeleniumHelper.click(contact);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Add new contact is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click add new contact");
//	}
//	return status;
//}
//public static Boolean enterAddressBookFaxNumber(String value) throws Exception
//{
//	Boolean status = false;
//	WebElement faxNumberBox = NextstepFaxInbox.getAddressBookFaxNumberTextbox();
//	try
//	{
//		if(SeleniumHelper.setText(faxNumberBox, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as faxNumber");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in faxNumber");
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter faxNumber");
//	}			
//	return status;
//}
//public static Boolean enterAddressFirstName(String value) throws Exception
//{
//	Boolean status = false;
//	WebElement name = NextstepFaxInbox.getAddressBookFirstNameTextbox();
//	try
//	{
//		if(SeleniumHelper.setText(name, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as name");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in name");
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Pass, "Not able to enter name");
//	}			
//	return status;
//}
//public static Boolean clickAddressBookCreate() throws Exception 
//{
//	Boolean status = false;
//	WebElement create = NextstepFaxInbox.getAddressBookCreate();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(create)) 
//		{
//			SeleniumHelper.click(create);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "create new contact is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click create");
//	}
//	return status;
//}
//public static Boolean clickAddressBookBackToSendFax() throws Exception 
//{
//	Boolean status = false;
//	WebElement contact = NextstepFaxInbox.getAddressBookBackToSendFax();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(contact)) 
//		{
//			SeleniumHelper.click(contact);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Back to send fax is clicked successfully");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click back to send fax");
//	}
//	return status;
//}
//public static Boolean clickAddressBookDuplicateAlertOkButton() throws Exception 
//{
//	Boolean status = false;
//	WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 10);	
//	try 
//	{
//		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sweetAlertParent']/p")));
//		WebElement ok = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sweetAlertParent']/div[7]/div/button")));
//		if (message.getText().contains("already exists")) 
//		{
//			SeleniumHelper.click(ok);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Validation message ok button is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click ok button in duplicate contact message");
//	}
//	return status;
//}
//public static Boolean clickAddressBookCancel() throws Exception 
//{
//	Boolean status = false;
//	WebElement cancel = NextstepFaxInbox.getAddressBookCancelButton();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(cancel)) 
//		{
//			SeleniumHelper.click(cancel);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "cancel new contact is clicked");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click cancel");
//	}
//	return status;
//}
//public static Boolean clickLastMergedDocument() throws Exception
//{		
//	Boolean status = false;
//	WebElement temp = null;
//	List<WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();
//	String[] rowValue = new String[rows.size()];
//	try
//	{
//		for(int i = 0; i<rows.size(); i++)
//		{
//			temp = rows.get(i);
//			rowValue[i] = temp.getAttribute("data-automation-id");
//			if(rowValue[i].equals(mergeDocumentID))
//			{
//				SeleniumHelper.click(temp);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document ID(s) are found");
//				break;
//			}
//		}			
//	}
//	catch(Exception e)
//	{			
//		Logger.writeDayLog(Logger.messageType.Exception, "Document ID(s) are  not found");
//	}
//	return status;
//}
//public static Boolean validateDocumentMerge() throws Exception 
//{
//	Boolean status = false;
//	WebElement event1 = NextstepFaxInbox.getFirstTimelineEvent();
//	WebElement event2 = NextstepFaxInbox.getGridSecondTimelineEvent();
//	String timelineevent1 = event1.getText();
//	String timelineevent2 = event2.getText();
//	try 
//	{
//		if (timelineevent1.contains("merged this document") || timelineevent2.contains("merged this document"))
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "merge document validation is successfull");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Multiple document merge validation is failed");
//	}
//	return status;
//}
//public static Boolean splitandDeletePage() throws Exception
//{
//	Boolean status = false;
//	Thread.sleep(2000);
//	List<WebElement> pageList = NextstepFaxInbox.getEditPagesList();
//	WebElement firstPage = NextstepFaxInbox.getFirstPage();
//	WebElement secondPage = NextstepFaxInbox.getSecondPage();
//	int count =pageList.size();
//	try
//	{
//		if(pageList.size()<=2)
//		{
//			status=clickFaxViewerExit();	
//			waitForFaxLoad();
//			Logger.writeDayLog(Logger.messageType.Pass, "Fax having single page so skipped split");
//		}
//		else
//		{
//			Actions action = new Actions(GlobalVariable.driver);				 
//	        action.moveToElement(secondPage).perform();		 
//	        WebElement subElement = NextstepFaxInbox.getSecondPageMoveButton();		 
//	        action.moveToElement(subElement);		 
//	        action.click();		 
//	        action.perform();
//	        Actions actions = new Actions(GlobalVariable.driver);
//	        actions.moveToElement(firstPage).perform();		 
//	        WebElement delete = NextstepFaxInbox.getfirstPageDeleteButton();		 
//	        actions.moveToElement(delete);		 
//	        actions.click();		 
//	        actions.perform();
//	        status = clickSaveAndExit();	
//	        waitForPageLoad();
//	        FaxInbox.openLastEditedDocument();
//	        waitForPageLoad();
//	        WebElement pageCount = NextstepFaxInbox.getViewetPagesCount();
//	        String number = pageCount.getText();
//	    	String[] parts = number.split(" ");
//	    	String part1 = parts[0];
//	        int afterpagecount=Integer.parseInt(part1);		        
//	        if(afterpagecount == (count-2))
//	        {
//	        	Logger.writeDayLog(Logger.messageType.Pass, "split page and delete page in a document validation is sucessfull");
//	        	status =true;
//	        	System.out.println("split page and delete page in a document validation is sucessfull");
//	        }		        
//		}
//	}
//	catch(Exception e)
//	{
//		status=false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Failed to split and delete a page in document");
//	}		
//	return status;
//}
//public static Boolean selectDocumentWithMorethanTwoPages() throws Exception 
//{
//	Boolean status = false;
//	List<WebElement> pages = NextstepFaxInbox.getPages();
//	try 
//	{
//		for (int i = 0; i <= pages.size(); i++) 
//		{
//			String pagenumber = pages.get(i).getText();
//			int j = Integer.parseInt(pagenumber);
//			if (j > 2) 
//			{
//				WebElement test = pages.get(i);
//				if (SeleniumHelper.isExist(test)) 
//				{
//					documentID = getDocumentIDWithIndex(i);
//					SeleniumHelper.click( test);
//					status = true;
//					break;
//				}
//			}
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "No record available with more than one page");
//	}
//	return status;
//}
//public static Boolean selectDocumentWithDocumentType() throws Exception 
//{
//	Boolean status = false;
//	List<WebElement> type = NextstepFaxInbox.getDocumentType();
//	try 
//	{
//		for (int i = 0; i <= type.size(); i++) 
//		{
//			String pagenumber = type.get(i).getText();
//			if (pagenumber.contains("a") || pagenumber.contains("e")) 
//			{
//				WebElement test = type.get(i);
//				if (SeleniumHelper.isExist(test)) 
//				{
//					documentID = getDocumentIDWithIndex(i);
//					SeleniumHelper.click( test);
//					status = true;
//					break;
//				}
//			}
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "No record available with more than one page");
//	}
//	return status;
//}
//public static Boolean clickClassificationProceedButton() throws Exception
//{
//	Boolean status=false;
//	Thread.sleep(1000);
//	WebElement proceed = NextstepFaxInbox.getDocumentClassificationSaveProceedButton();
//	try
//	{
//		if(SeleniumHelper.isExist(proceed))
//		{				
//			SeleniumHelper.click( proceed);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Classification Procees is Clicked Sucessfully");
//
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//
//		Logger.writeDayLog(Logger.messageType.Exception, "Classification Procees is not clicked");
//	}
//	return status;		
//}
//public static Boolean clickPreview() throws Exception 
//{
//	Boolean status = false;
//	WebElement maximize = NextstepFaxInbox.maximizeThumbnail();
//	try 
//	{
//		if (SeleniumHelper.isExist(maximize)) 
//		{
//			SeleniumHelper.click(maximize);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Thumbnail preview is maximized");
//		}
//	
//		else
//		{
//			status = true;
//			 throw new Exception();
//		}
//	}
//		catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Thumbnail preview is not maximized");
//	}
//	return status;
//}
//	
//	public static Boolean closePreview() throws Exception 
//	{
//		Boolean status = false;
//		WebElement closeicon = NextstepFaxInbox.closePreviewWindow();
//		try 
//		{
//			if (SeleniumHelper.isExist(closeicon)) 
//			{
//				SeleniumHelper.click(closeicon);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Thumbnail preview is closed");
//			}
//		
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Thumbnail preview is not closed");
//		}
//		return status;
//}
//
//	public static Boolean gotoDocviewer() throws Exception 
//	{
//		Boolean status = false;
//		WebElement viewericon = NextstepFaxInbox.Editinviewer();
//		try 
//		{
//			if (SeleniumHelper.isExist(viewericon)) 
//			{
//				SeleniumHelper.click(viewericon);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document viewer is opened");
//			}
//		
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Document viewer is not opened");
//		}
//		return status;
//}
//	
//	public static Boolean nextbuttonThumbnail() throws Exception 
//	{
//		Boolean status = false;
//		WebElement nextimage = NextstepFaxInbox.nextthumbnail();
//		try 
//		{
//			if (SeleniumHelper.isExist(nextimage)) 
//			{
//				SeleniumHelper.click(nextimage);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Next Thumbnail image is loaded");
//			}
//		
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Next Thumbnail image is not loaded");
//		}
//		return status;
//}
//
//	public static Boolean previousbuttonThumbnail() throws Exception 
//	{
//		Boolean status = false;
//		WebElement previousimage = NextstepFaxInbox.previousthumbnail();
//		try 
//		{
//			if (SeleniumHelper.isExist(previousimage)) 
//			{
//				SeleniumHelper.click(previousimage);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Next Thumbnail image is loaded");
//			}
//		
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Next Thumbnail image is not loaded");
//		}
//		return status;
//}
//	
//	public static Boolean okButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement ok = NextstepFaxInbox.dupicateFolder();
//		try 
//		{
//			if (SeleniumHelper.isExist(ok)) 
//			{
//				SeleniumHelper.click(ok);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Duplicate folder not created");
//			}
//		
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Warning message is not shown");
//		}
//		return status;
//}
//	public static Boolean validateSendwithoutEmail() throws Exception 
//	{
//		Boolean status = false;
//		WebElement ok = NextstepFaxInbox.reuiredMessage();
//		String validate=ok.getText();
//		//String message="Required";
//		try 
//		{
//			if (validate.equalsIgnoreCase("Required")) 
//			{
//				SeleniumHelper.click(ok);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Validation passed");
//				System.out.println("Validation passed for TCF_175");
//			}
//		
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Validation element not found");
//		}
//		return status;
//}
//	
//	public static Boolean printwithPagenumber(String value) throws Exception
//	{
//		Boolean status = false;
//		Thread.sleep(2000);
//		WebElement Pagetext = NextstepFaxInbox.pageNumber();		
//		try
//		{
//			while(!(Pagetext.isDisplayed()))
//			{
//				Thread.sleep(1000);
//			}
//			if(SeleniumHelper.setText(Pagetext, value))
//			{				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, value + "printed with selected page number");
//			}
//			else
//			{
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Fail, value + " Not printed with selected page number");
//			}
//		}
//		catch(Exception e)
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Pass, "Not able to print with selected page number");
//		}			
//		return status;
//	}
//	
//	public static Boolean printButton() throws Exception 
//	{
//		Boolean status = false;
//		WebElement printPages = NextstepFaxInbox.getPrintButton();
//		try 
//		{
//			if (SeleniumHelper.isExist(printPages)) 
//			{
//				SeleniumHelper.click(printPages);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Print clicked");
//				System.out.println("Printed with 2nd and 3rd page");
//			}
//		
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Print button is not clicked");
//		}
//		return status;
//}
//	
//	public static Boolean clickViewerPagination() throws Exception 
//	{
//		Boolean status = false;
//		WebElement Nextpage = NextstepFaxInbox.paginationViewer();
//		try 
//		{
//			if (SeleniumHelper.isExist(Nextpage)) 
//			{
//				SeleniumHelper.click(Nextpage);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Pagination clicked");
//			}
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Pagination is not clicked");
//		}
//		return status;
//}
//	public static Boolean firstPage() throws Exception 
//	{
//		Boolean status = false;
//		WebElement previouspage = NextstepFaxInbox.previousPage();
//		try 
//		{
//			if (SeleniumHelper.isExist(previouspage)) 
//			{
//				SeleniumHelper.click(previouspage);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Previous pagination clicked");
//			}
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Previous pagination is not clicked");
//		}
//		return status;
//}
//	public static Boolean rotateAllpages() throws Exception 
//	{
//		Boolean status = false;
//		WebElement rotated = NextstepFaxInbox.rotateAll();
//		try 
//		{
//			if (SeleniumHelper.isExist(rotated)) 
//			{
//				SeleniumHelper.click(rotated);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Rotate all pages clicked");
//			}
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Rotate all pages is not clicked");
//		}
//		return status;
//}
//	public static Boolean clickDropdown() throws Exception 
//	{
//		Boolean status = false;
//		WebElement dropdown = NextstepFaxInbox.clicked();
//		try 
//		{
//			if (SeleniumHelper.isExist(dropdown)) 
//			{
//				SeleniumHelper.click(dropdown);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Dropdown clicked");
//			}
//		else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Dropdown is not clicked");
//		}
//		return status;
//}	
//	public static Boolean clearDocumentStatus() throws Exception 
//	{
//		Boolean status = false;
//		WebElement clear = NextstepFaxInbox.documentClearStatus();
//		try 
//		{
//			if (SeleniumHelper.isExist(clear)) 
//			{
//				SeleniumHelper.click(clear);
//				
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Clear Document status clicked");
//				}
//			else
//			{
//				status = true;
//				 throw new Exception();
//			}
//		}
//			catch (Exception e) 
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Clear Document status is not clicked");
//		}
//		return status;
//}	
//	
//	public static Boolean splitaPage() throws Exception 
//	{
//		Boolean status = false;
//		List<WebElement> pageList = NextstepFaxInbox.getEditPagesList();
//		WebElement firstPage = NextstepFaxInbox.getFirstPage();
//		int count =pageList.size();
//		try
//		{
//		   Actions action = new Actions(GlobalVariable.driver);				 
//           action.moveToElement(firstPage).perform();		 
//           WebElement subElement = NextstepFaxInbox.getFirstPageMoveButton();		 
//           action.moveToElement(subElement);		 
//           action.click();		 
//           action.perform();
//           Logger.writeDayLog(Logger.messageType.Exception, "Thumbnail is clicked");
//           status=true;
//		}
//		catch (Exception e) 
//	{
//		   status = false;
//		   Logger.writeDayLog(Logger.messageType.Exception, "Thumbnail is not clicked");
//	}
//	return status;
//
//}
//public static Boolean editpageCancelButton() throws Exception 
//{
//	Boolean status = false;
//	WebElement cancel = NextstepFaxInbox.editPageCancel();
//	try 
//	{
//		if (SeleniumHelper.isExist(cancel)) 
//		{
//			SeleniumHelper.click(cancel);
//			
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Cancel button is clicked");	
//		}
//		else
//		{
//			status = true;
//			 throw new Exception();
//		}
//	}
//		catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Cancel button is not clicked");
//	}
//	return status;
//}	
//public static Boolean validatepagecount() throws Exception 
//{
//	Boolean status = false;
//	
//	try 
//	{
//		if (GlobalVariable.sourceFaxPageCount==GlobalVariable.thumbnailcount)
//		{
//			System.out.println("Pagecount is same, testcase passed");
//			status=true;
//		}
//		else {
//			status=false;
//			throw new Exception();
//		}
//	}
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "pagecount is not same");
//	}
//	return status;	
//}
//public static Boolean clickDefaultviewButton() throws Exception 
//{
//	Boolean status = false;
//	WebElement togglebutton = NextstepFaxInbox.defaultview();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(togglebutton))
//		{
//			SeleniumHelper.click(togglebutton);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Default view toggle button is clicked");
//			}
//		else
//		{
//			status = true;
//			throw new Exception();
//		}
//	}
//		catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Default view toggle button is not clicked");
//	}
//	return status;
//}	
//
//public static Boolean duplicateFoldermessage() throws Exception 
//{
//	Boolean status = false;
//	WebElement warningMessage = NextstepFaxInbox.getMessage();
//	String message=warningMessage.getText();
//	String message1="A folder with this name already exists.";
//	try 
//	{
//		if (message.contentEquals(message1))
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Dupliate folder not created");
//			System.out.println("validated");
//		}
//	
//		else
//		{
//			status = true;
//			 throw new Exception();
//		}
//	}
//		catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Folder name with Inbox doesnot exist, Please create and execute");
//	}
//	return status;
//}	
//public static Boolean enterSSOUserNameAndClickNext(String value) throws Exception
//{
//	Boolean status = false;
//	WebElement userNameBox = NextstepFaxInbox.getSSOUserNameInputBox();
//	WebElement next = NextstepFaxInbox.getSSOLoginNextButton();
//	try
//	{
//		while(!(userNameBox.isDisplayed()))
//		{
//			Thread.sleep(3000);
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
//	WebElement passwordBox = NextstepFaxInbox.getSSOPasswordInputBox();
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
//	WebElement temp = NextstepFaxInbox.getSSOLoginButton();
//	try
//	{			
//		if(SeleniumHelper.click(temp))
//		{
//			waitForLoginLoad();
//			verifyUserName();
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
//public static Boolean clickSSOLogout() throws Exception
//{
//	Boolean status = false;
//	WebElement temp = NextstepFaxInbox.getLogoutButton();
//	try
//	{			
//		SeleniumHelper.click(temp);
//		if(SeleniumHelper.isExist(NextstepFaxInbox.getSSOUserNameInputBox()))
//		{
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
//	public static Boolean SSOLogin() throws Exception
//	{
//		Boolean status = false;
//		try
//		{			
//			enterSSOUserNameAndClickNext(GlobalVariable.userName);
//			enterSSOPassword(GlobalVariable.password);
//			clickSSOLogin();
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
//public static Boolean enterSSOAndClickNext(String value) throws Exception
//{
//	Boolean status = false;
//	Thread.sleep(2000);
//	WebElement userNameBox = NextstepFaxInbox.getSSOUserNameInputBox();
//	WebElement next = NextstepFaxInbox.getSSOLoginNextButton();
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
//public static Boolean clickToastNotificationCloseButton() throws Exception 
//{
//	Boolean status = false;		
//	WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 90);
//	try 
//	{
//		WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-close']")));			
//		close.click();
//		status = true;
//		Logger.writeDayLog(Logger.messageType.Exception, "Toast Notification close is clicked successfully");
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click tToast Notification");
//	}
//	return status;
//}
//public static Boolean clickSharedQueuenHeader() throws Exception
//{
//	Boolean status=false;
//	Thread.sleep(2000);
//	WebElement organization = NextstepFaxInbox.getSharedQueueMoveCopyWindow();
//	try
//	{
//		if(SeleniumHelper.isExist(organization))
//		{				
//			SeleniumHelper.click( organization);	
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Shared Queue header is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click organization header");
//	}
//	return status;
//}
//public static Boolean selectWorkflow() throws Exception
//{
//	Boolean status=false;
//	Thread.sleep(3000);
//	WebElement workflow = NextstepFaxInbox.getWorkflowValue();
//	try
//	{
//		if(SeleniumHelper.isExist(workflow))
//		{				
//			SeleniumHelper.click( workflow);	
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Workflow is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Workflow");
//	}
//	return status;
//}
//public static Boolean validateProcessStartTimelineEvent() throws Exception 
//{
//	Boolean status = false;
//	List<WebElement> events = NextstepFaxInbox.getAllGridTimelineEvents();
//	try 
//	{
//		for (int i = 0; i < events.size(); i++) 
//		{
//			String startProcess = events.get(i).getText();
//			if (startProcess.contains("Started Process")) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Start Process is validated successfully");
//				break;
//			}
//		} 
//	}
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Start Process is validation is failed");
//	}
//	return status;
//}
//public static Boolean clickGridTag() throws Exception
//{
//	Boolean status=false;
//	WebElement tag = NextstepFaxInbox.getGridTag();
//	try
//	{
//		if(SeleniumHelper.isExist(tag))
//		{				
//			SeleniumHelper.click(tag);	
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Grid tag is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click Grid tag");
//	}
//	return status;
//}
//public static Boolean selectGridTagValue() throws Exception 
//{
//	Boolean status = false;
//	WebElement tagValue = NextstepFaxInbox.getGridTagValue();
//	try 
//	{
//		if (SeleniumHelper.isEnabled(tagValue)) 
//		{
//			SeleniumHelper.click(tagValue);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Grid Tag value is selected");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click image sign button");
//	}
//	return status;
//}
//public static Boolean clickViewerCancelButton() throws Exception
//{
//	Boolean status=false;
//	WebElement cancel = NextstepFaxInbox.getViewerCancelButton();
//	try
//	{
//		if(SeleniumHelper.isExist(cancel))
//		{
//			SeleniumHelper.click( cancel);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Viewer cancel is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Viewer cancel is not clicked");
//	}
//	return status;		
//}
//public static Boolean drawSecondShapes() throws Exception 
//{
//	Boolean status = false;
//	Thread.sleep(1000);
//	WebElement page = NextstepFaxInbox.getFaxViewerDocumentArea();
//	try 
//	{
//		if (SeleniumHelper.isExist(page)) 
//		{
//			Actions a = new Actions(GlobalVariable.driver);
//			Point point = page.getLocation();
//			System.out.println(point);
//			int x = point.getX() / 2;
//			int y = point.getY() / 2;
//			System.out.println(x);
//			System.out.println(y);
//			a.moveToElement(page, x, y).clickAndHold().build().perform();
//			a.moveToElement(page, 310, 160).release().build().perform();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Rectangle is applied successfully");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) {
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to apply rectangle");
//	}
//	return status;
//}
//public static Boolean newWaitForPreferanceLoad() throws Exception
//{
//	Boolean status = false;
//	try
//	{
//		WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='sessionTimeOut']")));
////		WebElement temp = GlobalVariable.driver.findElement(By.xpath("//div[@id='preference-wrapper']//img[contains(@src,'loader.gif')]"));			
////		Boolean austria = new WebDriverWait(GlobalVariable.driver, 10).until(ExpectedConditions.invisibilityOf(temp));
////		WebElement aus = new WebDriverWait(GlobalVariable.driver, 10).until(ExpectedConditions.elementToBeClickable(NextstepFaxInbox.getDefaultSharedQueueDropDown()));
//		Logger.writeDayLog(Logger.messageType.Pass, "Page loaded successfully");
//		status = true;
//	}
//	catch(Exception e)
//	{
//		status=false;
//		Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//	}
//	return status;
//}
//public static Boolean clickActivityTimeoutDropdown() throws Exception
//{
//	Boolean status=false;
//	WebElement timeout = NextstepFaxInbox.getActivityTimeoutDropdown();
//	try
//	{
//		if(SeleniumHelper.isExist(timeout))
//		{
//			SeleniumHelper.click( timeout);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Activity timeout dropdown is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "unable to click Activity timeout dropdown ");
//	}
//	return status;		
//}
//public static Boolean selectActivityTimeoutList() throws Exception
//{
//	Boolean status=false;		
//	List<WebElement> activityTimeoutValue = NextstepFaxInbox.getActivityTimeoutList();	
//	try
//	{	
//		if(activityTimeoutValue.size()>1)
//		{		
//				GlobalVariable.activityTimeout = activityTimeoutValue.get(1).getText();					
//				SeleniumHelper.click( activityTimeoutValue.get(1));
////				WebElement temp = NextstepFaxInbox.getPreferanceSaveButton();					
////				SeleniumHelper.click(temp);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "ActivityTinmeout is selected Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}			
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to Activcity Timeout");
//	}
//	return status;
//}	
//public static Boolean validateActivityLogout() throws Exception
//{
//	Boolean status = false;
//	try
//	{			
//		if(GlobalVariable.activityTimeout.equals("1 Minute"))
//		{
//			WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 120);
//			wait.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getSSOUserNameInputBox())));
//			SeleniumHelper.isExist(NextstepFaxInbox.getActivityTimeoutSSOUserNameInputBox());
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Applicaton is logged out is Clicked Sucessfully");
//		}
//		else if(GlobalVariable.activityTimeout.equals("2 Minute"))
//		{
//			WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 180);
//			wait.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getSSOUserNameInputBox())));
//			SeleniumHelper.isExist(NextstepFaxInbox.getActivityTimeoutSSOUserNameInputBox());
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Applicaton is logged out is Clicked Sucessfully");
//		}
//		else if(GlobalVariable.activityTimeout.equals("5 Minute"))
//		{
//			WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 360);
//			wait.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getSSOUserNameInputBox())));
//			SeleniumHelper.isExist(NextstepFaxInbox.getActivityTimeoutSSOUserNameInputBox());
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Applicaton is logged out is Clicked Sucessfully");
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
//public static Boolean enterSecondAnnotateTextbox(String text) throws Exception 
//{
//	Boolean status = false;
//	WebElement gotoPage = NextstepFaxInbox.getToolsAnnotateSecondTextbox();
//	try
//	{
//		if (SeleniumHelper.isExist(gotoPage)) 
//		{
//			SeleniumHelper.setText(gotoPage, text);
//			gotoPage.sendKeys(Keys.ENTER);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Annotate text is entered successfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Annotate text is not entered");
//	}
//	return status;
//}
//public static Boolean drawInSecondPage() throws Exception 
//{
//	Boolean status = false;
//	Thread.sleep(1000);
//	WebElement page = NextstepFaxInbox.getFaxViewerSecondPageDocumentArea();
//	try 
//	{
//		if (SeleniumHelper.isExist(page)) 
//		{
//			Actions a = new Actions(GlobalVariable.driver);
//			Point point = page.getLocation();
//			System.out.println(point);
//			int x = point.getX() / 2;
//			int y = point.getY() / 2;
//			System.out.println(x);
//			System.out.println(y);
//			a.moveToElement(page, x, y).clickAndHold().build().perform();
//			a.moveToElement(page, 300, 150).release().build().perform();
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "toold is applied successfully");
//		}
//		else 
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) {
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to apply tool");
//	}
//	return status;
//}
//public static Boolean validateProcessStatusTimelineEvent() throws Exception 
//{
//	Boolean status = false;
//	List<WebElement> events = NextstepFaxInbox.getAllGridTimelineEvents();
//	List<String> list=new ArrayList<String>();	
//	list.add("Notification completed");
//	list.add("Page rotation completed");
//	list.add("Document retrieval completed");
//	list.add("Signature detection completed");
//	list.add("Document conversion completed");
//	list.add("Document cleanup completed");
//	list.add("Metadata processing completed");
//	list.add("Metadata transform completed");
//	list.add("Prediction service completed");
//	list.add("Extraction completed");
//	list.add("Barcode recognition completed");
//	list.add("OCR completed");
//	list.add("Started Process 'Automation Test case'");
//	list.add("Document pdf conversion completed");
//	list.add("Document conversion completed");
//	try 
//	{
//		for (int i = 0; i < events.size(); i++) 
//		{
//			String startProcess = events.get(i).getText();
//			if (startProcess.contains(list.get(i))) 
//			{
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Process validation is validated successfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		} 
//	}
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Start Process is validation is failed");
//	}
//	return status;
//}
//public static Boolean validateProcessStatus() throws Exception 
//{
//	Boolean status = false;
//	try 
//	{
//	for(int i=0 ; i<=20 ; i++)
//	{
//		WebElement processStatus = NextstepFaxInbox.getFirstDocumentProcessStatus();
//		WebElement refresh = NextstepFaxInbox.gridRefresh();
//		if(processStatus.getText().equals("Complete"))
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Process Status is validated successfully");
//			break;
//		}
//		else 
//		{
//			SeleniumHelper.click(refresh);
//			waitForGridLoad();
//			Thread.sleep(30000);
//		}
//	}
//	}
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Process Ststus validation failed");
//	}
//	return status;
//}
//public static Boolean clickSSOLoginButton() throws Exception
//{
//	Boolean status = false;
//	WebElement temp = NextstepFaxInbox.getSSOLoginButton();
//	try
//	{			
//		if(SeleniumHelper.click(temp))
//		{
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
//public static Boolean clickSecondAnnotateEdit() throws Exception 
//{
//	Boolean status = false;
//	WebElement edit = NextstepFaxInbox.getToolsSecondAnnotateEditIcon();
//	try
//	{
//		if (SeleniumHelper.isExist(edit)) 
//		{
//			Actions action = new Actions(GlobalVariable.driver);
//			action.moveToElement(edit).build().perform();
//			SeleniumHelper.click( edit);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Annotate edit is clicked successfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	} 
//	catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Annotate text is not entered");
//	}
//	return status;
//}
//public static Boolean waitUntilMergeCartTurnsYellow() throws Exception
//{
//    Boolean status = false;
//    try
//    {
//    	WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 90);
//		wait.until(ExpectedConditions.visibilityOf(NextstepFaxInbox.getMergeCartInprogress()));
//		WebDriverWait newwait = new WebDriverWait(GlobalVariable.driver, 30);
//		newwait.until(ExpectedConditions.visibilityOf(NextstepFaxInbox.getGridMergeCompleted()));
//		status = true;
//    }
//    catch (Exception e)
//    {
//        status = false;
//        Logger.writeDayLog(Logger.messageType.Exception, "Merge cart did not turn to yellow");
//    }
//    return status;
//}
//public static Boolean waitForViewerTimelineLoad() throws Exception
//{
//       Boolean status = false;
//       try
//       {
//    	   WebDriverWait loader = new WebDriverWait(GlobalVariable.driver, 45);
//    	   loader.until(ExpectedConditions.visibilityOf((NextstepFaxInbox.getViewerTimelineLoader())));
//    	   SeleniumHelper.waitUntilControlNotExist(GlobalVariable.driver, NextstepFaxInbox.getViewerTimelineLoader());
//    	   WebDriverWait timeline = new WebDriverWait(GlobalVariable.driver, 45);
//    	   timeline.until(ExpectedConditions.visibilityOf(NextstepFaxInbox.getViewerFirstTimelineEvent()));       	   
//           status = true;
//       }
//       catch(Exception e)
//       {
//              status=false;
//              Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//       }
//       return status;
//}
//public static Boolean contextClickUploadedDocument(int i) throws Exception
//{
//	Boolean status=false;		
//	List<WebElement> docList = NextstepFaxInbox.getAllUploadedDocuments();
//	try
//	{
//		if(docList.size()>1)
//		{
//			if(SeleniumHelper.isExist(docList.get(i)))
//			{				
//				SeleniumHelper.contextClick(docList.get(i));
//				documentID = getUploadedDocumentIDWithIndex(i);
//				System.out.println(documentID);
//				Thread.sleep(1000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Context click on upload fax Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		else
//		{
//			SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//			FaxInbox.waitForPageLoad();				
//			Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//			List<WebElement>list = NextstepFaxInbox.getAllUploadedDocuments();
//			if(SeleniumHelper.isExist(list.get(i)))
//			{				
//				documentID = getUploadedDocumentIDWithIndex(i);
//				SeleniumHelper.click( list.get(i));
//				Thread.sleep(1000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Context click on upload fax Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	}
//	return status;
//}
//public static String getUploadedDocumentIDWithIndex(int index) throws Exception
//{
//	String value = null;;
//	WebElement temp = null;
//	List<WebElement> rows = NextstepFaxInbox.getAllUploadedDocumentsDocumentID();		
//	try
//	{					
//		temp = rows.get(index);
//		value = temp.getAttribute("data-automation-id");
//		Logger.writeDayLog(Logger.messageType.Pass, "Document ID for given index is found");
//	}				
//	catch(Exception e)
//	{
//		Logger.writeDayLog(Logger.messageType.Exception, "Document ID is not found");
//	}
//	return value;
//}
//public static Boolean clickLastSelectedDocument() throws Exception
//{		
//	Boolean status = false;
//	WebElement temp = null;
//	List<WebElement> rows = NextstepFaxInbox.getFaxInboxGriddRows();
//	String[] rowValue = new String[rows.size()];
//	try
//	{
//		for(int i = 0; i<rows.size(); i++)
//		{
//			temp = rows.get(i);
//			rowValue[i] = temp.getAttribute("data-automation-id");
//			if(rowValue[i].equals(documentID))
//			{
//				SeleniumHelper.click(temp);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Document ID(s) are found");
//				break;
//			}
//		}			
//	}
//	catch(Exception e)
//	{			
//		Logger.writeDayLog(Logger.messageType.Exception, "Document ID(s) are  not found");
//	}
//	return status;
//}
//public static Boolean waitForMergeCartLoad() throws Exception
//{
//       Boolean status = false;
//       try
//       {
//    	   WebDriverWait load = new WebDriverWait(GlobalVariable.driver, 60);
//    	   load.until(ExpectedConditions.visibilityOfAllElements(NextstepFaxInbox.getMergeThumbnails()));
//    	   WebDriverWait grid = new WebDriverWait(GlobalVariable.driver, 60);
//    	   grid.until(ExpectedConditions.elementToBeClickable((NextstepFaxInbox.getGridMergeSave())));
//           status = true;
//       }
//       catch(Exception e)
//       {
//              status=false;
//              Logger.writeDayLog(Logger.messageType.Exception,"Page not loaded " + e.getMessage() );
//       }
//       return status;
//} 
//public static Boolean validateMultipleRow() throws Exception
//{
//	Boolean status = false;
//	String[] temp = new String[getDocumentID().length];
//	temp = getDocumentID();
//	try
//	{
//		for(int i=0;i<temp.length; i++)
//		{
//			if(documentID.equals(temp[i]))
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Document is Found");
//				System.out.println("Document is found");
//				status = true; 
//				break;
//			}
//		}
//		for(int j=0;j<temp.length; j++)
//		{
//			if(secondDocumentID.equals(temp[j]))
//			{
//				Logger.writeDayLog(Logger.messageType.Pass, "Second Document is Found");
//				System.out.println("Document is found");
//				status = true; 
//				break;
//			}
//		}
//	}
//	catch(Exception e)
//	{
//		Logger.writeDayLog(Logger.messageType.Exception, "Document(s) not Found");
//		status = false;
//	}		
//	return status;		
//}
//public static Boolean selectOrganizationMovebyName(String name) throws Exception
//{
//	Boolean status=false;
//	Thread.sleep(3000);
//	WebElement organization = NextstepFaxInbox.getOrganizationValueMovebyName(name);
//	try
//	{
//		if(SeleniumHelper.isExist(organization))
//		{				
//			SeleniumHelper.click(organization);	
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "organization is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click organization");
//	}
//	return status;
//}
//public static Boolean selectSharedQueuebyName(String name) throws Exception
//{
//	Boolean status=false;
//	WebElement queue = NextstepFaxInbox.getSharedQueuebybyName(name);
//	try
//	{
//		if(SeleniumHelper.isExist(queue))
//		{				
//			SeleniumHelper.click(queue);	
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Workflow is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click workflow");
//	}
//	return status;
//}
//public static Boolean clickAddressbook() throws Exception 
//{
//	Boolean status = false;
//	WebElement Addressbook = NextstepFaxInbox.Addressbook();
//	try 
//	{
//		if (SeleniumHelper.isDisplayed(Addressbook))
//		{
//			SeleniumHelper.doubleClick(Addressbook);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Addressbook button is clicked");
//			System.out.println("1st");
//			}
//		else
//		{
//			status = false;
//			 throw new Exception();
//		}
//	}
//		catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Addressbook button is not clicked");
//	}
//	return status;
//}	
//
//public static Boolean createContact() throws Exception 
//{
//	Boolean status = false;
//	WebElement newContact = NextstepFaxInbox.createContact();
//	try 
//	{
//		if (SeleniumHelper.isExist(newContact)) 
//		{
//			SeleniumHelper.click(newContact);
//			
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Create Contact button is clicked");	
//		}
//		else
//		{
//			status = true;
//			 throw new Exception();
//		}
//	}
//		catch (Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Create Contact button is not clicked");
//	}
//	return status;
//}	
//public static Boolean enterFirstname(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement name = NextstepFaxInbox.contactFirstName();
//
//	try
//	{
//		if(SeleniumHelper.setText(name, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as firstname");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in firstname");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Firstname");
//	}
//	return status;
//}
//public static Boolean enterFax(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement fax = NextstepFaxInbox.enterFaxnumber();
//	try
//	{
//		if(SeleniumHelper.isExist(fax))
//		{		
//			//fax.sendKeys(value);
//			SeleniumHelper.setText(fax, value);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, fax + " Fax number is entered");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, fax + " Fax number is not entered");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Fax number");
//	}
//	return status;
//}
//public static Boolean filterwithCompany(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement companyname = NextstepFaxInbox.filtercompanyName();
//
//	try
//	{
//		if(SeleniumHelper.setText(companyname, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " Company name is entered");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " Company name is not entered");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Company name is not entered");
//	}
//	return status;
//}
//public static Boolean resetFilter() throws Exception
//{
//	Boolean status=false;
//	WebElement reset = NextstepFaxInbox.resetFilter();
//	try
//	{
//		if(SeleniumHelper.isExist(reset))
//		{
//			SeleniumHelper.click(reset);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Reset is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Reset is not clicked");
//	}
//	return status;
//	
//}
//public static Boolean searchFilter() throws Exception
//{
//	Boolean status=false;
//	WebElement search = NextstepFaxInbox.searchFilter();
//	try
//	{
//		if(SeleniumHelper.isExist(search))
//		{
//			SeleniumHelper.click(search);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Search is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Search is not clicked");
//	}
//	return status;
//	
//}
//public static Boolean saveContact() throws Exception
//{
//	Boolean status=false;
//	WebElement save = NextstepFaxInbox.saveFax();
//	try
//	{
//		if(SeleniumHelper.isExist(save))
//		{
//			SeleniumHelper.click(save);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "save is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "save is not clicked");
//	}
//	return status;
//	
//}
//public static Boolean enterCompany(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement companyname = NextstepFaxInbox.compnayName();
//	try
//	{
//		if(SeleniumHelper.setText(companyname, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " companyname is entered");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + "companyname is not entered");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter companyname");
//	}
//	return status;
//}
//public static Boolean compareCompanyname() throws Exception
//{
//	Boolean status=false;
//	String company="Automation";
//	WebElement compare = NextstepFaxInbox.tableList();
//	try
//	{
//		if(SeleniumHelper.isExist(compare))
//		{
//			String b=compare.getText();
//			if(company.equalsIgnoreCase(b))
//			{
//				System.out.println("Validated company search");
//			}
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Company name validated");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "company name is not matched");
//	}
//	return status;
//}
//public static Boolean comparefaxNumber() throws Exception
//{
//	Boolean status=false;
//	String fax="132454254544";
//	WebElement faxcompare = NextstepFaxInbox.companyfaxValue();
//	try
//	{
//		if(SeleniumHelper.isExist(faxcompare))
//		{
//			String b=faxcompare.getText();
//			if(fax.equalsIgnoreCase(b))
//			{
//				System.out.println("Fax number matched");
//			}
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Fax number validated");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Fax number is not matched");
//	}
//	return status;
//}
//public static Boolean compareEmail() throws Exception
//{
//	Boolean status=false;
//	String emailvalidation="test@test.com";
//	WebElement email = NextstepFaxInbox.emailValue();
//	try
//	{
//		if(SeleniumHelper.isExist(email))
//		{
//			String b=email.getText();
//			if(emailvalidation.equalsIgnoreCase(b))
//			{
//				System.out.println("Email matched");
//			}
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Email validated");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Email is not matched");
//	}
//	return status;
//}
//public static Boolean compareglobalCompany() throws Exception
//{
//	Boolean status=false;
//	String company="Automation";
//	WebElement companyname = NextstepFaxInbox.searchGlobalcompany();
//	try
//	{
//		if(SeleniumHelper.isExist(companyname))
//		{
//			String b=companyname.getText();
//			if(company.equalsIgnoreCase(b))
//			{
//				System.out.println("Global company name matched");
//			}
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Global company name validated");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Global company name is not matched");
//	}
//	return status;
//}
//public static Boolean compareglobalFax() throws Exception
//{
//	Boolean status=false;
//	String b="Automation";
//	WebElement globalfax = NextstepFaxInbox.searchGlobalfax();
//	try
//	{
//		if(SeleniumHelper.isExist(globalfax))
//		{
//			String a=globalfax.getText();
//			if(b.equalsIgnoreCase(a))
//			{
//				System.out.println("Global company name matched");
//			}
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Global company name validated");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Global company name is not matched");
//	}
//	return status;
//}
//public static Boolean filterFaxnumber() throws Exception
//{
//	Boolean status=false;
//	WebElement comparefax = NextstepFaxInbox.faxvalue();
//	try
//	{
//		if(SeleniumHelper.isExist(comparefax))
//		{
//			
//			String b=comparefax.getText();
//			if(UserInput.faxcontact.equalsIgnoreCase(b))
//			{
//				System.out.println("Validated fax search");
//			}
//			//SeleniumHelper.click(compare);
//			status = true;
//			//Logger.writeDayLog(Logger.messageType.Pass, "save is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Fax search is not matched");
//	}
//	return status;
//	
//}
//public static Boolean enterfilterFax(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement fax = NextstepFaxInbox.clickFaxNumber();
//
//	try
//	{
//		if(SeleniumHelper.setText(fax, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " fax number is entered");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " fax number is not entered");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Company name is not entered");
//	}
//	return status;
//}
//public static Boolean updateContact() throws Exception
//{
//	Boolean status=false;
//	WebElement update = NextstepFaxInbox.editContact();
//	try
//	{
//		Actions action = new Actions(GlobalVariable.driver);
//		action.moveToElement(update).build().perform();
//		SeleniumHelper.click(update);
//        status=true;
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "update is not clicked");
//	}
//	return status;
//}
//public static Boolean closeAddressbook() throws Exception
//{
//	Boolean status=false;
//	WebElement close = NextstepFaxInbox.closeAddressbook();
//	try
//	{
//		if(SeleniumHelper.isExist(close))
//		{
//			
//			new WebDriverWait( GlobalVariable.driver,10).until(ExpectedConditions.elementToBeClickable(close));
//			SeleniumHelper.click(close);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "close is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "close is not clicked");
//	}
//	return status;
//	}
//public static Boolean globalFirstname(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement firstname = NextstepFaxInbox.firstNameGlobalcontact();
//
//	try
//	{
//		if(SeleniumHelper.setText(firstname, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as firstname");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in firstname");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Firstname");
//	}
//	return status;
//}
//public static Boolean globalcontactFax(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement globalcontactfax = NextstepFaxInbox.globalContactFax();
//	try
//	{
//		if(SeleniumHelper.setText(globalcontactfax, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " Fax number is entered");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " Fax number is not entered");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Fax number");
//	}
//	return status;
//}
//public static Boolean saveGlobalcontact() throws Exception
//{
//	Boolean status=false;
//	WebElement saveglobal = NextstepFaxInbox.saveGlobalContact();
//	try
//	{
//		if(SeleniumHelper.isExist(saveglobal))
//		{
//			SeleniumHelper.click(saveglobal);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "save is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "save is not clicked");
//	}
//	return status;
//	}
//public static Boolean createGlobalcontact() throws Exception
//{
//	Boolean status=false;
//	WebElement newglobal = NextstepFaxInbox.createglobalContact();
//	try
//	{
//		if(SeleniumHelper.isExist(newglobal))
//		{
//			Thread.sleep(2000);
//			new WebDriverWait( GlobalVariable.driver,20).until(ExpectedConditions.elementToBeClickable(newglobal));
//			SeleniumHelper.click(newglobal);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Create new Global contact is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Create new Global contact is not clicked");
//	}
//	return status;
//	}
//public static Boolean updatePopuphandle() throws Exception
//{
//	Boolean status=false;
//	WebElement okbutton = NextstepFaxInbox.updatePopup();
//	try
//	{
//		if(SeleniumHelper.isExist(okbutton))
//		{
//			SeleniumHelper.click(okbutton);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "OK button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "OK button is not clicked");
//	}
//	return status;
//	}
//public static Boolean deleteContact() throws Exception
//{
//	Boolean status=false;
//	WebElement delete = NextstepFaxInbox.deleteContact();
//	try
//	{
//		Actions action = new Actions(GlobalVariable.driver);
//		action.moveToElement(delete).build().perform();
//		SeleniumHelper.click(delete);
//        status=true;
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "delete is not clicked");
//	}
//	return status;
//	
//}
//public static Boolean deletePopup() throws Exception
//{
//	Boolean status=false;
//	WebElement popup = NextstepFaxInbox.deletePopup();
//	try
//	{
//		if(SeleniumHelper.isExist(popup))
//		{
//			SeleniumHelper.click(popup);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Delete is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Delete is not clicked");
//	}
//	return status;
//	}
//public static Boolean dupicateContact() throws Exception
//{
//
//	Boolean status=false;
//	WebElement duplicate=NextstepFaxInbox.duplicateMessage();
//	try
//	{
//		if(SeleniumHelper.isExist(duplicate))
//		{
//			SeleniumHelper.click(duplicate);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Dupliate message is validated");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Dupliate message is not validated");
//	}
//	return status;
//	}
//public static Boolean globalcontacTab() throws Exception
//{
//	Boolean status=false;
//	WebElement global=NextstepFaxInbox.clickGlobalContact();
//	try
//	{
//		if(SeleniumHelper.isExist(global))
//		{
//			SeleniumHelper.click(global);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Global contact tab is clicked");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Global contact tab is not clicked");
//	}
//	return status;
//	}
//public static Boolean enterglobalFax(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement globalfax = NextstepFaxInbox.globalFax();
//
//	try
//	{
//		if(SeleniumHelper.setText(globalfax, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as global fax");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered in global fax");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter global fax number");
//	}
//	return status;
//}
//public static Boolean searchGlobalcontact() throws Exception
//{
//
//	Boolean status=false;
//	WebElement globalsearch=NextstepFaxInbox.searchglobalFax();
//	try
//	{
//		if(SeleniumHelper.isExist(globalsearch))
//		{
//			Thread.sleep(2000);
//			new WebDriverWait( GlobalVariable.driver,20).until(ExpectedConditions.elementToBeClickable(globalsearch));
//			SeleniumHelper.click(globalsearch);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "search button is clicked");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "search button is not clicked");
//	}
//	return status;
//	}
//public static Boolean enterGloablfax(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement globalOrganization = NextstepFaxInbox.searchglobalfax();
//
//	try
//	{
//		if(SeleniumHelper.setText(globalOrganization, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as global fax");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as global fax");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter global fax");
//	}
//	return status;
//}
//public static Boolean selectAllcontact() throws Exception
//{
//
//	Boolean status=false;
//	WebElement selectall=NextstepFaxInbox.checkAll();
//	try
//	{
//		if(SeleniumHelper.isExist(selectall))
//		{
//			Thread.sleep(1000);
//			new WebDriverWait(GlobalVariable.driver,20).until(ExpectedConditions.elementToBeClickable(selectall));
//			SeleniumHelper.click(selectall);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "select all checkbox is clicked");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "select all checkbox is not clicked");
//	}
//	return status;
//	}
//public static Boolean addtoMycontact() throws Exception
//{
//
//	Boolean status=false;
//	WebElement copyContact=NextstepFaxInbox.AddtoMycontact();
//	try
//	{
//		if(SeleniumHelper.isExist(copyContact))
//		{
//			SeleniumHelper.click(copyContact);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "copyContact checkbox is clicked");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "copyContact checkbox is not clicked");
//	}
//	return status;
//	}
//public static Boolean updateGlobalContact() throws Exception
//{
//	Boolean status=false;
//	WebElement updateglobal = NextstepFaxInbox.editGlobalContact();
//	try
//	{
//		Actions action = new Actions(GlobalVariable.driver);
//		action.moveToElement(updateglobal).build().perform();
//		SeleniumHelper.click(updateglobal);
//        status=true;
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "update is not clicked");
//	}
//	return status;
//	
//}
//public static Boolean enternewGloablalais(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement globalnew = NextstepFaxInbox.newGlobalcompany();
//
//	try
//	{
//		if(SeleniumHelper.setText(globalnew, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as gloabal compnay name");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as gloabal compnay name");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter gloabal compnay name");
//	}
//	return status;
//}
//public static Boolean viewerAddressbook() throws Exception
//{
//
//	Boolean status=false;
//	WebElement copyContact=NextstepFaxInbox.viewerAddressbook();
//	try
//	{
//		if(SeleniumHelper.isExist(copyContact))
//		{
//			SeleniumHelper.click(copyContact);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "viewer Addressbook is clicked");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "viewer Addressbook is not clicked");
//	}
//	return status;
//	}
//public static Boolean viewerSavebutton() throws Exception
//{
//
//	Boolean status=false;
//	WebElement savebutton=NextstepFaxInbox.viewerSaveButton();
//	try
//	{
//		if(SeleniumHelper.isExist(savebutton))
//		{
//			SeleniumHelper.click(savebutton);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "save button is clicked");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "save button is not clicked");
//	}
//	return status;
//	}
//public static Boolean enterGloablcompany(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement globalOrganization = NextstepFaxInbox.searchglobalCompany();
//
//	try
//	{
//		if(SeleniumHelper.setText(globalOrganization, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, value + " is entered as global organization");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, value + " is Not entered as global organization");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter global organization");
//	}
//	return status;
//}
//public static Boolean holdforreviewfax() throws Exception
//{
//	Boolean status=false;
//	WebElement reviewfax = NextstepFaxInbox.holdforreview();
//	Thread.sleep(5000);
//	try
//	{
//		if(SeleniumHelper.isExist(reviewfax))
//		{
//			SeleniumHelper.click( reviewfax);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Hold for review is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click hold for review");
//	}
//	return status;
//}
//	public static Boolean selectUploadedDocument(int i) throws Exception
//	{
//	    Boolean status=false;   
//	    List<WebElement> docList = NextstepFaxInbox.getAllUploadedDocuments();
//	    try
//	    {
//	        if(docList.size()>1)
//	        {
//	            if(SeleniumHelper.isExist(docList.get(i)))
//	            {               
//	                SeleniumHelper.doubleClick(docList.get(i));
//	                documentID = getUploadedDocumentIDWithIndex(i);
//	                System.out.println(documentID);
//	                Thread.sleep(1000);
//	                status = true;
//	                Logger.writeDayLog(Logger.messageType.Pass, "Context click on upload fax Sucessfully");
//	            }
//	            else
//	            {
//	                status = false;
//	                throw new Exception();
//	            }
//	        }
//	        else
//	        {
//	            SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//	            FaxInbox.waitForPageLoad();               
//	            Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//	            List<WebElement>list = NextstepFaxInbox.getAllUploadedDocuments();
//	            if(SeleniumHelper.isExist(list.get(i)))
//	            {               
//	                documentID = getUploadedDocumentIDWithIndex(i);
//	                SeleniumHelper.click( list.get(i));
//	                Thread.sleep(1000);
//	                status = true;
//	                Logger.writeDayLog(Logger.messageType.Pass, "Context click on upload fax Sucessfully");
//	            }
//	            else
//	            {
//	                status = false;
//	                throw new Exception();
//	            }
//	        }
//	    }
//	    catch(Exception e)
//	    {
//	        status = false;
//	        Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	    }
//	    return status;
//	}
//public static Boolean openDocument() throws Exception
//{
//	Boolean status=false;
//	WebElement open = NextstepFaxInbox.documentOpenbutton();
//	Thread.sleep(5000);
//	try
//	{
//		if(SeleniumHelper.isExist(open))
//		{
//			SeleniumHelper.click(open);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "open button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click open button");
//	}
//	return status;
//}
//public static Boolean selectDropdown() throws Exception
//{
//	Boolean status=false;
//	WebElement arrow = NextstepFaxInbox.clickDropdown();
//	try
//	{
//		if(SeleniumHelper.click(arrow))
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "dropdown is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "dropdown is not clicked");
//	}
//	return status;
//	}
//public static Boolean searchValue(String value) throws Exception
//{
//	Boolean status=false;		
//	WebElement search = NextstepFaxInbox.searchValue();
//
//	try
//	{
//		if(SeleniumHelper.setText(search, value))
//		{				
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Email is entered");
//		}
//		else
//		{
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Fail, "Email is not entered");
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter search e-mail");
//	}
//	return status;
//}
//public static Boolean selectEmailvalue() throws Exception
//{
//	Boolean status=false;
//	WebElement email = NextstepFaxInbox.selectEmail();
//	try
//	{
//		if(SeleniumHelper.click(email))
//		{
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Email is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Email is not clicked");
//	}
//	return status;
//	}
//public static Boolean contextClickholdforreview(int i) throws Exception
//{
//	Boolean status=false;		
//	List<WebElement> docList = NextstepFaxInbox.getAllholdforreview();
//	try
//	{
//		if(docList.size()>1)
//		{
//			if(SeleniumHelper.isExist(docList.get(i)))
//			{				
//				//documentID = getDocumentIDWithIndexForMarkAsRead(i);
//				//WebElement expand=NextstepFaxInbox.expandDocument();
//				SeleniumHelper.contextClick(docList.get(0));
//				Thread.sleep(1000);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "opened upload fax Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//		else
//		{
//			SeleniumHelper.click(NextstepFaxInbox.getClickHere());
//			FaxInbox.waitForPageLoad();				
//			Logger.writeDayLog(Logger.messageType.Pass, "Document is not available so clicking click here buttton");
//			List<WebElement>list = NextstepFaxInbox.getAllInboundOutboundDocuments();
//			if(SeleniumHelper.isExist(list.get(i)))
//			{				
//				documentID = getDocumentIDWithIndex(i);
//				SeleniumHelper.contextClick( list.get(i));
//				Thread.sleep(1000);
//				status = true;
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	}
//	return status;
//}
//public static Boolean addGlobalcontact() throws Exception
//{
//	Boolean status=false;
//	WebElement saveglobal = NextstepFaxInbox.AddGlobalContact();
//	try
//	{
//		if(SeleniumHelper.isExist(saveglobal))
//		{
//			SeleniumHelper.click(saveglobal);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "save is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "save is not clicked");
//	}
//	return status;
//	}
//public static Boolean createnewGroup() throws Exception
//{
//	Boolean status=false;
//	WebElement newgroup = NextstepFaxInbox.createGroup();
//	try
//	{
//		if(SeleniumHelper.isExist(newgroup))
//		{
//			SeleniumHelper.click(newgroup);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Create Group is Clicked Sucessfully");
//			System.out.println("2st");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Create Group is not clicked");
//	}
//	return status;
//	}
//public static Boolean enterGroup() throws Exception
//{
//	Boolean status=false;
//	WebElement groupName = NextstepFaxInbox.enterGroupname();
//	try
//	{
//		if(SeleniumHelper.isExist(groupName))
//		{
//			groupName.sendKeys("Automation");
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Group name value entered successfully");
//			System.out.println("3st");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Group name value ");
//	}
//	return status;		
//}
//public static Boolean selectContact() throws Exception
//{
//	Boolean status=false;	
//	Thread.sleep(2000);
//	List<WebElement> contact = NextstepFaxInbox.groupContacts();
//	WebElement moveto = NextstepFaxInbox.movetoGroupmember();
//	try
//	{
//	//	if(contact.size()>=1)
//		for(int i=0;i<=2;i++)
//		{
//			if(SeleniumHelper.isExist(contact.get(i)))
//			{				
//				SeleniumHelper.click(contact.get(i));
//				moveto.click();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "contact is selected Sucessfully");
//				System.out.println("4st");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, e.getMessage());
//	}
//	return status;
//}
//public static Boolean saveGroup() throws Exception
//{
//	Boolean status=false;
//	WebElement save = NextstepFaxInbox.saveGroup();
//	try
//	{
//		if(SeleniumHelper.isExist(save))
//		{
//			SeleniumHelper.click(save);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "save is Clicked Sucessfully");
//			System.out.println("st");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "save is not clicked");
//	}
//	return status;
//	}
//public static Boolean cancelGroup() throws Exception
//{
//	Boolean status=false;
//	WebElement cancel = NextstepFaxInbox.closeGroup();
//	try
//	{
//		if(SeleniumHelper.isExist(cancel))
//		{
//			SeleniumHelper.click(cancel);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "cancel is Clicked Sucessfully");
//			System.out.println("st");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "cancel is not clicked");
//	}
//	return status;
//	}
//public static Boolean warningMessage() throws Exception
//{
//	Boolean status=false;
//	WebElement alert = NextstepFaxInbox.duplicateWarning();
//	try
//	{
//		if(SeleniumHelper.isExist(alert))
//		{
//			SeleniumHelper.click(alert);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "OK is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "OK is not clicked");
//	}
//	return status;
//	}
//public static Boolean searchGroup() throws Exception
//{
//	Boolean status=false;
//	WebElement groupName = NextstepFaxInbox.searchBox();
//	try
//	{
//		if(SeleniumHelper.isExist(groupName))
//		{
//			groupName.sendKeys("Automation");
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Group name value entered successfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Group name value ");
//	}
//	return status;		
//}
//public static Boolean searchButton() throws Exception
//{
//	Boolean status=false;
//	WebElement search = NextstepFaxInbox.searchButton();
//	try
//	{
//		if(SeleniumHelper.isExist(search))
//		{
//			SeleniumHelper.click(search);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "search is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "search is not clicked");
//	}
//	return status;
//	}
//public static Boolean clickGroupcontact() throws Exception
//{
//	Boolean status=false;
//	WebElement search = NextstepFaxInbox.groupContacttab();
//	try
//	{
//		if(SeleniumHelper.isExist(search))
//		{
//			SeleniumHelper.click(search);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Group Contact tab is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Group Contact tab is not clicked");
//	}
//	return status;
//	}
//public static Boolean resetButton() throws Exception
//{
//	Boolean status=false;
//	WebElement reset = NextstepFaxInbox.resetButton();
//	try
//	{
//		if(SeleniumHelper.isExist(reset))
//		{
//			SeleniumHelper.click(reset);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Reset is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Reset is not clicked");
//	}
//	return status;
//	}
//public static Boolean updateGroup() throws Exception
//{
//	Boolean status=false;
//	WebElement updateGroup = NextstepFaxInbox.editGroup();
//	try
//	{
//		//Thread.sleep(3000);
//		Actions action = new Actions(GlobalVariable.driver);
//		action.moveToElement(updateGroup).build().perform();
//		SeleniumHelper.click(updateGroup);
//        status=true;
//        Logger.writeDayLog(Logger.messageType.Exception, "update is clicked");
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "update is not clicked");
//	}
//	return status;
//	
//}
//public static Boolean updateGroupname() throws Exception
//{
//	Boolean status=false;
//	WebElement groupName = NextstepFaxInbox.enterGroupname();
//	try
//	{
//		if(SeleniumHelper.isExist(groupName))
//		{
//			groupName.sendKeys("test");
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Group name value entered successfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to enter Group name value ");
//	}
//	return status;		
//}
//public static Boolean deleteGroup() throws Exception
//{
//	Boolean status=false;
//	WebElement deleteGroup = NextstepFaxInbox.deleteGroup();
//	try
//	{
//		//Thread.sleep(3000);
//		Actions action = new Actions(GlobalVariable.driver);
//		action.moveToElement(deleteGroup).build().perform();
//		SeleniumHelper.click(deleteGroup);
//        status=true;
//        Logger.writeDayLog(Logger.messageType.Exception, "delete is clicked");
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "delete is not clicked");
//	}
//	return status;
//}
//public static Boolean warningPopup() throws Exception
//{
//	Boolean status=false;
//	WebElement yes = NextstepFaxInbox.okButton();
//	try
//	{
//		if(SeleniumHelper.isExist(yes))
//		{
//			SeleniumHelper.click(yes);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Yes button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Yes button is not clicked");
//	}
//	return status;
//	}
//public static Boolean deletedPopup() throws Exception
//{
//	Boolean status=false;
//	WebElement deleted = NextstepFaxInbox.deletedMessage();
//	try
//	{
//		if(SeleniumHelper.isExist(deleted))
//		{
//			SeleniumHelper.click(deleted);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "OK button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "OK button is not clicked");
//	}
//	return status;
//	}
//public static Boolean getSearchresult() throws Exception
//{
//	Boolean status=false;
//	WebElement result = NextstepFaxInbox.getSearchresult();
//	try
//	{
//		if(SeleniumHelper.isExist(result))
//		{
//			
//			new WebDriverWait( GlobalVariable.driver,10).until(ExpectedConditions.elementToBeClickable(result));
//			SeleniumHelper.click(result);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Result first row is selected Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Result first row is not selected");
//	}
//	return status;
//	}
//public static Boolean getglobalSearchresult() throws Exception
//{
//	Boolean status=false;
//	WebElement globaltab = NextstepFaxInbox.getglobalSearchresult();
//	try
//	{
//		if(SeleniumHelper.isExist(globaltab))
//		{
//			
//			new WebDriverWait( GlobalVariable.driver,10).until(ExpectedConditions.elementToBeClickable(globaltab));
//			SeleniumHelper.click(globaltab);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Gloabl tab result first row is selected Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Global tab result first row is not selected");
//	}
//	return status;
//	}
//
//public static Boolean savePop() throws Exception
//{
//	Boolean status=false;
//	WebElement OK = NextstepFaxInbox.clickOKbutton();
//	try
//	{
//		if(SeleniumHelper.isExist(OK))
//		{
//			SeleniumHelper.click(OK);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "OK is clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "OK is not clicked");
//	}
//	return status;
//	}
//public static Boolean deletedSuccess() throws Exception
//{
//	Boolean status=false;
//	WebElement popup = NextstepFaxInbox.deletedMessagePopup();
//	try
//	{
//		if(SeleniumHelper.isExist(popup))
//		{
//			SeleniumHelper.click(popup);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "OK is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "OK is not clicked");
//	}
//	return status;
//	}
//public static Boolean newGroup() throws Exception
//{
//	Boolean status=false;
//	WebElement save = NextstepFaxInbox.groupCreated();
//	try
//	{
//		if(SeleniumHelper.isExist(save))
//		{
//			SeleniumHelper.click(save);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "OK is Clicked Sucessfully");
//			System.out.println("st");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "OK is not clicked");
//	}
//	return status;
//	}
//public static Boolean getgroupSearchresult() throws Exception
//{
//	Boolean status=false;
//	WebElement result = NextstepFaxInbox.getgroupSearchresult();
//	try
//	{
//		if(SeleniumHelper.isExist(result))
//		{
//			
//			new WebDriverWait( GlobalVariable.driver,10).until(ExpectedConditions.elementToBeClickable(result));
//			SeleniumHelper.click(result);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Result first row is selected Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Result first row is not selected");
//	}
//	return status;
//	}
//public static Boolean selectDefaultPersonalFolderFromList() throws Exception
//{
//	Boolean status=false;		
//	List<WebElement> defaultSharedQueueDropDown = NextstepFaxInbox.getDefaultSharedQueueDropDownList();	
//	try
//	{	
//		if(defaultSharedQueueDropDown.size()>1)
//		{							
//				SeleniumHelper.doubleClick(defaultSharedQueueDropDown.get(1));
//				WebElement temp = NextstepFaxInbox.getPreferanceSaveButton();					
//				SeleniumHelper.click( temp);
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Default Shared Queue option is selected Sucessfully");
//			}
//			else
//			{
//				status = false;
//				throw new Exception();
//			}			
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to select Default Shared Queue option ");
//	}
//	return status;
//}
//public static Boolean multiDeleteValidation() throws Exception
//{
//	Boolean status = false;		
//	try
//	{
//		if(GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount -2) 
//		{
//			status=true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Multiple document delete grid count validation is success");
//			System.out.println("move validation is sucessfull");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}							
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Copy/Move validation failed");
//	}
//	return status;
//}
//public static Boolean multiCopyValidation() throws Exception
//{
//	Boolean status = false;		
//	try
//	{
//		if(GlobalVariable.aftersourcefoldercount == GlobalVariable.beforesourcefoldercount +2) 
//		{
//			status=true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Multiple copy grid count validation is success");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}							
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Copy/Move validation failed");
//	}
//	return status;
//}
//public static Boolean clickFaxViewerDelete() throws Exception
//{
//	Boolean status=false;		
//	WebElement firstPage = NextstepFaxInbox.getFaxViewerDelete();
//	try
//	{
//		if(SeleniumHelper.isExist(firstPage))
//		{				
//			SeleniumHelper.click( firstPage);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "First Page is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click First Page");
//	}
//	return status;
//}
//public static Boolean clickDeleteFaxNoButton() throws Exception
//{
//	Boolean status=false;		
//	WebElement no = NextstepFaxInbox.getDeleteFaxNoButton();
//	try
//	{
//		if(SeleniumHelper.isExist(no))
//		{				
//			SeleniumHelper.click(no);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "No button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click the No button");
//	}
//	return status;
//}
//public static Boolean clickPermananentDeleteCancel() throws Exception
//{
//	Boolean status=false;		
//	WebElement cancel = NextstepFaxInbox.getPermanentDeleteCancelButton();
//	try
//	{
//		if(SeleniumHelper.isExist(cancel))
//		{				
//			SeleniumHelper.click(cancel);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Delete cancel button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click the delete cancel button");
//	}
//	return status;
//}
//public static Boolean clickPreferenceCancelButton() throws Exception
//{
//	Boolean status=false;		
//	WebElement cancel = NextstepFaxInbox.getPreferanceCancelButton();
//	try
//	{
//		if(SeleniumHelper.isExist(cancel))
//		{				
//			SeleniumHelper.click(cancel);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Preference cancel button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click the Preference cancel button");
//	}
//	return status;
//}
//public static Boolean clickCreateFolderCancelButton() throws Exception
//{
//	Boolean status=false;		
//	WebElement cancel = NextstepFaxInbox.getCreateFolderCancelButton();
//	try
//	{
//		if(SeleniumHelper.isExist(cancel))
//		{				
//			SeleniumHelper.click(cancel);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Create Folder cancel button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click the Create folder cancel button");
//	}
//	return status;
//}
//public static Boolean clickDeleteFolderCancelButton() throws Exception
//{
//	Boolean status=false;		
//	WebElement cancel = NextstepFaxInbox.getDeleteFolderCancelButton();
//	try
//	{
//		if(SeleniumHelper.isExist(cancel))
//		{				
//			SeleniumHelper.click(cancel);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Delete Folder cancel button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click the Delete folder cancel button");
//	}
//	return status;
//}
//public static Boolean enterFolderName(String folderName) throws Exception
//{
//	Boolean status = false;
//	WebElement textBox = NextstepFaxInbox.getNewFolderName();
//	try
//	{
//		if(SeleniumHelper.isExist(textBox))
//		{
//			SeleniumHelper.setText(textBox,folderName);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, folderName + " folder name is entered as sub folder");
//		}
//			
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e)
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, folderName + " folder name is not entered" + e.getMessage());
//	}
//	return status;
//}
//public static Boolean clickDiscardButton() throws Exception
//{
//	Boolean status=false;		
//	WebElement discard = NextstepFaxInbox.getDiscardButton();
//	try
//	{
//		if(SeleniumHelper.isExist(discard))
//		{				
//			SeleniumHelper.click(discard);
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, "Watermark discard button is Clicked Sucessfully");
//		}
//		else
//		{
//			status = false;
//			throw new Exception();
//		}
//	}
//	catch(Exception e) 
//	{
//		status = false;
//		Logger.writeDayLog(Logger.messageType.Exception, "Unable to click the Watermark discard button");
//	}
//	return status;
//}
//}
//
//
