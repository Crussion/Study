package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.GoodsVO;

@Repository("dao")
public class GoodsDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// SQL문
	String GOODS_INSERT = "insert into goods values (?, ?, ?, ?)";
	String GOODS_UPDATE = "update goods set name=?, price=?, maker=? where code=?";
	String GOODS_DELETE = "delete goods where code=?";
	String GOODS_GET = "select * from goods where code=?";
	String GOODS_LIST = "select * from goods order by code asc";
	
	public int insertGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_INSERT);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getMaker());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	public int updateGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getMaker());
			pstmt.setString(4, vo.getCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	public int deleteGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_DELETE);
			pstmt.setString(1, vo.getCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	public GoodsVO getGoods(GoodsVO vo) {
		GoodsVO goodsVO = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_GET);
			pstmt.setString(1, vo.getCode());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goodsVO = new GoodsVO();
				goodsVO.setCode(rs.getString("code"));
				goodsVO.setName(rs.getString("name"));
				goodsVO.setPrice(rs.getInt("price"));
				goodsVO.setMaker(rs.getString("maker"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return goodsVO;
	}
	
	public List<GoodsVO> getGoodsList(){
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(GOODS_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setMaker(rs.getString("maker"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
}
