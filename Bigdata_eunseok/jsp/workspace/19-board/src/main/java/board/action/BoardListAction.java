package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardListAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		
		BoardDAO dao = new BoardDAO();
		
		int endNum = pg * 10;
		int startNum = endNum - 9;
		
		int total_content = dao.total_content();
		int total_page = (total_content + 9) / 10;
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage>total_page) endPage = total_page;
		
		List<BoardBean> list = dao.boardList(startNum, endNum);
		
		request.setAttribute("list", list);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("total_page", total_page);
		
		return "board/boardList.jsp";
	}
}
