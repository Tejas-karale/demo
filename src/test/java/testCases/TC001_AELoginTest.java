package testCases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.HomePageAE;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC001_AELoginTest extends BaseClass {

	@Test

	public void verify_Logiin()
	{//logger.info("*******Start Test");
	try {
	
		HomePageAE hm = new HomePageAE(driver);
		hm.loginbtn();
		
		
		
		LoginPage lp = new LoginPage(driver);
        lp.mailnadpass(p.getProperty("email"), p.getProperty("password"));
	   lp.clickLOgin();
	
	//My Account
	    MyAccountPage macc = new MyAccountPage(driver);
	    boolean targetPage = macc.isMyAccountExixts();
	    
	    Assert.assertEquals(targetPage, true);
	    
	}
	catch(Exception e)
	{
	Assert.fail();
	}
	
	}
	
}
