package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoginDet {
	 public String InsertValue(String username,String email,String newpassword,String cpassword){

	        try{

		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airways","oviyasvapna","skcet");
		            
	                String query="insert into LoginDetails values(?,?,?,?)";
	                PreparedStatement pstmt=con.prepareStatement(query);

	                pstmt.setString(1,username);
	                pstmt.setString(2,email);
	                pstmt.setString(3,newpassword);
	                pstmt.setString(4,cpassword);

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