package CMAP_AppiumTests;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Ex_14_iOS_NativeTest {

	private WebDriver driver;
	 private String baseUrl;

	  @Before
	  public void setUp() throws Exception {
		//System.setProperty("webdriver.gecko.driver", "/Users/lianne/Documents/workspace2/geckodriver");
		//System.setProperty("webdriver.chrome.driver", "/Users/lianne/Documents/workspace2/chromedriver");
		//driver = new FirefoxDriver(); 
	    //driver = new SafariDriver(); //werkt nog niet
		//driver = new ChromeDriver(); 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		    
		capabilities.setCapability("deviceName", "iPhone 7");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("app", "/Users/lianne/Documents/UICatalog.app");
			  
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		baseUrl = "https://www.google.nl/";
	    
	  }

	  
	  @Test
	  public void testClickerdeClick() throws Exception {
		  //MobileElement el1 = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]"));
		  //el1.click();
		  //MobileElement el2 = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Gray\"]"));
		  //el2.click();
	  }
	  
	  public void testWebelement() throws Exception {
		  MobileElement dropdown = (MobileElement) driver.findElement(By.className("ac-gn-menuicon-bread ac-gn-menuicon-bread-top"));
		  dropdown.click();
		  
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}