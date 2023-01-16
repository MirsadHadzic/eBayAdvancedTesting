package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class addvancedTest {

	private static WebDriver webDriver;
	private static String baseUrl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anes\\Documents\\ChromeWebDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments ("--start-maximized");
		options.addArguments ("--user-data-dir=C:\\Users\\Anes\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
		webDriver = new ChromeDriver (options);
		baseUrl = "https://www.ebay.com/";
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	webDriver.quit();
	}
	@Test
	void testEbay() throws InterruptedException
	{
	webDriver.get(baseUrl);
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) webDriver;
	WebElement cb = webDriver.findElement(By.cssSelector("#items_list1 > div.hl-card-header > div > div.hl-card-header__title > h2 > a"));
	js.executeScript("arguments[0].scrollIntoView(true);", cb);
	Thread.sleep(6000);
	
	// Fetch domain name
	String domainName = js.executeScript("return document.domain;").toString();
	System.out.println (domainName);
	Thread.sleep (2000);
	
	// Fetch current URL
	String url = js.executeScript("return document. URL;").toString();
	System.out.println(url);
	Thread.sleep (2000);
	
	// Fetch page title
	String title = js.executeScript("return document.title;").toString();
	System.out.println(title);
	}
}