package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationpage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{	
		logger.info("*****Starting TC001_AccountRegistrationTest******");
		
		try
		{
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegis();
		logger.info("**Tapping on registartion**");
		
		AccountRegistrationpage ag = new AccountRegistrationpage(driver);
		logger.info("**Starting the Registration**");
		ag.setFirstname(randomString().toUpperCase()); //randomly first name
		ag.setLastName(randomString().toUpperCase()); //randomly last name
		ag.setEmail(randomString()+"@gmail.com"); //randomly generated email
		ag.setTelephone("9988"+randomNumber() );
		ag.setPassword("Check@123");
		ag.setConfirmPassword("Check@123");
		ag.CheckboxPolicy();
		ag.btnContinue();
		
		logger.info("**validating message**");
		String confmsg = ag.getConfirmationMsg();
		AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("**TestFinished**");
		}
		catch(Exception e)
		{
			logger.error("Test Failed......");
			logger.debug("debug logs...");
			AssertJUnit.fail();
		}
	}

		public String randomString()
		{
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public String randomNumber()
		{
			String generatedString = RandomStringUtils.randomNumeric(5);
			return generatedString;
		}
		
		
}
