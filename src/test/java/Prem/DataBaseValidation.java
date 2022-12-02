package Prem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DataBaseValidation {
	
	@Test
	public void main() throws SQLException
	{
		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
		Statement state = con.createStatement();
//		try {
//		state.executeUpdate("create table employeep(empname varchar(15) unique);");
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
		System.out.println("Enter the name");
		String empname =new Scanner(System.in).next();
		ResultSet value = state.executeQuery("select empname from employeep where empname='"+empname+"';");
	
		
		List<String> arr = new ArrayList<String>();
			while(value.next()) {
			arr.add(value.getString("empname"));
			}
			
		boolean flag=false;
		for(String s:arr)
		{
			if(s.equalsIgnoreCase(empname))
			{
				flag=true;
				break;
			}
		}
		
		if(flag==true)
		{
			System.out.println(empname+" is present in database ");
		}
		
		else
		{
			int update = state.executeUpdate("insert into employeep values('"+empname+"');");
			if(update==1)
			{
			System.out.println(empname+ " is updated");
			}	
		}
		con.close();
	}
		
		@Test
		public void main1() throws SQLException
		{
			DriverManager.registerDriver(new Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
			Statement state = con.createStatement();
//			try {
//			state.executeUpdate("create table employeep(empname varchar(15) unique);");
//			}
//			catch (Exception e) {
//				// TODO: handle exception
//			}
			System.out.println("Enter the name");
			String empname =new Scanner(System.in).next();
			ResultSet value = state.executeQuery("select empname from employeep where empname='"+empname+"';");
	
			boolean flag=false;
				while(value.next()) {
				String val = value.getString("empname");
				if(val.equalsIgnoreCase(empname))
				{
					flag=true;
					break;
				}
				}
			
			if(flag==true)
			{
				System.out.println(empname+" is present in database ");
			}
			
			else
			{
				int update = state.executeUpdate("insert into employeep values('"+empname+"');");
				if(update==1)
				{
				System.out.println(empname+ " is updated");
				}
			}
			con.close();
			
	}

}
