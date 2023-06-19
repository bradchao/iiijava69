package tw.org.iii.tutor;

import tw.org.iii.classes.Bike;

public class Brad26 {

	public static void main(String[] args) {
		Bike b1 = new Bike("Brad");
		Bike b2 = new Bike("Brad");
		Bike b3 = b1;
		int[] a1 = new int[3];
		double[] a2 = new double[3];
		
		b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(b1 == b2);
		
		
	}

}
