import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class WebAdvisorTest_Firefox extends WebAdvisorTest {
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:/Users/OwenLi/workspace/Library/geckodriver-v0.15.0-win64/geckodriver.exe");
		String addOnPath = "C:/Users/OwenLi/workspace/Library/saffplg.xpi";
		File addOnFile = new File( addOnPath );
		FirefoxProfile profile = new FirefoxProfile();
		profile.addExtension( addOnFile );
		driver = new FirefoxDriver( profile );
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
        Thread.sleep(2000);
        
        WebElement divWebAdvisior =driver.findElement(By.xpath("//div[contains(@id, 'WEBADVISORTEXT')]"));
        WebElement divRecommendation =driver.findElement(By.xpath("//div[contains(@id, 'RECOMMENDATION')]"));
        
        Assert.assertNotNull(divWebAdvisior);
        Assert.assertNotNull(divRecommendation);
        
	}

}
