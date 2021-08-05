package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class UpdateTest{
	public UpdateTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 등록 실패");
			e.printStackTrace();
		}
	}
	
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
	
	public int Update() {
		Scanner s = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = s.next();
		name = "%" + name + "%";
		
		int result = 0; //응답 결과 저장;
		String sql = "update dbtest set age = age + 1 where name like ?";
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

public class Exam4 {
	public static void main(String[] args) {
		UpdateTest test = new UpdateTest();
		int result = test.Update();
		System.out.println(result + "개의 행이 수정되었습니다.");
	}
}
