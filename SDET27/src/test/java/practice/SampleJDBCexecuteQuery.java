package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCexecuteQuery {
public static void main(String[] args) throws SQLException {
	Driver driver = new Driver();
DriverManager.registerDriver(driver);
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
Statement stste = con.createStatement();
 ResultSet result = stste.executeQuery("select * from employeeinfo;");
 while(result.next())
 {
	 System.out.println(result.getString(2));

 }
 con.close();
}
}
