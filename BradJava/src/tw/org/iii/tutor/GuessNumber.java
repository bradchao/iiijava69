package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	
	public GuessNumber() {
		super("猜數字");
		
		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		add(top, BorderLayout.NORTH);
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		add(log, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		guess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(createAnswer(4));
			}
		});
		
		initGame();
	}
	
	private void initGame() {
		answer = createAnswer(4);
		System.out.println(answer);
	}
	
	private String createAnswer(int d) {
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
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(poker[0]).append(poker[1]).append(poker[2]);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}

}
