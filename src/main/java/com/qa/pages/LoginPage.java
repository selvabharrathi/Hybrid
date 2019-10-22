package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest.Base;

public class LoginPage extends Base{

	@FindBy(name="username")
      WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement Login;
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement Logo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login()
	{
		this.username.sendKeys(p.getProperty("username"));
		this.password.sendKeys(p.getProperty("password"));
		this.Login.click();
		return new HomePage();
	}
	
	public boolean checkLogo()
	{
		return Logo.isDisplayed();
	}
}
