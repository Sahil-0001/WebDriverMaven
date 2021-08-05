package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.PKIXRevocationChecker.Option;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSample1 {
	
	@Parameters ("browser")
	@Test
	public void loginTest(String browser) throws MalformedURLException
	{

	WebDriver driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	
	if(browser.equals("chrome"))
	{
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.ANY);
	ChromeOptions option= new ChromeOptions();
	option.merge(cap);
	
	}
	else if(browser.equals("firefox"))
	{
	cap.setBrowserName("firefox");
	cap.setPlatform(Platform.ANY);
	
	FirefoxOptions option= new FirefoxOptions();
	option.merge(cap);	
	}
	else if(browser.equals("iexplore"))
	{
	cap.setBrowserName("internetexplorer");
	cap.setPlatform(Platform.ANY);
		
	InternetExplorerOptions option= new InternetExplorerOptions();
	option.merge(cap);
	}
	
	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	
	driver.get("http://www.gmail.com");
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("SHarmasd0786");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	
	driver.quit();
	
	}
	

}
