package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered Username");
		lp.setPassword(passWord);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust=new AddCustomerPage(driver);
		addCust.clickAddNewCustomer();
		logger.info("Providing Customer Details....");
		addCust.custName("Shivam");
		addCust.custgender("Male");
		addCust.custdob("10","15","1995");
		Thread.sleep(3000);
		addCust.custaddress("India");
		addCust.custcity("BLR");
		addCust.custstate("KA");
		addCust.custpinno("123456");
		addCust.custtelephoneno("1234567890");
		String email=randomString()+"@gmail.com";
		addCust.custemailid(email);
		addCust.custpassword("abcdef");
		addCust.custsubmit();
		Thread.sleep(3000);
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed...");
		}
		else
		{
			logger.info("test case failed...");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomNum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}

}
