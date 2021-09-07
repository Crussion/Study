package score.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import score.bean.ScoreDTO;

@Repository
public class ScoreDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	public int scoreWrite(ScoreDTO dto) {
		return sqlSession.insert("mybatis.scoreMapper.scoreWrite", dto);
	}
	
	public List<ScoreDTO> scoreList(int startNum, int endNum){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.scoreMapper.scoreList", map);
	}
	
	public int tot_content() {
		return sqlSession.selectOne("mybatis.scoreMapper.tot_content");
	}
	
	public ScoreDTO scoreView(ScoreDTO dto) {
		return sqlSession.selectOne("mybatis.scoreMapper.scoreView", dto);
	}
	
	public int scoreDelete(ScoreDTO dto) {
		return sqlSession.delete("mybatis.scoreMapper.scoreDelete", dto);
	}
}
