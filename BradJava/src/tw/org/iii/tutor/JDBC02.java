package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC02 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii","root", "root");
			
			
			Statement stmt = conn.createStatement();
			int n = stmt.executeUpdate("INSERT INTO cust (cname,tel,birthday) VALUES ('tony','321','1999-03-04')");
			System.out.println(n);
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
