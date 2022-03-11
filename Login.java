package database;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Login")
public class Login extends HttpServlet
{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

      String user=request.getParameter("username");
      String email=request.getParameter("email-id");
      String npass=request.getParameter("newpassword");
      String cpass=request.getParameter("cpassword");

      LoginDet ob=new LoginDet();
      if(npass.equals(cpass))
      {
      String result=ob.InsertValue(user,email,npass,cpass);
      out.println("<html><body onload=\"alert('Registered Successfully')\"></body></html>");
      }
      else
      {
    	  out.println("<html><body onclick=\"alert('Password is invalid')\"></body></html>");
    	  out.println("location='Login.html';");
    	  //out.println("<a href='LG.html'>Back</a>");
      }

      //out.println("<h1>"+result+"Login Successfully"+"</h1>");
      //out.println("<a href='LG.html'>Back</a>");
     

      out.close();
    }
}