package practice;

import java.sql.ResultSet;
import com.crm.autodesk.genericUtility.JDBCUtility;
import com.crm.autodesk.genericUtility.JavaUtility;

public class ReadDataJDBC {

	public static void main(String[] args) throws Throwable {

		JDBCUtility db= new JDBCUtility();
		JavaUtility jLib= new JavaUtility();
		int num = jLib.getRandomNumber();
		db.connectToDb("employeedb");
		int result1 = db.updateQuery("insert into student(Id , name )values("+num+",'Rahul');");
		if(result1==1)
		{
			System.out.println("Data added successfully");
		}
		ResultSet result2 = db.executeQuery("select* from student;");
		while(result2.next())
		{
			System.out.println(result2.getString(1)+"==>"+result2.getString(2));
		}
		db.closeDb();

	}
}
