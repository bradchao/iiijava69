package tw.org.iii.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private BufferedImage ball0;
	private int ballX, ballY, ballW, ballH;
	private HashSet<BallTask> balls;
	
	public MyPanel() {
		setBackground(Color.GREEN);
		
		balls = new HashSet<>();
		try {
			ball0 = ImageIO.read(new File("dir1/ball0.png"));
			ballW = ball0.getWidth();
			ballH = ball0.getHeight();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				changeBallXY(e.getX(), e.getY());
			}
		});
	}
	
	void changeBallXY(int x, int y) {
		ballX = (int)(x - (ballW * 0.5)); 
		ballY = (int)(y - (ballH * 0.5));
		repaint();
		
	}
	
	private class BallTask extends TimerTask {
		int x, y;
		@Override
		public void run() {
			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (BallTask ball :balls) {
			g.drawImage(ball0, ball.x, ball.y, null);
		}
	}
	
}
