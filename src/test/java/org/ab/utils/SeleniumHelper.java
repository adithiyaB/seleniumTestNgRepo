//package org.ab.utils;
//
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;
//
//import org.ab.constants.GlobalVariable;
//import org.openqa.selenium.By;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.concord.nextstep.logger.Logger;
//
//public class SeleniumHelper {
//
//	private final static int TIMEOUT = 10;
//
//	public static void waitForControl(WebElement control) throws Exception {
//		try {
//			Logger.writeDayLog(Logger.messageType.Pass, "waiting for" + control.getText());
//			WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 10);
//			wait.until(ExpectedConditions.elementToBeClickable(control));
//			Logger.writeDayLog(Logger.messageType.Pass, "Found control ");
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception, GlobalVariable.getTestCaseDescription()
//					+ " Not able to find control " + control.getText() + " in given time span " + e.getStackTrace());
//		}
//	}
//
//	public static Boolean isDisplayed(WebElement control) throws Exception {
//		Boolean status = false;
//		try {
//			Logger.writeDayLog(Logger.messageType.Pass, "Checking for control is displayed " + control.getText());
//			if (control.isDisplayed()) {
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, " Control found" + control.getText());
//			} else {
//				status = false;
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception,
//					control.getText() + " Control is not displayed" + e.getStackTrace());
//		}
//		return status;
//	}
//
//	public static Boolean click(WebElement control) throws Exception {
//		Boolean status = false;
//		String text = control.getText();
//		Logger.writeDayLog(Logger.messageType.Pass, "Trying to click control " + text);
//		try {
//			if ((control.isDisplayed()) && (control.isEnabled())) {
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is Displayed and Enabled to Click " + text);
//				control.click();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is clicked " + text);
//			} else {
//				Logger.writeDayLog(Logger.messageType.Pass, "Waiting for control to enabled " + text);
//				waitForControl(control);
//				control.click();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is clicked " + text);
//			}
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception,
//					"Not able to click control in given time span " + text + e.getStackTrace());
//			status = false;
//		}
//		return status;
//	}
//
//	public static Boolean doubleClick(WebElement control) throws Exception {
//		Boolean status = false;
//		String text = control.getText();
//		Actions action = new Actions(GlobalVariable.driver);
//		Logger.writeDayLog(Logger.messageType.Pass, "Trying to click control " + text);
//		try {
//			if ((control.isDisplayed()) && (control.isEnabled())) {
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is Displayed and Enabled to Click " + text);
//				action.moveToElement(control).doubleClick().perform();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is double clicked " + text);
//			} else {
//				Logger.writeDayLog(Logger.messageType.Pass, "Waiting for control to enabled " + text);
//				waitForControl(control);
//				action.moveToElement(control).doubleClick().perform();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is double  clicked " + text);
//			}
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception,
//					"Not able to double click control in given time span " + text + e.getStackTrace());
//			status = false;
//		}
//		return status;
//	}
//
//	public static Boolean contextClick(WebElement control) throws Exception {
//		Boolean status = false;
//		String text = control.getText();
//		Logger.writeDayLog(Logger.messageType.Pass, "Trying to click control " + text);
//		Actions action = new Actions(GlobalVariable.driver);
//		try {
//			if ((control.isDisplayed()) && (control.isEnabled())) {
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is Displayed and Enabled to right Click " + text);
//				action.contextClick(control).perform();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is right clicked " + text);
//			} else {
//				Logger.writeDayLog(Logger.messageType.Pass, "Waiting for control to enabled " + text);
//				waitForControl(control);
//				action.contextClick(control).perform();
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Control is right clicked " + text);
//			}
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception,
//					"Not able to right click control in given time span " + text + e.getStackTrace());
//			status = false;
//		}
//		return status;
//	}
//
//	public static Boolean isEnabled(WebElement control) throws Exception {
//		Boolean status = false;
//		try {
//			waitForControl(control);
//			Logger.writeDayLog(Logger.messageType.Pass, "Checking for control is enabled " + control.getText());
//			if (control.isEnabled()) {
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, " Control enabled " + control.getText());
//			} else {
//				status = false;
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception,
//					control.getText() + " Control is not enabled" + e.getStackTrace());
//		}
//		return status;
//	}
//
//	public static Boolean isExist(WebElement control) throws Exception {
//		Boolean status = false;
//		try {
//			waitForControl(control);
//			Logger.writeDayLog(Logger.messageType.Pass, "Checking for control is existance " + control.getText());
//			if (control.isDisplayed() && control.getSize().getHeight() > 0) {
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, " Control exist " + control.getText());
//			} else {
//				status = false;
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception,
//					control.getText() + " Control is not exist" + e.getStackTrace());
//		}
//		return status;
//	}
//
//	public static Boolean setText(WebElement control, String searchString) throws Exception {
//		Boolean status = false;
//		try {
//			waitForControl(control);
//			Logger.writeDayLog(Logger.messageType.Pass, "Checking for control existance " + control.getText());
//			if (control.isDisplayed() && control.isEnabled()) {
//				Logger.writeDayLog(Logger.messageType.Pass,
//						" Control exist and enabled to enter search text " + control.getText());
//				control.clear();
//				control.click();
//				control.sendKeys((searchString));
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass,
//						"Value " + searchString + " is entered in " + control.getText());
//			} else {
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception,
//					control.getText() + " Not able to set text " + e.getStackTrace());
//		}
//		return status;
//	}
//
//	public static Boolean waitUntilControlNotExist(WebDriver driver, WebElement control) throws Exception {
//		Boolean status = false;
//		try {
//			WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, 10);
//			wait.until(ExpectedConditions.attributeContains(control, "style", "none"));
//			status = true;
//			Logger.writeDayLog(Logger.messageType.Pass, control.getText() + " Element disappeared");
//		} catch (Exception e) {
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Warning, "element is not disappeared");
//		}
//		return status;
//	}
//
//	public static Boolean enableCheckBox(WebElement control) throws Exception {
//		Boolean status = true;
//		try {
//			waitForControl(control);
//			Logger.writeDayLog(Logger.messageType.Pass, "Checking for control existance " + control.getText());
//			if (control.isDisplayed() && control.isEnabled()) {
//				Logger.writeDayLog(Logger.messageType.Pass,
//						" Control exist and enabled to enter search text " + control.getText());
//				if (control.isSelected()) {
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Check box is already checked " + control.getText());
//				} else {
//					WebElement e = control.findElement(By.xpath("./following-sibling::label)"));
//					SeleniumHelper.click(e);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Check box is checked " + control.getText());
//				}
//			} else {
//				status = false;
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to check the CheckBox");
//		}
//		return status;
//	}
//
//	public static Boolean disableCheckBox(WebElement control) throws Exception {
//		Boolean status = true;
//		try {
//			waitForControl(control);
//			Logger.writeDayLog(Logger.messageType.Pass, "Checking for control existance " + control.getText());
//			if (control.isDisplayed()) {
//				Logger.writeDayLog(Logger.messageType.Pass,
//						" Control exist and enabled to enter search text " + control.getText());
//				if (!control.isSelected()) {
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Check box is already unchecked " + control.getText());
//				} else {
//					WebElement e = control.findElement(By.xpath("./following-sibling::label)"));
//					SeleniumHelper.click(e);
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Check box is unchecked " + control.getText());
//				}
//			} else {
//				status = false;
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			status = false;
//			Logger.writeDayLog(Logger.messageType.Exception, "Unable to uncheck the CheckBox");
//		}
//		return status;
//	}
//
//	public static Boolean isChecked(WebElement control) throws Exception {
//		Boolean status = false;
//		try {
//			waitForControl(control);
//			Logger.writeDayLog(Logger.messageType.Pass, "Checking for control is existance " + control.getText());
//			if (control.isDisplayed() && control.isSelected()) {
//				status = true;
//				Logger.writeDayLog(Logger.messageType.Pass, "Check box is checked " + control.getText());
//			} else {
//				status = false;
//				Logger.writeDayLog(Logger.messageType.Exception, control.getText() + " Check box is unchecked");
//			}
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception,
//					control.getText() + " Control is not exist" + e.getStackTrace());
//		}
//		return status;
//	}
//
//	public static Boolean dragAndDropE2E(WebDriver driver, WebElement from, WebElement to) throws Exception {
//		Boolean status = false;
//		Actions builder = new Actions(driver);
//		String text = from.getText();
//		Logger.writeDayLog(Logger.messageType.Pass, "Trying to click control " + text);
//		try {
//			if ((from.isDisplayed()) && (from.isEnabled())) {
//				Logger.writeDayLog(Logger.messageType.Pass,
//						"Control is Displayed and Enabled to drag " + from.getText());
//				if ((to.isDisplayed()) && (to.isEnabled())) {
//					Logger.writeDayLog(Logger.messageType.Pass,
//							"Control is Displayed and Enabled to drop " + to.getText());
//					Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
//					dragAndDrop.perform();
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Control is Drag and Dropped to " + to.getText());
//				} else {
//					Logger.writeDayLog(Logger.messageType.Pass, "Waiting for control to enabled " + to.getText());
//					waitForControl(to);
//					Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
//					dragAndDrop.perform();
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Control is Drag and Dropped to " + to.getText());
//				}
//			} else {
//				Logger.writeDayLog(Logger.messageType.Pass, "Waiting for control to enabled " + from.getText());
//				waitForControl(from);
//				if ((to.isDisplayed()) && (to.isEnabled())) {
//					Logger.writeDayLog(Logger.messageType.Pass,
//							"Control is Displayed and Enabled to drop " + to.getText());
//					Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
//					dragAndDrop.perform();
//					status = true;
//					Logger.writeDayLog(Logger.messageType.Pass, "Control is Drag and Dropped to " + to.getText());
//				} else {
//					Logger.writeDayLog(Logger.messageType.Pass, "Waiting for control to enabled " + to.getText());
//					waitForControl(to);
//					Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
//					dragAndDrop.perform();
//					status = false;
//					Logger.writeDayLog(Logger.messageType.Pass, "Control is Drag and Dropped to " + to.getText());
//				}
//			}
//		} catch (Exception e) {
//			Logger.writeDayLog(Logger.messageType.Exception,
//					"Not able to drag and drop control in given time span " + text + e.getStackTrace());
//			status = false;
//		}
//		return status;
//	}
//
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static void waitUntilElementDisplayed(final WebElement webElement) {
//		GlobalVariable.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(GlobalVariable.driver, TIMEOUT);
//		ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
//			public Boolean apply(WebDriver arg0) {
//				try {
//					webElement.isDisplayed();
//					return true;
//				} catch (NoSuchElementException e) {
//					return false;
//				} catch (StaleElementReferenceException f) {
//					return false;
//				}
//			}
//		};
//		wait.until(elementIsDisplayed);
//		GlobalVariable.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}
//}
