package DataTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/html-contact-form/");
	}
	
	@DataProvider(name = "getExcelData")
	public Object[][] readDataFromExcel() {
		return ReadData.getData("F:\\Projects\\TestNG\\src\\DataTesting\\DemoQA.xlsx", "contact");
	}
	
	@Test(dataProvider="getExcelData")
	public void testContacts(String fName,String lName,String country) {
		driver.findElement(By.cssSelector(".firstname")).sendKeys(fName);
		driver.findElement(By.id("lname")).sendKeys(lName);
		driver.findElement(By.name("country")).sendKeys(country);
		
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}
	
	@AfterTest
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
}
