package com.crm.contactus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;

public class CreateContactWithOrganization {


	public static void main(String[] args) throws Throwable {
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();
		String value = eu.getDataFromExcel("Sheet1",1,2);

		int randNum = ju.getRandomNumber();


		FileUtility fu = new FileUtility();
		String URL = fu.getPropertyKeyValue("url");
		String URN = fu.getPropertyKeyValue("urn");
		String PSW = fu.getPropertyKeyValue("psw");
		String BROWSER = fu.getPropertyKeyValue("browser");

		WebDriver driver = null;
		//Random rand= new Random();
		//int randNum = rand.nextInt(5000);

		//FileInputStream fis = new FileInputStream("./Data/commonData.properties");
		//Properties p = new Properties();
		//p.load(fis);
		//String URL = p.getProperty("url");
		//String URN = p.getProperty("urn");
		//String PSW = p.getProperty("psw");
		//String BROWSER = p.getProperty("browser");
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
		//FileInputStream fie = new FileInputStream("./Data/testscript.xlsx");
		/*Workbook wb = WorkbookFactory.create(fie);
		String s = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue()+randNum;
		driver.findElement(By.name("accountname")).sendKeys(s);

		String s1 = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue()+randNum;
		driver.findElement(By.name("industry")).sendKeys(s1);

		String s2 = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue()+randNum;
		driver.findElement(By.name("accounttype")).sendKeys(s2);


		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		String test = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();*/
		if(test.contains("Organization")) {
			System.out.println("succesfuly create");

		}else {
			System.out.println("not create");
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		String s4 = wb.getSheet("Sheet2").getRow(1).getCell(2).getStringCellValue()+randNum;

		driver.findElement(By.name("lastname")).sendKeys(s4);
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String pwh = driver.getWindowHandle();
		while(it.hasNext()) {
			String cid = it.next();
			driver.switchTo().window(cid);
			String mtc = driver.getTitle();
			if(mtc.contains("Accounts")) {
				break;
			}			
		}
		driver.findElement(By.id("search_txt")).sendKeys(s);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+s+"']")).click();
		driver.switchTo().window(pwh);
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains("Contact")) {
			System.out.println("create successfully");
		}else {
			System.out.println("fail");
		}
		WebElement e = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();




	}

}
