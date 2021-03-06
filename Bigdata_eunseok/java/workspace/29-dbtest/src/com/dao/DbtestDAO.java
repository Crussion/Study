package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.DbtestDTO;

public class DbtestDAO {
	public DbtestDAO() {
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
	
	public List<DbtestDTO> selectArticle(){
		List<DbtestDTO> list = new ArrayList<DbtestDTO>();
		String sql = "select * from dbtest";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//DB요청, 응답으로 문자열이 온다.
			rs = pstmt.executeQuery();
			//ResultSet 객체 처리
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
				String logtime = rs.getString("logtime");
				DbtestDTO dto = new DbtestDTO(name, age, height, logtime);
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
	
	public int updateArticle() {
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
	
	public int deleteArticle() {
		Scanner s = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : ");
		String name = s.next();
		
		int result = 0; //응답 결과 저장;
		String sql = "delete dbtest where name = ?";
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
