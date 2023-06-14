package tw.org.iii.tutor;

public class Brad13 {

	public static void main(String[] args) {
		int i = 0;
		for (printBrad(); i<10 ;printLine()) {
			System.out.println(i++);
		}
		System.out.println("Over:" + i);
	}

	static void printBrad() {
		System.out.println("BradV3");
	}
	static void printLine() {
		System.out.println("-------");
	}
	
}
