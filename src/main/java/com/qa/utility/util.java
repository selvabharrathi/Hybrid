package com.qa.utility;

import com.qa.BaseTest.Base;

public class util extends Base {
	
	public static int timeout=30;
	public void switchtoframe()
	{
		driver.switchTo().frame("mainpanel");
	}

}
