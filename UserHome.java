package database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserHome")
public class UserHome extends HttpServlet {
	 public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	    {
		  HttpSession session=request.getSession(true);
		  String s1=session.getAttribute("Name").toString();
		  String s2=session.getAttribute("Password").toString();
	      response.setContentType("text/html");
	      PrintWriter out=response.getWriter();
	      out.println(s1);
		  RequestDispatcher rd = request.getRequestDispatcher("UserHome");
      	  rd.forward(request, response);
	
	}
}
