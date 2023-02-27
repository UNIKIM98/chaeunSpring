package co.five.mprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복체크
		MemberService dao = new MemberServiceImpl();
		String id = request.getParameter("domainId");
		String result = "1"; //존재하지 않으면 1
		boolean bool = dao.isIdCheck(id);

		if(!bool) {
			result = "0";  //존재하면 0
		}
		
		return "Ajax:"+result;
	}

}
