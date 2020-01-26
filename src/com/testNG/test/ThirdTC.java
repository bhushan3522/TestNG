package com.testNG.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdTC {
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("This is setup method");
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.println("This is tearDown method");
	}
	
	@Test(priority=1,invocationCount = 3)
	public void login() throws InterruptedException
	{
		System.out.println("User has performed login");
		//Assert.assertTrue(false);
		//Thread.sleep(60000);
	}
	
	@Test(priority=2,expectedExceptions = ArithmeticException.class)
	public void homePage()
	{
		System.out.println("User has navigated to Homepage");
		int a = 10/0;
	}
	
	@Test(priority=3,dependsOnMethods = {"login","homePage"},alwaysRun = false)
	public void createContact()
	{
		System.out.println("User has created a Contact");
	}
	
	@Test(priority=4,enabled=true)
	public void logout()
	{
		System.out.println("User has logged out");
	}

}
