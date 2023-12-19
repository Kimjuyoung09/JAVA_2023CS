package RaceGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubbleGameFrame extends JFrame{
	public BubbleGameFrame() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BubbleGameFrame();
	}
}

class GamePanel extends JPanel{
	public GamePanel() {
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new BubbleThread(e.getX(), e.getY()).start();
			}
		});
	}
	
	class BubbleThread extends Thread{
		private JLabel bubble;
		private int bubble_move = 5;
		
		public BubbleThread(int bubbleX, int bubbleY) {
			ImageIcon img = new ImageIcon("bubble.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(), img.getIconWidth());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble);
			repaint();
		}
		
		public void run() {
            while(true) {
                int x = bubble.getX();
                int y = bubble.getY();
                
                bubble.setLocation(x, y - bubble_move);
                
                if(bubble.getY() + bubble.getHeight() < 0) {
                    remove(bubble);
                }
                
                try {
                    Thread.sleep(20);
                }
                catch(InterruptedException e) { return; }
            }
        }
	}
}

class MyFrame extends JFrame{
	JButton startButton, endButton;
	
	public MyFrame() {
		startButton = new JButton("시작");
		startButton.setBounds(0, 500, 50, 50);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try { 
					start();	
				}catch(InterruptedException e) {
					System.exit(0);
				}
			}
		});
		endButton = new JButton("종료");
		endButton.setBounds(300, 500, 350, 50);
		endButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try { 
					System.exit(0);	
				}catch(InterruptedException e) {
					start();
				}
			}
		});
		add(startButton);
		add(endButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
	}
}

