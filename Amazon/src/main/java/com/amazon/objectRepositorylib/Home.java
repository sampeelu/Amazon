package com.amazon.objectRepositorylib;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.generaiclib.BaseClass;
import com.amazon.generaiclib.WebDriverCommanFun;
/**
 * here define the all the home page element repository
 * @author sambhaw
 *
 */
public class Home{
	WebDriverCommanFun common;
	public Home() {
		common = new WebDriverCommanFun();
		PageFactory.initElements(BaseClass.driver, this);
	}

	@FindBy(xpath="//span[text()='Departments']")
	private WebElement departments;

	@FindBy(xpath=".//*[@id='nav-flyout-shopAll']/div[contains(@class,'nav-template')]/a")
	private List<WebElement> departlist;

	@FindBy(xpath = "//a[text()='Browsing History']")
	private WebElement browseHist;
	
	@FindBy(xpath = "//a[text()='View and Edit']")
	private WebElement viewedt;
	
	@FindBy(xpath = "//span[@class='icp-nav-link-inner']")
	private WebElement language;
	
	@FindBy(xpath="//a[@data-nav-role='signin']")
	private WebElement gologOut;

	//@FindBy(xpath="//span[text() = 'Sign Out']")
	@FindBy(partialLinkText="Sign Out")
	private WebElement signOut;

	public void nevigateToDepart(){
		try {
			System.out.println("...............................");

			//WebElement ele = BaseClass.driver.findElement(By.xpath("//span[text()='Departments']"));
			common.mouseMovementActions(departments);
	
			List<String> lststr = new ArrayList<String>();

			for(WebElement e : departlist) {
				lststr.add(e.getText());
			}
			System.out.println(lststr);	
			for(String str : lststr) {
				common.mouseMovementActions(departments);
				WebElement elem = BaseClass.driver.findElement(By.xpath("//span[text()=\""+str+"\"]"));			
				elem.click();
			}

		}
		catch(Exception e){
			e.printStackTrace();

		}
	}
	
	public void bsHist() {
		common.mouseMovementActions(browseHist);
		viewedt.click();
		
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
