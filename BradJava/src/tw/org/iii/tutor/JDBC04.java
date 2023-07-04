package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC04 {
	public static void main(String[] args) {
		try {
			String data = getData();
			parseData(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void parseData(String json) throws Exception {
		// prepare
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);
		
		Statement stmt = conn.createStatement();
		String delSQL = "DELETE FROM foods";
		stmt.executeUpdate(delSQL);
		
		stmt.executeUpdate("ALTER TABLE foods AUTO_INCREMENT = 1");
		
		
		String sql = "INSERT INTO foods (name,addr,tel,city,town,pic,lat,lng) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		JSONArray root = new JSONArray(json);
		for (int i =0 ; i< root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			
			// insert into
			pstmt.setString(1, row.getString("Name"));
			pstmt.setString(2, row.getString("Address"));
			pstmt.setString(3, row.getString("Tel"));
			pstmt.setString(4, row.getString("City"));
			pstmt.setString(5, row.getString("Town"));
			pstmt.setString(6, row.getString("PicURL"));
			try {
				pstmt.setDouble(7, Double.parseDouble(row.getString("Latitude")));
			}catch(Exception e) {
				pstmt.setDouble(7, 0);
			}
			
			try {
				pstmt.setDouble(8, Double.parseDouble(row.getString("Longitude")));
			}catch(Exception e) {
				pstmt.setDouble(8, 0);
			}
			
			
			pstmt.executeUpdate();
		}
		System.out.println("OK");
	}
	
	
	static String getData() throws Exception {
		URL url = new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
		URLConnection conn = url.openConnection();
		
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(conn.getInputStream()));
		
		String line; StringBuffer sb = new StringBuffer();
		while ( (line = reader.readLine()) != null) {
			sb.append(line);
		}
		
		return sb.toString();
	}
	
}
