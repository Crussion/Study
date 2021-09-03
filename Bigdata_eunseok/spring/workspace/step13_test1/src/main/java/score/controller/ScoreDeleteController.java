package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreDeleteController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		
		ScoreDAO dao = new ScoreDAO();
		int result = dao.scoreDelete(dto);
		
		request.setAttribute("result", result);
		request.setAttribute("pg", pg);
		
		return "scoreDelete";
	}
}
