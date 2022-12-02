package Prem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {    //"https://in.bookmyshow.com/explore/home/bengaluru"
	@Test
	public void main() throws InterruptedException, EncryptedDocumentException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.findElement(By.xpath("//div[@class='sc-gmeYpB jVkKUA']/child::span")).click();
		driver.findElement(By.xpath("//span[.='Bengaluru' and @class='sc-dRCTWM JQbba']")).click();
		driver.findElement(By.xpath("//span[.='Search for Movies, Events, Plays, Sports and Activities']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']")).sendKeys("Gandhada");
		//driver.findElement(By.xpath("//a[.='GG - Gandhada Gudi (U)']")).click();
		driver.findElement(By.xpath("//span[@class='sc-jhaWeW ChCae']")).click();
		driver.findElement(By.xpath("//div[@class='styles__CtaWrapper-sc-qswwm9-8 JInhj']//button[@class='CommonContainers__ButtonComponent-sc-8f9mtj-0 CommonContainers__CtaComponent-sc-8f9mtj-1 styles__CtaButtonContainer-sc-1vmod7e-0 emIChW']")).click();
		driver.findElement(By.xpath("//div[@class='date-numeric' and contains(.,'02')]")).click();
		driver.findElement(By.xpath("//button[.='Not Now']")).click();
		
		for (int i = 0; i < 3; i++) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(3000);
		}
		
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='__venue-name']"));
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='showtime-pill-wrapper']"));
		//List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='__details']"));
		
		String path = "./src/test/resources/BookMyShow.xlsx";
		
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		Sheet sheet = wb.getSheet("Sheet1");
		for (int i = 1; i <= list.size(); i++) {
			Row row = sheet.getRow(i);
			row.createCell(0).setCellValue(list.get(i - 1).getText());
			row.createCell(1).setCellValue(list1.get(i - 1).getText());
			wb.write(new FileOutputStream(path));
		}
		wb.close();		
		driver.close();
	}
}
