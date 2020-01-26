package Dec26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99_2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		WebElement countryDD = driver.findElement(By.name("country"));
		
		Select sel = new Select(countryDD);
	
		List<WebElement>countries = sel.getOptions();
		for(WebElement e : countries) {
			if(e.getAttribute("value").equalsIgnoreCase("INDIA")) {
				sel.selectByValue(e.getAttribute("value"));
				break;
			}
		}
		
		
	}

}
