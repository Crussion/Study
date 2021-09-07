package score.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;

@Controller
public class ScoreController {
	@Autowired
	private ScoreService service;
	
	@RequestMapping("/score/scoreDelete.do")
	public ModelAndView scoreDelete(HttpServletRequest request, HttpServletResponse response) {

		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);

		int result = service.scoreDelete(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreDelete.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreList.do")
	public ModelAndView scoreList(HttpServletRequest request, HttpServletResponse response) {
		
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<ScoreDTO> list = service.scoreList(startNum, endNum);
		
		int tot_content = service.tot_content();
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
	
	@RequestMapping("/score/scoreView.do")
	public ModelAndView scoreView(HttpServletRequest request, HttpServletResponse response) {

		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		dto = service.scoreView(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("scoreView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreWrite.do")
	public ModelAndView scoreWrite(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = tot / 3.0;
		
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		int result = service.scoreWrite(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("scoreWrite.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/score/scoreWriteForm.do")
	public ModelAndView scoreWriteForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scoreWriteForm.jsp");
		return modelAndView;
	}
}
