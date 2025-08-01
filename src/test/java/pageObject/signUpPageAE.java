package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signUpPageAE extends BasePage {

	public signUpPageAE(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@name=\"name\"]")
	WebElement name;
	
	@FindBy(xpath="//input[@data-qa=\"signup-email\"]")
	WebElement email;
	
	@FindBy(xpath="//button[@data-qa=\"signup-button\"]")
	WebElement signUp;
	
	@FindBy(xpath="//b[text()=\"Enter Account Information\"]")
	WebElement message;
	//Actions
	
	@FindBy(xpath="//a[text()=' Logout']")
	WebElement logout;
	public void sendname(String Name) 
	{
		name.sendKeys(Name);
	}
	
	public void sendemail(String Email) 
	{
		email.sendKeys(Email);
	}
	
	public void clickSign() 
	{
		signUp.click();
	}
	
	public String getmessage()
	{
		try {
			return(message.getText());
		}
		catch (Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void logout()
	{
		logout.click();
	}
}
