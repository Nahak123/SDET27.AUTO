package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="user_name")
	private WebElement user_nameEdt;

	@FindBy(name="user_password")
	private WebElement user_passwordEdt;

	@FindBy(id="submitButton")
	private WebElement submitButtonBtn;

	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver,this);

	}

	public WebElement getUser_nameEdt() {
		return user_nameEdt;
	}

	public WebElement getUser_passwordEdt() {
		return user_passwordEdt;
	}

	public WebElement getSubmitButtonBtn() {
		return submitButtonBtn;
	}

	//b logic
	public void login(String un,String psw) {
		user_nameEdt.sendKeys(un);
		user_passwordEdt.sendKeys(psw);
		submitButtonBtn.click();


	}

}

