package Prem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

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

public class MakemyTrip1 {
	
	@Test
	public void main() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//div[.='BOM']")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//div[.='BLR']")).click();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Wed Nov 30 2022']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		driver.findElement(By.xpath("//p[@class='appendBottom15']/span[@class='linkText pointer']")).click();
		List<WebElement> types = driver.findElements(By.xpath(
				"//p[.='Popular Filters']/ancestor::div[@class='filtersOuter']/descendant::div[@class='makeFlex flexOne gap-x-10']"));
		List<WebElement> cbs = driver.findElements(By.xpath(
				"//p[.='Popular Filters']/ancestor::div[@class='filtersOuter']/descendant::div[@class='makeFlex flexOne gap-x-10']/span[@class='customCheckbox']"));
		for (int j = 0; j < types.size(); j++) {
			String te = types.get(j).getText();
			int n = 0;
			for (int i = 0; i < te.length(); i++) {
				if (Character.isDigit(te.charAt(i))) {
					n = (n * 10) + (te.charAt(i) - 48);
				}
			}
			if (n <= 10) {
				cbs.get(j).click();
			}
		}

		for (int i = 0; i < 3; i++) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(3000);
		}
		List<WebElement> flightName = driver.findElements(By.xpath("//p[@class='boldFont blackText airlineName']"));
		List<WebElement> flightCode = driver.findElements(By.xpath("//p[@class='fliCode']"));
		List<WebElement> arrivalTime = driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']"));
		List<WebElement> departureTime = driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='textRight flexOne']"));

		Workbook wb = WorkbookFactory.create(new FileInputStream("./src/test/resources/Makemytrip1.xlsx"));
		Sheet sheet = wb.getSheet("Sheet1");
		for (int i = 1; i <= flightName.size(); i++) {
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(flightName.get(i - 1).getText());
			row.createCell(1).setCellValue(flightCode.get(i - 1).getText());
			row.createCell(2).setCellValue(arrivalTime.get(i - 1).getText());
			row.createCell(3).setCellValue(departureTime.get(i - 1).getText());
			row.createCell(4).setCellValue(price.get(i - 1).getText());

			wb.write(new FileOutputStream("./src/test/resources/Makemytrip1.xlsx"));
		}
		wb.close();
		driver.close();

}
}
