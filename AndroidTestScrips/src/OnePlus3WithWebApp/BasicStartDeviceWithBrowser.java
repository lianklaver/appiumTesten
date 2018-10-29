package OnePlus3WithWebApp;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasicStartDeviceWithBrowser {

	 private WebDriver driver;
	 private String baseUrl;

	  @Before
	  public void setUp() throws Exception {	  
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
	    //opens OnePlus3 with Chrome
	    capabilities.setCapability("deviceName", "ecc2e2eb");
	    capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("platformVersion", "7.1.1");
	    capabilities.setCapability("browserName", "Chrome");
		  
		baseUrl = "https://www.google.nl/";
		//start Appium with 127.0.0.1 & 4723
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	    
	  }

	  @Test
	  public void testGoogleSearch() throws Exception {
	    
		driver.get(baseUrl);
		System.out.println("url geopend");
		assertEquals(driver.getTitle(), "Google");
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}