package com.constants;

public abstract class Constants {

	public static final String CURRENT_DIR = System.getProperty("user.dir");
	
	public static final String REPORT_PATH = CURRENT_DIR + "/reports/execution.html";
	
	public static final int EXPLICIT_WAIT = 20;
	
	public static final String CONFIG_FILE_PATH = CURRENT_DIR + "/src/test/resources/execution/config.properties";
	
	public static String EXECUTION_ENV;
	
	public static final int IMPLICIT_WAIT_TIME = 20;
	
}
