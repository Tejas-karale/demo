package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	
	public void SetUp(String os,String br) throws IOException
	{
		//loading config.propertiesfile
		FileReader file=new FileReader("./src//test//resources//Config.properties");
		p= new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome" :driver = new ChromeDriver();break;
		case "safari" :driver = new SafariDriver();break;
		case "firefox" :driver = new FirefoxDriver();break;
        default :System.out.println("Invalid browser name...");return;
		
		}
		
		
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://automationexercise.com/");
		driver.get(p.getProperty("appUrl"));//reading from property file
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generateNumber=RandomStringUtils.randomNumeric(10);
		return generateNumber;
		
	}
	
	public String randomPassword()
	{
		String Alpha = RandomStringUtils.randomAlphabetic(5);
		String number =RandomStringUtils.randomNumeric(4);
		return(Alpha+"@"+number);
	}

	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat
				("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
	    String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp;
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	
	}
	
	
}
