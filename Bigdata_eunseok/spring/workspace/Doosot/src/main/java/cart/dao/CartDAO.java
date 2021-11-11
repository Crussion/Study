package cart.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cart.dto.CartDTO;

@Repository
public class CartDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int check_contents(String mem_id) {
		return sqlSession.selectOne("mybatis.DooSotMapper.check_contents", mem_id);
	}
	
	public int create_cart() {
		return sqlSession.selectOne("mybatis.DooSotMapper.create_cart");
	}
	
	public int get_cart(String mem_id) {
		List<CartDTO> list = sqlSession.selectList("mybatis.DooSotMapper.get_cart", mem_id);
		return list.get(0).getCart_num();
	}
	
	public int add_cart(CartDTO dto) {
		return sqlSession.insert("mybatis.DooSotMapper.add_cart", dto);
	}
}
