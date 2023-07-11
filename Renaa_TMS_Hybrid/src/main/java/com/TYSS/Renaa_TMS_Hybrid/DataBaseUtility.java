/**
 * 
 */
package com.TYSS.Renaa_TMS_Hybrid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * @author MIRZA KASHIF BAIG
 *
 */
public class DataBaseUtility {

	public void fecthDataJDBC() throws SQLException {
	Connection conn=null;
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement = conn.createStatement();
		String query="select * from project";
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			String value=result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6);
			System.out.println(value);
		}		

	}finally {
		conn.close();
	}
}
	public void insertInJdbc() throws SQLException {
	Connection conn=null;
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement = conn.createStatement();
		String query="insert into project value('TY_PROJ_115','Acacia','29/06/2023','Tyss','Completed','5')";
		int result = statement.executeUpdate(query);
		if(result==1) {
			System.out.println("data is created");
		}else
			System.out.println("data  is not created");

	

	}finally {
		conn.close();
	}
}
}
