package org.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.base.BaseClass;

public class logoutPage extends BaseClass{
public logoutPage() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//li[@class='nav-item logout']")
private WebElement logoutBtn;
public WebElement getLogoutBtn() {
	return logoutBtn;
}

}
