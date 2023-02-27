package co.five.mprj.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class AjaxAdminDel implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		String memberId = request.getParameter("memberId");
		System.out.println("(AjaxAdminDel)삭제할 아이디 ▶ " + memberId);

		vo.setMemberId(memberId);

		int delCnt = service.memberDelete(vo);
		String json = null;

		if (delCnt > 0) {
			json = "{\"retCode\":\"Success\",\"memberId\":\"" + memberId + "\"}";
			System.out.println(json);
		} else {
			json = "{\"retCode\":\"Fail\",\"memberId\":\"" + memberId + "\"}";
		}

		return "Ajax:" + json;
	}

}
