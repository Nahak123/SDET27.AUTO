package com.crm.autodesk.genericUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.LoginPage;

public class BaseClass {
	
		
		public	ExcelUtility eLib=new ExcelUtility();
		public	FileUtility fLib=new FileUtility();
		public	WebdriverUtility wLib= new WebdriverUtility();
		public	JavaUtility jLib=new JavaUtility();
		public	WebDriver driver;

	
		@BeforeClass
		public void lunchBrowser() throws Throwable
		{
			//read the data
			String BROWSER = fLib.getPropertyKeyValue("Browser");
			String URL = fLib.getPropertyKeyValue("URL");
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else
			{
				System.out.println("Invalid Browser");
			}
		    wLib.maximize(driver);
			wLib.waitForPageToLoad(driver);
			driver.get(URL);
			System.out.println("Browser lunched");
		}
		
		@BeforeMethod(groups = {"smokesuite","regressionsuite"})
		
		public void loginToApp() throws Throwable
		{
			//read the data
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			LoginPage lp= new LoginPage(driver);
			lp.login(USERNAME, PASSWORD);
			System.out.println("sucessfully login");
		}
		@AfterMethod
		public void logoutFromApp()
		{
			HomePage hp= new HomePage(driver);
			hp.logout(driver);
			System.out.println("sucessfully logout");
		}
		@AfterClass
		public void closeBrowser()
		{
			driver.quit();
			System.out.println("Browser closed");
		}
	
		}


