package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import test.bean.ScoreVO;

public class ScoreDAOSpring {
	SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int insertData(ScoreVO vo) {
		return sqlSession.insert("mybatis.scoreMapper.insertData", vo);
	}
	public int updateData(ScoreVO vo) {
		return sqlSession.update("mybatis.scoreMapper.updateData", vo);
	}
	public int deleteData(ScoreVO vo) {
		return sqlSession.delete("mybatis.scoreMapper.deleteData", vo);
	}
	public ScoreVO getData(ScoreVO vo) {
		return sqlSession.selectOne("mybatis.scoreMapper.getData", vo);
	}
	public List<ScoreVO> getList(){
		return sqlSession.selectList("mybatis.scoreMapper.getList");
	}
}
