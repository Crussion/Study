package test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository
public class ScoreDAOSpring {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	String SCORE_INSERT = "insert into score values (?, ?, ?, ?, ?, ?, ?, sysdate)";
	String SCORE_UPDATE = "update score set kor=?, eng=?, mat=?, tot=?, avg=? where studNo=?";
	String SCORE_DELETE = "delete score where studNo=?";
	String SCORE_GET = "select * from score where studNo=?";
	String SCORE_LIST = "select * from score order by studNo asc";
	
	public int insertData(ScoreVO vo) {
		int tot = vo.getKor() + vo.getEng() + vo.getMat();
		double avg = tot / 3.0;
		Object[] args = {vo.getStudNo(), vo.getName(), vo.getKor(), vo.getEng(),
							vo.getMat(), tot, avg};
		return jdbcTemplate.update(SCORE_INSERT, args);
	}
	public int updateData(ScoreVO vo) {
		int tot = vo.getKor() + vo.getEng() + vo.getMat();
		double avg = tot / 3.0;
		Object[] args = {vo.getKor(), vo.getEng(), vo.getMat(), tot, avg, 
						vo.getStudNo()};
		return jdbcTemplate.update(SCORE_UPDATE, args);
	}
	public int deleteData(ScoreVO vo) {
		return jdbcTemplate.update(SCORE_DELETE, vo.getStudNo());
	}
	public ScoreVO getData(ScoreVO vo) {
		Object[] args = {vo.getStudNo()};
		return jdbcTemplate.queryForObject(SCORE_GET, args, new ScoreRowMapper());
	}
	public List<ScoreVO> getList(){
		return jdbcTemplate.query(SCORE_LIST, new ScoreRowMapper());
	}
}
