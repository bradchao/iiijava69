package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes; 
	private Car[] cars;
	private int rank;
	
	public Racing() {
		setLayout(new GridLayout(9,1));
		
		go = new JButton("Go!");
		add(go);

		cars = new Car[8];
		lanes = new JLabel[8];
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + ". ");
			add(lanes[i]);
		}
		
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		
		setSize(1024, 480);
		setVisible(true);
	}
	
	private void go() {
		go.setEnabled(false);
		rank = 0;
		for (int i=0; i<lanes.length; i++) {
			lanes[i].setText((i+1) + ". ");
		}
		for (int i=0; i<cars.length; i++) {
			cars[i] = new Car(i);
			cars[i].start();
		}
	}
	
	private class Car extends Thread{
		private int lane;
		Car(int lane){this.lane = lane;}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				try {
					if (i == 99) {
						lanes[lane].setText(lanes[lane].getText() + ">" + ++rank);
						stopGame();
					}else {
						lanes[lane].setText(lanes[lane].getText() + ">");					
					}
					Thread.sleep(10 + (int)(Math.random()*100));
				}catch(InterruptedException e) {
					break;
				}
			}
		}
	}
	
	private void stopGame() {
		for (int i=0; i<cars.length; i++) {
			cars[i].interrupt();
		}
		go.setEnabled(true);
	}
	
	
	
	public static void main(String[] args) {
		new Racing();
	}

}
