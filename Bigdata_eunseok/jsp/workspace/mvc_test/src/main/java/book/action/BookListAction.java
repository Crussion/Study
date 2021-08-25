package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.bean.BookBean;
import book.dao.BookDAO;

public class BookListAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String req = "book/bookList.jsp";
		
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		int endNum = pg * 10;
		int startNum = endNum - 9;
		
		BookDAO dao = new BookDAO();
		List<BookBean> list = dao.bookList(startNum, endNum);
		
		int total_content = dao.getTotal();
		int total_page = (total_content + 9) / 10;
		
		int startPage = (pg - 1) / 5 * 5 + 1;
		int endPage = startPage + 4;
		if(endPage>total_page) endPage = total_page;
		
		request.setAttribute("req", req);
		request.setAttribute("list", list);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("total_page", total_page);
		
		return "index.jsp";
	}
}
