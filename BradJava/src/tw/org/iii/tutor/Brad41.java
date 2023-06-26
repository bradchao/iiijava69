package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad41 {
	public static void main(String[] args) {
		Brad411 obj = new Brad411();
		try {
			obj.m1();
		}catch(Exception e) {}
	}
}
class Brad411 {
	void m1() throws Exception {
		m2();
	}
	void m2() throws InterruptedException {
		try {
			m3(1);
		}catch(IOException e) {
			
		}
	}
	void m3(int a) throws IOException, InterruptedException {
		if (a == 1) {
			throw new IOException();
		}else if (a == 2) {
			throw new InterruptedException();
		}else if (a == 3) {
			throw new FileNotFoundException();
		}
	}
			
	
}

