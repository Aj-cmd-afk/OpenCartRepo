package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	//Locators

	By myAccount_loc=By.xpath("//span[normalize-space()='My Account']");
	By Regis_loc=By.xpath("//a[normalize-space()='Register']");
	By  Login_loc = By.xpath("//a[normalize-space()='Login']");
	
	
	//Actions
	
	public void clickMyAccount()
	{
	driver.findElement(myAccount_loc).click();
	}
	
	public void clickRegis()
	{
		driver.findElement(Regis_loc).click();
	}
	
	public void clickLogin()
	{
		driver.findElement(Login_loc).click();
	}
	
	
	
	
	
	
	
	
	
	
}
