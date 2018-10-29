package CMAP_SeleniumTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ex_2_PrintGetPageTitleHTMLSource {
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
	    driver.get(baseUrl);
	    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA" + driver.getTitle());
	    // + "?gfe_rd=cr&dcr=0&ei=km26WcPXHonSXv-httAL&gws_rd=ssl");
	    //driver.findElement(By.id("lst-ib")).clear();
	    //driver.findElement(By.id("lst-ib")).sendKeys("isqi");
	    //driver.findElement(By.name("btnK")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}