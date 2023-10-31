package problem1;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	public MyFrame() {
		setTitle("덕성여대 화이팅");
		setSize(300, 200);
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		add(panel);
		
		JLabel title = new JLabel("학생 등록하기");
		panel.add(title);
		
		JLabel name1 = new JLabel("이름");
		panel.add(name1);
		JTextField name2 = new JTextField(20);
		panel.add(name2);

		JLabel num1 = new JLabel("학번");
		panel.add(num1);
		JTextField num2 = new JTextField(20);
		panel.add(num2);
		JLabel score1 = new JLabel("성적");
		panel.add(score1);
		JTextField score2 = new JTextField(20);
		panel.add(score2);
		
		JButton button1 = new JButton("등록하기");
		button1.addActionListener(e->{
			String name = name2.getText();
			String num = num2.getText();
			String score = score2.getText();
		});
		
		JButton button2 = new JButton("취소");
		button2.addActionListener(e->{
			System.exit(0);
		});
		panel.add(button1);
		panel.add(button2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(button1.isSelected()) {
			System.out.println("이름: " +name2+ " 학번: " +num2+ " 성적: " +score2);
		}
	}
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}
}
