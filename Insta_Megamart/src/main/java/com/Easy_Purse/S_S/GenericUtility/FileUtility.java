package com.Easy_Purse.S_S.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	    public String getDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\PropFile.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}

}
