package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookWriteFormAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String req = "book/bookWriteForm.jsp";
		
		request.setAttribute("req", req);
		
		return "index.jsp";
	}
}
