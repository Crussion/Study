package board.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import boardbean.BoardDTO;

public class BoardDAO {
	/*
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "C##dbexam";
	String password = "m1234";
	*/
	Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds;
	
	public BoardDAO() {
		//import javax.naming.Context;
		//import javax.naming.InitialContext;
		try {
			//InitialContext() : context.xml을 읽어온다.
			Context context = new InitialContext();
			//톰캣인 경우, DataSource 객체를 찾을 경우,
			//반드시 커넥션풀 설정이름 앞에 "java:comp/env/"를 붙여야한다.
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	/*
	public BoardDAO() {
		try {
			Class.forName(driver);
			System.out.println("드라이브 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 등록 실패");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");
		}catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	*/
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int write(BoardDTO dto) {
		int result=0;
		String sql = "insert into board values (seq_board.nextval, ?, ?, ?, ?, 0, sysdate)";
		//conn = getConnection();
		try {
			conn = ds.getConnection();				//커넥션 풀에서 커넥션 가져오기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			
			result = pstmt.executeUpdate(); // insert, update, delete => 리턴값은 데이터 처리 갯수
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// 5개씩 목록보기
	public List<BoardDTO> boardList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select seq, id, name, subject, content, hit, to_char(logtime, 'YYYY.MM.DD') as logtime from"
				   + "(select rownum rn, tt.* from (select * from board order by seq desc) tt)"
				   + "where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = 
						new BoardDTO(rs.getLong("seq"), rs.getString("id"),
									 rs.getString("name"), rs.getString("subject"),
									 rs.getString("content"), rs.getLong("hit"),
									 rs.getString("logtime")
								    );
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public BoardDTO boardView(int seq) {
		BoardDTO dto = null;
		String sql = "select * from board where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = 
					new BoardDTO(rs.getLong("seq"), rs.getString("id"),
								 rs.getString("name"), rs.getString("subject"),
								 rs.getString("content"), rs.getLong("hit"),
								 rs.getString("logtime")
							    );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public int UpHit(int seq) {
		int result = 0;
		String sql = "update board set hit=hit+1 where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int getTotal() {
		int result = 0;
		String sql = "select count(*) as cnt from board";
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
	
	public int boardDelete(int seq) {
		int result = 0;
		String sql = "delete board where seq=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int boardModify(int seq, String subject, String content) {
		int result = 0;
		String sql = "update board set subject=?, content=? where seq=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, seq);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
