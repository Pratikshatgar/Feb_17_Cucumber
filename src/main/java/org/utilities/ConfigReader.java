package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	
public Properties init_Prop() {
		
		try {
			FileInputStream fis = new FileInputStream(
					"F:\\Acceleration\\workplace\\Feb_17_Cucumber\\src\\test\\resources\\org\\Config\\Config.Properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop;

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}


public String getTestData(String key) {
		
		try {
			FileInputStream fis = new FileInputStream(
					"F:\\Acceleration\\workplace\\Feb_17_Cucumber\\src\\test\\resources\\org\\Config\\Config.Properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
