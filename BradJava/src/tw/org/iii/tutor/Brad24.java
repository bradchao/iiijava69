package tw.org.iii.tutor;

import javax.swing.JFrame;

public class Brad24 extends JFrame{
	public Brad24() {
		super("我的視窗");
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Brad24();
	}

}
