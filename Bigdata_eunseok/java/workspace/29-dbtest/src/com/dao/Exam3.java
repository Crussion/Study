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

class SelectTest{
	public SelectTest() {
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
}

public class Exam3 {
	public static void main(String[] args) {
		SelectTest test = new SelectTest();
		List<DbtestDTO> list = test.selectArticle();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
}
