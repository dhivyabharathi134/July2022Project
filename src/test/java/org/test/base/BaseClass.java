package org.test.base;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
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
   public static JavascriptExecutor js;
   
   //1
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

	//2
	public static void urlLaunch(String url) {
		driver.get(url);

	}

	//3
	public static String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	//4
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	//5
	public static void quit() {
		driver.quit();

	}

	//6
	public static void close() {
		driver.close();

	}
	
	//7
	public static void sendkeys(WebElement e, String data) {
		e.sendKeys(data);

	}
	
	//8
	public static void impWait(int sec) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	//9
	public static void MoveToElement(WebElement e) {
		a = new Actions(driver);
		a.moveToElement(e).perform();
		

	}

	//10
	public static void rightClick(WebElement e) {
		a = new Actions(driver);
		a.contextClick(e).perform();

	}

	//11
	public static void dragAndDrop(WebElement from, WebElement to) {
		a = new Actions(driver);
		a.dragAndDrop(from, to);

	}

	//12
	public static void DragHoldAndDrop(WebElement from, WebElement to) {
		a = new Actions(driver);
		a.clickAndHold(from).moveToElement(to).release().perform();

	}

	//13
	public static void doubleClick(WebElement e) {
		a = new Actions(driver);
		a.doubleClick(e).perform();

	}

	//14
	public static void simpleAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	//15
	public static void confirmAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}
	
	//16
	public static String getTextFromAlert(WebElement e) {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		return text;

	}
	
	//17
	public static void alertSendKeys(String data) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(data);

	}

	//18
	public static void promptAlert(String data) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(data);

	}
	//19
	public static void click(WebElement e) {
		e.click();

	}
	
	//20
	public static String getAttribute(WebElement e) {
		String data = e.getAttribute("value");
		return data;

	}
	
	//21
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;

	}

	//22
	public static void selectByIndex(WebElement e, int in) {
		s = new Select(e);
		s.selectByIndex(in);

	}

	//23
	public static void selectByvalue(String data, WebElement e) {
		s = new Select(e);
		s.selectByValue(data);

	}
	
	//24
	public static void selectByVisibleText(WebElement e, String data) {
		s = new Select(e);
		s.selectByVisibleText(data);

	}

	//25
	public static void deselectAll(WebElement e) {
		s = new Select(e);
		s.deselectAll();

	}

	//26
	public static void deselectByIndex(WebElement e, int in) {
		s = new Select(e);
		s.deselectByIndex(in);

	}

	//27
	public static void deselectByValue(WebElement e, String data) {
		s = new Select(e);
		s.deselectByValue(data);

	}

	//28
	public static void deselectByVisibleText(WebElement e, String data) {
		s = new Select(e);
		s.deselectByVisibleText(data);

	}

	//29
	public static WebElement getFirstSelectedOptions(WebElement e) {
		s = new Select(e);
		WebElement first = s.getFirstSelectedOption();
		return first;
		
	}
	
	//30
	public static List<WebElement> getOptions(WebElement e) {
		s = new Select(e);
		List<WebElement> options = s.getOptions();
		return options;

	}
	
	//31	
	public static void takesscreenshot(String name) throws IOException {
		TakesScreenshot sh = (TakesScreenshot)driver;
		File from = sh.getScreenshotAs(OutputType.FILE);
		File to = new File(name);
		FileUtils.copyFile(from, to);

	}

	//32
	public static void javascriptSendKeys(WebElement e, String data) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+data+"')", e);

	}
	
	//33
	public static void javascriptClick(WebElement e) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);

	}
	
	//34
	public static String JavascriptGetAttribute(WebElement e) {
		js = (JavascriptExecutor)driver;
		Object data = js.executeScript("return arguments[0].getAttribute('value')",e);
		String value = data.toString();
		return value;

	}
	
	//35
	public static List<WebElement> getAllSelectedOption(WebElement e) {
		s = new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;

	}
	
	//36
	public static void scrollDown(WebElement e) {
		js.executeScript("arguments[0].scrollIntoView(true)", e);

	}
	
	//37
	public static void scrollUp(WebElement e) {
		js.executeScript("arguments[0].scrollIntoView(false)", e);

	}
	
	//38
	public static void switchFrameUsinIndex(int in) {
		driver.switchTo().frame(in);

	}
	
	//39
	public static void switchFrameUsingId(String id) {
		driver.switchTo().frame(id);
	}
	
	//40
	public static void switchFrameUsingWebElement(WebElement e) {
		driver.switchTo().frame(e);

	}
	
	//41
	public static void switchFrameUsingName(String name) {
		driver.switchTo().frame(name);

	}
	
	//42
	public static void switchOutFrame() {
		driver.switchTo().defaultContent();

	}
	
	//43
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();

	}
	
	//44
	public static void windowHandles(String value) {
		driver.switchTo().window(value);

	}
	
	//45
	public static Set<String> getAllWindowsId() {
	Set<String> windowHandles = driver.getWindowHandles();
	return windowHandles;

	}
	
	//46
	public static String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}
}
