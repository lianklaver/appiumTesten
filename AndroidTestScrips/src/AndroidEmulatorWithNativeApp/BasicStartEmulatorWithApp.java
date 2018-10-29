package AndroidEmulatorWithNativeApp;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasicStartEmulatorWithApp {

	 private WebDriver driver;

	  @Before
	  public void setUp() throws Exception {	  
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
	    //setup to start emulator
	    capabilities.setCapability("deviceName", "Android Emulator");
	    capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("platformVersion", "7.1.1");
	    
	    //location of app on mac
	    capabilities.setCapability("app", "/Users/lianne/Documents/calculator.apk");
		
	    // Start Appium with 127.0.0.1 & 4723
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  }

	  @Test
	  public void testCalcDisplayIsVisible() throws Exception {
		  MobileElement el1 = (MobileElement) driver.findElement(By.id("net.tecnotopia.SimpleCalculator:id/display"));
		  assertTrue(el1.isDisplayed());
	  }
	  
	  @Test
	  public void testCalcEqualsButtonIsVisible() throws Exception {
		  MobileElement el2 = (MobileElement) driver.findElement(By.id("net.tecnotopia.SimpleCalculator:id/buttonEquals"));
		  assertTrue(el2.isDisplayed());
	  }
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}
