package score.controller;

import java.util.List;

import score.bean.ScoreDTO;

public interface ScoreService {
	public int scoreWrite(ScoreDTO dto);
	public List<ScoreDTO> scoreList(int startNum, int endNum);
	public int tot_content();
	public ScoreDTO scoreView(ScoreDTO dto);
	public int scoreDelete(ScoreDTO dto);
}
