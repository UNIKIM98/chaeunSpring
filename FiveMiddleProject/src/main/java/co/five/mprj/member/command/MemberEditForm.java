package co.five.mprj.member.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class MemberEditForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원 정보 수정을 위해 데이터 호출 후 수정폼에 전달
		
		HttpSession session = request.getSession();
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		String memberId = (String) session.getAttribute("memberId");
		
		vo = service.memberSelectShow(memberId);
		
		request.setAttribute("member", vo);
		
		
		System.out.println(vo);
		
		return "member/memberEditNew2.tiles";
	}

}
