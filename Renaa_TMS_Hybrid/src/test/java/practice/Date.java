package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.annotations.Test;

public class Date {
	@Test
	public  void fromDate() {
		// TODO Auto-generated method stub
		java.util.Date d=new java.util.Date();
		System.out.println(d);
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sim.format(d);
		System.out.println(startDate);
		
	}
	@Test
	public void toDate() {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		java.util.Date d2=cal.getTime();
		SimpleDateFormat sim2=new SimpleDateFormat("yyyy-MM-dd");
		String lastDate=sim2.format(d2);
		System.out.println(lastDate);
	}

}
