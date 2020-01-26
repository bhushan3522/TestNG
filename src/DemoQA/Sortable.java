package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
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

public class Sortable {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		wait = new WebDriverWait(driver,20);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
//		Thread.sleep(20000);
//		driver.close();
	}
	
	@Test(enabled=false)
	public void sortFirstElement() {
		driver.findElement(By.xpath("//a[contains(text(),\"Sortable\")]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));
		
		WebElement firstItem = driver.findElement(By.xpath("//*[contains(text(),\"Item 1\")]"));
		WebElement secondItem = driver.findElement(By.xpath("//*[contains(text(),\"Item 2\")]"));
		WebElement thirdItem = driver.findElement(By.xpath("//*[contains(text(),\"Item 3\")]"));
		
		Point secondLocation = secondItem.getLocation();
		int secondX = secondLocation.getX();
		int secondY = secondLocation.getY();
		
		Point thirdLocation = thirdItem.getLocation();
		int thirdX = thirdLocation.getX();
		int thirdY = thirdLocation.getY();
		
		System.out.println("Co-ordinates of second box are : "+secondX+" and"+secondY);
		System.out.println("Co-ordinates of third box are : "+thirdX+" and"+thirdY);

		Actions action = new Actions(driver);
		action.clickAndHold(firstItem)
		.moveToElement(secondItem)
		.moveByOffset(0, 10)
		.release()
		.build()
		.perform();
		/*
		 * Actions action = new Actions(driver); action.clickAndHold(firstItem)
		 * .moveByOffset(0, 100) .build().perform();
		 */
	}
	
	@Test(enabled=false)
	public void selectElements() {
		
		driver.findElement(By.xpath("//a[contains(text(),\"Selectable\")]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));
		
		WebElement thirdItem = driver.findElement(By.xpath("//*[contains(text(),\"Item 3\")]"));
		thirdItem.click();
		
		Assert.assertEquals(thirdItem.getCssValue("background-color"),"rgba(243, 152, 20, 1)");
	}
	
	@Test(enabled=false)
	public void resizable() {
		driver.findElement(By.xpath("//a[contains(text(),\"Resizable\")]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));
		
		WebElement rightMove = driver.findElement(By.cssSelector(".ui-resizable-e"));
		Actions action = new Actions(driver);
		
		action.moveToElement(rightMove)
		.moveByOffset(0, 30)
		.clickAndHold()
		.moveByOffset(50, 0)
		.release()
		.build().perform();
	}
	
	@Test(enabled = false)
	public void dragElement() {
		driver.findElement(By.xpath("//a[contains(text(),\"Droppable\")]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable)
		.build().perform();
	}
	
	@Test
	public void testWindows() {
		driver.findElement(By.xpath("//a[contains(text(),\"Windows\")]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));
		
		driver.findElement(By.id("button1"));
	}

}
