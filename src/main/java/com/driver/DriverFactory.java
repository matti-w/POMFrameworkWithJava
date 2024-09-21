package com.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//To Support parallel execution
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	//Singleton pattern (only create one instance of a class)
	private DriverFactory() {
		
	}
	
	//Create object of this class. It can not be accessed out side this class
	private static DriverFactory instance = new DriverFactory();
	
	//Returns the object of this class to be used through out the project (DriverFactory.GetInstance)
	public static DriverFactory GetInstance() {
		return instance;
	}
	
	// add driver to driver thread pool
	public void SetDriver(WebDriver driverObj) {
		driver.set(driverObj);
	}
	
	// get driver from thread pool
	public WebDriver GetDriver() {
		return driver.get();
	}

}
