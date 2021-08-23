package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardDeleteAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pwd = request.getParameter("pwd");
		
		BoardDAO dao = new BoardDAO();
		BoardBean bean = dao.boardDetail(board_num);
		
		int delete = dao.boardDelete(board_num, pwd);
		
		
		request.setAttribute("pg", pg);
		request.setAttribute("board_num", board_num);
		request.setAttribute("delete", delete);
		
		if(delete > 0) {
			return "boardList.do";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("location.href = 'boardDetail.do'");
			out.println("</script>");
		}
		return null;
	}
}
