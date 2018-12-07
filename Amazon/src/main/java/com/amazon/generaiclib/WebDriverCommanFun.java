package com.amazon.generaiclib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.amazon.objectRepositorylib.Home;

/**
 * here define comman action or method or function
 * @author sambhaw
 *
 */
public class WebDriverCommanFun {

	public void mouseMovementActions(WebElement element){
		try {
			Object obj = PageFactory.initElements(BaseClass.driver, element.getClass());
			Actions act = new Actions(BaseClass.driver);
			act.moveToElement(element).build().perform();
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();

		}
	}
}