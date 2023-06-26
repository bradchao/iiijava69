package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Brad51 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/file1");
			int c;
			while ( (c = reader.read()) != -1) {
				System.out.print((char)c);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
