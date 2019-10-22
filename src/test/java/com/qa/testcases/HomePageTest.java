package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest.Base;
import com.qa.pages.ContactsPage;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utility.util;

public class HomePageTest extends Base {
	
	public LoginPage lp;
	HomePage hp;
	util u;
	ContactsPage cp;
	DealsPage dp;
	
	public HomePageTest()
	{
	     super();
	}
	
	@BeforeMethod
	public void setup()
	{
		 initialise();
		 u=new util();
		lp=new LoginPage();
		cp=new ContactsPage();
	     hp=lp.login();
	    
	}
	@Test
	public void VarifyHomePage()
	{
		u.switchtoframe();
		Assert.assertTrue(hp.verifyhomepage(),"Home page is not validated");
	}
	@Test
	public void varifycontactsbtn() throws InterruptedException
	{
		u.switchtoframe();
		//cp=
		hp.clickoncontacts();
		Thread.sleep(1000);
	}
	@Test
	public void varifyDealsbtn() throws InterruptedException
	{
		u.switchtoframe();
		dp=hp.clickondeals();
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
