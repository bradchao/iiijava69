package tw.org.iii.tutor;

public class Brad12 {

	public static void main(String[] args) {
		int month = (int)(Math.random()*12) + 1; 
		int days;
		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12:
				days = 31;
				break;
			case 4: case 6: case 9: case 11:
				days = 30;
				break;
			case 2:
				days = 28;
				break;
			default:
				days = 0;
		}
		System.out.printf("%d月有%d天", month, days);
	}

}
