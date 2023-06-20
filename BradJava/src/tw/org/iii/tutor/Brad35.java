package tw.org.iii.tutor;

public class Brad35 {
	public static void main(String[] args) {
		Shape s1 = new RecShap(10, 4);
		Shape s2 = new CircleShae(3);
		System.out.println(s1.calArea());
		System.out.println(s2.calArea());
		sumArea(s1, s2);
	}
	
	static void sumArea(Shape s1, Shape s2) {
		System.out.println(s1.calArea() + s2.calArea());
	}
}
abstract class Shape {
	abstract double calArea();
	abstract double calLength();
}
class RecShap extends Shape{
	double w, h;
	RecShap(double w, double h){this.w=w; this.h=h;}
	double calArea() {
		return w*h;
	}
	double calLength() {
		return (w+h)*2;
	}
}
class CircleShae extends Shape {
	double r;
	CircleShae(double r){this.r = r;}
	double calArea() {
		return Math.PI * r * r;
	}
	double calLength() {
		return 2*r*Math.PI;
	}	
}