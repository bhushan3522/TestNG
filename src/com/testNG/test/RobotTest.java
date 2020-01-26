package com.testNG.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class RobotTest {
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	}

}
