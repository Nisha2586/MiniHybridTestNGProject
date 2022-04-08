package com.TF_ibilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"page-wrapper\"]/div[2]/div/h2")WebElement DASHBOARD_HEADER_PAGE_ELEMENT;
	@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[5]/a/span[1]")WebElement TRANSACTION_SIDEMENU_ELEMENT;
	@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")WebElement NEW_DEPOSIT_ELEMENT;
	
	public void verifydashboardpage() {
		Assert.assertEquals(DASHBOARD_HEADER_PAGE_ELEMENT.getText(), "Dashboard", "Dashboard page not found.");
	}
	public void clickTransactionSideMenu() {
		TRANSACTION_SIDEMENU_ELEMENT.click();	
	}
	public void clickNewDeposit() {
		NEW_DEPOSIT_ELEMENT.click();	
	}

}
