package co.five.mprj.member.map;

import java.util.List;

import co.five.mprj.member.service.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList(); //전체 조회
	MemberVO memberSelect(MemberVO vo); //한 사람 조회, 로그인
	int memberInsert(MemberVO vo); //입력
	int memberDelete(MemberVO vo); //삭제
	int memberUpdate(MemberVO vo); //수정
	MemberVO memberSelectShow(String memberId); // 한 회원 조회, 마이페이지
	
	boolean isIdCheck(String id); //아이디 중복확인 (아이디 존재하면 0, 존재하지않으면 1)
	boolean isNickname(String nickname); // 닉네임 중복확인 (닉네임 존재하면 0, 존재하지않으면 1)
}
