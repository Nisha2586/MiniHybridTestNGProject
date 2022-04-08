package com.TF_ibilling.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {
		File src = new File("src\\main\\java\\configuration\\config.properties");
		try {
			FileInputStream fs = new FileInputStream(src);
			prop = new Properties();
			prop.load(fs);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}
	public String getApplicationsername() {
		String username = prop.getProperty("username");
		return username;
	}
	public String getApplicationPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	public String getBrowser() {
		String br = prop.getProperty("browser");
		return br;
	}
	public String getChromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxpath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getIEpath() {
		String iepath = prop.getProperty("iepath");
		return iepath;
	}
}
