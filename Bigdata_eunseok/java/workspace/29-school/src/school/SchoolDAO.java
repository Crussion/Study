package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolDAO {
	public SchoolDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("드라이브 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 등록 실패");
			e.printStackTrace();
		}
	}
	
	//DB에 접속
	//import java.sql.Connection;
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";			//오라클 데이터 베이스 주소
		String username = "C##dbexam";								//사용자 계정
		String password = "m1234";									//계정 비밀번호
		try {
			conn = DriverManager.getConnection(url, username, password);
			//System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	
	//DB에 요청, DB 응답처리, 접속끊기
	public int insertArticle(String name, String value, int code) {
		int result = 0; //응답 결과 저장;
		String sql = "insert into school values (?, ?, ?)";
		
		//DB접속
		Connection conn = getConnection();
		//요청, 응답 처리
		PreparedStatement pstmt = null;
		
		try {
			// 요청, 응답 객체 생성
			pstmt = conn.prepareStatement(sql);
			// pstmt 객체 설정
			pstmt.setString(1, name);
			pstmt.setString(2, value);
			pstmt.setInt(3, code);
			// db에 요청 및 응답값리턴
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//접속 끊기
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<SchoolDTO> selectArticle(String name){
		List<SchoolDTO> list = new ArrayList<SchoolDTO>();
		String sql;
		if(name == null) sql = "select * from school";
		else sql = "select * from school where name like ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(name != null)
				pstmt.setString(1, ("%" + name + "%"));
			//DB요청, 응답으로 문자열이 온다.
			rs = pstmt.executeQuery();
			//ResultSet 객체 처리
			while(rs.next()){
				String nam = rs.getString("name");
				String value = rs.getString("value");
				int code = rs.getInt("code");
				SchoolDTO dto = new SchoolDTO(nam, value, code);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int deleteArticle(String name) {
		int result = 0; //응답 결과 저장;
		String sql = "delete school where name = ?";
		Connection conn = getConnection();
		//요청, 응답 처리
		PreparedStatement pstmt = null;
		
		try {
			// 요청, 응답 객체 생성
			pstmt = conn.prepareStatement(sql);
			// pstmt 객체 설정
			pstmt.setString(1, name);
			// db에 요청 및 응답값리턴
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//접속 끊기
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
