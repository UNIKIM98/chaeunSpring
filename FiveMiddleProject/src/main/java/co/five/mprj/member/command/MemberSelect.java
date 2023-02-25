package co.five.mprj.member.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		
		vo.setMemberId(request.getParameter("memberId"));
		vo = service.memberSelectShow("memberId");
		request.setAttribute("member", vo);

		System.out.println("====" + vo);
		
		return "member/memberEditForm.tiles";
	}

}
