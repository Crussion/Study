package imageboard.controller;

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

import imageboard.DAO.ImageboardDAO;
import imageboard.bean.ImageboardDTO;

@Controller
public class ImageboardController {
	@Autowired
	ImageboardDAO dao;
	
	@RequestMapping("/imageboard/imageboardWriteForm")
	public ModelAndView imageboardWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("imageboardWriteForm");
		return modelAndView;
	}
	
	// 변수명은 반드시 <input type="file" name="image1">의 name속성 이름과 같아야 한다.
	@RequestMapping("/imageboard/imageboardWrite")
	public ModelAndView imageboardWrite(HttpServletRequest request, MultipartFile image1) {
		String filePath = request.getSession().getServletContext().getRealPath("/storage");
		String fileName = image1.getOriginalFilename();
		
		File file = new File(filePath, fileName);
		try {
			FileCopyUtils.copy(image1.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageboardDTO dto = new ImageboardDTO();
		dto.setImageId(request.getParameter("imageId"));
		dto.setImageName(request.getParameter("imageName"));
		dto.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));
		dto.setImageQty(Integer.parseInt(request.getParameter("imageQty")));
		dto.setImageContent(request.getParameter("imageContent"));
		dto.setImage1(fileName);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("imageboardWrite");
		
		return modelAndView;
	}
	
	@RequestMapping("/imageboard/imageboardList")
	public ModelAndView imageboardWrite(HttpServletRequest request) {
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<ImageboardDTO> list = dao.imageboardList(startNum, endNum);
		
		int total_content = dao.total_content();
		int total_page = (total_content + 4) / 5;

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > total_page)
			endPage = total_page;

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", total_page);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardList");
		
		return modelAndView;
	}
	
	@RequestMapping("/imageboard/imageboardView")
	public ModelAndView imageboardView(HttpServletRequest request) {
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		ImageboardDTO dto = dao.imageboardView(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("imageboardView");
		
		return modelAndView;
	}
}
