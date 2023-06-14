package tw.org.iii.tutor;

public class PokerV1 {
	public static void main(String[] args) {
		// 1. 洗牌
		int[] poker = new int[52];
		for (int i=0; i<poker.length; i++) {
			int temp = (int)(Math.random()*52);
			
			// 檢查機制
			boolean isRepeat = false;
			for (int j=0; j<i; j++) {
				if (poker[j] == temp) {
					// 重複了
					isRepeat = true;
					break;
				}
			}
			
			if (!isRepeat) {
				poker[i] = temp;
				System.out.println(poker[i]);
			}else {
				i--;
			}
		}
		
		// 2. 發牌
		
		// 3. 攤牌 + 里牌
	}
}
