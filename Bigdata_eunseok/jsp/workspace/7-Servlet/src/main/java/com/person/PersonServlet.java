package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String subject = request.getParameter("subject");
		
		response.setContentType("text/html; charset=UTF-8"); // 응답으로 돌아가는 파일의 종류 설정
		PrintWriter out = response.getWriter();	// 문서 출력 객체, 문자열로 HTML 문서를 출력
		out.printf("<html>"
				 + "<head>"
				 + "<title>PersonServlet</title>"
				 + "</head>"
				 + "<body>"
				 + "<p>당신의 이름은 %s입니다.</p>"
				 + "<p>당신의 성별은 %s입니다.</p>"
				 + "<p>당신의 취미는"
				 , name, gender);
		for(int i = 0; i < hobby.length; i++)
			out.print(" " + hobby[i]);
		out.printf("입니다.</p>"
				 + "<p>당신이 좋아하는 색깔은 %s입니다.</p>"
				 + "<p>당신이 듣는 과목은 %s입니다.</p>"
				 + "</body>"
				 + "</html>"
				 , color, subject);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
