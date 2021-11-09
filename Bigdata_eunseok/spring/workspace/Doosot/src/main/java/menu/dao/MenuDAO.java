package menu.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Repository;

import menu.dto.MenuDTO;

@Repository
public class MenuDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int menuWrite(MenuDTO dto) {
		return sqlSession.insert("mybatis.Mapper.menuWrite", dto);
	}
	
	public List<MenuDTO> menuList(){
		return sqlSession.selectList("mybatis.Mapper.menuListAll");
	}
	
	public List<MenuDTO> menuList(String menu_category){
		return sqlSession.selectList("mybatis.Mapper.menuList", menu_category);
	}
	
	public int total_content() {
		return sqlSession.selectOne("mybatis.Mapper.total_content");
	}
	
	public int category_content(String menu_category) {
		return sqlSession.selectOne("mybatis.Mapper.category_content", menu_category);
	}
	
	public MenuDTO menuDetail(int menu_num) {
		return sqlSession.selectOne("mybatis.Mapper.menuDetail", menu_num);
	}
}
