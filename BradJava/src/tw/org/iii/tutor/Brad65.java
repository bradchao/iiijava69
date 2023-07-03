package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad65 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("10.0.101.187"), 9999);
			
			File source = new File("dir1/coffee.jpg");
			FileInputStream fin = new FileInputStream(source);
			byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			fin.close();
			
			OutputStream out =  socket.getOutputStream();
			out.write(buf);
			out.flush();
			out.close();
			
			socket.close();
			System.out.println("Client OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
