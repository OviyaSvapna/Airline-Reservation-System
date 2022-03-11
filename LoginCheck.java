package database;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet
{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
     
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String user=request.getParameter("username");//key from html
      String pass=request.getParameter("password");
      LoginChk ob=new LoginChk();
      String result=ob.CheckValue(user,pass);
    
      
      if(result.equals("Login Succesfully"))
      {
    	  out.println("<html><body onload=\"alert('Login Successfully')\"></body></html>");
    	  if(user.equals("Oviya_Svapna")&&pass.equals("Kitty*"))
          {
              response.sendRedirect("http://localhost:8081/airways/AdminHome.html");
             
          }
          else
          {
        	   AddCurrentUser ob1=new AddCurrentUser();
               String r=ob1.InsertValue(user);
              response.sendRedirect("http://localhost:8081/airways/UserHome.html");
              
          }
    	

      
      }
      else
          out.println("<html><body onclick=\"alert('Invalid Username or Password')\"></body></html>");
    	  

      out.close();
    }
}