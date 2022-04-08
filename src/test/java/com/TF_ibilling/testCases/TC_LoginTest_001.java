package com.TF_ibilling.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TF_ibilling.pages.BasePage;
import com.TF_ibilling.pages.LoginPage;
import com.TF_ibilling.util.ExcelReader;

public class TC_LoginTest_001 extends BasePage {
	LoginPage loginPage;
	
	//@Parameters({"username","password"})
	public void validUserShouldAbleToLogin(String us,String ps) {
		driver.get(baseUrl);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(us);
		loginPage.insertPassword(ps);
		loginPage.clickSininButton();
	}
	
	@Test(dataProvider = "NegativeLoginData")
		public void negativeLoginTest(String us,String ps) {
		driver.get(baseUrl);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(us);
		loginPage.insertPassword(ps);
		loginPage.clickSininButton();
		
	}
	
	@DataProvider(name="NegativeLoginData")
	String[][] getData() throws IOException{
		String path = "src\\main\\java\\com\\TF_ibillimg\\testDatas\\TF_Ibilling_NegativeLoginData.xlsx";
		int rowcount=ExcelReader.getRowCount(path, "NegativeLoginData");
		int colcount = ExcelReader.getCellCount(path, "NegativeLoginData", 1);
		
		String negLogindata[][] = new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++) {
			for (int j=0;j<colcount;j++) {
				negLogindata[i-1][j]=ExcelReader.getCellDataArray(path,"NegativeLoginData", i, j);
				
			}
		}
		return negLogindata;
	}

}
