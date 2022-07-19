package org.test.testng;

import java.io.IOException;
import java.util.Date;

import org.test.base.BaseClass;
import org.test.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login extends BaseClass{
@BeforeClass
public static void beforeClass() {
	browserLaunch("chrome");
	impWait(10);
	urlLaunch("https://demo.openmrs.org/openmrs/");

}

@BeforeMethod
public void before() {
	Date d = new Date();
	System.out.println("Before----" + d);

}

@Test(priority=-2, invocationCount=1, groups= {"smoke","sanity"})
private void test() throws InterruptedException {
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

@AfterMethod
public void afterMethod() {
	Date d = new Date();
	System.out.println("After----" + d);

}

@AfterClass
public void afterClass() throws IOException {
	takesscreenshot("D:\\ecli\\PatientTasks\\target\\login.png");
	System.out.println("after class");

}
}
