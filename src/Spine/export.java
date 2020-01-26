package Spine;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class export {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://vistaar.spinehr.in/login.aspx?ReturnUrl=%2f");
		driver.findElement(By.cssSelector("input[name=\"txtUser\"]")).sendKeys("V685");
		driver.findElement(By.cssSelector("input[name=\"txtPassword\"]")).sendKeys("Welcome@123");
		driver.findElement(By.cssSelector("input[name=\"btnLogin\"]")).click();
	}
	@Test
	public void exportOp() throws AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		WebElement selfService = driver.findElement(By.xpath("(//a[contains(text(),\"Self Service\")])[1]"));
		selfService.click();
		Actions action = new Actions(driver);
		WebElement payslip = driver.findElement(By.xpath("(//a[contains(text(),\"Payslip\")])[1]"));
		action.moveToElement(payslip).click().build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement refreshBtn=driver.findElement(By.xpath("//input[@type=\"submit\"]"));
		//refreshBtn.click();
		WebElement monthDD = driver.findElement(By.xpath("//select"));
		wait.until(ExpectedConditions.visibilityOf(monthDD));
		Robot robot = new Robot();
		Select sel = new Select(monthDD);
		
		List<WebElement> months = sel.getOptions();
		
		for(WebElement e:months) {
			String monthName = e.getText();
			StringSelection data = new StringSelection(monthName);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(data, data);
			
			sel.selectByVisibleText(monthName);
			refreshBtn.click();
			String mainWindow = driver.getWindowHandle();
			WebElement print = driver.findElement(By.xpath("//img[contains(@src,\"print\")]"));
			wait.until(ExpectedConditions.visibilityOf(print)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Set<String> windows = driver.getWindowHandles();
			for(String a :windows) {
				if(!a.equalsIgnoreCase(mainWindow)) {
					driver.switchTo().window(a);
					WebElement print1 = driver.findElement(By.xpath("//img[contains(@src,\"print\")]"));
					String mainWindow2 = driver.getWindowHandle();
					wait.until(ExpectedConditions.visibilityOf(print1)).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Set<String> newWindows = driver.getWindowHandles();
					for(String b:newWindows) {
						if(!b.equalsIgnoreCase(mainWindow2)) {
							driver.switchTo().window(b);
							robot.keyPress(KeyEvent.VK_ENTER);
						}
					}
				}
			}
			
		}
	}
	
}
