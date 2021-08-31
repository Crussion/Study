package test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import test.bean.ScoreVO;

public class ScoreRowMapper implements RowMapper<ScoreVO>{
	@Override
	public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ScoreVO vo = new ScoreVO();
		vo.setStudNo(rs.getString("studNo"));
		vo.setName(rs.getString("name"));
		vo.setKor(rs.getInt("kor"));
		vo.setEng(rs.getInt("eng"));
		vo.setMat(rs.getInt("mat"));
		vo.setTot(rs.getInt("tot"));
		vo.setAvg(rs.getDouble("avg"));
		vo.setLogtime(rs.getString("logtime"));
		return vo;
	}
}
