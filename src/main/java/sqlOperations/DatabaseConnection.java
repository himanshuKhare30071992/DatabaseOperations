package sqlOperations;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author SonyVaio-HK
 *  NOTE: Please change :-  
 *  								"userName", 
 *  								"passWord", 	
 *  								"databaseName" 
 *  according to your SQL Server Database Management System !!!
 *  																			 
 */
public class DatabaseConnection 
{
	static String userName = "sa";
	static String passWord = ".";
	static String databaseName ="hkdb";
	static String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName="+databaseName+";user="+userName+";password="+passWord+";";
	static Connection con;
	static Statement st;
	static ResultSet result;
	
	
	public static void main(String[] args) throws SQLException
	{
			//String url = "SonyVaio-HK-PC\\SQLEXPRESS:localhost:1433";
			try 
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				System.out.println("1#SUCCESS===JDBC Driver Loaded Successfully===");
			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println("1#FAILED===JDBC Driver is Not Loaded===");
				e.printStackTrace();
			}
			
			try 
			{
				//System.out.println(connectionURL);
				con = DriverManager.getConnection(connectionURL);
				System.out.println("2#SUCCESS===Connection Established Successfully===");
			} 
			catch (SQLException e) 
			{
				System.out.println("2#FAILED===Connection is Not Established===");	
				e.printStackTrace();
			}
			
			try 
			{
				st =	con.createStatement();
				System.out.println("3#SUCCESS===Statement Created Successfully===");
			} 
			catch (SQLException e) 
			{
				System.out.println("3#FAILED===Statement is Not Created===");
				e.printStackTrace();
			}
			
			try 
			{
				result =	st.executeQuery("select * from employee");
				System.out.println("4#SUCCESS===SQL Query Executed Successfully===");
			} catch (SQLException e) 
			{
				System.out.println("4#FAILED===SQL Query is Not Executed===");
				e.printStackTrace();
			}
			
			
			while(result.next())
			{
				System.out.println(result.getString(1)+" | "+result.getString(2)+" | "+result.getString(1));
			}
			
			
			
	}

}
