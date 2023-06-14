package tw.org.iii.tutor;

public class Brad99 {

	public static void main(String[] args) {
		final int START = 1;
		final int ROWS = 1;
		final int COLS = 9;
		
		for (int k=0; k<ROWS; k++) {
			for (int j=1; j<=9; j++) {
				for (int i=START; i<=(START+COLS-1); i++) {
					int newi = i + k*COLS;
					int r = newi * j;
					System.out.printf("%d x %d = %d\t", newi, j, r);
				}
				System.out.println();
			}
			System.out.println("---");
		}
	}

}
