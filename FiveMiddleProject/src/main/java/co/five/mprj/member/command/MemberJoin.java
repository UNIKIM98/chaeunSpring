package co.five.mprj.member.command;

import java.io.IOException;
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

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		String password = request.getParameter("memberPassword");
		
		//패스워드 암복화
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
		
		int n = 0;
				
		String domainId = request.getParameter("memberId");
		
		vo.setMemberId(domainId);
		
		vo.setMemberName(request.getParameter("memberName"));
		
		vo.setMemberNickname(request.getParameter("memberNickname"));
		
		vo.setMemberPassword(password);
			
		if(request.getParameter("memberPhone") != "") {
			vo.setMemberPhone(request.getParameter("memberPhone"));
		}
		if(request.getParameter("memberBirth") != "") {
			vo.setMemberBirth(request.getParameter("memberBirth"));
		}
		if(request.getParameter("memberGender") != "") {
			vo.setMemberGender(request.getParameter("memberGender"));
		}
		vo.setMemberRole("USER");
		
		n= dao.memberInsert(vo);
		
		try {
			if (n > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('회원가입이 완료되었습니다.');location.href='main.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('회원가입이 실패하였습니다.');location.href='main.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "main/main.tiles";
	}

}
