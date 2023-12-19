package duksungDatabase4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	JTextField stuId, name, tel, dept;
	JButton previousButton, nextButton, InsertButton, deleteButton,
			searchButton, ClearButton;
	ResultSet rs;
	Statement stmt;
	
	public MyFrame() throws SQLException {
		super("Database Viewer");
		Connection con = makeConnection();
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//ResultsSet이 처음부터 끝까지 이동하면서 데이터를 순회할 수 있음
		rs = stmt.executeQuery("SELECT * FROM books");
		//모든 데이터를 가져옴
		
		setLayout(new GridLayout(0, 2));
		add(new JLabel("stustuId", JLabel.CENTER));
		add(stuId = new JTextField());
		
		add(new JLabel("name", JLabel.CENTER));
		add(name = new JTextField());
		
		add(new JLabel("tel", JLabel.CENTER));
		add(tel = new JTextField());
		
		add(new JLabel("dept", JLabel.CENTER));
		add(dept = new JTextField());

		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.previous(); //ResultSet에서 가져온 데이터를 화면에 업데이트
					stuId.setText("" + rs.getInt("stuId"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.next();
					stuId.setText("" + rs.getInt("stuId"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		InsertButton = new JButton("Insert");
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String deleteKeyword = name.getText();
				try {
					String query = "DELETE * FROM books WHERE tel LIKe '%" + deleteKeyword + "%'";
					ResultSet deleteResult = stmt.executeQuery(query);
					stuId.setText("");
					name.setText("");
					tel.setText("");
					dept.setText("");
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		});
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        String searchKeyword = name.getText(); // 여기서는 search가 아닌 searchtel를 사용해야 함
		        try {
		            // SQL 쿼리를 사용하여 저자 이름을 기준으로 검색
		            String query = "SELECT * FROM books WHERE tel LIKE '%" + searchKeyword + "%'";
		            ResultSet searchResult = stmt.executeQuery(query);
		            
		            // 검색 결과가 있으면 ResultSet에서 가져온 데이터를 화면에 업데이트
		            if (searchResult.next()) {
		                stuId.setText("" + searchResult.getInt("stuId"));
		                name.setText("" + searchResult.getString("name"));
		                tel.setText("" + searchResult.getString("tel"));
		                dept.setText("" + searchResult.getString("dept"));
		            } else {
		                System.out.println("검색 결과가 없습니다.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		});
		
		ClearButton = new JButton("Clear");
		
		add(previousButton);
		add(nextButton);
		add(InsertButton);
		add(deleteButton);
		add(searchButton);
		add(ClearButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
		}
	
		public static Connection makeConnection() {	
			String url = "jdbc:mysql://localhost:3308/book_db";
			String stuId = "root";
			String password = "root";
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("드라이버 적재 성공");
				con = DriverManager.getConnection(url, stuId, password);
				System.out.println("데이터베이스 연결 성공");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버를 찾을 수 없습니다.");
			} catch (SQLException e) {
				System.out.println("연결에 실패하였습니다.");
			}
			return con;
		}
	}


	public class ConnectDatabase {
		public static void main(String[] args) throws SQLException {
			new MyFrame();
		}
	}
