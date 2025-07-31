package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePageAE;
import pageObject.RegestrationPageAE;
import pageObject.signUpPageAE;
import testBase.BaseClass;

public class TC002_AERegistrationTest extends BaseClass {
	
	@Test
	
	public void VerifyAccount()
	{
		logger.info("****** Starting TC001 AccountRegestrationTest   ***");
		HomePageAE hm = new HomePageAE(driver);
		hm.loginbtn();
		
		signUpPageAE siup = new signUpPageAE(driver);
		siup.sendname("DemoRam");
		String mail = (randomString()+"@gmail.com");
		siup.sendemail(mail);
		 System.out.println(mail);
		siup.clickSign();
        System.out.println(siup.getmessage());
       
        
        RegestrationPageAE RP = new RegestrationPageAE(driver);
        RP.maleRadio();
        RP.firstname("Tejas");
       String password = randomPassword();
       System.out.println(password);
        RP.password("Password@123");
        RP.newsletter();
        RP.laststname("Karale");
        RP.companyname("FireFlink");
        RP.inpt_address("At Post Ddola");
        RP.Selectcountry("India");
        RP.SelectDay("7");
        RP.Selectmonth("7");
        RP.Selectyear("2001");
        RP.selectstate("Maharashtra");
        RP.selectCity("Pune");
        RP.selectZipcode();
        RP.mobile(randomNumber());
        RP.createAccount_btn();
       String message = RP.getMessage();
       AssertJUnit.assertEquals(message, "ACCOUNT CREATED!");  
	//	logger.info("****** Ending TC001 AccountRegestrationTest   ***");

	}
	
	
}
