package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad46 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/file1");

			int c;
			while ( (c = fin.read()) != -1 ) {
				System.out.print((char)c);
			}
			
			
			fin.close();
			//System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
