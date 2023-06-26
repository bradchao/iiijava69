package tw.org.iii.tutor;

import java.io.File;

public class Brad43 {

	public static void main(String[] args) {
		File dir1 = new File("d:/brad/dir");
		if (dir1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		File dir2 = new File("d:/brad/test");
		if (dir2.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
		
	}

}
