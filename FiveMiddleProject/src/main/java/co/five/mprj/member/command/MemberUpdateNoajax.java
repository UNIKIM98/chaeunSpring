package co.five.mprj.member.command;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.AES256Util;
import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class MemberUpdateNoajax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("업데이트 페이지 도착");
		MemberVO vo = new MemberVO();

		MemberService service = new MemberServiceImpl();

		String password = request.getParameter("memberPassword");
		String newPassword = request.getParameter("newPassword");
		
		vo.setMemberId(request.getParameter("memberId"));
		
		vo.setMemberNickname(request.getParameter("newNickname"));
		
		if(newPassword != "") {
			try {
				AES256Util aes = new AES256Util();
				try {
					newPassword = aes.encrypt(newPassword);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (GeneralSecurityException e) {
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			vo.setMemberPassword(newPassword);
			
		}else {
			vo.setMemberPassword(password);
		}
		
		System.out.println("vo값▶ " + vo);

		int n = service.memberUpdate(vo);
		
		try {
		if(n != 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<script language='javascript'>");
			out.println("alert('회원정보가 수정되었습니다.');location.href='memberEditForm.do';");
			out.println("</script>");

			out.flush();

		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<script language='javascript'>");
			out.println("alert('회원정보 수정에 실패했습니다.');location.href='memberEditForm.do';");
			out.println("</script>");

			out.flush();
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
		
		
		return "member/memberEditNew.tiles";
	}

}
