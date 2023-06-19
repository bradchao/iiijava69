package tw.org.iii.tutor;

import tw.org.iii.classes.Scooter;

public class Brad27 {

	public static void main(String[] args) {
		Object obj = new Object();
		String s1 = new String("Brad");
		String s2 = new String("Brad");
		System.out.println(obj);
		System.out.println(s1);
		
		Scooter s3 = new Scooter();
		System.out.println(s3);
		System.out.println("----");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		
	}

}
