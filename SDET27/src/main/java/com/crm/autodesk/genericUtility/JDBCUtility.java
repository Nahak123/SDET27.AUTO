package com.crm.autodesk.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtility {

	Connection con;
	Statement state;
	//connect to database
	public void connectToDb(String databaseName) throws SQLException
	{
		//load/register the MySql database
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		//get connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName+"", "root", "root");
	}
	//execute sql query
	public ResultSet executeQuery(String query) throws SQLException
	{
		//create statement object or create sql statement
		state = con.createStatement();
		//execute query
		ResultSet result = state.executeQuery(query);
		return result;
	}
	//update database
	public int updateQuery(String query) throws SQLException
	{
		state=con.createStatement();
		int result = state.executeUpdate(query);
		return result;
	}
	//close db connection
	public void closeDb() throws SQLException
	{
		con.close();
	}
}


