package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreDeleteController{
	@RequestMapping(value = "/score/scoreDelete.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		
		ScoreDAO dao = new ScoreDAO();
		int result = dao.scoreDelete(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreDelete.jsp");
		
		return modelAndView;
	}
}
