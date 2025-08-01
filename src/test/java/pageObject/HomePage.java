package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}
	//locators
	@FindBy(xpath="//span[text()=\"My Account\"]")
	WebElement MyAccount;
	
	@FindBy(xpath="//li//a[text()='Register']")
	WebElement Register;
	
	

	public void clickMyAccount()
	{
		MyAccount.click();
	}
	
	public void clickRegister() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",Register);
		//Register.click();
	}
}
