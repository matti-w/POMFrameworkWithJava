package com.alert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.driver.DriverFactory;
import com.reports.ExtentFactory;

public class AlertActions {
	
	private Logger logger = LogManager.getLogger(AlertActions.class);
	
	private Alert alert;
	
	public void SwithcToAlert() {
		
		
		try {
			alert = DriverFactory.GetInstance().GetDriver().switchTo().alert();
			logger.info("Swicthed to alert.");
			ExtentFactory.GetInstance().PassTest("Swicthed to Alert");
		} catch (NoAlertPresentException e) {
			logger.error("Exception occured while swicthing to alert.");
			ExtentFactory.GetInstance().FailTest("Exception occured while swicthing to alert.");
		}
		
	}
	
	public void AcceptAlert() {
		
		try {
			this.alert.accept();
			logger.info("Clicked on OK button");
			ExtentFactory.GetInstance().PassTest("Clicked on OK button");
		} catch (Exception e) {
			logger.error("Exception occured while clicking On OK button.");
			ExtentFactory.GetInstance().FailTest("Exception occured while clicking On OK button.");
		}
		
	}
	
	public void CancelAlert() {
		
		try {
			this.alert.dismiss();
			logger.info("Clicked on cancel button");
			ExtentFactory.GetInstance().PassTest("Clicked on cancel button");
		} catch (Exception e) {
			logger.error("Exception occured while clicking On cancel button.");
			ExtentFactory.GetInstance().FailTest("Exception occured while clicking On cancel button.");
		}
	}

}
