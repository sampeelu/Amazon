package com.amazon.generaiclib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.amazon.objectRepositorylib.Home;
import com.amazon.objectRepositorylib.LoginPage;
import com.gargoylesoftware.htmlunit.Page;
import com.relevantcodes.extentreports.ExtentReports;
/**
 * Here launch browser, login and logout
 * @author sambhaw
 *
 */
public class BaseClass {
	public static WebDriver driver;
	Filelib file = new Filelib();
	public BaseClass() {
		
	}
	public ExtentReports extreport;
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		
		
		
		
		
		
		try {
			System.out.println("launch browser");
			System.out.println(file.getPropertyobj("browser"));
			String brwsr = file.getPropertyobj("browser");
			if(brwsr.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","H:\\QSP_Automation\\Amazon\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			else if((brwsr).equalsIgnoreCase("firefox") | (brwsr).equalsIgnoreCase("ff")) {
				System.setProperty("webdriver.gecko.driver","H:\\QSP_Automation\\Amazon\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if((brwsr).equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.iedriver.driver","./Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
			driver.get(file.getPropertyobj("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void loginAmazon() {
		try {
			LoginPage logpage = new LoginPage();
			System.out.println("URL "+file.getPropertyobj("url"));
			driver.get(file.getPropertyobj("url"));
			logpage.login();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@AfterClass
	public void logoutAmazon() {
		//Home hlogout = new Home();// this type of object creation not required
		Home hlogout = PageFactory.initElements(driver,Home.class);
		hlogout.logout();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
