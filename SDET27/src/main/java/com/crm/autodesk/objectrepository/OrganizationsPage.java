package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationsPage {

	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement createOrganizationlookupimg;

	@FindBy(name = "search_text")
	private WebElement searchEdt;

	@FindBy(name ="submit")
	private WebElement searchBtn;
	
	public OrganizationsPage() {
		
	}
	





}
