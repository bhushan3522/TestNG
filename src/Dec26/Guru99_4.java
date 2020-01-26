package Dec26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guru99_4 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()=\"ACCEPT\"]")))).click();
		
		driver.findElement(By.id("button1")).click();
		String mainWindow = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		
		Set<String>a=driver.getWindowHandles();
		for(String str : a) {
			driver.switchTo().window(str);
			System.out.println(driver.getTitle());
		}
		System.out.println(driver.switchTo().window(mainWindow).getTitle());
		
	}

}
