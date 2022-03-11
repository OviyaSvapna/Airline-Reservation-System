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

@WebServlet("/ViewFlight")
public class ViewFlight extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airways", "oviyasvapna", "skcet");

			String query = "select* from FlightDetails";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			out.println("<a href=AdminHome.html><button type=button class=btn float=right>Home</button></a>"); 
			out.println("<a href=AdminHome.html><button type=button class=btn float=right>Flight</button></a>"); 
			//out.println("<a href=AddUserDet.html><button type=button class=btn float=right>Add Detail</button></a>");
			out.println("<a href=Home.html><button type=button class=btn float=right>Logout</button></a>");
			out.println("<html><body><center><h1>Flight Details</h1>");
			out.println("<form action=ViewSearch.jsp method=post><label>From City </label><input type=text name=f>");
			out.println("<label>To City </label><input type=text name=t>");
			out.println("<input type=submit value=search></form>");
			out.println("<br/><br/</center><center><table width=70% height=10% border=1><tr><th>Flight no</th><th>Flight name</th><th>From city</th><th>To city</th><th>Date</th><th>Time</th><th>Duration</th><th>Airway name</th><th>price</th></tr>");

			while (rs.next()) {
				out.println("<tr><td>" + rs.getString(1)+  "</td><td>" + rs.getString(2)+
						 "</td><td>" + rs.getString(3) +"</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5)+
						 "</td><td>"  +rs.getString(6) + "</td><td>" + rs.getString(7) + "</td><td>"+ rs.getString(8)+ "</td><td>"+ rs.getString(9)+ "</td></tr>");
			}
			out.println("</table></center>");
			out.println("</body></html>");
		} catch (Exception e) {

		}

	}
}
