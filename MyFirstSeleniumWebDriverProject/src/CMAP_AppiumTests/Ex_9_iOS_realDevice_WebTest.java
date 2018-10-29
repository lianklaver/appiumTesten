package CMAP_AppiumTests;

import static org.junit.Assert.*;

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
import io.appium.java_client.remote.MobileCapabilityType;

public class Ex_9_iOS_realDevice_WebTest {

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
		    
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 6s Plus");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.3");
		capabilities.setCapability(MobileCapabilityType.UDID,"d80e2ad22d0bbe056b1b92ba4476a98deb5ccd5c");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
			  
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		baseUrl = "https://www.google.nl/";
	    
	  }

	  @Test
	  public void testGoogleSearch() throws Exception {
	    //open google.com
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(baseUrl);
		System.out.println("website geopend");
	    //insert iSQI in search balk
	    driver.findElement(By.id("lst-ib")).sendKeys("iSQI");
	    System.out.println("isqi ingevoerd");
	    //click on search
	    driver.findElement(By.name("btnK")).click();
	    System.out.println("geklikt");
	    //print search results
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
	    System.out.println(driver.findElement(By.id("resultStats")).getText());
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}