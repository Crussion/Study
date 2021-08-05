package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class InsertTest{
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 등록 성공");
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
			System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	
	//DB에 요청, DB 응답처리, 접속끊기
	public int insertArticle() {
		Scanner s = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = s.next();
		System.out.print("나이 입력 : ");
		int age = s.nextInt();
		System.out.print("키 입력 : ");
		double height = s.nextDouble();
		
		int su = 0; //응답 결과 저장;
		String sql = "insert into dbtest values (?, ?, ?, sysdate)";
		//String sql = "insert into dbtest values ('" + name + "', " + age + ", " + height + ", sysdate)";
		
		//DB접속
		Connection conn = getConnection();
		//요청, 응답 처리
		PreparedStatement pstmt = null;
		
		try {
			// 요청, 응답 객체 생성
			pstmt = conn.prepareStatement(sql);
			// pstmt 객체 설정
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			// db에 요청 및 응답값리턴
			su = pstmt.executeUpdate();
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
		return su;
	}
}
public class Exam2 {
	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
		//insertTest.getConnection();
		int su = insertTest.insertArticle();
		if(su > 0) {
			System.out.println("저장 성공");
		}else {
			System.out.println("저장 실패");
		}
	}
}
