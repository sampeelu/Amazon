package com.amazonTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazon.generaiclib.BaseClass;
import com.amazon.objectRepositorylib.Home;

/**
 * HEre brBrowsingHistoryTestpage element
 * 
 * @author sambhaw
 */
public class BrowsingHistoryTest extends BaseClass {
	
	@Test
	public void browsehistory() {
		Home hp = PageFactory.initElements(driver, Home.class);
		hp.bsHist();
			
	}
	
}
