package org.ab.pageAction;

import org.ab.utils.SeleniumUtils;

public class Login {
	
	public static void SsoLogin(String userName,String password) {
		SeleniumUtils.sendKeys("LoginPage.usernameTxt", userName);
		SeleniumUtils.click("LoginPage.nextBtn");
		SeleniumUtils.sendKeys("LoginPage.passwordTxt", password);
		SeleniumUtils.click("LoginPage.enterBtn");
	}

}
