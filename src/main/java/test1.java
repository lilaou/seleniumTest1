//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class test1 {
  private WebDriver driver;
  @Before
  public void setUp() throws Exception {
	  //System.setProperty("webdriver.gecko.driver", "C:/Users/OwenLi/workspace/Library/geckodriver-v0.15.0-win64/geckodriver.exe");
	  System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
	  driver =new RemoteWebDriver(DesiredCapabilities.chrome());
	  
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
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    }
  }
