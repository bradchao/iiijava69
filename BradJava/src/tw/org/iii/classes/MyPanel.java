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
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private BufferedImage ball0;
	private int ballW, ballH;
	
	private HashSet<BallTask> balls;
	private Timer timer;
	private int viewW, viewH;
	
	
	public MyPanel() {
		setBackground(Color.GREEN);
		
		balls = new HashSet<>();
		timer = new Timer();
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
				createBall(e.getX(), e.getY());
			}
		});
		
		
		timer.schedule(new refreshTask(), 0, 16);	// 60 fps
	}
	

	private void createBall(int x, int y) {
		BallTask ball = new BallTask(x, y);
		balls.add(ball);
		timer.schedule(ball, 500, 30);
	}
	
	private class BallTask extends TimerTask {
		int x, y, dx, dy;
		public BallTask(int x, int y) {
			this.x = (int)(x - (ballW * 0.5));
			this.y = (int)(y - (ballH * 0.5));
			dx = (int)(Math.random()*17-8);
			dy = (int)(Math.random()*17-8);
		}
		
		@Override
		public void run() {
			if (x <= 0 || x + ballW >= viewW) {
				dx *= -1;
			}
			if (y<=0 || y+ballH >= viewH) {
				dy *= -1;
			}
			
			x += dx;
			y += dy;
			
		}
	}
	
	private class refreshTask extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
		for (BallTask ball :balls) {
			
			g.drawImage(ball0, ball.x, ball.y, null);
		}
	}
	
}
