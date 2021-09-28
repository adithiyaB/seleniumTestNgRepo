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

	public static void getPageObjects() {
		File file = new File("src/test/java/org/ab/pop");
		String files[] = file.list();
		for (int i = 0; i < files.length; i++) {
			yamlParse("src/test/java/org/ab/pop" + "/" + files[i]);
		}
	}

	public static void yamlParse(String filepath) {
		try {
			Yaml yaml = new Yaml();
			InputStream fis = new FileInputStream(new File(filepath));
			data = yaml.load(fis);
			System.out.println("###################################################");
			Set<String> keys = data.keySet();
			System.out.println("keys-----------------------" + keys);
			for (String key : keys) {
				System.out.println(data.get(key).getClass().getSimpleName());
				if (data.get(key).getClass().getSimpleName() != "String") {
					System.out.println("within if");
					parentKey = key;
					@SuppressWarnings("unchecked")
					Map<String, Object> tmpData = (Map<String, Object>) data.get(key);
					System.out.println(tmpData);
					Set<String> subKeys = tmpData.keySet();
					for (String subKey : subKeys) {
						System.out.println("#######"+parentKey+"##############"+subKey+"##############"+tmpData.get(subKey)+"################");
//						getLocator(parentKey, subKey, data.get(subKey));
						locator = By.xpath(data.get(key).toString());
					}
				} else {
					System.out.println("within else");
					System.out.println("#######"+parentKey+"##############"+key+"##############"+data.get(key)+"################");
//					getLocator(parentKey, key, data.get(key));
					locator = By.xpath(data.get(key).toString());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

//	public static void getAllChildKeyValues(Set<String> keys) {
//
////		Set<String> keys = data.keySet();
//		System.out.println("keys-----------------------" + keys);
//		for (String key : keys) {
//				getLocator(parentKey, key, data.get(key));
//		}
//	}

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
		System.out.println(allPageObjects);
	}

	public static void main(String[] args) {
		getPageObjects();
	}
}
