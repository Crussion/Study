package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	public int insertData(ScoreVO vo);
	public int updateData(ScoreVO vo);
	public int deleteData(ScoreVO vo);
	public ScoreVO getData(ScoreVO vo);
	public List<ScoreVO> getList();
}
