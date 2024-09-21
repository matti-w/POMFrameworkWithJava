package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.properties.ConfigLoader;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginWithValidUserNameAndValidPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage();

		loginPage.loginToApplication(ConfigLoader.GetInstnace().GetUserName(),
				ConfigLoader.GetInstnace().GetPassword());
		
		Assert.assertFalse(true);

	}

}
