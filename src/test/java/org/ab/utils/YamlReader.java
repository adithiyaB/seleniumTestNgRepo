package org.ab.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.yaml.snakeyaml.Yaml;

public class YamlReader {

	private static Map<String, Object> data = new HashMap<String, Object>();
	private static Map<String, By> allPageObjects = new HashMap<String, By>();
	private static String parentKey;
	private static By locator;

	public static Map<String, By> getPageObjects() {
		File file = new File("src/test/java/org/ab/pop");
		String files[] = file.list();
		for (int i = 0; i < files.length - 1; i++) {
			yamlParse("src/test/java/org/ab/pop" + "/" + files[i]);
		}
		return allPageObjects;
	}

	public static void yamlParse(String filepath) {
		try {
			Yaml yaml = new Yaml();
			InputStream fis = new FileInputStream(new File(filepath));
			data = yaml.load(fis);
			Set<String> keys = data.keySet();
			for (String key : keys) {
				if (data.get(key).getClass().getSimpleName() != "String") {
					parentKey = key;
					@SuppressWarnings("unchecked")
					Map<String, Object> tmpData = (Map<String, Object>) data.get(key);
					Set<String> subKeys = tmpData.keySet();
					for (String subKey : subKeys) {
						getLocator(parentKey, subKey, tmpData.get(subKey));
//						locator = By.xpath(data.get(key).toString());
					}
				} else {
					getLocator(parentKey, key, data.get(key));
//					locator = By.xpath(data.get(key).toString());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void getLocator(String parentKey, String key, Object objLocator) {
		switch (parentKey) {
		case "xpath":
			locator = By.xpath(objLocator.toString());
			break;
		case "id":
			locator = By.id(objLocator.toString());
			break;
		case "name":
			locator = By.name(objLocator.toString());
			break;
		case "css":
			locator = By.cssSelector(objLocator.toString());
			break;
		case "tagName":
			locator = By.tagName(objLocator.toString());
			break;
		case "linkText":
			locator = By.linkText(objLocator.toString());
			break;
		case "className":
			locator = By.className(objLocator.toString());
			break;
		case "partialLinkText":
			locator = By.partialLinkText(objLocator.toString());
			break;
		}
		allPageObjects.put(key, locator);
		
	}

	public static void main(String[] args) {
		getPageObjects();
	}
}
