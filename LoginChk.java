package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginChk {
	public String CheckValue(String username, String password) {
		int val = 0;
		if (!username.equals("")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/airways", "oviyasvapna","skcet");
				String query = "select username,newpassword from LoginDetails where username like ? and newpassword like ?";
				PreparedStatement st = co.prepareStatement(query);
				st.setString(1, username);
				st.setString(2, password);
				ResultSet rs = st.executeQuery();
		
				if (rs.next()) {
					val=1;
				} else {
					val=0;
				}
			} catch (Exception ex) {
				return "Exception------------------------>  " + ex;
			}
		}
		if (val==1) {
			return "Login Succesfully";
		} else {
			return "Invalid Username or Password";
		}
	}
}
