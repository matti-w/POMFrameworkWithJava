package com.base;

import org.openqa.selenium.WebElement;

import com.alert.AlertActions;
import com.javascript.JavaScriptActions;
import com.reports.ExtentFactory;
import com.waits.ExplicitWaitActions;

public class BasePage {
	
	protected AlertActions alertActions;
	
	protected JavaScriptActions javaScriptActions;
	
	protected ExplicitWaitActions explicitWaitActions;
	
	protected BasePage() {
		alertActions = new AlertActions();
		javaScriptActions = new JavaScriptActions();
		explicitWaitActions = new ExplicitWaitActions();
	}
	
	
	public void Click(WebElement element, String elementName) {
		explicitWaitActions.WiatForElementToBeClickable(element, elementName);
		element.click();
		ExtentFactory.GetInstance().PassTest(elementName+" is clicked.");
	}
	
	public void Sendkeys(WebElement element, String elementName, String value) {
		explicitWaitActions.WaitForElementToBePresent(element, elementName);
		element.clear();
		element.sendKeys(value);
		ExtentFactory.GetInstance().PassTest(value+ " is entered in "+elementName);
		
	}
	
	public boolean IsElementSelected(WebElement element, String elementName) {
		explicitWaitActions.WaitForElementToBePresent(element, elementName);
		return	element.isSelected();
	}
	
	public void SelectCheckBox(WebElement element, String elementName) {
		
		if(this.IsElementSelected(element, elementName) == false) {
			this.Click(element, elementName);
		}
		
		else {
			ExtentFactory.GetInstance().FailTest(elementName+ " is already selected");
		}
		
	}

}
