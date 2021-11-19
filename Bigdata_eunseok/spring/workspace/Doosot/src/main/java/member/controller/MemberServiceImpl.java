package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import order.bean.OrderDTO;
import orderList.dto.OrderListDTO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public int member_join(MemberDTO dto) {
		return memberDAO.member_join(dto);
	}
	@Override
	public MemberDTO member_login(MemberDTO dto) {
		return memberDAO.member_login(dto);
	}
	@Override
	public int reloading(MemberDTO dto) {
		return memberDAO.reloading(dto);
	}
	@Override
	public int get_deposit(String login_id) {
		return memberDAO.get_deposit(login_id);
	}
	@Override
	public int modify_pw(String login_id, String new_pw) {
		return memberDAO.modify_pw(login_id, new_pw);
	}
	@Override
	public int total_mem() {
		return memberDAO.total_mem();
	}
	@Override
	public List<MemberDTO> memberList(int startNum, int endNum) {
		return memberDAO.memberList(startNum, endNum);
	}
	@Override
	public int member_out(String login_id) {
		return memberDAO.member_out(login_id);
	}
	@Override
	public MemberDTO get_memInfo(String login_id) {
		return memberDAO.get_memInfo(login_id);
	}
	@Override
	public int total_order(String login_id) {
		return memberDAO.total_order(login_id);
	}
	@Override
	public List<OrderListDTO> orderList(int seq_num) {
		return memberDAO.orderList(seq_num);
	}
	/*
	@Override
	public OrderListDTO orderList(int startNum, int endNum) {
		return memberDAO.orderList(startNum, endNum).get(0);
	}
	*/
	@Override
	public List<Integer> order_seq(int startNum, int endNum) {
		return memberDAO.order_seq(startNum, endNum);
	}



}
