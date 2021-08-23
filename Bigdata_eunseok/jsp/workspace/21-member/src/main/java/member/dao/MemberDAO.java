package member.dao;

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

import member.bean.MemberBean;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	public MemberDAO(){
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
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
	
	public int write(MemberBean bean) {
		int result=0;
		String sql = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getId());
			pstmt.setString(3, bean.getPwd());
			pstmt.setString(4, bean.getGender());
			pstmt.setString(5, bean.getEmail1());
			pstmt.setString(6, bean.getEmail2());
			pstmt.setString(7, bean.getTel1());
			pstmt.setString(8, bean.getTel2());
			pstmt.setString(9, bean.getTel3());
			pstmt.setString(10, bean.getAddr());
			
			result = pstmt.executeUpdate(); // insert, update, delete => 리턴값은 데이터 처리 갯수
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public String login(String id, String pwd) {
		String name = null;
		String sql = "select * from member where id=? and pwd=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();	// select => 리턴값이 ResultSet 객체로 들어온다.
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}
	
	public MemberBean member_read(String id) {
		MemberBean bean = new MemberBean();
		String sql = "select * from member where id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setName(rs.getString("name"));
				bean.setId(id);
				bean.setPwd(rs.getString("pwd"));
				bean.setGender(rs.getString("gender"));
				bean.setEmail1(rs.getString("email1"));
				bean.setEmail2(rs.getString("email2"));
				bean.setTel1(rs.getString("tel1"));
				bean.setTel2(rs.getString("tel2"));
				bean.setTel3(rs.getString("tel3"));
				bean.setAddr(rs.getString("addr"));
				bean.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bean;
	}
	
	public int member_modify(MemberBean dto){
		int result = 0;
		String sql = "update member set pwd=?, gender=?, email1=?, email2=?, tel1=?, tel2=?, tel3=?, addr=? where id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getEmail1());
			pstmt.setString(4, dto.getEmail2());
			pstmt.setString(5, dto.getTel1());
			pstmt.setString(6, dto.getTel2());
			pstmt.setString(7, dto.getTel3());
			pstmt.setString(8, dto.getAddr());
			pstmt.setString(9, dto.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public List<MemberBean> memberList(int startNum, int endNum){
		List<MemberBean> list = new ArrayList<MemberBean>();
		String sql = "select * from"
				   + "(select rownum rn, tt.* from (select * from member order by name asc) tt)"
				   + "where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberBean dto = new MemberBean();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail1(rs.getString("email1"));
				dto.setEmail2(rs.getString("email2"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setAddr(rs.getString("addr"));
				dto.setLogtime(rs.getString("logtime"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public int getTotalMember(){
		int result = 0;
		String sql = "select count(*) as cnt from member";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public boolean checkId(String id) {
		boolean result = false;
		String sql = "select * from member where id=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
