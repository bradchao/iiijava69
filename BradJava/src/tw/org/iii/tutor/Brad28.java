package tw.org.iii.tutor;

import tw.org.iii.classes.TWId;

public class Brad28 {

	public static void main(String[] args) {
		System.out.println(Math.random());
		System.out.println(TWId.isRightId("abc"));
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(letters.indexOf('7'));
		
		String id = "A123456789";
		if (id.matches("[A-Z][12][0-9]{8}")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		

	}

}
