package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class InsertDataInJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

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
	
	//@Test
	public void insertData() throws SQLException {
		Connection con=null;
		try {
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stmt = con.createStatement();
			
			String query="insert into project value('Acacia', 'rena', '30/06/2023', 'TYSS', 'completed','6')";
			int result=stmt.executeUpdate(query);
			
			if(result==1) {
				System.out.println("data is inserted");
			}else
				System.out.println("data is not inserted");
		}finally {
			con.close();
		}
	}

}