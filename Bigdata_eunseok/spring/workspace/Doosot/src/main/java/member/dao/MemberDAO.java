package member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;
import order.bean.OrderDTO;
import orderList.dto.OrderListDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int member_join(MemberDTO dto) {
		return sqlSession.insert("mybatis.memberMapper.member_join", dto);
	}
	public MemberDTO member_login(MemberDTO dto) {
		return sqlSession.selectOne("mybatis.memberMapper.member_login",dto);
	}
	public int reloading(MemberDTO dto) {
		return sqlSession.update("mybatis.memberMapper.reloading",dto);
	}
	public int get_deposit(String login_id) {
		return sqlSession.selectOne("mybatis.memberMapper.get_deposit",login_id);
	}
	public int modify_pw(String login_id, String new_pw) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("login_id", login_id);
		map.put("new_pw", new_pw);
		return sqlSession.update("mybatis.memberMapper.modify_pw",map);
	}
	public int total_mem() {
		return sqlSession.selectOne("mybatis.memberMapper.total_mem");
	}
	public List<MemberDTO> memberList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.memberMapper.memberList",map);
	}
	public int member_out(String login_id) {
		return sqlSession.delete("mybatis.memberMapper.member_out",login_id);
	}
	public MemberDTO get_memInfo(String login_id) {
		return sqlSession.selectOne("mybatis.memberMapper.get_memInfo",login_id);
	}
	public int total_order(String login_id) {
		return sqlSession.selectOne("mybatis.memberMapper.total_order",login_id);
	}
	public List<OrderListDTO> orderList(int seq_num) {
		return sqlSession.selectList("mybatis.memberMapper.orderList",seq_num);
	}
	public List<Integer> order_seq(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.memberMapper.order_seq",map);
	}
	
}
