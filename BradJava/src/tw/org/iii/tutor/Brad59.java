package tw.org.iii.tutor;

import java.util.HashMap;
import java.util.Set;

public class Brad59 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<>();
		person.put("name", "Brad");
		person.put("gender", true);
		person.put("age", 18);
		person.put("weight", 80.123);
		System.out.println(person.get("age"));
		
		Set<String> keys = person.keySet();
		for (String key : keys) {
			System.out.println(key + ":" + person.get(key));
			
		}
		
		
	}

}
