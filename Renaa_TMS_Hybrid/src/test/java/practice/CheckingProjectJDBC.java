package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class CheckingProjectJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		String Project_Name="Acacia";
		try{
			//for register/load
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			//connecting with database
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			//asking to create statement
			Statement statement = conn.createStatement();
			
			String query="select * from project";
			//fetching data
			ResultSet result = statement.executeQuery(query);
			
			boolean flag=false;
			while(result.next()) {
				String value=result.getString(2);
				if(value.equalsIgnoreCase(Project_Name))
				{
					System.out.println("Project is created");
					flag=true;
					break;
				}
			}
			if(!flag) {
				System.out.println("Project is not created");
			}
			
		}finally {
			conn.close();
		}
	}

}
