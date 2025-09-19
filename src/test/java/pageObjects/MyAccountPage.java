package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators 
	By MyAccount_Heading_loc = By.xpath("//h2[text()='My Account']");
	By Logout_txt = By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");
	
	
	//Actions
	
	public boolean isMyAccountExists()
	{	
		try
		{
		return driver.findElement(MyAccount_Heading_loc).isDisplayed();
		} 
		catch(Exception e)
		{
			return false;
		}
				
	}
	
	public void logout()
	{
		driver.findElement(Logout_txt).click();
	}
}
