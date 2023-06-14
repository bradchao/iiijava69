package tw.org.iii.tutor;

public class Brad09 {

	public static void main(String[] args) {
		int year = 2023;
		
		if (year % 4 == 0 ) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// 366
				}else {
					// 365
				}
			}else {
				// 365
			}
		}else {
			// 365
		}
		
		//-------------------
		
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			// 366
		}else {
			// 365
		}
		
		
		
		
	}

}
