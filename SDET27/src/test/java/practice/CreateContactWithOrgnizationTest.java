package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.WebdriverUtility;
import com.crm.autodesk.objectrepository.ContactsPage;
import com.crm.autodesk.objectrepository.CreateContactPage;
import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.LoginPage;

public class CreateContactWithOrgnizationTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		FileUtility fu = new FileUtility();
		WebdriverUtility wu = new WebdriverUtility();

		String URL = fu.getPropertyKeyValue("url");
		String URN = fu.getPropertyKeyValue("urn");
		String PSW = fu.getPropertyKeyValue("psw");
		String BROWSER = fu.getPropertyKeyValue("browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else{
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		wu.waitForPageToLoad(driver);
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.login(URN, PSW);

		HomePage hp = new HomePage(driver);
		hp.Contacts();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOncreatecontact();

		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.createContact(driver, "RAHUL", "demo1");

		hp.logout(driver);
	}

}
