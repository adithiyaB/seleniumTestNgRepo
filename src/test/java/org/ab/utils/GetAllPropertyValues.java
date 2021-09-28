package org.ab.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class GetAllPropertyValues {
	private static FileInputStream fis;
	private static Map<String, String> map = new HashMap<String, String>();

	public static Map<String, String> allPropertyValues(String filepath) {
		Properties prop = new Properties();

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

		Set<Object> set = prop.keySet();
		for (Object o : set) {
			String key = (String) o;
			map.put(key, prop.getProperty(key));
		}
		return map;
	}

}
