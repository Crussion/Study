package test01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.bean.GoodsVO;
import test.dao.JDBCUtil;

@Repository
public class GoodsDAOSpring {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// SQL문
		String GOODS_INSERT = "insert into goods values (?, ?, ?, ?)";
		String GOODS_UPDATE = "update goods set name=?, price=?, maker=? where code=?";
		String GOODS_DELETE = "delete goods where code=?";
		String GOODS_GET = "select * from goods where code=?";
		String GOODS_LIST = "select * from goods order by code asc";
		
		public int insertGoods(GoodsVO vo) {
			int result = jdbcTemplate.update(GOODS_INSERT, vo.getCode(), vo.getName(),
							vo.getPrice(), vo.getMaker());
			return result;
		}
		
		public int updateGoods(GoodsVO vo) {
			int result = jdbcTemplate.update(GOODS_UPDATE, vo.getName(), vo.getPrice(),
					vo.getMaker(), vo.getCode());
			return result;
		}
		
		public int deleteGoods(GoodsVO vo) {
			int result = jdbcTemplate.update(GOODS_DELETE, vo.getCode());
			return result;
		}
		
		public GoodsVO getGoods(GoodsVO vo) {
			Object[] args = {vo.getCode()};
			return jdbcTemplate.queryForObject(GOODS_GET, args, new GoodsRowMapper());
		}
		
		public List<GoodsVO> getGoodsList(){
			return jdbcTemplate.query(GOODS_LIST, new GoodsRowMapper());
		}
}
