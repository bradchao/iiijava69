package tw.org.iii.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyDrawerV2 extends JPanel {
	private LinkedList<Line> lines, garbag;
	private Color nowColor;
	private float nowWidth;
	
	public MyDrawerV2() {
		lines = new LinkedList<>();
		garbag = new LinkedList<>();
		setBackground(Color.YELLOW);
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		
		nowColor = Color.BLUE;
		nowWidth = 4;
		
	}
	
	public void setColor(Color newColor) {nowColor = newColor;}
	public Color getColor() {return nowColor;}
	public void setWidth (float newWidth) {nowWidth = newWidth;}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX(), y = e.getY();
			
			Line line = new Line(nowColor, nowWidth);
			line.addPoint(x, y);
			
			lines.add(line);
			
			garbag.clear();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			int x = e.getX(), y = e.getY();
			lines.getLast().addPoint(x, y);
			
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for (Line line : lines) {
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));
			
			for (int i=1; i<line.getSize(); i++) {
				g2d.drawLine(line.getPointX(i-1), line.getPointY(i-1), 
						line.getPointX(i), line.getPointY(i));
			}
			
		}
	}
	
	public void clear() {
		lines.clear();
		garbag.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size()>0) {
			garbag.add(lines.removeLast());
			repaint();
		}
	}
	
	public void redo() {
		if (garbag.size() > 0) {
			lines.add(garbag.removeLast());
			repaint();
		}
	}
	
	public void saveJPEG() {
		System.out.println("saveJPEG()1");
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		paint(g);
		try {
	        if (ImageIO.write(img, "jpg", new File("dir1/brad.jpg"))) {
	        	System.out.println("OK");
	        }else {
	        	System.out.println("XX");
	        }
			System.out.println("saveJPEG()2");
	    } catch (IOException e) {
	    	System.out.println(e);
	    }
	}
	
	public void saveLines() throws Exception {
		try(ObjectOutputStream oout = 
			new ObjectOutputStream(new FileOutputStream("dir1/brad.sign"))){
			oout.writeObject(lines);
			oout.flush();
		}
	}
	
	public void loadLines() throws Exception{
		ObjectInputStream oin = 
			new ObjectInputStream(new FileInputStream("dir1/brad.sign"));
		Object obj = oin.readObject();
		lines = (LinkedList<Line>)obj;
		oin.close();
		
		repaint();
	}
	
}

class Line implements Serializable {
	private LinkedList<HashMap<String, Integer>> points;
	private Color color;
	private float width;
	
	public Line(Color color, float width) {
		points = new LinkedList<>();
		this.color = color; 
		this.width = width;
	}
	
	public void addPoint(int x, int y) {
		HashMap<String, Integer> point = new HashMap<>();
		point.put("x", x); point.put("y", y);
		points.add(point);
	}
	
	public int getPointX(int index) {
		return points.get(index).get("x");
	}
	public int getPointY(int index) {
		return points.get(index).get("y");
	}
	public int getSize() {return points.size();}

	public Color getColor() {
		return color;
	}

	public float getWidth() {
		return width;
	}
	
	
}


