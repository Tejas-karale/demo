package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAE extends BasePage {

	public HomePageAE(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//a[@href=\"/login\"]")
    WebElement login;
    
    @FindBy(xpath="//i[@class=\"fa fa-home\"]")
    WebElement home;
    
    @FindBy(xpath="//a[@href=\"/view_cart\"]//i")
    WebElement cart ;
    
    @FindBy(xpath="//a[@href=\"/products\"]")
    WebElement products;
    
    @FindBy(xpath="//a[text()=' Logout']")
	WebElement logout;
    
    //actions
  public void homebtn() 
  {
	 home.click(); 
  }
    
  public void loginbtn() 
  {
	 login.click(); 
  }
   
  public void cartbtn() 
  {
	 cart.click(); 
  }
   
  public void productsbtn() 
  {
	 products.click(); 
  }
   
  public void logout()
	{
	  logout.click();
	}
   
  
}
