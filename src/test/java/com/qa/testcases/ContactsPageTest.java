package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest.Base;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utility.util;

public class ContactsPageTest extends Base {

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	util u;
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		lp=new LoginPage();
		cp=new ContactsPage();
		hp=lp.login();
		u=new util();
		u.switchtoframe();
		cp=hp.clickoncontacts();
	}
//	@Test
//	public void varifycontactspagetest()
//	{
//		Assert.assertTrue(cp.varifycontactspage(),"contacts page is not varified");
//	}

//@Test
//public void contactscheckboxclicktest()
//{
//	cp.clickoncontactcheckbox(p.getProperty("name"));
//}

//@DataProvider
//public void getData()
//{
//	
//}

	@Test
	public void validatenewcontacts()
	{
     Actions action=new Actions(driver);
     action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Companies')]"))).perform();
	hp.newcontacts();
     cp.addcontact("Mr.","tom" , "talbot", "google");
	}
	
}
