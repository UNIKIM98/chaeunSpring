package co.five.mprj.member.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.five.mprj.common.AES256Util;
import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인
		System.out.println("로그인 호출");
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		HttpSession session = request.getSession();

		String password = request.getParameter("memberPassword");
		try {
			AES256Util aes = new AES256Util();
			try {
				password = aes.encrypt(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println(password);
		System.out.println(request.getParameter("memberId"));
		System.out.println(vo);

		vo.setMemberId(request.getParameter("memberId"));

		vo.setMemberPassword(password);

		vo = dao.memberSelect(vo);
		try {
			if (vo != null) {
				// 세션으로 계속 가지고 갈 정보들
				session.setAttribute("memberId", vo.getMemberId());
				session.setAttribute("memberRole", vo.getMemberRole());

				// 추가 (정은)
				session.setAttribute("memberName", vo.getMemberName());
				session.setAttribute("memberNickname", vo.getMemberNickname());
				System.out.println("▼ vo에 담긴 닉네임");
				System.out.println(vo.getMemberNickname());
				System.out.println("▼ session에 담긴 닉네임");
				System.out.println(session.getAttribute("memberNickname"));

				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('" + vo.getMemberNickname() + "님, 안녕하세요 :D');location.href='main.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('아이디 또는 비밀번호를 다시 확인해주세요.');location.href='memberLoginForm.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "admin/adminProductList.tiles";
	}
}
