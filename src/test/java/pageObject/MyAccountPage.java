package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
		@FindBy(xpath="//a[contains(text(), 'Logged in as')]")	
		WebElement loginText;
		
		public boolean isMyAccountExixts()
		{
			
			try 
			{
				return(loginText.isDisplayed());
				
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		
		
		}

