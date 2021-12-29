package com.crm.autodesk.genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * its used to generate random number
	 * @return int data
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(1000);
		return intRandom;
	}
	/**
	 * used to get system date & time in IST formate
	 * @return 
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		String systemDate = date.toString();
		return systemDate;
	}
	/**
	 * used to get yyyy-mm-dd formate
	 */
	 
	 
	public String getSytemDateWithFormate() {
		Date date = new Date();
		String dateAndTime = date.toString();
		String yyyy = dateAndTime.split("")[5];
		String dd = dateAndTime.split("")[2];
		int mm = date.getMonth()+1;
		String finaldate = yyyy+"-"+mm+"-"+dd;
		return finaldate;
		
		
		
	}

}

