package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Brad67 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.iii.org.tw/default.aspx");
			URLConnection conn = url.openConnection();
			
			InputStreamReader ir = new InputStreamReader(conn.getInputStream()) ;
			BufferedReader breader = new BufferedReader(ir);
			
			String line;
			while ((line = breader.readLine()) != null) {
				System.out.println(line);
			}
			
			ir.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
