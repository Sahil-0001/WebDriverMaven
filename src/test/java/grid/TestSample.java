package grid;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import com.beust.jcommander.Parameter;


public class TestSample {
	
	@Parameters ("browser")
	@Test(dataProvider = "testdata")
	public void testLogin(String username, String browser ) throws MalformedURLException
	{
		System.out.println(browser);
		DesiredCapabilities cap=null;
		
		if(browser.equals("chrome"))
		{
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		}
		else if(browser.equals("firefox"))
		{
			cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.ANY);
		}
		else if(browser.equals("iexplore"))
		{
		cap=DesiredCapabilities.internetExplorer();
		cap.setBrowserName("internetExplorer");
		cap.setPlatform(Platform.WINDOWS);
		}
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		
		driver.get("http://www.gmail.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		driver.quit();
		
	}
	
	@DataProvider (name="testdata",parallel=true)
	public Object[][] getData()
	{
	
		Object[][] data =new Object[9][2];
		
		//first row
		data[0][0]="sharmasd0786@gmail.com";
		data[0][1]="chrome";
		
		
		//second row
		data[1][0]="sahil.sharma441@gmail.com";
		data[1][1]="chrome";
		
		
		//Third row
		data[2][0]="sharmasd@gmail.com";
		data[2][1]="chrome";
		
		
		
		//first row
		data[3][0]="sharmasd07862@gmail.com";
		data[3][1]="chrome";
		
		
		//second row
		data[4][0]="sahil.sharma4412@gmail.com";
		data[4][1]="chrome";
		
		
		//Third row
		data[5][0]="sharmasd2@gmail.com";
		data[5][1]="chrome";
		
		
		
		//first row
		data[6][0]="sharmasd07861@gmail.com";
		data[6][1]="chrome";
		
		
		//second row
		data[7][0]="sahil.sharma4411@gmail.com";
		data[7][1]="chrome";
		
		
		//Third row
		data[8][0]="sharmasd1@gmail.com";
		data[8][1]="chrome";
		
		return data;
		
	}
	

}
