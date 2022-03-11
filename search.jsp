<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<a href=UserHome.html><button type=button class=btn>Home</button></a> 
<a href="UserHome.html"><button type=button class=btn>Flight</button></a> 
<a href="AddUserDet.html"><button type=button class=btn>Add Detail</button></a>
<a href="Home.html"><button type=button class=btn>Logout</button></a>
	<center>
		<table width=70% height=10% border=1>
			<tr>
				<th>Flight no</th>
				<th>Flight name</th>
				<th>From city</th>
				<th>To city</th>
				<th>Date</th>
				<th>Time</th>
				<th>Duration</th>
				<th>Airway name</th>
				<th>price</th>
				<th>Book</th>
			</tr>

			<% 
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airways", "oviyasvapna","skcet");
			Statement st=con.createStatement();
			String f=request.getParameter("f");
			String t=request.getParameter("t");
			String query = "select * from FlightDetails where fcity='"+f+"' and tcity='"+t+"'";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
			%>
			<center><h1>Flight Details</h1></center>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
				<td><%=rs.getString(6)%></td>
				<td><%=rs.getString(7)%></td>
				<td><%=rs.getString(8)%></td>
				<td><%=rs.getString(9)%></td>
				<td><a href=book.html><button type=button class=btn>Book</button></a>
			</tr>
			<% 
			  }
			}
			  catch(Exception e)
			  {
				  System.out.print(e.getMessage());
			  }
			 %>

		</table>
	</center>

</body>
</html>