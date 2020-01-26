package com.testNG.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleiumPrctice {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/");
		wait = new WebDriverWait(driver,20);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
	
	@Test(enabled=false)
	public void testTooltip() {
		
		String expectedHoverText = "Tooltip text";
		
		driver.findElement(By.xpath("//a[contains(text(),\"Tooltip\")]")).click();
		wait.until(ExpectedConditions.titleContains("Tooltip"));
		
		WebElement mouseHover = driver.findElement(By.xpath("//div[contains(text(),\"Hover\")]"));
		Actions action = new Actions(driver);
		
		action.moveToElement(mouseHover).build().perform();
		
		String hoverText= driver.findElement(By.cssSelector("span.tooltiptext")).getText();
		
		Assert.assertEquals(hoverText, expectedHoverText);
	}
	
	@Test
	public void delayedAlert() {
		driver.findElement(By.xpath("//a[contains(text(),\"Alert\")]")).click();
		wait.until(ExpectedConditions.titleContains("Alert"));
		
		driver.findElement(By.xpath("//button")).click();
		Alert al = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(al.getText());
		al.accept();
	}

}
