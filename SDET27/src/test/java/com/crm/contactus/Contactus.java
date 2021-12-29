package com.crm.contactus;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Contactus {
	 
	public static void main(String[] args) throws Throwable {
		  WebDriver driver = null;
		Random rand= new Random();
		int randNum = rand.nextInt(5000);
		
		FileInputStream fis = new FileInputStream("./Data/commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String URN = p.getProperty("urn");
		String PSW = p.getProperty("psw");
		String BROWSER = p.getProperty("browser");
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(URN);
		driver.findElement(By.name("user_password")).sendKeys(PSW);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		FileInputStream fie = new FileInputStream("./Data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fie);
		String s = wb.getSheet("sheet2").getRow(1).getCell(2).getStringCellValue()+randNum;
		
		driver.findElement(By.name("accountname")).sendKeys(s);
		driver.findElement(By.name("button")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt ='Create Contact...']")).click();
		String c = wb.getSheet("sheet2").getRow(2).getCell(3).getStringCellValue();
		
		
			
	}

}
