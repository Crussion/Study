package member.controller;

import java.util.List;

import member.bean.MemberDTO;
import order.bean.OrderDTO;
import orderList.dto.OrderListDTO;

public interface MemberService {
	// 회원가입
	public int member_join(MemberDTO dto);
	// 로그인
	public MemberDTO member_login(MemberDTO dto);
	// 예치금충전하기
	public int reloading(MemberDTO dto);
	// 충전된 예치금 가져오기
	public int get_deposit(String login_id);
	// 비밀번호 수정
	public int modify_pw(String login_id, String new_pw);
	// 회원 총인원수 가져오기
	public int total_mem();
	// 회원 리스트 가져오기
	public List<MemberDTO> memberList(int startNum, int endNum);
	// 회원 탈퇴
	public int member_out(String login_id);
	// 회원정보 가져오기
	public MemberDTO get_memInfo(String login_id);
	// 회원 주문내역 총 갯수 가져오기
	public int total_order(String login_id);
	// 회원 리스트 가져오기
	public List<OrderListDTO> orderList(int seq_num);
	// 주문 번호 기준 5개씩 리스트 가져오기
	public List<Integer> order_seq(int startNum, int endNum);
	/*
	// 회원 리스트 가져오기
	public OrderListDTO orderList(int startNum, int endNum);
	*/
}
