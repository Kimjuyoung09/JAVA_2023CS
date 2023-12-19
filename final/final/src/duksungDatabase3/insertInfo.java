package duksungDatabase3;



import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.sql.*;

public class insertInfo {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3308/duksung?characterEncoding=UTF-8 & serverTimezone=UTC";
		String id = "root";
		String password = "root";
		Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 적재 성공");
		con = DriverManager.getConnection(url, id, password);
		System.out.println("데이터베이스 연결 성공");
	} catch(ClassNotFoundException e) {
		System.out.println("드라이버를 찾을 수 없습니다.");
	} catch(SQLException e) {
		System.out.println("연결에 실패하였습니다.");
	}
	
	return con;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection con = makeConnection();
		try {
		//매개변수화된 SQL를 작성
		String sql = "" + 
		"INSERT INTO duksung (stuId, name, tel, dept) " + 
				"VALUES (?, ?, ?, ?)";
		
		//PreparedStatement 열기 및 값 지정
		PreparedStatement pstmt1 = con.prepareStatement(sql);
		pstmt1.setInt(1,  2022001);
		pstmt1.setString(2, "Minji lee");
		pstmt1.setString(3, "000-0000-0001");
		pstmt1.setString(4, "Cyber Security");
		
		PreparedStatement pstmt2 = con.prepareStatement(sql);
		pstmt2.setInt(1,  2022002);
		pstmt2.setString(2, "Hanni park");
		pstmt2.setString(3, "000-0000-0002");
		pstmt2.setString(4, "Computer");
		
		PreparedStatement pstmt3 = con.prepareStatement(sql);
		pstmt3.setInt(1,  2022003);
		pstmt3.setString(2, "Danielle chung");
		pstmt3.setString(3, "000-0000-0003");
		pstmt3.setString(4, "IT Media");
		
		PreparedStatement pstmt4 = con.prepareStatement(sql);
		pstmt4.setInt(1,  2022004);
		pstmt4.setString(2, "Hyein choi");
		pstmt4.setString(3, "000-0000-0004");
		pstmt4.setString(4, "Software");
		
		//SQL 실행
		int rows1 = pstmt1.executeUpdate();
		System.out.println("저장된 행 수: " + rows1);
		
		int rows2 = pstmt2.executeUpdate();
		System.out.println("저장된 행 수: " + rows2);
		
		int rows3 = pstmt3.executeUpdate();
		System.out.println("저장된 행 수: " + rows3);
		
		int rows4 = pstmt4.executeUpdate();
		System.out.println("저장된 행 수: " + rows4);
		
		//PreparedStatement 닫기
		pstmt1.close();
		pstmt2.close();
		pstmt3.close();
		pstmt4.close();
		
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					//연결 끊기
					con.close();
				} catch (SQLException e) {}
			}
		}
	}
}

