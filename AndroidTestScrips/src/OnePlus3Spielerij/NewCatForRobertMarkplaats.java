package OnePlus3Spielerij;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NewCatForRobertMarkplaats {

	private WebDriver driver;
	private String baseUrl;

	  @Before
	  public void setUp() throws Exception {	  
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
	    //opens OnePlus3 with Chrome
	    capabilities.setCapability("deviceName", "Android Emulator");
	    capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("platformVersion", "7.1.1");
	    capabilities.setCapability("browserName", "Chrome");
	    
	    baseUrl = "https://www.marktplaats.nl";
		//start Appium with 127.0.0.1 & 4723
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	    
	  }

	  @Test 
	  public void testOpenMarkplaats() throws Exception {
		  
		  //opening Marktplaats website and title check
		  driver.get(baseUrl);
		  System.out.println("url geopend");
		  assertEquals(driver.getTitle(), "≥ Marktplaats - Cookiewall"); 
		  
	  }
	 
	  @Test
	  public void testCookieAccepted() throws Exception {
		  
		  //opening Marktplaats website and title check
		  driver.get(baseUrl);
		  System.out.println("url geopend");
		  //assertEquals(driver.getTitle(), "≥ Marktplaats - Cookiewall");  
		  
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("track-accept")));
		  System.out.println("waited");
		  
		  // click on cookie button and title check
		  RemoteWebElement el1 = driver.findElement(By.className("button"));
		  System.out.println("element opgeslagen");
		  el1.click();
		  System.out.println("coockie weggeklikt");
		  //assertEquals(driver.getTitle(), "≥ Marktplaats - De plek om nieuwe en tweedehands spullen te kopen en verkopen");
		  
		  //remove translate question
		  //RemoteWebElement el2 = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Close\"]"));
		  //el2.click();
		  
		  // insert search "zwart kat Almere"
		  RemoteWebElement el4 = driver.findElement(By.id("input"));
		  wait.until(ExpectedConditions.visibilityOf(el4));
		  el4.click();
		  //RemoteWebElement el4 = driver.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"≥ Marktplaats - De plek om nieuwe en tweedehands spullen te kopen en verkopen\"]/android.view.View[1]/android.view.View[2]/android.widget.EditText"));
		  el4.sendKeys("zwart kat");
		  
		  //insert postal code 1335VL
		  RemoteWebElement el5 = driver.findElement(By.name("postcode"));
		  wait.until(ExpectedConditions.visibilityOf(el5));
		  //RemoteWebElement el5 = driver.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"≥ Marktplaats - De plek om nieuwe en tweedehands spullen te kopen en verkopen\"]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.EditText"));
		  el5.sendKeys("1335 vl");
		  
		  //select less then 5 km
		  driver.findElement(By.name("distance")).click();
		  RemoteWebElement el7 = driver.findElement(By.xpath("/html/body/mp-header/div[1]/div[3]/div/form/div[2]/div[3]/div/select/option[3]")); 
		  el7.click();
		  
		  //click on search
		  RemoteWebElement el6 = driver.findElement(By.className("mp-SearchForm-search"));
		  el6.click();
		  
		  
	  }

	  @After
	  public void tearDown() throws Exception {
	    //driver.quit();
	  }
}