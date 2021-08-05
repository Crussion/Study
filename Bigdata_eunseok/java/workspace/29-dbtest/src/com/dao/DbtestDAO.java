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
	
	//DB�� ��û, DB ����ó��, ���Ӳ���
	public int insertArticle() {
		Scanner s = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name = s.next();
		System.out.print("���� �Է� : ");
		int age = s.nextInt();
		System.out.print("Ű �Է� : ");
		double height = s.nextDouble();
		
		int su = 0; //���� ��� ����;
		String sql = "insert into dbtest values (?, ?, ?, sysdate)";
		//String sql = "insert into dbtest values ('" + name + "', " + age + ", " + height + ", sysdate)";
		
		//DB����
		Connection conn = getConnection();
		//��û, ���� ó��
		PreparedStatement pstmt = null;
		
		try {
			// ��û, ���� ��ü ����
			pstmt = conn.prepareStatement(sql);
			// pstmt ��ü ����
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			// db�� ��û �� ���䰪����
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//���� ����
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
	
	public int updateArticle() {
		Scanner s = new Scanner(System.in);
		System.out.print("������ �̸� �Է� : ");
		String name = s.next();
		name = "%" + name + "%";
		
		int result = 0; //���� ��� ����;
		String sql = "update dbtest set age = age + 1 where name like ?";
		Connection conn = getConnection();
		//��û, ���� ó��
		PreparedStatement pstmt = null;
		
		try {
			// ��û, ���� ��ü ����
			pstmt = conn.prepareStatement(sql);
			// pstmt ��ü ����
			pstmt.setString(1, name);
			// db�� ��û �� ���䰪����
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//���� ����
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
		System.out.print("������ �̸� �Է� : ");
		String name = s.next();
		
		int result = 0; //���� ��� ����;
		String sql = "delete dbtest where name = ?";
		Connection conn = getConnection();
		//��û, ���� ó��
		PreparedStatement pstmt = null;
		
		try {
			// ��û, ���� ��ü ����
			pstmt = conn.prepareStatement(sql);
			// pstmt ��ü ����
			pstmt.setString(1, name);
			// db�� ��û �� ���䰪����
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//���� ����
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
