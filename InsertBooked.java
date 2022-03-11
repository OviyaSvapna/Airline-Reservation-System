package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class InsertBooked {
	
		public String InsertValue(String name,String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9) 
		{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airways", "oviyasvapna","skcet");
		    String query="insert into BookedDetails values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
	
				pstmt.setString(1,name); 
				pstmt.setString(2,s1);
		        pstmt.setString(3,s2);
		        pstmt.setString(4,s3);
		        pstmt.setString(5,s4);
		        pstmt.setString(6,s5);
		        pstmt.setString(7,s6);
		        pstmt.setString(8,s7);
		        pstmt.setString(9,s8);
		        pstmt.setString(10,s9);
		        
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
