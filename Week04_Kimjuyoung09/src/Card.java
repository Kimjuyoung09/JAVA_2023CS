import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.ImageIO;

class MyFrame extends JFrame{
	BufferedImage img = null;
	public MyFrame(){
		setTitle("BusinessCard");
		setSize(700, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			img = ImageIO.read(new File("char.png"));
		} catch(IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		add(new MyPanel());
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.drawImage(img, 30, 30, null);
			g.drawString("김주영", 400, 70);
			g.drawString("학생", 400, 100);
			g.drawString("덕성여자대학교", 400, 130);
		}
	}
}

public class Card {
	public static void main(String[] args) {
		MyFrame F = new MyFrame();
	}
}

