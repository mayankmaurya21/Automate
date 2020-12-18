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

public class localTesting {
	public static final String AUTOMATE_USERNAME = "";
	  public static final String AUTOMATE_ACCESS_KEY ="";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 
	
	  public static void localTest(WebDriver driver) throws MalformedURLException, InterruptedException

	  {
		    
		  	
		  
		  // Open Local host
		driver.get("http://localhost:8080/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("Title of page "+driver.getTitle());
		driver.quit();
	  }
	  
	  @Test
	public static void launchChrome() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser_version", "84.0 beta");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("browser", "chrome");
		    caps.setCapability("browserstack.local", "true");
		
		    caps.setCapability("project", "LocalTest");
		    caps.setCapability("build", "alpha_0.1.7");
		    caps.setCapability("name", "Mayank's test chrome");

		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		    mark(sessionid);
		    System.out.println(sessionid);
		    localTest(driver);
	
	}
	  
	@Test
	public static void launchEdge() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser_version", "85.0");
		    caps.setCapability("os", "Windows");
		   caps.setCapability("browser", "Edge"); 
		   caps.setCapability("browserstack.local", "true");

		    caps.setCapability("project", "sample");
		    caps.setCapability("build", "alpha_0.1.7");
		    caps.setCapability("name", "Mayank's test Edge");

		   WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		   SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		   System.out.println(sessionid);
		   mark(sessionid);
		   localTest(driver);

	}
	
	@Test
	public static void launchSafari() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "Mojave");
	    caps.setCapability("resolution", "1920x1080");
	    caps.setCapability("browser", "Safari");
	    caps.setCapability("browser_version", "12.1");
	    caps.setCapability("os", "OS X"); 
	    caps.setCapability("browserstack.local", "true");

	    caps.setCapability("project", "sample");
	    caps.setCapability("build", "alpha_0.1.7");
	    caps.setCapability("name", "Mayank's test Safari");
	    
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
	    System.out.println(sessionid);
	    mark(sessionid);
		localTest(driver);

	}
	
	@Test
	public static void launchAndroid() throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("browserName", "Android");
		    caps.setCapability("device", "Samsung Galaxy S20");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "10.0");
	caps.setCapability("browserstack.local", "true");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
	    System.out.println(sessionid);
	    mark(sessionid);
		localTest(driver);

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
