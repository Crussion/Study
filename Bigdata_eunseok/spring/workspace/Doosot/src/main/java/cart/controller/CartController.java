package cart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cart.dao.CartDAO;
import cart.dto.CartDTO;

@Controller
public class CartController {
	@Autowired
	CartDAO dao;
	
	@RequestMapping("/cart/cartList.do")
	ModelAndView cartList() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cartList.jsp");
		
		return modelAndView;
	}
	
	
	@RequestMapping("/menu/add_cart.do")
	ModelAndView add_cart(HttpServletRequest request) {
		int cart_qty = Integer.parseInt(request.getParameter("cart_qty"));
		String mem_id = request.getParameter("mem_id");
		int menu_num = Integer.parseInt(request.getParameter("menu_num"));
		
		int contents = dao.check_contents(mem_id);
		int cart_num;
		CartDTO dto = new CartDTO();
		if(contents == 0) {
			cart_num = dao.create_cart();
		}else {
			cart_num = dao.get_cart(mem_id);
		}
		dto.setCart_num(cart_num);
		dto.setCart_qty(cart_qty);
		dto.setMem_id(mem_id);
		dto.setMenu_num(menu_num);
		
		int result = dao.add_cart(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("menuDetail.jsp");
		
		return modelAndView;
	}
}
