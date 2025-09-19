package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verifyLogin()
	{
		logger.info("********Starting TC002_Login Test ************");
		
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("******On Login Page");
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.ClickLoginButton();
		
		
		logger.info("******Enterend in My Account Page *****");
		MyAccountPage ma = new MyAccountPage(driver);
		boolean targetPage=ma.isMyAccountExists();
		
		Assert.assertEquals(targetPage, true, "Login failed!!!!!!");
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*******Finished TC002_Login testCase******");
		
	}

}
