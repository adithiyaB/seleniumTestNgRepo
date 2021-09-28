package org.ab.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {}

	private static final String CHROMEDRIVERPATH = "src/main/resources/drivers/chromedriver.exe";
	private static final String IEDRIVERPATH = "src/main/resources/drivers/IEDriverServer.exe";
	private static final String GECKODRIVERPATH = "src/main/resources/drivers/geckodriver.exe";
	private static final String EDGEDRIVERPATH = "src/main/resources/drivers/msedgedriver.exe";
	private static final String CONFIGFILEPATH = "src/test/resources/config/config.properties";
	private static final String pageObjectsPath = "src/test/java/org/ab/pop/";
	
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getIedriverpath() {
		return IEDRIVERPATH;
	}

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}

	public static String getEdgedriverpath() {
		return EDGEDRIVERPATH;
	}
	
	public static String getPageObjectsPath() {
		return pageObjectsPath;
	}
}
