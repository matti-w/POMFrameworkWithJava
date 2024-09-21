package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.constants.Constants;
import com.driver.BrowserFactory;
import com.driver.DriverFactory;
import com.properties.ConfigLoader;

public class BaseTest {

	@BeforeSuite
	public void SetUp() {
		WebDriver driver = BrowserFactory.CreateBrowserInstance(ConfigLoader.GetInstnace().GetBrowser());
		DriverFactory.GetInstance().SetDriver(driver);
		DriverFactory.GetInstance().GetDriver().manage().deleteAllCookies();
		DriverFactory.GetInstance().GetDriver().manage().window().maximize();
		DriverFactory.GetInstance().GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		DriverFactory.GetInstance().GetDriver().get(ConfigLoader.GetInstnace().GetAppUrl());


	}
	
	@AfterSuite
	public void TearDown() {
		DriverFactory.GetInstance().GetDriver().quit();
		
	}
}
