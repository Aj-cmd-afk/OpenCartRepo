package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;


/*
 * Data is valid - login success - test passed - logout
 * Data is valid - login failed - test fail
 * 
 * Data is invalid- login success - test fail - logout
 * Data is invalid- login failed - test pass
 */

public class TC003_LogInDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") //getting DataProvider from different class
	public void verify_login_DDT(String email, String pwd, String exp) 
	{
	logger.info("*****Starting TC003_LoginDDT test case***");
	
	
	try {
		//HomePage
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	logger.info("******On Login Page");
	
	//Login Page
	LoginPage lp = new LoginPage(driver);
	lp.enterEmail(email);
	lp.enterPassword(pwd);
	lp.ClickLoginButton();
	
	
	logger.info("******Enterend in My Account Page *****");
	
	//MyAccount
	MyAccountPage ma = new MyAccountPage(driver);
	boolean targetPage=ma.isMyAccountExists();
	
	Assert.assertEquals(targetPage, true, "Login failed!!!!!!");
	
	
	
	/*Data is valid - login success - test passed - logout
	 * - login failed - test fail
	 * 
	 * Data is invalid- login success - test fail - logout
	 * - login failed - test pass
	*/
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage==true)
		{	
			ma.logout();
			Assert.assertTrue(true);
			
		}else 
		{
			Assert.assertTrue(false);
		}
	} 
	if(exp.equalsIgnoreCase("Invalid"))
	{

		if(targetPage==true)
		{	
			ma.logout();
			Assert.assertTrue(false);
			
		}else 
		{
			Assert.assertTrue(true);
		}
	}
		
	logger.info("*****Ending TC003_LoginDDT test case***");
	
	}catch(Exception e)
		{
		Assert.fail();
			}
	}
	
	
}
