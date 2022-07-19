package org.test.testng;

import java.io.IOException;
import java.util.Date;

import org.test.base.BaseClass;
import org.test.pages.LoginPage;
import org.test.pages.logoutPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logout extends BaseClass{
	@BeforeClass
	public static void beforeClass() {
		browserLaunch("chrome");
		impWait(10);
		urlLaunch("https://demo.openmrs.org/openmrs/login.htm");


	}
	@Test
	private void test1() throws InterruptedException {
		LoginPage li = new LoginPage();
		sendkeys(li.getUsername(), "Admin");
		Assert.assertEquals("Admin", getAttribute(li.getUsername()), "username verify");
		System.out.println("username verified");
	    sendkeys(li.getPassword(), "Admin123");
	    Assert.assertEquals("Admin123",getAttribute(li.getPassword()),"password verify");
	    System.out.println("password verified");
	    click(li.getLocation());
	    click(li.getLoginBtn());
	    Thread.sleep(3000);
	    Assert.assertTrue(driver.getCurrentUrl().contains("home.page"));
	    System.out.println("The user has successfully login the application");
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
	public void afterClass() throws IOException {
		takesscreenshot("D:\\ecli\\PatientTasks\\target\\logout.png");
		quit();

	}
@Test(groups= "smoke")
public void test2() throws InterruptedException {
	logoutPage lo = new logoutPage();
    click(lo.getLogoutBtn());
    Thread.sleep(3000);
    Assert.assertTrue(driver.getCurrentUrl().contains("login.htm"));
    System.out.println("The user has successfully logged out");
}
}
