package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactBtn;

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public void clickOncreatecontact() {
		createContactBtn.click();
	}


}




