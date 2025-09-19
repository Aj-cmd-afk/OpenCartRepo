package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; //Log4j
	public Properties p;
	
	@BeforeClass(groups= {"sanity", "Regression", "Master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{	
		//LOADING CONFIG.PROPERTIES FILE
		FileReader file = new FileReader("./src//test//resource/config.properties");
		p=new Properties();
		p.load(file);
		
		logger= LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}else if (os.equalsIgnoreCase("macbook"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("Linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome");break;
			case "safari" : capabilities.setBrowserName("safari");break;
			case "firefox" : capabilities.setBrowserName("firefox");break;
			default: System.out.println("No matching browser");return;
			}
			
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
			if (p.getProperty("execution_env").equalsIgnoreCase("local"))
			{
				
				switch (br.toLowerCase())
				{
				case "chrome" : driver = new ChromeDriver(); break;
				case "safari" : driver = new SafariDriver(); break;
				default : System.out.println("Invalid browser name..");
				}
			
			}
			
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appUrl")); // reading url from properties file.
		driver.manage().window().maximize();
	
		
	}
	
	@AfterMethod
	@AfterClass(groups= {"sanity", "Regression", "Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
