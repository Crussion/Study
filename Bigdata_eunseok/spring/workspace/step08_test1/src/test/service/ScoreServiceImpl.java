package test.service;

import java.util.List;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

public class ScoreServiceImpl implements ScoreService{
	ScoreDAOSpring dao;
	
	public ScoreDAOSpring getDao() {
		return dao;
	}

	public void setDao(ScoreDAOSpring dao) {
		this.dao = dao;
	}

	@Override
	public int insertData(ScoreVO vo) {
		return dao.insertData(vo);
	}
	
	@Override
	public int updateData(ScoreVO vo) {
		return dao.updateData(vo);
	}
	
	@Override
	public int deleteData(ScoreVO vo) {
		return dao.deleteData(vo);
	}
	
	@Override
	public ScoreVO getData(ScoreVO vo) {
		return dao.getData(vo);
	}
	
	@Override
	public List<ScoreVO> getList() {
		return dao.getList();
	}
}
