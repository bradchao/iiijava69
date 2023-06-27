package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad55 {
	public static void main(String[] args) {
		Brad553 obj = new Brad553();
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/test"));
			oout.writeObject(obj);
			oout.flush(); oout.close();
			System.out.println("------");
			
			ObjectInputStream ooin = new ObjectInputStream(new FileInputStream("dir1/test"));
			Object obj1 = ooin.readObject();
			ooin.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
class Brad551 {
	Brad551(){System.out.println("Brad551()");}
}
class Brad552 extends Brad551 implements Serializable {
	Brad552(){System.out.println("Brad552()");}
}
class Brad553 extends Brad552{
	Brad553(){System.out.println("Brad553()");}
}

