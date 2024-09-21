package com.waits;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.reports.ExtentFactory;

public class ExplicitWaitActions {
	
	private Logger logger = LogManager.getLogger(ExplicitWaitActions.class);
	
	public void WaitForElementToBePresent(WebElement element, String elementName) {
		try {
			WebDriver driver = DriverFactory.GetInstance().GetDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info(elementName+" is avaialble on screen");
		} catch (Exception e) {
			logger.error("Exception occured while waiting for the eleement to be visible "+e.getMessage());
			ExtentFactory.GetInstance().ClickFail("Exception occured while waiting for the eleement to be visible");
		}
	}
	
	public void WiatForElementToBeClickable(WebElement element, String elementName) {
		try {
			WebDriver driver = DriverFactory.GetInstance().GetDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			logger.info(elementName+" is clickable on screen");
		} catch (Exception e) {
			logger.error("Exception occured while waiting for the element to be clickable "+e.getMessage());
			ExtentFactory.GetInstance().ClickFail("Exception occured while waiting for the element to be clickable");
		}
	}

}
