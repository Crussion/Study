package loca.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import event.bean.EventDTO;
import loca.bean.LocaDTO;

@Controller
public class LocaController {
	@Autowired
	private LocaService locaService;
	
	// 전체 리스트 구하기
	@RequestMapping(value = "*/loca_list.do")
	public ModelAndView locaList(HttpServletRequest request) {
		// 1. 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		int totalA = locaService.getTotalA();
		int totalP = (totalA + 9) / 10;
		
		if (pg > totalP) {
			pg = totalP;
		}
		// 페이징 : 3블럭 페이지 표시
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;		
		// 목록 : 3개씩
		int endNum = pg*10;
		int startNum = endNum - 9;
		
		List<LocaDTO> list = locaService.locaList(startNum, endNum);
		// 2. 데이터 공유 + 파일명
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("../loca/loca_list.jsp");
		return modelAndView;
	}

	// 검색 후 리스트 구하기
	@RequestMapping(value = "*/loca_SearchList.do")
	public ModelAndView locaSearchList(HttpServletRequest request) {
		// 1. 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		
		// DB
		int totalA = locaService.getTotalS(sido, gugun);
		int totalP = (totalA + 9) / 10;
		
		if (pg > totalP) {
			pg = totalP;
		}
		// 페이징 : 3블럭 페이지 표시
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;		
		// 목록 : 3개씩
		int endNum = pg*10;
		int startNum = endNum - 9;
		
		List<LocaDTO> list = locaService.locaListSearch(startNum, endNum, sido, gugun);
		// 2. 데이터 공유 + 파일명
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("sido", sido);
		modelAndView.addObject("gugun", gugun);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("../loca/loca_searchList.jsp");
		return modelAndView;
	}
	
	// 매장 등록
	@RequestMapping("*/locaWrite.do")
	public ModelAndView eventWrite(HttpServletRequest request, MultipartFile loca_img) {
		String filePath = request.getSession().getServletContext().getRealPath("/loca_map");
		String fileName = loca_img.getOriginalFilename();
		System.out.println(filePath);
		
		File file = new File(filePath, fileName);
		try {
			FileCopyUtils.copy(loca_img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LocaDTO dto = new LocaDTO();
		dto.setLoca_name(request.getParameter("loca_name"));
		dto.setLoca_addr(request.getParameter("loca_addr"));
		dto.setLoca_phone(request.getParameter("loca_phone"));
		dto.setLoca_img(fileName);
		
		int result = locaService.locaWrite(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("../loca/loca_write.jsp");
		return modelAndView;
	}

	// 매장선택 - 전체 리스트 구하기
	@RequestMapping(value = "*/loca_Select.do")
	public ModelAndView locaSelectList(HttpServletRequest request) {
		// 1. 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		int totalA = locaService.getTotalA();
		int totalP = (totalA + 9) / 10;
		
		if (pg > totalP) {
			pg = totalP;
		}
		// 페이징 : 3블럭 페이지 표시
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;		
		// 목록 : 3개씩
		int endNum = pg*10;
		int startNum = endNum - 9;
		
		List<LocaDTO> list = locaService.locaList(startNum, endNum);
		// 2. 데이터 공유 + 파일명
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("../loca/loca_selectList.jsp");
		return modelAndView;
	}	
	
	// 검색 후 리스트 구하기
	@RequestMapping(value = "*/loca_SelectSearch.do")
	public ModelAndView locaSelectSearch(HttpServletRequest request) {
		// 1. 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		System.out.println(sido + gugun);
		
		// DB
		int totalA = locaService.getTotalS(sido, gugun);
		int totalP = (totalA + 9) / 10;
		
		if (pg > totalP) {
			pg = totalP;
		}
		// 페이징 : 3블럭 페이지 표시
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;		
		// 목록 : 3개씩
		int endNum = pg*10;
		int startNum = endNum - 9;
		
		List<LocaDTO> list = locaService.locaListSearch(startNum, endNum, sido, gugun);
		// 2. 데이터 공유 + 파일명
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("sido", sido);
		modelAndView.addObject("gugun", gugun);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("../loca/loca_selectSearch.jsp");
		return modelAndView;
	}	
	
	
	
	@RequestMapping(value = "*/locaCorr.do")
	public ModelAndView eventCorr(HttpServletRequest request, MultipartFile loca_img) {
		String filePath = request.getSession().getServletContext().getRealPath("/loca_map");
		String fileName = loca_img.getOriginalFilename();
		System.out.println(filePath+"/" +fileName);
		
		File file = new File(filePath, fileName);	
		
		try {
			FileCopyUtils.copy(loca_img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 1. 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		int loca_num = Integer.parseInt(request.getParameter("loca_num"));
		
		LocaDTO dto = new LocaDTO();
		dto.setLoca_num(loca_num);
		dto.setLoca_name(request.getParameter("loca_name"));
		dto.setLoca_addr(request.getParameter("loca_addr"));
		dto.setLoca_phone(request.getParameter("loca_phone"));
		dto.setLoca_img(fileName);
		
		int result = locaService.locaCorr(dto);

		// 2. 데이터 공유 + 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loca_num", loca_num);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../loca/loca_corr.jsp");
		return modelAndView;		
		
	}	
	
	
	
	
	
	
	
	@RequestMapping(value = "/loca/locaDelete.do")
	public ModelAndView eventDelete(HttpServletRequest request) {
		// 데이터
		int loca_num = Integer.parseInt(request.getParameter("loca_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		int result = locaService.locaDelete(loca_num);
		
		// 2. 데이터 공유 + 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("loca_delete.jsp");
		return modelAndView;
		
	}
	
	
}
