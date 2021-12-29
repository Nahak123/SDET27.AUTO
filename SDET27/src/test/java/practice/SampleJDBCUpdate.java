package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdate {

	public static void main(String[] args) throws Throwable {
		//step1:Register the driver
	Driver driver = new	Driver(); 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
	Statement state = con.createStatement();

	}

}
