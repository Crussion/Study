package member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import order.bean.OrderDTO;
import orderList.dto.OrderListDTO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@RequestMapping(value="*/member_join.do")
	public ModelAndView member_join(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		String mem_name = request.getParameter("mem_name");
		String mem_phone1 = request.getParameter("mem_phone1");
		String mem_phone2 = request.getParameter("mem_phone2");
		String mem_phone3 = request.getParameter("mem_phone3");
		String mem_addr = request.getParameter("mem_addr");
		String mem_email1 = request.getParameter("mem_email1");
		String mem_email2 = request.getParameter("mem_email2");

		MemberDTO dto = new MemberDTO();
		dto.setMem_id(mem_id);
		dto.setMem_pw(mem_pw);
		dto.setMem_name(mem_name);
		dto.setMem_phone1(mem_phone1);
		dto.setMem_phone2(mem_phone2);
		dto.setMem_phone3(mem_phone3);
		dto.setMem_addr(mem_addr);
		dto.setMem_email1(mem_email1);
		dto.setMem_email2(mem_email2);
		
		int result = memberService.member_join(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result == 0) { // 회원가입 실패
			modelAndView.addObject("join_check","1"); // false
		}
		else { // 회원가입 성공
			modelAndView.addObject("join_check","0"); // true
		}
		modelAndView.setViewName("../alert/member_alert_join.jsp");
		return modelAndView;
	}
	@RequestMapping(value="*/member_login.do")
	public ModelAndView member_login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login_id = request.getParameter("login_id");
		String login_pw = request.getParameter("login_pw");
		MemberDTO dto = new MemberDTO();
		dto.setMem_id(login_id);
		dto.setMem_pw(login_pw);
		
		ModelAndView modelAndView = new ModelAndView();
		dto = memberService.member_login(dto);   // 아이디,비번 사용해서 이름,관리자판단,예치금 데이터 가져오기
		if(dto == null) {
			modelAndView.addObject("login_check","1"); // false
		}else {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("login_id",login_id);
			session.setAttribute("login_name",dto.getMem_name());
			session.setAttribute("login_addr",dto.getMem_addr());
			session.setAttribute("admin_num",dto.getAdmin());
			session.setAttribute("mem_deposit",dto.getMem_deposit());
			
			modelAndView.addObject("login_check","0"); // true
		}
		modelAndView.setViewName("../alert/member_alert_login.jsp");
		
		return modelAndView;
	}
	@RequestMapping(value="*/member_logout.do")
	public ModelAndView member_logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		//세션 삭제
		session.removeAttribute("login_Id");
		session.removeAttribute("login_Name");
		session.removeAttribute("admin_num");
		session.removeAttribute("mem_deposit");
		// 무효화 : 모두 지우기
		session.invalidate();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:../main/main.jsp");
		
		return modelAndView;
	}
	@RequestMapping(value="*/reload_deposit.do")
	public ModelAndView reload_deposit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login_id = request.getParameter("login_id");
		int deposit = Integer.parseInt(request.getParameter("reload_deposit"));
		MemberDTO dto = new MemberDTO();
		dto.setMem_id(login_id);
		dto.setMem_deposit(deposit);
		
		int result = memberService.reloading(dto);
		ModelAndView modelAndView = new ModelAndView();

		if(result == 0) { // 충전 실패
			modelAndView.addObject("reload_check","1"); // false
		}
		else { // 충전 성공
			deposit = memberService.get_deposit(dto.getMem_id()); // 업데이트된 예치금 가져오기
			HttpSession session = request.getSession();
			session.setAttribute("mem_deposit",deposit); // 세션에 다시 저장
			modelAndView.addObject("reload_check","0"); // true
		}
		modelAndView.setViewName("../alert/member_alert_reload.jsp");
		return modelAndView;
	}
	@RequestMapping(value="*/modify_pw.do")
	public ModelAndView modify_pw(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login_id = request.getParameter("login_id");
		String old_pw = request.getParameter("old_pw");
		String new_pw = request.getParameter("new_pw");
		
		MemberDTO dto = new MemberDTO();
		dto.setMem_id(login_id);
		dto.setMem_pw(old_pw);
		dto = memberService.member_login(dto); // 로그인된 아이디와 비번으로 일치하는 이름가져오기, not null 이면 회원확인된것
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(dto == null) {
			modelAndView.addObject("modify_check","1"); // 회원정보 불일치 false
		}
		else {
			int result = memberService.modify_pw(login_id, new_pw);
			if(result == 0) {
				modelAndView.addObject("modify_check","2"); // 수정실패 false
			}
			else {
				modelAndView.addObject("modify_check","0"); // true
			}
		}
		modelAndView.setViewName("../alert/member_alert_mpw.jsp");
		return modelAndView;
		
	}
	@RequestMapping(value="*/member_manage.do")
	public ModelAndView member_manage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pg = 1;
		if(request.getParameter("pg")!= null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		};
		
		int total_mem = memberService.total_mem();
		int total_page = (total_mem + 4)/5;
		if(pg > total_page) {
			pg = total_page;
		}
		
		int start_page = (pg-1)/3*3+1;
		int end_page = start_page+2;
		if(end_page > total_page) {
			end_page = total_page;
		}
		
		int endNum = pg*5;
		int startNum = endNum-4;
		
		List<MemberDTO> list = memberService.memberList(startNum, endNum);
		ModelAndView modelAndView = null;
		if(list != null) {
			modelAndView = new ModelAndView();
			HttpSession session = request.getSession();
			modelAndView.addObject("login_id", session.getAttribute("login_id"));
			modelAndView.addObject("total_page", total_page);
			modelAndView.addObject("start_page", start_page);
			modelAndView.addObject("end_page", end_page);
			modelAndView.addObject("list", list);
			modelAndView.addObject("pg", pg);
			
			modelAndView.setViewName("../member/member_manage.jsp");
			
			return modelAndView;
		}
		return null;
	}
	@RequestMapping(value="*/member_out.do")
	public ModelAndView member_out(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login_id = request.getParameter("login_id");
		String pw = request.getParameter("pw");
		
		MemberDTO dto = new MemberDTO();
		dto.setMem_id(login_id);
		dto.setMem_pw(pw);
		ModelAndView modelAndView = new ModelAndView();
		
		dto = memberService.member_login(dto); // 비밀번호 일치 확인
		if(dto == null) {
			modelAndView.addObject("out_check","1"); // false 비밀번호 불일치
		}else {
			int result = memberService.member_out(login_id);
			if(result == 0) {
				modelAndView.addObject("out_check","2"); // false 탈퇴실패
			}else {
				HttpSession session = request.getSession();
				//세션 삭제
				session.removeAttribute("login_Id");
				session.removeAttribute("login_Name");
				session.removeAttribute("admin_num");
				session.removeAttribute("mem_deposit");
				// 무효화 : 모두 지우기
				session.invalidate();
				modelAndView.addObject("out_check","0"); // true
			}
		}
		modelAndView.setViewName("../alert/member_alert_out.jsp");
		return modelAndView;
	}
	@RequestMapping(value="*/menu_order_page.do")
	public ModelAndView menu_order_page(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login_id = session.getAttribute("login_id").toString();
		
		MemberDTO dto = memberService.get_memInfo(login_id);
		ModelAndView modelAndView = new ModelAndView();
		
		if(dto == null) {
			modelAndView.addObject("order_page_check","1"); // false 정보찾기 실패
		}else {
			modelAndView.addObject("order_page_check","0"); // true
			
			modelAndView.addObject("mem_name",dto.getMem_name());
			modelAndView.addObject("mem_addr",dto.getMem_addr());
		}
		modelAndView.setViewName("../alert/menu_order_alert_page.jsp");
		return modelAndView;
	}
	@RequestMapping(value="*/check_id.do")
	public ModelAndView check_id(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String check_id = request.getParameter("check_id");
		
		MemberDTO dto = memberService.get_memInfo(check_id);
		ModelAndView modelAndView = new ModelAndView();
		if(dto != null) {
			modelAndView.addObject("checked","1"); // 중복된 아이디 있음
		}else {
			modelAndView.addObject("checked","0"); // 중복된 아이디 없음
			modelAndView.addObject("id",check_id);
		}
		modelAndView.setViewName("../alert/member_alert_checkId.jsp");
		return modelAndView;
	}
	@RequestMapping(value="*/member_orderList.do")
	public ModelAndView member_orderList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login_id = request.getSession().getAttribute("login_id").toString();
		int pg = 1;
		if(request.getParameter("pg")!= null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		};
		
		int total_mem = memberService.total_order(login_id);
		int total_page = (total_mem + 4)/5;
		if(pg > total_page) {
			pg = total_page;
		}
		
		int start_page = (pg-1)/3*3+1;
		int end_page = start_page+2;
		if(end_page > total_page) {
			end_page = total_page;
		}
		
		int endNum = pg*5;
		int startNum = endNum-4;
		
		List<Integer> seq = memberService.order_seq(startNum, endNum); // 6,7,8,9,10
		ModelAndView modelAndView = null;
		if(seq != null) {
			List<OrderListDTO> list = new ArrayList<OrderListDTO>(); // seq,name,date 첫번째줄만
			List<Integer> cnt = new ArrayList<Integer>(); // 같은 seq 갯수
			for(int seq_num=0; seq_num<seq.size(); seq_num++) { // 0~5
				List<OrderListDTO> orderList = memberService.orderList(seq.get(seq_num));
				list.add(orderList.get(0));
				cnt.add(orderList.size());
			}
			modelAndView = new ModelAndView();
			modelAndView.addObject("total_page", total_page);
			modelAndView.addObject("start_page", start_page);
			modelAndView.addObject("end_page", end_page);
			modelAndView.addObject("list", list);
			modelAndView.addObject("cnt", cnt);
			modelAndView.addObject("pg", pg);
		}
		modelAndView.setViewName("../member/member_orderList.jsp");

		return modelAndView;
	}
}














