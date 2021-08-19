package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardDeleteProAction;
import board.action.BoardListAction;
import board.action.BoardWriteProAction;
import board.action.FileDownAction;
import board.action.BoardModifyAction;
import board.action.BoardModifyFormAction;
import board.action.BoardReplyFormAction;
import board.action.BoardReplyProAction;
import board.action.BoardDetailAction;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getServletPath();
		System.out.println(command);
		String view = null;
		Action action = null;
		
		
		try {
			if(command.equals("/boardWriteForm.do")) {
				view = "board/boardWriteForm.jsp";
			}else if(command.equals("/boardList.do")){
				action = new BoardListAction();
			}else if(command.equals("/boardWritePro.do")) {
				action = new BoardWriteProAction();
			}else if(command.equals("/boardDetail.do")) {
				action = new BoardDetailAction();
			}else if(command.equals("/boardDelete.do")) {
				action = new BoardDeleteProAction();
			}else if(command.equals("/boardModifyForm.do")) {
				action = new BoardModifyFormAction();
			}else if(command.equals("/boardModifyPro.do")) {
				action = new BoardModifyAction();
			}else if(command.equals("/fileDown.do")) {
				action = new FileDownAction();
			}else if(command.equals("/boardReplyForm.do")) {
				action = new BoardReplyFormAction();
			}else if(command.equals("/boardReplyPro.do")) {
				action = new BoardReplyProAction();
			}
			
			if(action != null) {
				view = action.process(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
