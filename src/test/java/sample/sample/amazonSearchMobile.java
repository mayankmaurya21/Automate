package sample.sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;

public class amazonSearchMobile {
	public static final String AUTOMATE_USERNAME = "";
	  public static final String AUTOMATE_ACCESS_KEY ="";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 
	
	  public static void amazonProductSearchMobile(WebDriver driver) throws MalformedURLException, InterruptedException

	  {   
		  // Open Amazon.com
		driver.get("https://www.amazon.com/");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//input[@id='nav-search-keywords']")).clear();
		driver.findElement(By.xpath("//input[@id='nav-search-keywords']")).sendKeys("iPhone X");
		driver.findElement(By.xpath("//input[@id='nav-search-keywords']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@id='s-all-filters']")).click();
		Thread.sleep(3000);
			
		driver.quit();
	  }
	  
	 
	@Test
	public static void launchIosIphone11() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
	    caps.setCapability("device", "iPhone 11");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "13.0"); 
	    caps.setCapability("project", "MobileTest");
	    caps.setCapability("build", "alpha_0.1.7");
	    caps.setCapability("name", "launchIosIphone11");
	    caps.setCapability("browserstack.geoLocation", "FR");
		   WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		   SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		   System.out.println(sessionid);
		   mark(sessionid);
		   amazonProductSearchMobile(driver);

	}
	
	
	@Test
	public static void launchAndroidSamsungS20() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("browserName", "Android");
		    caps.setCapability("device", "Samsung Galaxy S20");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "10.0");
		    caps.setCapability("project", "MobileTest");
		    caps.setCapability("build", "alpha_0.1.7");
		    caps.setCapability("name", "launchAndroidSamsungS20");
		    caps.setCapability("browserstack.geoLocation", "FR");
		    caps.setCapability("browserstack.networkProfile", "2g-gprs-good");
		   
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
	    System.out.println(sessionid);
	    mark(sessionid);
		amazonProductSearchMobile(driver);

	}
	
	@Test
	public static void launchAndroidGooglePixel3A() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		   caps.setCapability("browserName", "Android");
		    caps.setCapability("device", "Google Pixel 3a");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "9.0");
		    caps.setCapability("project", "MobileTest");
		    caps.setCapability("build", "alpha_0.1.7");
		    caps.setCapability("name", "launchAndroidGooglePixel3A");
		    caps.setCapability("browserstack.geoLocation", "CN");
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
	    System.out.println(sessionid);
	    mark(sessionid);
		amazonProductSearchMobile(driver);

	}
	@Test
	public static void launchAndroidOnePlus8() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "Android");
		    caps.setCapability("device", "OnePlus 8");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "10.0");
		    caps.setCapability("project", "MobileTest");
		    caps.setCapability("build", "alpha_0.1.7");
		    caps.setCapability("name", "launchAndroidOnePlus8");
		    caps.setCapability("browserstack.geoLocation", "CN");
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
	    System.out.println(sessionid);
	    mark(sessionid);
		amazonProductSearchMobile(driver);

	}
	public static void mark(SessionId sessionid) throws URISyntaxException, UnsupportedEncodingException, IOException {
		  URI uri = new URI("https://mayankmaurya2:qwudT56wfMJxWLKKhRv1@api.browserstack.com/automate/sessions/"+sessionid+".json");
		  HttpPut putRequest = new HttpPut(uri);

		  ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		  nameValuePairs.add((new BasicNameValuePair("status", "passed")));
		  nameValuePairs.add((new BasicNameValuePair("reason", "")));
		  putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		  HttpClientBuilder.create().build().execute(putRequest);
		}
}
