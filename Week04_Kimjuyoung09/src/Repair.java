import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Repair extends JPanel implements ItemListener{
	JCheckBox[] buttons = new JCheckBox[4];
	String[] items = {"엔진오일 교환", "자동변속기오일교환", "에어콘필터교환", "타이어교환"};
	int[] prices = {45000, 80000, 30000, 100000};
	int money = 0;
	JLabel label;
	
	public Repair() {
		super();
		setLayout(new FlowLayout());
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JCheckBox(items[i]);
			buttons[i].addItemListener(this);
			add(buttons[i]);
		}
	
		label = new JLabel("현재까지의 가격은 " + "입니다.");
		Font font = new Font("Console font", Font.ITALIC, 16);
		label.setFont(font);
		add(label);
	}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			money = 0;
			for(int i = 0; i < buttons.length; i++) {
				if(buttons[i].isSelected()) {
					money += prices[i];
				}
			}
			label.setText("현재까지의 가격은 " + money + "입니다.");
		}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new Repair();
		newContentPane.setVisible(true);
		frame.setContentPane(newContentPane);
		frame.setSize(500, 200);
		frame.setVisible(true);
	}
}
	

