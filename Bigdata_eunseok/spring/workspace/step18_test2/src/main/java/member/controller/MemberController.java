package member.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	@RequestMapping("/member/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		// 데이터 읽기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// DB
		String name = service.login(id, pwd);
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		// 페이지 이동
		if (name != null) { // 로그인 성공
			// 공유데이터를 세션에 저장하고 페이지 이동
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);

			modelAndView.setViewName("redirect:loginOk.jsp");

			/*
			 * // 1) 페이지 이동시 데이터 전송을 get방식으로 전송하면 // 주소창에 표시되기 때문에 보안에 취약하다. // 그래서, 보안에 관련된
			 * 데이터를 다른 페이지로 전송할 때는 쿠키 또는 세션을 이용한다. // 2) get방식으로 문자열을 전송할 때는 utf-8로 전송되기 때문에
			 * // 한글은 반드시 utf-8 엔코딩 설정을 해야함 response.sendRedirect("loginOk.jsp?name=" +
			 * URLEncoder.encode(name, "utf-8") + "&id=" + id);
			 */
		} else { // 로그인 실패
			modelAndView.setViewName("redirect:loginFail.jsp");
		}

		return modelAndView;
	}

	@RequestMapping("/member/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginForm.jsp");
		return modelAndView;
	}

	@RequestMapping("/member/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 세션 삭제
		session.removeAttribute("memName");
		session.removeAttribute("memId");

		// 무효화 : 모두 지우기
		session.invalidate();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("logout.jsp");

		return modelAndView;
	}

	@RequestMapping("/member/memberList.do")
	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response) {
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 목록 보기 : 5개씩 목록 출력
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<MemberDTO> list = service.memberList(startNum, endNum);

		// 페이징 처리 : 숫자를 3블럭으로 표시
		int totalA = service.getTotalMember(); // 총회원수
		int totalP = (totalA + 4) / 5; // 총 페이주

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("memberList.jsp");

		return modelAndView;
	}

	@RequestMapping("/member/memberModify.do")
	public ModelAndView memberModify(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");

		// DTO에 저장
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setGender(gender);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		dto.setTel1(tel1);
		dto.setTel2(tel2);
		dto.setTel3(tel3);
		dto.setAddr(addr);

		// DB
		int su = service.memberModify(dto);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("modify.jsp");

		return modelAndView;
	}

	@RequestMapping("/member/memberModifyForm.do")
	public ModelAndView memberModifyForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 데이터
		String id = (String) session.getAttribute("memId");

		// 회원정보 불러오기
		MemberDTO dto = service.memberView(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("modifyForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/member/memberWrite.do")
	public ModelAndView memberWrite(HttpServletRequest request, HttpServletResponse response) {
		// 데이터 읽기
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		
		// DTO에 저장
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setGender(gender);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		dto.setTel1(tel1);
		dto.setTel2(tel2);
		dto.setTel3(tel3);
		dto.setAddr(addr);
		
		// DB
		int su = service.memberWrite(dto);
		String result = "";
		if(su>0) {
			result = "회원 가입 성공";
		} else {
			result = "회원 가입 실패";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("write.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/member/memberWriteForm.do")
	public ModelAndView memberWriteForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("writeForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/member/checkId.do")
	public ModelAndView checkId(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");

		// DB
		boolean exist = service.isExistId(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exist", exist);
		modelAndView.addObject("id", id);
		modelAndView.setViewName("checkId.jsp");
		
		return modelAndView;
	}
}
