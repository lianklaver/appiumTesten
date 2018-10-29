package CMAP_AppiumTests;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File; 

public class Ex_9_iOS_WebTest {


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
		capabilities.setCapability("browserName", "safari");
			  
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		baseUrl = "https://www.google.nl/";
	    
	  }

	  @Test
	  public void testGoogleSearch() throws Exception {
	    //open google.com
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(baseUrl);
		System.out.println("website geopend");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users/lianne/Documents/screenshot.jpg"));
	    //insert iSQI in search balk
	    //driver.findMobileElement(By.id("tsbb")).sendKeys("iSQI");
	    System.out.println("isqi ingevoerd");
	    //click on search
	    //driver.findElement(By.name("btnK")).click();
	    //System.out.println("geklikt");
	    //print search results
	    //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
	    //System.out.println(driver.findElement(By.id("resultStats")).getText());
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}