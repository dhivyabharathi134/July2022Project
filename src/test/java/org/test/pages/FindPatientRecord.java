package org.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.base.BaseClass;

public class FindPatientRecord extends BaseClass{
public FindPatientRecord() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[contains(@id,'oreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension')]")
private WebElement findRecords;

@FindBy(xpath="//input[@id='patient-search']")
private WebElement searchBox;

@FindBy(xpath="//tr[@class='odd']")
private WebElement data;

public WebElement getFindRecords() {
	return findRecords;
}

public WebElement getSearchBox() {
	return searchBox;
}

public WebElement getData() {
	return data;
}
}
