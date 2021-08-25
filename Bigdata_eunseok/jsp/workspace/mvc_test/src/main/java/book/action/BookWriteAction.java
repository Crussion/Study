package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.bean.BookBean;
import book.dao.BookDAO;

public class BookWriteAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String req = "book/book.jsp";
		
		request.setCharacterEncoding("utf-8");
		BookBean bean = new BookBean();
		bean.setBook_num(Integer.parseInt(request.getParameter("book_num")));
		bean.setBook_subject(request.getParameter("book_subject"));
		bean.setBook_writer(request.getParameter("book_writer"));
		bean.setBook_publisher(request.getParameter("book_publisher"));
		if(!request.getParameter("book_price").equals(""))
			bean.setBook_price(Integer.parseInt(request.getParameter("book_price")));
		else
			bean.setBook_price(0);
		String date1, date2, date3;
		if(!request.getParameter("book_date1").equals(""))
			date1 = request.getParameter("book_date1");
		else
			date1 = "1";
		if(!request.getParameter("book_date2").equals(""))
			date2 = request.getParameter("book_date2");
		else
			date2 = "1";
		if(!request.getParameter("book_date3").equals(""))
			date3 = request.getParameter("book_date3");
		else
			date3 = "1";
		String date = date1 + "/" + date2 + "/" + date3;
		bean.setBook_date(date);
		
		BookDAO dao = new BookDAO();
		int result = dao.bookWrite(bean);
		
		int pg = 1;
		
		request.setAttribute("req", req);
		request.setAttribute("result", result);
		request.setAttribute("bean", bean);
		
		return "index.jsp";
	}
}
