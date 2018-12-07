package com.amazonTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.amazon.generaiclib.BaseClass;
import com.amazon.objectRepositorylib.Home;

/**
 * here execute 
 * to all the department list  
 * @author sambhaw
 *
 */
public class DepartmentsTest extends BaseClass{
	/*	Home hp;
	DepartmentsTest(){
	//	hp = new Home();
	hp = PageFactory.initElements(driver, Home.class);
	}
	 */


	/*@DataProvider
	public Object[][] getLoginData(){
		return new Object[][] {
			{"9620350904","gudieam123"},
			{"65766767879","itftcgh"}
		};
	}

	 */

	@Test()
	public void depart_lst() throws InterruptedException{
		Home hp = PageFactory.initElements(driver, Home.class);
		System.out.println("Test starting...........");
		//Thread.sleep(5000);
		hp.nevigateToDepart();
	}
}