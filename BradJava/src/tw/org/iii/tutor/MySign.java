package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.classes.MyDrawerV2;

public class MySign extends JFrame{
	private MyDrawerV2 myDrawer;
	private JButton clear, undo, redo, saveJPEG, saveObj, loadObj,
		changeColor;
	
	public MySign() {
		super("簽名App");
		setLayout(new BorderLayout());
		
		myDrawer = new MyDrawerV2();
		add(myDrawer, BorderLayout.CENTER);
		
		clear = new JButton("清除");
		undo = new JButton("上一");
		redo = new JButton("復原");
		saveJPEG = new JButton("存檔");
		saveObj = new JButton("序列化");
		loadObj = new JButton("解序列");
		changeColor = new JButton("顏色");
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo); top.add(saveJPEG);
		top.add(saveObj); top.add(loadObj);
		top.add(changeColor);
		add(top, BorderLayout.NORTH);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		saveJPEG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJPEG();
			}
		});
		saveObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myDrawer.saveLines();
				}catch(Exception e2) {
					System.out.println(e2);
				}
			}
		});
		loadObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myDrawer.loadLines();
				}catch(Exception e2) {
					System.out.println(e2);
				}
			}
		});
		changeColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//myDrawer.setColor(Color.BLACK);
				Color newColor = JColorChooser.showDialog(null, "換顏色", myDrawer.getColor());
				if (newColor != null) {
					myDrawer.setColor(newColor);
				}
			}
		});
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
