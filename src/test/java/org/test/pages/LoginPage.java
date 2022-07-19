package org.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.base.BaseClass;

public class LoginPage extends BaseClass {
public LoginPage() {
	PageFactory.initElements(driver, this);
}

@FindBy(id="username")
private WebElement username;

@FindBy(id="password")
private WebElement password;

@FindBy(xpath="//li[text()='Inpatient Ward']")
private WebElement location;

@FindBy(id="loginButton")
private WebElement loginBtn;

public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLocation() {
	return location;
}

public WebElement getLoginBtn() {
	return loginBtn;
}

}
