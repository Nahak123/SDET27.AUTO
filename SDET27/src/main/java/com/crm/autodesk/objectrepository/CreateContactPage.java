package com.crm.autodesk.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebdriverUtility;
import com.mysql.cj.jdbc.Driver;

public class CreateContactPage extends WebdriverUtility {
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;

	@FindBys({@FindBy(name="account_id"),@FindBy(xpath="//img[@alt='Select']")})
	//@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement selectOrglookUpImg;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement saveBtn;

	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getCreateOrglookUpBtn() {
		return selectOrglookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//business library to create contact
	public void createContact(String lastName)
	{
		lastnameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	public void createContact(WebDriver driver, String lastName, String orgName)
	{
		lastnameEdt.sendKeys(lastName);
		selectOrglookUpImg.click();
		swithToWindow(driver, "Accounts");
		driver.findElement(By.linkText(orgName)).click();
		swithToWindow(driver,"Contacts");
		saveBtn.click();
	}
}
