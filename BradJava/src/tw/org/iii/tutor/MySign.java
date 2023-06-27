package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.classes.MyDrawer;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear, undo, redo;
	
	public MySign() {
		super("簽名App");
		setLayout(new BorderLayout());
		
		myDrawer = new MyDrawer();
		add(myDrawer, BorderLayout.CENTER);
		
		clear = new JButton("清除");
		undo = new JButton("上一");
		redo = new JButton("復原");
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo);
		
		add(top, BorderLayout.NORTH);
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MySign();
	}

}
