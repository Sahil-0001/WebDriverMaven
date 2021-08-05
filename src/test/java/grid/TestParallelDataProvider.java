package grid;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;



public class TestParallelDataProvider {
	
	public ThreadLocal<WebDriver> dr= new ThreadLocal<WebDriver>();
	public ThreadLocal<DesiredCapabilities> dc= new ThreadLocal<DesiredCapabilities>();
	public WebDriver driver;
	public DesiredCapabilities cap;
	
	
	public WebDriver getDriver()
	{
		return dr.get();
	}
	
	public void setWebDriver(WebDriver driver)
	{
	 	dr.set(driver);
	}
	
	public DesiredCapabilities getDesiredCapabilities()
	{
		return dc.get();
	}
	
	public void setDesiredCapabilities(DesiredCapabilities cap)
	{
	 	dc.set(cap);
	}
	
	@Test(dataProvider = "testdata")
	public void doLogin(String username, String browser) throws MalformedURLException
	{
		
		if(browser.equals("chrome"))
		{
			cap=new DesiredCapabilities();
			setDesiredCapabilities(cap);
			
			getDesiredCapabilities().setBrowserName("chrome");
			getDesiredCapabilities().setPlatform(Platform.ANY);
			
			ChromeOptions option= new ChromeOptions();
			option.merge(getDesiredCapabilities());
		}
		
		if(browser.equals("firefox"))
		{
			cap=new DesiredCapabilities();
			setDesiredCapabilities(cap);
			
			getDesiredCapabilities().setBrowserName("firefox");
			getDesiredCapabilities().setPlatform(Platform.ANY);
			
			FirefoxOptions option= new FirefoxOptions();
			option.merge(getDesiredCapabilities());
		}
		
		if(browser.equals("iexplorer"))
		{
			cap=new DesiredCapabilities();
			setDesiredCapabilities(cap);
			
			getDesiredCapabilities().setBrowserName("internetexplorer");
			getDesiredCapabilities().setPlatform(Platform.ANY);
			
			InternetExplorerOptions option= new InternetExplorerOptions();
			option.merge(getDesiredCapabilities());
		}
		
		driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		setWebDriver(driver);
		getDriver().get("http://www.gmail.com");
		getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		getDriver().findElement(By.xpath("//span[text()='Next']")).click();
		
		getDriver().quit();
	}
	
	@DataProvider(name="testdata",parallel=true)
	public Object[][] getdata()
	{
		Object[][] data=new Object[3][2];
		
		
		//first row
				data[0][0]="sharmasd0786@gmail.com";
				data[0][1]="chrome";
				
				
				//second row
				data[1][0]="sahil.sharma441@gmail.com";
				data[1][1]="chrome";
				
				
				//Third row
				data[2][0]="sharmasd@gmail.com";
				data[2][1]="chrome";
				
		return data;
		
	}
	

}
