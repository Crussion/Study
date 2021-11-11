package orderController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import order.dao.OrderDAO;

@Controller
public class OrderController {
	@Autowired
	OrderDAO dao;
	

}
