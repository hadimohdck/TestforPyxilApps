package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TestBase {
	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("QAurl");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		String browser=browser_maven!=null ? browser_maven:browser_properties;
		System.out.println(browser);
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome")) 
			{	System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
				driver=new ChromeDriver();
				}
			if(browser.equalsIgnoreCase("firefox"))
			{	driver=new FirefoxDriver();
				System.getProperty("webdriver.gecho.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");			
			}	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
			
		}
	    return driver;
	    
		
		}

}
