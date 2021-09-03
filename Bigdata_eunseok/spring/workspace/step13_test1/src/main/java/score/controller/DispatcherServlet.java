package score.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HandlerMapping handlerMapping;
	ViewResolver viewResolver;
	
	public DispatcherServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청 정보 추출
		// url : http://localhost:8080/step11/board/boardList.do?pg=1
		// uri : step11/board/boardList.do
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		// path : /boardList.do
		System.out.println(path);

		// 2. 데이터 처리 코드 선택
		Controller controller = handlerMapping.getController(path);

		String viewName = controller.handleRequest(request, response);

		String viewPage = null;
		if (viewName != null)
			viewPage = viewResolver.getView(viewName);

		// 3. view 처리 파일로 화면 이동
		if (viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
