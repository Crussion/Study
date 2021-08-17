package exam2.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageHostAction  implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//데이터 처리
		String result = "고길동 입니다.";
		
		//데이터 공유
		request.setAttribute("result", result);
		
		//view 처리 파일 리턴
		return "/messageView.jsp";
	}
}