package tw.org.iii.tutor;

public class Brad34 {
	public static void main(String[] args) {
		Brad341 obj1; // = new Brad341();
		obj1 = new Brad342();
		Brad341 obj2 = new Brad341() {
			void m3() {System.out.println("Brad341:m3()");}
		};
		obj2.m3();
		
	}
}
abstract class Brad341 {
	void m1() {System.out.println("Brad341:m1()");}
	void m2() {System.out.println("Brad341:m2()");}
	abstract void m3();
}
class Brad342 extends Brad341 {
	void m3() {System.out.println("Brad342:m3()");}
}
class Brad343 extends Brad341 {
	void m3() {System.out.println("Brad343:m3()");}
}