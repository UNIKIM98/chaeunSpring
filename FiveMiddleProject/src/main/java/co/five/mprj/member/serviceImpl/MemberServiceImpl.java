package co.five.mprj.member.serviceImpl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import co.five.mprj.common.DataSource;
import co.five.mprj.member.map.MemberMapper;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	
SqlSession sqlSession = DataSource.getInstance().openSession(true); //데이터 베이스 연결
MemberMapper map = sqlSession.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		return map.isIdCheck(id);
	}

	@Override
	public boolean isNickname(String nickname) {
		return map.isNickname(nickname);
	}

	@Override
	public MemberVO memberSelectShow(String memberId) {
		return map.memberSelectShow(memberId);
	}

}
