package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide1 {
	
	@Test(dataProvider = "data")
	public void dataExecute(String src, String dst) {
		System.out.println(src+"  "+dst);
		
	}
	
	@DataProvider
	public Object[][] data(){
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="bglr";
		obj[0][1]="delhi";
		
		obj[1][0]="delhi";
		obj[1][1]="mumbai";
		
		obj[2][0]="bidar";
		obj[2][1]="bglr";
		
		return obj;
	}
}
