package com.testNG.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class JDBCExample {
	Connection con;
	@Test
	public void TestVerifyDB() throws SQLException {

		
		try {

			// This will connect with Database , getConnection taking three argument
			// first argument is database url,
			// second argument is username and third argument is password

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "bhushan3522","tu3f1011032");

			System.out.println("Connection created");

			// This will create statement
			Statement smt = con.createStatement();

			System.out.println("Statement created");

			// Now execute the query, here Employee is the table which I have created in DB

			ResultSet rs = smt.executeQuery("Select * from Employee");

			System.out.println("Query Executed");

			// Iterate the resultset now

			while (rs.next()) {

				String eid = rs.getString("EId");
				String fname = rs.getString("FName");
				String lname = rs.getString("LName");

				System.out.println("Employee ID is " + eid + " First Name is " + fname + " Last Name is " + lname);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("closing DB Conn");
			con.close();
		}

	}

}