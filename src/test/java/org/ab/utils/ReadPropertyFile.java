package org.ab.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class ReadPropertyFile {
	private static FileInputStream fis;

	public static String getPropertyValue(String filepath, String key) {
		Properties prop = new Properties();
		String value = "";

		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		value = prop.getProperty(key);
		System.out.println(value);
		Assert.assertNotNull(value, "Key " + key + " not found in the property file");
		return value;
	}

}
