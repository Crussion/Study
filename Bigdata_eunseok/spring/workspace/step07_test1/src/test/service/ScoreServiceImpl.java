package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

@Component("scoreService")
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	ScoreDAOSpring dao;
	
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
