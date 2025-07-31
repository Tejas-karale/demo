package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
   //Locators
	
	@FindBy(xpath="//input[@data-qa=\"login-email\"]")
	WebElement loginMail;
	
	@FindBy(xpath="//input[@data-qa=\"login-password\"]")
	WebElement loginPass;
	
	@FindBy(xpath="//button[@data-qa=\"login-button\"]")
	WebElement Login_btn;
	
	//Actions
	public void  mailnadpass(String mail,String pass)
	{
		loginMail.sendKeys(mail);
		loginPass.sendKeys(pass);	
	}
	
	public void clickLOgin()
	{
		Login_btn.click();
	}
	
	
}
