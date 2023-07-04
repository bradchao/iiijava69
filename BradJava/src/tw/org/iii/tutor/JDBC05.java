package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC05 {

	public static void main(String[] args) {
		String key = "中山路";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);
			String sql = "SELECT * FROM foods WHERE name LIKE ? OR addr LIKE ? OR tel LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + key + "%");
			pstmt.setString(2, "%" + key + "%");
			pstmt.setString(3, "%" + key + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				System.out.println(String.format("%s:%s:%s:%s", id, name, addr, tel));
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
