package co.five.mprj.member.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class MemberDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");

		vo.setMemberId(memberId);

		int n = service.memberDelete(vo);

		try {
			if (n != 0) {
			    session.invalidate();
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('회원 탈퇴가 완료되었습니다.');location.href='main.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('회원 탈퇴가 정상적으로 완료되지 않았습니다.');location.href='main.do';");
				out.println("</script>");

				out.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "main/main.tiles";
	}

}
