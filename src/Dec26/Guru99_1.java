package Dec26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/radio.html");
		
		System.out.println("Selecting First radio button");
		WebElement Option1 = driver.findElement(By.xpath("//input[@value=\"Option 1\"]"));
		Option1.click();
		
		Thread.sleep(5000);
		
		System.out.println("Selecting Second radio button");
		WebElement Option2 = driver.findElement(By.xpath("//input[@value=\"Option 2\"]"));
		Option2.click();
		
		System.out.println("Checking if Option 1 is seleted or not");
		if(Option1.isSelected()) {
			System.out.println("Option 1 is selected");
		}
		else
			System.out.println("Option 1 is not selected");
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		for(WebElement e : checkBoxes) {
			e.click();
		}
	}
	
		
		
	}


