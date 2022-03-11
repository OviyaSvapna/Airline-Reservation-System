package database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet
{
	
	 public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	    {
	      response.setContentType("text/html");
	      PrintWriter out=response.getWriter();

	      String Flightno=request.getParameter("Flightno");
	      String Flightname=request.getParameter("Flightname");
	      String fcity=request.getParameter("fcity");
	      String tcity=request.getParameter("tcity");
	      String date=request.getParameter("fdate");
	      String time=request.getParameter("ftime");
	      String dur=request.getParameter("dur");
	      String airname=request.getParameter("airname");
	      String price=request.getParameter("price");
	  
	      AddFlgt ob=new AddFlgt();
	    
	      String result=ob.InsertValue(Flightno,Flightname,fcity,tcity,date,time,dur,airname,price);
	      
	      if(result.equals("Inserted Successfully!"))
	      {
	      out.println("<html><body onload=\"alert('Flight details added successfully')\"></body></html>");
          response.sendRedirect("http://localhost:8081/airways/AdminHome.html");
	      }
	      else
	      {
	    	  out.println("<html><body onload=\"alert('Adding flight details failed')\"></body></html>");
	      }
	    	
	      
	      out.close();
	    }
	}
