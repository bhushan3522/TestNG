package Dec26;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Guru99_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		Actions action = new Actions(driver);
		
		WebElement home = driver.findElement(By.xpath("//a[contains(text(),\"Home\")]"));
		WebElement homebox = driver.findElement(By.xpath("//a[contains(text(),\"Home\")]//ancestor::tr[1]"));
		
		System.out.println(homebox.getCssValue("background-color"));
		action.moveToElement(home).perform();
		System.out.println(homebox.getCssValue("background-color"));

		WebElement username = driver.findElement(By.cssSelector("input[name=userName]"));
		action.click(username).keyDown(Keys.SHIFT).sendKeys("bhushan").keyUp(Keys.SHIFT).build().perform();
		
		action.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
