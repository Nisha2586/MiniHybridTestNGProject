package com.TF_ibilling.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TF_ibilling.pages.BasePage;
import com.TF_ibilling.pages.DashboardPage;
import com.TF_ibilling.pages.LoginPage;
import com.TF_ibilling.pages.TransactionPage;
import com.TF_ibilling.util.ExcelReader;

import junit.framework.Assert;


public class TC_TransactionTest_003 extends BasePage {
	// WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	TransactionPage transactionPage;

	@Test//(dataProvider = "TransactionNewDepositData")
	//@Parameters({ "username", "password" })
	
	public void ValidUserShouldBeAbleToAccessAddCustomerMenu() {
		// driver=init();
		driver.get(baseUrl);
		
		String path = "src\\main\\java\\com\\TF_ibillimg\\testDatas\\TransactionNewDepositData.xlsx";
		String account = ExcelReader.getCellData(path,"TransactionNewDeposit", "Account", 2);
		String description= ExcelReader.getCellData(path,"TransactionNewDeposit", "Description", 2);
		String amount =ExcelReader.getCellData(path,"TransactionNewDeposit", "Amount", 2);
		
		
		
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSininButton();
		logger.info("Signed In");

		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifydashboardpage();
		dashboardPage.clickTransactionSideMenu();
		dashboardPage.clickNewDeposit();
		logger.info("Clicked New Deposit");

		transactionPage = PageFactory.initElements(driver, TransactionPage.class);
		Assert.assertEquals("Transactions- iBilling", getTitle());
		transactionPage.selectAccountDropDownMenu(account);
		// transactionPage.insertDate("2022-05-07");
		transactionPage.insertDescription(description);
		transactionPage.insertAmount(amount);
		transactionPage.clickSubmit();
		Assert.assertEquals("Transactions- iBilling", getTitle());
		logger.info("Transaction successfull");
	}
//	@DataProvider(name="TransactionNewDepositData")
//	String getData(String data){
//		String path = "src\\main\\java\\com\\TF_ibillimg\\testDatas\\TransactionNewDepositData.xlsx";
//		//com.TF_ibilling.util.ExcelReader.setExcelReader(path);
//		switch(data){
//		case "account":
//		String account = com.TF_ibilling.util.ExcelReader.getCellData(path,"TransactionNewDeposit", "Account", 2);
//		return account;
//		case "description":
//		String description= com.TF_ibilling.util.ExcelReader.getCellData(path,"TransactionNewDeposit", "Description", 2);
//		return description;
//		case "amount":
//		String amount = com.TF_ibilling.util.ExcelReader.getCellData(path,"TransactionNewDeposit", "Amount", 2);
//		return amount;
//		default:
//	      System.out.println("Data Fetched");
//		}
//		return data;
//	}

}
