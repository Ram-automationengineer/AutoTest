package browserPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayPage {

	private WebDriver driver;

	//Search Textbox
	private By textBox = By.id("gh-ac");
    
	//Search button
	private By searchButton = By.id("gh-btn");

	//First result link
	private By firstResult = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a");

	//Item Price
	private By itemPrice = By.xpath("//*[@id=\"mm-saleDscPrc\"]");

	/**
	* Initialize the constructor with driver object
	*/
	public EbayPage(WebDriver driver)
	{
		this.driver = driver;
	}

   /**
	* Used to enter text in Textbox
	* @param text, Specifies text to be entered
	*/
	public void enterTextInTextbox(String text)
	{
		driver.findElement(textBox).sendKeys(text);
	}

	/**
	* Used to perform search by clicking Search button
	*/
	public void performSearch()
	{
		driver.findElement(searchButton).click();
	}

	/**
	* Used to click First result from Search results
	*/
	public void clickFirstResult()
	{
		driver.findElement(firstResult).click();
	}

	/**
	* Used to get Item price of specific item
	* @return the Price of item
	*/
	public String getItemPrice()
	{
		return driver.findElement(itemPrice).getText();
	}
}