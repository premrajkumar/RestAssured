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

import GenericUtility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripSearch {
	@Test
	public void main() throws InterruptedException, EncryptedDocumentException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String from="BLR";
		String TO = "BOM";
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		driver.findElement(By.xpath("//div[@class='hsw_inputBox width160']/span[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(from);
		//driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		driver.findElement(By.xpath("//span[.='"+from+"']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(TO);
		driver.findElement(By.xpath("//span[.='"+TO+"']")).click();
		//driver.findElement(By.xpath("//span[@for='departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thursday, 1 December 2022']")).click();
		driver.findElement(By.xpath("//input[@id='return']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Friday, 2 December 2022']")).click();
		driver.findElement(By.xpath("//span[.='SEARCH']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='linkText pointer'])[1]")).click();
		List<WebElement> count = driver.findElements(By.xpath("//p[.='Popular Filters']/parent::div/descendant::span[@class='filterName']"));
		List<WebElement> click = driver.findElements(By.xpath("//p[.='Popular Filters']/parent::div/descendant::span[@class='customCheckbox']//span[@class='check']"));
		
		for (int i=0;i<count.size();i++){
			
			String val = count.get(i).getText();
			int sum=0;
			int tsum=0;
			for(int j=0;j<val.length();j++)
			{
				if(val.charAt(j)>='0' && val.charAt(j)<='9')
				{
					int n = val.charAt(j)-48;
					tsum=tsum*10+n;
				}
				else
				{
					sum=sum+tsum;
					tsum=0;
				}		
			}
			sum=sum+tsum;
			System.out.println(sum);
			
			if(sum>=1 && sum<=9)
			{
				click.get(i).click();
			}
		}
		
		for (int i = 0; i < 3; i++) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(3000);
		}
		//Thread.sleep(3000);
		List<WebElement> flightname = driver.findElements(By.xpath("//p[@class='boldFont blackText airlineName']"));	
		List<WebElement> flightcode = driver.findElements(By.xpath("//p[@class='fliCode']"));
		List<WebElement> flighttime = driver.findElements(By.xpath("//p[@class='appendBottom2 flightTimeInfo']"));
		List<WebElement> place = driver.findElements(By.xpath("//p[@class='blackText']"));
		List<WebElement> travelduration = driver.findElements(By.xpath("//div[@class='stop-info flexOne']"));
		List<WebElement> amount = driver.findElements(By.xpath("//p[@class='blackText fontSize18 blackFont white-space-no-wrap']"));
		ExcelUtility ex = new ExcelUtility();
		String path = "./src/test/resources/MakemyTripSearch.xlsx";
		
		for (WebElement fn : flightname) {
			System.out.println(fn.getText());
		}
		
		int a=1;
		int b=1;
		for(int i=0;i<flighttime.size();i++)
		{
			if(i%2==0)
			{
				System.out.println(flighttime.get(i).getText());
			//ex.setdata(path, a++, 2, flighttime.get(i).getText());
			}
			
			else
			{
				System.out.println(flighttime.get(i).getText());
				//ex.setdata(path, b++, 5, flighttime.get(i).getText());
			}
		}
		
		for (WebElement fc : flightcode) {
			
			System.out.println(fc.getText());
			//ex.setdata(path, c++, 1, fc.getText());
		}
		
		int d=1;
		int e=1;
		for(int k=0;k<place.size();k++)
		{
			if(k%2==0)
			{
			System.out.println(place.get(k).getText());
			//ex.setdata(path, d++, 3, place.get(k).getText());
			}
			
			else
			{
				System.out.println(place.get(k).getText());
				//ex.setdata(path, e++, 4, place.get(k).getText());
			}
		}
		
		int tr=1;
		for (WebElement webE : travelduration) {
			System.out.println(webE.getText());
			//ex.setdata(path, tr++, 6, webE.getText());
		}
		
		int am=1;
		for (WebElement amt : amount) {
			System.out.println(amt.getText());
			//ex.setdata(path, am++, 7, amt.getText());
		}
		
		driver.quit();
		
		
	}
}
