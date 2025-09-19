package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	
	By email_loc = By.xpath("//input[@id='input-email']");
	By Password_loc = By.xpath("//input[@id='input-password']");
	By Login_btn = By.xpath("//input[@value='Login']");
	
	//Actions
	
	public void enterEmail(String email)
	{
		driver.findElement(email_loc).sendKeys(email);
	}
	
	public void enterPassword(String Password)
	{
		driver.findElement(Password_loc).sendKeys(Password);
	}
	
	public void ClickLoginButton()
	{
		driver.findElement(Login_btn).click();
	}


}
