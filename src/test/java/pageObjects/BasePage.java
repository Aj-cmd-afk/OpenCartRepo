package pageObjects;

import org.openqa.selenium.WebDriver;

public class BasePage {
	//constructor
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		
	}

}
