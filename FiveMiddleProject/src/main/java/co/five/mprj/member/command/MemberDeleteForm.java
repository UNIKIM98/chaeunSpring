package co.five.mprj.member.command;

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

public class MemberDeleteForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원 정보 삭제를 위해 데이터 호출 후 수정폼에 전달

		HttpSession session = request.getSession();
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		String memberId = (String) session.getAttribute("memberId");

		vo = service.memberSelectShow(memberId);
		
		String password = vo.getMemberPassword();
		
		System.out.println(password);

		
		try {
		AES256Util aes = new AES256Util();
		try {
			password = aes.decrypt(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}  catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	
	vo.setMemberPassword(password);
		
		request.setAttribute("member", vo);

		System.out.println(vo);

		return "member/memberDeleteForm.tiles";
	}

}
