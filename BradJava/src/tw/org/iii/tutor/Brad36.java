package tw.org.iii.tutor;

public class Brad36 {
	public static void main(String[] args) {
		Brad362 obj1 = new Brad362();
		Brad361 obj2 = new Brad362();
		Brad363 obj3 = new Brad362();
		
	}
}
interface Brad361 {
	void m1();
	int m2(String a);
}
class Brad362 implements Brad361, Brad363 {
	public void m1() {}
	public int m2(String a) {return 1;}
	public void m3() {}
	public int m4(String a) {return 1;}
}
interface Brad363 {
	void m3();
	int m4(String a);
}
interface Brad364 extends Brad361, Brad363 {
	void m5();
}

