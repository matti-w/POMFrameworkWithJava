package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.driver.DriverFactory;

public class LoginPage extends BasePage{
	
	@FindBy(name = "username")
	private WebElement userNameTextBox;
	
	@FindBy(name = "password")
	private WebElement passwordTExtBox;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(DriverFactory.GetInstance().GetDriver(), this);
	}
	
	public void loginToApplication(String userNameValue, String passwordValue) throws InterruptedException {
		Thread.sleep(3000);
		super.Sendkeys(userNameTextBox, "user name text box", userNameValue);
		Thread.sleep(3000);
		
		super.Sendkeys(passwordTExtBox, "Password text box", passwordValue);
		Thread.sleep(3000);
		super.Click(loginBtn, "Login btn");
		Thread.sleep(3000);
	}

}
