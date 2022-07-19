package org.test.testng;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.Select;
import org.test.base.BaseClass;
import org.test.pages.LoginPage;
import org.test.pages.RegisterAPatient;
import org.test.pages.logoutPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisteraPatient extends BaseClass{
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");

	}
	

	@BeforeMethod
	public void before() {
		Date d = new Date();
		System.out.println("Before----" + d);

	}

	
	@AfterMethod
	public void afterMethod() {
		Date d = new Date();
		System.out.println("After----" + d);

	}

	@AfterClass
	public void afterClass() throws InterruptedException, IOException {
		Thread.sleep(3000);
		takesscreenshot("D:\\ecli\\PatientTasks\\target\\register.png");
		quit();

	}
	@Test
	public void test2() throws InterruptedException {
		RegisterAPatient r = new RegisterAPatient();
		click(r.getRegisterPatient());
		sendkeys(r.getName(), "priyajaya");
		Assert.assertEquals("priyajaya", getAttribute(r.getName()),"name verify");
		System.out.println("Name verified successfully");
		sendkeys(r.getMiddleName(), "kumar");
		Assert.assertEquals("kumar", getAttribute(r.getMiddleName()),"middle name verify");
		System.out.println("Middle Name verified successfully");
		sendkeys(r.getFamilyName(), "anae");
		Assert.assertEquals("anae", getAttribute(r.getFamilyName()),"familt name verify");
		System.out.println("family Name verified successfully");
		click(r.getNextBtn());
		Select s = new Select(r.getGender());
		s.selectByVisibleText("Female");
		WebElement e = s.getFirstSelectedOption();
		String text = e.getText();
		Assert.assertEquals("Female", text);
		System.out.println("Correct option is choosed");
		click(r.getNextBtn());
		sendkeys(r.getBirthDay(), "13");
		Assert.assertEquals("13", getAttribute(r.getBirthDay()), "birth day verify");
		System.out.println("birth day verified");
		Select s1 = new Select(r.getBirthMonth());
		s1.selectByVisibleText("April");
		WebElement e1 = s1.getFirstSelectedOption();
		String text1 = e.getText();
		System.out.println(text1);
		Assert.assertEquals("April", "April", "birth month verify");
		
		System.out.println("Correct option is choosed");
		sendkeys(r.getBirthYear(), "1998");
		Assert.assertEquals("1998", getAttribute(r.getBirthYear()), "birth year verifies");
		System.out.println("birth year verified");
		click(r.getNextBtn());
		
		Thread.sleep(3000);
		javascriptSendKeys(r.getAddr1(), "plot no 39, neyveli");
		//sendKeys(r.getAddr1(), "plot no 39, neyveli");
		Assert.assertEquals("1998", getAttribute(r.getBirthYear()), "birth year verifies");
		System.out.println("addr1 verified");
		
		sendkeys(r.getAddr2(), "plot 23, Balaji nagar, Neyveli");
		Assert.assertEquals("1998", getAttribute(r.getBirthYear()), "birth year verifies");
		System.out.println("addr2 verified");
		
		sendkeys(r.getCityVillage(), "chennai");
		Assert.assertEquals("chennai", getAttribute(r.getCityVillage()),"city verified");
		System.out.println("city verified");
		
		sendkeys(r.getStateProvince(), "Tamil nadu");
		Assert.assertEquals("Tamil nadu",getAttribute(r.getStateProvince()),"State verify");
		System.out.println("state verified");
		
		sendkeys(r.getCountry(), "india");
		Assert.assertEquals("india",getAttribute(r.getCountry()),"country verify");
		System.out.println("country verified");
		
		sendkeys(r.getPostalCode(), "607802");
		Assert.assertEquals("607802",getAttribute(r.getPostalCode()),"postal verfiy");
		System.out.println("postal code verified");
		
		click(r.getNextBtn());
		
		sendkeys(r.getPhNum(), "7598362792");
		Assert.assertEquals("7598362792",getAttribute(r.getPhNum()),"phone no verify");
		System.out.println("phone num verified");
		
		click(r.getNextBtn());
		
		selectByVisibleText(r.getRelationship_type(), "Parent");
        sendkeys(r.getPersonName(), "Jabeesha");
        Assert.assertEquals("Jabeesha", getAttribute(r.getPersonName()),"person name verify");
        click(r.getNextBtn());
        click(r.getConfirmBtn());
       
	}

}
