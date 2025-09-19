package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountRegistrationpage extends BasePage {

	public AccountRegistrationpage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Locators

	By txtFirstname=By.xpath("//input[@id='input-firstname']");
	By txtlastName=By.xpath("//input[@id='input-lastname']");
	By txtEmail=By.xpath("//input[@id='input-email']");
	By txtTelephone=By.xpath("//input[@id='input-telephone']");
	By txtpassword=By.xpath("//input[@id='input-password']");
	By txtPasswordConfirm= By.xpath("//input[@id='input-confirm']");
	By chkdPolicy=By.xpath("//input[@name='agree']");
	By btnContinue=By.xpath("//input[@value='Continue']");
	By msgConfirmation = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
	
	public void setFirstname(String Firstname)
	{
		driver.findElement(txtFirstname).sendKeys(Firstname);
	}
	
	public void setLastName(String lastname)
	{
		driver.findElement(txtlastName).sendKeys(lastname);
	}
	
	public void setEmail(String email)
	{
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		driver.findElement(txtTelephone).sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		driver.findElement(txtpassword).sendKeys(password);
	}
	
	public void setConfirmPassword(String cnfpassword)
	{
		driver.findElement(txtPasswordConfirm).sendKeys(cnfpassword);
	}
	
	public void CheckboxPolicy()
	{
		driver.findElement(chkdPolicy).click();

	}
	
	public void btnContinue()
	{
		driver.findElement(btnContinue).click();

	}
	
	public String getConfirmationMsg() {
	try{
		return (driver.findElement(msgConfirmation).getText());
		
	}catch (Exception e) {
		return (e.getMessage());
	}
	
	}
	
}
