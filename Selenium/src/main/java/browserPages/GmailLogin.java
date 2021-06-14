package browserPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailLogin
{

	private WebDriver driver;

	//UserName Textbox
	private By userName = By.name("identifier");
	
	//Next button
	private By userNameNextButton = By.xpath("//*[@id=\"identifierNext\"]/div/button");
    
	//Password textbox
	private By password = By.name("password");
	
	//Next button
	private By passwordNextButton = By.xpath("//*[@id=\"passwordNext\"]/div/button");
	
	//Account Logo
	private By gmailAccountLogo = By.xpath("//img[@Class='gb_Ca gbii']");
	
	//Incorrect Email Error msg
	private By incorrectUserNameError = By.xpath("//div[@class='o6cuMc']");
	
	public GmailLogin(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	/**
	* Used to enter text in username textbox and click Next button
	* @param text, Specifies text to be entered
	*/
	public void enterUserNameAndClickNext( String txtUserName )
	{
		driver.findElement(userName).sendKeys(txtUserName);
		driver.findElement(userNameNextButton).click();
		//Add an Implicit delay to load
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	* Used to enter text in password textbox and click Next button
	* @param text, Specifies text to be entered
	*/
	public void enterPasswordAndClickNext( String txtPassword )
	{
		driver.findElement(password).sendKeys(txtPassword);
		driver.findElement(passwordNextButton).click();
		//Add an Implicit delay to load
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	* Used to verify whether Login is success by verifying User logo in Top-Right corner
	* @return boolean, Specifies verify whether login is success or not.
	*/
	public boolean verifyLoginSuccess()
	{
		return driver.findElement(gmailAccountLogo).isDisplayed();
	}
	
	/**
	* Used to verify whether Login is Failure by verifying invalid mail object and the error message.
	* @return boolean, Specifies verify whether login is failed or not due to invalid mail address.
	*/
	public boolean verifyLoginFailure()
	{
		boolean isLogonFailure = false;
		WebElement element = driver.findElement(incorrectUserNameError);
		if ( element.isDisplayed() && element.getText().equalsIgnoreCase("Enter a valid email or phone number"))
		{
			isLogonFailure = true;
		}
		return isLogonFailure;
	}
}