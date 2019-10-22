package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest.Base;

public class HomePage extends Base {
	
	@FindBy(xpath="//td[contains(text(),'User: d_bharath D')]")
	WebElement namelabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contact;
	@FindBy(xpath="//a[@title='Deals']")
	WebElement deals;
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasks;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontact;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyhomepage()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(namelabel));
		return namelabel.isDisplayed();
	
	}
	public ContactsPage clickoncontacts()
	{
		contact.click();
		return new ContactsPage();
	}
	public DealsPage clickondeals()
	{
		deals.click();
		return new DealsPage();
	}
public TasksPage clickontasks()
{
	tasks.click();
	return new TasksPage();
}
public void newcontacts() 
{
//	String strjs="var element=arguments[0];"
//			+ "var mouseEventObj=document.createEvent('MouseEvents');"
//			+ "mouseEventObj.initEvent('mouseover',true,true);"
//			+ "element.dispatchEvent(mouseEventObj);";
//	((JavascriptExecutor)driver).executeScript(strjs,contact);
//	System.out.println(contact.isEnabled());
	Actions action=new Actions(driver);
	action.moveToElement(contact).build().perform();
   newcontact.click();
}

}
