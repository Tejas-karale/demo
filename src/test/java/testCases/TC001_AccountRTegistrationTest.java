package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class TC001_AccountRTegistrationTest {

	public WebDriver driver ;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/index.php?route=account/register");
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test
	
	public void verify_Account_Verification() throws InterruptedException
	{
		
		HomePage hm= new HomePage(driver);
		//hm.clickRegister();
		Thread.sleep(3000);
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
	    arp.firstname("Tejas");
	
	}
}
