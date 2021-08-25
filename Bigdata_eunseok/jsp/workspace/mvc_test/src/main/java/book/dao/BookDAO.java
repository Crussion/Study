package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import book.bean.BookBean;

public class BookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public BookDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int bookWrite(BookBean bean) {
		int result = 0;
		String sql = "insert into book2 values (?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getBook_num());
			pstmt.setString(2, bean.getBook_subject());
			pstmt.setString(3, bean.getBook_writer());
			pstmt.setString(4, bean.getBook_publisher());
			pstmt.setInt(5, bean.getBook_price());
			pstmt.setString(6, bean.getBook_date());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public List<BookBean> bookList(int startNum, int endNum){
		List<BookBean> list = new ArrayList<BookBean>();
		String sql = "select * from "
				   + "(select rownum rn, tt.* from (select * from book2 order by book_num asc) tt) "
				   + "where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookBean bean = new BookBean();
				bean.setBook_num(rs.getInt("book_num"));
				bean.setBook_subject(rs.getString("book_subject"));
				bean.setBook_writer(rs.getString("book_writer"));
				bean.setBook_publisher(rs.getString("book_publisher"));
				bean.setBook_price(rs.getInt("book_price"));
				bean.setBook_date(rs.getString("book_date"));
				
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public int getTotal() {
		int result = 0;
		String sql = "select count(*) as cnt from book2";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
