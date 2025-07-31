package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegestrationPageAE extends BasePage{

	public RegestrationPageAE(WebDriver driver)
	{
		super(driver);
	}
//locator
@FindBy (xpath="//input[@id=\"id_gender1\"]")	
	WebElement rdbMale;

@FindBy (xpath="//input[@id=\"password\"]")	
WebElement inpPassword;

@FindBy(xpath="//select[@id=\"days\"]")
WebElement day;

@FindBy(xpath="//select[@id=\"months\"]")
WebElement months;

@FindBy(xpath="//select[@id=\"years\"]")
WebElement year;

@FindBy (xpath="//input[@id=\"newsletter\"]")	
WebElement rbdNewsletter;

@FindBy (xpath="//input[@id=\"first_name\"]")	
WebElement inpt_FirstName;

@FindBy (xpath="//input[@id=\"last_name\"]")	
WebElement inpt_LastName;

@FindBy (xpath="//input[@id=\"company\"]")
WebElement Company;

@FindBy(xpath="//input[@id=\"address1\"]")
WebElement address;

@FindBy(xpath="//select[@id=\"country\"]")
WebElement drp_country;

@FindBy(xpath="//input[@id=\"state\"]")
WebElement state;

@FindBy(xpath="//input[@data-qa=\"city\"]")
WebElement city;

@FindBy(xpath="//input[@data-qa=\"zipcode\"]")
WebElement zipcode;

@FindBy(xpath="//input[@id=\"mobile_number\"]")
WebElement mobileno;

@FindBy(xpath="//button[@data-qa=\"create-account\"]")
WebElement createAcc;

@FindBy(xpath="//b[text()='Account Created!']")
WebElement message;
//Actions

public void maleRadio()
{
	rdbMale.click();
}
	
public void password(String password)
{
	inpPassword.sendKeys(password);
}

public void newsletter()
{
	rbdNewsletter.click();
}

public void firstname(String name)
{
	inpt_FirstName.sendKeys(name);
}

public void laststname(String firstname)
{
	inpt_LastName.sendKeys(firstname);
}

public void companyname(String comp)
{
	Company.sendKeys(comp);
}

public void inpt_address(String add)
{
address.sendKeys(add);	
}

public void Selectcountry(String value)
{
	Select dropdown = new Select(drp_country);
	dropdown.selectByValue(value);
}

public void SelectDay(String date)
{
	Select dropdown = new Select(day);
	dropdown.selectByValue(date);
}

public void Selectmonth(String month)
{
	months.click();
	Select dropdown = new Select(months);
	dropdown.selectByValue(month);
}

public void Selectyear(String Year)
{
	year.click();
	Select dropdown = new Select(year);
	dropdown.selectByValue(Year);
}

public void selectstate(String State)
{
	state.sendKeys(State);
}

public void selectCity(String City)
{
	city.sendKeys(City);
}

public void selectZipcode()
{
	zipcode.sendKeys("121013");
}

public void mobile(String mobile) 
{
	mobileno.sendKeys(mobile);
}

public void createAccount_btn()
{
	createAcc.click();
}

public String getMessage(){
try{
	return (message.getText());
}
catch(Exception e)
{
	return(e.getMessage());
}
}

}
