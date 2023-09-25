package Week03_02;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Myframe extends JFrame{
	public Myframe() {
		setSize(450, 150);
		setTitle("Mile -> Km");
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel label1 = new JLabel("마일을 입력하시오 ");
		JLabel label2 = new JLabel("->");
		JLabel label3 = new JLabel(" KM 값");
		JTextField field1 = new JTextField(10);
		JTextField field2 = new JTextField(10);
		JButton button = new JButton("변환");
		
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(label3);
		panel.add(field2);
		panel.add(button);
		
		class MyListener implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==button)
				{
					int t=Integer.parseInt(field1.getText());
					double k=t*1.609344;
					field2.setText(k+" km");
				}
			}
		}
		button.addActionListener(new MyListener());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Converter {
	public static void main(String[] arge) {
		Myframe f = new Myframe();
	}
}
