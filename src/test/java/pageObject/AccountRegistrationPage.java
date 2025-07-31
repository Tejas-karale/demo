package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
//Locator
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement Email;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement Password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement Continue;
	
	@FindBy(xpath="//label[@class=\"form-check-label\"]/parent::div//input[@type=\"checkbox\"]")
	WebElement privacybtn;
	
	@FindBy(xpath="//div[@id=\"content\"]//h1")
	WebElement confimsg;
	
	@FindBy(xpath="//input[@name=\"newsletter\"]")
	WebElement subscribe;
	//actions
	
	public void firstname(String name)
	{
		Firstname.sendKeys(name);
	}
	
	public void LastName(String last) 
	{
		LastName.sendKeys(last);
	}
	
	public void email(String mail)
	{
		Email.sendKeys(mail);
	}
	
	public void checkbox()
	{
		privacybtn.click();
	}
	
	public void subscribleclick()
	{
		subscribe.click();
	}
	public void conti() 
	{
		Continue.click();
	}
	
	public  String getCofirmationMsg() {
	try {
		return (confimsg.getText());
	}
	catch(Exception e) 
	{
		return(e.getMessage());
	}
	
}}
