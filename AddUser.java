package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddUser {
	 public String InsertValue(String Name,String Lname,String Email,String Mobile,String Address){

	        try{

		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airways","oviyasvapna","skcet");
		            
	                String query="insert into UserDetails values(?,?,?,?,?)";
	                PreparedStatement pstmt=con.prepareStatement(query);
	                
	                pstmt.setString(1,Name);
	                pstmt.setString(2,Lname);
	                pstmt.setString(3,Email);
	                pstmt.setString(4,Mobile);
	                pstmt.setString(5,Address);
	   
	                pstmt.executeUpdate();
	                con.setAutoCommit(true);
	                con.close();
	                return "Inserted Successfully!";
	        }
	        catch(Exception ex){
	             return  "Exception------------------------>  "+ex;
	        }

}
}
