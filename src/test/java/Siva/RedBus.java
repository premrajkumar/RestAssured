package Siva;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	List<WebElement> ele;
	int count=0;

	@Test
	public void bus() throws  InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Robot rb = new Robot();
		driver.get("https://www.redbus.in/bus-tickets");
		driver.findElement(By.xpath("//input[@placeholder='FROM']")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		driver.findElement(By.xpath("//input[@placeholder='TO']")).sendKeys("Dindigul");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		driver.findElement(By.xpath("//input[@placeholder='ONWARD DATE']")).sendKeys("24-Nov-2022");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		driver.findElement(By.xpath("//button")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		String nobus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		for (int i = 0; i < 5; i++) {
			js.executeScript("window.scrollBy(0,1000)");	
			List<WebElement> ele = driver.findElements(By.xpath("//div[@id='result-section']//div[@scrollthreshold='1']/ul/div/li//div[@class='travels lh-24 f-bold d-color']"));
			Thread.sleep(5000);
			for (WebElement webElement : ele) {
				String name = webElement.getText();
				System.out.println(name);
				count++;
			}

		}
		
			
		driver.quit();
		
		
	}

}

