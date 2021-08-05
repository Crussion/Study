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
			//System.out.println("����̺� ��� ����");
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
			//System.out.println("���� ����");
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		return conn;
	}
	
	//DB�� ��û, DB ����ó��, ���Ӳ���
	public int insertArticle(String name, String value, int code) {
		int result = 0; //���� ��� ����;
		String sql = "insert into school values (?, ?, ?)";
		
		//DB����
		Connection conn = getConnection();
		//��û, ���� ó��
		PreparedStatement pstmt = null;
		
		try {
			// ��û, ���� ��ü ����
			pstmt = conn.prepareStatement(sql);
			// pstmt ��ü ����
			pstmt.setString(1, name);
			pstmt.setString(2, value);
			pstmt.setInt(3, code);
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
			//DB��û, �������� ���ڿ��� �´�.
			rs = pstmt.executeQuery();
			//ResultSet ��ü ó��
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
		int result = 0; //���� ��� ����;
		String sql = "delete school where name = ?";
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
