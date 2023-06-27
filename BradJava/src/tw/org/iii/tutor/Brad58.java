package tw.org.iii.tutor;

import java.util.LinkedList;

public class Brad58 {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.add(0,"Brad");
		names.add(0,"Eric");
		names.add(0,"Peter");
		names.add(0,"Amy");
		names.add(0,"Brad");
		System.out.println(names.size());
		for (String name : names) {
			System.out.println(name);
		}
	}

}
