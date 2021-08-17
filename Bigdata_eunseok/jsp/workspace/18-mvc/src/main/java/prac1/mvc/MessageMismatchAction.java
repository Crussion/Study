package prac1.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageMismatchAction  implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//데이터 처리
		String result = "타입이 일치하지 않습니다.";
		
		//데이터 공유
		request.setAttribute("result", result);
		
		//view 처리 파일 리턴
		return "/exam2/messageView.jsp";
	}
}