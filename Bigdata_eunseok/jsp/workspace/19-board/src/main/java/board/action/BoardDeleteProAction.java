package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteProAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pwd = request.getParameter("pwd");

		BoardDAO dao = new BoardDAO();
		int delete = dao.boardDelete(board_num, pwd);
		
		request.setAttribute("board_num", board_num);
		request.setAttribute("delete", delete);
		request.setAttribute("pg", pg);
		
		if(delete > 0) {
			System.out.println("삭제 성공");
			return "/boardList.do";
		}else {
			System.out.println("삭제 실패");
			return "/boardDetail.do";
		}
	}
}