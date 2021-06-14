package Automation.Testing.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import browserPages.EbayPage;
import browserPages.GmailLogin;

public class App 
{
	WebDriver driver;
	private void ebayPageTest() 
	{
		/*Test steps in Brief:
		 * 1. Load Ebay page
		 * 2. Search for "Electric Guitar"
		 * 3. Click the First result from search results
		 * 4. Print the Item price
		 */
		EbayPage page = new EbayPage(driver);
		//Browse to Ebay.com
		driver.get("https://www.ebay.com/");
		//Add an Implicit delay to load
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Search for "Electric Guitar"
		page.enterTextInTextbox("Electric Guitar");
		page.performSearch();
		//Add an Implicit delay for page to load the results
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Click the First Result
		page.clickFirstResult();
		//Add an Implicit delay for page to load
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Print the Item price
		System.out.println("Item Price is: " + page.getItemPrice());
	}
	
	private void gmailTest()
	{
		/*Test steps in Brief:
		 * 1. Load Gmail page
		 * 2. Login with valid credentials
		 * 3. Login with invalid credentials
		 * 4. Verify the login failure and validate error message
		 * 5. Verify Success login by verifying availability of profile icon
		 */
		
		//Browse to gmail.com
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		//Add an Implicit delay to load
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		GmailLogin gmailPage1 = new GmailLogin(driver);
		gmailPage1.enterUserNameAndClickNext("invalid-login");
		if ( gmailPage1.verifyLoginFailure() )
		{
			System.out.println("User loggedin failed as expected." );
		}
		else
		{
			System.out.println("User logged in passed which is incorrect." );
		}
		
		//Browse to gmail.com
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		//Add an Implicit delay to load
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Search for "Electric Guitar"
		GmailLogin gmailPage2 = new GmailLogin(driver);
		gmailPage2.enterUserNameAndClickNext("ta7201467");
		gmailPage2.enterPasswordAndClickNext("google2021");
		//Verify success login
		if ( gmailPage2.verifyLoginSuccess() )
		{
			System.out.println("User logged in sucessfully and logo is displayed." );
		}
		else
		{
			System.out.println("User logged in failed." );
		}
	}
	
	/**
	* Used to launch GoogleChrome browser and Maximize it
	*/
	private void launchChromeBrowserAndMaximize()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Jars\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/**
	* Used to close the browser and driver object
	*/
	private void closeBrowser()
	{
		driver.close();
		driver.quit();
	}

	public static void main(String[] args)
	{
		App testApp = new App();
		testApp.launchChromeBrowserAndMaximize();
		testApp.ebayPageTest();
		testApp.gmailTest();
		testApp.closeBrowser();	
	}
}