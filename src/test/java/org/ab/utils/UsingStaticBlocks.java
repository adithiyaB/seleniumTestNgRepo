package org.ab.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class UsingStaticBlocks {
	
	public static Properties prop = new Properties();
	public static final Map<Object,Object> CONFIGMAP= new HashMap<Object,Object>();
	public static int counter =0;
	
	static {
		System.out.println("2");
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("3");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1");
		System.out.println(prop.getProperty("qa"));
		
		prop.entrySet().forEach(entry -> System.out.println(String.valueOf(++counter) + entry));
		
		for(Entry<Object, Object> entry:prop.entrySet()) {
			System.out.println(++counter + entry.getKey().toString() +entry.getValue().toString());
		}
		
		
	}

}
