package com.testNG.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTC {
	
	
	
	@Test(groups="Print")
	public void test1()
	{
		System.out.println("this is test 1");
	}
	@Test(groups="Print")
	public void test2()
	{
		System.out.println("this is test 2");
	}
	
	@Test(groups= {"sum","Print"})
	public void test3()
	{
		System.out.println("Sum");
	}
	
	@Test(groups="sum")
	public void test4()
	{
		System.out.println("sum 2");
	}
	
}
