package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pwd = request.getParameter("pwd");
		String modify_content = request.getParameter("modify_content");
		
		BoardDAO dao = new BoardDAO();
		int modify = dao.boardModify(board_num, pwd, modify_content);
		
		request.setAttribute("pg", pg);
		request.setAttribute("board_num", board_num);
		request.setAttribute("modify", modify);
		
		return "boardDetail.do";
	}
}