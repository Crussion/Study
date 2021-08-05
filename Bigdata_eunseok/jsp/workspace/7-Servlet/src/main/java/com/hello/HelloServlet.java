package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //
    public void init() throws ServletException{
    	System.out.println("init() 호출");
    	
    }

    // get 형식으로 요청을 받을때 실행
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 호출");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=UTF-8;"); // 응답으로 돌아가는 파일의 종류 설정
		PrintWriter out = response.getWriter();	// 문서 출력 객체, 문자열로 HTML 문서를 출력
		out.print("<html>"
				+ "<head>"
				+ "<title>Servlet</title>"
				+ "</head>"
				+ "<body>"
				+ "<p>Hello Servlet</p>"
				+ "<p>안녕하세요, 서블릿!!</p>"
				+ "</body>"
				+ "</html>");
	}

	// post 형식으로 요청을 받을때 실행
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
