package Siva;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAutosuggestions {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("moksha");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@class='G43f7e']/li"))));
		Thread.sleep(2000);
		List<WebElement> findElemnts = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
	System.out.println(findElemnts.size());
	    // ArrayList<WebElement> list = new ArrayList<WebElement>(findElemnts);
	    for(int i=0;i<findElemnts.size();i++){
	     System.out.println(findElemnts.get(i).getText());
	    }
	    Thread.sleep(2000);
	    driver.quit();
	     
	     
	     //for(WebElement wb:findElemnts){
			//System.out.println(wb.getText());
		}
//	    	int count = findElemnts.size();
//	    	System.out.println(count);
//	    	findElemnts.get(count);
	   
	     }


