package EndToEndScenarios;

import static io.restassured.RestAssured.when;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericUtility.Iconstants;
import GenericUtility.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;

public class Test2Test {
	@Test
	public void createProject() throws InterruptedException
	{
		JavaUtility jv = new JavaUtility();
		int ran = jv.getrandomNumber(1200);
		String name = "prem"+ran;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Iconstants.AppUsername);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Iconstants.AppPassword);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("escape");
		WebElement dd = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sel = new Select(dd);
		sel.selectByIndex(1);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		String dt=null;
		int count=0;
		int duration=10;
		while(count<duration)
		{
			try {
		dt = driver.findElement(By.xpath("//tr/../following-sibling::tbody/tr/td[.='"+name+"']/preceding-sibling::td")).getText();
		if(dt.isEmpty())
		{
			continue;
		}
		}
			catch(Exception e)
			{
				Thread.sleep(2000);
				count++;
			}
		}
		
		System.out.println(dt);
		
		Response resp = when()
		.get("http://rmgtestingserver:8084/projects/"+dt);
//		String value = resp.jsonPath().get("projectId");
//		System.out.println(value);
		resp.then()
		.log().all();	
		
	}

}
