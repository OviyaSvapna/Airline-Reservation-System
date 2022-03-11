package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Flight")
public class Flight extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airways", "oviyasvapna", "skcet");

			String query = "select * from FlightDetails";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			out.println("<a href=UserHome.html><button type=button class=btn float=right>Home</button></a>"); 
			out.println("<a href=UserHome.html><button type=button class=btn float=right>Flight</button></a>"); 
			out.println("<a href=Home.html><button type=button class=btn float=right>Logout</button></a>");
			out.println("<html><body><center><h1>Flight Details</h1>");
			out.println("<form action=search.jsp method=post><label>From City </label><input type=text name=f>");
			out.println("<label>To City </label><input type=text name=t>");
			out.println("<input type=submit value=search></form>");
			out.println("<br/><br/</center><center><table width=70% height=10% border=1><tr><th>Flight no</th><th>Flight name</th><th>From city</th><th>To city</th><th>Date</th><th>Time</th><th>Duration</th><th>Airway name</th><th>price</th><th>Book</th></tr>");

			while (rs.next()) {
				out.println("<tr><td>" + rs.getString(1)+  "</td><td>" + rs.getString(2)+
						 "</td><td>" + rs.getString(3) +"</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5)+
						 "</td><td>"  +rs.getString(6) + "</td><td>" + rs.getString(7) + "</td><td>"+ rs.getString(8)+ "</td><td>"+ rs.getString(9)+ "</td><td><a href=Payment.html><button type=button class=btn>Book</button></a></td></tr>");
			}
			out.println("</table></center>");
			out.println("</body></html>");
		} catch (Exception e) {

		}

	}

	/*public void Valuename(String username) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airways", "oviyasvapna", "skcet");

			String query = "select* from FlightDetails";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			String s1=rs.getString(1);
			String s2=rs.getString(2);
			String s3=rs.getString(3);
			String s4=rs.getString(4);
			String s5=rs.getString(5);
			String s6=rs.getString(6);
			String s7=rs.getString(7);
			String s8=rs.getString(8);
			String s9=rs.getString(9);	
			//Booked b=new Booked(username);
			//b.Value1(username);
			//b.Value2(s1,s2,s3,s4,s5,s6,s7,s8,s9);
		} 
		catch (Exception e) {}

	}*/
}
