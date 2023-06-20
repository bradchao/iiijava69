package tw.org.iii.tutor;

public class Brad31 {

	public static void main(String[] args) {
		String s1 = "Brad";
		String s4 = s1;
		System.out.println(s1 == s4);
		String s2 = s1.concat("iii");
		System.out.println(s1);
		System.out.println(s2);
		String s3 = s1.replace('a', 'k');
		System.out.println(s1);
		System.out.println(s3);
		s1 = "KKK";
		System.out.println(s1);
		s1 += "OK";
		System.out.println(s1);
		System.out.println(s1 == s4);
		int[] a = new int[2];
		System.out.println(a[100]);
	}

}
