package score.dao;

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

import score.bean.ScoreBean;

public class ScoreDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	public ScoreDAO(){
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int scoreWrite(ScoreBean bean) {
		int result = 0;
		String sql = "insert into score values (?, ?, ?, ?, ?, ?, ?)";
		double kor = bean.getScore_kor();
		double eng = bean.getScore_eng();
		double math = bean.getScore_math();
		double total =  kor + eng + math;
		double avg = total / 3;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getStudent_num());
			pstmt.setString(2, bean.getStudent_name());
			pstmt.setDouble(3, kor);
			pstmt.setDouble(4, eng);
			pstmt.setDouble(5, math);
			pstmt.setDouble(6, total);
			pstmt.setDouble(7, avg);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public List<ScoreBean> scoreList(int startNum, int endNum){
		List<ScoreBean> list = new ArrayList<ScoreBean>();
		String sql = "select * from "
				   + "(select rownum rn, tt.* from "
				   + "(select * from score order by student_num asc) tt) "
				   + "where rn>=? and rn<=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreBean bean = new ScoreBean();
				bean.setStudent_name(rs.getString("student_name"));
				bean.setStudent_num(rs.getInt("student_num"));
				bean.setScore_kor(rs.getDouble("score_kor"));
				bean.setScore_eng(rs.getDouble("score_eng"));
				bean.setScore_math(rs.getDouble("score_math"));
				bean.setScore_total(rs.getDouble("score_total"));
				bean.setScore_avg(rs.getDouble("score_avg"));
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
		String sql = "select count(*) as cnt from score";
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
