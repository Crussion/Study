package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;
	@Override
	public int memberWrite(MemberDTO dto) {
		return dao.memberWrite(dto);
	}

	@Override
	public String login(String id, String pwd) {
		return dao.login(id, pwd);
	}

	@Override
	public boolean isExistId(String id) {
		return dao.isExistId(id);
	}

	@Override
	public MemberDTO memberView(String id) {
		return dao.memberView(id);
	}

	@Override
	public int memberModify(MemberDTO dto) {
		return dao.memberModify(dto);
	}

	@Override
	public int getTotalMember() {
		return dao.getTotalMember();
	}

	@Override
	public List<MemberDTO> memberList(int startNum, int endNum) {
		return dao.memberList(startNum, endNum);
	}

}
