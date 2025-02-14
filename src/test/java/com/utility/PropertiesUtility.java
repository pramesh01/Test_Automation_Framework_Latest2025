package com.utility;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtility {
	
	public static String readPropertiesUtility(Env env,String proprtyName) {
		
		Properties prop=new Properties();
		File filePath=new File(System.getProperty("user.dir")+"//config//"+env+".properties");
		try {
			FileReader fileReader=new FileReader(filePath);
			prop.load(fileReader);
		} catch (Exception e) {
			e.getMessage();
		} 
		String value=prop.getProperty(proprtyName.toUpperCase());
		return value;
	}

}
