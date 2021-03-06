package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageboardDTO;

@Controller
public class ImageboardController {
	@RequestMapping("/imageboard/imageboardWriteForm")
	public String imageboardWriteForm() {
		return "imageboardWriteForm";
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
}
