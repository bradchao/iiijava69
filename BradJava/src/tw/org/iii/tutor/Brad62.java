package tw.org.iii.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Brad62 {

	public static void main(String[] args) {
		
		try {
			InetAddress ip = InetAddress.getByName("192.168.3.444");
			System.out.println(ip.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		
	}

}
