package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddFlgt 
{
	 public String InsertValue(String Flightno,String Flightname,String fcity,String tcity,String date,String time,String dur,String airname,String price){

	        try{

		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airways","oviyasvapna","skcet");
		            
	                String query="insert into FlightDetails values(?,?,?,?,?,?,?,?,?)";
	                PreparedStatement pstmt=con.prepareStatement(query);
	                
	                pstmt.setString(1, Flightno);
	                pstmt.setString(2,Flightname);
	                pstmt.setString(3,fcity);
	                pstmt.setString(4,tcity);
	                pstmt.setString(5,date);
	                pstmt.setString(6,time);
	                pstmt.setString(7,dur);
	                pstmt.setString(8,airname);
	                pstmt.setString(9,price);

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
