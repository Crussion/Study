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
			System.out.println("����̺� ��� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̺� ��� ����");
			e.printStackTrace();
		}
	}
	
	//DB�� ����
	//import java.sql.Connection;
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";			//����Ŭ ������ ���̽� �ּ�
		String username = "C##dbexam";								//����� ����
		String password = "m1234";									//���� ��й�ȣ
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("���� ����");
		} catch (SQLException e) {
			System.out.println("���� ����");
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
			//DB��û, �������� ���ڿ��� �´�.
			rs = pstmt.executeQuery();
			//ResultSet ��ü ó��
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
