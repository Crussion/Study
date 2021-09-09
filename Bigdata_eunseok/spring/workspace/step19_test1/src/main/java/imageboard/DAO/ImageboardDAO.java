package imageboard.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import imageboard.bean.ImageboardDTO;

@Repository
public class ImageboardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int imageWrite(ImageboardDTO dto) {
		return sqlSession.insert("mybatis.Mapper.imageboardWrite", dto);
	}
	
	public List<ImageboardDTO> imageboardList(int startNum, int endNum){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.Mapper.imageboardList", map);
	}
	
	public int total_content() {
		return sqlSession.selectOne("mybatis.Mapper.total_content");
	}
	
	public ImageboardDTO imageboardView(int seq) {
		return sqlSession.selectOne("mybatis.Mapper.imageboardView", seq);
	}
}
