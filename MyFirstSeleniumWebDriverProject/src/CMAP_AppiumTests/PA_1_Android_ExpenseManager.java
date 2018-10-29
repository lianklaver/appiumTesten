package CMAP_AppiumTests;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException; 

public class PA_1_Android_ExpenseManager {

	 private WebDriver driver;

	  @Before
	  public void setUp() throws Exception {	  
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
	    capabilities.setCapability("deviceName", "Android Emulator");
	    capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("platformVersion", "6.0");
	    capabilities.setCapability("app", "/Users/lianne/Documents/ExpenseManager.apk");
		  
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}
	
	@Test
	public void test() throws IOException {
		
		
		//add amount 1
		driver.findElement(By.id("at.markushi.expensemanager:id/menu_new_expense_only")).click();
		driver.findElement(By.id("at.markushi.expensemanager:id/digit_1")).click();
		System.out.println(driver.findElement(By.id("at.markushi.expensemanager:id/txt_amount")).getText());
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.CheckedTextView")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TextView")).click(); 
		
		
		//add amount 2
		driver.findElement(By.id("at.markushi.expensemanager:id/menu_new_expense_only")).click();
		driver.findElement(By.id("at.markushi.expensemanager:id/digit_2")).click();
		System.out.println(driver.findElement(By.id("at.markushi.expensemanager:id/txt_amount")).getText());
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.CheckedTextView")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TextView")).click(); 
			
		//add amount 3
		driver.findElement(By.id("at.markushi.expensemanager:id/menu_new_expense_only")).click();
		driver.findElement(By.id("at.markushi.expensemanager:id/digit_3")).click();
		System.out.println(driver.findElement(By.id("at.markushi.expensemanager:id/txt_amount")).getText());
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.CheckedTextView")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TextView")).click(); 
		
		// take screenshot
		File Photo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Photo, new File("/Users/lianne/Documents/screenshot.jpg"));
				
	}

	@After
	public void tearDown() throws Exception {
	driver.quit();
	}

}
