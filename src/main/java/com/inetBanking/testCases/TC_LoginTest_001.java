package com.inetBanking.testCases;

import java.io.IOException;

//import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		driver .get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp =new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("Entered Username");
		
		lp.setPassword(passWord);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		 //String title = driver.getTitle();
		 //System.out.println("The page title is : " +title);
		 
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test Failed");
		}
		
	}
	

}
