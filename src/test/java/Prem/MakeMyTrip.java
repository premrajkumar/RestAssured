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

public class MakeMyTrip {
	@Test
	public void main() throws InterruptedException, EncryptedDocumentException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String Fromdata = "BOM";
		String Todata = "DEL";
		driver.get("https://www.makemytrip.com/");
		//driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Fromdata);
		driver.findElement(By.xpath("//div[text()='"+Fromdata+"']")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Todata);
		driver.findElement(By.xpath("//div[text()='"+Todata+"']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
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
		String path = "./src/test/resources/Makemytrip.xlsx";
		int r=1;
		for (WebElement fn : flightname) {
			//ex.setdata(path, r++, 0, fn.getText());
			FileInputStream file = new FileInputStream(path);
			Workbook book = WorkbookFactory.create(file);
			Sheet sh = book.getSheet("Sheet1");
			Row row = sh.getRow(r++);
			row.createCell(0).setCellValue(fn.getText());
		FileOutputStream fout = new FileOutputStream(path);
		book.write(fout);
		book.close();
		}
		
		int a=1;
		int b=1;
		for(int i=0;i<flighttime.size();i++)
		{
			if(i%2==0)
			{
			ex.setdata(path, a++, 2, flighttime.get(i).getText());
			}
			
			else
			{
				ex.setdata(path, b++, 5, flighttime.get(i).getText());
			}
		}
		
		int c=1;
		for (WebElement fc : flightcode) {
			
			ex.setdata(path, c++, 1, fc.getText());
		}
		
		int d=1;
		int e=1;
		for(int k=0;k<place.size();k++)
		{
			if(k%2==0)
			{
			ex.setdata(path, d++, 3, place.get(k).getText());
			}
			
			else
			{
				ex.setdata(path, e++, 4, place.get(k).getText());
			}
		}
		
		int tr=1;
		for (WebElement webE : travelduration) {
			ex.setdata(path, tr++, 6, webE.getText());
		}
		
		int am=1;
		for (WebElement amt : amount) {
			ex.setdata(path, am++, 7, amt.getText());
		}
		
		driver.quit();
		}
			

		
	}

	
//span[@class='linkText pointer'])[1] =for more click
