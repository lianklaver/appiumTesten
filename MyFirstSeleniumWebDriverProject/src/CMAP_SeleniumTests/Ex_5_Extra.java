package CMAP_SeleniumTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex_5_Extra {

	//voorbeeld Rutger en nog in verwerken
	
	 private WebDriver driver;
	 private String baseUrl;
	 
	  @Before
	  public void setUp() throws Exception {
		//System.setProperty("webdriver.gecko.driver", "/Users/lianne/Documents/workspace2/geckodriver");
		//System.setProperty("webdriver.chrome.driver", "/Users/lianne/Documents/workspace2/chromedriver");
		//driver = new FirefoxDriver(); 
	    driver = new SafariDriver(); //werkt nog niet
		//driver = new ChromeDriver(); 
	    baseUrl = "https://www.google.nl/";
	  }

	  @Test
	  public void testGoogleSearch() throws Exception {
	    //open google.com
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(baseUrl);
	    //insert iSQI in search balk
	    driver.findElement(By.id("lst-ib")).sendKeys("iSQI");
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