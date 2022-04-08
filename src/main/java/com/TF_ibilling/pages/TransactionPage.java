package com.TF_ibilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TransactionPage {
	WebDriver driver;

	public TransactionPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")WebElement ACCOUNT_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"date\"]")WebElement DATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")WebElement DESCRIPTION_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"amount\"]")WebElement AMOUNT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")WebElement SUBMIT_BUTTON_ELEMENT;
	//@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]")WebElement TRANSACTION_SUCCESSFULL_ELEMENT;
	//@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[2]/div[1]/div/div[1]/h5")WebElement ADD_DEPOSIT_ELEMENT;
	//@FindBy(how = How.XPATH, using = "//*[@id="page-wrapper"]/div[3]/div[2]/div[2]/div/div[1]/h5")RECENT_DEPOSITS_ELEMENT;
	
	public void selectAccountDropDownMenu(String visibleText) {
		Select sel = new Select(ACCOUNT_DROPDOWN_ELEMENT);
		sel.selectByVisibleText(visibleText);
	}

	public void insertDate(String date) {//yyyy-mm-dd
		DATE_ELEMENT.sendKeys(date);;
	}

	public void insertDescription(String description) {
		DESCRIPTION_ELEMENT.sendKeys(description);
	}
	public void insertAmount(String amount) {
		AMOUNT_ELEMENT.sendKeys(amount);
	}
	public void clickSubmit() {
		SUBMIT_BUTTON_ELEMENT.click();
	}
//	public void verifyTransactionAdded() {
//		Assert.assertEquals(ADD_DEPOSIT_ELEMENT.getText(),"Add Deposit","wrong page");
//	}

}
