package Dec26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99 {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/login.html");
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement pwd = driver.findElement(By.id("passwd"));
		
		email.sendKeys("abc");
		pwd.sendKeys("pwd");
		
		email.clear();
		pwd.clear();
		
		email.sendKeys("zxc");
		pwd.sendKeys("789");
	}

}
