package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad49 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream("dir2/coffee2.jpg");
			FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
			int b;
			while ( (b = fin.read()) != -1) {
				fout.write(b);
			}
			fin.close();
			
			fout.flush();
			fout.close();
			System.out.println("finish:" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
