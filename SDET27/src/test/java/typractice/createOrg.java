package typractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.BaseClass;
import com.crm.autodesk.objectrepository.HomePage;

public class createOrg extends BaseClass {
	@Test
	public void CreateOrgTest() {
		HomePage hp = new HomePage(driver);
		hp.Organizations();
	}
}

	