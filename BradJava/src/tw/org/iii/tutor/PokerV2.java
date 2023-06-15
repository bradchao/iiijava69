package tw.org.iii.tutor;

public class PokerV2 {
	public static void main(String[] args) {
		//long start = System.currentTimeMillis();
		//System.out.println(start);
		// 1. 洗牌
		int[] poker = new int[52];
		boolean isRepeat;
		int temp;
		for (int i=0; i<poker.length; i++) {
			do {
				temp = (int)(Math.random()*52);
				
				// 檢查機制
				isRepeat = false;
				for (int j=0; j<i; j++) {
					if (poker[j] == temp) {
						// 重複了
						isRepeat = true;
						break;
					}
				}
			}while(isRepeat);
			
			poker[i] = temp;
			System.out.println(temp);
		}
		//long end = System.currentTimeMillis();
		//System.out.println(end);
		
		// 2. 發牌
		
		// 3. 攤牌 + 里牌
	}
}
