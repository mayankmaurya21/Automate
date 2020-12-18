package sample.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class NewTest {
	public static final String AUTOMATE_USERNAME = "";
	  public static final String AUTOMATE_ACCESS_KEY ="";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  static DesiredCapabilities caps = new DesiredCapabilities();
	  
	  public static void flipkart() throws MalformedURLException, InterruptedException

	  {
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		   
		    caps.setCapability("browser_version", "84.0 beta");
		    caps.setCapability("os", "Windows"); 
		  	WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		  
		  // Open flipKart
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		driver.findElement(By.xpath("//input[@class='LM6RPg']")).clear();
		driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("Samsung Galaxy S10");
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='_3XS1AH _32ZSYo']")));
		driver.findElement(By.xpath("//a[@class='_3XS1AH _32ZSYo']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='512 MB - 1 GB']")));
		WebElement element = driver.findElement(By.xpath("//div[text()='512 MB - 1 GB']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		driver.findElement(By.xpath("//div[@class='_1GEhLw' and text()='Samsung']/..")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Price']")));
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Price']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@class='_2rIV_l']/../../..")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Price -- High to Low']")));
		driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
		Thread.sleep(3000);
		List<WebElement> productList=driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		List<WebElement> displayPriceList=driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		List<WebElement> linkslist=driver.findElements(By.xpath("//a[@class='_31qSD5']"));
		for (int i=0;i<productList.size();i++)
		{
		System.out.println("Product List   ="+productList.get(i).getText());	
		System.out.println("Display Price List   ="+displayPriceList.get(i).getText());
		System.out.println("Links List   ="+linkslist.get(i).getAttribute("href"));
		System.out.println("*********************************************************************************************");
		}
		driver.quit();
	  }
	  
	  @Test
	public static void launchChrome() throws InterruptedException, MalformedURLException {
		
		    caps.setCapability("browser", "chrome");
		    flipkart();
	
	}
	  
	@Test
	public static void launchEdge() throws InterruptedException, MalformedURLException {
		
		   caps.setCapability("browser", "Edge"); 
		   flipkart();

	}
	
}
