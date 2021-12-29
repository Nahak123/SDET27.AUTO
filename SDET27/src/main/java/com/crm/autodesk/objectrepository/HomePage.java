package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility {
	@FindBy(linkText = "Organizations")
	private WebElement Organizationslnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contactslnk;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	 private WebElement administratorDropDown;
	
	
	@FindBy(linkText = "Sign Out")
	private WebElement logoutBtn;
	
	// initiolize
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//bussiness logic
	
	public void Organizations() {
		Organizationslnk.click();
	}
	
	public void Contacts () {
		Contactslnk.click();
	}
	
	public void logout(WebDriver driver) {
		WebdriverUtility wu = new WebdriverUtility();
		wu.mouseOverOnElemnet(driver,administratorDropDown);
		logoutBtn.click();	
	}
	
	
	

}
