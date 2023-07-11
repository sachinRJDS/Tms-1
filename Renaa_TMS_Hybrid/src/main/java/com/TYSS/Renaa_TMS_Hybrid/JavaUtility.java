package com.TYSS.Renaa_TMS_Hybrid;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;



public class JavaUtility {
	Date date= new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");

	public String currectDate() {
		
		String currentDate = sim.format(date);
		return currentDate;
		
		
	}
	public String toDate(int reqDate) {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, reqDate);
		Date date1=cal.getTime();
		String reqDate1 = sim.format(date1);
		return reqDate1;
		
	}
	/**
	 * generate random number with in the limit of 40000 for very invocation
	 * 
	 * @return
	 */
	public String getRandomNumber() {
		Random random=new Random();
		int ranInt = random.nextInt(500);
		return ("$"+ranInt);
	}
	

}
