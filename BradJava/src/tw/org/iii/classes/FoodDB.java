package tw.org.iii.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FoodDB {
	private Connection conn;
	private String[] fieldNames;
	private ResultSet rs;
	
	public FoodDB() throws SQLException {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii",prop);
	}
	
	public void queryData() throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery("SELECT * FROM foods");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnName(i+1);
		}
		
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {return 0;}
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	
	public String getData(int row, int col) {
		try {
			rs.absolute(row);
			return rs.getString(fieldNames[col-1]);
		}catch(Exception e) {
			return "XXX";
		}
	}
	
}
