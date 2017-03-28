//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
import java.io.File;

import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class test1 {
  private WebDriver driver;
	//private ChromeDriver driver;
  @Before
  public void setUp() throws Exception {
	  //System.setProperty("webdriver.gecko.driver", "C:/Users/OwenLi/workspace/Library/geckodriver-v0.15.0-win64/geckodriver.exe");
	  ChromeOptions options = new ChromeOptions ();

	  options.addExtensions (new File("C:/Users/OwenLi/workspace/Library/WebAdvisor_v5.0.532.0.crx"));

	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();//new DesiredCapabilities ();

	  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	  System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
	   driver =new RemoteWebDriver(capabilities);
	  //driver =new RemoteWebDriver(DesiredCapabilities.chrome());
	  
  }
// Search using keyword through Google search

  @Test
  public void testtestclass() throws Exception {
        //Open Home Page
        driver.get("http://www.google.com");
        //Enter text in search box
        driver.findElement(By.name("q")).sendKeys("mcafee webadvisor");
        Thread.sleep(1000);
        //Click Search button
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".mcafee_HACKERSAFE")).click();
        driver.get("chrome-extension://fheoggkfdfchfphceeifdbepaooicaho/html/annotationballoon.html");
        //driver.findElement(By.cssSelector(".mcafee_HACKERSAFE"));
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
    }
  }
