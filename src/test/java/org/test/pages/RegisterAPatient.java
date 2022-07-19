package org.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.base.BaseClass;

public class RegisterAPatient extends BaseClass{
public RegisterAPatient() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[contains(@id,'referenceapplication-registrationapp')]")
private WebElement registerPatient;

@FindBy(name="givenName")
private WebElement name;

@FindBy(name="middleName")
private WebElement middleName;

@FindBy(name="familyName")
private WebElement familyName;

@FindBy(xpath="//button[@id='next-button']")
private WebElement nextBtn;

@FindBy(name="gender")
private WebElement gender;

@FindBy(name="birthdateDay")
private WebElement birthDay;

@FindBy(name="birthdateMonth")
private WebElement birthMonth;

@FindBy(name="birthdateYear")
private WebElement birthYear;

@FindBy(xpath="//input[@id='submit']")
private WebElement confirmBtn;

@FindBy(xpath="//input[@id='address1']")
private WebElement addr1;

@FindBy(xpath="//input[@id='address2']")
private WebElement addr2;

@FindBy(xpath="//input[@id='cityVillage']")
private WebElement cityVillage;

@FindBy(xpath="//input[@id='stateProvince']")
private WebElement stateProvince;

@FindBy(xpath="//input[@id='country']")
private WebElement country;

@FindBy(xpath="//input[@id='postalCode']")
private WebElement postalCode;

@FindBy(name="phoneNumber")
private WebElement phNum;

public WebElement getPhNum() {
	return phNum;
}

@FindBy(name="relationship_type")
private WebElement relationship_type;

@FindBy(xpath="//input[contains(@class,'person-typeahead ng')]")
private WebElement personName;

public WebElement getRelationship_type() {
	return relationship_type;
}

public WebElement getPersonName() {
	return personName;
}

public WebElement getAddr1() {
	return addr1;
}

public WebElement getAddr2() {
	return addr2;
}

public WebElement getCityVillage() {
	return cityVillage;
}

public WebElement getStateProvince() {
	return stateProvince;
}

public WebElement getCountry() {
	return country;
}

public WebElement getPostalCode() {
	return postalCode;
}

public WebElement getRegisterPatient() {
	return registerPatient;
}

public WebElement getName() {
	return name;
}

public WebElement getMiddleName() {
	return middleName;
}

public WebElement getFamilyName() {
	return familyName;
}

public WebElement getNextBtn() {
	return nextBtn;
}

public WebElement getGender() {
	return gender;
}

public WebElement getBirthDay() {
	return birthDay;
}

public WebElement getBirthMonth() {
	return birthMonth;
}

public WebElement getBirthYear() {
	return birthYear;
}

public WebElement getConfirmBtn() {
	return confirmBtn;
}
}
