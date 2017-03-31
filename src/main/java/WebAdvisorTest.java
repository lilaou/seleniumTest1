//import java.util.regex.Pattern;
import java.io.File;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;


public class WebAdvisorTest {
	public WebDriver driver;
		
	public static void main(String[] args) {
        JUnitCore.main("WebAdvisorTest");  
    }
	
	@Before
	public void setUp() throws Exception {

		ChromeOptions options = new ChromeOptions ();
		options.addExtensions (new File("C:/Users/OwenLi/workspace/Library/WebAdvisor_v5.0.532.0.crx"));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		driver =new RemoteWebDriver(capabilities);
	  }


	@Test
	public void given_VerifiedSite_TestedDaily_IsPresent() throws Exception {
        //Open Home Page
        driver.get("http://www.google.com");
        //Enter text in search box
        driver.findElement(By.name("q")).sendKeys("mcafee webadvisor");
        Thread.sleep(1000);
        //Click Search button
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".mcafee_HACKERSAFE")).click();
        
        WebElement divWebAdvisior =driver.findElement(By.xpath("//div[contains(text(),'McAfee WebAdvisor')]"));
        WebElement divTestedDaily = divWebAdvisior.findElement(By.xpath("//div[contains(text(),'Tested Daily')]"));
        
        Assert.assertNotNull(divWebAdvisior);
        Assert.assertNotNull(divTestedDaily);
        Assert.assertEquals("Tested Daily", divTestedDaily.getText());
	}
  
	@Test
	public void given_PhishingSite_RiskyMessageDisplayed_And_RedirectToPhishingPage() throws Exception {
		driver.get("http://www.masinovodje.com/");
		Thread.sleep(2000);
		WebElement spanRisky =driver.findElement(By.xpath("//span[contains(text(),'Whoa, that page could be risky')]"));
		Assert.assertNotNull(spanRisky);
		  
		String URL = driver.getCurrentUrl();
		Assert.assertThat(URL, containsString("http://www.siteadvisor.com/phishing.html?"));
		  
	}
  
	@Test
	public void given_RestrictedSite_RiskyMessageDisplayed_And_RedirectToRestrictedPage() throws Exception {
		driver.get("http://aadroid.net/sys.olk");
		Thread.sleep(2000);
		WebElement spanRisky =driver.findElement(By.xpath("//span[contains(text(),'Whoa, that page could be risky')]"));
		Assert.assertNotNull(spanRisky);
		  
		String URL = driver.getCurrentUrl();
		Assert.assertThat(URL, containsString("http://www.siteadvisor.com/restricted.html?"));
	}
	  
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
