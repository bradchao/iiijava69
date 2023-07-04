package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Page = ");
		int page = scanner.nextInt();
		int rpp = 7;	// row per page
		int start = (page - 1) * rpp;
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);
			Statement stmt = conn.createStatement();
			ResultSet rsTotal = stmt.executeQuery("SELECT count(*) total FROM foods");
			rsTotal.next();
			int total = rsTotal.getInt("total");
			int pages = (int)Math.ceil(total * 1.0 / rpp);
			
			if (page <= 0 || page > pages)
				throw new Exception("Page XXXXX");
			
			String sql = "SELECT * FROM foods LIMIT ?, ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println(String.format("%s:%s", id, name));
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
