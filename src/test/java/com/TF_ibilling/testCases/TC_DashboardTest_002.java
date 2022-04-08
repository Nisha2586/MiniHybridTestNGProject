package com.TF_ibilling.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TF_ibilling.pages.BasePage;
import com.TF_ibilling.pages.DashboardPage;
import com.TF_ibilling.pages.LoginPage;

public class TC_DashboardTest_002 extends BasePage {
	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;

//@Test
	@Parameters({"username","password"})
	public void ValidUserShouldBeAbleToAccessAddCustomerMenu(String us,String ps) {
		driver.get(baseUrl);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(us);
		loginPage.insertPassword(ps);
		loginPage.clickSininButton();
	
	dashboardPage=PageFactory.initElements(driver,DashboardPage.class);
	dashboardPage.verifydashboardpage();dashboardPage.clickTransactionSideMenu();dashboardPage.clickNewDeposit();
}

}
