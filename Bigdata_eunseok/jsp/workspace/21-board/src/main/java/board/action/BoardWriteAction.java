package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardWriteAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String realFolder = request.getServletContext().getRealPath("/boardUpload");
		
		// 브라우저에서 보내온 문자열과 파일 데이터는 cos.jar에 있는 MultipartRequest 사용
		// new DefaultFileRenamePolicy() : 업로드시, 똑같은 파일이름이 있을 경우 기존 파일이름에 숫자를 덧붙여 저장.
		MultipartRequest multi = new MultipartRequest(request, realFolder,
										5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		String board_name = multi.getParameter("board_name");
		String board_pwd = multi.getParameter("board_pwd");
		String board_subject = multi.getParameter("board_subject");
		String board_content = multi.getParameter("board_content");
		//서버의 boardUpload 폴더에 저장된 파일 이름
		String board_file = multi.getFilesystemName("board_file");
		
		BoardBean bean = new BoardBean();
		
		bean.setBoard_name(board_name);
		bean.setBoard_pwd(board_pwd);
		bean.setBoard_subject(board_subject);
		bean.setBoard_content(board_content);
		bean.setBoard_file(board_file);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.boardWrite(bean);
		
		request.setAttribute("result", result);
		
		return "index.jsp?req=boardList&pg=1";
	}
}
