package score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	ScoreDAO dao;
	
	@Override
	public int scoreWrite(ScoreDTO dto) {
		return dao.scoreWrite(dto);
	}

	@Override
	public List<ScoreDTO> scoreList(int startNum, int endNum) {
		return dao.scoreList(startNum, endNum);
	}

	@Override
	public int tot_content() {
		return dao.tot_content();
	}

	@Override
	public ScoreDTO scoreView(ScoreDTO dto) {
		return dao.scoreView(dto);
	}

	@Override
	public int scoreDelete(ScoreDTO dto) {
		return dao.scoreDelete(dto);
	}

}
