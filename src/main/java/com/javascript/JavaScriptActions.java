package com.javascript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.driver.DriverFactory;
import com.reports.ExtentFactory;

public class JavaScriptActions {
	
	private Logger logger = LogManager.getLogger(JavaScriptActions.class);
	
	public void click(WebElement element) {
		
		try {
			JavascriptExecutor js =(JavascriptExecutor) DriverFactory.GetInstance().GetDriver();
			js.executeScript("arguments[0].click()", element);
			logger.info("Element is clicked");
			ExtentFactory.GetInstance().PassTest("Element is clicked using Javascript");
		} catch (Exception e) {
			logger.error("Exception occured while clicking on element using JS" +e.getMessage() );
			ExtentFactory.GetInstance().FailTest("Exception occured while clicking on element using JS");
		}
		
		
		
	}
	
	public void sendKeys(WebElement element, String value) {
		
		try {
			JavascriptExecutor js =(JavascriptExecutor) DriverFactory.GetInstance().GetDriver();
			js.executeScript("arguments[0].value=" + "'" + value + "'", element);
			
			logger.info(value+ " is entered");
			ExtentFactory.GetInstance().PassTest(value+ " is entered");
		} catch (Exception e) {
			logger.error("Exception occured while entering value using JS" +e.getMessage() );
			ExtentFactory.GetInstance().FailTest("Exception occured while entering value using JS");
		}
	}
	
	public void scrollPageToViewElement(WebElement element) {
		
		try {
			JavascriptExecutor js =(JavascriptExecutor) DriverFactory.GetInstance().GetDriver();
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			
			logger.info("Element is visible on Screen");
			ExtentFactory.GetInstance().PassTest("Element is visible on Screen");
		} catch (Exception e) {
			logger.error("Exception occured while scrolling the page " +e.getMessage() );
			ExtentFactory.GetInstance().FailTest("Exception occured while scrolling the page ");
		}
	}
	
	public void scrollTillEndOfPage() {
		
		try {
			JavascriptExecutor js =(JavascriptExecutor) DriverFactory.GetInstance().GetDriver();
			js.executeScript("window.scrollTo(0 , document.body.scrollHeight)");
			
			logger.info("Page is scrolled till end");
			ExtentFactory.GetInstance().PassTest("Page is scrolled till end");
		} catch (Exception e) {
			logger.error("Exception occured while scrolling the page till end " +e.getMessage() );
			ExtentFactory.GetInstance().FailTest("Exception occured while scrolling the page till end ");
		}
	}

}
