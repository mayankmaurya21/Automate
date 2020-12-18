package sample.sample;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class browserStackInception {
	public static final String AUTOMATE_USERNAME = "";
	  public static final String AUTOMATE_ACCESS_KEY ="";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 
	 static WebDriver driver ;
	  public static void browserStackInception() throws MalformedURLException, InterruptedException

	  {
		    
		  	
		  
		  // Open Browserstack.com
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//a[ text()='Sign in']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='user_email_login']")).sendKeys("mayank.m+demo@browserstack.com");
		
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("makmm21@");
		
		driver.findElement(By.xpath("//input[@id='user_submit']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@id='skip-local-installation']")).click();
		
		Thread.sleep(3000);
				
		driver.findElement(By.xpath("//li[contains(@class,'os-item rf-win10-os-ico')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[@data-browser='Chrome']//a[text()='80']")).click();
		Thread.sleep(10000);
		
		WebElement canvas=driver.findElement(By.xpath("//canvas[@id='flashlight-overlay']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(canvas, 148,54).click().build().perform();;
		actions.moveToElement(canvas, 148,54).sendKeys("BrowserStack").build().perform();
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
		
		
	  }
	  
	  @Test
	public static void launchChrome() throws InterruptedException, MalformedURLException {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser_version", "81.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("browser", "chrome");
		    ChromeOptions options = new ChromeOptions();
		    options.setExperimentalOption("excludeSwitches",
		        Arrays.asList("disable-popup-blocking"));
		    driver = new RemoteWebDriver(new URL(URL), caps);
		    browserStackInception();
	
	}
	  
//	@Test
//	public static void launchEdge() throws InterruptedException, MalformedURLException {
//		DesiredCapabilities caps = new DesiredCapabilities();
//		 caps.setCapability("os_version", "10");
//		    caps.setCapability("resolution", "1920x1080");
//		    caps.setCapability("browser_version", "85.0");
//		    caps.setCapability("os", "Windows");
//		   caps.setCapability("browser", "Edge"); 
//		   driver = new RemoteWebDriver(new URL(URL), caps);
//		   browserStackInception();
//
//	}
//	
//	@Test
//	public static void launchSafari() throws InterruptedException, MalformedURLException {
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("os_version", "Mojave");
//	    caps.setCapability("resolution", "1920x1080");
//	    caps.setCapability("browser", "Safari");
//	    caps.setCapability("browser_version", "12.1");
//	    caps.setCapability("os", "OS X"); 
//	 driver = new RemoteWebDriver(new URL(URL), caps);
//		   browserStackInception();
//
//	}
	
}
