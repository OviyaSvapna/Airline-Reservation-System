package database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddUserDet")
public class AddUserDet extends HttpServlet {
	 
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	 {
	 response.setContentType("text/html");
     PrintWriter out=response.getWriter();

     String Name=request.getParameter("fname");
     String Lname=request.getParameter("lname");
     String Email=request.getParameter("email");
     String Mobile=request.getParameter("mobile");
     String Address=request.getParameter("address");
 
     AddUser ob=new AddUser();
   
     String result=ob.InsertValue(Name,Lname,Email,Mobile,Address);
     
     if(result.equals("Inserted Successfully!"))
     {
     out.println("<html><body onload=\"alert('User details added successfully')\"></body></html>");
     response.sendRedirect("http://localhost:8081/airways/UserHome.html");
     }
     else
     {
   	  out.println("<html><body onload=\"alert('Adding user details failed')\"></body></html>");
   	  response.sendRedirect("http://localhost:8081/airways/AddUserDet.html");
     }
   	
     
     out.close();
   }
}
