package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyFormAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDAO dao = new BoardDAO();
		BoardBean bean = dao.boardDetail(board_num);
		
		request.setAttribute("pg", pg);
		request.setAttribute("board_num", board_num);
		request.setAttribute("bean", bean);
		
		return "board/boardModifyForm.jsp";
	}
}