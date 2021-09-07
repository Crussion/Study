package member.controller;

import java.util.List;

import member.bean.MemberDTO;

public interface MemberService {
	public int memberWrite(MemberDTO dto);
	public String login(String id, String pwd);
	// 아이디 유무 검사
	public boolean isExistId(String id);
	// 회원정보 보기
	public MemberDTO memberView(String id);
	// 회원정보 수정
	public int memberModify(MemberDTO dto);
	// 총 회원수 구하기
	public int getTotalMember();
	public List<MemberDTO> memberList(int startNum, int endNum);
}
