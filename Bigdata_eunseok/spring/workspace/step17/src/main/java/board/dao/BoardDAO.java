package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "C##dbexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDAO() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		try {
			conn= DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close() {
		try {
			if (rs != null)rs.close();
			if (pstmt != null)pstmt.close();
			if (conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 목록 (5개씩)
	public List<BoardDTO> boardList(int startNum, int endNum) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select seq, id, name, subject, content, hit, "
				   + " to_char(logtime, 'YYYY.MM.DD') as logtime from " 
				   + " (select rownum rn, tt.* from "
				   + " (select * from board order by seq desc) tt) " 
				   + " where rn>=? and rn<=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setLogtime(rs.getString("logtime"));
				// 리스트에 저장
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	// 총 데이터수
	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) as cnt from board";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalA = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
	}
	// 글쓰기
	public int boardWrite(BoardDTO dto) {
		int su = 0;
		String sql = "insert into board values (seq_board.nextval, ?, ?, ?, ?, 0, sysdate)";
		
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}	
	// 조회수 증가
	public int updateHit(int seq) {
		int su = 0;
		String sql = "update board set hit=hit+1 where seq=?";
		
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}	
	// 상세보기
	public BoardDTO boardView(int seq) {
		BoardDTO dto = null;
		String sql = "select * from board where seq=?";
		
		conn = getConnection();
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}	
	// 삭제하기
	public int delete(int seq) {
		int su = 0;
		String sql = "delete board where seq=?";
		
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}	
}
