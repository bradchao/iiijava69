package tw.org.iii.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.org.iii.classes.MyDrawer;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	
	public MySign() {
		super("簽名App");
		setLayout(new BorderLayout());
		
		myDrawer = new MyDrawer();
		add(myDrawer, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MySign();
	}

}
