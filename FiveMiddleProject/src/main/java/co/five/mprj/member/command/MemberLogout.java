package co.five.mprj.member.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.five.mprj.common.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		HttpSession session = request.getSession();
		session.invalidate();
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<script language='javascript'>");
			out.println("alert('로그아웃 되었습니다.');location.href='main.do';");
			out.println("</script>");

			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "main/main.tiles";
	}

}
