package com.amazon.objectRepositorylib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.generaiclib.BaseClass;
import com.amazon.generaiclib.Filelib;
import com.amazon.generaiclib.WebDriverCommanFun;
/**
 * here only login element repository
 * @author sambhaw
 *
 */
public class LoginPage {
	public LoginPage() {
		f = new Filelib();
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	@FindBy(xpath="//a[@data-nav-role='signin']")
	private WebElement gologOut;
	
	@FindBy(id="nav-link-accountList")
	private WebElement signmovement;

	@FindBy(id="nav-flyout-ya-signin")
	private WebElement goToSignIn;

	@FindBy(id="ap_email")
	private WebElement email;

	@FindBy(id="ap_password")
	private WebElement pwd;

	@FindBy(id="signInSubmit")
	private WebElement clickSignInbutton;
	@FindBy(partialLinkText="Sign Out")
	private WebElement signOut;
	
	Filelib f;
	

	public void login() throws IOException {
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(signmovement).build().perform();
		// go to sign option		
		goToSignIn.click();

		email.sendKeys(f.getPropertyobj("Email"));
		pwd.sendKeys(f.getPropertyobj("Password"));
		clickSignInbutton.click();
	}
	
	public void login(String un,String pasword) throws IOException {
		email.clear();
		email.sendKeys(un);
		pwd.clear();
		pwd.sendKeys(pasword);
		clickSignInbutton.click();
	}
	
	public void logout(){
		System.out.println("inside logout................");
		//common.mouseMovementActions(gologOut);
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(gologOut).build().perform();
		//Thread.sleep(3000);
		System.out.println("logout print");
		signOut.click();
	}
	
	
	
}
