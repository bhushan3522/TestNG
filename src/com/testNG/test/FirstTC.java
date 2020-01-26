//package com.testNG.test;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.io.FileHandler;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class FirstTC {
//	
//	WebDriver driver;
//	@BeforeMethod
//	public void setup()
//	{
//		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Chrome\\chromedriver.exe");
//		driver = new ChromeDriver();
//		
//	}
//	
//	@Test
//	public void openURL() throws InterruptedException, Exception
//	{
//		driver.get("http://www.google.com");
//		TakesScreenshot ss = (TakesScreenshot)driver;
//		File f = ss.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f, new File("E:\\Projects\\TestNG\\ss.png"));
//		Thread.sleep(3000);
//	}
//	
//	@AfterMethod
//	public void teardown()
//	{
//		driver.quit();
//	}
//
//}
