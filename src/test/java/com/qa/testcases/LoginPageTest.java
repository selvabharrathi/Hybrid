package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends Base{
	
	LoginPage lp;
	HomePage hp;
	LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialise();
		lp=new LoginPage();
	}
	
	@Test
	public void logintest()
	{
		hp=lp.login();
		
	}
	@Test
	public void logotest()
	{
		if(lp.checkLogo())
			System.out.println("Logo is displayed");
		else
			System.out.println("Logo is not displayed");
	}
	@AfterMethod()
	public void teardown()
	{
		driver.close();
	}

}
