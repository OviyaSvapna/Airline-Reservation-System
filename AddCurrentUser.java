package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddCurrentUser 
{
	public String InsertValue(String username) 
	{
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airways", "oviyasvapna","skcet");
	    String query="insert into CurrentUser values(?)";
	
        PreparedStatement pstmt=con.prepareStatement(query);
        
        pstmt.setString(1,username);
   
        pstmt.executeUpdate();
        con.setAutoCommit(true);
        con.close();
        return "Inserted Successfully!";
	}
	catch (Exception ex) 
	{
		return "Exception------------------------>  " + ex;
	}
}

}
