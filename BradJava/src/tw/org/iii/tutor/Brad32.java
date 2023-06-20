package tw.org.iii.tutor;

import tw.org.iii.classes.TWId;

public class Brad32 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("abcdefg")
			.append("OK")
			.append("XX");
		System.out.println(sb);
		System.out.println("----");
		TWId id = TWId.newTWId("A123456784");
		if (id == null) {
			System.out.println("XX");
		}else {
			System.out.println("OK");
		}
	}

}
