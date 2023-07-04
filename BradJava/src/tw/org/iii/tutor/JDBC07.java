package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.org.iii.classes.BCrypt;

public class JDBC07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account = ");
		String account = scanner.next();
		System.out.print("Password = ");
		String passwd = scanner.next();
		System.out.print("Name = ");
		String name = scanner.next();
		
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
			
			String sqlDup = "SELECT * FROM member WHERE account = ?";
			PreparedStatement pstmtDup = conn.prepareStatement(sqlDup);
			pstmtDup.setString(1, account);
			ResultSet rs = pstmtDup.executeQuery();
			if (!rs.next()) {
				String sql = "INSERT INTO member (account,passwd,cname) VALUES (?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, account);
				pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
				pstmt.setString(3, name);
				
				int n = pstmt.executeUpdate();
				if (n == 0) {
					System.out.println("ERR");
				}else {
					System.out.println("OK");
				}
			}else {
				System.out.println("Duplicate");
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
