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
}
public class Exam2 {
	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
		//insertTest.getConnection();
		int su = insertTest.insertArticle();
		if(su > 0) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
}
