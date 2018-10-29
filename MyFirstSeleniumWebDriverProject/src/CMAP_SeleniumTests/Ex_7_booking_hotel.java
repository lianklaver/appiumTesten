package CMAP_SeleniumTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.containsString;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Ex_7_booking_hotel {

	private WebDriver driver;
	  private String baseUrl;

	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/lianne/Documents/workspace2/geckodriver");
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.booking.com/";
	  }

	  //donders lastig
	  
	  @Test
	  public void testEnterLocation() throws Exception {
	    //open booking.com
		driver.get(baseUrl);
	    //insert iSQI in search balk & click
		//driver.findElement(By.id("ss")).click();
	    //driver.findElement(By.id("ss")).sendKeys("London");
	    //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("c-autocomplete__item sb-autocomplete__item sb-autocomplete__item--city sb-autocomplete__item__item--elipsis" )));
	    //System.out.println(driver.findElement(By.className("c-autocomplete__list sb-autocomplete__list -visible")).getText());
	    System.out.println(driver.findElement(By.className("sb-date-field__chevron bicon-downchevron")));
		driver.findElement(By.className("sb-date-field__chevron bicon-downchevron")).click();
		driver.findElement(By.className("c2-day c2-day-s-today")).click();
	    //System.out.println((driver.findElement(By.id("ss")).getText()));
	    //driver.findElement(By.xpath(".//*[@id='frm']/div[3]/div/div[1]/div[1]/div/div/div[1]/div/i")).click();
	    //driver.findElement(By.id("1505433600000")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	   driver.quit();
	  }
}