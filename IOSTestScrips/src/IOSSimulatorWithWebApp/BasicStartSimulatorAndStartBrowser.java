package IOSSimulatorWithWebApp;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class BasicStartSimulatorAndStartBrowser {

	 private WebDriver driver;
	 private String baseUrl;

	  @Before
	  public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//opens right simulator
		capabilities.setCapability("deviceName", "iPhone 7");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("browserName", "safari");
		
		// start appium with 127.0.0.1 & 4723
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		baseUrl = "https://www.google.nl/";
	    
	  }

	  @Test
	  public void testGoogleSearch() throws Exception {
	    //open google.com
		driver.get(baseUrl);
		System.out.println("website geopend");
		assertEquals(driver.getTitle(), "Google"); 
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}