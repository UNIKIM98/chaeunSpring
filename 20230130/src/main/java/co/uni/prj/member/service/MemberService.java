package co.uni.prj.member.service;

import java.util.List;

import co.uni.prj.member.vo.MemberVO;

public interface MemberService {

	// 전체조회
	List<MemberVO> memberListSelect();

	// 단건조회, 로그인
	MemberVO memberSelect(MemberVO vo);

	// 추가
	int memberInsert(MemberVO vo);

	// 수정
	int memberUpdate(MemberVO vo);

	// 삭제
	int memberDelete(MemberVO vo);

	// 아이디 중복 체크
	boolean isIdCheck(String id);
}
