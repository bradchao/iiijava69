package tw.org.iii.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import tw.org.iii.classes.MyTable;

public class JDBC10 extends JFrame {
	private MyTable myTable;
	
	public JDBC10() {
	
		setLayout(new BorderLayout());
		myTable = new MyTable();
		JScrollPane jsp = new JScrollPane(myTable);
		add(jsp, BorderLayout.CENTER);
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new JDBC10();
	}

}
