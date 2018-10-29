package CMAP_AppiumTests;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Ex_15_Android_NativeTest {

	 private WebDriver driver;
	 private String baseUrl;

	  @Before
	  public void setUp() throws Exception {	  
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
	    capabilities.setCapability("deviceName", "Android Emulator");
	    capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("platformVersion", "7.1.1");
	    capabilities.setCapability("app", "/Users/lianne/Documents/calculator.apk");
		  
		baseUrl = "https://www.google.nl/";
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		// van test browsers:   
		//System.setProperty("webdriver.gecko.driver", "/Users/lianne/Documents/workspace2/geckodriver");
		//System.setProperty("webdriver.chrome.driver", "/Users/lianne/Documents/workspace2/chromedriver");
		//driver = new FirefoxDriver(); 
	    //driver = new SafariDriver();
		//driver = new ChromeDriver();
		
	    
	  }

	  @Test
	  public void testGoogleSearch() throws Exception {
	    //open google.com
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		  
		driver.get(baseUrl);
		System.out.println("url geopend");
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("/Users/lianne/Documents/screenshot.jpg"));
		
	    //insert iSQI in search balk
	    //driver.findElement(By.id("lst-ib")).sendKeys("iSQI");
	    //System.out.println("element gevonden");
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