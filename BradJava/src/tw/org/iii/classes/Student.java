package tw.org.iii.classes;

import java.io.Serializable;

public class Student implements Serializable {
	private int math, eng, ch;
	private String name;
	private Bike bike;
	
	public Student(int math, int eng, int ch, String name) {
		this.math = math; this.eng = eng; this.ch = ch;
		this.name = name;
		bike = new Bike(name);
	}
	public int sum() {return math+eng+ch;}
	public double avg() {return sum() / 3.0;}
	public String getName() {return name;}
}
