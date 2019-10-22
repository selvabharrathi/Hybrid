package com.qa.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.qa.utility.util;

public class Base {
	
	public static Properties p;
	FileInputStream fis;
	public static WebDriver driver;
	public Base()
	{
		p=new Properties();
		try {
			fis = new FileInputStream("D:\\jaSelenium\\hybrid\\src\\main\\java\\com\\qa\\config\\configration.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialise()
	{
		String browser=p.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(util.timeout,TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));
	}
	
	
}
