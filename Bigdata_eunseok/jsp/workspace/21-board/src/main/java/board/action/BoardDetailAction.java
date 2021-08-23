package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardDetailAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pg = 1;
		int modify = -1;
		boolean reply = false;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		if(request.getAttribute("modify") != null) {
			modify = Integer.parseInt(request.getAttribute("modify").toString());
			request.setAttribute("modify", modify);
		}
		
		BoardDAO dao = new BoardDAO();
		BoardBean bean = null;
		if(request.getAttribute("bean") == null) {
			bean = dao.boardDetail(board_num);
		}else {
			bean = (BoardBean)request.getAttribute("bean");
			reply = true;
		}
		int result = 0;
		if(modify == -1) {
			if(reply) {
				System.out.println("답글 작성 성공");
			}else {
				result = dao.read_count(board_num);
				if(result > 0) {
					System.out.println("조회수 증가 성공");
				}else {
					System.out.println("조회수 증가 실패");
				}
			}
		}
		else if(modify == 0) {
			System.out.println("내용 수정 실패");
		}else if(modify > 0){
			System.out.println("내용 수정 성공");
		}
		request.setAttribute("pg", pg);
		request.setAttribute("bean", bean);
		
		return "board/boardView.jsp";
	}
}