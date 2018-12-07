package com.amazon.generaiclib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * fetch the data from property file for launching and login
 * @author sambhaw
 *
 */
public class Filelib {

	public String getPropertyobj(String property) throws IOException {
		System.out.println("Reading property.........");
		FileInputStream fobj = new FileInputStream("./TestData/commanData.properties"); 
		Properties pobj = new Properties();
		pobj.load(fobj);

		String strproperty = pobj.getProperty(property);


		return strproperty;
	}


}
