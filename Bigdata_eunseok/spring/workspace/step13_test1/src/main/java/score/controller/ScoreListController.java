package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreListController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		ScoreDAO dao = new ScoreDAO();
		List<ScoreDTO> list = dao.scoreList(startNum, endNum);
		
		int tot_content = dao.tot_content();
		int tot_page = (tot_content + 4) / 5;
		
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > tot_page)
			endPage = tot_page;
		
		request.setAttribute("tot_page", tot_page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);

		return "scoreList";
	}
}
