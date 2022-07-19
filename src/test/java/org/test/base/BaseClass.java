package org.test.base;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public static WebDriver driver;
	public static Actions a;
	public static Select s;

	public static void browserLaunch(String browserName) {
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if(browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}

	}

	public static void urlLaunch(String url) {
		driver.get(url);

	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public static void quit() {
		driver.quit();

	}

	public static void close() {
		driver.close();

	}
	public static void sendkeys(WebElement e, String data) {
		e.sendKeys(data);

	}

	public static void impWait(int sec) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public static void MoveToElement(WebElement e) {
		a = new Actions(driver);
		a.moveToElement(e).perform();
		

	}

	public static void rightClick(WebElement e) {
		a = new Actions(driver);
		a.contextClick(e).perform();

	}

	public static void dragAndDrop(WebElement from, WebElement to) {
		a = new Actions(driver);
		a.dragAndDrop(from, to);

	}

	public static void DragHoldAndDrop(WebElement from, WebElement to) {
		a = new Actions(driver);
		a.clickAndHold(from).moveToElement(to).release().perform();

	}

	public static void doubleClick(WebElement e) {
		a = new Actions(driver);
		a.doubleClick(e).perform();

	}

	public static void simpleAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	public static void confirmAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}
	public static String getTextFromAlert(WebElement e) {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		return text;

	}

	public static void alertSendKeys(String data) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(data);

	}



	public static void promptAlert(String data) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(data);

	}
	public static void click(WebElement e) {
		e.click();

	}

	public static String getAttribute(WebElement e) {
		String data = e.getAttribute("value");
		return data;

	}
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;

	}

	public static void selectByIndex(WebElement e, int in) {
		s = new Select(e);
		s.selectByIndex(in);

	}

	public static void selectByvalue(String data, WebElement e) {
		s = new Select(e);
		s.selectByValue(data);

	}

	public static void selectByVisibleText(WebElement e, String data) {
		s = new Select(e);
		s.selectByVisibleText(data);

	}

	public static void deselectAll(WebElement e) {
		s = new Select(e);
		s.deselectAll();

	}

	public static void deselectByIndex(WebElement e, int in) {
		s = new Select(e);
		s.deselectByIndex(in);

	}

	public static void deselectByValue(WebElement e, String data) {
		s = new Select(e);
		s.deselectByValue(data);

	}

	public static void deselectByVisibleText(WebElement e, String data) {
		s = new Select(e);
		s.deselectByVisibleText(data);

	}

	public static WebElement getFirstSelectedOptions(WebElement e) {
		s = new Select(e);
		WebElement first = s.getFirstSelectedOption();
		return first;
		
	}
	public static List<WebElement> getOptions(WebElement e) {
		s = new Select(e);
		List<WebElement> options = s.getOptions();
		return options;

	}
	
	public static void takesscreenshot(String name) throws IOException {
		TakesScreenshot sh = (TakesScreenshot)driver;
		File from = sh.getScreenshotAs(OutputType.FILE);
		File to = new File(name);
		FileUtils.copyFile(from, to);

	}
	public static void javascriptSendKeys(WebElement e, String data) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+data+"')", e);

	}
}
