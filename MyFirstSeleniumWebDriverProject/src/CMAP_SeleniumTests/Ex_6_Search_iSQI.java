package CMAP_SeleniumTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindActiveElement;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class Ex_6_Search_iSQI {

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
	    
	    //saving title of iSQI website
	    String Website = driver.findElement(By.xpath(".//*[@id='rso']/div[1]/div/div/div/div/h3/a")).getText();
	   
	    //checks if object contains string
	    assertThat(Website, containsString("Start - iSQI - Certifying People all over the world")); 
	    //checks if object is equal to object
	    assertEquals(Website,"Start - iSQI - Certifying People all over the world"); 
	    //element is present
	    assertTrue(driver.findElement(By.id("resultStats")).isDisplayed());
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}