package tw.org.iii.tutor;

public class PokerV3 {

	public static void main(String[] args) {
		int num = 10;
		int[] poker = new int[num];
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		for (int i= num-1 ; i > 0; i--) {
			int rand = (int)(Math.random()*(i+1));
			// poker[rand] <=> poker[i]
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
		
		for(int v : poker) System.out.println(v);
		
	}

}
