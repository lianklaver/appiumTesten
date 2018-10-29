package CMAP_SeleniumTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ex_4_Search_iSQI {
	  
	  private WebDriver driver;
	  private String baseUrl;

	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/lianne/Documents/workspace2/geckodriver");
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.google.nl/";
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testGoogleSearch() throws Exception {
	    //open google.com
		driver.get(baseUrl);
	    //insert iSQI in search balk
	    driver.findElement(By.id("lst-ib")).sendKeys("iSQI");
	    //click on search
	    driver.findElement(By.name("btnK")).click();
	    //print search results
	    System.out.println(driver.findElement(By.xpath(".//*[@id='resultStats']")).getText());
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}