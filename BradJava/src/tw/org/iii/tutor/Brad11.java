package tw.org.iii.tutor;

public class Brad11 {

	public static void main(String[] args) {
		int a = 100, c = 10;
		final int b = 10;
		switch (a) {
			case 1:
				System.out.println("A");
				break;
			case b:
				System.out.println("B");
			default:
				System.out.println("X");
				break;
			case 100:
				System.out.println("C");
				break;
		}
		System.out.println("Game OVER");
	}

}
