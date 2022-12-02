package Siva;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneChildOpen {
	
	@Test
	public void main() throws AWTException, InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Robot rb = new Robot();
		for (int i = 0; i < 2; i++) {

			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_T);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_T);
			Thread.sleep(2000);
			
		}
		
		String twin = driver.getWindowHandle();
		Set<String> winds = driver.getWindowHandles();
		ArrayList<String> arr = new ArrayList<String>(winds);
		int len = arr.size();
		for(int i=0;i<len-1;i++)
		{
			driver.switchTo().window(arr.get(i));
			driver.close();
		}
		
//		for (String win : winds) {
//			if (win !=twin)
//				driver.switchTo().window(win);
//			driver.close();
		}
	}


