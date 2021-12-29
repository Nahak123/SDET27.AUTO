package com.crm.createPurchaseOrder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCreatepurchaseOrder {

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
		WebElement mus = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/menuDnArrow.gif\"]"));
		action

	}

}
