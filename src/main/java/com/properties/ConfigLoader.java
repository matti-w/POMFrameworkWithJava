package com.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Constants;
import com.reports.ExtentFactory;

public class ConfigLoader {
	
	private Logger logger = LogManager.getLogger(ConfigLoader.class);
	
	private Properties prop;
	
	private ConfigLoader() {
		FileReader reader = null;
		try {
			reader = new FileReader(Constants.CONFIG_FILE_PATH);
		} catch (FileNotFoundException e) {
			logger.error("Exception occured while reader config file");
			ExtentFactory.GetInstance().FailTest("Exception occured while reader config file");
		}
		prop = new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Constants.EXECUTION_ENV = GetEnv();
		
	}
	
	private static ConfigLoader instance = new ConfigLoader();
	
	public static ConfigLoader GetInstnace() {
		return instance;
	}
	
	private String getPropertyValue(String key) {
		
		return prop.getProperty(key);
		
	}
	
	public String GetBrowser() {
		return this.getPropertyValue("browser");
	}
	
	public String GetAppUrl() {
		return this.getPropertyValue("app_url");
	}
	
	public String GetUserName() {
		return this.getPropertyValue("username");
	}
	
	public String GetPassword() {
		return this.getPropertyValue("password");
	}
	
	public String GetEnv() {
		return this.getPropertyValue("environment");
	}


}
