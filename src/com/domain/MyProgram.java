package com.domain;

import java.sql.*;

public class MyProgram 
{

	public static void main(String[] args)
	{
		//For selecting table data in jdbc
		try 
		{
			// Step 1: Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2: Establish connectin to database 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","sadhu");
			
			// Step 3: Prepare SQL statement
			Statement s = con.createStatement();
			
			// Step 4: Execute the Query
			ResultSet rs = s.executeQuery("select*from employee");
			
			//Step 5: Read/Process the data coming from Resultset
			while(rs.next()== true) 
			{
				System.out.println("Eid: "+ rs.getInt("eid"));
				System.out.println("Ename:" + rs.getString("ename"));
				System.out.println("Ecity:" + rs.getString("ecity"));
			}
			
			// Step 6: Close connection and statement
			s.close();
			con.close();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}

}
