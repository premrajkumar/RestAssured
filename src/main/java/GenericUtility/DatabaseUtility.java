package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility
{
	private Driver dbdriver;
	private Connection connection;
	private Connection con;
	private Driver driverref;
	/**
	 * this method is used to get connection to the database 
	 * @param url
	 * @param Db_un
	 * @param Db_pwd
	 * @return
	 */
	public void getConnection1()
	{
		
		try {
			dbdriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//step2--> register the driver instance to the jdbc
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//step3--> get/establish the database connection
		try {
		connection = DriverManager.getConnection(Iconstants.DBURL, Iconstants.DBUsername, Iconstants.DBpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to get data from database
	 * @param query
	 * @param colname
	 * @return
	 */
	public List<String> getDataFromDb(String query, String colname)
	{
		Statement statement=null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//step5--> execute the query 
		ResultSet result=null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> arr = new ArrayList<String>();
	    //step6-->verify or iterate or fetch the data
		try {
			while(result.next()) {
			arr.add(result.getString(colname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	/**
	 * this method is used to close the connection of database
	 */
	public void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to validate the database data with expected value
	 * @param query1
	 * @param colname1
	 * @param expectedvalue
	 * @return
	 */
	public boolean verifyDataInsideDatabase(String query1, String colname1, String expectedvalue)
	{
		List<String> arr = getDataFromDb(query1, colname1);
		boolean flag=false;
		for(String s:arr)
		{
			if(s.equalsIgnoreCase(expectedvalue))
			{
				flag=true;
				break;
			}
		}
		return flag;
		
	}
	
	public void setDataToDataBase(String query1)
	{
		Statement statement=null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		int result=0;
		try {
			result = statement.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result==1) {
			System.out.println(result+"dataupdated succesfully");
		}
	}
	
	public String readDatafromDBAndValidate(String query2, int columnIndex,String expectedData) throws SQLException
	{
		boolean flag=false;
		Statement statement=null;
		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//step5--> execute the query 
		ResultSet result=null;
		try {
			result = statement.executeQuery(query2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while(result.next())
		{
			if(result.getString(columnIndex).equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("verified");
			return expectedData;
		}
		else
		{
			System.out.println("data not verified");
			return " ";
		}
			
	}
	
	public void getConnection() throws SQLException
	{
		driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(Iconstants.DBURL,Iconstants.DBUsername,Iconstants.DBpassword);
	}
}
