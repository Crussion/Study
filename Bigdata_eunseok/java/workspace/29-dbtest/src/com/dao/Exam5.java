package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class DeleteTest{
	public DeleteTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̺� ��� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̺� ��� ����");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";			//����Ŭ ������ ���̽� �ּ�
		String username = "C##dbexam";								//����� ����
		String password = "m1234";									//���� ��й�ȣ
		try {
			conn = DriverManager.getConnection(url, username, password);
			//System.out.println("���� ����");
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		return conn;
	}
	
	public int Delete() {
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
public class Exam5 {
	public static void main(String[] args) {
		DeleteTest test = new DeleteTest();
		int result = test.Delete();
		if(result > 0) {
			System.out.println(result + "���� ���� �����Ǿ����ϴ�.");
		}else {
			System.out.println("���� ����");
		}
	}
}
