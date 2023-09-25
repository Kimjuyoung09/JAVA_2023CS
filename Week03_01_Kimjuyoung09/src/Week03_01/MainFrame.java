package Week03_01;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	public MainFrame() {
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel label = new JLabel("회원 등록하기");
		JLabel label1 = new JLabel(" 이름 ");
		JLabel label2 = new JLabel("패스워드");
		JLabel label3 = new JLabel("이메일 주소");
		JLabel label4 = new JLabel("전화번호");
		JTextField field1 = new JTextField(20);
		JTextField field2 = new JTextField(20);
		JTextField field3 = new JTextField(20);
		JTextField field4 = new JTextField(20);
		
		panel.add(label);
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(label4);
		panel.add(field4);
		
		JButton button1 = new JButton("등록하기");
		JButton button2 = new JButton("취소");
		panel.add(button1);
		panel.add(button2);
		
		setSize(500, 200);
		setTitle("회원 등록하기");
		setVisible(true);
	}
	public static void main(String argv[]) {
		MainFrame t = new MainFrame();
	}
}
