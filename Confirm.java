package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Confirm")
public class Confirm extends HttpServlet 
{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airways", "oviyasvapna", "skcet");

			String query = "select * from FlightDetails";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			String query2 = "select * from CurrentUser";
			PreparedStatement pstmt2 = con.prepareStatement(query2);
			ResultSet rs2 = pstmt2.executeQuery();
		
			InsertBooked ob=new InsertBooked();
			//ob.InsertValue(rs2.getString(1),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9));

			out.println("<a href=UserHome.html><button type=button class=btn float=right>Home</button></a>"); 
			out.println("<a href=UserHome.html><button type=button class=btn float=right>Flight</button></a>"); 
			out.println("<a href=Home.html><button type=button class=btn float=right>Logout</button></a>");
			out.println("<html><body><center><h1>Payment Details</h1>");
			while (rs.next()&&rs2.next()) {
				out.println("<center><table width=30% height=10% border=1><tr><td> Username:" +rs2.getString(1)+"</td></tr><tr><td> Flight no: " + rs.getString(1)+  "</td></tr><tr><td> Flight name: " + rs.getString(2)+
						 "</td></tr><tr><td> From City: " + rs.getString(3) +"</td></tr><tr><td> To City: " + rs.getString(4) + "</td></tr><tr><td> Flight Date: " + rs.getString(5)+
						 "</td></tr><tr><td> Flight Time: "  +rs.getString(6) + "</td></tr><tr><td> Travel Duration: " + rs.getString(7) + "</td></tr><tr><td> Airport Name: "+ rs.getString(8)+ "</td></tr><tr><td> Price: "+ rs.getString(9)+ "</td></tr><tr><td> Payment Status: Payment Successfull</td></tr>");
				ob.InsertValue(rs2.getString(1),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9));

			}
			out.println("</table></center>");
			out.println("</body></html>");
	

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
