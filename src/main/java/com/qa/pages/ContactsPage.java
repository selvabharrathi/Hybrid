package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.BaseTest.Base;

public class ContactsPage extends Base{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
//	@FindBy(xpath="//tbody/descendant::tr/descendant::a[contains(text(),'"+p.getProperty("name")+"')]/../preceding-sibling::td/input")
//	WebElement contactcheckbox;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean varifycontactspage()
	{
		return contactslabel.isDisplayed();
	}
	public void clickoncontactcheckbox(String name)
	{
		driver.findElement(By.xpath("//tbody/descendant::tr/descendant::a[contains(text(),'"
	                      +name+"')]/../preceding-sibling::td/input")).click();
	}
	public void addcontact(String title,String name,String surname,String company)
	{
		Select s=new Select(driver.findElement(By.name("title")));
		s.selectByVisibleText(title);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='surname']")).sendKeys(surname);
		driver.findElement(By.xpath("//input[@name='client_lookup']")).sendKeys(company);
		driver.findElement(By.xpath("//input[@value='Save' and @type='submit']")).click();
		
	}
}
