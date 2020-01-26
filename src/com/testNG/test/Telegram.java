package com.testNG.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Telegram {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		   driver.get("http://seleniumpractise.blogspot.com/");
		   WebElement dd = driver.findElement(By.cssSelector("#tools"));
		   Select sel = new Select(dd);
		   
		   String docker = "Docker";
		   List<WebElement> listDD = sel.getOptions();
		   for(WebElement e : listDD)
		   {
			   if(e.getAttribute("value").equalsIgnoreCase(docker))
			   {
				   sel.selectByValue(e.getAttribute("value"));
				   break;
			   }
			   
		   }
		   
		   	}

}
