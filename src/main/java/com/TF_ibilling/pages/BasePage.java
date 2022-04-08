package com.TF_ibilling.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.TF_ibilling.util.ReadConfig;

public class BasePage {

	ReadConfig readconfig = new ReadConfig();
	
	
	public  static WebDriver driver;
	public static Logger logger;
	public  String baseUrl = readconfig.getApplicationUrl();
//	public  String username = readconfig.getApplicationsername();
//	public  String password =readconfig.getApplicationPassword();
	public String br = readconfig.getBrowser();
		
	
	@BeforeClass
	//@Parameters("browser")
	public void init() {
		
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}else if (br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logger = Logger.getLogger("TF_ibilling");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	public static String getTitle() {
		return driver.getTitle();
	}
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
