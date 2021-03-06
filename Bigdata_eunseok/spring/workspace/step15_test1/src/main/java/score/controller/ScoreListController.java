package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreListController{
	@RequestMapping(value = "/score/scoreList.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
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
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("tot_page", tot_page);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreList.jsp");

		return modelAndView;
	}
}
