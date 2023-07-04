package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;

public class JDBC04 {
	public static void main(String[] args) {
		try {
			String data = getData();
			parseData(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void parseData(String json) {
		JSONArray root = new JSONArray(json);
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
