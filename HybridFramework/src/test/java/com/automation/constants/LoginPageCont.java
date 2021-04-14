package com.automation.constants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageCont {

	public @FindBy(id="Email") WebElement uname;
	
	public @FindBy(id="EmployeePassword") WebElement pwd;
}
