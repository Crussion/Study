package menu.controller;


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

import menu.dao.MenuDAO;
import menu.dto.MenuDTO;

@Controller
public class MenuController {
	@Autowired
	MenuDAO dao;
	
	@RequestMapping("/menu/menuWriteForm.do")
	ModelAndView menuWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("menuWriteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/menu/menuWrite.do")
	ModelAndView menuWrite(HttpServletRequest request, MultipartFile menu_img) {
		String filePath = request.getSession().getServletContext().getRealPath("/menu_image");
		String fileName = menu_img.getOriginalFilename();
		
		File file = new File(filePath, fileName);
		try {
			FileCopyUtils.copy(menu_img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MenuDTO dto = new MenuDTO();
		dto.setMenu_num(Integer.parseInt(request.getParameter("menu_num")));
		dto.setMenu_name(request.getParameter("menu_name"));
		dto.setMenu_img(fileName);
		dto.setMenu_price(Integer.parseInt(request.getParameter("menu_price")));
		dto.setMenu_content(request.getParameter("menu_content"));
		dto.setMenu_ingre(request.getParameter("menu_ingre"));
		dto.setMenu_kcal(Integer.parseInt(request.getParameter("menu_kcal")));
		dto.setMenu_category(request.getParameter("menu_category"));
		
		int result = dao.menuWrite(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("menuWrite.jsp");
		
		return modelAndView;
	}

	@RequestMapping("/menu/menuList.do")
	ModelAndView menuList(HttpServletRequest request) {
		String menu_category;
		List<MenuDTO> list;
		int total_content;
		if(request.getParameter("menu_category") != null) {
			menu_category = request.getParameter("menu_category");
			if(menu_category.equals("total")) {
				list = dao.menuList();
				total_content = dao.total_content();
			}else {
				list = dao.menuList(menu_category);
				total_content = dao.category_content(menu_category);
			}
		}else {
			list = dao.menuList();
			total_content = dao.total_content();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("total_content", total_content);
		modelAndView.setViewName("menuList.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/menu/menuDetail.do")
	ModelAndView menuDetail(HttpServletRequest request) {
		int menu_num = Integer.parseInt(request.getParameter("menu_num"));
		String category = request.getParameter("category");
		
		MenuDTO dto = dao.menuDetail(menu_num);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("category", category);
		modelAndView.setViewName("menuDetail.jsp");
		return modelAndView;
	}
}
