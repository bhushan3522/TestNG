package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\Gecko\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.facebook.com");
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}

	
	@Test
	public void fillSignupDetails() {
		driver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("abc");
		driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("abc");
	}
}
