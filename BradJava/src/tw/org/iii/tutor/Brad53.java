package tw.org.iii.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.org.iii.classes.Student;

public class Brad53 {

	public static void main(String[] args) {
		Student s1 = new Student(45, 32, 56, "Brad");
		System.out.println(s1.getName());
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		
		try (FileOutputStream fout = new FileOutputStream("dir1/student.s1");
				ObjectOutputStream oout = new ObjectOutputStream(fout);) {
			oout.writeObject(s1);
			oout.flush();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
