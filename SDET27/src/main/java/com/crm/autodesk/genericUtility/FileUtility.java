package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Pradeep
 *
 */
public class FileUtility {
	/**
	 * its used to read the data from commonData.properties file based on key which you pass as an argument
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}
	
	
	

}
