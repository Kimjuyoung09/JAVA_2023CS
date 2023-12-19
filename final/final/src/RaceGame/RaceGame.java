package RaceGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RaceGame extends JFrame{
	class CarThread extends Thread{
		private JLabel car;
		private int car_move = 1;
		private int x, y;
		
		public CarThread(String fname, int x, int y) {
			this.x = x;
			this.y = y;
			car = new JLabel();
			car.setIcon(new ImageIcon(fname));
			car.setBounds(x, y, 100, 100);
			add(car);
			repaint();
		}
		
		public void run() {
            for(int i = 0; i < 200; i++) {
            	x += 10*Math.random();
            	car.setBounds(x, y, 100, 100);
            	repaint();
            	try {
            		Thread.sleep(100);
            	}catch(InterruptedException e) {
            		e.printStackTrace();
            	}
            }
		}
	}
		
	public RaceGame() {
		setTitle("CarRace");
		setSize(600, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
			
		(new CarThread("car1.gif", 100, 0)).start();
		(new CarThread("car2.gif", 100, 50)).start();
		(new CarThread("car3.gif", 100, 100)).start();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new RaceGame();
	}
}


	

