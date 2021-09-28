//package org.ab.pageAction;
//
//import org.ab.constants.FrameworkConstants;
//import org.ab.utils.ReadPropertyFile;
//import org.openqa.selenium.WebElement;
//
//import com.concord.nextstep.POM.NextstepFaxInbox;
//import com.concord.nextstep.framework.GlobalVariable;
//import com.concord.nextstep.helper.SeleniumHelper;
//import com.concord.nextstep.logger.Logger;
//
//public class LoginPage {
//
//	public static Boolean SSOLogin() throws Exception {
//		SeleniumHelper.click(temp);
//		
//		ReadPropertyFile
//				.getPropertyValue(FrameworkConstants.getPageObjectsPath() + "LoginPage.properties", "qa");
//		enterSSOUserNameAndClickNext(GlobalVariable.userName);
//		enterSSOPassword(GlobalVariable.password);
//		clickSSOLogin();
//	}
//
//	public static Boolean clickSSOLogout() throws Exception {
//		Boolean status = false;
//		WebElement temp = NextstepFaxInbox.getLogoutButton();
//		try {
//			SeleniumHelper.click(temp);
//			if (SeleniumHelper.isExist(NextstepFaxInbox.getSSOUserNameInputBox())) {
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Logout is Clicked Sucessfully");
//			} else {
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Logout" + e.getStackTrace());
//		}
//		return status;
//	}
//
//	public static Boolean clickSSOLogin() throws Exception {
//		Boolean status = false;
//		WebElement temp = NextstepFaxInbox.getSSOLoginButton();
//		try {
//			if (SeleniumHelper.click(temp)) {
//				waitForLoginLoad();
//				verifyUserName();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Login is Clicked Sucessfully");
//			} else {
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Not able to click Login" + e.getStackTrace());
//		}
//		return status;
//	}
//}