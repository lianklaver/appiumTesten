package IOSSimulatorWithNativeApp;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.*;
import org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class BasicStartSimulatorAndStartApp {

	private WebDriver driver;

	  @Before
	  public void setUp() throws Exception {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		    
		capabilities.setCapability("deviceName", "iPhone 7");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		//location of app on mac
		capabilities.setCapability("app", "/Users/lianne/Documents/UICatalog.app");
		
		//start appium wit 127.0.0.1 $& 4723
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    
	  }
	  
	  @Test
	  public void testClickerdeClick() throws Exception {
	  
		  MobileElement el1 = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]"));
		  assertTrue(el1.isDisplayed());
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}