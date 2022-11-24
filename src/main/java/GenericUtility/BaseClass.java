package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	protected ExcelUtility excel;
	protected WebdriverUtility web;
	protected FileUtility file;
	private String url;
	protected JavaUtility jv;
	private String browser;
	protected WebDriver driver;
	protected LoginPage login;
	protected CommonPage com;
	public static JavaUtility sjv;
	public static WebDriver sdriver;
	
	/**
	 * intialize the all utility class
	 * open the excel, property file
	 * read the common data
	 * create the instance for browser(launch browser)
	 * maximize, implicit wait
	 * open the application
	 * intiallllllize jsexecutor, actions, webdriverwait
	 * create the instance for common object repo
	 */
	//@Parameters(value="browser")
	@BeforeClass(groups = "a")
	public void setupApp()
	{
		//create instance for the Generic Utility
		excel = new ExcelUtility();
		web = new WebdriverUtility();
		file = new FileUtility();
		jv = new JavaUtility();
		sjv=jv;
		
		//intiallize the property file and excelfile
		file.intializePropertyFile(Iconstants.PROPERTY_FILE);
		excel.openExcelPage(Iconstants.EXCEL);
		
		//fetch the data from property file
		url=file.getDataFromPropertyAfterIntialize("Appurl");
		browser = file.getDataFromPropertyAfterIntialize("Browser");
		
		//launching the browser and doing some browser setting
		driver = web.openBrowserWithApplication(browser, 15, url);
		sdriver=driver;
	}
	
	@AfterMethod(groups = "b")
	public void logoutSuccess()
	{
		//logout from the application
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		web.verifyWebPage(login.loginText(), "Login", driver, login.loginText());
		
	}
	
	@AfterClass(groups = "c")
	public void closeEntire()
	{
		web.closeTheApplication(driver);
		excel.closeExcelBook();	
	}

}
