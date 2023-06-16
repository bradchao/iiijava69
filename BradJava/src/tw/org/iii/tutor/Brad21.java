package tw.org.iii.tutor;

import tw.org.iii.classes.Bike;

public class Brad21 {

	public static void main(String[] args) {
		Bike b1 = new Bike("Brad");
		System.out.println(b1.owner);
		System.out.println(b1.getSpeed());
		
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());
		b1.downSpeed();
		System.out.println(b1.getSpeed());
		b1.downSpeed();
		System.out.println(b1.getSpeed());
		
		
		
	}

}
