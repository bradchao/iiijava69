package tw.org.iii.tutor;

public class Brad17 {

	public static void main(String[] args) {
		int[][] a = new int[3][];
		a[0] = new int[4];
		a[1] = new int[2];
		a[2] = new int[3];
		a[0][0] = 123;
		a[0][1] = 45;
		a[0][2] = 76;
		a[0][3] = 53;
		
		a[1][0] = 21;
		a[1][1] = 112;
		
		a[2][0] = 75;
		a[2][1] = 87;
		a[2][2] = 64;
		
		for (int[] b : a) {
			for (int c : b) {
				System.out.print(c + "  ");
			}
			System.out.println();
		}
		System.out.println("-----");
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
		
		
	}

}
