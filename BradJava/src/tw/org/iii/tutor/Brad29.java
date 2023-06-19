package tw.org.iii.tutor;

public class Brad29 {
	public static void main(String[] args) {
		Brad291 obj = new Brad291();
	}
}
class Brad291 {
	Brad291(){
		this(2);
		System.out.println("Brad291()");
	}
	Brad291(int a){
		this(false);
		System.out.println("Brad291(int)");
	}
	Brad291(boolean b){
		System.out.println("Brad291(boolean)");
	}
}
