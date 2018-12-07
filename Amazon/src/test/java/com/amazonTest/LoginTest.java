package com.amazonTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.generaiclib.BaseClass;
import com.amazon.objectRepositorylib.Home;
import com.amazon.objectRepositorylib.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage lp=null;
	public LoginTest() {
		//lp = PageFactory.initElements(driver, LoginPage.class);
	}

	@DataProvider
	public Object[][] getLoginData(){
		return new Object[][] {
			{"un1","pwd1"},
			{"un2","pwd2"},
			{"","pwd2"},
			{"un1",""}
		};
	}

	@Test(dataProvider="getLoginData")
	public void testLoginFlows(String un,String pwd) throws IOException, InterruptedException {
		try {
			lp = PageFactory.initElements(driver, LoginPage.class);
			try {
				lp.logout();
			}catch(Exception e) {
				//e.printStackTrace();
				driver.get("https://www.amazon.com/ap/signin?ie=UTF8&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&_encoding=UTF8&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&ignoreAuthState=1&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&ie=UTF8&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&fromAuthPrompt=1");
			}
			System.out.println(un+" "+pwd);
			lp.login(un,pwd);
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
	
	//@AfterMethod
	public void loginToAmazon() throws IOException {
		lp.login();
	}

}
