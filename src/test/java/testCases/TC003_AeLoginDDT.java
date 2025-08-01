package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePageAE;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_AeLoginDDT extends BaseClass {

	@Test(dataProvider = "Logindata",dataProviderClass=DataProviders.class)
    
	public void verify_LogiinDDT(String email,String password,String exp)
	{	
		
		try {
		HomePageAE hm = new HomePageAE(driver);
		hm.loginbtn();
		
		
		
	   LoginPage lp = new LoginPage(driver);
       lp.mailnadpass(email,password);
	   lp.clickLOgin();
	
	//My Account
	    MyAccountPage macc = new MyAccountPage(driver);
	    boolean targetPage = macc.isMyAccountExixts();
	    
	    Assert.assertEquals(targetPage, true);
	    if(exp.equalsIgnoreCase("Valid"))
	    {
	    	if(targetPage==true)
	    	{
	    		hm.logout();
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    if(exp.equalsIgnoreCase("Invalid"))
	    	
	    {
	    	if(targetPage==true)
	    	{
	    		hm.logout();
	    		Assert.assertTrue(true);
	    	}
	    }
		}
	    catch(Exception e)
	    {
	    	Assert.fail();
	    	}
	}
	}